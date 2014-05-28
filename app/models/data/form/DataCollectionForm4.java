package models.data.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.Status;
import models.YesNo;
import models.user.User;
import org.apache.commons.lang3.StringUtils;
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
    private Long patientIdNumber;

    @Constraints.Required
    private YesNo intracranialStenosis = YesNo.NO;

    private String intracranialStenosisPercent = StringUtils.EMPTY;

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

    @Constraints.Required
    private YesNo lesionAnterior = YesNo.NO;

    @Constraints.Required
    private YesNo lesionRight = YesNo.NO;

    @Constraints.Required
    private YesNo lesionLeft = YesNo.NO;

    @Constraints.Required
    private YesNo lesionBilateral = YesNo.NO;

    @Constraints.Required
    private YesNo lesionPosterior = YesNo.NO;

    @Constraints.Required
    private YesNo lesionAnterioposterior = YesNo.NO;

    private Double ricaStenosisPercent = 0.0;

    private Double licaStenosisPercent = 0.0;

    private Double rccaStenosisPercent = 0.0;

    private Double lccaStenosisPercent = 0.0;

    private Double rVertebralStenosisPercent = 0.0;

    private Double lVertebralStenosisPercent = 0.0;

    private Double basilarStenosisPercent = 0.0;

    @Constraints.Required
    private YesNo lvd = YesNo.NO;

    @Constraints.Required
    private YesNo svd = YesNo.NO;

    @Constraints.Required
    private YesNo cardioembolism = YesNo.NO;

    @Constraints.Required
    private YesNo combined = YesNo.NO;

    @Constraints.Required
    private YesNo strokeOfDeterminedEtiology = YesNo.NO;

    @Constraints.Required
    private YesNo negativeEvaluation = YesNo.NO;

    @Constraints.Required
    private YesNo ecgDone = YesNo.NO;

    @Constraints.Required
    private YesNo echoDone = YesNo.NO;

    @Constraints.Required
    private YesNo ecgNormal = YesNo.NO;

    @Constraints.Required
    private YesNo ecgLvh = YesNo.NO;

    @Constraints.Required
    private YesNo ecgAf = YesNo.NO;

    @Constraints.Required
    private YesNo ecgVentricularEctopics = YesNo.NO;

    @Constraints.Required
    private YesNo ecgArtialEctopics = YesNo.NO;

    @Constraints.Required
    private YesNo ecgNoneOfAbove = YesNo.NO;

    @Constraints.Required
    private YesNo echoNormal = YesNo.NO;

    @Constraints.Required
    private YesNo echoLvh = YesNo.NO;

    @Constraints.Required
    private YesNo echoPfo = YesNo.NO;

    @Constraints.Required
    private YesNo echoThrombus = YesNo.NO;

    @Constraints.Required
    private YesNo echoNoneOfAbove = YesNo.NO;

    @Constraints.Required
    private YesNo echoDontKnow = YesNo.NO;

    @Constraints.Required
    private YesNo ecgDontKnow = YesNo.NO;

    private String nihssOnAdmission = StringUtils.EMPTY;

    private String nihssOnDischarge = StringUtils.EMPTY;

    private String barthelOnAdmission = StringUtils.EMPTY;

    private String barthelOnDischarge = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo home = YesNo.NO;

    @Constraints.Required
    private YesNo nursingHome = YesNo.NO;

    @Constraints.Required
    private YesNo rehabilitation = YesNo.NO;

    @Constraints.Required
    private YesNo rip = YesNo.NO;

    @Constraints.Required
    private YesNo localDgh = YesNo.NO;

    @Constraints.Required
    public Status status = Status.ACTIVE;

    @OneToOne
    private User createdBy;

    @OneToOne
    private User modifiedBy;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public DataCollectionForm4() {
    }

    public DataCollectionForm4(Long patientIdNumber, YesNo intracranialStenosis, String intracranialStenosisPercent, YesNo extracranialDopplersImagingDone, YesNo extracranialMraImagingDone, YesNo extracranialCtaImagingDone, YesNo brainCtImagingDone, YesNo brainMriImagingDone, YesNo lesionAnterior, YesNo lesionRight, YesNo lesionLeft, YesNo lesionBilateral, YesNo lesionPosterior, YesNo lesionAnterioposterior, Double ricaStenosisPercent, Double licaStenosisPercent, Double rccaStenosisPercent, Double lccaStenosisPercent, Double rVertebralStenosisPercent, Double lVertebralStenosisPercent, Double basilarStenosisPercent, YesNo lvd, YesNo svd, YesNo cardioembolism, YesNo combined, YesNo strokeOfDeterminedEtiology, YesNo negativeEvaluation, YesNo ecgDone, YesNo echoDone, YesNo ecgNormal, YesNo ecgLvh, YesNo ecgAf, YesNo ecgVentricularEctopics, YesNo ecgArtialEctopics, YesNo ecgNoneOfAbove, YesNo echoNormal, YesNo echoLvh, YesNo echoPfo, YesNo echoThrombus, YesNo echoNoneOfAbove, YesNo echoDontKnow, YesNo ecgDontKnow, String nihssOnAdmission, String nihssOnDischarge, String barthelOnAdmission, String barthelOnDischarge, YesNo home, YesNo nursingHome, YesNo rehabilitation, YesNo rip, YesNo localDgh) {
        this.patientIdNumber = patientIdNumber;
        this.intracranialStenosis = intracranialStenosis;
        this.intracranialStenosisPercent = intracranialStenosisPercent;
        this.extracranialDopplersImagingDone = extracranialDopplersImagingDone;
        this.extracranialMraImagingDone = extracranialMraImagingDone;
        this.extracranialCtaImagingDone = extracranialCtaImagingDone;
        this.brainCtImagingDone = brainCtImagingDone;
        this.brainMriImagingDone = brainMriImagingDone;
        this.lesionAnterior = lesionAnterior;
        this.lesionRight = lesionRight;
        this.lesionLeft = lesionLeft;
        this.lesionBilateral = lesionBilateral;
        this.lesionPosterior = lesionPosterior;
        this.lesionAnterioposterior = lesionAnterioposterior;
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
        this.ecgNormal = ecgNormal;
        this.ecgLvh = ecgLvh;
        this.ecgAf = ecgAf;
        this.ecgVentricularEctopics = ecgVentricularEctopics;
        this.ecgArtialEctopics = ecgArtialEctopics;
        this.ecgNoneOfAbove = ecgNoneOfAbove;
        this.echoNormal = echoNormal;
        this.echoLvh = echoLvh;
        this.echoPfo = echoPfo;
        this.echoThrombus = echoThrombus;
        this.echoNoneOfAbove = echoNoneOfAbove;
        this.echoDontKnow = echoDontKnow;
        this.ecgDontKnow = ecgDontKnow;
        this.nihssOnAdmission = nihssOnAdmission;
        this.nihssOnDischarge = nihssOnDischarge;
        this.barthelOnAdmission = barthelOnAdmission;
        this.barthelOnDischarge = barthelOnDischarge;
        this.home = home;
        this.nursingHome = nursingHome;
        this.rehabilitation = rehabilitation;
        this.rip = rip;
        this.localDgh = localDgh;
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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Model.Finder<Long, DataCollectionForm4> find = new Model.Finder<Long, DataCollectionForm4>(
            Long.class, DataCollectionForm4.class
    );

    public YesNo getIntracranialStenosis() {
        return intracranialStenosis;
    }

    public void setIntracranialStenosis(YesNo intracranialStenosis) {
        this.intracranialStenosis = intracranialStenosis;
    }

    public String getIntracranialStenosisPercent() {
        return intracranialStenosisPercent;
    }

    public void setIntracranialStenosisPercent(String intracranialStenosisPercent) {
        this.intracranialStenosisPercent = intracranialStenosisPercent;
    }

    public YesNo getLesionAnterior() {
        return lesionAnterior;
    }

    public void setLesionAnterior(YesNo lesionAnterior) {
        this.lesionAnterior = lesionAnterior;
    }

    public YesNo getLesionRight() {
        return lesionRight;
    }

    public void setLesionRight(YesNo lesionRight) {
        this.lesionRight = lesionRight;
    }

    public YesNo getLesionLeft() {
        return lesionLeft;
    }

    public void setLesionLeft(YesNo lesionLeft) {
        this.lesionLeft = lesionLeft;
    }

    public YesNo getLesionBilateral() {
        return lesionBilateral;
    }

    public void setLesionBilateral(YesNo lesionBilateral) {
        this.lesionBilateral = lesionBilateral;
    }

    public YesNo getLesionPosterior() {
        return lesionPosterior;
    }

    public void setLesionPosterior(YesNo lesionPosterior) {
        this.lesionPosterior = lesionPosterior;
    }

    public YesNo getLesionAnterioposterior() {
        return lesionAnterioposterior;
    }

    public void setLesionAnterioposterior(YesNo lesionAnterioposterior) {
        this.lesionAnterioposterior = lesionAnterioposterior;
    }

    public YesNo getEcgNormal() {
        return ecgNormal;
    }

    public void setEcgNormal(YesNo ecgNormal) {
        this.ecgNormal = ecgNormal;
    }

    public YesNo getEcgLvh() {
        return ecgLvh;
    }

    public void setEcgLvh(YesNo ecgLvh) {
        this.ecgLvh = ecgLvh;
    }

    public YesNo getEcgAf() {
        return ecgAf;
    }

    public void setEcgAf(YesNo ecgAf) {
        this.ecgAf = ecgAf;
    }

    public YesNo getEcgVentricularEctopics() {
        return ecgVentricularEctopics;
    }

    public void setEcgVentricularEctopics(YesNo ecgVentricularEctopics) {
        this.ecgVentricularEctopics = ecgVentricularEctopics;
    }

    public YesNo getEcgArtialEctopics() {
        return ecgArtialEctopics;
    }

    public void setEcgArtialEctopics(YesNo ecgArtialEctopics) {
        this.ecgArtialEctopics = ecgArtialEctopics;
    }

    public YesNo getEcgNoneOfAbove() {
        return ecgNoneOfAbove;
    }

    public void setEcgNoneOfAbove(YesNo ecgNoneOfAbove) {
        this.ecgNoneOfAbove = ecgNoneOfAbove;
    }

    public YesNo getEcgDontKnow() {
        return ecgDontKnow;
    }

    public void setEcgDontKnow(YesNo ecgDontKnow) {
        this.ecgDontKnow = ecgDontKnow;
    }

    public YesNo getEchoNormal() {
        return echoNormal;
    }

    public void setEchoNormal(YesNo echoNormal) {
        this.echoNormal = echoNormal;
    }

    public YesNo getEchoLvh() {
        return echoLvh;
    }

    public void setEchoLvh(YesNo echoLvh) {
        this.echoLvh = echoLvh;
    }

    public YesNo getEchoPfo() {
        return echoPfo;
    }

    public void setEchoPfo(YesNo echoPfo) {
        this.echoPfo = echoPfo;
    }

    public YesNo getEchoThrombus() {
        return echoThrombus;
    }

    public void setEchoThrombus(YesNo echoThrombus) {
        this.echoThrombus = echoThrombus;
    }

    public YesNo getEchoNoneOfAbove() {
        return echoNoneOfAbove;
    }

    public void setEchoNoneOfAbove(YesNo echoNoneOfAbove) {
        this.echoNoneOfAbove = echoNoneOfAbove;
    }

    public YesNo getEchoDontKnow() {
        return echoDontKnow;
    }

    public void setEchoDontKnow(YesNo echoDontKnow) {
        this.echoDontKnow = echoDontKnow;
    }

    public YesNo getHome() {
        return home;
    }

    public void setHome(YesNo home) {
        this.home = home;
    }

    public YesNo getNursingHome() {
        return nursingHome;
    }

    public void setNursingHome(YesNo nursingHome) {
        this.nursingHome = nursingHome;
    }

    public YesNo getRehabilitation() {
        return rehabilitation;
    }

    public void setRehabilitation(YesNo rehabilitation) {
        this.rehabilitation = rehabilitation;
    }

    public YesNo getRip() {
        return rip;
    }

    public void setRip(YesNo rip) {
        this.rip = rip;
    }

    public YesNo getLocalDgh() {
        return localDgh;
    }

    public void setLocalDgh(YesNo localDgh) {
        this.localDgh = localDgh;
    }

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
