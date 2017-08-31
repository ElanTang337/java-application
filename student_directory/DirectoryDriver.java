
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
/**
 * Swing for Student Directory.
 * @author siyut
 */
public class DirectoryDriver extends JFrame implements ActionListener {
    /**
     * Serial number.
     */
    private static final long serialVersionUID = 1L;
    /**
     * reference to the textArea.
     */
    private JTextArea result;
    /**
     * reference to the textField.
     */
    private JTextField addFirst;
    /**
     * reference to the textField.
     */
    private JTextField addLast;
    /**
     * reference to the textField.
     */
    private JTextField addAndrew;
    /**
     * reference to the textField.
     */
    private JTextField addPhone;
    /**
     * reference to the textField.
     */
    private JTextField searchField;
    /**
     * reference to button add.
     */
    private JButton addButton;
    /**
     * reference to button delete.
     */
    private JButton deleteButton;
    /**
     * reference to button delete.
     */
    private JButton searchByAndrewButton;
    /**
     * reference to button delete.
     */
    private JButton searchByFirstButton;
    /**
     * reference to button delete.
     */
    private JButton searchByLastButton;
    /**
     * instantiate directory.
     */
    private static Directory d = new Directory();
    /**
     * reference to the textField.
     */
    private JTextField deleteAndrew;
    /**
     * Constructor where JFrame and other components are instantiated.
     */
    public DirectoryDriver() {
        setTitle("Student Directory");
        setSize(950, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel pane = new JPanel();
        JLabel headLabel = new JLabel("Student Directory");
        Font headFont = new Font(Font.SERIF, Font.BOLD, 30);
        headLabel.setFont(headFont);
        headLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JPanel student = new JPanel(new GridBagLayout());
        Border b1 = BorderFactory.createLineBorder(Color.PINK, 5);
        Border b11 = BorderFactory.createTitledBorder(b1, "Add a student");
        student.setBorder(BorderFactory.createCompoundBorder(b11, BorderFactory.createEmptyBorder(10, 5, 10, 0)));
        pane.add(headLabel);
        addFirst = new JTextField(10);
        JLabel addFirstName = new JLabel("First Name:");
        student.add(addFirstName);
        student.add(addFirst);
        addLast = new JTextField(10);
        JLabel addLastName = new JLabel("Last Name:");
        student.add(addLastName);
        student.add(addLast);
        addAndrew = new JTextField(10);
        JLabel addAndrewId = new JLabel("Andrew ID:");
        student.add(addAndrewId);
        student.add(addAndrew);
        addPhone = new JTextField(10);
        JLabel addPhoneNumber = new JLabel("Phone Number:");
        student.add(addPhoneNumber);
        student.add(addPhone);
        addButton = new JButton("Add");
        addButton.setHorizontalTextPosition(SwingConstants.CENTER);
        addButton.setBackground(Color.PINK);
        addButton.setOpaque(true);
        addButton.addActionListener(this);
        student.add(addButton);
        pane.add(student);
        JPanel delete = new JPanel(new GridBagLayout());
        Border b2 = BorderFactory.createLineBorder(Color.PINK, 5);
        Border b22 = BorderFactory.createTitledBorder(b2, "Delete a student");
        delete.setBorder(BorderFactory.createCompoundBorder(b22, BorderFactory.createEmptyBorder(10, 5, 10, 617)));
        deleteAndrew = new JTextField(10);
        JLabel deleteAndrewId = new JLabel("Andrew ID:");
        delete.add(deleteAndrewId);
        delete.add(deleteAndrew);
        deleteButton = new JButton("Delete");
        deleteButton.setOpaque(true);
        deleteButton.setBackground(Color.PINK);
        deleteButton.setHorizontalTextPosition(SwingConstants.CENTER);
        deleteButton.addActionListener(this);
        delete.add(deleteButton);
        pane.add(delete);
        JPanel search = new JPanel(new GridBagLayout());
        Border b3 = BorderFactory.createLineBorder(Color.PINK, 5);
        Border b33 = BorderFactory.createTitledBorder(b3, "Search a student");
        search.setBorder(BorderFactory.createCompoundBorder(b33, BorderFactory.createEmptyBorder(10, 5, 10, 317)));
        searchField = new JTextField(10);
        JLabel searchKey = new JLabel("Search Key:");
        searchByAndrewButton = new JButton("By Andrew ID");
        searchByAndrewButton.setBackground(Color.PINK);
        searchByAndrewButton.setOpaque(true);
        searchByFirstButton = new JButton("By First Name");
        searchByFirstButton.setBackground(Color.PINK);
        searchByFirstButton.setOpaque(true);
        searchByLastButton = new JButton("By Last Name");
        searchByLastButton.setBackground(Color.PINK);
        searchByLastButton.setOpaque(true);
        searchByAndrewButton.setHorizontalTextPosition(SwingConstants.CENTER);
        searchByFirstButton.setHorizontalTextPosition(SwingConstants.CENTER);
        searchByLastButton.setHorizontalTextPosition(SwingConstants.CENTER);
        searchByAndrewButton.addActionListener(this);
        searchByFirstButton.addActionListener(this);
        searchByLastButton.addActionListener(this);
        search.add(searchKey);
        search.add(searchField);
        search.add(searchByAndrewButton);
        search.add(searchByFirstButton);
        search.add(searchByLastButton);
        pane.add(search);
     //   searchField.addActionListener(this);
        searchField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    searchByAndrewButton.doClick();
                }
            }
        });
        //focus the searchfield when open the window
        this.addWindowFocusListener(new WindowAdapter() {
            public void windowGainedFocus(WindowEvent e) {
                searchField.requestFocusInWindow();
            }
        });
        result = new JTextArea(10, 75);
        Border b4 = BorderFactory.createLineBorder(Color.PINK, 5);
        Border b44 = BorderFactory.createTitledBorder(b4, "Results");
        result.setBorder(BorderFactory.createCompoundBorder(b44, BorderFactory.createLineBorder(Color.PINK, 2)));
        result.setEditable(false);
        pane.add(result);
        JScrollPane scroller = new JScrollPane(result);
        pane.add(scroller);
        setContentPane(pane);
        setVisible(true);
    }
    /**
     * print a student in the TextField.
     * @param st the reference of the student
     */
    private void printStudent(Student st) {
        this.result.append(st.getFirstName());
        this.result.append(" ");
        this.result.append(st.getLastName());
        this.result.append(" (Andrew ID: ");
        this.result.append(st.getAndrewId());
        this.result.append(", Phone Number: ");
        this.result.append(st.getPhoneNumber());
        this.result.append(")\n");
    }
    /**
     * Method to be invoked when buttons are clicked.
     * @param event object
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == addButton) {
            String[] stArray = new String[4];
            String s = addFirst.getText();
            if (s == null || s.equals("") || s.trim().equals("")) {
                result.append("First Name Missing!\n");
                stArray[0] = null;
            } else {
                stArray[0] = s;
            }
            String s1 = addLast.getText();
            if (s1 == null || s1.equals("") || s1.trim().equals("")) {
                if (stArray[0] != null) {
                    result.append("Last Name Missing!\n");
                }
                stArray[1] = null;
            } else {
                stArray[1] = s1;
            }
            String s2 = addAndrew.getText();
            if (s2 == null || s2.equals("") || s2.trim().equals("")) {
                if ((stArray[0] != null) && (stArray[1] != null)) {
                    result.append("Andrew ID Missing!\n");
                }
                stArray[2] = null;
            } else {
                stArray[2] = s2;
            }
            String s3 = addPhone.getText();
            if (s3 == null || s3.equals("") || s3.trim().equals("")) {
                stArray[3] = null;
            } else {
                stArray[3] = s3;
            }
            if ((stArray[0] != null) && (stArray[1] != null) && (stArray[2] != null)) {
                Student stu = new Student(stArray[2]);
                stu.setFirstName(stArray[0]);
                stu.setLastName(stArray[1]);
                if (stArray[3] != null) {
                    stu.setPhoneNumber(stArray[3]);
                }
                if (d.searchByAndrewId(stArray[2]) != null) {
                    result.append("Data already contains an entry for this Andrew ID\n");
                } else {
                    d.addStudent(stu);
                    result.append("Successfully added: ");
                    printStudent(stu);
                    addFirst.setText("");
                    addLast.setText("");
                    addAndrew.setText("");
                    addPhone.setText("");
                }
            }
        }
        if (event.getSource() == deleteButton) {
            String s = deleteAndrew.getText();
            Student stu = d.searchByAndrewId(s);
            if (s == null || s.equals("") || s.trim().equals("")) {
                result.append("Andrew ID Missing!\n");
            } else if (stu != null) {
                result.append("Successfully deleted: ");
                printStudent(stu);
                d.deleteStudent(s);
                deleteAndrew.setText("");
            } else {
                result.append("No Matches for the Andrew ID: ");
                result.append(s);
                result.append("\n");
            }
        }
        if (event.getSource() == searchByAndrewButton) {
            String s = searchField.getText();
            if (s == null || s.equals("") || s.trim().equals("")) {
                result.append("Andrew ID Missing!\n");
            } else if (d.searchByAndrewId(s) == null) {
                result.append("No Matches for the Andrew ID: ");
                result.append(s);
                result.append("\n");
            } else {
                Student stu = d.searchByAndrewId(s);
                printStudent(stu);
                searchField.setText("");
            }
        }
        if (event.getSource() == searchByFirstButton) {
            String s = searchField.getText();
            if (s == null || s.equals("") || s.trim().equals("")) {
                result.append("First Name Missing!\n");
            } else if (d.searchByFirstName(s).isEmpty()) {
                result.append("No Matches for the first name: ");
                result.append(s);
                result.append("\n");
            } else {
                List<Student> list = new ArrayList<Student>();
                list = d.searchByFirstName(s);
                for (Student l: list) {
                    printStudent(l);
                }
                searchField.setText("");
            }
        }
        if (event.getSource() == searchByLastButton) {
            String s = searchField.getText();
            if (s == null || s.equals("") || s.trim().equals("")) {
                result.append("Last Name Misssing!\n");
            } else if (d.searchByLastName(s).isEmpty()) {
                result.append("No Matches for the last name: ");
                result.append(s);
                result.append("\n");
            } else {
                List<Student> list = new ArrayList<Student>();
                list = d.searchByLastName(s);
                for (Student l: list) {
                    printStudent(l);
                }
                searchField.setText("");
            }
        }
    }
    /**
     * a nested class of csv reader.
     */
    private class CSVReader extends BufferedReader {
        /**
         * a constructor of the reader.
         * @param in the parameter of the reader
         */
        CSVReader(Reader in) {
            super(in);
        }
        /**
         * use the count of the commas to parse the elements into string in an array.
         * @return
         * return a string
         * @throws IOException
         * throw an ioexception
         */
        public String[] readCSVLine() throws IOException {
            String line = super.readLine();
            if (line == null) {
                return null;
            }
            int commaCount = 0;
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == ',') {
                    commaCount = commaCount + 1;
                }
            }
           String[] values = new String[commaCount + 1];
           int beginIndex = 0;
           for (int i = 0; i < commaCount; i++) {
               int endIndex = line.indexOf(',', beginIndex);
               if (line.charAt(beginIndex) == '"' && line.charAt(endIndex - 1) == '"') {
                   values[i] = line.substring(beginIndex + 1, endIndex - 1);
               } else {
                   values[i] = line.substring(beginIndex, endIndex);
               }
               beginIndex = endIndex + 1;
           }
           if (line.charAt(beginIndex) == '"' && line.charAt(line.length() - 1) == '"') {
               values[commaCount] = line.substring(beginIndex + 1, line.length() - 1);
           } else {
               values[commaCount] = line.substring(beginIndex, line.length());
           }

           return values;
        }
    }
    /**
     * main method.
     * @param args command line arguments.
     * @throws FileNotFoundException
     * if file is not found
     * @throws IOException
     * if error occurred
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        DirectoryDriver dd = new DirectoryDriver();
        // Directory d = new Directory();
        if (args.length == 1) {
            FileReader fr = new FileReader(args[0]);
            CSVReader c = dd.new CSVReader(fr);
            int lineNum = 0;
            boolean eof = false;
            while (!eof) {
                String[] values = c.readCSVLine();
                if (values == null) {
                    eof = true;
                } else {
                    lineNum = lineNum + 1;
                    if (lineNum != 1) {
                        Student s = new Student(values[2]);
                        s.setFirstName(values[0]);
                        s.setLastName(values[1]);
                        s.setPhoneNumber(values[3]);
                        d.addStudent(s);
                    }
                }
            }
            c.close();
        }
    }
}
