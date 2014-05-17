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
public class DataCollectionForm3 extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private Integer patientIdNumber;

    @Constraints.Required
    private Integer alcoholUnitsPerWeek;

    @Constraints.Required
    private Double height = 0.0;

    @Constraints.Required
    private Double weight = 0.0;

    @Constraints.Required
    private Double bmi = 0.0;

    @Constraints.Required
    private YesNo aspirin = YesNo.NO;

    private String aspirinDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo clopidogrel = YesNo.NO;

    private String clopidogrelDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo aspirinPlusClopidogrel = YesNo.NO;

    private String aspirinPlusClopidogrelDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo dipyridamole = YesNo.NO;

    private String dipyridamoleDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo aspirinPlusDipyridamole = YesNo.NO;

    private String aspirinPlusDipyridamoleDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo warfarin = YesNo.NO;

    private String warfarinInr = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo statin = YesNo.NO;

    private String statinDosage = StringUtils.EMPTY;

    private String statinName = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo antihypertensive = YesNo.NO;

    private String antihypertensiveDosage = StringUtils.EMPTY;

    private YesNo medicineNoneOfTheAbove = YesNo.NO;

    @Constraints.Required
    private YesNo glucoseBloodTest = YesNo.NO;

    private String glucoseBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo totalCholesterolBloodTest = YesNo.NO;

    private String totalCholesterolBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo hdlCholesterolBloodTest = YesNo.NO;

    private String hdlCholesterolBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo ldlCholesterolBloodTest = YesNo.NO;

    private String ldlCholesterolBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo triglycerideBloodTest = YesNo.NO;

    private String triglycerideBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo esrBloodTest = YesNo.NO;

    private String esrBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo crpBloodTest = YesNo.NO;

    private String crpBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo troponimBloodTest = YesNo.NO;

    private String troponimBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo proteinCBloodTest = YesNo.NO;

    private String proteinCBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo proteinSBloodTest = YesNo.NO;

    private String proteinSBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo fibrinogenBloodTest = YesNo.NO;

    private String fibrinogenBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo antithrombin11BloodTest = YesNo.NO;

    private String antithrombin11BloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo factorVBloodTest = YesNo.NO;

    private String factorVBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo homocysteineBloodTest = YesNo.NO;

    private String homocysteineBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo prothrombinBloodTest = YesNo.NO;

    private String prothrombinBloodTestResult = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo antiphospholipidBloodTest = YesNo.NO;

    private String antiphospholipidBloodTestResult = StringUtils.EMPTY;

    private String bpOnAdmission = StringUtils.EMPTY;

    private String temperatureOnAdmission = StringUtils.EMPTY;

    private YesNo carotidEndarterectomyDone = YesNo.NO;

    private YesNo thrombolysedDone = YesNo.NO;

    private YesNo ctaDone = YesNo.NO;

    private YesNo mraDone = YesNo.NO;

    private YesNo angiogramDone = YesNo.NO;

    @Constraints.Required
    public Status status = Status.ACTIVE;

    @OneToOne
    private User createdBy;

    @OneToOne
    private User modifiedBy;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public DataCollectionForm3() {
    }

    public DataCollectionForm3(Integer patientIdNumber, Integer alcoholUnitsPerWeek, Double height, Double weight, Double bmi, YesNo aspirin, String aspirinDosage, YesNo clopidogrel, String clopidogrelDosage, YesNo aspirinPlusClopidogrel, String aspirinPlusClopidogrelDosage, YesNo dipyridamole, String dipyridamoleDosage, YesNo aspirinPlusDipyridamole, String aspirinPlusDipyridamoleDosage, YesNo warfarin, String warfarinInr, YesNo statin, String statinDosage, String statinName, YesNo antihypertensive, YesNo medicineNoneOfTheAbove, YesNo glucoseBloodTest, String glucoseBloodTestResult, YesNo totalCholesterolBloodTest, String totalCholesterolBloodTestResult, YesNo hdlCholesterolBloodTest, String hdlCholesterolBloodTestResult, YesNo ldlCholesterolBloodTest, String ldlCholesterolBloodTestResult, YesNo triglycerideBloodTest, String triglycerideBloodTestResult, YesNo esrBloodTest, String esrBloodTestResult, YesNo crpBloodTest, String crpBloodTestResult, YesNo troponimBloodTest, String troponimBloodTestResult, YesNo proteinCBloodTest, String proteinCBloodTestResult, YesNo proteinSBloodTest, String proteinSBloodTestResult, YesNo fibrinogenBloodTest, String fibrinogenBloodTestResult, YesNo antithrombin11BloodTest, String antithrombin11BloodTestResult, YesNo factorVBloodTest, String factorVBloodTestResult, YesNo homocysteineBloodTest, String homocysteineBloodTestResult, YesNo prothrombinBloodTest, String prothrombinBloodTestResult, YesNo antiphospholipidBloodTest, String antiphospholipidBloodTestResult, String bpOnAdmission, String temperatureOnAdmission, YesNo carotidEndarterectomyDone, YesNo thrombolysedDone, YesNo ctaDone, YesNo mraDone, YesNo angiogramDone) {
        this.patientIdNumber = patientIdNumber;
        this.alcoholUnitsPerWeek = alcoholUnitsPerWeek;
        this.height = height;
        this.weight = weight;
        this.bmi = bmi;
        this.aspirin = aspirin;
        this.aspirinDosage = aspirinDosage;
        this.clopidogrel = clopidogrel;
        this.clopidogrelDosage = clopidogrelDosage;
        this.aspirinPlusClopidogrel = aspirinPlusClopidogrel;
        this.aspirinPlusClopidogrelDosage = aspirinPlusClopidogrelDosage;
        this.dipyridamole = dipyridamole;
        this.dipyridamoleDosage = dipyridamoleDosage;
        this.aspirinPlusDipyridamole = aspirinPlusDipyridamole;
        this.aspirinPlusDipyridamoleDosage = aspirinPlusDipyridamoleDosage;
        this.warfarin = warfarin;
        this.warfarinInr = warfarinInr;
        this.statin = statin;
        this.statinDosage = statinDosage;
        this.statinName = statinName;
        this.antihypertensive = antihypertensive;
        this.medicineNoneOfTheAbove = medicineNoneOfTheAbove;
        this.glucoseBloodTest = glucoseBloodTest;
        this.glucoseBloodTestResult = glucoseBloodTestResult;
        this.totalCholesterolBloodTest = totalCholesterolBloodTest;
        this.totalCholesterolBloodTestResult = totalCholesterolBloodTestResult;
        this.hdlCholesterolBloodTest = hdlCholesterolBloodTest;
        this.hdlCholesterolBloodTestResult = hdlCholesterolBloodTestResult;
        this.ldlCholesterolBloodTest = ldlCholesterolBloodTest;
        this.ldlCholesterolBloodTestResult = ldlCholesterolBloodTestResult;
        this.triglycerideBloodTest = triglycerideBloodTest;
        this.triglycerideBloodTestResult = triglycerideBloodTestResult;
        this.esrBloodTest = esrBloodTest;
        this.esrBloodTestResult = esrBloodTestResult;
        this.crpBloodTest = crpBloodTest;
        this.crpBloodTestResult = crpBloodTestResult;
        this.troponimBloodTest = troponimBloodTest;
        this.troponimBloodTestResult = troponimBloodTestResult;
        this.proteinCBloodTest = proteinCBloodTest;
        this.proteinCBloodTestResult = proteinCBloodTestResult;
        this.proteinSBloodTest = proteinSBloodTest;
        this.proteinSBloodTestResult = proteinSBloodTestResult;
        this.fibrinogenBloodTest = fibrinogenBloodTest;
        this.fibrinogenBloodTestResult = fibrinogenBloodTestResult;
        this.antithrombin11BloodTest = antithrombin11BloodTest;
        this.antithrombin11BloodTestResult = antithrombin11BloodTestResult;
        this.factorVBloodTest = factorVBloodTest;
        this.factorVBloodTestResult = factorVBloodTestResult;
        this.homocysteineBloodTest = homocysteineBloodTest;
        this.homocysteineBloodTestResult = homocysteineBloodTestResult;
        this.prothrombinBloodTest = prothrombinBloodTest;
        this.prothrombinBloodTestResult = prothrombinBloodTestResult;
        this.antiphospholipidBloodTest = antiphospholipidBloodTest;
        this.antiphospholipidBloodTestResult = antiphospholipidBloodTestResult;
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

    public YesNo getAspirin() {
        return aspirin;
    }

    public void setAspirin(YesNo aspirin) {
        this.aspirin = aspirin;
    }

    public String getAspirinDosage() {
        return aspirinDosage;
    }

    public void setAspirinDosage(String aspirinDosage) {
        this.aspirinDosage = aspirinDosage;
    }

    public YesNo getClopidogrel() {
        return clopidogrel;
    }

    public void setClopidogrel(YesNo clopidogrel) {
        this.clopidogrel = clopidogrel;
    }

    public String getClopidogrelDosage() {
        return clopidogrelDosage;
    }

    public void setClopidogrelDosage(String clopidogrelDosage) {
        this.clopidogrelDosage = clopidogrelDosage;
    }

    public YesNo getAspirinPlusClopidogrel() {
        return aspirinPlusClopidogrel;
    }

    public void setAspirinPlusClopidogrel(YesNo aspirinPlusClopidogrel) {
        this.aspirinPlusClopidogrel = aspirinPlusClopidogrel;
    }

    public String getAspirinPlusClopidogrelDosage() {
        return aspirinPlusClopidogrelDosage;
    }

    public String getAspirinPlusClopidogrelDosage1() {
        if(StringUtils.isEmpty(aspirinPlusClopidogrelDosage)) {
            return StringUtils.EMPTY;
        } else {
            return aspirinPlusClopidogrelDosage.split("\\+").length <= 0 ? StringUtils.EMPTY : aspirinPlusClopidogrelDosage.split("\\+")[0];
        }
    }

    public String getAspirinPlusClopidogrelDosage2() {
        if(StringUtils.isEmpty(aspirinPlusClopidogrelDosage)) {
            return StringUtils.EMPTY;
        } else {
            return aspirinPlusClopidogrelDosage.split("\\+").length <= 0 ? StringUtils.EMPTY : aspirinPlusClopidogrelDosage.split("\\+")[1];
        }
    }

    public void setAspirinPlusClopidogrelDosage(String aspirinPlusClopidogrelDosage) {
        this.aspirinPlusClopidogrelDosage = aspirinPlusClopidogrelDosage;
    }

    public YesNo getDipyridamole() {
        return dipyridamole;
    }

    public void setDipyridamole(YesNo dipyridamole) {
        this.dipyridamole = dipyridamole;
    }

    public String getDipyridamoleDosage() {
        return dipyridamoleDosage;
    }

    public void setDipyridamoleDosage(String dipyridamoleDosage) {
        this.dipyridamoleDosage = dipyridamoleDosage;
    }

    public YesNo getAspirinPlusDipyridamole() {
        return aspirinPlusDipyridamole;
    }

    public void setAspirinPlusDipyridamole(YesNo aspirinPlusDipyridamole) {
        this.aspirinPlusDipyridamole = aspirinPlusDipyridamole;
    }

    public String getAspirinPlusDipyridamoleDosage() {
        return aspirinPlusDipyridamoleDosage;
    }

    public String getAspirinPlusDipyridamoleDosage1() {
        if(StringUtils.isEmpty(aspirinPlusDipyridamoleDosage)) {
            return StringUtils.EMPTY;
        } else {
            return aspirinPlusDipyridamoleDosage.split("\\+").length <= 0 ? StringUtils.EMPTY : aspirinPlusDipyridamoleDosage.split("\\+")[0];
        }
    }

    public String getAspirinPlusDipyridamoleDosage2() {
        if(StringUtils.isEmpty(aspirinPlusDipyridamoleDosage)) {
            return StringUtils.EMPTY;
        } else {
            return aspirinPlusDipyridamoleDosage.split("\\+").length <= 0 ? StringUtils.EMPTY : aspirinPlusDipyridamoleDosage.split("\\+")[1];
        }
    }

    public void setAspirinPlusDipyridamoleDosage(String aspirinPlusDipyridamoleDosage) {
        this.aspirinPlusDipyridamoleDosage = aspirinPlusDipyridamoleDosage;
    }

    public YesNo getWarfarin() {
        return warfarin;
    }

    public void setWarfarin(YesNo warfarin) {
        this.warfarin = warfarin;
    }

    public String getWarfarinInr() {
        return warfarinInr;
    }

    public void setWarfarinInr(String warfarinInr) {
        this.warfarinInr = warfarinInr;
    }

    public YesNo getStatin() {
        return statin;
    }

    public void setStatin(YesNo statin) {
        this.statin = statin;
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

    public YesNo getGlucoseBloodTest() {
        return glucoseBloodTest;
    }

    public void setGlucoseBloodTest(YesNo glucoseBloodTest) {
        this.glucoseBloodTest = glucoseBloodTest;
    }

    public String getGlucoseBloodTestResult() {
        return glucoseBloodTestResult;
    }

    public void setGlucoseBloodTestResult(String glucoseBloodTestResult) {
        this.glucoseBloodTestResult = glucoseBloodTestResult;
    }

    public YesNo getTotalCholesterolBloodTest() {
        return totalCholesterolBloodTest;
    }

    public void setTotalCholesterolBloodTest(YesNo totalCholesterolBloodTest) {
        this.totalCholesterolBloodTest = totalCholesterolBloodTest;
    }

    public String getTotalCholesterolBloodTestResult() {
        return totalCholesterolBloodTestResult;
    }

    public void setTotalCholesterolBloodTestResult(String totalCholesterolBloodTestResult) {
        this.totalCholesterolBloodTestResult = totalCholesterolBloodTestResult;
    }

    public YesNo getHdlCholesterolBloodTest() {
        return hdlCholesterolBloodTest;
    }

    public void setHdlCholesterolBloodTest(YesNo hdlCholesterolBloodTest) {
        this.hdlCholesterolBloodTest = hdlCholesterolBloodTest;
    }

    public String getHdlCholesterolBloodTestResult() {
        return hdlCholesterolBloodTestResult;
    }

    public void setHdlCholesterolBloodTestResult(String hdlCholesterolBloodTestResult) {
        this.hdlCholesterolBloodTestResult = hdlCholesterolBloodTestResult;
    }

    public YesNo getLdlCholesterolBloodTest() {
        return ldlCholesterolBloodTest;
    }

    public void setLdlCholesterolBloodTest(YesNo ldlCholesterolBloodTest) {
        this.ldlCholesterolBloodTest = ldlCholesterolBloodTest;
    }

    public String getLdlCholesterolBloodTestResult() {
        return ldlCholesterolBloodTestResult;
    }

    public void setLdlCholesterolBloodTestResult(String ldlCholesterolBloodTestResult) {
        this.ldlCholesterolBloodTestResult = ldlCholesterolBloodTestResult;
    }

    public YesNo getTriglycerideBloodTest() {
        return triglycerideBloodTest;
    }

    public void setTriglycerideBloodTest(YesNo triglycerideBloodTest) {
        this.triglycerideBloodTest = triglycerideBloodTest;
    }

    public String getTriglycerideBloodTestResult() {
        return triglycerideBloodTestResult;
    }

    public void setTriglycerideBloodTestResult(String triglycerideBloodTestResult) {
        this.triglycerideBloodTestResult = triglycerideBloodTestResult;
    }

    public YesNo getEsrBloodTest() {
        return esrBloodTest;
    }

    public void setEsrBloodTest(YesNo esrBloodTest) {
        this.esrBloodTest = esrBloodTest;
    }

    public String getEsrBloodTestResult() {
        return esrBloodTestResult;
    }

    public void setEsrBloodTestResult(String esrBloodTestResult) {
        this.esrBloodTestResult = esrBloodTestResult;
    }

    public YesNo getCrpBloodTest() {
        return crpBloodTest;
    }

    public void setCrpBloodTest(YesNo crpBloodTest) {
        this.crpBloodTest = crpBloodTest;
    }

    public String getCrpBloodTestResult() {
        return crpBloodTestResult;
    }

    public void setCrpBloodTestResult(String crpBloodTestResult) {
        this.crpBloodTestResult = crpBloodTestResult;
    }

    public YesNo getTroponimBloodTest() {
        return troponimBloodTest;
    }

    public void setTroponimBloodTest(YesNo troponimBloodTest) {
        this.troponimBloodTest = troponimBloodTest;
    }

    public String getTroponimBloodTestResult() {
        return troponimBloodTestResult;
    }

    public void setTroponimBloodTestResult(String troponimBloodTestResult) {
        this.troponimBloodTestResult = troponimBloodTestResult;
    }

    public YesNo getProteinCBloodTest() {
        return proteinCBloodTest;
    }

    public void setProteinCBloodTest(YesNo proteinCBloodTest) {
        this.proteinCBloodTest = proteinCBloodTest;
    }

    public String getProteinCBloodTestResult() {
        return proteinCBloodTestResult;
    }

    public void setProteinCBloodTestResult(String proteinCBloodTestResult) {
        this.proteinCBloodTestResult = proteinCBloodTestResult;
    }

    public YesNo getProteinSBloodTest() {
        return proteinSBloodTest;
    }

    public void setProteinSBloodTest(YesNo proteinSBloodTest) {
        this.proteinSBloodTest = proteinSBloodTest;
    }

    public String getProteinSBloodTestResult() {
        return proteinSBloodTestResult;
    }

    public void setProteinSBloodTestResult(String proteinSBloodTestResult) {
        this.proteinSBloodTestResult = proteinSBloodTestResult;
    }

    public YesNo getFibrinogenBloodTest() {
        return fibrinogenBloodTest;
    }

    public void setFibrinogenBloodTest(YesNo fibrinogenBloodTest) {
        this.fibrinogenBloodTest = fibrinogenBloodTest;
    }

    public String getFibrinogenBloodTestResult() {
        return fibrinogenBloodTestResult;
    }

    public void setFibrinogenBloodTestResult(String fibrinogenBloodTestResult) {
        this.fibrinogenBloodTestResult = fibrinogenBloodTestResult;
    }

    public YesNo getAntithrombin11BloodTest() {
        return antithrombin11BloodTest;
    }

    public void setAntithrombin11BloodTest(YesNo antithrombin11BloodTest) {
        this.antithrombin11BloodTest = antithrombin11BloodTest;
    }

    public String getAntithrombin11BloodTestResult() {
        return antithrombin11BloodTestResult;
    }

    public void setAntithrombin11BloodTestResult(String antithrombin11BloodTestResult) {
        this.antithrombin11BloodTestResult = antithrombin11BloodTestResult;
    }

    public YesNo getFactorVBloodTest() {
        return factorVBloodTest;
    }

    public void setFactorVBloodTest(YesNo factorVBloodTest) {
        this.factorVBloodTest = factorVBloodTest;
    }

    public String getFactorVBloodTestResult() {
        return factorVBloodTestResult;
    }

    public void setFactorVBloodTestResult(String factorVBloodTestResult) {
        this.factorVBloodTestResult = factorVBloodTestResult;
    }

    public YesNo getHomocysteineBloodTest() {
        return homocysteineBloodTest;
    }

    public void setHomocysteineBloodTest(YesNo homocysteineBloodTest) {
        this.homocysteineBloodTest = homocysteineBloodTest;
    }

    public String getHomocysteineBloodTestResult() {
        return homocysteineBloodTestResult;
    }

    public void setHomocysteineBloodTestResult(String homocysteineBloodTestResult) {
        this.homocysteineBloodTestResult = homocysteineBloodTestResult;
    }

    public YesNo getProthrombinBloodTest() {
        return prothrombinBloodTest;
    }

    public void setProthrombinBloodTest(YesNo prothrombinBloodTest) {
        this.prothrombinBloodTest = prothrombinBloodTest;
    }

    public String getProthrombinBloodTestResult() {
        return prothrombinBloodTestResult;
    }

    public void setProthrombinBloodTestResult(String prothrombinBloodTestResult) {
        this.prothrombinBloodTestResult = prothrombinBloodTestResult;
    }

    public YesNo getAntiphospholipidBloodTest() {
        return antiphospholipidBloodTest;
    }

    public void setAntiphospholipidBloodTest(YesNo antiphospholipidBloodTest) {
        this.antiphospholipidBloodTest = antiphospholipidBloodTest;
    }

    public String getAntiphospholipidBloodTestResult() {
        return antiphospholipidBloodTestResult;
    }

    public void setAntiphospholipidBloodTestResult(String antiphospholipidBloodTestResult) {
        this.antiphospholipidBloodTestResult = antiphospholipidBloodTestResult;
    }

    public String getBpOnAdmission() {
        return bpOnAdmission;
    }

    public String getBpOnAdmission1() {
        if(StringUtils.isEmpty(bpOnAdmission)) {
            return StringUtils.EMPTY;
        } else {
            return bpOnAdmission.split("/").length <= 0 ? StringUtils.EMPTY : bpOnAdmission.split("/")[0];
        }
    }

    public String getBpOnAdmission2() {
        if(StringUtils.isEmpty(bpOnAdmission)) {
            return StringUtils.EMPTY;
        } else {
            return bpOnAdmission.split("/").length <= 0 ? StringUtils.EMPTY : bpOnAdmission.split("/")[1];
        }
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

    public static Finder<Long, DataCollectionForm3> find = new Finder<Long, DataCollectionForm3>(
            Long.class, DataCollectionForm3.class
    );

    public String getAntihypertensiveDosage() {
        return antihypertensiveDosage;
    }

    public void setAntihypertensiveDosage(String antihypertensiveDosage) {
        this.antihypertensiveDosage = antihypertensiveDosage;
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
