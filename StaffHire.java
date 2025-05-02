/**
 * This is the parent class for all staff hiring types in the system.
 * It contains common attributes and methods for all staff positions.
 */
public class StaffHire {

    // Basic attributes for any staff position
    private int vacancyNumber;      // Unique identifier for the vacancy
    private String designation;     // Job title or position name
    private String jobType;         // Type of job (e.g., "Full-time", "Part-time")
    private String staffName;       // Name of the appointed staff member
    private String joiningDate;     // Date when the staff member joined
    private String qualification;   // Educational qualification of staff
    private String appointedBy;     // Name of the person who appointed the staff
    private boolean joined;         // Flag indicating if the position is filled

    /**
     * Constructor to initialize a StaffHire object with all necessary attributes.
     * 
     * @param vacancyNumber Unique identifier for the vacancy
     * @param designation Job title or position name
     * @param jobType Type of job (e.g., "Full-time", "Part-time")
     * @param staffName Name of the appointed staff member
     * @param joiningDate Date when the staff member joined
     * @param qualification Educational qualification of staff
     * @param appointedBy Name of the person who appointed the staff
     * @param joined Flag indicating if the position is filled
     */
    public StaffHire(int vacancyNumber, String designation, String jobType, String staffName,
                      String joiningDate, String qualification, String appointedBy, boolean joined) {
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
    }

    // Getter methods - provide access to private attributes
    
    /**
     * @return The vacancy number for this position
     */
    public int getVacancyNumber() {
        return vacancyNumber;
    }

    /**
     * @return The designation/job title for this position
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @return The job type (full-time/part-time)
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * @return The name of the staff member
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * @return The joining date of the staff member
     */
    public String getJoiningDate() {
        return joiningDate;
    }

    /**
     * @return The qualification of the staff member
     */
    public String getQualification() {
        return qualification;
    }

    /**
     * @return The name of the person who appointed this staff
     */
    public String getAppointedBy() {
        return appointedBy;
    }

    /**
     * @return Whether the staff has joined or not
     */
    public boolean isJoined() {
        return joined;
    }

    // Setter methods - allow modification of private attributes
    
    /**
     * @param vacancyNumber New vacancy number to set
     */
    public void setVacancyNumber(int vacancyNumber) {
        this.vacancyNumber = vacancyNumber;
    }

    /**
     * @param designation New designation/job title to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @param jobType New job type to set
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     * @param staffName New staff name to set
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * @param joiningDate New joining date to set
     */
    public void setJoiningDate(String joiningDate) {
        this.joiningDate = joiningDate;
    }

    /**
     * @param qualification New qualification to set
     */
    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    /**
     * @param appointedBy New appointer name to set
     */
    public void setAppointedBy(String appointedBy) {
        this.appointedBy = appointedBy;
    }

    /**
     * @param joined New joined status to set
     */
    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    /**
     * Displays all the information about this staff position.
     * This method will be inherited by child classes and may be overridden.
     */
    public void display() {
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designation);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Qualification: " + qualification);
        System.out.println("Appointed By: " + appointedBy);
        System.out.println("Joined: " + joined);
    }
}