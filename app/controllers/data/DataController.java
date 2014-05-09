package controllers.data;

import actions.Authenticated;
import com.fasterxml.jackson.databind.JsonNode;
import models.YesNo;
import models.data.form.DataCollectionForm1;
import models.data.form.Gender;
import models.response.ResponseMessage;
import models.response.ResponseMessageType;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import java.net.URL;
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
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        return ok(views.html.data.form1.render("Form1",u));
    }

    @With(Authenticated.class)
    public static Result form2(){
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        return ok(views.html.data.form2.render("Form2",u));
    }

    @With(Authenticated.class)
    public static Result form3(){
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        return ok(views.html.data.form3.render("Form3",u));
    }

    @With(Authenticated.class)
    public static Result form4(){
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        return ok(views.html.data.form4.render("Form4",u));
    }

    @With(Authenticated.class)
    public static Result form5(){
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        return ok(views.html.data.form5.render("Form5",u));
    }

    @With(Authenticated.class)
    public static Result form6(){
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        return ok(views.html.data.form6.render("Form6",u));
    }

    @With(Authenticated.class)
    public static Result handleSaveForm1() {
        DataCollectionForm1 dcf1 = new DataCollectionForm1();

        Map<String, String[]> map = request().body().asFormUrlEncoded();
        if(map.size() <= 0)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));
        Long id = Long.valueOf(map.get("id").length <= 0 ? "0" : map.get("id")[0]);
        Integer patientIdNumber = Integer.valueOf(map.get("patientIdNumber").length <= 0 ? StringUtils.EMPTY : map.get("patientIdNumber")[0]);
        String trialSite = map.get("trialSite").length <= 0 ? StringUtils.EMPTY : map.get("trialSite")[0];
        String dateRecruited = map.get("dateRecruited").length <= 0 ? StringUtils.EMPTY : map.get("dateRecruited")[0];
        String dateRecruitedMonth = map.get("dateRecruitedMonth").length <= 0 ? StringUtils.EMPTY : map.get("dateRecruitedMonth")[0];
        String dateRecruitedYear = map.get("dateRecruitedYear").length <= 0 ? StringUtils.EMPTY : map.get("dateRecruitedYear")[0];
        DateTime recruitedDate = DATE_TIME_FORMATTER.parseDateTime(dateRecruited + URL_SEPARATOR + dateRecruitedMonth + URL_SEPARATOR + dateRecruitedYear);
        String patientName = map.get("patientName").length <= 0 ? StringUtils.EMPTY : map.get("patientName")[0];
        String patientDobDate = map.get("patientDobDate").length <= 0 ? StringUtils.EMPTY : map.get("patientDobDate")[0];
        String patientDobMonth = map.get("patientDobMonth").length <= 0 ? StringUtils.EMPTY : map.get("patientDobMonth")[0];
        String patientDobYear = map.get("patientDobYear").length <= 0 ? StringUtils.EMPTY : map.get("patientDobYear")[0];
        DateTime datePatientDob = DATE_TIME_FORMATTER.parseDateTime(patientDobDate + URL_SEPARATOR + patientDobMonth + URL_SEPARATOR + patientDobYear);
        String patientAddress = map.get("patientAddress").length <= 0 ? StringUtils.EMPTY : map.get("patientAddress")[0];
        Gender gender = Gender.valueOf(map.get("gender").length <= 0 ? "MALE" : map.get("gender")[0].toUpperCase());
        String landlinePhoneNumber = map.get("landlinePhoneNumber").length <= 0 ? StringUtils.EMPTY : map.get("landlinePhoneNumber")[0];
        String cellPhoneNumber = map.get("cellPhoneNumber").length <= 0 ? StringUtils.EMPTY : map.get("cellPhoneNumber")[0];
        String friendRelativePhoneNumber = map.get("friendRelativePhoneNumber").length <= 0 ? StringUtils.EMPTY : map.get("friendRelativePhoneNumber")[0];
        String placeOfBirth = map.get("placeOfBirth").length <= 0 ? StringUtils.EMPTY : map.get("placeOfBirth")[0];
        String ethnicity = map.get("ethnicity").length <= 0 ? StringUtils.EMPTY : map.get("ethnicity")[0];
        String nativeLanguage = map.get("nativeLanguage").length <= 0 ? StringUtils.EMPTY : map.get("nativeLanguage")[0];
        String religion = map.get("religion").length <= 0 ? StringUtils.EMPTY : map.get("religion")[0];
        String[] economicStatuses = map.get("economicStatuses[]") == null ? new String[0] : map.get("economicStatuses[]");
        YesNo bloodSampleTaken = YesNo.valueOf(map.get("bloodSampleTaken").length <= 0 ? StringUtils.EMPTY : map.get("bloodSampleTaken")[0].toUpperCase());
        String bloodSampleDate = map.get("bloodSampleDate").length <= 0 ? StringUtils.EMPTY : map.get("bloodSampleDate")[0];
        String bloodSampleMonth = map.get("bloodSampleMonth").length <= 0 ? StringUtils.EMPTY : map.get("bloodSampleMonth")[0];
        String bloodSampleYear = map.get("bloodSampleYear").length <= 0 ? StringUtils.EMPTY : map.get("bloodSampleYear")[0];
        DateTime dateBloodSampleTaken = DATE_TIME_FORMATTER.parseDateTime(bloodSampleDate + URL_SEPARATOR + bloodSampleMonth + URL_SEPARATOR + bloodSampleYear);
        String bloodSampleNumber = map.get("bloodSampleNumber").length <= 0 ? StringUtils.EMPTY : map.get("bloodSampleNumber")[0];
        String strokeDate = map.get("strokeDate").length <= 0 ? StringUtils.EMPTY : map.get("strokeDate")[0];
        String strokeMonth = map.get("strokeMonth").length <= 0 ? StringUtils.EMPTY : map.get("strokeMonth")[0];
        String strokeYear = map.get("strokeYear").length <= 0 ? StringUtils.EMPTY : map.get("strokeYear")[0];
        DateTime dateStroke = DATE_TIME_FORMATTER.parseDateTime(strokeDate + URL_SEPARATOR + strokeMonth + URL_SEPARATOR + strokeYear);
        dcf1 = new DataCollectionForm1(patientIdNumber,
                trialSite,
                new Timestamp(recruitedDate.getMillis()),
                patientName,
                new Timestamp(datePatientDob.getMillis()),
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
                new Timestamp(dateBloodSampleTaken.getMillis()),
                bloodSampleNumber,
                new Timestamp(dateStroke.getMillis()));
        dcf1.save();
        return ok(Json.toJson(new ResponseMessage(200, "Form one saved successfully", ResponseMessageType.SUCCESSFUL)));
    }
}
