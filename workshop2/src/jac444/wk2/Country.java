/**
 * 
 */
package jac444.wk2;

/**
 * @author Namra Rupesh Fanse
 *
 */
public class Country implements Measurable {
	
	/**
	 * String for name
	 */
	private String name;
	
	/**
	 * double for area
	 */
	private double area;
	
	/**
	 * @param name
	 * @param area
	 */
	public Country(String name , double area) {
		
		this.name = name;
		
		this.area = area;
		
	}
	
	/* (non-Javadoc)
	 * @see jac444.wk2.Measurable#getArea()
	 */
	public String getArea() {
		
		return Double.toString(area) + " square kilometeres is the area of this country";
		
	}
	
}
	
/*	
	public static void main(String args[]) {
		
		Country country =  new Country("France" , 100);
		
		System.out.println(country.getArea());
		
	}
*/