/**
 * define a rectangle class.
 * @author siyut
 *
 */
public class Rectangle extends Shape {
    /**
     * the width of the rectangle.
     */
    private double width;
    /**
     * the height of the rectangle.
     */
    private double height;
    /**
     * a constructor of Rectangle with two parameters.
     * @param newWidth
     * the width of the rectangle
     * @param newHeight
     * the height of the rectangle
     */
    public Rectangle(double newWidth, double newHeight) {
        super();
        width = newWidth;
        height = newHeight;
    }
    /**
     * implement Shape.getArea.
     * @return
     * return the value of area
     */
    public double getArea() {
        return (width * height);
    }
    /**
     * implement Shape.getPerimeter.
     * @return
     * return the value of perimeter
     */
    public double getPerimeter() {
        return (2 * (width + height));
    }
    /**
     * a method which can get the width of the rectangle.
     * @return
     * return the width of the rectangle
     */
    public double getWidth() {
        return width;
    }
    /**
     * a method which can get the height of the rectangle.
     * @return
     * return the height of the rectangle
     */
    public double getHeight() {
        return height;
    }
    /**
     * a method which can return the string format of the width and height.
     */
    @Override
    public String toString() {
        return String.format("Rectangle %1$.3f", getArea()) + " " + String.format("%1$.3f", getPerimeter());
    }
}
