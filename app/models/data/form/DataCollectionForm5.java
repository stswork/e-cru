package models.data.form;

/**
 * Created by Sagar Gopale on 5/4/14.
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import models.YesNo;
import org.joda.time.DateTime;
import play.data.format.Formats;
import play.data.validation.Constraints;
import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCollectionForm5 extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private Integer patientIdNumber;

    @Constraints.Required
    private YesNo aspirin;

    private String aspirinDosage;

    @Constraints.Required
    private YesNo clopidogrel;

    private String clopidogrelDosage;

    @Constraints.Required
    private YesNo aspirinPlusClopidogrel;

    private String aspirinPlusClopidogrelDosage1;

    private String aspirinPlusClopidogrelDosage2;

    @Constraints.Required
    private YesNo dipyridamole;

    private String dipyridamoleDosage;

    @Constraints.Required
    private YesNo aspirinPlusDipyridamole;

    private String aspirinPlusDipyridamoleDosage1;

    private String aspirinPlusDipyridamoleDosage2;

    @Constraints.Required
    private YesNo warfarin;

    @Constraints.Required
    private YesNo statin;

    private String statinDosage;

    private String statinName;

    @Constraints.Required
    private YesNo antihypertensive = YesNo.DONT_KNOW;

    private String spouseName;

    private String spouseAddress;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp spouseDateOfBirth;

    private Gender spouseGender;

    private String spouseLandlinePhoneNumber;

    private String spouseCellPhoneNumber;

    private String spouseFriendPhoneNumber;

    private String spousePlaceOfBirth;

    private String spouseEthnicity;

    private String spouseNativeLanguage;

    private String spouseReligion;

    private YesNo spouseHypertension = YesNo.DONT_KNOW;

    private YesNo spouseDiabetesMellitus = YesNo.DONT_KNOW;

    private YesNo spouseIhdAngina = YesNo.DONT_KNOW;

    private YesNo spouseHypercholesterolemia = YesNo.DONT_KNOW;

    private YesNo spouseAtrialFibrillation = YesNo.DONT_KNOW;

    private YesNo spousePvd = YesNo.DONT_KNOW;

    private YesNo spouseMi = YesNo.DONT_KNOW;

    private YesNo spouseMigraineWithAura = YesNo.DONT_KNOW;

    private YesNo spouseMigraineWithoutAura = YesNo.DONT_KNOW;

    private YesNo spouseIschaemicStroke = YesNo.DONT_KNOW;

    private YesNo spouseHoemorrhagicStroke = YesNo.DONT_KNOW;

    private YesNo spouseTia = YesNo.DONT_KNOW;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public DataCollectionForm5() {
    }

    public DataCollectionForm5(Integer patientIdNumber, YesNo aspirin, String aspirinDosage, YesNo clopidogrel, String clopidogrelDosage, YesNo aspirinPlusClopidogrel, String aspirinPlusClopidogrelDosage1, String aspirinPlusClopidogrelDosage2, YesNo dipyridamole, String dipyridamoleDosage, YesNo aspirinPlusDipyridamole, String aspirinPlusDipyridamoleDosage1, String aspirinPlusDipyridamoleDosage2, YesNo warfarin, YesNo statin, String statinDosage, String statinName, YesNo antihypertensive, String spouseName, String spouseAddress, Timestamp spouseDateOfBirth, Gender spouseGender, String spouseLandlinePhoneNumber, String spouseCellPhoneNumber, String spouseFriendPhoneNumber, String spousePlaceOfBirth, String spouseEthnicity, String spouseNativeLanguage, String spouseReligion, YesNo spouseHypertension, YesNo spouseDiabetesMellitus, YesNo spouseIhdAngina, YesNo spouseHypercholesterolemia, YesNo spouseAtrialFibrillation, YesNo spousePvd, YesNo spouseMi, YesNo spouseMigraineWithAura, YesNo spouseMigraineWithoutAura, YesNo spouseIschaemicStroke, YesNo spouseHoemorrhagicStroke, YesNo spouseTia) {
        this.patientIdNumber = patientIdNumber;
        this.aspirin = aspirin;
        this.aspirinDosage = aspirinDosage;
        this.clopidogrel = clopidogrel;
        this.clopidogrelDosage = clopidogrelDosage;
        this.aspirinPlusClopidogrel = aspirinPlusClopidogrel;
        this.aspirinPlusClopidogrelDosage1 = aspirinPlusClopidogrelDosage1;
        this.aspirinPlusClopidogrelDosage2 = aspirinPlusClopidogrelDosage2;
        this.dipyridamole = dipyridamole;
        this.dipyridamoleDosage = dipyridamoleDosage;
        this.aspirinPlusDipyridamole = aspirinPlusDipyridamole;
        this.aspirinPlusDipyridamoleDosage1 = aspirinPlusDipyridamoleDosage1;
        this.aspirinPlusDipyridamoleDosage2 = aspirinPlusDipyridamoleDosage2;
        this.warfarin = warfarin;
        this.statin = statin;
        this.statinDosage = statinDosage;
        this.statinName = statinName;
        this.antihypertensive = antihypertensive;
        this.spouseName = spouseName;
        this.spouseAddress = spouseAddress;
        this.spouseDateOfBirth = spouseDateOfBirth;
        this.spouseGender = spouseGender;
        this.spouseLandlinePhoneNumber = spouseLandlinePhoneNumber;
        this.spouseCellPhoneNumber = spouseCellPhoneNumber;
        this.spouseFriendPhoneNumber = spouseFriendPhoneNumber;
        this.spousePlaceOfBirth = spousePlaceOfBirth;
        this.spouseEthnicity = spouseEthnicity;
        this.spouseNativeLanguage = spouseNativeLanguage;
        this.spouseReligion = spouseReligion;
        this.spouseHypertension = spouseHypertension;
        this.spouseDiabetesMellitus = spouseDiabetesMellitus;
        this.spouseIhdAngina = spouseIhdAngina;
        this.spouseHypercholesterolemia = spouseHypercholesterolemia;
        this.spouseAtrialFibrillation = spouseAtrialFibrillation;
        this.spousePvd = spousePvd;
        this.spouseMi = spouseMi;
        this.spouseMigraineWithAura = spouseMigraineWithAura;
        this.spouseMigraineWithoutAura = spouseMigraineWithoutAura;
        this.spouseIschaemicStroke = spouseIschaemicStroke;
        this.spouseHoemorrhagicStroke = spouseHoemorrhagicStroke;
        this.spouseTia = spouseTia;
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

    public String getAspirinPlusClopidogrelDosage1() {
        return aspirinPlusClopidogrelDosage1;
    }

    public void setAspirinPlusClopidogrelDosage1(String aspirinPlusClopidogrelDosage1) {
        this.aspirinPlusClopidogrelDosage1 = aspirinPlusClopidogrelDosage1;
    }

    public String getAspirinPlusClopidogrelDosage2() {
        return aspirinPlusClopidogrelDosage2;
    }

    public void setAspirinPlusClopidogrelDosage2(String aspirinPlusClopidogrelDosage2) {
        this.aspirinPlusClopidogrelDosage2 = aspirinPlusClopidogrelDosage2;
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

    public String getAspirinPlusDipyridamoleDosage1() {
        return aspirinPlusDipyridamoleDosage1;
    }

    public void setAspirinPlusDipyridamoleDosage1(String aspirinPlusDipyridamoleDosage1) {
        this.aspirinPlusDipyridamoleDosage1 = aspirinPlusDipyridamoleDosage1;
    }

    public String getAspirinPlusDipyridamoleDosage2() {
        return aspirinPlusDipyridamoleDosage2;
    }

    public void setAspirinPlusDipyridamoleDosage2(String aspirinPlusDipyridamoleDosage2) {
        this.aspirinPlusDipyridamoleDosage2 = aspirinPlusDipyridamoleDosage2;
    }

    public YesNo getWarfarin() {
        return warfarin;
    }

    public void setWarfarin(YesNo warfarin) {
        this.warfarin = warfarin;
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

    public String getSpouseName() {
        return spouseName;
    }

    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }

    public String getSpouseAddress() {
        return spouseAddress;
    }

    public void setSpouseAddress(String spouseAddress) {
        this.spouseAddress = spouseAddress;
    }

    public Timestamp getSpouseDateOfBirth() {
        return spouseDateOfBirth;
    }

    public void setSpouseDateOfBirth(Timestamp spouseDateOfBirth) {
        this.spouseDateOfBirth = spouseDateOfBirth;
    }

    public Gender getSpouseGender() {
        return spouseGender;
    }

    public void setSpouseGender(Gender spouseGender) {
        this.spouseGender = spouseGender;
    }

    public String getSpouseLandlinePhoneNumber() {
        return spouseLandlinePhoneNumber;
    }

    public void setSpouseLandlinePhoneNumber(String spouseLandlinePhoneNumber) {
        this.spouseLandlinePhoneNumber = spouseLandlinePhoneNumber;
    }

    public String getSpouseCellPhoneNumber() {
        return spouseCellPhoneNumber;
    }

    public void setSpouseCellPhoneNumber(String spouseCellPhoneNumber) {
        this.spouseCellPhoneNumber = spouseCellPhoneNumber;
    }

    public String getSpouseFriendPhoneNumber() {
        return spouseFriendPhoneNumber;
    }

    public void setSpouseFriendPhoneNumber(String spouseFriendPhoneNumber) {
        this.spouseFriendPhoneNumber = spouseFriendPhoneNumber;
    }

    public String getSpousePlaceOfBirth() {
        return spousePlaceOfBirth;
    }

    public void setSpousePlaceOfBirth(String spousePlaceOfBirth) {
        this.spousePlaceOfBirth = spousePlaceOfBirth;
    }

    public String getSpouseEthnicity() {
        return spouseEthnicity;
    }

    public void setSpouseEthnicity(String spouseEthnicity) {
        this.spouseEthnicity = spouseEthnicity;
    }

    public String getSpouseNativeLanguage() {
        return spouseNativeLanguage;
    }

    public void setSpouseNativeLanguage(String spouseNativeLanguage) {
        this.spouseNativeLanguage = spouseNativeLanguage;
    }

    public String getSpouseReligion() {
        return spouseReligion;
    }

    public void setSpouseReligion(String spouseReligion) {
        this.spouseReligion = spouseReligion;
    }

    public YesNo getSpouseHypertension() {
        return spouseHypertension;
    }

    public void setSpouseHypertension(YesNo spouseHypertension) {
        this.spouseHypertension = spouseHypertension;
    }

    public YesNo getSpouseDiabetesMellitus() {
        return spouseDiabetesMellitus;
    }

    public void setSpouseDiabetesMellitus(YesNo spouseDiabetesMellitus) {
        this.spouseDiabetesMellitus = spouseDiabetesMellitus;
    }

    public YesNo getSpouseIhdAngina() {
        return spouseIhdAngina;
    }

    public void setSpouseIhdAngina(YesNo spouseIhdAngina) {
        this.spouseIhdAngina = spouseIhdAngina;
    }

    public YesNo getSpouseHypercholesterolemia() {
        return spouseHypercholesterolemia;
    }

    public void setSpouseHypercholesterolemia(YesNo spouseHypercholesterolemia) {
        this.spouseHypercholesterolemia = spouseHypercholesterolemia;
    }

    public YesNo getSpouseAtrialFibrillation() {
        return spouseAtrialFibrillation;
    }

    public void setSpouseAtrialFibrillation(YesNo spouseAtrialFibrillation) {
        this.spouseAtrialFibrillation = spouseAtrialFibrillation;
    }

    public YesNo getSpousePvd() {
        return spousePvd;
    }

    public void setSpousePvd(YesNo spousePvd) {
        this.spousePvd = spousePvd;
    }

    public YesNo getSpouseMi() {
        return spouseMi;
    }

    public void setSpouseMi(YesNo spouseMi) {
        this.spouseMi = spouseMi;
    }

    public YesNo getSpouseMigraineWithAura() {
        return spouseMigraineWithAura;
    }

    public void setSpouseMigraineWithAura(YesNo spouseMigraineWithAura) {
        this.spouseMigraineWithAura = spouseMigraineWithAura;
    }

    public YesNo getSpouseMigraineWithoutAura() {
        return spouseMigraineWithoutAura;
    }

    public void setSpouseMigraineWithoutAura(YesNo spouseMigraineWithoutAura) {
        this.spouseMigraineWithoutAura = spouseMigraineWithoutAura;
    }

    public YesNo getSpouseIschaemicStroke() {
        return spouseIschaemicStroke;
    }

    public void setSpouseIschaemicStroke(YesNo spouseIschaemicStroke) {
        this.spouseIschaemicStroke = spouseIschaemicStroke;
    }

    public YesNo getSpouseHoemorrhagicStroke() {
        return spouseHoemorrhagicStroke;
    }

    public void setSpouseHoemorrhagicStroke(YesNo spouseHoemorrhagicStroke) {
        this.spouseHoemorrhagicStroke = spouseHoemorrhagicStroke;
    }

    public YesNo getSpouseTia() {
        return spouseTia;
    }

    public void setSpouseTia(YesNo spouseTia) {
        this.spouseTia = spouseTia;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public static Model.Finder<Long, DataCollectionForm5> find = new Model.Finder<Long, DataCollectionForm5>(
            Long.class, DataCollectionForm5.class
    );
}
