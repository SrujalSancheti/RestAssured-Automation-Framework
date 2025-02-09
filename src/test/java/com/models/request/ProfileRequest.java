package com.models.request;

public class ProfileRequest {


    private String email;
    private String firstName;
    private String lastName;
    private String mobileNumber;

    // Default Constructor
    public ProfileRequest() {
    }

    // Parameterized Constructor
    public ProfileRequest( String email, String firstName, String lastName, String mobileNumber) {
   
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mobileNumber = mobileNumber;
    }

    // Getters

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    // Setters
  



    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    // toString method
    @Override
    public String toString() {
        return "ProfileRequest{" +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }

    public static class Builder{
        private String email;
        private String firstName;
        private String lastName;
        private String mobileNumber;




        public Builder Email(String email) {
            this.email = email;
            return this;
        }

        public Builder FirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder LastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder MobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public ProfileRequest build(){
            ProfileRequest profileRequest = new ProfileRequest(email, firstName, lastName, mobileNumber);
            return profileRequest;
        }
    }
}