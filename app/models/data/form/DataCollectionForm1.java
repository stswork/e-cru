package models.data.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.Status;
import models.YesNo;
import models.user.User;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
    private Long patientIdNumber;

    @Constraints.Required
    private String trialSite = StringUtils.EMPTY;

    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp recruitedDate;

    @Constraints.Required
    private String patientName = StringUtils.EMPTY;

    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateOfBirth;

    @Constraints.Required
    private String patientAddress = StringUtils.EMPTY;

    @Constraints.Required
    private Gender gender;

    private String landlinePhoneNumber = StringUtils.EMPTY;

    private String cellPhoneNumber = StringUtils.EMPTY;

    private String friendRelativePhoneNumber = StringUtils.EMPTY;

    private String placeOfBirth = StringUtils.EMPTY;

    private String ethnicity = StringUtils.EMPTY;

    private String nativeLanguage = StringUtils.EMPTY;

    private String religion = StringUtils.EMPTY;

    @OneToMany
    private List<EconomicStatus> economicStatuses = new ArrayList<EconomicStatus>();

    @Constraints.Required
    private YesNo bloodSampleTaken = YesNo.NO;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp bloodSampleDate;

    private String bloodSampleNumber = StringUtils.EMPTY;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateOfStroke;

    @Constraints.Required
    public Status status = Status.ACTIVE;

    @OneToOne
    private User createdBy;

    @OneToOne
    private User modifiedBy;

    @OneToOne
    private DataCollectionForm2 dataCollectionForm2;

    @OneToOne
    private DataCollectionForm3 dataCollectionForm3;

    @OneToOne
    private DataCollectionForm4 dataCollectionForm4;

    @OneToOne
    private DataCollectionForm5 dataCollectionForm5;

    @OneToOne
    private DataCollectionForm6 dataCollectionForm6;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public DataCollectionForm1() {
    }

    public DataCollectionForm1(Long patientIdNumber, String trialSite, Timestamp recruitedDate, String patientName, Timestamp dateOfBirth, String patientAddress, Gender gender, String landlinePhoneNumber, String cellPhoneNumber, String friendRelativePhoneNumber, String placeOfBirth, String ethnicity, String nativeLanguage, String religion, YesNo bloodSampleTaken, Timestamp bloodSampleDate, String bloodSampleNumber, Timestamp dateOfStroke) {
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

    public Long getPatientIdNumber() {
        return patientIdNumber;
    }

    public void setPatientIdNumber(Long patientIdNumber) {
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

    public String getRecruitedDateString() {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("MM/dd/yyyy");
        return recruitedDate == null ? StringUtils.EMPTY : DATE_TIME_FORMATTER.print(recruitedDate.getTime());
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

    public String getDateOfBirthString() {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("MM/dd/yyyy");
        return dateOfBirth == null ? StringUtils.EMPTY : DATE_TIME_FORMATTER.print(dateOfBirth.getTime());
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

    public String getBloodSampleDateString() {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("MM/dd/yyyy");
        return bloodSampleDate == null ? StringUtils.EMPTY : DATE_TIME_FORMATTER.print(bloodSampleDate.getTime());
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

    public String getDateOfStrokeString() {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("MM/dd/yyyy");
        return dateOfStroke == null ? StringUtils.EMPTY : DATE_TIME_FORMATTER.print(dateOfStroke.getTime());
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public DataCollectionForm2 getDataCollectionForm2() {
        return dataCollectionForm2;
    }

    public void setDataCollectionForm2(DataCollectionForm2 dataCollectionForm2) {
        this.dataCollectionForm2 = dataCollectionForm2;
    }

    public DataCollectionForm3 getDataCollectionForm3() {
        return dataCollectionForm3;
    }

    public void setDataCollectionForm3(DataCollectionForm3 dataCollectionForm3) {
        this.dataCollectionForm3 = dataCollectionForm3;
    }

    public DataCollectionForm4 getDataCollectionForm4() {
        return dataCollectionForm4;
    }

    public void setDataCollectionForm4(DataCollectionForm4 dataCollectionForm4) {
        this.dataCollectionForm4 = dataCollectionForm4;
    }

    public DataCollectionForm5 getDataCollectionForm5() {
        return dataCollectionForm5;
    }

    public void setDataCollectionForm5(DataCollectionForm5 dataCollectionForm5) {
        this.dataCollectionForm5 = dataCollectionForm5;
    }

    public DataCollectionForm6 getDataCollectionForm6() {
        return dataCollectionForm6;
    }

    public void setDataCollectionForm6(DataCollectionForm6 dataCollectionForm6) {
        this.dataCollectionForm6 = dataCollectionForm6;
    }
}
