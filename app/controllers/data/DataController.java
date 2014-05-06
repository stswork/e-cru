package controllers.data;

import com.fasterxml.jackson.databind.JsonNode;
import models.response.ResponseMessage;
import models.response.ResponseMessageType;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

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

        JsonNode body = request().body().asJson();
        if(body == null)
            return badRequest(Json.toJson(new ResponseMessage(400, "Invalid parameters passed!", ResponseMessageType.BAD_REQUEST)));

        return ok();
    }
}
