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
public class BarthelIndexForm extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private String protocolNumber = "InVeST";

    @Constraints.Required
    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp visitDate;

    @Constraints.Required
    private String subjectInitials;

    @Constraints.Required
    private Integer screeningNumber;

    @Constraints.Required
    private Integer centerNumber;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public BarthelIndexForm() {
    }

    public BarthelIndexForm(String protocolNumber, Timestamp visitDate, String subjectInitials, Integer screeningNumber, Integer centerNumber) {
        this.protocolNumber = protocolNumber;
        this.visitDate = visitDate;
        this.subjectInitials = subjectInitials;
        this.screeningNumber = screeningNumber;
        this.centerNumber = centerNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public Timestamp getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Timestamp visitDate) {
        this.visitDate = visitDate;
    }

    public String getSubjectInitials() {
        return subjectInitials;
    }

    public void setSubjectInitials(String subjectInitials) {
        this.subjectInitials = subjectInitials;
    }

    public Integer getScreeningNumber() {
        return screeningNumber;
    }

    public void setScreeningNumber(Integer screeningNumber) {
        this.screeningNumber = screeningNumber;
    }

    public Integer getCenterNumber() {
        return centerNumber;
    }

    public void setCenterNumber(Integer centerNumber) {
        this.centerNumber = centerNumber;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Finder<Long, BarthelIndexForm> find = new Finder<Long, BarthelIndexForm>(
            Long.class, BarthelIndexForm.class
    );
}
