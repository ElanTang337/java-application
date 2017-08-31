/**
 * define a class of Hexagon.
 * @author siyut
 *
 */
public class Hexagon extends Shape {
    /**
     * define the side of the hexagon.
     */
    private double side;
    /**
     * a constructor of the Hexagon of one parameter.
     * @param newSide
     * the side of the hexagon
     */
    public Hexagon(double newSide) {
        super();
        side = newSide;
    }
    /**
     * implements Shape.getArea().
     * @return
     * return the value of area.
     */
    public double getArea() {
        return 3 * 0.5 * Math.pow(3, 0.5) * Math.pow(side, 2);
    }
    /**
     * implements Shape.getPerimeter().
     * @return
     * return the value of perimeter
     */
    public double getPerimeter() {
        return 6 * side;
    }
    /**
     * a method which can return side.
     * @return
     * return the side of the hexagon
     */
    public double getSide() {
        return side;
    }
    /**
     * an override of the method toString which can print out the area and the perimeter of the hexagon.
     */
    @Override
    public String toString() {
        return String.format("Hexagon %1$.3f", getArea()) + " " + String.format("%1$.3f", getPerimeter());
    }
}
