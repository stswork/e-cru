package controllers.data;

import com.fasterxml.jackson.databind.JsonNode;
import models.response.ResponseMessage;
import models.response.ResponseMessageType;
import org.apache.commons.lang3.StringUtils;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.Map;

/**
 * Created by Sagar Gopale on 5/6/14.
 */
public class DataController extends Controller {

    public static Result form1(){
        return ok(views.html.data.form1.render());
    }

    public static Result form2(){
        return ok(views.html.data.form2.render());
    }

    public static Result form3(){
        return ok(views.html.data.form3.render());
    }

    public static Result form4(){
        return ok(views.html.data.form4.render());
    }

    public static Result form5(){
        return ok(views.html.data.form5.render());
    }

    public static Result form6(){
        return ok(views.html.data.form6.render());
    }


    public static Result handleSaveForm1() {

        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        /*String a = map.get("id").length <= 0 ? StringUtils.EMPTY : map.get("id")[0];
        String a = map.get("patientIdNumber").length <= 0 ? StringUtils.EMPTY : map.get("patientIdNumber")[0];
        String a = map.get("trialSite").length <= 0 ? StringUtils.EMPTY : map.get("trialSite")[0];
        String a = map.get("dateRecruited").length <= 0 ? StringUtils.EMPTY : map.get("dateRecruited")[0];
        String a = map.get("dateRecruitedMonth").length <= 0 ? StringUtils.EMPTY : map.get("dateRecruitedMonth")[0];
        String a = map.get("dateRecruitedYear").length <= 0 ? StringUtils.EMPTY : map.get("dateRecruitedYear")[0];
        String a = map.get("patientName").length <= 0 ? StringUtils.EMPTY : map.get("patientName")[0];
        String a = map.get(asad).length <= 0 ? StringUtils.EMPTY : map.get("patientDobDate")[0];
        String a = map.get("").length <= 0 ? StringUtils.EMPTY : map.get("")[0];
        String a = map.get("").length <= 0 ? StringUtils.EMPTY : map.get("")[0];
        String a = map.get("").length <= 0 ? StringUtils.EMPTY : map.get("")[0];
        String a = map.get("").length <= 0 ? StringUtils.EMPTY : map.get("")[0];
        String a = map.get("").length <= 0 ? StringUtils.EMPTY : map.get("")[0];
        String a = map.get("").length <= 0 ? StringUtils.EMPTY : map.get("")[0];*/
        return ok(Json.toJson(new ResponseMessage(200, "Form one saved successfully", ResponseMessageType.SUCCESSFUL)));
    }
}
