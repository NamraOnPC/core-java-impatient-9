/**
 * 
 */
package jac444.wk3;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Namra Rupesh Fanse
 *
 */
public class WeatherQueue {
	
	
	private int capacity;
	/**
	 * a Deque to store WeatherReading objects.
	 */
	private Queue<WeatherReading> weatherData;
	/**
	 * Constuctor that sets the maximum number of elements the data structure can hold.
	 * @param capacity
	 */
	public WeatherQueue(int capacity){
		this.capacity = capacity;
		weatherData =  new ArrayDeque<WeatherReading>(capacity);
	}
	/**
	 * a function that adds a WeatherReading object to the tail of the queue.
	 * @param wr
	 */
	public synchronized void put(WeatherReading wr) throws WeatherQueueFull {
		//throws exception when the user attempts to insert a WeatherReading element into the queue but no more space is available
		if (weatherData.size() >= capacity) {
			throw new WeatherQueueFull("WeatherQueue is Full");
		}
		weatherData.add(wr);
	}
	/**
	 * obtains a reference to the WeatherReading object at the head of the queue and removes the object from the structure.
	 * @return WeatherReading object
	 */
	/**
	 * @return WeatherReading object
	 * @throws WeatherQueueEmpty
	 * @throws WeatherQueueFull
	 */
	public synchronized WeatherReading get() throws WeatherQueueEmpty {	
		//throws exception when the user attempt to obtain a WeatherReading element from the queue, but it does not hold any.	
		if(weatherData.isEmpty()) {
			throw new WeatherQueueEmpty("WeatherQueue is Empty");
		}
		return weatherData.poll();
	
	}
	public synchronized boolean isEmpty() {
		return weatherData.isEmpty();
	}
}
