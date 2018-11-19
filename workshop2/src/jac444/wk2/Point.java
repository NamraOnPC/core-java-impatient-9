/**
 * 
 */
package jac444.wk2;

/**
 * @author Namra Rupesh Fanse
 *
 */
public class Point {

	/**
	 * @param args
	 */
	/**
	 * Double for X
	 */
	private double X;
	
	/**
	 * Double for Y
	 */
	private double Y;
	
	//Constructor
	/**
	 * @param x
	 * @param y
	 */
	public Point(double x , double y) {
		
		this.X = x;
		
		this.Y = y;
		
		
	}
	
	//Acessor methods
	/**
	 * @return X
	 */
	public double getX() {
		
		return X;
		
	}
	
	/**
	 * @return Y
	 */
	public double getY() {
		
		return Y;
		
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object object) {
		
		if (this == object) {
			
			return true;
			
		}
		
		if(object == null || getClass() != object.getClass()) {
			
			return false;
			
		}
		
		Point point = (Point) object;
		
		if(Double.compare(point.X, X) != 0) {
			
			return false;
			
		}
		
		return Double.compare(point.Y, Y) == 0;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		
		int result;
		
		long foo;
		
		foo = Double.doubleToLongBits(X);
		
		result = (int)(foo ^ (foo >>> 32));
		
		foo = Double.doubleToLongBits(Y);
		
		result = 31 * result + (int)(foo ^ ( foo >>> 32));
		
		return result;
		
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		return "Point{" + " X = " + X + " , Y = " + Y + "}" ;
		
		
	}
	
	class LabeledPoint extends Point {
		
		/**
		 * String for label name
		 */
		private String label;
		
		//Constructor
		/**
		 * @param x
		 * @param y
		 * @param label
		 */
		public LabeledPoint(double x , double y , String label) {
			
			super(x,y);
			
			this.label = label;
			
		}
		
		/**
		 * @return String which accesses label 
		 */
		public String getLabel() {
			
			return label;
			
		}
		
		/* (non-Javadoc)
		 * @see jac444.wk2.Point#equals(java.lang.Object)
		 */
		@Override
		public boolean equals(Object object) {
			
			if(this == object) {
				
				return false;
				
			}
			
			if(object == null || getClass() != object.getClass()) {
				
				return false;
				
			}
			
			if(!super.equals(object)) {
				
				return false;
				
			}
			
			LabeledPoint current = (LabeledPoint) object;
			
			return label.equals(current.label);
			
		}
		
		/* (non-Javadoc)
		 * @see jac444.wk2.Point#hashCode()
		 */
		@Override
		public int hashCode() {
			
			int result = super.hashCode();
			
			result = 31 * result + label.hashCode();
			
			return result;
		
		}
		
		/* (non-Javadoc)
		 * @see jac444.wk2.Point#toString()
		 */
		@Override 
		public String toString() {
			
			return "LabeledPoint{" + " X = " + this.getX() + " , Y = " + this.getY() + " , label = '" + label + '\'' + '}'; 		
			
		}
		
	}
	
}
