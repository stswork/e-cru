package controllers.data;

import actions.Authenticated;
import models.YesNo;
import models.data.form.DataCollectionForm1;
import models.data.form.DataCollectionForm2;
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
 * Date: 5/10/14
 * Time: 12:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Form2Controller extends Controller {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");
    private static final String URL_SEPARATOR = "/";

    @With(Authenticated.class)
    public static Result handleSaveForm2() {
        DataCollectionForm2 dcf2 = new DataCollectionForm2();

        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));

        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
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
        YesNo currentSmoker = YesNo.DONT_KNOW/*YesNo.valueOf(map.get("currentSmoker").length <= 0 ? StringUtils.EMPTY : map.get("currentSmoker")[0].toUpperCase())*/;
        Integer cigarettePerDay = Integer.valueOf(map.get("cigarettePerDay").length <= 0 ? StringUtils.EMPTY : map.get("cigarettePerDay")[0]);
        YesNo exSmoker = YesNo.DONT_KNOW/*YesNo.valueOf(map.get("exSmoker").length <= 0 ? StringUtils.EMPTY : map.get("exSmoker")[0].toUpperCase())*/;
        YesNo never = YesNo.DONT_KNOW/*YesNo.valueOf(map.get("never").length <= 0 ? StringUtils.EMPTY : map.get("never")[0].toUpperCase())*/;
        Double hip = Double.valueOf(map.get("cigarettePerDay").length <= 0 ? StringUtils.EMPTY : map.get("cigarettePerDay")[0]);
        Double waist = Double.valueOf(map.get("cigarettePerDay").length <= 0 ? StringUtils.EMPTY : map.get("cigarettePerDay")[0]);

        dcf2= new DataCollectionForm2(patientIdNumber,ischaemicStroke,
                   hoemorrhagicStroke,venousSinusThrombosis,tia,avm,aneurysm,subaranchoid,
                   hypertension,diabetesMellitus,ihdAngina,hypercholesterolemia,atrialFibrillation,
                   pvd,mi,migraineWithAura,migraineWithoutAura,ischaemicStrokeYear,hoemorrhagicStrokeYear,
                   tiaYear,strokeAssociatedWithDissection,strokeAssociatedWithPfo,strokeAssociatedWithMi,
                   familyStroke,familyIhdAngina,familyDiabetesMellitus,familyMi,familyPvd,familyHypertension,
                   familyNoneOfTheAbove,currentSmoker,cigarettePerDay,exSmoker,never,hip,waist
                   /*,alcoholUnitsPerWeek,height,weight,bmi,aspirinDosage,clopidogrelDosage,aspirinPlusClopidogrelDosage
                   ,dipyridamoleDosage,aspirinPlusDipyridamoleDosage,warfarinInr,statinDosage,statinName,antihypertensive,
                   medicineNoneOfTheAbove,bpOnAdmission,temperatureOnAdmission,carotidEndarterectomyDone,thrombolysedDone,
                   ctaDone,mraDone,angiogramDone*/);

        dcf2.save();
        session("pid", patientIdNumber.toString());
        return ok(Json.toJson(new ResponseMessage(200, "Form two saved successfully", ResponseMessageType.SUCCESSFUL)));

    }
}
