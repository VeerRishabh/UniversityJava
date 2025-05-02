/**
 * This class represents Full-Time staff positions in the organization.
 * It extends the base StaffHire class and adds specific attributes for full-time positions.
 */
public class FullTimeStaffHire extends StaffHire {

    // Additional attributes specific to full-time positions
    private double salary;                  // Annual or monthly salary amount
    private int weeklyFractionalHours;      // Weekly working hours commitment

    /**
     * Constructor for creating a full-time staff position
     * 
     * @param vacancyNumber Unique identifier for the vacancy
     * @param designation Job title or position name
     * @param jobType Type of job (should be "Full-time")
     * @param staffName Name of the appointed staff member
     * @param joiningDate Date when the staff member joined
     * @param qualification Educational qualification of staff
     * @param appointedBy Name of the person who appointed the staff
     * @param joined Flag indicating if the position is filled
     * @param salary Salary amount for the position
     * @param weeklyFractionalHours Weekly working hours commitment
     */
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType,
                              String staffName, String joiningDate, String qualification,
                              String appointedBy, boolean joined, double salary,
                              int weeklyFractionalHours) {
        // Call the parent constructor to initialize inherited attributes
        super(vacancyNumber, designation, jobType, staffName, joiningDate,
              qualification, appointedBy, joined);
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    /**
     * @return The salary for this full-time position
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Sets a new salary for the staff member
     * Only allows setting salary if the staff has joined
     * 
     * @param salary New salary amount to set
     */
    public void setSalary(double salary) {
        // Check if the staff has joined before updating salary
        if (isJoined()) {
            this.salary = salary;
        } else {
            System.out.println("Cannot set salary for unappointed staff.");
        }
    }

    /**
     * @return The weekly fractional hours commitment
     */
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    /**
     * @param weeklyFractionalHours New weekly hours commitment to set
     */
    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    /**
     * Displays all information about this full-time staff position
     * Overrides the parent class display method and adds full-time specific attributes
     */
    @Override
    public void display() {
        // First display all parent class attributes
        super.display();
        // Then add full-time specific attributes
        System.out.println("Salary: " + salary);
        System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
    }
}