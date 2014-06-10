package controllers.export;

import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.List;

/**
 * Created by Sagar Gopale on 6/10/14.
 */
public class ExportController extends Controller {

    public static Result exportToExcel(Long id) {
        Chunks<String> chunks = null;
        try{
            chunks = new StringChunks() {
                // Called when the stream is ready
                public void onReady(Chunks.Out<String> out) {
                    out.write("Patient Id Number, Trial Site, Date Recruited, Name Of Patient, Date Of Birth, Address, Gender, " +
                            "Landline, Cell Phone, Friend/Relative Phone, Place Of Birth, Ethnicity, Native Language, Religion, " +
                            "Economic Status, Blood Taken, Blood Taken On, Blood Sample Number, Date Of Stroke, " +
                            "Ischaemic Stroke, TACI, PACI, LACI, POCI, Hoemorrhagic Stroke, Venous Sinus Thrombosis, TIA, AVM, " +
                            "Aneurysm, Subarachnoid, Hypertension, Diabetes Mellitus, IHD/Angina, Hypercholesterolemia, Atrial Fibrillation," +
                            "PVD, MI, Migraine With Aura, Migraine Without Aura, Ischaemic Stroke, Hoemorrhagic Stroke, Ischaemic Stroke Year," +
                            "Hoemorrhagic Stroke, TIA, Dissection, PFO, MI, FAMILY HISTORY, Stroke, IHD/Angina, Diabetes Mellitus, MI, PVD," +
                            "Hypertension, None Of Above, Current Smoker, Cig/day, Hip, Ex-Smoker, Never Smoked, Waist, \n");

                    out.close();
                }

            };
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
        }
        return ok();
    }
}
