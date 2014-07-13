package models.utils;

import models.response.data.EconomicStatus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sagar Gopale on 6/22/14.
 */
public class EconomicStatusUtil {

    public static EconomicStatus getEconomicStatus(List<models.data.form.EconomicStatus> eList) {
        EconomicStatus es = null;
        ArrayList<models.EconomicStatus> checkedEconomicStatuses = new ArrayList<models.EconomicStatus>();
        ArrayList<models.EconomicStatus> uncheckedEconomicStatuses = new ArrayList<models.EconomicStatus>();
        for(models.data.form.EconomicStatus e: eList) {
            es = new EconomicStatus();
            models.EconomicStatus economicStatus = models.EconomicStatus.valueOf(e.getName().toUpperCase().trim().replace(" ", "_"));
            switch(economicStatus) {
                case BED:
                    checkedEconomicStatuses.add(models.EconomicStatus.BED);
                    es.setBed(models.EconomicStatus.BED.ordinal());
                    break;
                case ELECTRICITY:
                    checkedEconomicStatuses.add(models.EconomicStatus.ELECTRICITY);
                    es.setElectricity(models.EconomicStatus.ELECTRICITY.ordinal());
                    break;
                case TABLE:
                    checkedEconomicStatuses.add(models.EconomicStatus.TABLE);
                    es.setTable(models.EconomicStatus.TABLE.ordinal());
                    break;
                case TOILET:
                    checkedEconomicStatuses.add(models.EconomicStatus.TOILET);
                    es.setToilet(models.EconomicStatus.TOILET.ordinal());
                    break;
                case ROOFED_HOUSE:
                    checkedEconomicStatuses.add(models.EconomicStatus.ROOFED_HOUSE);
                    es.setRoofedHouse(models.EconomicStatus.ROOFED_HOUSE.ordinal());
                    break;
                case WATER_FILTER:
                    checkedEconomicStatuses.add(models.EconomicStatus.WATER_FILTER);
                    es.setWaterFilter(models.EconomicStatus.WATER_FILTER.ordinal());
                    break;
                case FAN:
                    checkedEconomicStatuses.add(models.EconomicStatus.FAN);
                    es.setFan(models.EconomicStatus.FAN.ordinal());
                    break;
                case COOLER:
                    checkedEconomicStatuses.add(models.EconomicStatus.COOLER);
                    es.setCooler(models.EconomicStatus.COOLER.ordinal());
                    break;
                case COOKING_GAS:
                    checkedEconomicStatuses.add(models.EconomicStatus.COOKING_GAS);
                    es.setCookingGas(models.EconomicStatus.COOKING_GAS.ordinal());
                    break;
                case TV:
                    checkedEconomicStatuses.add(models.EconomicStatus.TV);
                    es.setTV(models.EconomicStatus.TV.ordinal());
                    break;
                case PHONE:
                    checkedEconomicStatuses.add(models.EconomicStatus.PHONE);
                    es.setPhone(models.EconomicStatus.PHONE.ordinal());
                    break;
                case SCOOTER:
                    checkedEconomicStatuses.add(models.EconomicStatus.SCOOTER);
                    es.setScooter(models.EconomicStatus.SCOOTER.ordinal());
                    break;
                case SOFA_SET:
                    checkedEconomicStatuses.add(models.EconomicStatus.SOFA_SET);
                    es.setSofaSet(models.EconomicStatus.SOFA_SET.ordinal());
                    break;
                case CURTAIN_IN_WINDOWS:
                    checkedEconomicStatuses.add(models.EconomicStatus.CURTAIN_IN_WINDOWS);
                    es.setCurtainInWindows(models.EconomicStatus.CURTAIN_IN_WINDOWS.ordinal());
                    break;
                case REFRIGERATOR:
                    checkedEconomicStatuses.add(models.EconomicStatus.REFRIGERATOR);
                    es.setRefrigerator(models.EconomicStatus.REFRIGERATOR.ordinal());
                    break;
                case MIXER_GRINDER:
                    checkedEconomicStatuses.add(models.EconomicStatus.MIXER_GRINDER);
                    es.setMixerGrinder(models.EconomicStatus.MIXER_GRINDER.ordinal());
                    break;
                case DINING_TABLE:
                    checkedEconomicStatuses.add(models.EconomicStatus.DINING_TABLE);
                    es.setDiningTable(models.EconomicStatus.DINING_TABLE.ordinal());
                    break;
                case TOASTER:
                    checkedEconomicStatuses.add(models.EconomicStatus.TOASTER);
                    es.setToaster(models.EconomicStatus.TOASTER.ordinal());
                    break;
                case AQUAGUARD:
                    checkedEconomicStatuses.add(models.EconomicStatus.AQUAGUARD);
                    es.setAquaguard(models.EconomicStatus.AQUAGUARD.ordinal());
                    break;
                case MICROWAVE_OVEN:
                    checkedEconomicStatuses.add(models.EconomicStatus.MICROWAVE_OVEN);
                    es.setMicrowaveOven(models.EconomicStatus.MICROWAVE_OVEN.ordinal());
                    break;
                case COMPUTER:
                    checkedEconomicStatuses.add(models.EconomicStatus.COMPUTER);
                    es.setComputer(models.EconomicStatus.COMPUTER.ordinal());
                    break;
                case GEYSER:
                    checkedEconomicStatuses.add(models.EconomicStatus.GEYSER);
                    es.setGeyser(models.EconomicStatus.GEYSER.ordinal());
                    break;
                case RO_WATER_PURIFIER_SYSTEM:
                    checkedEconomicStatuses.add(models.EconomicStatus.RO_WATER_PURIFIER_SYSTEM);
                    es.setRO(models.EconomicStatus.RO_WATER_PURIFIER_SYSTEM.ordinal());
                    break;
                case CAR:
                    checkedEconomicStatuses.add(models.EconomicStatus.CAR);
                    es.setCar(models.EconomicStatus.CAR.ordinal());
                    break;
                case AC:
                    checkedEconomicStatuses.add(models.EconomicStatus.AC);
                    es.setAC(models.EconomicStatus.AC.ordinal());
                    break;
            }
            es.setCheckedEconomicStatuses(checkedEconomicStatuses);
        }
        for(models.EconomicStatus economicStatus: models.EconomicStatus.values()) {
            if(es != null && !es.getCheckedEconomicStatuses().contains(economicStatus)) {
                uncheckedEconomicStatuses.add(economicStatus);
            }
        }
        if(es != null)
            es.setUncheckedEconomicStatuses(uncheckedEconomicStatuses);
        return es;
    }
}
