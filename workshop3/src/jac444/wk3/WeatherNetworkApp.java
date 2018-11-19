package jac444.wk3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Namra Rupesh Fanse
 */
public class WeatherNetworkApp { 
	/**
	 * Polls readings from queue and writes it to out.
	 * @param queue	the weather queue
	 * @param out	the output stream
	 */
	private static void writeQueueReadings(WeatherQueue queue, PrintWriter out) {
		while (!queue.isEmpty()) {
			try {
				WeatherReading reading = queue.get();
				out.println(reading);
			} catch (WeatherQueueEmpty e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * The program's entry point.
	 * @param args	the program arguments
	 */
	public static void main(String[] args) {
		// Declare PrintWriter for the finally block.
		PrintWriter out = null;
		try {
			// Starts a output stream to write the output to master_out.txt
			File outFile = new File("master_out.txt");
			// Deletes the master_out.txt if it already exists.
			outFile.delete();
			out = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
			// Sets the max size of queue; its elements are WeatherReading objects read from weather*.txt's
			WeatherQueue queue = new WeatherQueue(10);
			Set<WeatherReporter> reporters = new HashSet<WeatherReporter>();
			// Adds reporters to read their corresponding text files.
			reporters.add(new WeatherReporter("weather.txt", queue));
			reporters.add(new WeatherReporter("weather1.txt", queue));
			reporters.add(new WeatherReporter("weather2.txt", queue));
			reporters.add(new WeatherReporter("weather3.txt", queue));
			for (WeatherReporter reporter : reporters) {
				reporter.reportReadings();
			}
			do {
				writeQueueReadings(queue, out);
				boolean threadsRunning = false;
				for (WeatherReporter reporter : reporters) {
					// Checks if at least one thread (reader) is still running.
					threadsRunning = threadsRunning || reporter.getRunningThread() != null;
					// Breaks the loop if at least one thread is still running, for efficiency.
					if (threadsRunning) {
						break;
					}
				}
				// If no more readers are executing, then exit the loop.
				if (!threadsRunning) {
					// Check and write elements from queue again to prevent loss of readings.
					writeQueueReadings(queue, out);
					break;
				}
				// Pause execution for 1 millisecond to not eat CPU:
				try {
					Thread.sleep(1L);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} while (true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
