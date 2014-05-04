package models.data.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.YesNo;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Sagar Gopale on 5/4/14.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCollectionForm4 extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private Integer patientIdNumber;

    @Constraints.Required
    private YesNo extracranialDopplersImagingDone = YesNo.NO;

    @Constraints.Required
    private YesNo extracranialMraImagingDone = YesNo.NO;

    @Constraints.Required
    private YesNo extracranialCtaImagingDone = YesNo.NO;

    @Constraints.Required
    private YesNo brainCtImagingDone = YesNo.NO;

    @Constraints.Required
    private YesNo brainMriImagingDone = YesNo.NO;

    private LesionLocation lesionLocation;

    private Double ricaStenosisPercent;

    private Double licaStenosisPercent;

    private Double rccaStenosisPercent;

    private Double lccaStenosisPercent;

    private Double rVertebralStenosisPercent;

    private Double lVertebralStenosisPercent;

    private Double basilarStenosisPercent;

    @Constraints.Required
    private YesNo lvd;

    @Constraints.Required
    private YesNo svd;

    @Constraints.Required
    private YesNo cardioembolism;

    @Constraints.Required
    private YesNo combined;

    @Constraints.Required
    private YesNo strokeOfDeterminedEtiology;

    @Constraints.Required
    private YesNo negativeEvaluation;

    @Constraints.Required
    private YesNo ecgDone;

    @Constraints.Required
    private YesNo echoDone;

    private Result ecgResult;

    private Result echoResult;

    private String nihssOnAdmission;

    private String nihssOnDischarge;

    private String barthelOnAdmission;

    private String barthelOnDischarge;

    @Constraints.Required
    private DischargePlace dischargePlace;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public DataCollectionForm4() {
    }

    public DataCollectionForm4(Integer patientIdNumber, YesNo extracranialDopplersImagingDone, YesNo extracranialMraImagingDone, YesNo extracranialCtaImagingDone, YesNo brainCtImagingDone, YesNo brainMriImagingDone, LesionLocation lesionLocation, Double ricaStenosisPercent, Double licaStenosisPercent, Double rccaStenosisPercent, Double lccaStenosisPercent, Double rVertebralStenosisPercent, Double lVertebralStenosisPercent, Double basilarStenosisPercent, YesNo lvd, YesNo svd, YesNo cardioembolism, YesNo combined, YesNo strokeOfDeterminedEtiology, YesNo negativeEvaluation, YesNo ecgDone, YesNo echoDone, Result ecgResult, Result echoResult, String nihssOnAdmission, String nihssOnDischarge, String barthelOnAdmission, String barthelOnDischarge, DischargePlace dischargePlace) {
        this.patientIdNumber = patientIdNumber;
        this.extracranialDopplersImagingDone = extracranialDopplersImagingDone;
        this.extracranialMraImagingDone = extracranialMraImagingDone;
        this.extracranialCtaImagingDone = extracranialCtaImagingDone;
        this.brainCtImagingDone = brainCtImagingDone;
        this.brainMriImagingDone = brainMriImagingDone;
        this.lesionLocation = lesionLocation;
        this.ricaStenosisPercent = ricaStenosisPercent;
        this.licaStenosisPercent = licaStenosisPercent;
        this.rccaStenosisPercent = rccaStenosisPercent;
        this.lccaStenosisPercent = lccaStenosisPercent;
        this.rVertebralStenosisPercent = rVertebralStenosisPercent;
        this.lVertebralStenosisPercent = lVertebralStenosisPercent;
        this.basilarStenosisPercent = basilarStenosisPercent;
        this.lvd = lvd;
        this.svd = svd;
        this.cardioembolism = cardioembolism;
        this.combined = combined;
        this.strokeOfDeterminedEtiology = strokeOfDeterminedEtiology;
        this.negativeEvaluation = negativeEvaluation;
        this.ecgDone = ecgDone;
        this.echoDone = echoDone;
        this.ecgResult = ecgResult;
        this.echoResult = echoResult;
        this.nihssOnAdmission = nihssOnAdmission;
        this.nihssOnDischarge = nihssOnDischarge;
        this.barthelOnAdmission = barthelOnAdmission;
        this.barthelOnDischarge = barthelOnDischarge;
        this.dischargePlace = dischargePlace;
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

    public YesNo getExtracranialDopplersImagingDone() {
        return extracranialDopplersImagingDone;
    }

    public void setExtracranialDopplersImagingDone(YesNo extracranialDopplersImagingDone) {
        this.extracranialDopplersImagingDone = extracranialDopplersImagingDone;
    }

    public YesNo getExtracranialMraImagingDone() {
        return extracranialMraImagingDone;
    }

    public void setExtracranialMraImagingDone(YesNo extracranialMraImagingDone) {
        this.extracranialMraImagingDone = extracranialMraImagingDone;
    }

    public YesNo getExtracranialCtaImagingDone() {
        return extracranialCtaImagingDone;
    }

    public void setExtracranialCtaImagingDone(YesNo extracranialCtaImagingDone) {
        this.extracranialCtaImagingDone = extracranialCtaImagingDone;
    }

    public YesNo getBrainCtImagingDone() {
        return brainCtImagingDone;
    }

    public void setBrainCtImagingDone(YesNo brainCtImagingDone) {
        this.brainCtImagingDone = brainCtImagingDone;
    }

    public YesNo getBrainMriImagingDone() {
        return brainMriImagingDone;
    }

    public void setBrainMriImagingDone(YesNo brainMriImagingDone) {
        this.brainMriImagingDone = brainMriImagingDone;
    }

    public LesionLocation getLesionLocation() {
        return lesionLocation;
    }

    public void setLesionLocation(LesionLocation lesionLocation) {
        this.lesionLocation = lesionLocation;
    }

    public Double getRicaStenosisPercent() {
        return ricaStenosisPercent;
    }

    public void setRicaStenosisPercent(Double ricaStenosisPercent) {
        this.ricaStenosisPercent = ricaStenosisPercent;
    }

    public Double getLicaStenosisPercent() {
        return licaStenosisPercent;
    }

    public void setLicaStenosisPercent(Double licaStenosisPercent) {
        this.licaStenosisPercent = licaStenosisPercent;
    }

    public Double getRccaStenosisPercent() {
        return rccaStenosisPercent;
    }

    public void setRccaStenosisPercent(Double rccaStenosisPercent) {
        this.rccaStenosisPercent = rccaStenosisPercent;
    }

    public Double getLccaStenosisPercent() {
        return lccaStenosisPercent;
    }

    public void setLccaStenosisPercent(Double lccaStenosisPercent) {
        this.lccaStenosisPercent = lccaStenosisPercent;
    }

    public Double getrVertebralStenosisPercent() {
        return rVertebralStenosisPercent;
    }

    public void setrVertebralStenosisPercent(Double rVertebralStenosisPercent) {
        this.rVertebralStenosisPercent = rVertebralStenosisPercent;
    }

    public Double getlVertebralStenosisPercent() {
        return lVertebralStenosisPercent;
    }

    public void setlVertebralStenosisPercent(Double lVertebralStenosisPercent) {
        this.lVertebralStenosisPercent = lVertebralStenosisPercent;
    }

    public Double getBasilarStenosisPercent() {
        return basilarStenosisPercent;
    }

    public void setBasilarStenosisPercent(Double basilarStenosisPercent) {
        this.basilarStenosisPercent = basilarStenosisPercent;
    }

    public YesNo getLvd() {
        return lvd;
    }

    public void setLvd(YesNo lvd) {
        this.lvd = lvd;
    }

    public YesNo getSvd() {
        return svd;
    }

    public void setSvd(YesNo svd) {
        this.svd = svd;
    }

    public YesNo getCardioembolism() {
        return cardioembolism;
    }

    public void setCardioembolism(YesNo cardioembolism) {
        this.cardioembolism = cardioembolism;
    }

    public YesNo getCombined() {
        return combined;
    }

    public void setCombined(YesNo combined) {
        this.combined = combined;
    }

    public YesNo getStrokeOfDeterminedEtiology() {
        return strokeOfDeterminedEtiology;
    }

    public void setStrokeOfDeterminedEtiology(YesNo strokeOfDeterminedEtiology) {
        this.strokeOfDeterminedEtiology = strokeOfDeterminedEtiology;
    }

    public YesNo getNegativeEvaluation() {
        return negativeEvaluation;
    }

    public void setNegativeEvaluation(YesNo negativeEvaluation) {
        this.negativeEvaluation = negativeEvaluation;
    }

    public YesNo getEcgDone() {
        return ecgDone;
    }

    public void setEcgDone(YesNo ecgDone) {
        this.ecgDone = ecgDone;
    }

    public YesNo getEchoDone() {
        return echoDone;
    }

    public void setEchoDone(YesNo echoDone) {
        this.echoDone = echoDone;
    }

    public Result getEcgResult() {
        return ecgResult;
    }

    public void setEcgResult(Result ecgResult) {
        this.ecgResult = ecgResult;
    }

    public Result getEchoResult() {
        return echoResult;
    }

    public void setEchoResult(Result echoResult) {
        this.echoResult = echoResult;
    }

    public String getNihssOnAdmission() {
        return nihssOnAdmission;
    }

    public void setNihssOnAdmission(String nihssOnAdmission) {
        this.nihssOnAdmission = nihssOnAdmission;
    }

    public String getNihssOnDischarge() {
        return nihssOnDischarge;
    }

    public void setNihssOnDischarge(String nihssOnDischarge) {
        this.nihssOnDischarge = nihssOnDischarge;
    }

    public String getBarthelOnAdmission() {
        return barthelOnAdmission;
    }

    public void setBarthelOnAdmission(String barthelOnAdmission) {
        this.barthelOnAdmission = barthelOnAdmission;
    }

    public String getBarthelOnDischarge() {
        return barthelOnDischarge;
    }

    public void setBarthelOnDischarge(String barthelOnDischarge) {
        this.barthelOnDischarge = barthelOnDischarge;
    }

    public DischargePlace getDischargePlace() {
        return dischargePlace;
    }

    public void setDischargePlace(DischargePlace dischargePlace) {
        this.dischargePlace = dischargePlace;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Model.Finder<Long, DataCollectionForm4> find = new Model.Finder<Long, DataCollectionForm4>(
            Long.class, DataCollectionForm4.class
    );
}
