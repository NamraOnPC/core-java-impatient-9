package jac444.wk2;


/**
 * @author Namra Rupesh Fanse
 *
 */
public abstract class Shape implements Measurable {
	
	/**
	 * A point object from Point class
	 */
	protected Point point;
	
	/**
	 * @param point
	 */
	public Shape(Point point) {
		
		this.point = point;
		
	}
	
	
	/**
	 * @param dx 
	 * @param dy
	 */
	public void moveBy(double dx , double dy) {
		
		this.point = new Point(this.point.getX() + dx , this.point.getY() + dy);
		
		//System.out.println();
		
	}
	
	/**
	 * @return a point of the desired shape
	 */
	public abstract Point getCentre();
	
}

/**
 * @author Namra Rupesh Fanse
 *
 */
class Circle extends Shape {
	
	/**
	 * Double for radius of the circle
	 */
	private double radius;
	//Constructor
	/**
	 * @param center
	 * @param radius
	 */
	public Circle(Point center, double radius) {
		
		super(center);
		
		this.radius = radius;
		
	}
	
	/* (non-Javadoc)
	 * @see jac444.wk2.Shape#getCentre()
	 */
	@Override 
	public Point getCentre() {
		
		return this.point;
		
	}
	
	/* (non-Javadoc)
	 * @see jac444.wk2.Measurable#getArea()
	 */
	@Override
	public String getArea() {
		
		return Double.toString(Math.PI * ( radius * radius)) + " Units Squared";
		
	}

}

/**
 * @author Namra Rupesh Fanse
 *
 */
class Rectangle extends Shape {
	
	/**
	 * Double to measure width of the rectangle 
	 */
	private double width;
	
	/**
	 * Double to measure height of the rectangle 
	 */
	private double height;
	
	/**
	 * @param topLeft
	 * @param width
	 * @param height
	 */
	public Rectangle(Point topLeft, double width , double height) {
		
		super(topLeft);
		
		this.width = width;
		
		this.height = height;
		
	}
	
	/* (non-Javadoc)
	 * @see jac444.wk2.Shape#getCentre()
	 */
	@Override 
	public Point getCentre() {
		
		double X = (2 * this.point.getX() + this.width) / 2;
		
		double Y = (2 * this.point.getY() - this.height) / 2;
		
		return new Point(X,Y);
		
	}	
	
	/* (non-Javadoc)
	 * @see jac444.wk2.Measurable#getArea()
	 */
	@Override
	public String getArea() {
		
		return Double.toString(height * width) + " Units Squared" ;
	
	}

}

/**
 * @author Namra Rupesh Fanse
 *
 */
class Line extends Shape {
	
	/**
	 * Point object to calculate distance between two objects
	 */
	private Point from;
	
	/**
	 * Point object to calculate distance between two objects
	 */
	private Point to;
	
	/**
	 * @param from
	 * @param to
	 */
	public Line(Point from , Point to) {
		
		super(null);
		
		this.from = from;
		
		this.to = to;
		
		double X = (this.from.getX() + this.to.getX())/2;
		
		double Y = (this.from.getY() + this.to.getY())/2;
		
		this.point = new Point(X,Y);
		
	}
	
	/* (non-Javadoc)
	 * @see jac444.wk2.Shape#getCentre()
	 */
	@Override
	public Point getCentre() {
		
		return this.point;
		
	}
	
	/* (non-Javadoc)
	 * @see jac444.wk2.Shape#moveBy(double, double)
	 */
	@Override
	public void moveBy(double dx, double dy) {
		
		super.moveBy(dx, dy);
		
		this.from = new Point(this.from.getX() + dx , this.from.getY() + dy);
		
		this.to = new Point(this.to.getX() + dx, this.to.getY() + dy);
	}
	
	/* (non-Javadoc)
	 * @see jac444.wk2.Measurable#getArea()
	 */
	@Override
	public String getArea() {
		
		return "Area of a Line Segment is not possible !!"; 
		
	}
	
}
