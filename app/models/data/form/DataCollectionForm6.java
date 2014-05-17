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
public class DataCollectionForm6 extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private Integer patientIdNumber;

    @OneToMany
    private List<EconomicStatus> economicStatuses = new ArrayList<EconomicStatus>();

    private Double hip = 0.0;

    private Double waist = 0.0;

    private Double height = 0.0;

    private Double weight = 0.0;

    private Double bmi = 0.0;

    private YesNo bloodSampleTaken = YesNo.NO;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp bloodSampleDate;

    private String bloodSampleNumber = StringUtils.EMPTY;

    @Constraints.Required
    public Status status = Status.ACTIVE;

    @OneToOne
    private User createdBy;

    @OneToOne
    private User modifiedBy;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public DataCollectionForm6() {
    }

    public DataCollectionForm6(Integer patientIdNumber, Double hip, Double waist, Double height, Double weight, Double bmi, YesNo bloodSampleTaken, Timestamp bloodSampleDate, String bloodSampleNumber) {
        this.patientIdNumber = patientIdNumber;
        this.hip = hip;
        this.waist = waist;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.bloodSampleTaken = bloodSampleTaken;
        this.bloodSampleDate = bloodSampleDate;
        this.bloodSampleNumber = bloodSampleNumber;
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

    public List<EconomicStatus> getEconomicStatuses() {
        return economicStatuses;
    }

    public void setEconomicStatuses(List<EconomicStatus> economicStatuses) {
        this.economicStatuses = economicStatuses;
    }

    public Double getHip() {
        return hip;
    }

    public void setHip(Double hip) {
        this.hip = hip;
    }

    public Double getWaist() {
        return waist;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return bmi;
    }

    public void setBmi(Double bmi) {
        this.bmi = bmi;
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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Model.Finder<Long, DataCollectionForm6> find = new Model.Finder<Long, DataCollectionForm6>(
            Long.class, DataCollectionForm6.class
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
}
