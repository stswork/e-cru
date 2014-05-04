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

    @Constraints.Required
    private Integer alcoholUnitsPerWeek;

    @Constraints.Required
    private Double height;

    @Constraints.Required
    private Double weight;

    @Constraints.Required
    private Double bmi;

    private String aspirinDosage;

    private String clopidogrelDosage;

    private String aspirinPlusClopidogrelDosage;

    private String dipyridamoleDosage;

    private String aspirinPlusDipyridamoleDosage;

    private String warfarinInr;

    private String statinDosage;

    private String statinName;

    private YesNo antihypertensive = YesNo.DONT_KNOW;

    private YesNo medicineNoneOfTheAbove = YesNo.DONT_KNOW;

    private String bpOnAdmission;

    private String temperatureOnAdmission;

    private YesNo carotidEndarterectomyDone = YesNo.DONT_KNOW;

    private YesNo thrombolysedDone = YesNo.DONT_KNOW;

    private YesNo ctaDone = YesNo.DONT_KNOW;

    private YesNo mraDone = YesNo.DONT_KNOW;

    private YesNo angiogramDone = YesNo.DONT_KNOW;

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
        this.alcoholUnitsPerWeek = alcoholUnitsPerWeek;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.aspirinDosage = aspirinDosage;
        this.clopidogrelDosage = clopidogrelDosage;
        this.aspirinPlusClopidogrelDosage = aspirinPlusClopidogrelDosage;
        this.dipyridamoleDosage = dipyridamoleDosage;
        this.aspirinPlusDipyridamoleDosage = aspirinPlusDipyridamoleDosage;
        this.warfarinInr = warfarinInr;
        this.statinDosage = statinDosage;
        this.statinName = statinName;
        this.antihypertensive = antihypertensive;
        this.medicineNoneOfTheAbove = medicineNoneOfTheAbove;
        this.bpOnAdmission = bpOnAdmission;
        this.temperatureOnAdmission = temperatureOnAdmission;
        this.carotidEndarterectomyDone = carotidEndarterectomyDone;
        this.thrombolysedDone = thrombolysedDone;
        this.ctaDone = ctaDone;
        this.mraDone = mraDone;
        this.angiogramDone = angiogramDone;
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

    public Integer getAlcoholUnitsPerWeek() {
        return alcoholUnitsPerWeek;
    }

    public void setAlcoholUnitsPerWeek(Integer alcoholUnitsPerWeek) {
        this.alcoholUnitsPerWeek = alcoholUnitsPerWeek;
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

    public String getAspirinDosage() {
        return aspirinDosage;
    }

    public void setAspirinDosage(String aspirinDosage) {
        this.aspirinDosage = aspirinDosage;
    }

    public String getClopidogrelDosage() {
        return clopidogrelDosage;
    }

    public void setClopidogrelDosage(String clopidogrelDosage) {
        this.clopidogrelDosage = clopidogrelDosage;
    }

    public String getAspirinPlusClopidogrelDosage() {
        return aspirinPlusClopidogrelDosage;
    }

    public void setAspirinPlusClopidogrelDosage(String aspirinPlusClopidogrelDosage) {
        this.aspirinPlusClopidogrelDosage = aspirinPlusClopidogrelDosage;
    }

    public String getDipyridamoleDosage() {
        return dipyridamoleDosage;
    }

    public void setDipyridamoleDosage(String dipyridamoleDosage) {
        this.dipyridamoleDosage = dipyridamoleDosage;
    }

    public String getAspirinPlusDipyridamoleDosage() {
        return aspirinPlusDipyridamoleDosage;
    }

    public void setAspirinPlusDipyridamoleDosage(String aspirinPlusDipyridamoleDosage) {
        this.aspirinPlusDipyridamoleDosage = aspirinPlusDipyridamoleDosage;
    }

    public String getWarfarinInr() {
        return warfarinInr;
    }

    public void setWarfarinInr(String warfarinInr) {
        this.warfarinInr = warfarinInr;
    }

    public String getStatinDosage() {
        return statinDosage;
    }

    public void setStatinDosage(String statinDosage) {
        this.statinDosage = statinDosage;
    }

    public String getStatinName() {
        return statinName;
    }

    public void setStatinName(String statinName) {
        this.statinName = statinName;
    }

    public YesNo getAntihypertensive() {
        return antihypertensive;
    }

    public void setAntihypertensive(YesNo antihypertensive) {
        this.antihypertensive = antihypertensive;
    }

    public YesNo getMedicineNoneOfTheAbove() {
        return medicineNoneOfTheAbove;
    }

    public void setMedicineNoneOfTheAbove(YesNo medicineNoneOfTheAbove) {
        this.medicineNoneOfTheAbove = medicineNoneOfTheAbove;
    }

    public String getBpOnAdmission() {
        return bpOnAdmission;
    }

    public void setBpOnAdmission(String bpOnAdmission) {
        this.bpOnAdmission = bpOnAdmission;
    }

    public String getTemperatureOnAdmission() {
        return temperatureOnAdmission;
    }

    public void setTemperatureOnAdmission(String temperatureOnAdmission) {
        this.temperatureOnAdmission = temperatureOnAdmission;
    }

    public YesNo getCarotidEndarterectomyDone() {
        return carotidEndarterectomyDone;
    }

    public void setCarotidEndarterectomyDone(YesNo carotidEndarterectomyDone) {
        this.carotidEndarterectomyDone = carotidEndarterectomyDone;
    }

    public YesNo getThrombolysedDone() {
        return thrombolysedDone;
    }

    public void setThrombolysedDone(YesNo thrombolysedDone) {
        this.thrombolysedDone = thrombolysedDone;
    }

    public YesNo getCtaDone() {
        return ctaDone;
    }

    public void setCtaDone(YesNo ctaDone) {
        this.ctaDone = ctaDone;
    }

    public YesNo getMraDone() {
        return mraDone;
    }

    public void setMraDone(YesNo mraDone) {
        this.mraDone = mraDone;
    }

    public YesNo getAngiogramDone() {
        return angiogramDone;
    }

    public void setAngiogramDone(YesNo angiogramDone) {
        this.angiogramDone = angiogramDone;
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
