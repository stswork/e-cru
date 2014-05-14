package controllers.data;

import actions.Authenticated;
import models.YesNo;
import models.data.form.DataCollectionForm2;
import models.data.form.DataCollectionForm3;
import models.response.ResponseMessage;
import models.response.ResponseMessageType;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 5/11/14
 * Time: 12:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class Form3Controller extends Controller {

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");
    private static final String URL_SEPARATOR = "/";

    @With(Authenticated.class)
    public static Result handleSaveForm3() {
        DataCollectionForm3 dcf3 = new DataCollectionForm3();

        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));

        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
        Integer patientIdNumber = Integer.valueOf(map.get("patientIdNumber").length <= 0 ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);
        Integer alcoholUnitsPerWeek = Integer.valueOf(map.get("alcoholUnitsPerWeek").length <= 0 ? StringUtils.EMPTY : map.get("alcoholUnitsPerWeek")[0]);
        Double height = Double.valueOf(map.get("height").length <= 0 ? StringUtils.EMPTY : map.get("height")[0]);
        Double weight = Double.valueOf(map.get("weight").length <= 0 ? StringUtils.EMPTY : map.get("weight")[0]);
        Double bmi = Double.valueOf(map.get("bmi").length <= 0 ? StringUtils.EMPTY : map.get("bmi")[0]);

        YesNo aspirin = YesNo.valueOf(map.containsKey("aspirin") ? StringUtils.EMPTY : map.get("aspirin")[0]);


        String aspirinDosage = StringUtils.isEmpty(map.get("aspirinDosage")[0]) ? StringUtils.EMPTY : map.get("aspirinDosage")[0];
        YesNo clopidogrel = YesNo.valueOf(StringUtils.isEmpty(map.get("clopidogrel")[0]) ? StringUtils.EMPTY : map.get("clopidogrel")[0]);
        String clopidogrelDosage = StringUtils.isEmpty(map.get("clopidogrelDosage")[0]) ? StringUtils.EMPTY : map.get("clopidogrelDosage")[0];
        YesNo aspirinPlusClopidogrel = YesNo.valueOf(StringUtils.isEmpty(map.get("aspirinPlusClopidogrel")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrel")[0]);
        String aspirinPlusClopidogrelDosage = StringUtils.isEmpty(map.get("aspirinPlusClopidogrelDosage")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrelDosage")[0];
        YesNo dipyridamole = YesNo.valueOf(StringUtils.isEmpty(map.get("dipyridamole")[0]) ? StringUtils.EMPTY : map.get("dipyridamole")[0]);
        String dipyridamoleDosage = StringUtils.isEmpty(map.get("dipyridamoleDosage")[0]) ? StringUtils.EMPTY : map.get("dipyridamoleDosage")[0];
        YesNo aspirinPlusDipyridamole = YesNo.valueOf(StringUtils.isEmpty(map.get("aspirinPlusDipyridamole")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamole")[0]);
        String aspirinPlusDipyridamoleDosage = StringUtils.isEmpty(map.get("aspirinPlusDipyridamoleDosage")[0]) ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamoleDosage")[0];
        YesNo warfarin = YesNo.valueOf(StringUtils.isEmpty(map.get("warfarin")[0]) ? StringUtils.EMPTY : map.get("warfarin")[0]);
        String warfarinInr = StringUtils.isEmpty(map.get("warfarinInr")[0]) ? StringUtils.EMPTY : map.get("warfarinInr")[0];
        YesNo statin = YesNo.valueOf(StringUtils.isEmpty(map.get("statin")[0]) ? StringUtils.EMPTY : map.get("statin")[0]);
        String statinDosage = StringUtils.isEmpty(map.get("statinDosage")[0]) ? StringUtils.EMPTY : map.get("statinDosage")[0];
        /*String statinName = StringUtils.isEmpty(map.get("statinName")[0]) ? StringUtils.EMPTY : map.get("statinName")[0];*/
        YesNo antihypertensive = YesNo.valueOf(StringUtils.isEmpty(map.get("antihypertensive")[0]) ? StringUtils.EMPTY : map.get("antihypertensive")[0]);
        String antihypertensiveDosage = StringUtils.isEmpty(map.get("antihypertensiveDosage")[0]) ? StringUtils.EMPTY : map.get("antihypertensiveDosage")[0];
        YesNo medicineNoneOfTheAbove = YesNo.valueOf(StringUtils.isEmpty(map.get("medicineNoneOfTheAbove")[0]) ? StringUtils.EMPTY : map.get("medicineNoneOfTheAbove")[0]);

        YesNo glucoseBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("glucoseBloodTest")[0]) ? StringUtils.EMPTY : map.get("glucoseBloodTest")[0]);
        String glucoseBloodTestResult = StringUtils.isEmpty(map.get("glucoseBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("glucoseBloodTestResult")[0];

        YesNo totalCholesterolBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("totalCholesterolBloodTest")[0]) ? StringUtils.EMPTY : map.get("totalCholesterolBloodTest")[0]);
        String totalCholesterolBloodTestResult = StringUtils.isEmpty(map.get("totalCholesterolBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("totalCholesterolBloodTestResult")[0];

        YesNo hdlCholesterolBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("hdlCholesterolBloodTest")[0]) ? StringUtils.EMPTY : map.get("hdlCholesterolBloodTest")[0]);
        String hdlCholesterolBloodTestResult = StringUtils.isEmpty(map.get("hdlCholesterolBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("hdlCholesterolBloodTestResult")[0];

        YesNo ldlCholesterolBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("ldlCholesterolBloodTest")[0]) ? StringUtils.EMPTY : map.get("ldlCholesterolBloodTest")[0]);
        String ldlCholesterolBloodTestResult = StringUtils.isEmpty(map.get("ldlCholesterolBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("ldlCholesterolBloodTestResult")[0];

        YesNo triglycerideBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("triglycerideBloodTest")[0]) ? StringUtils.EMPTY : map.get("triglycerideBloodTest")[0]);
        String triglycerideBloodTestResult = StringUtils.isEmpty(map.get("triglycerideBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("triglycerideBloodTestResult")[0];

        YesNo esrBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("esrBloodTest")[0]) ? StringUtils.EMPTY : map.get("esrBloodTest")[0]);
        String esrBloodTestResult = StringUtils.isEmpty(map.get("esrBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("esrBloodTestResult")[0];

        YesNo crpBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("crpBloodTest")[0]) ? StringUtils.EMPTY : map.get("crpBloodTest")[0]);
        String crpBloodTestResult = StringUtils.isEmpty(map.get("crpBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("crpBloodTestResult")[0];

        YesNo troponimBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("troponimBloodTest")[0]) ? StringUtils.EMPTY : map.get("troponimBloodTest")[0]);
        String troponimBloodTestResult = StringUtils.isEmpty(map.get("troponimBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("troponimBloodTestResult")[0];


        YesNo proteinCBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("proteinCBloodTest")[0]) ? StringUtils.EMPTY : map.get("proteinCBloodTest")[0]);
        String proteinCBloodTestResult = StringUtils.isEmpty(map.get("proteinCBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("proteinCBloodTestResult")[0];

        YesNo proteinSBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("proteinSBloodTest")[0]) ? StringUtils.EMPTY : map.get("proteinSBloodTest")[0]);
        String proteinSBloodTestResult = StringUtils.isEmpty(map.get("proteinSBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("proteinSBloodTestResult")[0];

        YesNo fibrinogenBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("fibrinogenBloodTest")[0]) ? StringUtils.EMPTY : map.get("fibrinogenBloodTest")[0]);
        String fibrinogenBloodTestResult = StringUtils.isEmpty(map.get("fibrinogenBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("fibrinogenBloodTestResult")[0];

        YesNo antithrombin11BloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("antithrombin11BloodTest")[0]) ? StringUtils.EMPTY : map.get("antithrombin11BloodTest")[0]);
        String antithrombin11BloodTestResult = StringUtils.isEmpty(map.get("antithrombin11BloodTestResult")[0]) ? StringUtils.EMPTY : map.get("antithrombin11BloodTestResult")[0];

        YesNo factorVBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("factorVBloodTest")[0]) ? StringUtils.EMPTY : map.get("factorVBloodTest")[0]);
        String factorVBloodTestResult = StringUtils.isEmpty(map.get("factorVBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("factorVBloodTestResult")[0];

        YesNo homocysteineBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("homocysteineBloodTest")[0]) ? StringUtils.EMPTY : map.get("homocysteineBloodTest")[0]);
        String homocysteineBloodTestResult = StringUtils.isEmpty(map.get("homocysteineBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("homocysteineBloodTestResult")[0];

        YesNo prothrombinBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("prothrombinBloodTest")[0]) ? StringUtils.EMPTY : map.get("prothrombinBloodTest")[0]);
        String prothrombinBloodTestResult = StringUtils.isEmpty(map.get("prothrombinBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("prothrombinBloodTestResult")[0];


        YesNo antiphospholipidBloodTest = YesNo.valueOf(StringUtils.isEmpty(map.get("antiphospholipidBloodTest")[0]) ? StringUtils.EMPTY : map.get("antiphospholipidBloodTest")[0]);
        String antiphospholipidBloodTestResult = StringUtils.isEmpty(map.get("antiphospholipidBloodTestResult")[0]) ? StringUtils.EMPTY : map.get("antiphospholipidBloodTestResult")[0];

        String bpOnAdmission = StringUtils.isEmpty(map.get("bpOnAdmission")[0]) ? StringUtils.EMPTY : map.get("bpOnAdmission")[0];
        String temperatureOnAdmission = StringUtils.isEmpty(map.get("temperatureOnAdmission")[0]) ? StringUtils.EMPTY : map.get("temperatureOnAdmission")[0];

        YesNo carotidEndarterectomyDone = YesNo.valueOf(StringUtils.isEmpty(map.get("carotidEndarterectomyDone")[0]) ? StringUtils.EMPTY : map.get("carotidEndarterectomyDone")[0]);
        YesNo thrombolysedDone = YesNo.valueOf(StringUtils.isEmpty(map.get("thrombolysedDone")[0]) ? StringUtils.EMPTY : map.get("thrombolysedDone")[0]);
        YesNo ctaDone = YesNo.valueOf(StringUtils.isEmpty(map.get("ctaDone")[0]) ? StringUtils.EMPTY : map.get("ctaDone")[0]);
        YesNo mraDone = YesNo.valueOf(StringUtils.isEmpty(map.get("mraDone")[0]) ? StringUtils.EMPTY : map.get("mraDone")[0]);
        YesNo angiogramDone = YesNo.valueOf(StringUtils.isEmpty(map.get("angiogramDone")[0]) ? StringUtils.EMPTY : map.get("angiogramDone")[0]);

        dcf3.save();
        session("pid", patientIdNumber.toString());
        return ok(Json.toJson(new ResponseMessage(200, "Form two saved successfully", ResponseMessageType.SUCCESSFUL)));

    }
    }
