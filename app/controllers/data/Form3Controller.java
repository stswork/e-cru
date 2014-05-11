package controllers.data;

import actions.Authenticated;
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
    public static Result handleSaveForm2() {
        DataCollectionForm3 dcf3 = new DataCollectionForm3();

        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));

        Long id = Long.valueOf(StringUtils.isEmpty(map.get("id")[0]) ? "0" : map.get("id")[0]);
        Integer patientIdNumber = Integer.valueOf(map.get("patientIdNumber").length <= 0 ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);

        dcf3.save();
        session("pid", patientIdNumber.toString());
        return ok(Json.toJson(new ResponseMessage(200, "Form two saved successfully", ResponseMessageType.SUCCESSFUL)));

    }
    }
