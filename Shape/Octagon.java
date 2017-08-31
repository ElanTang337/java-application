/**
 * define a class of octagon.
 * @author siyut
 *
 */
public class Octagon extends Shape {
    /**
     * the side of the octagon.
     */
    private double side;
    /**
     * a constructor with one parameter.
     * @param newSide
     * the side of the octagon
     */
    public Octagon(double newSide) {
        super();
        side =  newSide;
    }
    /**
     * implements Shape.getArea().
     * @return
     * return the value of area
     */
    public double getArea() {
        return 2 * (1 + Math.pow(2, 0.5)) * Math.pow(side, 2);
    }
    /**
     * implements Shape.getPerimeter().
     * @return
     * return the value of perimeter
     */
    public double getPerimeter() {
        return 8 * side;
    }
    /**
     * a method which return side.
     * @return
     * the side of the octagon
     */
    public double getSide() {
        return side;
    }
    /**
     * an override of the method toString which can print out the area and the perimeter of the octagon.
     */
    @Override
    public String toString() {
        return String.format("Octagon %1$.3f", getArea()) + " " + String.format("%1$.3f", getPerimeter());
    }
}
