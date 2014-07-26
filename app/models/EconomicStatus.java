package models;

/**
 * Created by Sagar Gopale on 6/22/14.
 */
public enum EconomicStatus {
    BED ("Bed"),
    ELECTRICITY("Electricity"),
    TABLE("Table"),
    TOILET("Toilet"),
    ROOFED_HOUSE("Roofed House"),
    WATER_FILTER("Water Filter"),
    FAN("Fan"),
    COOLER("Cooler"),
    COOKING_GAS("Cooking Gas"),
    TV("TV"),
    PHONE("Phone"),
    SCOOTER("Scooter"),
    SOFA_SET("Sofa Set"),
    CURTAIN_IN_WINDOWS("Curtain In Windows"),
    REFRIGERATOR("Refrigerator"),
    MIXER_GRINDER("Mixer Grinder"),
    DINING_TABLE("Dining Table"),
    TOASTER("Toaster"),
    AQUAGUARD("Aquaguard"),
    MICROWAVE_OVEN("Microwave Oven"),
    COMPUTER("Computer"),
    GEYSER("Geyser"),
    RO_WATER_PURIFIER_SYSTEM("RO Water Purifier System"),
    CAR("Car"),
    AC("AC");

    private String displayName;

    EconomicStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() { return displayName; }
}
