/**
 * This class provides a graphical user interface for the recruitment system.
 * It allows users to manage both full-time and part-time staff positions.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RecruitmentSystemGUI extends JFrame implements ActionListener {

    // GUI component declarations
    private JTextField vacancyNumberField, designationField, jobTypeField, staffNameField,
            joiningDateField, qualificationField, appointedByField, salaryField,
            weeklyHoursField, workingHoursField, wagesPerHourField, shiftsField;
    private JCheckBox joinedCheckBox;
    private JButton addFullTimeButton, addPartTimeButton, setSalaryButton,
            setShiftsButton, terminatePartTimeButton, displayAllButton, searchButton;
    private JTextArea displayArea;

    // ArrayList to store all staff (both full-time and part-time)
    private ArrayList<StaffHire> staffList;

    /**
     * Constructor to initialize the GUI and set up components
     */
    public RecruitmentSystemGUI() {
        // Initialize the staff list to store staff objects
        staffList = new ArrayList<>();

        // Set up the main JFrame
        setTitle("Recruitment System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with grid layout to organize form fields
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(0, 4, 10, 5)); // Rows, Columns, H-gap, V-gap

        // Add title to the form
        mainPanel.add(new JLabel(""));
        JLabel titleLabel = new JLabel("Staff Details", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainPanel.add(titleLabel);
        mainPanel.add(new JLabel(""));
        mainPanel.add(new JLabel(""));

        // Add form fields for staff details
        addLabelAndField("Vacancy:", vacancyNumberField = new JTextField(10), mainPanel);
        addLabelAndField("Designation:", designationField = new JTextField(10), mainPanel);
        addLabelAndField("Job Type:", jobTypeField = new JTextField(10), mainPanel);
        addLabelAndField("Job Date:", joiningDateField = new JTextField(10), mainPanel);
        addLabelAndField("Staff Name:", staffNameField = new JTextField(10), mainPanel);
        addLabelAndField("Appointed By:", appointedByField = new JTextField(10), mainPanel);
        addLabelAndField("Qualification:", qualificationField = new JTextField(10), mainPanel);
        addLabelAndField("Salary:", salaryField = new JTextField(10), mainPanel);

        // Add joined checkbox
        JPanel joinedPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        joinedPanel.add(new JLabel("Joined:"));
        joinedPanel.add(joinedCheckBox = new JCheckBox());
        mainPanel.add(joinedPanel);

        // Add spacers for layout
        mainPanel.add(new JLabel(""));
        mainPanel.add(new JLabel(""));
        mainPanel.add(new JLabel(""));

        // Add part-time specific fields
        addLabelAndField("Weekly Hours:", weeklyHoursField = new JTextField(10), mainPanel);
        addLabelAndField("Working Hours:", workingHoursField = new JTextField(10), mainPanel);
        addLabelAndField("Wages/Hour:", wagesPerHourField = new JTextField(10), mainPanel);
        addLabelAndField("Shifts:", shiftsField = new JTextField(10), mainPanel);

        // Create buttons with action listeners
        addFullTimeButton = createButton("Add Full time");
        addPartTimeButton = createButton("Add Part time");
        setSalaryButton = createButton("Set Salary");
        setShiftsButton = createButton("Set Shifts");
        terminatePartTimeButton = createButton("Terminate Part time");
        displayAllButton = createButton("Display All");
        searchButton = createButton("Search");

        // Add buttons to a separate panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addButton(addFullTimeButton, buttonPanel);
        addButton(addPartTimeButton, buttonPanel);
        addButton(setSalaryButton, buttonPanel);
        addButton(setShiftsButton, buttonPanel);
        addButton(terminatePartTimeButton, buttonPanel);
        addButton(displayAllButton, buttonPanel);
        addButton(searchButton, buttonPanel);

        // Create display area for showing results
        displayArea = new JTextArea(10, 40);
        displayArea.setBorder(BorderFactory.createTitledBorder("Display"));
        JScrollPane scrollPane = new JScrollPane(displayArea);

        // Add all panels to the frame
        add(mainPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Display the frame
        setVisible(true);
    }

    /**
     * Helper method to add a label and text field to a panel
     * 
     * @param labelText Text for the label
     * @param textField Text field to add
     * @param panel Panel to add components to
     */
    private void addLabelAndField(String labelText, JTextField textField, JPanel panel) {
        panel.add(new JLabel(labelText));
        panel.add(textField);
    }

    /**
     * Helper method to create a button with an action listener
     * 
     * @param text Text for the button
     * @return The created button
     */
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.addActionListener(this); // Add this class as the action listener
        return button;
    }

    /**
     * Helper method to add a button to a panel
     * 
     * @param button Button to add
     * @param panel Panel to add the button to
     */
    private void addButton(JButton button, JPanel panel) {
        panel.add(button);
    }

    /**
     * Action listener for all buttons in the GUI
     * Handles button clicks and performs appropriate actions
     * 
     * @param e The action event (button click)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            // Add Full-Time Staff button action
            if (e.getSource() == addFullTimeButton) {
                // Parse input values
                int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                String designation = designationField.getText();
                String jobType = jobTypeField.getText();
                String staffName = staffNameField.getText();
                String joiningDate = joiningDateField.getText();
                String qualification = qualificationField.getText();
                String appointedBy = appointedByField.getText();
                boolean joined = joinedCheckBox.isSelected();
                double salary = Double.parseDouble(salaryField.getText());
                int weeklyHours = Integer.parseInt(weeklyHoursField.getText());

                // Create new full-time staff object
                FullTimeStaffHire fullTime = new FullTimeStaffHire(vacancyNumber, designation, jobType,
                        staffName, joiningDate, qualification, appointedBy, joined, salary, weeklyHours);

                // Add to staff list and show success message
                staffList.add(fullTime);
                displayArea.append("Full-time staff added successfully!\n");

            // Add Part-Time Staff button action
            } else if (e.getSource() == addPartTimeButton) {
                // Parse input values
                int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                String designation = designationField.getText();
                String jobType = jobTypeField.getText();
                String staffName = staffNameField.getText();
                String joiningDate = joiningDateField.getText();
                String qualification = qualificationField.getText();
                String appointedBy = appointedByField.getText();
                boolean joined = joinedCheckBox.isSelected();
                int workingHours = Integer.parseInt(workingHoursField.getText());
                double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
                String shifts = shiftsField.getText();

                // Create new part-time staff object
                PartTimeStaffHire partTime = new PartTimeStaffHire(vacancyNumber, designation, jobType,
                        staffName, joiningDate, qualification, appointedBy, joined, workingHours, wagesPerHour, shifts);

                // Add to staff list and show success message
                staffList.add(partTime);
                displayArea.append("Part-time staff added successfully!\n");

            // Set Salary button action
            } else if (e.getSource() == setSalaryButton) {
                // Parse input values
                int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                double newSalary = Double.parseDouble(salaryField.getText());
                
                // Search for matching full-time staff
                for (StaffHire staff : staffList) {
                    if (staff instanceof FullTimeStaffHire && staff.getVacancyNumber() == vacancyNumber) {
                        // Update salary if found
                        ((FullTimeStaffHire) staff).setSalary(newSalary);
                        displayArea.append("Salary updated for Full-time staff.\n");
                        return;
                    }
                }
                // If no matching staff found
                displayArea.append("Full-time staff not found.\n");

            // Set Shifts button action
            } else if (e.getSource() == setShiftsButton) {
                // Parse input values
                int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                String newShift = shiftsField.getText();
                
                // Search for matching part-time staff
                for (StaffHire staff : staffList) {
                    if (staff instanceof PartTimeStaffHire && staff.getVacancyNumber() == vacancyNumber) {
                        // Update shifts if found
                        ((PartTimeStaffHire) staff).setShifts(newShift);
                        displayArea.append("Shifts updated for Part-time staff.\n");
                        return;
                    }
                }
                // If no matching staff found
                displayArea.append("Part-time staff not found.\n");

            // Terminate Part-Time Staff button action
            } else if (e.getSource() == terminatePartTimeButton) {
                // Parse input values
                int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                
                // Search for matching part-time staff
                for (StaffHire staff : staffList) {
                    if (staff instanceof PartTimeStaffHire && staff.getVacancyNumber() == vacancyNumber) {
                        // Terminate staff if found
                        ((PartTimeStaffHire) staff).terminateStaff();
                        displayArea.append("Part-time staff terminated.\n");
                        return;
                    }
                }
                // If no matching staff found
                displayArea.append("Part-time staff not found.\n");

            // Search button action
            } else if (e.getSource() == searchButton) {
                // Parse input values
                int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
                displayArea.setText(""); // Clear display area
                
                // Search for any staff with matching vacancy number
                for (StaffHire staff : staffList) {
                    if (staff.getVacancyNumber() == vacancyNumber) {
                        // Redirect System.out to capture output from display() method
                        java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
                        java.io.PrintStream ps = new java.io.PrintStream(baos);
                        java.io.PrintStream old = System.out;
                        System.setOut(ps);
                        
                        // Call display method which prints to System.out
                        staff.display();
                        
                        // Restore System.out and get captured text
                        System.out.flush();
                        System.setOut(old);
                        displayArea.append(baos.toString());
                        return;
                    }
                }
                // If no matching staff found
                displayArea.append("Staff not found.\n");

            // Display All button action
            } else if (e.getSource() == displayAllButton) {
                displayArea.setText(""); // Clear display area
                
                // Display all staff in the list
                for (StaffHire staff : staffList) {
                    // Redirect System.out to capture output from display() method
                    java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
                    java.io.PrintStream ps = new java.io.PrintStream(baos);
                    java.io.PrintStream old = System.out;
                    System.setOut(ps);
                    
                    // Call display method which prints to System.out
                    staff.display();
                    
                    // Restore System.out and get captured text
                    System.out.flush();
                    System.setOut(old);
                    displayArea.append(baos.toString() + "\n");
                }
            }
        } 
        // Handle any exceptions that occur during processing
        catch (Exception ex) {
            displayArea.append("Error: " + ex.getMessage() + "\n");
        }
    }

    /**
     * Main method to start the application
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        new RecruitmentSystemGUI(); // Create an instance of the GUI
    }
}