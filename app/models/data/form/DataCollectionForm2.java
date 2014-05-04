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
public class DataCollectionForm2 extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private Integer patientIdNumber;

    @Constraints.Required
    private YesNo ischaemicStroke = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo hoemorrhagicStroke = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo venousSinusThrombosis = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo tia = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo avm = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo aneurysm = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo subaranchoid = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo hypertension = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo diabetesMellitus = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo ihdAngina = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo hypercholesterolemia = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo atrialFibrillation = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo pvd = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo mi = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo migraineWithAura = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo migraineWithoutAura = YesNo.DONT_KNOW;

    private Integer ischaemicStrokeYear;

    private Integer hoemorrhagicStrokeYear;

    private Integer tiaYear;

    @Constraints.Required
    private YesNo strokeAssociatedWithDissection = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo strokeAssociatedWithPfo = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo strokeAssociatedWithMi = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo familyStroke = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo familyIhdAngina = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo familyDiabetesMellitus = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo familyMi = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo familyPvd = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo familyHypertension = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo familyNoneOfTheAbove = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo currentSmoker = YesNo.DONT_KNOW;

    private Integer cigarettePerDay = 0;

    @Constraints.Required
    private YesNo exSmoker = YesNo.DONT_KNOW;

    @Constraints.Required
    private YesNo never = YesNo.DONT_KNOW;

    @Constraints.Required
    private Double hip;

    @Constraints.Required
    private Double waist;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public DataCollectionForm2() {
    }

    public DataCollectionForm2(Integer patientIdNumber, YesNo ischaemicStroke, YesNo hoemorrhagicStroke, YesNo venousSinusThrombosis, YesNo tia, YesNo avm, YesNo aneurysm, YesNo subaranchoid, YesNo hypertension, YesNo diabetesMellitus, YesNo ihdAngina, YesNo hypercholesterolemia, YesNo atrialFibrillation, YesNo pvd, YesNo mi, YesNo migraineWithAura, YesNo migraineWithoutAura, Integer ischaemicStrokeYear, Integer hoemorrhagicStrokeYear, Integer tiaYear, YesNo strokeAssociatedWithDissection, YesNo strokeAssociatedWithPfo, YesNo strokeAssociatedWithMi, YesNo familyStroke, YesNo familyIhdAngina, YesNo familyDiabetesMellitus, YesNo familyMi, YesNo familyPvd, YesNo familyHypertension, YesNo familyNoneOfTheAbove, YesNo currentSmoker, Integer cigarettePerDay, YesNo exSmoker, YesNo never, Double hip, Double waist, Integer alcoholUnitsPerWeek, Double height, Double weight, Double bmi, String aspirinDosage, String clopidogrelDosage, String aspirinPlusClopidogrelDosage, String dipyridamoleDosage, String aspirinPlusDipyridamoleDosage, String warfarinInr, String statinDosage, String statinName, YesNo antihypertensive, YesNo medicineNoneOfTheAbove, String bpOnAdmission, String temperatureOnAdmission, YesNo carotidEndarterectomyDone, YesNo thrombolysedDone, YesNo ctaDone, YesNo mraDone, YesNo angiogramDone) {
        this.patientIdNumber = patientIdNumber;
        this.ischaemicStroke = ischaemicStroke;
        this.hoemorrhagicStroke = hoemorrhagicStroke;
        this.venousSinusThrombosis = venousSinusThrombosis;
        this.tia = tia;
        this.avm = avm;
        this.aneurysm = aneurysm;
        this.subaranchoid = subaranchoid;
        this.hypertension = hypertension;
        this.diabetesMellitus = diabetesMellitus;
        this.ihdAngina = ihdAngina;
        this.hypercholesterolemia = hypercholesterolemia;
        this.atrialFibrillation = atrialFibrillation;
        this.pvd = pvd;
        this.mi = mi;
        this.migraineWithAura = migraineWithAura;
        this.migraineWithoutAura = migraineWithoutAura;
        this.ischaemicStrokeYear = ischaemicStrokeYear;
        this.hoemorrhagicStrokeYear = hoemorrhagicStrokeYear;
        this.tiaYear = tiaYear;
        this.strokeAssociatedWithDissection = strokeAssociatedWithDissection;
        this.strokeAssociatedWithPfo = strokeAssociatedWithPfo;
        this.strokeAssociatedWithMi = strokeAssociatedWithMi;
        this.familyStroke = familyStroke;
        this.familyIhdAngina = familyIhdAngina;
        this.familyDiabetesMellitus = familyDiabetesMellitus;
        this.familyMi = familyMi;
        this.familyPvd = familyPvd;
        this.familyHypertension = familyHypertension;
        this.familyNoneOfTheAbove = familyNoneOfTheAbove;
        this.currentSmoker = currentSmoker;
        this.cigarettePerDay = cigarettePerDay;
        this.exSmoker = exSmoker;
        this.never = never;
        this.hip = hip;
        this.waist = waist;
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

    public YesNo getIschaemicStroke() {
        return ischaemicStroke;
    }

    public void setIschaemicStroke(YesNo ischaemicStroke) {
        this.ischaemicStroke = ischaemicStroke;
    }

    public YesNo getHoemorrhagicStroke() {
        return hoemorrhagicStroke;
    }

    public void setHoemorrhagicStroke(YesNo hoemorrhagicStroke) {
        this.hoemorrhagicStroke = hoemorrhagicStroke;
    }

    public YesNo getVenousSinusThrombosis() {
        return venousSinusThrombosis;
    }

    public void setVenousSinusThrombosis(YesNo venousSinusThrombosis) {
        this.venousSinusThrombosis = venousSinusThrombosis;
    }

    public YesNo getTia() {
        return tia;
    }

    public void setTia(YesNo tia) {
        this.tia = tia;
    }

    public YesNo getAvm() {
        return avm;
    }

    public void setAvm(YesNo avm) {
        this.avm = avm;
    }

    public YesNo getAneurysm() {
        return aneurysm;
    }

    public void setAneurysm(YesNo aneurysm) {
        this.aneurysm = aneurysm;
    }

    public YesNo getSubaranchoid() {
        return subaranchoid;
    }

    public void setSubaranchoid(YesNo subaranchoid) {
        this.subaranchoid = subaranchoid;
    }

    public YesNo getHypertension() {
        return hypertension;
    }

    public void setHypertension(YesNo hypertension) {
        this.hypertension = hypertension;
    }

    public YesNo getDiabetesMellitus() {
        return diabetesMellitus;
    }

    public void setDiabetesMellitus(YesNo diabetesMellitus) {
        this.diabetesMellitus = diabetesMellitus;
    }

    public YesNo getIhdAngina() {
        return ihdAngina;
    }

    public void setIhdAngina(YesNo ihdAngina) {
        this.ihdAngina = ihdAngina;
    }

    public YesNo getHypercholesterolemia() {
        return hypercholesterolemia;
    }

    public void setHypercholesterolemia(YesNo hypercholesterolemia) {
        this.hypercholesterolemia = hypercholesterolemia;
    }

    public YesNo getAtrialFibrillation() {
        return atrialFibrillation;
    }

    public void setAtrialFibrillation(YesNo atrialFibrillation) {
        this.atrialFibrillation = atrialFibrillation;
    }

    public YesNo getPvd() {
        return pvd;
    }

    public void setPvd(YesNo pvd) {
        this.pvd = pvd;
    }

    public YesNo getMi() {
        return mi;
    }

    public void setMi(YesNo mi) {
        this.mi = mi;
    }

    public YesNo getMigraineWithAura() {
        return migraineWithAura;
    }

    public void setMigraineWithAura(YesNo migraineWithAura) {
        this.migraineWithAura = migraineWithAura;
    }

    public YesNo getMigraineWithoutAura() {
        return migraineWithoutAura;
    }

    public void setMigraineWithoutAura(YesNo migraineWithoutAura) {
        this.migraineWithoutAura = migraineWithoutAura;
    }

    public Integer getIschaemicStrokeYear() {
        return ischaemicStrokeYear;
    }

    public void setIschaemicStrokeYear(Integer ischaemicStrokeYear) {
        this.ischaemicStrokeYear = ischaemicStrokeYear;
    }

    public Integer getHoemorrhagicStrokeYear() {
        return hoemorrhagicStrokeYear;
    }

    public void setHoemorrhagicStrokeYear(Integer hoemorrhagicStrokeYear) {
        this.hoemorrhagicStrokeYear = hoemorrhagicStrokeYear;
    }

    public Integer getTiaYear() {
        return tiaYear;
    }

    public void setTiaYear(Integer tiaYear) {
        this.tiaYear = tiaYear;
    }

    public YesNo getStrokeAssociatedWithDissection() {
        return strokeAssociatedWithDissection;
    }

    public void setStrokeAssociatedWithDissection(YesNo strokeAssociatedWithDissection) {
        this.strokeAssociatedWithDissection = strokeAssociatedWithDissection;
    }

    public YesNo getStrokeAssociatedWithPfo() {
        return strokeAssociatedWithPfo;
    }

    public void setStrokeAssociatedWithPfo(YesNo strokeAssociatedWithPfo) {
        this.strokeAssociatedWithPfo = strokeAssociatedWithPfo;
    }

    public YesNo getStrokeAssociatedWithMi() {
        return strokeAssociatedWithMi;
    }

    public void setStrokeAssociatedWithMi(YesNo strokeAssociatedWithMi) {
        this.strokeAssociatedWithMi = strokeAssociatedWithMi;
    }

    public YesNo getFamilyStroke() {
        return familyStroke;
    }

    public void setFamilyStroke(YesNo familyStroke) {
        this.familyStroke = familyStroke;
    }

    public YesNo getFamilyIhdAngina() {
        return familyIhdAngina;
    }

    public void setFamilyIhdAngina(YesNo familyIhdAngina) {
        this.familyIhdAngina = familyIhdAngina;
    }

    public YesNo getFamilyDiabetesMellitus() {
        return familyDiabetesMellitus;
    }

    public void setFamilyDiabetesMellitus(YesNo familyDiabetesMellitus) {
        this.familyDiabetesMellitus = familyDiabetesMellitus;
    }

    public YesNo getFamilyMi() {
        return familyMi;
    }

    public void setFamilyMi(YesNo familyMi) {
        this.familyMi = familyMi;
    }

    public YesNo getFamilyPvd() {
        return familyPvd;
    }

    public void setFamilyPvd(YesNo familyPvd) {
        this.familyPvd = familyPvd;
    }

    public YesNo getFamilyHypertension() {
        return familyHypertension;
    }

    public void setFamilyHypertension(YesNo familyHypertension) {
        this.familyHypertension = familyHypertension;
    }

    public YesNo getFamilyNoneOfTheAbove() {
        return familyNoneOfTheAbove;
    }

    public void setFamilyNoneOfTheAbove(YesNo familyNoneOfTheAbove) {
        this.familyNoneOfTheAbove = familyNoneOfTheAbove;
    }

    public YesNo getCurrentSmoker() {
        return currentSmoker;
    }

    public void setCurrentSmoker(YesNo currentSmoker) {
        this.currentSmoker = currentSmoker;
    }

    public Integer getCigarettePerDay() {
        return cigarettePerDay;
    }

    public void setCigarettePerDay(Integer cigarettePerDay) {
        this.cigarettePerDay = cigarettePerDay;
    }

    public YesNo getExSmoker() {
        return exSmoker;
    }

    public void setExSmoker(YesNo exSmoker) {
        this.exSmoker = exSmoker;
    }

    public YesNo getNever() {
        return never;
    }

    public void setNever(YesNo never) {
        this.never = never;
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

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Finder<Long, DataCollectionForm2> find = new Finder<Long, DataCollectionForm2>(
            Long.class, DataCollectionForm2.class
    );
}
