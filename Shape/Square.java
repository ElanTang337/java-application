/**
 * define a Square class.
 * @author siyut
 */
public class Square extends Rectangle {
    /**
     * the side of the square.
     */
   private double side;
   /**
    * a constructor of Square with one parameter newSide.
    * @param newSide
    * the side of the square
    */
   public Square(double newSide) {
       super(newSide, newSide);
       side = newSide;
   }
   /**
    * a method which returns side.
    * @return
    * return the side of the square
    */
   public double getSide() {
       return side;
   }
   /**
    * a override of toString method to get the area and the perimeter of the square.
    */
   @Override
   public String toString() {
       return String.format("Square %1$.3f", getArea()) + " " + String.format("%1$.3f", getPerimeter());
   }
}
