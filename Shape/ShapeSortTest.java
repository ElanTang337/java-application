/**
 * test the sorting of the shapes.
 * @author siyut
 */
public class ShapeSortTest {
    /**
     * the main method of the test program.
     * @param args
     * the parameter for main method.
     */
    public static void main(String[] args) {
        /**
         * define an array of Shape.
         */
        Shape[] sh = new Shape[args.length];
        for (int i = 0; i < args.length; i++) {
            switch (args[i].charAt(0)) {
            case 'C':
                sh[i] = new Circle(Integer.valueOf(args[i].substring(1)));
                break;
            case 'S':
                sh[i] = new Square(Integer.valueOf(args[i].substring(1)));
                break;
            case 'H':
                sh[i] = new Hexagon(Integer.valueOf(args[i].substring(1)));
                break;
            case 'O':
                sh[i] = new Octagon(Integer.valueOf(args[i].substring(1)));
                break;
            default:
            System.out.println("Undefined Shape!");
            }
        }
        for (int i = 0; i < sh.length; i++) {
            for (int j = i + 1; j < sh.length; j++) {
                if (sh[j].getArea() < sh[i].getArea()) {
                    Shape temp = sh[i];
                    sh[i] = sh[j];
                    sh[j] = temp;
                }
            }
        }
        for (Shape s : sh) {
            System.out.println(s);
        }
        System.out.println();
        for (int i = 0; i < sh.length; i++) {
            for (int j = i + 1; j < sh.length; j++) {
                if (sh[j].getPerimeter() > sh[i].getPerimeter()) {
                    Shape temp = sh[i];
                    sh[i] = sh[j];
                    sh[j] = temp;
                }
            }
        }
        for (Shape s : sh) {
            System.out.println(s);
        }
    }
}
