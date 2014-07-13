package models.response.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 6/22/14
 * Time: 12:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class EconomicStatus {

    List<models.EconomicStatus> checkedEconomicStatuses = new ArrayList<models.EconomicStatus>();
    List<models.EconomicStatus> uncheckedEconomicStatuses = new ArrayList<models.EconomicStatus>();
    public int Bed = 0;
    public int Electricity = 0;
    public int Table = 0;
    public int Toilet = 0;
    public int  RoofedHouse = 0;
    public int  WaterFilter = 0;
    public int  Fan = 0;
    public int Cooler = 0;
    public int CookingGas = 0;
    public int TV = 0;
    public int Phone = 0;
    public int Scooter = 0;
    public int SofaSet = 0;
    public int CurtainInWindows = 0;
    public int Refrigerator = 0;
    public int MixerGrinder = 0;
    public int DiningTable = 0;
    public int Toaster = 0;
    public int Aquaguard = 0;
    public int MicrowaveOven = 0;
    public int Computer = 0;
    public int Geyser = 0;
    public int RO = 0;
    public int Car = 0;
    public int AC = 0;

    public EconomicStatus() {
    }

    public int getBed() {
        return Bed;
    }

    public void setBed(int bed) {
        Bed = bed;
    }

    public int getElectricity() {
        return Electricity;
    }

    public void setElectricity(int electricity) {
        Electricity = electricity;
    }

    public int getTable() {
        return Table;
    }

    public void setTable(int table) {
        Table = table;
    }

    public int getToilet() {
        return Toilet;
    }

    public void setToilet(int toilet) {
        Toilet = toilet;
    }

    public int getRoofedHouse() {
        return RoofedHouse;
    }

    public void setRoofedHouse(int roofedHouse) {
        RoofedHouse = roofedHouse;
    }

    public int getWaterFilter() {
        return WaterFilter;
    }

    public void setWaterFilter(int waterFilter) {
        WaterFilter = waterFilter;
    }

    public int getFan() {
        return Fan;
    }

    public void setFan(int fan) {
        Fan = fan;
    }

    public int getCooler() {
        return Cooler;
    }

    public void setCooler(int cooler) {
        Cooler = cooler;
    }

    public int getCookingGas() {
        return CookingGas;
    }

    public void setCookingGas(int cookingGas) {
        CookingGas = cookingGas;
    }

    public int getTV() {
        return TV;
    }

    public void setTV(int TV) {
        this.TV = TV;
    }

    public int getPhone() {
        return Phone;
    }

    public void setPhone(int phone) {
        Phone = phone;
    }

    public int getScooter() {
        return Scooter;
    }

    public void setScooter(int scooter) {
        Scooter = scooter;
    }

    public int getSofaSet() {
        return SofaSet;
    }

    public void setSofaSet(int sofaSet) {
        SofaSet = sofaSet;
    }

    public int getCurtainInWindows() {
        return CurtainInWindows;
    }

    public void setCurtainInWindows(int curtainInWindows) {
        CurtainInWindows = curtainInWindows;
    }

    public int getRefrigerator() {
        return Refrigerator;
    }

    public void setRefrigerator(int refrigerator) {
        Refrigerator = refrigerator;
    }

    public int getMixerGrinder() {
        return MixerGrinder;
    }

    public void setMixerGrinder(int mixerGrinder) {
        MixerGrinder = mixerGrinder;
    }

    public int getDiningTable() {
        return DiningTable;
    }

    public void setDiningTable(int diningTable) {
        DiningTable = diningTable;
    }

    public int getToaster() {
        return Toaster;
    }

    public void setToaster(int toaster) {
        Toaster = toaster;
    }

    public int getAquaguard() {
        return Aquaguard;
    }

    public void setAquaguard(int aquaguard) {
        Aquaguard = aquaguard;
    }

    public int getMicrowaveOven() {
        return MicrowaveOven;
    }

    public void setMicrowaveOven(int microwaveOven) {
        MicrowaveOven = microwaveOven;
    }

    public int getComputer() {
        return Computer;
    }

    public void setComputer(int computer) {
        Computer = computer;
    }

    public int getGeyser() {
        return Geyser;
    }

    public void setGeyser(int geyser) {
        Geyser = geyser;
    }

    public int getRO() {
        return RO;
    }

    public void setRO(int RO) {
        this.RO = RO;
    }

    public int getCar() {
        return Car;
    }

    public void setCar(int car) {
        Car = car;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public List<models.EconomicStatus> getCheckedEconomicStatuses() {
        return checkedEconomicStatuses;
    }

    public void setCheckedEconomicStatuses(List<models.EconomicStatus> checkedEconomicStatuses) {
        this.checkedEconomicStatuses = checkedEconomicStatuses;
    }

    public List<models.EconomicStatus> getUncheckedEconomicStatuses() {
        return uncheckedEconomicStatuses;
    }

    public void setUncheckedEconomicStatuses(List<models.EconomicStatus> uncheckedEconomicStatuses) {
        this.uncheckedEconomicStatuses = uncheckedEconomicStatuses;
    }
}
