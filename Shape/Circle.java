/**
 * define a shape of Circle.
 * @author siyut
 *
 */
public class Circle extends Shape {
    /**
     * the radius of the circle.
     */
    private double radius;
    /**
     * a constructor of the circle with a parameter of newRadius.
     * @param newRadius
     * the radius of the circle
     */
    public Circle(double newRadius) {
        super();
        radius = newRadius;
    }
    /**
     * implements Shape.getArea().
     * @return
     * return the value of area
     */
    public double getArea() {
        return Math.PI * radius * radius;
    }
    /**
     * implements Shape.getPerimeter().
     * @return
     * return the value of perimeter
     */
    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }
    /**
     * a method which can return radius.
     * @return
     * return the radius of the circle
     */
    public double getRadius() {
        return radius;
    }
    /**
     * an override of the method toString which can print out the area and the perimeter of the circle.
     */
    @Override
    public String toString() {
        return String.format("Circle %1$.3f", getArea()) + " " + String.format("%1$.3f", getPerimeter());
    }
}
