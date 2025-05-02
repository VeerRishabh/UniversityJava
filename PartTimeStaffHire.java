/**
 * This class represents Part-Time staff positions in the organization.
 * It extends the base StaffHire class and adds specific attributes for part-time positions.
 */
public class PartTimeStaffHire extends StaffHire {

    // Additional attributes specific to part-time positions
    private int workingHour;        // Number of hours worked per day
    private double wagesPerHour;    // Payment rate per hour
    private String shifts;          // Shift timing (morning, evening, etc.)
    private boolean terminated;     // Flag indicating if employment is terminated

    /**
     * Constructor for creating a part-time staff position
     * 
     * @param vacancyNumber Unique identifier for the vacancy
     * @param designation Job title or position name
     * @param jobType Type of job (should be "Part-time")
     * @param staffName Name of the appointed staff member
     * @param joiningDate Date when the staff member joined
     * @param qualification Educational qualification of staff
     * @param appointedBy Name of the person who appointed the staff
     * @param joined Flag indicating if the position is filled
     * @param workingHour Number of hours worked per day
     * @param wagesPerHour Payment rate per hour
     * @param shifts Shift timing (morning, evening, etc.)
     */
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType,
                              String staffName, String joiningDate, String qualification,
                              String appointedBy, boolean joined, int workingHour,
                              double wagesPerHour, String shifts) {
        // Call the parent constructor to initialize inherited attributes
        super(vacancyNumber, designation, jobType, staffName, joiningDate,
              qualification, appointedBy, joined);
        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false; // Initially set to false when created
    }

    /**
     * @return The working hours per day
     */
    public int getWorkingHour() {
        return workingHour;
    }

    /**
     * @param workingHour New working hours to set
     */
    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    /**
     * @return The wages per hour rate
     */
    public double getWagesPerHour() {
        return wagesPerHour;
    }

    /**
     * @param wagesPerHour New wages per hour to set
     */
    public void setWagesPerHour(double wagesPerHour) {
        this.wagesPerHour = wagesPerHour;
    }

    /**
     * @return The current shift assignment
     */
    public String getShifts() {
        return shifts;
    }

    /**
     * Sets a new shift for the staff member
     * Only allows setting shifts if the staff has joined
     * 
     * @param shifts New shift to assign
     */
    public void setShifts(String shifts) {
        // Check if the staff has joined before updating shifts
        if (isJoined()) {
            this.shifts = shifts;
        } else {
            System.out.println("Cannot set shifts for unappointed staff.");
        }
    }

    /**
     * @return Whether the staff is terminated
     */
    public boolean isTerminated() {
        return terminated;
    }

    /**
     * @param terminated New terminated status to set
     */
    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    /**
     * Terminates the employment of this part-time staff
     * Resets all personal information and marks as terminated
     */
    public void terminateStaff() {
        // Check if already terminated to avoid redundant operation
        if (terminated) {
            System.out.println("Staff is already terminated.");
        } else {
            // Clear all personal information
            setStaffName("");
            setJoiningDate("");
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            this.terminated = true;
        }
    }

    /**
     * Calculates the daily income for this part-time staff
     * 
     * @return The daily income (working hours * wages per hour)
     */
    public double getIncomePerDay() {
        return workingHour * wagesPerHour;
    }

    /**
     * Displays all information about this part-time staff position
     * Overrides the parent class display method and adds part-time specific attributes
     */
    @Override
    public void display() {
        // First display all parent class attributes
        super.display();
        // Then add part-time specific attributes
        System.out.println("Working Hour: " + workingHour);
        System.out.println("Wages Per Hour: " + wagesPerHour);
        System.out.println("Shifts: " + shifts);
        System.out.println("Terminated: " + terminated);
        System.out.println("Income Per Day: " + getIncomePerDay());
    }
}