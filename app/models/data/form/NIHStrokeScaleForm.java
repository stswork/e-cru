package models.data.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sagar Gopale on 5/3/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class NIHStrokeScaleForm extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private String parentIdentification;

    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateOfBirth;

    @Constraints.Required
    private String hospital;

    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp dateOfExam;

    @Constraints.Required
    private String interval;

    @Constraints.Required
    private String time;

    @Constraints.Required
    private String personAdministering;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public NIHStrokeScaleForm() {
    }

    public NIHStrokeScaleForm(String parentIdentification, Timestamp dateOfBirth, String hospital, Timestamp dateOfExam, String interval, String time, String personAdministering) {
        this.parentIdentification = parentIdentification;
        this.dateOfBirth = dateOfBirth;
        this.hospital = hospital;
        this.dateOfExam = dateOfExam;
        this.interval = interval;
        this.time = time;
        this.personAdministering = personAdministering;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentIdentification() {
        return parentIdentification;
    }

    public void setParentIdentification(String parentIdentification) {
        this.parentIdentification = parentIdentification;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public Timestamp getDateOfExam() {
        return dateOfExam;
    }

    public void setDateOfExam(Timestamp dateOfExam) {
        this.dateOfExam = dateOfExam;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPersonAdministering() {
        return personAdministering;
    }

    public void setPersonAdministering(String personAdministering) {
        this.personAdministering = personAdministering;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Finder<Long, NIHStrokeScaleForm> find = new Finder<Long, NIHStrokeScaleForm>(
            Long.class, NIHStrokeScaleForm.class
    );
}
