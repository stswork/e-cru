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

        String aspirin = map.containsKey("aspirin") ? StringUtils.EMPTY : map.get("aspirin")[0];
        String clopidogrel = map.containsKey("clopidogrel") ? StringUtils.EMPTY : map.get("clopidogrel")[0];
        String aspirinPlusClopidogrel = map.containsKey("aspirinPlusClopidogrel") ? StringUtils.EMPTY : map.get("aspirinPlusClopidogrel")[0];
        String dipyridamole = map.containsKey("dipyridamole") ? StringUtils.EMPTY : map.get("dipyridamole")[0];
        String aspirinPlusDipyridamole = map.containsKey("aspirinPlusDipyridamole") ? StringUtils.EMPTY : map.get("aspirinPlusDipyridamole")[0];
        String warfarin = map.containsKey("warfarin") ? StringUtils.EMPTY : map.get("warfarin")[0];
        String statin = map.containsKey("statin") ? StringUtils.EMPTY : map.get("statin")[0];
        String antihypertensive = map.containsKey("antihypertensive") ? StringUtils.EMPTY : map.get("antihypertensive")[0];
        String medicineNoneOfTheAbove = map.containsKey("medicineNoneOfTheAbove") ? StringUtils.EMPTY : map.get("medicineNoneOfTheAbove")[0];
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
        String glucoseBloodTest = map.containsKey("glucoseBloodTest") ? StringUtils.EMPTY : map.get("glucoseBloodTest")[0];
        String totalCholesterolBloodTest = map.containsKey("totalCholesterolBloodTest") ? StringUtils.EMPTY : map.get("totalCholesterolBloodTest")[0];
        String hdlCholesterolBloodTest = map.containsKey("hdlCholesterolBloodTest") ? StringUtils.EMPTY : map.get("hdlCholesterolBloodTest")[0];
        String ldlCholesterolBloodTest = map.containsKey("ldlCholesterolBloodTest") ? StringUtils.EMPTY : map.get("ldlCholesterolBloodTest")[0];
        String triglycerideBloodTest = map.containsKey("triglycerideBloodTest") ? StringUtils.EMPTY : map.get("triglycerideBloodTest")[0];
        String esrBloodTest = map.containsKey("esrBloodTest") ? StringUtils.EMPTY : map.get("esrBloodTest")[0];
        String crpBloodTest = map.containsKey("crpBloodTest") ? StringUtils.EMPTY : map.get("crpBloodTest")[0];
        String troponimBloodTest = map.containsKey("troponimBloodTest") ? StringUtils.EMPTY : map.get("troponimBloodTest")[0];
        String proteinCBloodTest = map.containsKey("proteinCBloodTest") ? StringUtils.EMPTY : map.get("proteinCBloodTest")[0];
        String proteinSBloodTest = map.containsKey("proteinSBloodTest") ? StringUtils.EMPTY : map.get("proteinSBloodTest")[0];
        String fibrinogenBloodTest = map.containsKey("fibrinogenBloodTest") ? StringUtils.EMPTY : map.get("fibrinogenBloodTest")[0];
        String antithrombin11BloodTest = map.containsKey("antithrombin11BloodTest") ? StringUtils.EMPTY : map.get("antithrombin11BloodTest")[0];
        String factorVBloodTest = map.containsKey("factorVBloodTest") ? StringUtils.EMPTY : map.get("factorVBloodTest")[0];
        String homocysteineBloodTest = map.containsKey("homocysteineBloodTest") ? StringUtils.EMPTY : map.get("homocysteineBloodTest")[0];
        String prothrombinBloodTest = map.containsKey("prothrombinBloodTest") ? StringUtils.EMPTY : map.get("prothrombinBloodTest")[0];
        String antiphospholipidBloodTest = map.containsKey("antiphospholipidBloodTest") ? StringUtils.EMPTY : map.get("antiphospholipidBloodTest")[0];
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
}
