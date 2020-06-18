class User {
    private String firstName;
    private String lastName;

    public User() {
        this.firstName = "";
        this.lastName = "";
    }

    public void setFirstName(String firstName) {
        // write your code here
        if (firstName != null) {
            this.firstName = firstName;
        } else this.firstName = "";
    }

    public void setLastName(String lastName) {
        // write your code here
        if (lastName != null) {
            this.lastName = firstName;
        } else this.lastName = "";
    }

    public String getFullName() {
        if ((this.firstName == "") && (this.lastName == "")) {
            return "Unknown";
        } else if (this.firstName == "") {
            return this.lastName;
        } else if (this.lastName == "") {
            return this.firstName;
        } else return e

    }
}