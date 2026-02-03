package com.forms;



public class User {

	private PersonalInfo personalInfo;



    // --- Address Info ---

    private AddressInfo addressInfo;



    // --- Education Info ---

    private EducationInfo educationInfo;
    public PersonalInfo getPersonalInfo() {

        return personalInfo;

    }



    public void setPersonalInfo(PersonalInfo personalInfo) {

        this.personalInfo = personalInfo;

    }



    public AddressInfo getAddressInfo() {

        return addressInfo;

    }
    public void setAddressInfo(AddressInfo addressInfo) {

        this.addressInfo = addressInfo;

    }



    public EducationInfo getEducationInfo() {

        return educationInfo;

    }



    public void setEducationInfo(EducationInfo educationInfo) {

        this.educationInfo = educationInfo;

    }

}