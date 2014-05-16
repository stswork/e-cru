package models.data.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.YesNo;
import models.user.User;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagar Gopale on 5/4/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCollectionForm1 extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private Integer patientIdNumber;

    @Constraints.Required
    private String trialSite;

    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp recruitedDate;

    @Constraints.Required
    private String patientName;

    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateOfBirth;

    @Constraints.Required
    private String patientAddress;

    @Constraints.Required
    private Gender gender;

    private String landlinePhoneNumber;

    private String cellPhoneNumber;

    private String friendRelativePhoneNumber;

    @Constraints.Required
    private String placeOfBirth;

    @Constraints.Required
    private String ethnicity;

    @Constraints.Required
    private String nativeLanguage;

    @Constraints.Required
    private String religion;

    @OneToMany
    private List<EconomicStatus> economicStatuses = new ArrayList<EconomicStatus>();

    @Constraints.Required
    private YesNo bloodSampleTaken = YesNo.NO;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp bloodSampleDate;

    @Constraints.Required
    private String bloodSampleNumber;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateOfStroke;

    @OneToOne
    private User createdBy;

    @OneToOne
    private User modifiedBy;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public DataCollectionForm1() {
    }

    public DataCollectionForm1(Integer patientIdNumber, String trialSite, Timestamp recruitedDate, String patientName, Timestamp dateOfBirth, String patientAddress, Gender gender, String landlinePhoneNumber, String cellPhoneNumber, String friendRelativePhoneNumber, String placeOfBirth, String ethnicity, String nativeLanguage, String religion, YesNo bloodSampleTaken, Timestamp bloodSampleDate, String bloodSampleNumber, Timestamp dateOfStroke) {
        this.patientIdNumber = patientIdNumber;
        this.trialSite = trialSite;
        this.recruitedDate = recruitedDate;
        this.patientName = patientName;
        this.dateOfBirth = dateOfBirth;
        this.patientAddress = patientAddress;
        this.gender = gender;
        this.landlinePhoneNumber = landlinePhoneNumber;
        this.cellPhoneNumber = cellPhoneNumber;
        this.friendRelativePhoneNumber = friendRelativePhoneNumber;
        this.placeOfBirth = placeOfBirth;
        this.ethnicity = ethnicity;
        this.nativeLanguage = nativeLanguage;
        this.religion = religion;
        this.bloodSampleTaken = bloodSampleTaken;
        this.bloodSampleDate = bloodSampleDate;
        this.bloodSampleNumber = bloodSampleNumber;
        this.dateOfStroke = dateOfStroke;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPatientIdNumber() {
        return patientIdNumber;
    }

    public void setPatientIdNumber(Integer patientIdNumber) {
        this.patientIdNumber = patientIdNumber;
    }

    public String getTrialSite() {
        return trialSite;
    }

    public void setTrialSite(String trialSite) {
        this.trialSite = trialSite;
    }

    public Timestamp getRecruitedDate() {
        return recruitedDate;
    }

    public void setRecruitedDate(Timestamp recruitedDate) {
        this.recruitedDate = recruitedDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPatientAddress() {
        return patientAddress;
    }

    public void setPatientAddress(String patientAddress) {
        this.patientAddress = patientAddress;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLandlinePhoneNumber() {
        return landlinePhoneNumber;
    }

    public void setLandlinePhoneNumber(String landlinePhoneNumber) {
        this.landlinePhoneNumber = landlinePhoneNumber;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getFriendRelativePhoneNumber() {
        return friendRelativePhoneNumber;
    }

    public void setFriendRelativePhoneNumber(String friendRelativePhoneNumber) {
        this.friendRelativePhoneNumber = friendRelativePhoneNumber;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public String getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity;
    }

    public String getNativeLanguage() {
        return nativeLanguage;
    }

    public void setNativeLanguage(String nativeLanguage) {
        this.nativeLanguage = nativeLanguage;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public List<EconomicStatus> getEconomicStatuses() {
        return economicStatuses;
    }

    public void setEconomicStatuses(List<EconomicStatus> economicStatuses) {
        this.economicStatuses = economicStatuses;
    }

    public YesNo getBloodSampleTaken() {
        return bloodSampleTaken;
    }

    public void setBloodSampleTaken(YesNo bloodSampleTaken) {
        this.bloodSampleTaken = bloodSampleTaken;
    }

    public Timestamp getBloodSampleDate() {
        return bloodSampleDate;
    }

    public void setBloodSampleDate(Timestamp bloodSampleDate) {
        this.bloodSampleDate = bloodSampleDate;
    }

    public String getBloodSampleNumber() {
        return bloodSampleNumber;
    }

    public void setBloodSampleNumber(String bloodSampleNumber) {
        this.bloodSampleNumber = bloodSampleNumber;
    }

    public Timestamp getDateOfStroke() {
        return dateOfStroke;
    }

    public void setDateOfStroke(Timestamp dateOfStroke) {
        this.dateOfStroke = dateOfStroke;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Model.Finder<Long, DataCollectionForm1> find = new Model.Finder<Long, DataCollectionForm1>(
            Long.class, DataCollectionForm1.class
    );

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(User modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
}
