package phone;

public class Phone {
    private int id;
    private String lastName;
    private String firstName;
    private String middleName;
    private int accountNumber;
    private int cityCallDuration;
    private int longDistanceCallDuration;

    public Phone(int id, String lastName, String firstName, String middleName, int accountNumber, int cityCallDuration,
            int longDistanceCallDuration) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.accountNumber = accountNumber;
        this.cityCallDuration = cityCallDuration;
        this.longDistanceCallDuration = longDistanceCallDuration;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getCityCallDuration() {
        return cityCallDuration;
    }

    public int getLongDistanceCallDuration() {
        return longDistanceCallDuration;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCityCallDuration(int cityCallDuration) {
        this.cityCallDuration = cityCallDuration;
    }

    public void setLongDistanceCallDuration(int longDistanceCallDuration) {
        this.longDistanceCallDuration = longDistanceCallDuration;
    }

    @Override
    public String toString() {
        return "Subscriber: " + lastName + " " + firstName + " " + middleName + ", Account number: " + accountNumber +
                ", City call duration: " + cityCallDuration + " min, Long-distance call duration: "
                + longDistanceCallDuration + " min.";
    }
}
