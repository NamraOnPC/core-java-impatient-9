/**
 * 
 */
package jac444.wk3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author Namra Rupesh Fanse
 *
 */
public class WeatherReporter {
	private Thread runningThread;
	/**
	 * reference to a WeatherQueue object
	 */
	private WeatherQueue queue;
	/**
	 * specifies file containing all the weather readings to be reported
	 */
	public File file;
	/**
	 * reference to a logging object
	 */
	private Logger LOGGER = Logger.getLogger(WeatherReporter.class.getName());

	/**
	 * constructor that initializes the objects 
	 */
	public WeatherReporter(String filename, WeatherQueue queue) {

		file = new File(filename);

		this.queue = queue;

		System.setProperty("java.util.logging.config.file", "E:\\Eclipse Projects\\JAC444WK3\\src\\jac444\\wk3");

		//LogManager.getLogManager().reset();
		LOGGER.setLevel(Level.ALL);

	}

	/**
	 * creates a handler for logging object so the logs can be sent to a file on the disk.
	 * opens an input file and reads the lines and makes a WeatherRading object from each row read.
	 * inserts WeatherReading object into WeatherQueue object
	 * Logs the outcomes accordingly
	 */
	public void reportReadings() {
		if (getRunningThread() != null) {
			return; // In case this method is invoked twice before the initial thread joins.
		}
		runningThread = new Thread() {
			@Override
			public void run() {
				try {
					FileHandler fh = new FileHandler("weatherreporter.log" , true);
					LOGGER.addHandler(fh);
					fh.setLevel(Level.FINEST);
					LOGGER.log(Level.FINEST, "working!!");

				} catch(IOException ex) {
					LOGGER.log(Level.SEVERE, "File logger not working." , ex);	
				}
				BufferedReader input = null;
				try {
					input = new BufferedReader(new BufferedReader(new FileReader(file)));
					String line;
					while((line = input.readLine()) != null) {
						try {
							String[] details = line.split(",");
							SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
							Date parsedDate = dateformat.parse(details[0]);
							Timestamp time = new Timestamp(parsedDate.getTime());
							int temperature = Integer.parseInt(details[1]);
							String location = details[2];
							WeatherReading wr = new WeatherReading(time , temperature , location);
							try {
								queue.put(wr);
							} catch (WeatherQueueFull e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (ParseException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					LOGGER.log(Level.FINER, "Successfully logged");
				} catch(IOException ex) {
					System.out.printf("problem with scanning %s\n" , ex);
					LOGGER.log(Level.WARNING, "Problem in opening file", ex);
				} finally {
					if (input != null) {
						try {
							input.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		};
		runningThread.start();
	}
	public WeatherQueue getQueue() {
		return queue;
	}
	public Thread getRunningThread() {
		return runningThread != null && runningThread.isAlive() ? runningThread : null;
	}
}
