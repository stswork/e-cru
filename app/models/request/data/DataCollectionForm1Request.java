package models.request.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.YesNo;
import models.data.form.EconomicStatus;
import models.data.form.Gender;
import play.data.format.Formats;
import play.data.validation.Constraints;

import javax.persistence.OneToMany;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagar Gopale on 5/5/14.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCollectionForm1Request {

    private Long id;
    private Integer patientIdNumber;
    private String trialSite;
    private Integer dateRecruited;
    private Integer dateRecruitedMonth;
    private Integer dateRecruitedYear;
    private String patientName;
    private Integer patientDobDate;
    private Integer patientDobMonth;
    private Integer patientDobYear;
    private String[] economicStatus;
    private String bloodSampleTaken;
    private Integer bloodSampleDate;
    private Integer bloodSampleMonth;
    private Integer bloodSampleYear;
    private String bloodSampleNumber;
    private Integer strokeDate;
    private Integer strokeMonth;
    private Integer strokeYear;
}
