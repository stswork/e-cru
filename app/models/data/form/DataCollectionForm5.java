package models.data.form;

/**
 * Created by Sagar Gopale on 5/4/14.
 */

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

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DataCollectionForm5 extends Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Constraints.Required
    private Long patientIdNumber;

    @Constraints.Required
    private YesNo aspirin;

    private String aspirinDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo clopidogrel;

    private String clopidogrelDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo aspirinPlusClopidogrel;

    private String aspirinPlusClopidogrelDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo dipyridamole;

    private String dipyridamoleDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo aspirinPlusDipyridamole;

    private String aspirinPlusDipyridamoleDosage = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo warfarin;

    @Constraints.Required
    private YesNo statin;

    private String statinDosage = StringUtils.EMPTY;

    private String statinName = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo antihypertensive = YesNo.DONT_KNOW;

    private String spouseName = StringUtils.EMPTY;

    private String spouseAddress = StringUtils.EMPTY;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp spouseDateOfBirth;

    private Gender spouseGender;

    private String spouseLandlinePhoneNumber = StringUtils.EMPTY;

    private String spouseCellPhoneNumber = StringUtils.EMPTY;

    private String spouseFriendPhoneNumber = StringUtils.EMPTY;

    private String spousePlaceOfBirth = StringUtils.EMPTY;

    private String spouseEthnicity = StringUtils.EMPTY;

    private String spouseNativeLanguage = StringUtils.EMPTY;

    private String spouseReligion = StringUtils.EMPTY;

    @Constraints.Required
    private YesNo spouseHypertension = YesNo.NO;

    @Constraints.Required
    private YesNo spouseDiabetesMellitus = YesNo.NO;

    @Constraints.Required
    private YesNo spouseIhdAngina = YesNo.NO;

    @Constraints.Required
    private YesNo spouseHypercholesterolemia = YesNo.NO;

    @Constraints.Required
    private YesNo spouseAtrialFibrillation = YesNo.NO;

    @Constraints.Required
    private YesNo spousePvd = YesNo.NO;

    @Constraints.Required
    private YesNo spouseMi = YesNo.NO;

    @Constraints.Required
    private YesNo spouseMigraineWithAura = YesNo.NO;

    @Constraints.Required
    private YesNo spouseMigraineWithoutAura = YesNo.NO;

    @Constraints.Required
    private YesNo spouseIschaemicStroke = YesNo.NO;

    @Constraints.Required
    private YesNo spouseHoemorrhagicStroke = YesNo.NO;

    @Constraints.Required
    private YesNo spouseTia = YesNo.NO;

    private String bpToday = StringUtils.EMPTY;

    @Constraints.Required
    public Status status = Status.ACTIVE;

    @OneToOne
    private User createdBy;

    @OneToOne
    private User modifiedBy;

    @Formats.DateTime(pattern = "MM/dd/yy")
    private Timestamp created = new Timestamp(DateTime.now().toDate().getTime());

    public DataCollectionForm5() {
    }

    public DataCollectionForm5(Long patientIdNumber, YesNo aspirin, String aspirinDosage, YesNo clopidogrel, String clopidogrelDosage, YesNo aspirinPlusClopidogrel, String aspirinPlusClopidogrelDosage, YesNo dipyridamole, String dipyridamoleDosage, YesNo aspirinPlusDipyridamole, String aspirinPlusDipyridamoleDosage, YesNo warfarin, YesNo statin, String statinDosage, String statinName, YesNo antihypertensive, String spouseName, String spouseAddress, Timestamp spouseDateOfBirth, Gender spouseGender, String spouseLandlinePhoneNumber, String spouseCellPhoneNumber, String spouseFriendPhoneNumber, String spousePlaceOfBirth, String spouseEthnicity, String spouseNativeLanguage, String spouseReligion, YesNo spouseHypertension, YesNo spouseDiabetesMellitus, YesNo spouseIhdAngina, YesNo spouseHypercholesterolemia, YesNo spouseAtrialFibrillation, YesNo spousePvd, YesNo spouseMi, YesNo spouseMigraineWithAura, YesNo spouseMigraineWithoutAura, YesNo spouseIschaemicStroke, YesNo spouseHoemorrhagicStroke, YesNo spouseTia, String bpToday) {
        this.patientIdNumber = patientIdNumber;
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
        this.bpToday = bpToday;
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

    public String getSpouseDateOfBirthString() {
        DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("MM/dd/yyyy");
        return spouseDateOfBirth == null ? StringUtils.EMPTY : DATE_TIME_FORMATTER.print(spouseDateOfBirth.getTime());
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

    public String getBpToday() {
        return bpToday;
    }

    public String getBpToday1() {
        if(StringUtils.isEmpty(bpToday)) {
            return StringUtils.EMPTY;
        } else {
            return bpToday.split("/").length <= 0 ? StringUtils.EMPTY : bpToday.split("/")[0];
        }
    }

    public String getBpToday2() {
        if(StringUtils.isEmpty(bpToday)) {
            return StringUtils.EMPTY;
        } else {
            return bpToday.split("/").length <= 0 ? StringUtils.EMPTY : bpToday.split("/")[1];
        }
    }

    public void setBpToday(String bpToday) {
        this.bpToday = bpToday;
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
