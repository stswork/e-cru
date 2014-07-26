package actors;

import actors.mail.MailSenderActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import com.avaje.ebean.Ebean;
import com.avaje.ebean.Expr;
import com.google.common.io.Files;
import models.actor.mail.Mail;
import models.amazon.s3.S3File;
import models.data.form.DataCollectionForm1;
import models.data.form.EconomicStatus;
import models.request.export.ExportRequest;
import models.response.ResponseMessage;
import models.response.ResponseMessageType;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import play.Logger;
import play.libs.Akka;

import java.io.BufferedWriter;
import java.io.File;
import java.nio.charset.Charset;
import java.util.List;

public class ExportActor extends UntypedActor {

    private static final DateTimeFormatter printFmtDateTime = DateTimeFormat.forPattern("dd-MMM-yyyy H:mm:ss");
    private static final DateTimeFormatter fmt = DateTimeFormat.forPattern("MM/dd/yyyy");
    private static final DateTimeFormatter printFmt = DateTimeFormat.forPattern("dd-MMM-yyyy");

    @Override
    public void onReceive(Object message) throws Exception {

        ExportRequest er = null;
        File f = new File("ExportExcel" + String.valueOf(DateTime.now().getMillis()) + ".csv");
        if(f.exists()) {
            boolean deleted = f.delete();
        }
        if(message instanceof ExportRequest)
            er = (ExportRequest) message;
        DateTime fd = DateTime.parse(er.getStartDate(), fmt).withTimeAtStartOfDay();
        DateTime td = DateTime.parse(er.getEndDate(), fmt).plusDays(1).withTimeAtStartOfDay();
        final List<DataCollectionForm1> dcfList = Ebean.find(DataCollectionForm1.class)
                .fetch("dataCollectionForm2")
                .fetch("dataCollectionForm3")
                .fetch("dataCollectionForm4")
                .fetch("dataCollectionForm5")
                .fetch("dataCollectionForm6")
                .where(
                        Expr.and(
                                Expr.between("created", fd, td),
                                Expr.ne("status", models.Status.DISABLED)
                        )
                ).findList();
        try {
            if(dcfList != null && dcfList.size() > 0) {
                Charset charset = Charset.forName("US-ASCII");
                BufferedWriter writer = Files.newWriter(f, charset);
                writer.write("Patient Id Number, Trial Site, Date Recruited, Name Of Patient, Date Of Birth, Address, Gender, " +
                        "Landline, Cell Phone, Friend/Relative Phone, Place Of Birth, Ethnicity, Native Language, Religion, " +
                        "Economic Status, Blood Taken, Blood Sample Number, Date Of Stroke, " +

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
                for(DataCollectionForm1 dcf1: dcfList){
                    List<EconomicStatus> dcf1Ec = dcf1.getEconomicStatuses();
                    List<EconomicStatus> dcf6Ec = dcf1.getDataCollectionForm6().getEconomicStatuses();
                    StringBuilder dcf1EcSb = new StringBuilder();
                    StringBuilder dcf6EcSb = new StringBuilder();
                    if(dcf1Ec != null && dcf1Ec.size() > 0){
                        for(EconomicStatus e: dcf1Ec){
                            dcf1EcSb.append(e.getName() + "/ ");
                        }
                    }
                    if(dcf6Ec != null && dcf6Ec.size() > 0){
                        for(EconomicStatus e: dcf6Ec){
                            dcf6EcSb.append(e.getName() + "/ ");
                        }
                    }
                    writer.write(dcf1.getPatientIdNumber().toString()
                            + "," + (StringUtils.isEmpty(dcf1.getTrialSite()) ? StringUtils.EMPTY : dcf1.getTrialSite())
                            + "," + (StringUtils.isEmpty(dcf1.getRecruitedDateString()) ? StringUtils.EMPTY : dcf1.getRecruitedDateString())
                            + "," + (StringUtils.isEmpty(dcf1.getPatientName()) ? StringUtils.EMPTY : dcf1.getPatientName())
                            + "," + (StringUtils.isEmpty(dcf1.getDateOfBirthString()) ? StringUtils.EMPTY : dcf1.getDateOfBirthString())
                            + "," + (StringUtils.isEmpty(dcf1.getPatientAddress()) ? StringUtils.EMPTY : dcf1.getPatientAddress())
                            + "," + (dcf1.getGender().name())
                            + "," + (StringUtils.isEmpty(dcf1.getLandlinePhoneNumber()) ? StringUtils.EMPTY : dcf1.getLandlinePhoneNumber())
                            + "," + (StringUtils.isEmpty(dcf1.getCellPhoneNumber()) ? StringUtils.EMPTY : dcf1.getCellPhoneNumber())
                            + "," + (StringUtils.isEmpty(dcf1.getFriendRelativePhoneNumber()) ? StringUtils.EMPTY : dcf1.getFriendRelativePhoneNumber())
                            + "," + (StringUtils.isEmpty(dcf1.getPlaceOfBirth()) ? StringUtils.EMPTY : dcf1.getPlaceOfBirth())
                            + "," + (StringUtils.isEmpty(dcf1.getEthnicity()) ? StringUtils.EMPTY : dcf1.getEthnicity())
                            + "," + (StringUtils.isEmpty(dcf1.getNativeLanguage()) ? StringUtils.EMPTY : dcf1.getNativeLanguage())
                            + "," + (StringUtils.isEmpty(dcf1.getReligion()) ? StringUtils.EMPTY : dcf1.getReligion())
                            + "," + (dcf1EcSb.toString())
                            + "," + dcf1.getBloodSampleTaken().name()
                            + "," + (StringUtils.isEmpty(dcf1.getBloodSampleNumber()) ? StringUtils.EMPTY : dcf1.getBloodSampleNumber())
                            + "," + (StringUtils.isEmpty(dcf1.getDateOfStrokeString()) ? StringUtils.EMPTY : dcf1.getDateOfStrokeString())

                            + "," + dcf1.getDataCollectionForm2().getIschaemicStroke().name() + "," + dcf1.getDataCollectionForm2().getTaci().name() + "," + dcf1.getDataCollectionForm2().getPaci().name() + "," + dcf1.getDataCollectionForm2().getLaci().name() + "," + dcf1.getDataCollectionForm2().getPoci().name() + "," + dcf1.getDataCollectionForm2().getHoemorrhagicStroke().name() + "," + dcf1.getDataCollectionForm2().getVenousSinusThrombosis().name()
                            + "," + dcf1.getDataCollectionForm2().getTia().name() + "," + dcf1.getDataCollectionForm2().getAvm().name() + "," + dcf1.getDataCollectionForm2().getAneurysm().name() + "," + dcf1.getDataCollectionForm2().getSubaranchoid().name() + "," + dcf1.getDataCollectionForm2().getHypertension().name() + "," + dcf1.getDataCollectionForm2().getDiabetesMellitus().name() + "," + dcf1.getDataCollectionForm2().getIhdAngina().name() + "," + dcf1.getDataCollectionForm2().getHypercholesterolemia().name() + "," + dcf1.getDataCollectionForm2().getAtrialFibrillation().name()
                            + "," + dcf1.getDataCollectionForm2().getPvd().name() + "," + dcf1.getDataCollectionForm2().getMi().name() + "," + dcf1.getDataCollectionForm2().getMigraineWithAura().name() + "," + dcf1.getDataCollectionForm2().getMigraineWithoutAura().name() + "," + (dcf1.getDataCollectionForm2().getIschaemicStrokeYear() == 0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm2().getIschaemicStrokeYear().toString()) + "," + (dcf1.getDataCollectionForm2().getHoemorrhagicStrokeYear() == 0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm2().getHoemorrhagicStrokeYear().toString()) + "," + dcf1.getDataCollectionForm2().getTia().name()
                            + "," + dcf1.getDataCollectionForm2().getStrokeAssociatedWithDissection().name() + "," + dcf1.getDataCollectionForm2().getStrokeAssociatedWithPfo().name() + "," + dcf1.getDataCollectionForm2().getStrokeAssociatedWithMi().name() + "," + dcf1.getDataCollectionForm2().getFamilyStroke().name() + "," + dcf1.getDataCollectionForm2().getFamilyIhdAngina().name() + "," + dcf1.getDataCollectionForm2().getFamilyDiabetesMellitus().name()
                            + "," + dcf1.getDataCollectionForm2().getFamilyMi().name() + "," + dcf1.getDataCollectionForm2().getFamilyPvd().name() + "," + dcf1.getDataCollectionForm2().getFamilyHypertension().name() + "," + dcf1.getDataCollectionForm2().getFamilyNoneOfTheAbove().name() + "," + dcf1.getDataCollectionForm2().getCurrentSmoker().name() + "," + (dcf1.getDataCollectionForm2().getCigarettePerDay() == 0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm2().getCigarettePerDay().toString()) + "," + (dcf1.getDataCollectionForm2().getHip() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm2().getHip().toString()) + "," + dcf1.getDataCollectionForm2().getExSmoker().name() + "," + dcf1.getDataCollectionForm2().getNever().name()
                            + "," + (dcf1.getDataCollectionForm2().getWaist() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm2().getWaist().toString())

                            + "," + (dcf1.getDataCollectionForm3().getAlcoholUnitsPerWeek().equals(0) ? 0 : dcf1.getDataCollectionForm3().getAlcoholUnitsPerWeek().toString())
                            + "," + (dcf1.getDataCollectionForm3().getHeight() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm3().getHeight().toString())
                            + "," + (dcf1.getDataCollectionForm3().getWeight() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm3().getWeight().toString())
                            + "," + (dcf1.getDataCollectionForm3().getBmi() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm3().getBmi().toString())
                            + "," + dcf1.getDataCollectionForm3().getAspirin().name()
                            + "," + dcf1.getDataCollectionForm3().getAspirinDosage()
                            + "," + dcf1.getDataCollectionForm3().getClopidogrel().name()
                            + "," + dcf1.getDataCollectionForm3().getClopidogrelDosage()
                            + "," + dcf1.getDataCollectionForm3().getAspirinPlusClopidogrel().name()
                            + "," + dcf1.getDataCollectionForm3().getAspirinPlusClopidogrelDosage()
                            + "," + dcf1.getDataCollectionForm3().getDipyridamole().name()
                            + "," + dcf1.getDataCollectionForm3().getDipyridamoleDosage()
                            + "," + dcf1.getDataCollectionForm3().getAspirinPlusDipyridamole().name()
                            + "," + dcf1.getDataCollectionForm3().getAspirinPlusDipyridamoleDosage()
                            + "," + dcf1.getDataCollectionForm3().getWarfarin().name()
                            + "," + dcf1.getDataCollectionForm3().getWarfarinInr()
                            + "," + dcf1.getDataCollectionForm3().getStatin().name()
                            + "," + dcf1.getDataCollectionForm3().getStatinDosage()
                            + "," + dcf1.getDataCollectionForm3().getAntihypertensive().name()
                            + "," + dcf1.getDataCollectionForm3().getAntihypertensiveDosage()
                            + "," + dcf1.getDataCollectionForm3().getMedicineNoneOfTheAbove().name()
                            + "," + dcf1.getDataCollectionForm3().getGlucoseBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getGlucoseBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getTotalCholesterolBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getTotalCholesterolBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getHdlCholesterolBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getHdlCholesterolBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getLdlCholesterolBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getLdlCholesterolBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getTriglycerideBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getTriglycerideBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getEsrBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getEsrBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getCrpBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getCrpBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getProteinCBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getProteinCBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getProteinSBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getProteinSBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getFibrinogenBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getFibrinogenBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getAntithrombin11BloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getAntithrombin11BloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getFactorVBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getFactorVBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getHomocysteineBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getHomocysteineBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getProthrombinBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getProthrombinBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getAntiphospholipidBloodTest().name()
                            + "," + dcf1.getDataCollectionForm3().getAntiphospholipidBloodTestResult()
                            + "," + dcf1.getDataCollectionForm3().getBpOnAdmission()
                            + "," + dcf1.getDataCollectionForm3().getTemperatureOnAdmission()
                            + "," + dcf1.getDataCollectionForm3().getCarotidEndarterectomyDone().name()
                            + "," + dcf1.getDataCollectionForm3().getThrombolysedDone().name()
                            + "," + dcf1.getDataCollectionForm3().getCtaDone().name()
                            + "," + dcf1.getDataCollectionForm3().getMraDone().name()
                            + "," + dcf1.getDataCollectionForm3().getAngiogramDone().name()

                            + "," + dcf1.getDataCollectionForm4().getIntracranialStenosis().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm4().getIntracranialStenosisPercent()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getIntracranialStenosisPercent())
                            + "," + dcf1.getDataCollectionForm4().getExtracranialDopplersImagingDone().name()
                            + "," + dcf1.getDataCollectionForm4().getExtracranialMraImagingDone().name()
                            + "," + dcf1.getDataCollectionForm4().getExtracranialCtaImagingDone().name()
                            + "," + dcf1.getDataCollectionForm4().getBrainCtImagingDone().name()
                            + "," + dcf1.getDataCollectionForm4().getBrainMriImagingDone().name()
                            + "," + dcf1.getDataCollectionForm4().getLesionAnterior().name()
                            + "," + dcf1.getDataCollectionForm4().getLesionRight().name()
                            + "," + dcf1.getDataCollectionForm4().getLesionLeft().name()
                            + "," + dcf1.getDataCollectionForm4().getLesionBilateral().name()
                            + "," + dcf1.getDataCollectionForm4().getLesionPosterior().name()
                            + "," + dcf1.getDataCollectionForm4().getLesionAnterioposterior().name()
                            + "," + (dcf1.getDataCollectionForm4().getRicaStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getRicaStenosisPercent().toString())
                            + "," + (dcf1.getDataCollectionForm4().getLicaStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getLicaStenosisPercent().toString())
                            + "," + (dcf1.getDataCollectionForm4().getRccaStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getRccaStenosisPercent().toString())
                            + "," + (dcf1.getDataCollectionForm4().getLccaStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getLccaStenosisPercent().toString())
                            + "," + (dcf1.getDataCollectionForm4().getrVertebralStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getrVertebralStenosisPercent().toString())
                            + "," + (dcf1.getDataCollectionForm4().getlVertebralStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getlVertebralStenosisPercent().toString())
                            + "," + (dcf1.getDataCollectionForm4().getBasilarStenosisPercent() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getBasilarStenosisPercent().toString())
                            + "," + dcf1.getDataCollectionForm4().getLvd().name()
                            + "," + dcf1.getDataCollectionForm4().getSvd().name()
                            + "," + dcf1.getDataCollectionForm4().getCardioembolism().name()
                            + "," + dcf1.getDataCollectionForm4().getCombined().name()
                            + "," + dcf1.getDataCollectionForm4().getStrokeOfDeterminedEtiology().name()
                            + "," + dcf1.getDataCollectionForm4().getNegativeEvaluation().name()
                            + "," + dcf1.getDataCollectionForm4().getEcgDone().name()
                            + "," + dcf1.getDataCollectionForm4().getEchoDone().name()
                            + "," + dcf1.getDataCollectionForm4().getEcgNormal().name()
                            + "," + dcf1.getDataCollectionForm4().getEchoLvh().name()
                            + "," + dcf1.getDataCollectionForm4().getEchoPfo().name()
                            + "," + dcf1.getDataCollectionForm4().getEchoThrombus().name()
                            + "," + dcf1.getDataCollectionForm4().getEchoNoneOfAbove().name()
                            + "," + dcf1.getDataCollectionForm4().getEchoDontKnow().name()
                            + "," + dcf1.getDataCollectionForm4().getEcgDontKnow().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm4().getNihssOnAdmission()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getNihssOnAdmission())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm4().getNihssOnDischarge()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getNihssOnDischarge())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm4().getBarthelOnAdmission()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getBarthelOnAdmission())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm4().getBarthelOnDischarge()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm4().getBarthelOnDischarge())
                            + "," + dcf1.getDataCollectionForm4().getHome().name()
                            + "," + dcf1.getDataCollectionForm4().getNursingHome().name()
                            + "," + dcf1.getDataCollectionForm4().getRehabilitation().name()
                            + "," + dcf1.getDataCollectionForm4().getRip().name()
                            + "," + dcf1.getDataCollectionForm4().getLocalDgh().name()

                            + "," + dcf1.getDataCollectionForm5().getAspirin().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getAspirinDosage()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getAspirinDosage())
                            + "," + dcf1.getDataCollectionForm5().getClopidogrel().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getClopidogrelDosage()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getClopidogrelDosage())
                            + "," + dcf1.getDataCollectionForm5().getAspirinPlusClopidogrel().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getAspirinPlusClopidogrelDosage()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getAspirinPlusClopidogrelDosage())
                            + "," + dcf1.getDataCollectionForm5().getDipyridamole().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getDipyridamoleDosage()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getDipyridamoleDosage())
                            + "," + dcf1.getDataCollectionForm5().getAspirinPlusDipyridamole().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getAspirinPlusDipyridamoleDosage()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getAspirinPlusDipyridamoleDosage())
                            + "," + dcf1.getDataCollectionForm5().getWarfarin().name()
                            + "," + dcf1.getDataCollectionForm5().getStatin().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getStatinDosage()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getStatinDosage())
                            + "," + dcf1.getDataCollectionForm5().getAntihypertensive().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpouseName()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpouseName())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpouseAddress()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpouseAddress())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpouseDateOfBirthString()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpouseDateOfBirthString())
                            + "," + dcf1.getDataCollectionForm5().getSpouseGender().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpouseLandlinePhoneNumber()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpouseLandlinePhoneNumber())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpouseCellPhoneNumber()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpouseCellPhoneNumber())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpouseFriendPhoneNumber()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpouseFriendPhoneNumber())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpousePlaceOfBirth()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpousePlaceOfBirth())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpouseEthnicity()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpouseEthnicity())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpouseNativeLanguage()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpouseNativeLanguage())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getSpouseReligion()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getSpouseReligion())
                            + "," + dcf1.getDataCollectionForm5().getSpouseHypertension().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseDiabetesMellitus().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseIhdAngina().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseHypercholesterolemia().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseAtrialFibrillation().name()
                            + "," + dcf1.getDataCollectionForm5().getSpousePvd().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseMi().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseMigraineWithAura().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseMigraineWithoutAura().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseIschaemicStroke().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseHoemorrhagicStroke().name()
                            + "," + dcf1.getDataCollectionForm5().getSpouseTia().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm5().getBpToday()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm5().getBpToday())

                            + "," + dcf6EcSb.toString()
                            + "," + (dcf1.getDataCollectionForm6().getHip() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm6().getHip().toString())
                            + "," + (dcf1.getDataCollectionForm6().getWaist() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm6().getHip().toString())
                            + "," + (dcf1.getDataCollectionForm6().getHeight() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm6().getHeight().toString())
                            + "," + (dcf1.getDataCollectionForm6().getWeight() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm6().getWeight().toString())
                            + "," + (dcf1.getDataCollectionForm6().getBmi() == 0.0 ? StringUtils.EMPTY : dcf1.getDataCollectionForm6().getBmi().toString())
                            + "," + dcf1.getDataCollectionForm6().getBloodSampleTaken().name()
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm6().getBloodSampleDateString()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm6().getBloodSampleDateString())
                            + "," + (StringUtils.isEmpty(dcf1.getDataCollectionForm6().getBloodSampleNumber()) ? StringUtils.EMPTY : dcf1.getDataCollectionForm6().getBloodSampleNumber()) + "\n");
                    dcf1EcSb.setLength(0);
                    dcf6EcSb.setLength(0);
                }
                writer.close();
                S3File s3File = new S3File();
                if(f != null){
                    s3File.name = "ExportExcel.csv";
                    s3File.file = f;
                    s3File.save();
                }
                try {
                    Mail mail = new Mail(er.getRecipient(), s3File.getUrl().toString());
                    ActorRef mailActor = Akka.system().actorOf(Props.create(MailSenderActor.class));
                    mailActor.tell(mail ,mailActor);
                } catch (Exception e) {
                    Logger.error(e.getMessage(), e);
                }
            }
        } catch (Exception e) {
            Logger.error(e.getMessage(), e);
        }
        getSender().tell(new ResponseMessage(200, "Download link for exported file has been sent to ", ResponseMessageType.SUCCESSFUL), getSelf());
    }
}