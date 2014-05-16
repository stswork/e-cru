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
        if(id > 0) {
            dcf1 = DataCollectionForm1.find.byId(id);
            if(dcf1 == null)
                return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        }
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
        DataCollectionForm2 dcf2 = new DataCollectionForm2();
        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
        if(id > 0) {
            dcf2 = DataCollectionForm2.find.byId(id);
            if(dcf2 == null)
                return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        }
        Integer patientIdNumber = Integer.valueOf(map.get("patientIdNumber").length <= 0 ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);
        YesNo ischaemicStroke = YesNo.valueOf(map.get("ischaemicStroke").length <= 0 ? StringUtils.EMPTY : map.get("ischaemicStroke")[0].toUpperCase());
        YesNo hoemorrhagicStroke = YesNo.valueOf(map.get("hoemorrhagicStroke").length <= 0 ? StringUtils.EMPTY : map.get("hoemorrhagicStroke")[0].toUpperCase());
        YesNo venousSinusThrombosis = YesNo.valueOf(map.get("venousSinusThrombosis").length <= 0 ? StringUtils.EMPTY : map.get("venousSinusThrombosis")[0].toUpperCase());
        YesNo tia = YesNo.valueOf(map.get("tia").length <= 0 ? StringUtils.EMPTY : map.get("tia")[0].toUpperCase());
        YesNo avm = YesNo.valueOf(map.get("avm").length <= 0 ? StringUtils.EMPTY : map.get("avm")[0].toUpperCase());
        YesNo aneurysm = YesNo.valueOf(map.get("aneurysm").length <= 0 ? StringUtils.EMPTY : map.get("aneurysm")[0].toUpperCase());
        YesNo subaranchoid = YesNo.valueOf(map.get("subaranchoid").length <= 0 ? StringUtils.EMPTY : map.get("subaranchoid")[0].toUpperCase());
        YesNo hypertension = YesNo.valueOf(map.get("hypertension").length <= 0 ? StringUtils.EMPTY : map.get("hypertension")[0].toUpperCase());
        YesNo diabetesMellitus = YesNo.valueOf(map.get("diabetesMellitus").length <= 0 ? StringUtils.EMPTY : map.get("diabetesMellitus")[0].toUpperCase());
        YesNo ihdAngina = YesNo.valueOf(map.get("ihdAngina").length <= 0 ? StringUtils.EMPTY : map.get("ihdAngina")[0].toUpperCase());
        YesNo hypercholesterolemia = YesNo.valueOf(map.get("hypercholesterolemia").length <= 0 ? StringUtils.EMPTY : map.get("hypercholesterolemia")[0].toUpperCase());
        YesNo atrialFibrillation = YesNo.valueOf(map.get("atrialFibrillation").length <= 0 ? StringUtils.EMPTY : map.get("atrialFibrillation")[0].toUpperCase());
        YesNo pvd = YesNo.valueOf(map.get("pvd").length <= 0 ? StringUtils.EMPTY : map.get("pvd")[0].toUpperCase());
        YesNo mi = YesNo.valueOf(map.get("mi").length <= 0 ? StringUtils.EMPTY : map.get("mi")[0].toUpperCase());
        YesNo migraineWithAura = YesNo.valueOf(map.get("migraineWithAura").length <= 0 ? StringUtils.EMPTY : map.get("migraineWithAura")[0].toUpperCase());
        YesNo migraineWithoutAura = YesNo.valueOf(map.get("migraineWithoutAura").length <= 0 ? StringUtils.EMPTY : map.get("migraineWithoutAura")[0].toUpperCase());
        Integer ischaemicStrokeYear = 0/*Integer.valueOf(map.get("ischaemicStrokeYear").length <= 0 ? StringUtils.EMPTY : map.get("ischaemicStrokeYear")[0])*/;
        Integer hoemorrhagicStrokeYear = 0/*Integer.valueOf(map.get("hoemorrhagicStrokeYear").length <= 0 ? StringUtils.EMPTY : map.get("hoemorrhagicStrokeYear")[0])*/;
        Integer tiaYear = 0/*Integer.valueOf(map.get("tiaYear").length <= 0 ? StringUtils.EMPTY : map.get("tiaYear")[0])*/;
        YesNo strokeAssociatedWithDissection = YesNo.valueOf(map.get("strokeAssociatedWithDissection").length <= 0 ? StringUtils.EMPTY : map.get("strokeAssociatedWithDissection")[0].toUpperCase());
        YesNo strokeAssociatedWithPfo = YesNo.valueOf(map.get("strokeAssociatedWithPfo").length <= 0 ? StringUtils.EMPTY : map.get("strokeAssociatedWithPfo")[0].toUpperCase());
        YesNo strokeAssociatedWithMi = YesNo.valueOf(map.get("strokeAssociatedWithMi").length <= 0 ? StringUtils.EMPTY : map.get("strokeAssociatedWithMi")[0].toUpperCase());
        YesNo familyStroke = YesNo.valueOf(map.get("familyStroke").length <= 0 ? StringUtils.EMPTY : map.get("familyStroke")[0].toUpperCase());
        YesNo familyIhdAngina = YesNo.valueOf(map.get("familyIhdAngina").length <= 0 ? StringUtils.EMPTY : map.get("familyIhdAngina")[0].toUpperCase());
        YesNo familyDiabetesMellitus = YesNo.valueOf(map.get("familyDiabetesMellitus").length <= 0 ? StringUtils.EMPTY : map.get("familyDiabetesMellitus")[0].toUpperCase());
        YesNo familyMi = YesNo.valueOf(map.get("familyMi").length <= 0 ? StringUtils.EMPTY : map.get("familyMi")[0].toUpperCase());
        YesNo familyPvd = YesNo.valueOf(map.get("familyPvd").length <= 0 ? StringUtils.EMPTY : map.get("familyPvd")[0].toUpperCase());
        YesNo familyHypertension = YesNo.valueOf(map.get("familyHypertension").length <= 0 ? StringUtils.EMPTY : map.get("familyHypertension")[0].toUpperCase());
        YesNo familyNoneOfTheAbove = YesNo.valueOf(map.get("familyNoneOfTheAbove").length <= 0 ? StringUtils.EMPTY : map.get("familyNoneOfTheAbove")[0].toUpperCase());
        String currentSmoker = !map.containsKey("currentSmoker") ? StringUtils.EMPTY : map.get("currentSmoker")[0];
        if(!StringUtils.isEmpty(currentSmoker))
            dcf2.setCurrentSmoker(YesNo.YES);
        Integer cigarettePerDay = Integer.valueOf(map.get("cigarettePerDay").length <= 0 ? StringUtils.EMPTY : map.get("cigarettePerDay")[0]);
        String exSmoker = !map.containsKey("exSmoker") ? StringUtils.EMPTY : map.get("exSmoker")[0];
        if(!StringUtils.isEmpty(exSmoker))
            dcf2.setExSmoker(YesNo.YES);
        String never = !map.containsKey("never") ? StringUtils.EMPTY : map.get("never")[0];
        if(!StringUtils.isEmpty(never))
            dcf2.setNever(YesNo.YES);
        Double hip = Double.valueOf(map.get("cigarettePerDay").length <= 0 ? StringUtils.EMPTY : map.get("cigarettePerDay")[0]);
        Double waist = Double.valueOf(map.get("cigarettePerDay").length <= 0 ? StringUtils.EMPTY : map.get("cigarettePerDay")[0]);
        dcf2.setPatientIdNumber(patientIdNumber);
        dcf2.setIschaemicStroke(ischaemicStroke);
        dcf2.setHoemorrhagicStroke(hoemorrhagicStroke);
        dcf2.setVenousSinusThrombosis(venousSinusThrombosis);
        dcf2.setTia(tia);
        dcf2.setAvm(avm);
        dcf2.setAneurysm(aneurysm);
        dcf2.setSubaranchoid(subaranchoid);
        dcf2.setHypertension(hypertension);
        dcf2.setDiabetesMellitus(diabetesMellitus);
        dcf2.setIhdAngina(ihdAngina);
        dcf2.setHypercholesterolemia(hypercholesterolemia);
        dcf2.setAtrialFibrillation(atrialFibrillation);
        dcf2.setPvd(pvd);
        dcf2.setMi(mi);
        dcf2.setMigraineWithAura(migraineWithAura);
        dcf2.setMigraineWithoutAura(migraineWithoutAura);
        dcf2.setIschaemicStrokeYear(ischaemicStrokeYear);
        dcf2.setHoemorrhagicStrokeYear(hoemorrhagicStrokeYear);
        dcf2.setTiaYear(tiaYear);
        dcf2.setStrokeAssociatedWithDissection(strokeAssociatedWithDissection);
        dcf2.setStrokeAssociatedWithPfo(strokeAssociatedWithPfo);
        dcf2.setStrokeAssociatedWithMi(strokeAssociatedWithMi);
        dcf2.setFamilyStroke(familyStroke);
        dcf2.setFamilyIhdAngina(familyIhdAngina);
        dcf2.setFamilyDiabetesMellitus(familyDiabetesMellitus);
        dcf2.setFamilyMi(familyMi);
        dcf2.setFamilyPvd(familyPvd);
        dcf2.setFamilyHypertension(familyHypertension);
        dcf2.setFamilyNoneOfTheAbove(familyNoneOfTheAbove);
        dcf2.setCigarettePerDay(cigarettePerDay);
        dcf2.setHip(hip);
        dcf2.setWaist(waist);
        if(id > 0)
            dcf2.update();
        else
            dcf2.save();
        session("pid", patientIdNumber.toString());
        return ok(Json.toJson(new ResponseMessage(200, "Form two saved successfully", ResponseMessageType.SUCCESSFUL)));
    }

    @With(Authenticated.class)
    public static Result handleSaveForm3() {
        DataCollectionForm3 dcf3 = new DataCollectionForm3();

        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));

        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
        if(id > 0) {
            dcf3 = DataCollectionForm3.find.byId(id);
            if(dcf3 == null)
                return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        }
        Integer patientIdNumber = Integer.valueOf(map.get("patientIdNumber").length <= 0 ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);
        Integer alcoholUnitsPerWeek = Integer.valueOf(map.get("alcoholUnitsPerWeek").length <= 0 ? StringUtils.EMPTY : map.get("alcoholUnitsPerWeek")[0]);
        Double height = Double.valueOf(map.get("height").length <= 0 ? StringUtils.EMPTY : map.get("height")[0]);
        Double weight = Double.valueOf(map.get("weight").length <= 0 ? StringUtils.EMPTY : map.get("weight")[0]);
        Double bmi = Double.valueOf(map.get("bmi").length <= 0 ? StringUtils.EMPTY : map.get("bmi")[0]);

        String aspirin = !map.containsKey("aspirin") ? StringUtils.EMPTY : map.get("aspirin")[0];
        String clopidogrel = !map.containsKey("clopidogrel") ? StringUtils.EMPTY : map.get("clopidogrel")[0];
        String aspirinPlusClopidogrel = !map.containsKey("aspirinPlusClopidogrel") ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrel")[0];
        String dipyridamole = !map.containsKey("dipyridamole") ? StringUtils.EMPTY : map.get("dipyridamole")[0];
        String aspirinPlusDipyridamole = !map.containsKey("aspirinPlusDipyridamole") ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamole")[0];
        String warfarin = !map.containsKey("warfarin") ? StringUtils.EMPTY : map.get("warfarin")[0];
        String statin = !map.containsKey("statin") ? StringUtils.EMPTY : map.get("statin")[0];
        String antihypertensive = !map.containsKey("antihypertensive") ? StringUtils.EMPTY : map.get("antihypertensive")[0];
        String medicineNoneOfTheAbove = !map.containsKey("medicineNoneOfTheAbove") ? StringUtils.EMPTY : map.get("medicineNoneOfTheAbove")[0];
        if(!StringUtils.isEmpty(aspirin)){
            String aspirinDosage = StringUtils.isEmpty(map.get("aspirinDosage")[0]) ? StringUtils.EMPTY : map.get("aspirinDosage")[0];
            dcf3.setAspirin(YesNo.YES);
            dcf3.setAspirinDosage(aspirinDosage);
        }
        if(!StringUtils.isEmpty(clopidogrel)){
            String clopidogrelDosage = StringUtils.isEmpty(map.get("clopidogrelDosage")[0]) ? StringUtils.EMPTY : map.get("clopidogrelDosage")[0];
            dcf3.setClopidogrel(YesNo.YES);
            dcf3.setClopidogrelDosage(clopidogrelDosage);
        }
        if(!StringUtils.isEmpty(aspirinPlusClopidogrel)){
            String aspirinPlusClopidogrelDosage1 = StringUtils.isEmpty(map.get("aspirinPlusClopidogrelDosage1")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrelDosage1")[0];
            String aspirinPlusClopidogrelDosage2 = StringUtils.isEmpty(map.get("aspirinPlusClopidogrelDosage2")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrelDosage2")[0];
            dcf3.setAspirinPlusClopidogrel(YesNo.YES);
            dcf3.setAspirinPlusClopidogrelDosage(aspirinPlusClopidogrelDosage1 + "+" + aspirinPlusClopidogrelDosage2);
        }
        if(!StringUtils.isEmpty(dipyridamole)){
            String dipyridamoleDosage = StringUtils.isEmpty(map.get("dipyridamoleDosage")[0]) ? StringUtils.EMPTY : map.get("dipyridamoleDosage")[0];
            dcf3.setDipyridamole(YesNo.YES);
            dcf3.setDipyridamoleDosage(dipyridamoleDosage);
        }
        if(!StringUtils.isEmpty(aspirinPlusDipyridamole)){
            String aspirinPlusDipyridamoleDosage1 = StringUtils.isEmpty(map.get("aspirinPlusDipyridamoleDosage1")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamoleDosage1")[0];
            String aspirinPlusDipyridamoleDosage2 = StringUtils.isEmpty(map.get("aspirinPlusDipyridamoleDosage2")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamoleDosage2")[0];
            dcf3.setAspirinPlusDipyridamole(YesNo.YES);
            dcf3.setAspirinPlusDipyridamoleDosage(aspirinPlusDipyridamoleDosage1 + "+" + aspirinPlusDipyridamoleDosage2);
        }
        if(!StringUtils.isEmpty(antihypertensive)){
            dcf3.setAntihypertensive(YesNo.YES);
        }
        if(!StringUtils.isEmpty(warfarin)){
            String warfarinInr = StringUtils.isEmpty(map.get("warfarinInr")[0]) ? StringUtils.EMPTY : map.get("warfarinInr")[0];
            dcf3.setWarfarinInr(warfarinInr);
            dcf3.setWarfarin(YesNo.YES);
        }
        if(!StringUtils.isEmpty(statin)){
            String statinDosage = StringUtils.isEmpty(map.get("statinDosage")[0]) ? StringUtils.EMPTY : map.get("statinDosage")[0];
            dcf3.setStatin(YesNo.YES);
            dcf3.setStatinDosage(statinDosage);
        }
        if(!StringUtils.isEmpty(medicineNoneOfTheAbove)){
            dcf3.setMedicineNoneOfTheAbove(YesNo.YES);
        }
        String glucoseBloodTest = !map.containsKey("glucoseBloodTest") ? StringUtils.EMPTY : map.get("glucoseBloodTest")[0];
        String totalCholesterolBloodTest = !map.containsKey("totalCholesterolBloodTest") ? StringUtils.EMPTY : map.get("totalCholesterolBloodTest")[0];
        String hdlCholesterolBloodTest = !map.containsKey("hdlCholesterolBloodTest") ? StringUtils.EMPTY : map.get("hdlCholesterolBloodTest")[0];
        String ldlCholesterolBloodTest = !map.containsKey("ldlCholesterolBloodTest") ? StringUtils.EMPTY : map.get("ldlCholesterolBloodTest")[0];
        String triglycerideBloodTest = !map.containsKey("triglycerideBloodTest") ? StringUtils.EMPTY : map.get("triglycerideBloodTest")[0];
        String esrBloodTest = !map.containsKey("esrBloodTest") ? StringUtils.EMPTY : map.get("esrBloodTest")[0];
        String crpBloodTest = !map.containsKey("crpBloodTest") ? StringUtils.EMPTY : map.get("crpBloodTest")[0];
        String troponimBloodTest = !map.containsKey("troponimBloodTest") ? StringUtils.EMPTY : map.get("troponimBloodTest")[0];
        String proteinCBloodTest = !map.containsKey("proteinCBloodTest") ? StringUtils.EMPTY : map.get("proteinCBloodTest")[0];
        String proteinSBloodTest = !map.containsKey("proteinSBloodTest") ? StringUtils.EMPTY : map.get("proteinSBloodTest")[0];
        String fibrinogenBloodTest = !map.containsKey("fibrinogenBloodTest") ? StringUtils.EMPTY : map.get("fibrinogenBloodTest")[0];
        String antithrombin11BloodTest = !map.containsKey("antithrombin11BloodTest") ? StringUtils.EMPTY : map.get("antithrombin11BloodTest")[0];
        String factorVBloodTest = !map.containsKey("factorVBloodTest") ? StringUtils.EMPTY : map.get("factorVBloodTest")[0];
        String homocysteineBloodTest = !map.containsKey("homocysteineBloodTest") ? StringUtils.EMPTY : map.get("homocysteineBloodTest")[0];
        String prothrombinBloodTest = !map.containsKey("prothrombinBloodTest") ? StringUtils.EMPTY : map.get("prothrombinBloodTest")[0];
        String antiphospholipidBloodTest = !map.containsKey("antiphospholipidBloodTest") ? StringUtils.EMPTY : map.get("antiphospholipidBloodTest")[0];
        if(!StringUtils.isEmpty(glucoseBloodTest)) {
            String glucoseBloodTestResult = StringUtils.isEmpty(map.get("glucoseBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("glucoseBloodTestResult")[0];
            dcf3.setGlucoseBloodTest(YesNo.YES);
            dcf3.setGlucoseBloodTestResult(glucoseBloodTestResult);
        }
        if(!StringUtils.isEmpty(totalCholesterolBloodTest)) {
            String totalCholesterolBloodTestResult = StringUtils.isEmpty(map.get("totalCholesterolBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("totalCholesterolBloodTestResult")[0];
            dcf3.setTotalCholesterolBloodTest(YesNo.YES);
            dcf3.setTotalCholesterolBloodTestResult(totalCholesterolBloodTestResult);
        }
        if(!StringUtils.isEmpty(hdlCholesterolBloodTest)) {
            String hdlCholesterolBloodTestResult = StringUtils.isEmpty(map.get("hdlCholesterolBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("hdlCholesterolBloodTestResult")[0];
            dcf3.setHdlCholesterolBloodTest(YesNo.YES);
            dcf3.setHdlCholesterolBloodTestResult(hdlCholesterolBloodTestResult);
        }
        if(!StringUtils.isEmpty(ldlCholesterolBloodTest)) {
            String ldlCholesterolBloodTestResult = StringUtils.isEmpty(map.get("ldlCholesterolBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("ldlCholesterolBloodTestResult")[0];
            dcf3.setLdlCholesterolBloodTest(YesNo.YES);
            dcf3.setLdlCholesterolBloodTestResult(ldlCholesterolBloodTestResult);
        }
        if(!StringUtils.isEmpty(triglycerideBloodTest)) {
            String triglycerideBloodTestResult = StringUtils.isEmpty(map.get("triglycerideBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("triglycerideBloodTestResult")[0];
            dcf3.setTriglycerideBloodTest(YesNo.YES);
            dcf3.setTriglycerideBloodTestResult(triglycerideBloodTestResult);
        }
        if(!StringUtils.isEmpty(esrBloodTest)) {
            String esrBloodTestResult = StringUtils.isEmpty(map.get("esrBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("esrBloodTestResult")[0];
            dcf3.setEsrBloodTest(YesNo.YES);
            dcf3.setEsrBloodTestResult(esrBloodTestResult);
        }
        if(!StringUtils.isEmpty(crpBloodTest)) {
            String crpBloodTestResult = StringUtils.isEmpty(map.get("crpBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("crpBloodTestResult")[0];
            dcf3.setCrpBloodTest(YesNo.YES);
            dcf3.setCrpBloodTestResult(crpBloodTestResult);
        }
        if(!StringUtils.isEmpty(troponimBloodTest)) {
            String troponimBloodTestResult = StringUtils.isEmpty(map.get("troponimBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("troponimBloodTestResult")[0];
            dcf3.setTroponimBloodTest(YesNo.YES);
            dcf3.setTroponimBloodTestResult(troponimBloodTestResult);
        }
        if(!StringUtils.isEmpty(proteinCBloodTest)) {
            String proteinCBloodTestResult = StringUtils.isEmpty(map.get("proteinCBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("proteinCBloodTestResult")[0];
            dcf3.setProteinCBloodTest(YesNo.YES);
            dcf3.setProteinCBloodTestResult(proteinCBloodTestResult);
        }
        if(!StringUtils.isEmpty(proteinSBloodTest)) {
            String proteinSBloodTestResult = StringUtils.isEmpty(map.get("proteinSBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("proteinSBloodTestResult")[0];
            dcf3.setProteinSBloodTest(YesNo.YES);
            dcf3.setProteinSBloodTestResult(proteinSBloodTestResult);
        }
        if(!StringUtils.isEmpty(fibrinogenBloodTest)) {
            String fibrinogenBloodTestResult = StringUtils.isEmpty(map.get("fibrinogenBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("fibrinogenBloodTestResult")[0];
            dcf3.setFibrinogenBloodTest(YesNo.YES);
            dcf3.setFibrinogenBloodTestResult(fibrinogenBloodTestResult);
        }
        if(!StringUtils.isEmpty(antithrombin11BloodTest)) {
            String antithrombin11BloodTestResult = StringUtils.isEmpty(map.get("antithrombin11BloodTestResult")[0]) ? StringUtils.EMPTY : map.get("antithrombin11BloodTestResult")[0];
            dcf3.setAntithrombin11BloodTest(YesNo.YES);
            dcf3.setAntithrombin11BloodTestResult(antithrombin11BloodTestResult);
        }
        if(!StringUtils.isEmpty(factorVBloodTest)) {
            String factorVBloodTestResult = StringUtils.isEmpty(map.get("factorVBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("factorVBloodTestResult")[0];
            dcf3.setFactorVBloodTest(YesNo.YES);
            dcf3.setFactorVBloodTestResult(factorVBloodTestResult);
        }
        if(!StringUtils.isEmpty(homocysteineBloodTest)) {
            String homocysteineBloodTestResult = StringUtils.isEmpty(map.get("homocysteineBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("homocysteineBloodTestResult")[0];
            dcf3.setHomocysteineBloodTest(YesNo.YES);
            dcf3.setHomocysteineBloodTestResult(homocysteineBloodTestResult);
        }
        if(!StringUtils.isEmpty(prothrombinBloodTest)) {
            String prothrombinBloodTestResult = StringUtils.isEmpty(map.get("prothrombinBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("prothrombinBloodTestResult")[0];
            dcf3.setProthrombinBloodTest(YesNo.YES);
            dcf3.setProthrombinBloodTestResult(prothrombinBloodTestResult);
        }
        if(!StringUtils.isEmpty(antiphospholipidBloodTest)) {
            String antiphospholipidBloodTestResult = StringUtils.isEmpty(map.get("antiphospholipidBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("antiphospholipidBloodTestResult")[0];
            dcf3.setAntiphospholipidBloodTest(YesNo.YES);
            dcf3.setAntiphospholipidBloodTestResult(antiphospholipidBloodTestResult);
        }
        String bpOnAdmission1 = StringUtils.isEmpty(map.get("bpOnAdmission1")[0]) ? StringUtils.EMPTY : map.get("bpOnAdmission1")[0];
        String bpOnAdmission2 = StringUtils.isEmpty(map.get("bpOnAdmission2")[0]) ? StringUtils.EMPTY : map.get("bpOnAdmission2")[0];
        String temperatureOnAdmission = StringUtils.isEmpty(map.get("temperatureOnAdmission")[0]) ? StringUtils.EMPTY : map.get("temperatureOnAdmission")[0];
        YesNo carotidEndarterectomyDone = YesNo.valueOf(StringUtils.isEmpty(map.get("carotidEndarterectomyDone")[0]) ? StringUtils.EMPTY : map.get("carotidEndarterectomyDone")[0]);
        YesNo thrombolysedDone = YesNo.valueOf(StringUtils.isEmpty(map.get("thrombolysedDone")[0]) ? StringUtils.EMPTY : map.get("thrombolysedDone")[0]);
        YesNo ctaDone = YesNo.valueOf(StringUtils.isEmpty(map.get("ctaDone")[0]) ? StringUtils.EMPTY : map.get("ctaDone")[0]);
        YesNo mraDone = YesNo.valueOf(StringUtils.isEmpty(map.get("mraDone")[0]) ? StringUtils.EMPTY : map.get("mraDone")[0]);
        YesNo angiogramDone = YesNo.valueOf(StringUtils.isEmpty(map.get("angiogramDone")[0]) ? StringUtils.EMPTY : map.get("angiogramDone")[0]);
        dcf3.setPatientIdNumber(patientIdNumber);
        dcf3.setAlcoholUnitsPerWeek(alcoholUnitsPerWeek);
        dcf3.setHeight(height);
        dcf3.setWeight(weight);
        dcf3.setBmi(bmi);
        dcf3.setBpOnAdmission(bpOnAdmission1 + "/" + bpOnAdmission2);
        dcf3.setTemperatureOnAdmission(temperatureOnAdmission);
        dcf3.setCarotidEndarterectomyDone(carotidEndarterectomyDone);
        dcf3.setThrombolysedDone(thrombolysedDone);
        dcf3.setCtaDone(ctaDone);
        dcf3.setMraDone(mraDone);
        dcf3.setAngiogramDone(angiogramDone);
        if(id > 0)
            dcf3.update();
        else
            dcf3.save();
        session("pid", patientIdNumber.toString());
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
        YesNo ecgNormal = !map.containsKey("ecgNormal") ? YesNo.NO : YesNo.YES;
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
        String aspirin = !map.containsKey("aspirin") ? StringUtils.EMPTY : map.get("aspirin")[0];
        String clopidogrel = !map.containsKey("clopidogrel") ? StringUtils.EMPTY : map.get("clopidogrel")[0];
        String aspirinPlusClopidogrel = StringUtils.isEmpty(map.get("aspirinPlusClopidogrel")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrel")[0];
        String dipyridamole = !map.containsKey("dipyridamole") ? StringUtils.EMPTY : map.get("dipyridamole")[0];
        String aspirinPlusDipyridamole = !map.containsKey("aspirinPlusDipyridamole1") ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamole1")[0];
        String antihypertensive = !map.containsKey("antihypertensive") ? StringUtils.EMPTY : map.get("antihypertensive")[0];
        String warfarin = !map.containsKey("warfarin") ? StringUtils.EMPTY : map.get("warfarin")[0];
        String statin = !map.containsKey("statin") ? StringUtils.EMPTY : map.get("statin")[0];
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
        if(id > 0) {
            dcf6 = DataCollectionForm6.find.byId(id);
            if(dcf6 == null)
                return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        }
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

    @With(Authenticated.class)
    public static Result patientList() {

        return ok();
    }
}
