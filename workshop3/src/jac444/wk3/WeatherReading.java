/**
 * 
 */
package jac444.wk3;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Objects;
/**
 * @author Namra Rupesh Fanse
 *
 */

public class WeatherReading {
	/**
	 * temperatures are assumed to be between -40 and 40 degrees Celsius
	 */
	/**
	 * minimum temperature is -40°C
	 */
	final static int MIN_TEMP = -40;
	/**
	 * maximum temperature is 40°C
	 */
	final static int MAX_TEMP = 40;
	/**
	 * stores precise time of the reading 
	 */
	private Timestamp time;
	
	public static final DateFormat timeFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	
	//private Date time2;
	/**
	 * stores temperature of the reading
	 */
	private int temperature;
	/**
	 * stores location of the reading 
	 */
	private String location;
	/**
	 * Constructor to initialize all the values
	 * @param time
	 * @param temperature
	 * @param location
	 */
	public WeatherReading(Timestamp time ,int temperature , String location) {
		this.time = time;
		this.temperature = temperature;
		this.location = location;
	}
	/**
	 * Accesor that returns time value
	 * @return time 
	 */
	public Timestamp getTime() {	
		return time;
	}
	/**
	 * Accesor that returns temperature value
	 * @return temperature
	 */
	public int getTemperature() {	
		return temperature;
	}
	/**
	 * Accesor that returns location value
	 * @return location
	 */
	public String getLocation() {	
		return location;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override	
	public boolean equals(Object object) {
		//check if the objects are identical
		if(this == object) return true;
		//return false if parameter is null
		if(object == null) return false;
		//check that object is an WeatherReading
		if(getClass() != object.getClass()) return false;
		//check that the instance variables have identical values
		WeatherReading wrother = (WeatherReading) object;
		
		return Objects.equals(time, wrother.time) && temperature == wrother.temperature && Objects.equals(location, wrother.location); 
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "time = "  + new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(time) + ", temperature = " + temperature + "\u00b0C" + ", location = " + location; 
	}
	
	
}
