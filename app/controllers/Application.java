package controllers;

import play.mvc.*;

public class Application extends Controller {
  
    /*public static Result login() {
        if (StringUtils.isEmpty(session("user"))) {
            return ok(views.html.index.render("Welcome"));
        } else {
            models.response.user.User u = (models.response.user.User) ctx().args.get("user");
            User user = User.find.byId(u.getId());
            if(user.getUserType().equals(UserType.DOCTOR))
                return redirect(controllers.review.routes.ReviewController.getPatientsToReview());
            else if(user.getUserType().equals(UserType.MRI_SCAN_CENTER))
                return redirect(controllers.review.routes.ReviewController.getPatientsToReview());
        }
        return ok(views.html.index.render("Welcome"));
    }*/


    /*public static Result patientSave() {

        //User u=User.find(UserType.DOCTOR);
        //User user = User.find.fetch();

        List<User> user= Ebean.find(User.class).where(Expr.eq("userType", UserType.DOCTOR)).findList();
        Patient patient = Patient.find.byId((long)121);

        return ok(views.html.patient.save.render("Patient", user, patient));
    }*/

    public static Result form(){
        return ok(views.html.form1.render());
    }
    public static Result form2(){
        return ok(views.html.form2.render());
    }
    public static Result form3(){
        return ok(views.html.form3.render());
    }
    public static Result form4(){
        return ok(views.html.form4.render());
    }
    public static Result form5(){
        return ok(views.html.form5.render());
    }
    public static Result form6(){
        return ok(views.html.form6.render());
    }
}
