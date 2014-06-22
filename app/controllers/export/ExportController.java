package controllers.export;

import actions.Authenticated;
import au.com.bytecode.opencsv.CSVWriter;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import controllers.data.*;
import models.Status;
import models.data.form.*;
import models.response.ResponseMessage;
import models.response.ResponseMessageType;
import org.apache.commons.lang3.StringUtils;
import play.Logger;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import java.io.FileWriter;
import java.util.List;

/**
 * Created by Sagar Gopale on 6/10/14.
 */
public class ExportController extends Controller {

    @With(Authenticated.class)
    public static Result export() {
        models.response.user.User u = (models.response.user.User) ctx().args.get("user");
        session().remove("pid");
        return ok(views.html.export.export.render("Excel Export", u));
    }

    @With(Authenticated.class)
    public static Result exportToExcel(Long id) {
        DataCollectionForm1 dcf1 = Ebean.find(DataCollectionForm1.class).where(Expr.and(Expr.ne("status", models.Status.DISABLED),Expr.eq("patientIdNumber", id))).findUnique();
        DataCollectionForm2 dcf2 = Ebean.find(DataCollectionForm2.class).where(Expr.and(Expr.ne("status", models.Status.DISABLED),Expr.eq("patientIdNumber", id))).findUnique();
        DataCollectionForm3 dcf3 = Ebean.find(DataCollectionForm3.class).where(Expr.and(Expr.ne("status", models.Status.DISABLED),Expr.eq("patientIdNumber", id))).findUnique();
        DataCollectionForm4 dcf4 = Ebean.find(DataCollectionForm4.class).where(Expr.and(Expr.ne("status", models.Status.DISABLED),Expr.eq("patientIdNumber", id))).findUnique();
        DataCollectionForm5 dcf5 = Ebean.find(DataCollectionForm5.class).where(Expr.and(Expr.ne("status", models.Status.DISABLED),Expr.eq("patientIdNumber", id))).findUnique();
        DataCollectionForm6 dcf6 = Ebean.find(DataCollectionForm6.class).where(Expr.and(Expr.ne("status", models.Status.DISABLED),Expr.eq("patientIdNumber", id))).findUnique();
        if(dcf1 == null)
            return badRequest(Json.toJson(new ResponseMessage(400, "No such patient found!", ResponseMessageType.BAD_REQUEST)));
        if(dcf2 == null)
            dcf2 = new DataCollectionForm2();
        if(dcf3 == null)
            dcf3 = new DataCollectionForm3();
        if(dcf4 == null)
            dcf4 = new DataCollectionForm4();
        if(dcf5 == null)
            dcf5 = new DataCollectionForm5();
        if(dcf6 == null)
            dcf6 = new DataCollectionForm6();
        Chunks<String> chunks = null;
        try {
            List<EconomicStatus> dcf1Ec = dcf1.getEconomicStatuses();
            List<EconomicStatus> dcf6Ec = dcf6.getEconomicStatuses();
            StringBuilder dcf1EcSb = new StringBuilder();
            StringBuilder dcf6EcSb = new StringBuilder();
            if(dcf1Ec != null && dcf1Ec.size() > 0){
                for(EconomicStatus e: dcf1Ec){
                    dcf1EcSb.append(e.getName() + ", ");
                }
            }
            if(dcf6Ec != null && dcf6Ec.size() > 0){
                for(EconomicStatus e: dcf6Ec){
                    dcf6EcSb.append(e.getName() + ", ");
                }
            }
            String userHome = System.getProperty("user.home");
            String csv = userHome+ "\\PatientData.csv";
            CSVWriter writer = new CSVWriter(new FileWriter(csv));
            writer.writeNext(new String[]{"Patient Id Number","Trial Site","Date Recruited","Name Of Patient","Date Of Birth","Address","Gender","" +
                    "Landline","Cell Phone","Friend/Relative Phone","Place Of Birth","Ethnicity","Native Language","Religion","" +
                    "Economic Status","Blood Taken","Blood Taken On","Blood Sample Number","Date Of Stroke","" +

                    //FORM 2
                    "Ischaemic Stroke","TACI","PACI","LACI","POCI","Hoemorrhagic Stroke","Venous Sinus Thrombosis","TIA","AVM","" +
                    "Aneurysm","Subarachnoid","Hypertension","Diabetes Mellitus","IHD/Angina","Hypercholesterolemia","Atrial Fibrillation","" +
                    "PVD","MI","Migraine With Aura","Migraine Without Aura","Ischaemic Stroke Year","" +
                    "Hoemorrhagic Stroke Year","TIA","Stroke Associated With Dissection","Stroke Associated With PFO","Stroke Associated With MI","" +
                    "Stroke (Family)","IHD/Angina(Family)","Diabetes Mellitus(Family)","MI(Family)","PVD(Family)","" +
                    "Hypertension(Family)","None Of Above(Family)","Current Smoker","Cig/day","Hip","Ex-Smoker","Never Smoked","Waist","" +

                    //FORM 3
                    "Alcohol Units Per Week","Height","Weight","BMI","Aspirin","Aspirin Dosage","Clopidogrel","Clopidogrel Dosage","Aspirin Plus Clopidogrel","" +
                    "Aspirin Plus Clopidogrel Dosage","Dipyridamole","Dipyridamole Dosage","Aspirin Plus Dipyridamole","Aspirin Plus Dipyridamole Dosage","" +
                    "Warfarin","Warfarin INR","Statin","Statin Dosage","Antihypertensive","Antihypertensive Dosage","None Of The Above Medicine","Glucose Blood Test","" +
                    "Glucose Blood Test Result","Total Cholesterol Blood Test","Total Cholesterol Blood Test Result","HDL Cholesterol Blood Test","HDL Cholesterol Blood Test Result","" +
                    "LDL Cholesterol Blood Test","LDL Cholesterol Blood Test Result","Triglyceride Blood Test","Triglyceride Blood Test Result","ESR Blood Test","" +
                    "ESR Blood Test Result","CRP Blood Test","CRP Blood Test Result","Protein C Blood Test","Protein C Blood Test Result","Protein S Blood Test Result","" +
                    "Protein S Blood Test Result","Fibrinogen Blood Test","Fibrinogen Blood Test Result","Antithrombin 11 Blood Test","Antithrombin 11 Blood Test Result","" +
                    "Factor V Blood Test","Factor V Blood Test Result","Homocysteine Blood Test","Homocysteine Blood Test Result","Prothrombin Blood Test","" +
                    "Prothrombin Blood Test Result","Antiphospholipid Blood Test","Antiphospholipid Blood Test Result","BP On Admission","Temperature On Admission","" +
                    "Carotid Endarterectomy Done","Thrombolysed Done","CTA","MRA","Angiogram Done","" +

                    //FORM 4
                    "Intracranial Stenosis","Intracranial Stenosis Percent","Extracranial Dopplers Imaging Done","Extracranial Mra Imaging Done","Extracranial Cta Imaging Done","" +
                    "Brain Ct Imaging Done","Brain Mri Imaging Done","Lesion Anterior","Lesion Right","Lesion Left","Lesion Bilateral","Lesion Posterior","Lesion Anterioposterior","RICA Stenosis Percent","" +
                    "LICA Stenosis Percent","RCCA Stenosis Percent","LCCA Stenosis Percent","R Vertebral Stenosis Percent","L Vertebral Stenosis Percent","Basilar Stenosis Percent","LVD","" +
                    "SVD","Cardioembolism","Combined","Stroke Of Determined Etiology","Negative Evaluation","Ecg Done","Echo Done","Ecg Normal","Echo LVH","Echo PFO","Echo Thrombus","Echo None Of Above","Echo Dont Know","ecgDontKnow","nihssOnAdmission","nihssOnDischarge","" +
                    "Barthel On Admission","Barthel On Discharge","Home","Nursing Home","Rehabilitation","Rip","Local Dgh","" +

                    //FORM 5
                    "Aspirin(Spouse)","Aspirin Dosage(Spouse)","Clopidogrel(Spouse)","Clopidogrel Dosage(Spouse)","Aspirin Plus Clopidogrel(Spouse)","" +
                    "Aspirin Plus Clopidogrel Dosage(Spouse)","Dipyridamole(Spouse)","Dipyridamole Dosage(Spouse)","Aspirin Plus Dipyridamole(Spouse)","Aspirin Plus Dipyridamole Dosage(Spouse)","" +
                    "Warfarin(Spouse)","Statin(Spouse)","Statin Dosage(Spouse)","Antihypertensive(Spouse)","" +
                    "Spouse Name","Spouse Address","Spouse Date Of Birth","Spouse Gender","Spouse LandLine Number","Spouse Cell Phone Number","Spouse Relative Phone Number","Spouse Place Of Birth","" +
                    "Spouse Ethnicity","Spouse Native Language","Spouse Religion","Spouse Hypertension","Spouse Diabetes Mellitus","Spouse Ihd Angina","Spouse Hypercholesterolemia","Spouse Atrial Fibrillation","" +
                    "Spouse Pvd","Spouse Mi","Spouse Migraine With Aura","Spouse Migraine Without Aura","Spouse Ischaemic Stroke","Spouse Hoemorrhagic Stroke","Spouse Tia","Spouse Bp Today","" +

                    //FORM 6
                    "Economic Statuses(Spouse)","Hip(Spouse)","Waist(Spouse)","Height(Spouse)","Weight(Spouse)","BMI(Spouse)","Blood Sample Taken(Spouse)","Blood Sample Date(Spouse)","Blood Sample Number(Spouse)\n"});
                    writer.writeNext(new String[] {dcf1.getPatientIdNumber().toString() , StringUtils.isEmpty(dcf1.getTrialSite()) ? StringUtils.EMPTY : dcf1.getTrialSite() , StringUtils.isEmpty(dcf1.getRecruitedDateString()) ? StringUtils.EMPTY : dcf1.getRecruitedDateString() , StringUtils.isEmpty(dcf1.getPatientName()) ? StringUtils.EMPTY : dcf1.getPatientName() , StringUtils.isEmpty(dcf1.getDateOfBirthString()) ? StringUtils.EMPTY : dcf1.getDateOfBirthString() , StringUtils.isEmpty(dcf1.getPatientAddress()) ? StringUtils.EMPTY : dcf1.getPatientAddress() , dcf1.getGender().name()
                    , StringUtils.isEmpty(dcf1.getLandlinePhoneNumber()) ? StringUtils.EMPTY : dcf1.getLandlinePhoneNumber() , StringUtils.isEmpty(dcf1.getCellPhoneNumber()) ? StringUtils.EMPTY : dcf1.getCellPhoneNumber() , StringUtils.isEmpty(dcf1.getFriendRelativePhoneNumber()) ? StringUtils.EMPTY : dcf1.getFriendRelativePhoneNumber() , StringUtils.isEmpty(dcf1.getPlaceOfBirth()) ? StringUtils.EMPTY : dcf1.getPlaceOfBirth() , StringUtils.isEmpty(dcf1.getEthnicity()) ? StringUtils.EMPTY : dcf1.getEthnicity() , StringUtils.isEmpty(dcf1.getNativeLanguage()) ? StringUtils.EMPTY : dcf1.getNativeLanguage() , StringUtils.isEmpty(dcf1.getReligion()) ? StringUtils.EMPTY : dcf1.getReligion()
                    , dcf1EcSb.toString() , dcf1.getBloodSampleTaken().name() , StringUtils.isEmpty(dcf1.getBloodSampleNumber()) ? StringUtils.EMPTY : dcf1.getBloodSampleNumber() , StringUtils.isEmpty(dcf1.getDateOfStrokeString()) ? StringUtils.EMPTY : dcf1.getDateOfStrokeString()
                    , dcf2.getIschaemicStroke().name() , dcf2.getTaci().name() , dcf2.getPaci().name() , dcf2.getLaci().name() , dcf2.getPoci().name() , dcf2.getHoemorrhagicStroke().name() , dcf2.getVenousSinusThrombosis().name()
                    , dcf2.getTia().name() , dcf2.getAvm().name() , dcf2.getAneurysm().name() , dcf2.getSubaranchoid().name() , dcf2.getHypertension().name() , dcf2.getDiabetesMellitus().name() , dcf2.getIhdAngina().name() , dcf2.getHypercholesterolemia().name() , dcf2.getAtrialFibrillation().name()
                    , dcf2.getPvd().name() , dcf2.getMi().name() , dcf2.getMigraineWithAura().name() , dcf2.getMigraineWithoutAura().name() , dcf2.getIschaemicStrokeYear() == 0 ? StringUtils.EMPTY : dcf2.getIschaemicStrokeYear().toString() , dcf2.getHoemorrhagicStrokeYear() == 0 ? StringUtils.EMPTY : dcf2.getHoemorrhagicStrokeYear().toString() , dcf2.getTia().name()
                    , dcf2.getStrokeAssociatedWithDissection().name() , dcf2.getStrokeAssociatedWithPfo().name() , dcf2.getStrokeAssociatedWithMi().name() , dcf2.getFamilyStroke().name() , dcf2.getFamilyIhdAngina().name() , dcf2.getFamilyDiabetesMellitus().name()
                    , dcf2.getFamilyMi().name() , dcf2.getFamilyPvd().name() , dcf2.getFamilyHypertension().name() , dcf2.getFamilyNoneOfTheAbove().name() , dcf2.getCurrentSmoker().name() , dcf2.getCigarettePerDay() == 0 ? StringUtils.EMPTY : dcf2.getCigarettePerDay().toString() , dcf2.getHip() == 0.0 ? StringUtils.EMPTY : dcf2.getHip().toString() , dcf2.getExSmoker().name() , dcf2.getNever().name()
                    , dcf2.getWaist() == 0.0 ? StringUtils.EMPTY : dcf2.getWaist().toString(), dcf3.getAlcoholUnitsPerWeek() == 0 ? StringUtils.EMPTY : dcf3.getAlcoholUnitsPerWeek().toString() , dcf3.getHeight() == 0.0 ? StringUtils.EMPTY : dcf3.getHeight().toString() , dcf3.getWeight() == 0.0 ? StringUtils.EMPTY : dcf3.getWeight().toString() , dcf3.getBmi() == 0.0 ? StringUtils.EMPTY : dcf3.getBmi().toString() , dcf3.getAspirin().name() , dcf3.getAspirinDosage() , dcf3.getClopidogrel().name() , dcf3.getClopidogrelDosage() , dcf3.getAspirinPlusClopidogrel().name()
                    , dcf3.getAspirinPlusClopidogrelDosage() , dcf3.getDipyridamole().name() , dcf3.getDipyridamoleDosage() , dcf3.getAspirinPlusDipyridamole().name() , dcf3.getAspirinPlusDipyridamoleDosage()
                    , dcf3.getWarfarin().name() , dcf3.getWarfarinInr() , dcf3.getStatin().name() , dcf3.getStatinDosage() , dcf3.getAntihypertensive().name() , dcf3.getAntihypertensiveDosage()
                    , dcf3.getMedicineNoneOfTheAbove().name() , dcf3.getGlucoseBloodTest().name() , dcf3.getGlucoseBloodTestResult() , dcf3.getTotalCholesterolBloodTest().name() , dcf3.getTotalCholesterolBloodTestResult()
                    , dcf3.getHdlCholesterolBloodTest().name() , dcf3.getHdlCholesterolBloodTestResult() , dcf3.getLdlCholesterolBloodTest().name() , dcf3.getLdlCholesterolBloodTestResult() , dcf3.getTriglycerideBloodTest().name() , dcf3.getTriglycerideBloodTestResult()
                    , dcf3.getEsrBloodTest().name() , dcf3.getEsrBloodTestResult() , dcf3.getCrpBloodTest().name() , dcf3.getCrpBloodTestResult() , dcf3.getProteinCBloodTest().name() , dcf3.getProteinCBloodTestResult()
                    , dcf3.getProteinSBloodTest().name() , dcf3.getProteinSBloodTestResult() , dcf3.getFibrinogenBloodTest().name() , dcf3.getFibrinogenBloodTestResult() , dcf3.getAntithrombin11BloodTest().name() , dcf3.getAntithrombin11BloodTestResult()
                    , dcf3.getFactorVBloodTest().name() , dcf3.getFactorVBloodTestResult() , dcf3.getHomocysteineBloodTest().name() , dcf3.getHomocysteineBloodTestResult() , dcf3.getProthrombinBloodTest().name() , dcf3.getProthrombinBloodTestResult()
                    , dcf3.getAntiphospholipidBloodTest().name() , dcf3.getAntiphospholipidBloodTestResult() , dcf3.getBpOnAdmission() , dcf3.getTemperatureOnAdmission() , dcf3.getCarotidEndarterectomyDone().name()
                    , dcf3.getThrombolysedDone().name() , dcf3.getCtaDone().name() , dcf3.getMraDone().name() , dcf3.getAngiogramDone().name() , dcf4.getIntracranialStenosis().name() , StringUtils.isEmpty(dcf4.getIntracranialStenosisPercent()) ? StringUtils.EMPTY : dcf4.getIntracranialStenosisPercent() , dcf4.getExtracranialDopplersImagingDone().name() , dcf4.getExtracranialMraImagingDone().name() , dcf4.getExtracranialCtaImagingDone().name()
                    , dcf4.getBrainCtImagingDone().name() , dcf4.getBrainMriImagingDone().name() , dcf4.getLesionAnterior().name() , dcf4.getLesionRight().name() , dcf4.getLesionLeft().name() , dcf4.getLesionBilateral().name() , dcf4.getLesionPosterior().name()
                    , dcf4.getLesionAnterioposterior().name() , dcf4.getRicaStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf4.getRicaStenosisPercent().toString() , dcf4.getLicaStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf4.getLicaStenosisPercent().toString() , dcf4.getRccaStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf4.getRccaStenosisPercent().toString() , dcf4.getLccaStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf4.getLccaStenosisPercent().toString() , dcf4.getrVertebralStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf4.getrVertebralStenosisPercent().toString() , dcf4.getlVertebralStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf4.getlVertebralStenosisPercent().toString()
                    , dcf4.getBasilarStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf4.getBasilarStenosisPercent().toString() , dcf4.getLvd().name() , dcf4.getSvd().name() , dcf4.getCardioembolism().name() , dcf4.getCombined().name() , dcf4.getStrokeOfDeterminedEtiology().name() , dcf4.getNegativeEvaluation().name() , dcf4.getEcgDone().name() , dcf4.getEchoDone().name()
                    , dcf4.getEcgNormal().name() , dcf4.getEchoLvh().name() , dcf4.getEchoPfo().name() , dcf4.getEchoThrombus().name() , dcf4.getEchoNoneOfAbove().name() , dcf4.getEchoDontKnow().name() , dcf4.getEcgDontKnow().name()
                    , StringUtils.isEmpty(dcf4.getNihssOnAdmission()) ? StringUtils.EMPTY : dcf4.getNihssOnAdmission() , StringUtils.isEmpty(dcf4.getNihssOnDischarge()) ? StringUtils.EMPTY : dcf4.getNihssOnDischarge() , StringUtils.isEmpty(dcf4.getBarthelOnAdmission()) ? StringUtils.EMPTY : dcf4.getBarthelOnAdmission() , StringUtils.isEmpty(dcf4.getBarthelOnDischarge()) ? StringUtils.EMPTY : dcf4.getBarthelOnDischarge() , dcf4.getHome().name() , dcf4.getNursingHome().name() , dcf4.getRehabilitation().name() , dcf4.getRip().name() , dcf4.getLocalDgh().name()
                    , dcf5.getAspirin().name() , StringUtils.isEmpty(dcf5.getAspirinDosage()) ? StringUtils.EMPTY : dcf5.getAspirinDosage() , dcf5.getClopidogrel().name() , StringUtils.isEmpty(dcf5.getClopidogrelDosage()) ? StringUtils.EMPTY : dcf5.getClopidogrelDosage() , dcf5.getAspirinPlusClopidogrel().name()
                    , StringUtils.isEmpty(dcf5.getAspirinPlusClopidogrelDosage()) ? StringUtils.EMPTY : dcf5.getAspirinPlusClopidogrelDosage() , dcf5.getDipyridamole().name() , StringUtils.isEmpty(dcf5.getDipyridamoleDosage()) ? StringUtils.EMPTY : dcf5.getDipyridamoleDosage() , dcf5.getAspirinPlusDipyridamole().name() , StringUtils.isEmpty(dcf5.getAspirinPlusDipyridamoleDosage()) ? StringUtils.EMPTY : dcf5.getAspirinPlusDipyridamoleDosage()
                    , dcf5.getWarfarin().name() , dcf5.getStatin().name() , StringUtils.isEmpty(dcf5.getStatinDosage()) ? StringUtils.EMPTY : dcf5.getStatinDosage() , dcf5.getAntihypertensive().name() , StringUtils.isEmpty(dcf5.getSpouseName()) ? StringUtils.EMPTY : dcf5.getSpouseName() , StringUtils.isEmpty(dcf5.getSpouseAddress()) ? StringUtils.EMPTY : dcf5.getSpouseAddress() , StringUtils.isEmpty(dcf5.getSpouseDateOfBirthString()) ? StringUtils.EMPTY : dcf5.getSpouseDateOfBirthString() , dcf5.getSpouseGender().name()
                    , StringUtils.isEmpty(dcf5.getSpouseLandlinePhoneNumber()) ? StringUtils.EMPTY : dcf5.getSpouseLandlinePhoneNumber() , StringUtils.isEmpty(dcf5.getSpouseCellPhoneNumber()) ? StringUtils.EMPTY : dcf5.getSpouseCellPhoneNumber() , StringUtils.isEmpty(dcf5.getSpouseFriendPhoneNumber()) ? StringUtils.EMPTY : dcf5.getSpouseFriendPhoneNumber() , StringUtils.isEmpty(dcf5.getSpousePlaceOfBirth()) ? StringUtils.EMPTY : dcf5.getSpousePlaceOfBirth() , StringUtils.isEmpty(dcf5.getSpouseEthnicity()) ? StringUtils.EMPTY : dcf5.getSpouseEthnicity() , StringUtils.isEmpty(dcf5.getSpouseNativeLanguage()) ? StringUtils.EMPTY : dcf5.getSpouseNativeLanguage() , StringUtils.isEmpty(dcf5.getSpouseReligion()) ? StringUtils.EMPTY :dcf5.getSpouseReligion()
                    , dcf5.getSpouseHypertension().name() , dcf5.getSpouseDiabetesMellitus().name() , dcf5.getSpouseIhdAngina().name() , dcf5.getSpouseHypercholesterolemia().name() , dcf5.getSpouseAtrialFibrillation().name()
                    , dcf5.getSpousePvd().name() , dcf5.getSpouseMi().name() , dcf5.getSpouseMigraineWithAura().name() , dcf5.getSpouseMigraineWithoutAura().name() , dcf5.getSpouseIschaemicStroke().name() , dcf5.getSpouseHoemorrhagicStroke().name() , dcf5.getSpouseTia().name()
                    , StringUtils.isEmpty(dcf5.getBpToday()) ? StringUtils.EMPTY : dcf5.getBpToday(), dcf6EcSb.toString() , dcf6.getHip() == 0.0 ? StringUtils.EMPTY : dcf6.getHip().toString() , dcf6.getWaist() == 0.0 ? StringUtils.EMPTY : dcf6.getWaist().toString() , dcf6.getHeight() == 0.0 ? StringUtils.EMPTY : dcf6.getHeight().toString() , dcf6.getWeight() == 0.0 ? StringUtils.EMPTY : dcf6.getWeight().toString() , dcf6.getBmi() == 0.0 ? StringUtils.EMPTY : dcf6.getBmi().toString() , dcf6.getBloodSampleTaken().name() , StringUtils.isEmpty(dcf6.getBloodSampleDateString()) ? StringUtils.EMPTY : dcf6.getBloodSampleDateString() , StringUtils.isEmpty(dcf6.getBloodSampleNumber()) ? StringUtils.EMPTY : dcf6.getBloodSampleNumber() + "\n"});
            writer.close();
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
        }
        /*try{
            chunks = new StringChunks() {
                // Called when the stream is ready
                public void onReady(Chunks.Out<String> out) {
                    List<EconomicStatus> dcf1Ec = dcf1.getEconomicStatuses();
                    List<EconomicStatus> dcf6Ec = dcf6.getEconomicStatuses();
                    StringBuilder dcf1EcSb = new StringBuilder();
                    StringBuilder dcf6EcSb = new StringBuilder();
                    if(dcf1Ec != null && dcf1Ec.size() > 0){
                        for(EconomicStatus e: dcf1Ec){
                            dcf1EcSb.append(e.getName() + ", ");
                        }
                    }
                    if(dcf6Ec != null && dcf6Ec.size() > 0){
                        for(EconomicStatus e: dcf6Ec){
                            dcf6EcSb.append(e.getName() + ", ");
                        }
                    }
                    //FORM 1
                    out.write("Patient Id Number, Trial Site, Date Recruited, Name Of Patient, Date Of Birth, Address, Gender, " +
                            "Landline, Cell Phone, Friend/Relative Phone, Place Of Birth, Ethnicity, Native Language, Religion, " +
                            "Economic Status, Blood Taken, Blood Taken On, Blood Sample Number, Date Of Stroke, " +

                            //FORM 2
                            "Ischaemic Stroke, TACI, PACI, LACI, POCI, Hoemorrhagic Stroke, Venous Sinus Thrombosis, TIA, AVM, " +
                            "Aneurysm, Subarachnoid, Hypertension, Diabetes Mellitus, IHD/Angina, Hypercholesterolemia, Atrial Fibrillation," +
                            "PVD, MI, Migraine With Aura, Migraine Without Aura, Ischaemic Stroke Year," +
                            "Hoemorrhagic Stroke Year, TIA, Stroke Associated With Dissection, Stroke Associated With PFO, Stroke Associated With MI," +
                            "Stroke (Family), IHD/Angina(Family), Diabetes Mellitus(Family), MI(Family), PVD(Family)," +
                            "Hypertension(Family), None Of Above(Family), Current Smoker, Cig/day, Hip, Ex-Smoker, Never Smoked, Waist, " +

                            //FORM 3
                            "Alcohol Units Per Week, Height, Weight, BMI, Aspirin, Aspirin Dosage, Clopidogrel, Clopidogrel Dosage, Aspirin Plus Clopidogrel," +
                            "Aspirin Plus Clopidogrel Dosage, Dipyridamole, Dipyridamole Dosage, Aspirin Plus Dipyridamole, Aspirin Plus Dipyridamole Dosage, " +
                            "Warfarin, Warfarin INR, Statin, Statin Dosage, Antihypertensive, Antihypertensive Dosage, None Of The Above Medicine, Glucose Blood Test," +
                            "Glucose Blood Test Result, Total Cholesterol Blood Test, Total Cholesterol Blood Test Result, HDL Cholesterol Blood Test, HDL Cholesterol Blood Test Result, " +
                            "LDL Cholesterol Blood Test, LDL Cholesterol Blood Test Result, Triglyceride Blood Test, Triglyceride Blood Test Result, ESR Blood Test," +
                            "ESR Blood Test Result, CRP Blood Test, CRP Blood Test Result, Protein C Blood Test, Protein C Blood Test Result, Protein S Blood Test Result," +
                            "Protein S Blood Test Result, Fibrinogen Blood Test, Fibrinogen Blood Test Result, Antithrombin 11 Blood Test, Antithrombin 11 Blood Test Result," +
                            "Factor V Blood Test, Factor V Blood Test Result, Homocysteine Blood Test, Homocysteine Blood Test Result, Prothrombin Blood Test," +
                            "Prothrombin Blood Test Result, Antiphospholipid Blood Test, Antiphospholipid Blood Test Result, BP On Admission, Temperature On Admission," +
                            "Carotid Endarterectomy Done, Thrombolysed Done, CTA, MRA, Angiogram Done," +

                            //FORM 4
                            "Intracranial Stenosis, Intracranial Stenosis Percent, Extracranial Dopplers Imaging Done, Extracranial Mra Imaging Done, Extracranial Cta Imaging Done," +
                            "Brain Ct Imaging Done, Brain Mri Imaging Done, Lesion Anterior, Lesion Right, Lesion Left, Lesion Bilateral, Lesion Posterior, Lesion Anterioposterior, RICA Stenosis Percent, " +
                            "LICA Stenosis Percent, RCCA Stenosis Percent, LCCA Stenosis Percent, R Vertebral Stenosis Percent, L Vertebral Stenosis Percent, Basilar Stenosis Percent, LVD, " +
                            "SVD, Cardioembolism, Combined, Stroke Of Determined Etiology, Negative Evaluation, Ecg Done, Echo Done, Ecg Normal, Echo LVH, Echo PFO, Echo Thrombus, Echo None Of Above, Echo Dont Know, ecgDontKnow, nihssOnAdmission, nihssOnDischarge," +
                            "Barthel On Admission, Barthel On Discharge, Home, Nursing Home, Rehabilitation, Rip, Local Dgh, " +

                            //FORM 5
                            "Aspirin(Spouse), Aspirin Dosage(Spouse), Clopidogrel(Spouse), Clopidogrel Dosage(Spouse), Aspirin Plus Clopidogrel(Spouse), " +
                            "Aspirin Plus Clopidogrel Dosage(Spouse), Dipyridamole(Spouse), Dipyridamole Dosage(Spouse), Aspirin Plus Dipyridamole(Spouse), Aspirin Plus Dipyridamole Dosage(Spouse), " +
                            "Warfarin(Spouse), Statin(Spouse), Statin Dosage(Spouse), Antihypertensive(Spouse)," +
                            "Spouse Name, Spouse Address, Spouse Date Of Birth, Spouse Gender, Spouse LandLine Number, Spouse Cell Phone Number, Spouse Relative Phone Number, Spouse Place Of Birth," +
                            "Spouse Ethnicity, Spouse Native Language, Spouse Religion, Spouse Hypertension, Spouse Diabetes Mellitus, Spouse Ihd Angina, Spouse Hypercholesterolemia, Spouse Atrial Fibrillation," +
                            "Spouse Pvd, Spouse Mi, Spouse Migraine With Aura, Spouse Migraine Without Aura, Spouse Ischaemic Stroke, Spouse Hoemorrhagic Stroke, Spouse Tia, Spouse Bp Today," +

                            //FORM 6
                            "Economic Statuses(Spouse), Hip(Spouse), Waist(Spouse), Height(Spouse), Weight(Spouse), BMI(Spouse), Blood Sample Taken(Spouse), Blood Sample Date(Spouse), Blood Sample Number(Spouse)\n");
                    out.write(dcf1.getPatientIdNumber().toString() + "," + dcf1.getTrialSite() + "," + dcf1.getRecruitedDateString() + "," + dcf1.getPatientName() + "," + dcf1.getDateOfBirthString() + "," + dcf1.getPatientAddress() + "," + dcf1.getGender().name()
                            + "," + dcf1.getLandlinePhoneNumber() + "," + dcf1.getCellPhoneNumber() + "," + dcf1.getFriendRelativePhoneNumber() + "," + dcf1.getPlaceOfBirth() + "," + dcf1.getEthnicity() + "," + dcf1.getNativeLanguage() + "," + dcf1.getReligion()
                            + "," + dcf1EcSb.toString() + "," + dcf1.getBloodSampleTaken().name() + "," + dcf1.getBloodSampleNumber() + "," + dcf1.getDateOfStrokeString()

                            + "," + dcf2.getIschaemicStroke().name() + "," + dcf2.getTaci().name() + "," + dcf2.getPaci().name() + "," + dcf2.getLaci().name() + "," + dcf2.getPoci().name() + "," + dcf2.getHoemorrhagicStroke().name() + "," + dcf2.getVenousSinusThrombosis().name()
                            + "," + dcf2.getTia().name() + "," + dcf2.getAvm().name() + "," + dcf2.getAneurysm().name() + "," + dcf2.getSubaranchoid().name() + "," + dcf2.getHypertension() + "," + dcf2.getDiabetesMellitus().name() + "," + dcf2.getIhdAngina().name() + "," + dcf2.getHypercholesterolemia() + "," + dcf2.getAtrialFibrillation().name()
                            + "," + dcf2.getPvd().name() + "," + dcf2.getMi().name() + "," + dcf2.getMigraineWithAura().name() + "," + dcf2.getMigraineWithoutAura().name() + "," + dcf2.getIschaemicStrokeYear().toString() + "," + dcf2.getHoemorrhagicStrokeYear().toString() + "," + dcf2.getTia().name()
                            + "," + dcf2.getStrokeAssociatedWithDissection().name() + "," + dcf2.getStrokeAssociatedWithPfo().name() + "," + dcf2.getStrokeAssociatedWithMi().name() + "," + dcf2.getFamilyStroke().name() + "," + dcf2.getFamilyIhdAngina().name() + "," + dcf2.getFamilyDiabetesMellitus().name()
                            + "," + dcf2.getFamilyMi().name() + "," + dcf2.getFamilyPvd().name() + "," + dcf2.getFamilyHypertension().name() + "," + dcf2.getFamilyNoneOfTheAbove().name() + "," + dcf2.getCurrentSmoker().name() + "," + dcf2.getCigarettePerDay().toString() + "," + dcf2.getHip().toString() + "," + dcf2.getExSmoker() + "," + dcf2.getNever()
                            + "," + dcf2.getWaist().toString()

                            + "," + dcf3.getAlcoholUnitsPerWeek().toString() + "," + dcf3.getHeight().toString() + "," + dcf3.getWeight().toString() + "," + dcf3.getBmi().toString() + "," + dcf3.getAspirin().name() + "," + dcf3.getAspirinDosage() + "," + dcf3.getClopidogrel().name() + "," + dcf3.getClopidogrelDosage() + "," + dcf3.getAspirinPlusClopidogrel().name()
                            + "," + dcf3.getAspirinPlusClopidogrelDosage() + "," + dcf3.getDipyridamole().name() + "," + dcf3.getDipyridamoleDosage() + "," + dcf3.getAspirinPlusDipyridamole().name() + "," + dcf3.getAspirinPlusDipyridamoleDosage()
                            + "," + dcf3.getWarfarin().name() + "," + dcf3.getWarfarinInr() + "," + dcf3.getStatin().name() + "," + dcf3.getStatinDosage() + "," + dcf3.getAntihypertensive().name() + "," + dcf3.getAntihypertensiveDosage()
                            + "," + dcf3.getMedicineNoneOfTheAbove().name() + "," + dcf3.getGlucoseBloodTest().name() + "," + dcf3.getGlucoseBloodTestResult() + "," + dcf3.getTotalCholesterolBloodTest().name() + "," + dcf3.getTotalCholesterolBloodTestResult()
                            + "," + dcf3.getHdlCholesterolBloodTest().name() + "," + dcf3.getHdlCholesterolBloodTestResult() + "," + dcf3.getLdlCholesterolBloodTest().name() + "," + dcf3.getLdlCholesterolBloodTestResult() + "," + dcf3.getTriglycerideBloodTest().name() + "," + dcf3.getTriglycerideBloodTestResult()
                            + "," + dcf3.getEsrBloodTest().name() + "," + dcf3.getEsrBloodTestResult() + "," + dcf3.getCrpBloodTest().name() + "," + dcf3.getCrpBloodTestResult() + "," + dcf3.getProteinCBloodTest().name() + "," + dcf3.getProteinCBloodTestResult()
                            + "," + dcf3.getProteinSBloodTest().name() + "," + dcf3.getProteinSBloodTestResult() + "," + dcf3.getFibrinogenBloodTest().name() + "," + dcf3.getFibrinogenBloodTestResult() + "," + dcf3.getAntithrombin11BloodTest().name() + "," + dcf3.getAntithrombin11BloodTestResult()
                            + "," + dcf3.getFactorVBloodTest().name() + "," + dcf3.getFactorVBloodTestResult() + "," + dcf3.getHomocysteineBloodTest().name() + "," + dcf3.getHomocysteineBloodTestResult() + "," + dcf3.getProthrombinBloodTest().name() + "," + dcf3.getProthrombinBloodTestResult()
                            + "," + dcf3.getAntiphospholipidBloodTest().name() + "," + dcf3.getAntiphospholipidBloodTestResult() + "," + dcf3.getBpOnAdmission() + "," + dcf3.getTemperatureOnAdmission() + "," + dcf3.getCarotidEndarterectomyDone().name()
                            + "," + dcf3.getThrombolysedDone().name() + "," + dcf3.getCtaDone().name() + "," + dcf3.getMraDone().name() + "," + dcf3.getAngiogramDone().name()

                            + "," + dcf4.getIntracranialStenosis().name() + "," + dcf4.getIntracranialStenosisPercent() + "," + dcf4.getExtracranialDopplersImagingDone().name() + "," + dcf4.getExtracranialMraImagingDone().name() + "," + dcf4.getExtracranialCtaImagingDone().name()
                            + "," + dcf4.getBrainCtImagingDone().name() + "," + dcf4.getBrainMriImagingDone().name() + "," + dcf4.getLesionAnterior().name() + "," + dcf4.getLesionRight().name() + "," + dcf4.getLesionLeft().name() + "," + dcf4.getLesionBilateral() + "," + dcf4.getLesionPosterior().name()
                            + "," + dcf4.getLesionAnterioposterior().name() + "," + dcf4.getRicaStenosisPercent().toString() + "," + dcf4.getLicaStenosisPercent().toString() + "," + dcf4.getRccaStenosisPercent().toString() + "," + dcf4.getLccaStenosisPercent().toString() + "," + dcf4.getrVertebralStenosisPercent().toString() + "," + dcf4.getlVertebralStenosisPercent().toString()
                            + "," + dcf4.getBasilarStenosisPercent().toString() + "," + dcf4.getLvd().name() + "," + dcf4.getSvd().name() + "," + dcf4.getCardioembolism().name() + "," + dcf4.getCombined().name() + "," + dcf4.getStrokeOfDeterminedEtiology().name() + "," + dcf4.getNegativeEvaluation() + "," + dcf4.getEcgDone().name() + "," + dcf4.getEchoDone().name()
                            + "," + dcf4.getEcgNormal().name() + "," + dcf4.getEchoLvh().name() + "," + dcf4.getEchoPfo().name() + "," + dcf4.getEchoThrombus().name() + "," + dcf4.getEchoNoneOfAbove().name() + "," + dcf4.getEchoDontKnow().name() + "," + dcf4.getEcgDontKnow().name()
                            + "," + dcf4.getNihssOnAdmission() + "," + dcf4.getNihssOnDischarge() + "," + dcf4.getBarthelOnAdmission() + "," + dcf4.getBarthelOnDischarge() + "," + dcf4.getHome().name() + "," + dcf4.getNursingHome().name() + "," + dcf4.getRehabilitation().name() + "," + dcf4.getRip().name() + "," + dcf4.getLocalDgh().name()

                            + "," + dcf5.getAspirin().name() + "," + dcf5.getAspirinDosage() + "," + dcf5.getClopidogrel().name() + "," + dcf5.getClopidogrelDosage() + "," + dcf5.getAspirinPlusClopidogrel().name()
                            + "," + dcf5.getAspirinPlusClopidogrelDosage() + "," + dcf5.getDipyridamole().name() + "," + dcf5.getDipyridamoleDosage() + "," + dcf5.getAspirinPlusDipyridamole().name() + "," + dcf5.getAspirinPlusDipyridamoleDosage()
                            + "," + dcf5.getWarfarin().name() + "," + dcf5.getStatin().name() + "," + dcf5.getStatinDosage() + "," + dcf5.getAntihypertensive().name() + "," + dcf5.getSpouseName() + "," + dcf5.getSpouseAddress() + "," + dcf5.getSpouseDateOfBirthString() + "," + dcf5.getSpouseGender().name()
                            + "," + dcf5.getSpouseLandlinePhoneNumber() + "," + dcf5.getSpouseCellPhoneNumber() + "," + dcf5.getSpouseFriendPhoneNumber() + "," + dcf5.getSpousePlaceOfBirth() + "," + dcf5.getSpouseEthnicity() + "," + dcf5.getSpouseNativeLanguage() + "," + dcf5.getSpouseReligion()
                            + "," + dcf5.getSpouseHypertension().name() + "," + dcf5.getSpouseDiabetesMellitus().name() + "," + dcf5.getSpouseIhdAngina().name() + "," + dcf5.getSpouseHypercholesterolemia().name() + "," + dcf5.getSpouseAtrialFibrillation().name()
                            + "," + dcf5.getSpousePvd().name() + "," + dcf5.getSpouseMi().name() + "," + dcf5.getSpouseMigraineWithAura().name() + "," + dcf5.getSpouseMigraineWithoutAura().name() + "," + dcf5.getSpouseIschaemicStroke().name() + "," + dcf5.getSpouseHoemorrhagicStroke().name() + "," + dcf5.getSpouseTia().name()
                            + "," + dcf5.getBpToday()

                            + "," + dcf6EcSb.toString() + "," + dcf6.getHip().toString() + "," + dcf6.getWaist().toString() + "," + dcf6.getHeight().toString() + "," + dcf6.getWeight().toString() + "," + dcf6.getBmi().toString() + "," + dcf6.getBloodSampleTaken().name() + "," + dcf6.getBloodSampleDateString() + "," + dcf6.getBloodSampleNumber() + "\n");
                    out.close();
                }
            };
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
        }*/
        // Serves this stream with 200 OK
        /*response().setContentType("text/csv");
        response().setHeader("Content-Disposition", "attachment; filename=PatientData.csv");*/
        return redirect(controllers.data.routes.DataController.patientList());
    }
}
