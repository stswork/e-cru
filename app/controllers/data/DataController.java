package controllers.data;

import actions.Authenticated;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import models.YesNo;
import models.data.form.*;
import models.response.ResponseMessage;
import models.response.ResponseMessageType;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by Sagar Gopale on 5/6/14.
 */
public class DataController extends Controller {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");
    private static final String URL_SEPARATOR = "/";

    @With(Authenticated.class)
    public static Result form1(){
        session("pid", StringUtils.EMPTY);
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        return ok(views.html.data.form1.render("Form1",u));
    }

    @With(Authenticated.class)
    public static Result form2(){
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        if(StringUtils.isEmpty(session("pid")))
            return redirect(controllers.data.routes.DataController.form1());
        Integer pid = Integer.valueOf(session("pid"));
        return ok(views.html.data.form2.render("Form2", u, pid));
    }

    @With(Authenticated.class)
    public static Result form3(){
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        if(StringUtils.isEmpty(session("pid")))
            return redirect(controllers.data.routes.DataController.form1());
        Integer pid = Integer.valueOf(session("pid"));
        return ok(views.html.data.form3.render("Form3", u, pid));
    }

    @With(Authenticated.class)
    public static Result form4(){
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        if(StringUtils.isEmpty(session("pid")))
            return redirect(controllers.data.routes.DataController.form1());
        Integer pid = Integer.valueOf(session("pid"));
        return ok(views.html.data.form4.render("Form4", u, pid));
    }

    @With(Authenticated.class)
    public static Result form5(){
        session("pid", "2");
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        if(StringUtils.isEmpty(session("pid")))
            return redirect(controllers.data.routes.DataController.form1());
        Integer pid = Integer.valueOf(session("pid"));
        return ok(views.html.data.form5.render("Form5", u, pid));
    }

    @With(Authenticated.class)
    public static Result form6(){
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        if(StringUtils.isEmpty(session("pid")))
            return redirect(controllers.data.routes.DataController.form1());
        Integer pid = Integer.valueOf(session("pid"));
        return ok(views.html.data.form6.render("Form6", u, pid));
    }

    @With(Authenticated.class)
    public static Result handleSaveForm1() {
        DataCollectionForm1 dcf1 = new DataCollectionForm1();
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
        Integer patientIdNumber = Integer.valueOf(StringUtils.isEmpty(map.get("patientIdNumber")[0]) ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);
        String trialSite = StringUtils.isEmpty(map.get("trialSite")[0]) ? StringUtils.EMPTY : map.get("trialSite")[0];
        String dateRecruited = StringUtils.isEmpty(map.get("dateRecruited")[0]) ? StringUtils.EMPTY : map.get("dateRecruited")[0];
        String dateRecruitedMonth = StringUtils.isEmpty(map.get("dateRecruitedMonth")[0]) ? StringUtils.EMPTY : map.get("dateRecruitedMonth")[0];
        String dateRecruitedYear = StringUtils.isEmpty(map.get("dateRecruitedYear")[0]) ? StringUtils.EMPTY : map.get("dateRecruitedYear")[0];
        DateTime recruitedDate = DATE_TIME_FORMATTER.parseDateTime(dateRecruited + URL_SEPARATOR + dateRecruitedMonth + URL_SEPARATOR + dateRecruitedYear);
        String patientName = StringUtils.isEmpty(map.get("patientName")[0]) ? StringUtils.EMPTY : map.get("patientName")[0];
        String patientDobDate = StringUtils.isEmpty(map.get("patientDobDate")[0]) ? StringUtils.EMPTY : map.get("patientDobDate")[0];
        String patientDobMonth = StringUtils.isEmpty(map.get("patientDobMonth")[0]) ? StringUtils.EMPTY : map.get("patientDobMonth")[0];
        String patientDobYear = StringUtils.isEmpty(map.get("patientDobYear")[0]) ? StringUtils.EMPTY : map.get("patientDobYear")[0];
        DateTime datePatientDob = null;
        try {
            datePatientDob = DATE_TIME_FORMATTER.parseDateTime(patientDobDate + URL_SEPARATOR + patientDobMonth + URL_SEPARATOR + patientDobYear);
        } catch (Exception e) {
            Logger.info("INVALID DATE STRING FOR BLOOD SAMPLE DATE");
        }
        String patientAddress = StringUtils.isEmpty(map.get("patientAddress")[0]) ? StringUtils.EMPTY : map.get("patientAddress")[0];
        Gender gender = Gender.valueOf(StringUtils.isEmpty(map.get("gender")[0]) ? "MALE" : map.get("gender")[0].toUpperCase());
        String landlinePhoneNumber = StringUtils.isEmpty(map.get("landlinePhoneNumber")[0]) ? StringUtils.EMPTY : map.get("landlinePhoneNumber")[0];
        String cellPhoneNumber = StringUtils.isEmpty(map.get("cellPhoneNumber")[0]) ? StringUtils.EMPTY : map.get("cellPhoneNumber")[0];
        String friendRelativePhoneNumber = StringUtils.isEmpty(map.get("friendRelativePhoneNumber")[0]) ? StringUtils.EMPTY : map.get("friendRelativePhoneNumber")[0];
        String placeOfBirth = StringUtils.isEmpty(map.get("placeOfBirth")[0]) ? StringUtils.EMPTY : map.get("placeOfBirth")[0];
        String ethnicity = StringUtils.isEmpty(map.get("ethnicity")[0]) ? StringUtils.EMPTY : map.get("ethnicity")[0];
        String nativeLanguage = StringUtils.isEmpty(map.get("nativeLanguage")[0]) ? StringUtils.EMPTY : map.get("nativeLanguage")[0];
        String religion = StringUtils.isEmpty(map.get("religion")[0]) ? StringUtils.EMPTY : map.get("religion")[0];
        String[] economicStatuses = map.get("economicStatuses[]") == null ? new String[0] : map.get("economicStatuses[]");
        YesNo bloodSampleTaken = YesNo.valueOf(StringUtils.isEmpty(map.get("bloodSampleTaken")[0]) ? StringUtils.EMPTY : map.get("bloodSampleTaken")[0].toUpperCase());
        String bloodSampleDate = StringUtils.isEmpty(map.get("bloodSampleDate")[0]) ? StringUtils.EMPTY : map.get("bloodSampleDate")[0];
        String bloodSampleMonth = StringUtils.isEmpty(map.get("bloodSampleMonth")[0]) ? StringUtils.EMPTY : map.get("bloodSampleMonth")[0];
        String bloodSampleYear = StringUtils.isEmpty(map.get("bloodSampleYear")[0]) ? StringUtils.EMPTY : map.get("bloodSampleYear")[0];
        DateTime dateBloodSampleTaken = null;
        try {
            dateBloodSampleTaken = DATE_TIME_FORMATTER.parseDateTime(bloodSampleDate + URL_SEPARATOR + bloodSampleMonth + URL_SEPARATOR + bloodSampleYear);
        } catch (Exception e) {
            Logger.info("INVALID DATE STRING FOR BLOOD SAMPLE DATE");
        }
        String bloodSampleNumber = StringUtils.isEmpty(map.get("bloodSampleNumber")[0]) ? StringUtils.EMPTY : map.get("bloodSampleNumber")[0];
        String strokeDate = StringUtils.isEmpty(map.get("strokeDate")[0]) ? StringUtils.EMPTY : map.get("strokeDate")[0];
        String strokeMonth = StringUtils.isEmpty(map.get("strokeMonth")[0]) ? StringUtils.EMPTY : map.get("strokeMonth")[0];
        String strokeYear = StringUtils.isEmpty(map.get("strokeYear")[0]) ? StringUtils.EMPTY : map.get("strokeYear")[0];
        DateTime dateStroke = null;
        try {
            dateStroke = DATE_TIME_FORMATTER.parseDateTime(strokeDate + URL_SEPARATOR + strokeMonth + URL_SEPARATOR + strokeYear);
        } catch (Exception e) {
            Logger.info("INVALID DATE STRING FOR BLOOD SAMPLE DATE");
        }
        if(id > 0) {
            dcf1 = DataCollectionForm1.find.byId(id);
            if(dcf1 == null)
                return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        }
        dcf1.setPatientIdNumber(patientIdNumber);
        dcf1.setTrialSite(trialSite);
        dcf1.setRecruitedDate(recruitedDate == null ? null : new Timestamp(recruitedDate.getMillis()));
        dcf1.setPatientName(patientName);
        dcf1.setDateOfBirth(datePatientDob == null ? null : new Timestamp(datePatientDob.getMillis()));
        dcf1.setPatientAddress(patientAddress);
        dcf1.setGender(gender);
        dcf1.setLandlinePhoneNumber(landlinePhoneNumber);
        dcf1.setCellPhoneNumber(cellPhoneNumber);
        dcf1.setFriendRelativePhoneNumber(friendRelativePhoneNumber);
        dcf1.setPlaceOfBirth(placeOfBirth);
        dcf1.setEthnicity(ethnicity);
        dcf1.setNativeLanguage(nativeLanguage);
        dcf1.setReligion(religion);
        dcf1.setBloodSampleTaken(bloodSampleTaken);
        dcf1.setBloodSampleDate(dateBloodSampleTaken == null ? null : new Timestamp(dateBloodSampleTaken.getMillis()));
        dcf1.setBloodSampleNumber(bloodSampleNumber);
        dcf1.setDateOfStroke(dateStroke == null ? null : new Timestamp(dateStroke.getMillis()));
        if(id == 0) {
            dcf1.save();
            for(String s: economicStatuses) {
                EconomicStatus es = new EconomicStatus(s, dcf1, null);
                es.save();
            }
        } else if (id > 0) {
            dcf1.update();
            for(String s: economicStatuses) {
                EconomicStatus status = Ebean.find(EconomicStatus.class).fetch("dataCollectionForm1").where(
                        Expr.and(
                                Expr.eq("dataCollectionForm1", id),
                                Expr.ieq("name", s)
                        )
                ).setMaxRows(1).findUnique();
                if(status == null) {
                    status = new EconomicStatus(s, dcf1, null);
                    status.save();
                }
            }
        }
        session("pid", patientIdNumber.toString());
        return ok(Json.toJson(new ResponseMessage(200, "Form one saved successfully", ResponseMessageType.SUCCESSFUL)));
    }

    @With(Authenticated.class)
     public static Result handleSaveForm2() {
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        return ok(Json.toJson(new ResponseMessage(200, "Form two saved successfully", ResponseMessageType.SUCCESSFUL)));
    }

    @With(Authenticated.class)
    public static Result handleSaveForm4() {
        DataCollectionForm4 dcf4 = new DataCollectionForm4();
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
        Integer patientIdNumber = Integer.valueOf(StringUtils.isEmpty(map.get("patientIdNumber")[0]) ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);
        YesNo intracranialStenosis = YesNo.valueOf(StringUtils.isEmpty(map.get("intracranialStenosis")[0]) ? StringUtils.EMPTY : map.get("intracranialStenosis")[0]);
        String intracranialStenosisPercent = StringUtils.isEmpty(map.get("intracranialStenosisPercent")[0]) ? StringUtils.EMPTY : map.get("intracranialStenosisPercent")[0];
        YesNo extracranialDopplersImagingDone = YesNo.valueOf(StringUtils.isEmpty(map.get("extracranialDopplersImagingDone")[0]) ? StringUtils.EMPTY : map.get("extracranialDopplersImagingDone")[0]);
        YesNo extracranialMraImagingDone = YesNo.valueOf(StringUtils.isEmpty(map.get("extracranialMraImagingDone")[0]) ? StringUtils.EMPTY : map.get("extracranialMraImagingDone")[0]);
        YesNo extracranialCtaImagingDone = YesNo.valueOf(StringUtils.isEmpty(map.get("extracranialCtaImagingDone")[0]) ? StringUtils.EMPTY : map.get("extracranialCtaImagingDone")[0]);
        YesNo brainCtImagingDone = YesNo.valueOf(StringUtils.isEmpty(map.get("brainCtImagingDone")[0]) ? StringUtils.EMPTY : map.get("brainCtImagingDone")[0]);
        YesNo brainMriImagingDone = YesNo.valueOf(StringUtils.isEmpty(map.get("brainMriImagingDone")[0]) ? StringUtils.EMPTY : map.get("brainMriImagingDone")[0]);
        YesNo anterior = !map.containsKey("anterior") ? YesNo.NO : YesNo.YES;
        YesNo right = !map.containsKey("right") ? YesNo.NO : YesNo.YES;
        YesNo left = !map.containsKey("left") ? YesNo.NO : YesNo.YES;
        YesNo bilateral = !map.containsKey("bilateral") ? YesNo.NO : YesNo.YES;
        YesNo posterior = !map.containsKey("posterior") ? YesNo.NO : YesNo.YES;
        YesNo anterioposterior = !map.containsKey("anterioposterior") ? YesNo.NO : YesNo.YES;
        Double ricaStenosisPercent = Double.valueOf(StringUtils.isEmpty(map.get("ricaStenosisPercent")[0]) ? "0" : map.get("ricaStenosisPercent")[0]);
        Double licaStenosisPercent = Double.valueOf(StringUtils.isEmpty(map.get("licaStenosisPercent")[0]) ? "0" : map.get("licaStenosisPercent")[0]);
        Double rccaStenosisPercent = Double.valueOf(StringUtils.isEmpty(map.get("rccaStenosisPercent")[0]) ? "0" : map.get("rccaStenosisPercent")[0]);
        Double lccaStenosisPercent = Double.valueOf(StringUtils.isEmpty(map.get("lccaStenosisPercent")[0]) ? "0" : map.get("lccaStenosisPercent")[0]);
        Double rVertebralStenosisPercent = Double.valueOf(StringUtils.isEmpty(map.get("rVertebralStenosisPercent")[0]) ? "0" : map.get("rVertebralStenosisPercent")[0]);
        Double lVertebralStenosisPercent = Double.valueOf(StringUtils.isEmpty(map.get("lVertebralStenosisPercent")[0]) ? "0" : map.get("lVertebralStenosisPercent")[0]);
        Double basilarStenosisPercent = Double.valueOf(StringUtils.isEmpty(map.get("basilarStenosisPercent")[0]) ? StringUtils.EMPTY : map.get("basilarStenosisPercent")[0]);
        YesNo lvd = !map.containsKey("lvd") ? YesNo.NO : YesNo.YES;
        YesNo svd = !map.containsKey("svd") ? YesNo.NO : YesNo.YES;
        YesNo cardioembolism = !map.containsKey("cardioembolism") ? YesNo.NO : YesNo.YES;
        YesNo combined = !map.containsKey("combined") ? YesNo.NO : YesNo.YES;
        YesNo strokeOfDeterminedEtiology = !map.containsKey("strokeOfDeterminedEtiology") ? YesNo.NO : YesNo.YES;
        YesNo negativeEvaluation = !map.containsKey("negativeEvaluation") ? YesNo.NO : YesNo.YES;
        YesNo ecgDone = YesNo.valueOf(StringUtils.isEmpty(map.get("ecgDone")[0]) ? StringUtils.EMPTY : map.get("ecgDone")[0]);
        YesNo echoDone = YesNo.valueOf(StringUtils.isEmpty(map.get("echoDone")[0]) ? StringUtils.EMPTY : map.get("echoDone")[0]);
        YesNo ecgNormal = YesNo.valueOf(map.containsKey("ecgNormal") ? StringUtils.EMPTY : map.get("ecgNormal")[0]);
        YesNo ecgLvf = !map.containsKey("ecgLvf") ? YesNo.NO : YesNo.YES;
        YesNo ecgAf = !map.containsKey("ecgAf") ? YesNo.NO : YesNo.YES;
        YesNo ecgVentricularEctopics = !map.containsKey("ecgVentricularEctopics") ? YesNo.NO : YesNo.YES;
        YesNo ecgArtialEctopics = !map.containsKey("ecgArtialEctopics") ? YesNo.NO : YesNo.YES;
        YesNo ecgNoneOfAbove = !map.containsKey("ecgNoneOfAbove") ? YesNo.NO : YesNo.YES;
        YesNo ecgDontKnow = !map.containsKey("ecgDontKnow") ? YesNo.NO : YesNo.YES;
        YesNo echoNormal = !map.containsKey("echoNormal") ? YesNo.NO : YesNo.YES;
        YesNo echoLvh = !map.containsKey("echoLvh") ? YesNo.NO : YesNo.YES;
        YesNo echoPfo = !map.containsKey("echoPfo") ? YesNo.NO : YesNo.YES;
        YesNo echoThrombus = !map.containsKey("echoThrombus") ? YesNo.NO : YesNo.YES;
        YesNo echoNoneOfAbove = !map.containsKey("echoNoneOfAbove") ? YesNo.NO : YesNo.YES;
        YesNo echoDontKnow = !map.containsKey("echoDontKnow") ? YesNo.NO : YesNo.YES;
        String nihssOnAdmission = StringUtils.isEmpty(map.get("nihssOnAdmission")[0]) ? StringUtils.EMPTY : map.get("nihssOnAdmission")[0];
        String nihssOnDischarge = StringUtils.isEmpty(map.get("nihssOnDischarge")[0]) ? StringUtils.EMPTY : map.get("nihssOnDischarge")[0];
        String barthelOnAdmission = StringUtils.isEmpty(map.get("barthelOnAdmission")[0]) ? StringUtils.EMPTY : map.get("barthelOnAdmission")[0];
        String barthelOnDischarge = StringUtils.isEmpty(map.get("barthelOnDischarge")[0]) ? StringUtils.EMPTY : map.get("barthelOnDischarge")[0];
        YesNo home = !map.containsKey("home") ? YesNo.NO : YesNo.YES;
        YesNo nursingHome = !map.containsKey("nursingHome") ? YesNo.NO : YesNo.YES;
        YesNo rehabilitation = !map.containsKey("rehabilitation") ? YesNo.NO : YesNo.YES;
        YesNo rip = !map.containsKey("rip") ? YesNo.NO : YesNo.YES;
        YesNo localDgh = !map.containsKey("localDgh") ? YesNo.NO : YesNo.YES;
        dcf4.setPatientIdNumber(patientIdNumber);
        dcf4.setIntracranialStenosis(intracranialStenosis);
        dcf4.setIntracranialStenosisPercent(intracranialStenosisPercent);
        dcf4.setExtracranialDopplersImagingDone(extracranialDopplersImagingDone);
        dcf4.setExtracranialMraImagingDone(extracranialMraImagingDone);
        dcf4.setExtracranialCtaImagingDone(extracranialCtaImagingDone);
        dcf4.setBrainCtImagingDone(brainCtImagingDone);
        dcf4.setBrainMriImagingDone(brainMriImagingDone);
        dcf4.setLesionAnterior(anterior);
        dcf4.setLesionRight(right);
        dcf4.setLesionLeft(left);
        dcf4.setLesionBilateral(bilateral);
        dcf4.setLesionPosterior(posterior);
        dcf4.setLesionAnterioposterior(anterioposterior);
        dcf4.setRicaStenosisPercent(ricaStenosisPercent);
        dcf4.setLicaStenosisPercent(licaStenosisPercent);
        dcf4.setRccaStenosisPercent(rccaStenosisPercent);
        dcf4.setLccaStenosisPercent(lccaStenosisPercent);
        dcf4.setrVertebralStenosisPercent(rVertebralStenosisPercent);
        dcf4.setlVertebralStenosisPercent(lVertebralStenosisPercent);
        dcf4.setBasilarStenosisPercent(basilarStenosisPercent);
        dcf4.setLvd(lvd);
        dcf4.setSvd(svd);
        dcf4.setCardioembolism(cardioembolism);
        dcf4.setCombined(combined);
        dcf4.setStrokeOfDeterminedEtiology(strokeOfDeterminedEtiology);
        dcf4.setNegativeEvaluation(negativeEvaluation);
        dcf4.setEcgDone(ecgDone);
        dcf4.setEchoDone(echoDone);
        dcf4.setEcgNormal(ecgNormal);
        dcf4.setEcgLvh(ecgLvf);
        dcf4.setEcgAf(ecgAf);
        dcf4.setEcgVentricularEctopics(ecgVentricularEctopics);
        dcf4.setEcgArtialEctopics(ecgArtialEctopics);
        dcf4.setEcgNoneOfAbove(ecgNoneOfAbove);
        dcf4.setEcgDontKnow(ecgDontKnow);
        dcf4.setEchoNormal(echoNormal);
        dcf4.setEchoLvh(echoLvh);
        dcf4.setEchoPfo(echoPfo);
        dcf4.setEchoThrombus(echoThrombus);
        dcf4.setEchoNoneOfAbove(echoNoneOfAbove);
        dcf4.setEchoDontKnow(echoDontKnow);
        dcf4.setNihssOnAdmission(nihssOnAdmission);
        dcf4.setNihssOnDischarge(nihssOnDischarge);
        dcf4.setBarthelOnAdmission(barthelOnAdmission);
        dcf4.setBarthelOnDischarge(barthelOnDischarge);
        dcf4.setHome(home);
        dcf4.setNursingHome(nursingHome);
        dcf4.setRehabilitation(rehabilitation);
        dcf4.setRip(rip);
        dcf4.setLocalDgh(localDgh);
        if(id > 0)
            dcf4.update();
        else
            dcf4.save();
        session("pid", patientIdNumber.toString());
        return ok(Json.toJson(new ResponseMessage(200, "Form four saved successfully", ResponseMessageType.SUCCESSFUL)));
    }

    @With(Authenticated.class)
    public static Result handleSaveForm5() {
        DataCollectionForm5 dcf5 = new DataCollectionForm5();
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
        Integer patientIdNumber = Integer.valueOf(StringUtils.isEmpty(map.get("patientIdNumber")[0]) ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);
        String aspirin = map.containsKey("aspirin") ? StringUtils.EMPTY : map.get("aspirin")[0];
        String clopidogrel = map.containsKey("clopidogrel") ? StringUtils.EMPTY : map.get("clopidogrel")[0];
        String aspirinPlusClopidogrel = StringUtils.isEmpty(map.get("aspirinPlusClopidogrel")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrel")[0];
        String dipyridamole = map.containsKey("dipyridamole") ? StringUtils.EMPTY : map.get("dipyridamole")[0];
        String aspirinPlusDipyridamole = map.containsKey("aspirinPlusDipyridamole1") ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamole1")[0];
        String antihypertensive = map.containsKey("antihypertensive") ? StringUtils.EMPTY : map.get("antihypertensive")[0];
        String warfarin = map.containsKey("warfarin") ? StringUtils.EMPTY : map.get("warfarin")[0];
        String statin = map.containsKey("statin") ? StringUtils.EMPTY : map.get("statin")[0];
        if(id > 0) {
            dcf5 = DataCollectionForm5.find.byId(id);
            if(dcf5 == null)
                return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        }
        if(!StringUtils.isEmpty(aspirin)){
            String aspirinDosage = StringUtils.isEmpty(map.get("aspirinDosage")[0]) ? StringUtils.EMPTY : map.get("aspirinDosage")[0];
            dcf5.setAspirin(YesNo.YES);
            dcf5.setAspirinDosage(aspirinDosage);
        }
        if(!StringUtils.isEmpty(clopidogrel)){
            String clopidogrelDosage = StringUtils.isEmpty(map.get("clopidogrelDosage")[0]) ? StringUtils.EMPTY : map.get("clopidogrelDosage")[0];
            dcf5.setClopidogrel(YesNo.YES);
            dcf5.setClopidogrelDosage(clopidogrelDosage);
        }
        if(!StringUtils.isEmpty(aspirinPlusClopidogrel)){
            String aspirinPlusClopidogrelDosage1 = StringUtils.isEmpty(map.get("aspirinPlusClopidogrelDosage1")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrelDosage1")[0];
            String aspirinPlusClopidogrelDosage2 = StringUtils.isEmpty(map.get("aspirinPlusClopidogrelDosage2")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrelDosage2")[0];
            dcf5.setAspirinPlusClopidogrel(YesNo.YES);
            dcf5.setAspirinPlusClopidogrelDosage(aspirinPlusClopidogrelDosage1 + "+" + aspirinPlusClopidogrelDosage2);
        }
        if(!StringUtils.isEmpty(dipyridamole)){
            String dipyridamoleDosage = StringUtils.isEmpty(map.get("dipyridamoleDosage")[0]) ? StringUtils.EMPTY : map.get("dipyridamoleDosage")[0];
            dcf5.setDipyridamole(YesNo.YES);
            dcf5.setDipyridamoleDosage(dipyridamoleDosage);
        }
        if(!StringUtils.isEmpty(aspirinPlusDipyridamole)){
            String aspirinPlusDipyridamoleDosage1 = StringUtils.isEmpty(map.get("aspirinPlusDipyridamoleDosage1")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamoleDosage1")[0];
            String aspirinPlusDipyridamoleDosage2 = StringUtils.isEmpty(map.get("aspirinPlusDipyridamoleDosage2")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamoleDosage2")[0];
            dcf5.setAspirinPlusDipyridamole(YesNo.YES);
            dcf5.setAspirinPlusDipyridamoleDosage(aspirinPlusDipyridamoleDosage1 + "+" + aspirinPlusDipyridamoleDosage2);
        }
        if(!StringUtils.isEmpty(antihypertensive)){
            dcf5.setAntihypertensive(YesNo.YES);
        }
        if(!StringUtils.isEmpty(warfarin)){
            dcf5.setWarfarin(YesNo.YES);
        }
        if(!StringUtils.isEmpty(statin)){
            String statinDosage = StringUtils.isEmpty(map.get("statinDosage")[0]) ? StringUtils.EMPTY : map.get("statinDosage")[0];
            String statinName = StringUtils.isEmpty(map.get("statinName")[0]) ? StringUtils.EMPTY : map.get("statinName")[0];
            dcf5.setStatin(YesNo.YES);
            dcf5.setStatinDosage(statinDosage);
            dcf5.setStatinName(statinName);
        }
        String spouseDobDate = StringUtils.isEmpty(map.get("spouseDobDate")[0]) ? StringUtils.EMPTY : map.get("spouseDobDate")[0];
        String spouseDobMonth = StringUtils.isEmpty(map.get("spouseDobMonth")[0]) ? StringUtils.EMPTY : map.get("spouseDobMonth")[0];
        String spouseDobYear = StringUtils.isEmpty(map.get("spouseDobYear")[0]) ? StringUtils.EMPTY : map.get("spouseDobYear")[0];
        DateTime spouseDateOfBirth = null;
        try {
            spouseDateOfBirth = DATE_TIME_FORMATTER.parseDateTime(spouseDobDate + URL_SEPARATOR + spouseDobMonth + URL_SEPARATOR + spouseDobYear);
        } catch (Exception e) {
            Logger.info("INVALID DATE STRING FOR BLOOD SAMPLE DATE");
        }
        String spouseName = StringUtils.isEmpty(map.get("spouseName")[0]) ? StringUtils.EMPTY : map.get("spouseName")[0];
        String spouseAddress = StringUtils.isEmpty(map.get("spouseAddress")[0]) ? StringUtils.EMPTY : map.get("spouseAddress")[0];
        Gender spouseGender = Gender.valueOf(StringUtils.isEmpty(map.get("spouseGender")[0]) ? StringUtils.EMPTY : map.get("spouseGender")[0]);
        String spouseLandlinePhoneNumber = StringUtils.isEmpty(map.get("spouseLandlinePhoneNumber")[0]) ? StringUtils.EMPTY : map.get("spouseLandlinePhoneNumber")[0];
        String spouseCellPhoneNumber = StringUtils.isEmpty(map.get("spouseCellPhoneNumber")[0]) ? StringUtils.EMPTY : map.get("spouseCellPhoneNumber")[0];
        String spouseFriendPhoneNumber = StringUtils.isEmpty(map.get("spouseFriendPhoneNumber")[0]) ? StringUtils.EMPTY : map.get("spouseFriendPhoneNumber")[0];
        String spousePlaceOfBirth = StringUtils.isEmpty(map.get("spousePlaceOfBirth")[0]) ? StringUtils.EMPTY : map.get("spousePlaceOfBirth")[0];
        String spouseEthnicity = StringUtils.isEmpty(map.get("spouseEthnicity")[0]) ? StringUtils.EMPTY : map.get("spouseEthnicity")[0];
        String spouseReligion = StringUtils.isEmpty(map.get("spouseReligion")[0]) ? StringUtils.EMPTY : map.get("spouseReligion")[0];
        String spouseNativeLanguage = StringUtils.isEmpty(map.get("spouseNativeLanguage")[0]) ? StringUtils.EMPTY : map.get("spouseNativeLanguage")[0];
        String bpToday1 = StringUtils.isEmpty(map.get("bpToday1")[0]) ? StringUtils.EMPTY : map.get("bpToday1")[0];
        String bpToday2 = StringUtils.isEmpty(map.get("bpToday2")[0]) ? StringUtils.EMPTY : map.get("bpToday2")[0];
        YesNo spouseHypertension = YesNo.valueOf(StringUtils.isEmpty(map.get("spouseHypertension")[0]) ? StringUtils.EMPTY : map.get("spouseHypertension")[0]);
        YesNo spouseDiabetesMellitus = YesNo.valueOf(StringUtils.isEmpty(map.get("spouseDiabetesMellitus")[0]) ? StringUtils.EMPTY : map.get("spouseDiabetesMellitus")[0]);
        YesNo spouseIhdAngina = YesNo.valueOf(StringUtils.isEmpty(map.get("spouseIhdAngina")[0]) ? StringUtils.EMPTY : map.get("spouseIhdAngina")[0]);
        YesNo spouseHypercholesterolemia = YesNo.valueOf(StringUtils.isEmpty(map.get("spouseHypercholesterolemia")[0]) ? StringUtils.EMPTY : map.get("spouseHypercholesterolemia")[0]);
        YesNo spouseAtrialFibrillation = YesNo.valueOf(StringUtils.isEmpty(map.get("spouseAtrialFibrillation")[0]) ? StringUtils.EMPTY : map.get("spouseAtrialFibrillation")[0]);
        YesNo spousePvd = YesNo.valueOf(StringUtils.isEmpty(map.get("spousePvd")[0]) ? StringUtils.EMPTY : map.get("spousePvd")[0]);
        YesNo spouseMi = YesNo.valueOf(StringUtils.isEmpty(map.get("spouseMi")[0]) ? StringUtils.EMPTY : map.get("spouseMi")[0]);
        YesNo spouseMigraineWithAura = YesNo.valueOf(StringUtils.isEmpty(map.get("spouseMigraineWithAura")[0]) ? StringUtils.EMPTY : map.get("spouseMigraineWithAura")[0]);
        YesNo spouseMigraineWithoutAura = YesNo.valueOf(StringUtils.isEmpty(map.get("spouseMigraineWithoutAura")[0]) ? StringUtils.EMPTY : map.get("spouseMigraineWithoutAura")[0]);
        YesNo ischaemicStroke = YesNo.valueOf(StringUtils.isEmpty(map.get("ischaemicStroke")[0]) ? StringUtils.EMPTY : map.get("ischaemicStroke")[0]);
        YesNo hoemorrhagicStroke = YesNo.valueOf(StringUtils.isEmpty(map.get("hoemorrhagicStroke")[0]) ? StringUtils.EMPTY : map.get("hoemorrhagicStroke")[0]);
        YesNo tia = YesNo.valueOf(StringUtils.isEmpty(map.get("tia")[0]) ? StringUtils.EMPTY : map.get("tia")[0]);
        dcf5.setPatientIdNumber(patientIdNumber);
        dcf5.setSpouseName(spouseName);
        dcf5.setSpouseAddress(spouseAddress);
        dcf5.setSpouseDateOfBirth(spouseDateOfBirth == null ? null : new Timestamp(spouseDateOfBirth.getMillis()));
        dcf5.setSpouseGender(spouseGender);
        dcf5.setSpouseLandlinePhoneNumber(spouseLandlinePhoneNumber);
        dcf5.setSpouseCellPhoneNumber(spouseCellPhoneNumber);
        dcf5.setSpouseFriendPhoneNumber(spouseFriendPhoneNumber);
        dcf5.setSpousePlaceOfBirth(spousePlaceOfBirth);
        dcf5.setSpouseEthnicity(spouseEthnicity);
        dcf5.setSpouseNativeLanguage(spouseNativeLanguage);
        dcf5.setSpouseReligion(spouseReligion);
        dcf5.setSpouseHypertension(spouseHypertension);
        dcf5.setSpouseDiabetesMellitus(spouseDiabetesMellitus);
        dcf5.setSpouseIhdAngina(spouseIhdAngina);
        dcf5.setSpouseHypercholesterolemia(spouseHypercholesterolemia);
        dcf5.setSpouseAtrialFibrillation(spouseAtrialFibrillation);
        dcf5.setSpousePvd(spousePvd);
        dcf5.setSpouseMi(spouseMi);
        dcf5.setSpouseMigraineWithAura(spouseMigraineWithAura);
        dcf5.setSpouseMigraineWithoutAura(spouseMigraineWithoutAura);
        dcf5.setSpouseIschaemicStroke(ischaemicStroke);
        dcf5.setSpouseHoemorrhagicStroke(hoemorrhagicStroke);
        dcf5.setSpouseTia(tia);
        dcf5.setBpToday(bpToday1 + "/" + bpToday2);
        if(id > 0)
            dcf5.update();
        else
            dcf5.save();
        session("pid", patientIdNumber.toString());
        return ok(Json.toJson(new ResponseMessage(200, "Form five saved successfully", ResponseMessageType.SUCCESSFUL)));
    }

    @With(Authenticated.class)
    public static Result handleSaveForm6() {
        DataCollectionForm6 dcf6 = new DataCollectionForm6();
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
        Integer patientIdNumber = Integer.valueOf(StringUtils.isEmpty(map.get("patientIdNumber")[0]) ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);
        Double hip = Double.valueOf(StringUtils.isEmpty(map.get("hip")[0]) ? "0" : map.get("hip")[0]);
        Double height = Double.valueOf(StringUtils.isEmpty(map.get("height")[0]) ? "0" : map.get("height")[0]);
        Double waist = Double.valueOf(StringUtils.isEmpty(map.get("waist")[0]) ? "0" : map.get("waist")[0]);
        Double weight = Double.valueOf(StringUtils.isEmpty(map.get("weight")[0]) ? "0" : map.get("weight")[0]);
        Double bmi = Double.valueOf(StringUtils.isEmpty(map.get("bmi")[0]) ? "0" : map.get("bmi")[0]);
        YesNo bloodSampleTaken = YesNo.valueOf(StringUtils.isEmpty(map.get("bloodSampleTaken")[0]) ? StringUtils.EMPTY : map.get("bloodSampleTaken")[0].toUpperCase());
        String bloodSampleDate = StringUtils.isEmpty(map.get("bloodSampleDate")[0]) ? StringUtils.EMPTY : map.get("bloodSampleDate")[0];
        String bloodSampleMonth = StringUtils.isEmpty(map.get("bloodSampleMonth")[0]) ? StringUtils.EMPTY : map.get("bloodSampleMonth")[0];
        String bloodSampleYear = StringUtils.isEmpty(map.get("bloodSampleYear")[0]) ? StringUtils.EMPTY : map.get("bloodSampleYear")[0];
        String[] economicStatuses = map.get("economicStatuses[]") == null ? new String[0] : map.get("economicStatuses[]");
        DateTime dateBloodSampleTaken = null;
        try {
            dateBloodSampleTaken = DATE_TIME_FORMATTER.parseDateTime(bloodSampleDate + URL_SEPARATOR + bloodSampleMonth + URL_SEPARATOR + bloodSampleYear);
        } catch (Exception e) {
            Logger.info("INVALID DATE STRING FOR BLOOD SAMPLE DATE");
        }
        String bloodSampleNumber = StringUtils.isEmpty(map.get("bloodSampleNumber")[0]) ? StringUtils.EMPTY : map.get("bloodSampleNumber")[0];
        if(id > 0) {
            dcf6 = DataCollectionForm6.find.byId(id);
            if(dcf6 == null)
                return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        }
        dcf6.setPatientIdNumber(patientIdNumber);
        dcf6.setHip(hip);
        dcf6.setWaist(waist);
        dcf6.setHeight(height);
        dcf6.setWeight(weight);
        dcf6.setBmi(bmi);
        dcf6.setBloodSampleTaken(bloodSampleTaken);
        dcf6.setBloodSampleDate(dateBloodSampleTaken == null ? null : new Timestamp(dateBloodSampleTaken.getMillis()));
        dcf6.setBloodSampleNumber(bloodSampleNumber);
        if(id == 0) {
            dcf6.save();
            for(String s: economicStatuses) {
                EconomicStatus es = new EconomicStatus(s, null, dcf6);
                es.save();
            }
        } else if (id > 0) {
            dcf6.update();
            for(String s: economicStatuses) {
                EconomicStatus status = Ebean.find(EconomicStatus.class).fetch("dataCollectionForm6").where(
                        Expr.and(
                                Expr.eq("dataCollectionForm6", id),
                                Expr.ieq("name", s)
                        )
                ).setMaxRows(1).findUnique();
                if(status == null) {
                    status = new EconomicStatus(s, null, dcf6);
                    status.save();
                }
            }
        }
        return ok(Json.toJson(new ResponseMessage(200, "Form three saved successfully", ResponseMessageType.SUCCESSFUL)));
    }
}
