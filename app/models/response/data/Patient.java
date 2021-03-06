package models.response.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sagar Gopale on 5/16/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Patient {

    public Long id;
    public Long patientId;
    public String patientName;
    public String trialSite;
    public String dateOfBirth;
    public String gender;
    public String createdOn;

    public Patient() {
    }

    public Patient(Long id, Long patientId, String patientName, String trialSite, String dateOfBirth, String gender, String createdOn) {
        this.id = id;
        this.patientId = patientId;
        this.patientName = patientName;
        this.trialSite = trialSite;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.createdOn = createdOn;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getTrialSite() {
        return trialSite;
    }

    public void setTrialSite(String trialSite) {
        this.trialSite = trialSite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
