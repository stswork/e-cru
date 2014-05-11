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
import play.cache.Cache;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import java.net.URL;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
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
        if(id == 0) {
            dcf1 = new DataCollectionForm1(patientIdNumber,
                    trialSite,
                    recruitedDate == null ? null : new Timestamp(recruitedDate.getMillis()),
                    patientName,
                    datePatientDob == null ? null : new Timestamp(datePatientDob.getMillis()),
                    patientAddress,
                    gender,
                    landlinePhoneNumber,
                    cellPhoneNumber,
                    friendRelativePhoneNumber,
                    placeOfBirth,
                    ethnicity,
                    nativeLanguage,
                    religion,
                    bloodSampleTaken,
                    dateBloodSampleTaken == null ? null : new Timestamp(dateBloodSampleTaken.getMillis()),
                    bloodSampleNumber,
                    dateStroke == null ? null : new Timestamp(dateStroke.getMillis()));
            dcf1.save();
            for(String s: economicStatuses) {
                EconomicStatus es = new EconomicStatus(s, dcf1, null);
                es.save();
            }
        } else if (id > 0) {
            dcf1 = DataCollectionForm1.find.byId(id);
            if(dcf1 == null)
                return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
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
    public static Result handleSaveForm5() {

        DataCollectionForm5 dcf5 = new DataCollectionForm5();
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
        Integer patientIdNumber = Integer.valueOf(StringUtils.isEmpty(map.get("patientIdNumber")[0]) ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);
        String[] medicines = map.get("medicines[]") == null ? new String[0] : map.get("medicines[]");
        String aspirinDosage = StringUtils.isEmpty(map.get("aspirinDosage")[0]) ? StringUtils.EMPTY : map.get("aspirinDosage")[0];
        String clopidogrelDosage = StringUtils.isEmpty(map.get("clopidogrelDosage")[0]) ? StringUtils.EMPTY : map.get("clopidogrelDosage")[0];
        String aspirinPlusClopidogrelDosage1 = StringUtils.isEmpty(map.get("aspirinPlusClopidogrelDosage1")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrelDosage1")[0];
        String aspirinPlusClopidogrelDosage2 = StringUtils.isEmpty(map.get("aspirinPlusClopidogrelDosage2")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrelDosage2")[0];
        String dipyridamoleDosage = StringUtils.isEmpty(map.get("dipyridamoleDosage")[0]) ? StringUtils.EMPTY : map.get("dipyridamoleDosage")[0];
        String aspirinPlusDipyridamoleDosage1 = StringUtils.isEmpty(map.get("aspirinPlusDipyridamoleDosage1")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamoleDosage1")[0];
        String aspirinPlusDipyridamoleDosage2 = StringUtils.isEmpty(map.get("aspirinPlusDipyridamoleDosage2")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamoleDosage2")[0];
        String antihypertensiveDosage = StringUtils.isEmpty(map.get("antihypertensiveDosage")[0]) ? StringUtils.EMPTY : map.get("antihypertensiveDosage")[0];
        String warfarinDosage = StringUtils.isEmpty(map.get("warfarinDosage")[0]) ? StringUtils.EMPTY : map.get("warfarinDosage")[0];
        String statinDosage = StringUtils.isEmpty(map.get("statinDosage")[0]) ? StringUtils.EMPTY : map.get("statinDosage")[0];
        String spouseDobDate = StringUtils.isEmpty(map.get("spouseDobDate")[0]) ? StringUtils.EMPTY : map.get("spouseDobDate")[0];
        String spouseDobMonth = StringUtils.isEmpty(map.get("spouseDobMonth")[0]) ? StringUtils.EMPTY : map.get("spouseDobMonth")[0];
        String spouseDobYear = StringUtils.isEmpty(map.get("spouseDobYear")[0]) ? StringUtils.EMPTY : map.get("spouseDobYear")[0];
        DateTime spouseDateOfBirth = null;
        try {
            spouseDateOfBirth = DATE_TIME_FORMATTER.parseDateTime(spouseDobDate + URL_SEPARATOR + spouseDobMonth + URL_SEPARATOR + spouseDobYear);
        } catch (Exception e) {
            Logger.info("INVALID DATE STRING FOR BLOOD SAMPLE DATE");
        }
        Gender spouseGender = Gender.valueOf(StringUtils.isEmpty(map.get("spouseGender")[0]) ? StringUtils.EMPTY : map.get("spouseGender")[0]);
        String spouseLandlinePhoneNumber = StringUtils.isEmpty(map.get("spouseLandlinePhoneNumber")[0]) ? StringUtils.EMPTY : map.get("spouseLandlinePhoneNumber")[0];
        String spouseCellPhoneNumber = StringUtils.isEmpty(map.get("spouseCellPhoneNumber")[0]) ? StringUtils.EMPTY : map.get("spouseCellPhoneNumber")[0];
        String spouseFriendPhoneNumber = StringUtils.isEmpty(map.get("spouseFriendPhoneNumber")[0]) ? StringUtils.EMPTY : map.get("spouseFriendPhoneNumber")[0];
        String spousePlaceOfBirth = StringUtils.isEmpty(map.get("spousePlaceOfBirth")[0]) ? StringUtils.EMPTY : map.get("spousePlaceOfBirth")[0];
        String spouseEthnicity = StringUtils.isEmpty(map.get("spouseEthnicity")[0]) ? StringUtils.EMPTY : map.get("spouseEthnicity")[0];
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
        YesNo ischaemic = YesNo.valueOf(StringUtils.isEmpty(map.get("ischaemic")[0]) ? StringUtils.EMPTY : map.get("ischaemic")[0]);
        YesNo hoemorrhagic = YesNo.valueOf(StringUtils.isEmpty(map.get("hoemorrhagic")[0]) ? StringUtils.EMPTY : map.get("hoemorrhagic")[0]);
        YesNo tia = YesNo.valueOf(StringUtils.isEmpty(map.get("tia")[0]) ? StringUtils.EMPTY : map.get("tia")[0]);
        for(String s: medicines) {

        }
        if(id == 0) {
            //dcf5 = new DataCollectionForm5(patientIdNumber,
              //      aspi)
        } else if (id > 0) {

        }
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
        if(id == 0) {
            dcf6 = new DataCollectionForm6(patientIdNumber,
                    hip,
                    waist,
                    height,
                    weight,
                    bmi,
                    bloodSampleTaken,
                    dateBloodSampleTaken == null ? null : new Timestamp(dateBloodSampleTaken.getMillis()),
                    bloodSampleNumber);
            dcf6.save();
            for(String s: economicStatuses) {
                EconomicStatus es = new EconomicStatus(s, null, dcf6);
                es.save();
            }
        } else if (id > 0) {
            dcf6 = DataCollectionForm6.find.byId(id);
            if(dcf6 == null)
                return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
            dcf6.setPatientIdNumber(patientIdNumber);
            dcf6.setHip(hip);
            dcf6.setWaist(waist);
            dcf6.setHeight(height);
            dcf6.setWeight(weight);
            dcf6.setBmi(bmi);
            dcf6.setBloodSampleTaken(bloodSampleTaken);
            dcf6.setBloodSampleDate(dateBloodSampleTaken == null ? null : new Timestamp(dateBloodSampleTaken.getMillis()));
            dcf6.setBloodSampleNumber(bloodSampleNumber);
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
