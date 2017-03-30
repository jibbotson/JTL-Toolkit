package jtl.toolkit.models;

import java.util.ArrayList;
import java.util.UUID;

public class Loadout {
    
    private final UUID loadoutID;
    
    private final String loadoutName;
    private final String chassisName;
    private final Double mass;
    private final Double accelerationModifier;
    private final Double decelerationModifier;
    private final Double yawRateModifier;
    private final Double pitchRateModifier;
    private final Double rollRateModifier;
    private final Double speedModifier;
    
    private final Integer weaponMounts;
    private final Integer ordnanceMounts;
    
    private UUID reactorID;
    private UUID engineID;
    private UUID shieldID;
    private UUID armorOneID;
    private UUID armorTwoID;
    private UUID droidInterfaceID;
    private UUID capacitorID;
    private UUID boosterID;
    private UUID countermeasureID;
    private ArrayList<UUID> weaponIDs;
    private ArrayList<UUID> ordnanceIDs;

    public Loadout(UUID loadoutID, String loadoutName, String chassisName, Double mass, Double accelerationModifier, Double decelerationModifier, Double yawRateModifier, Double pitchRateModifier, Double rollRateModifier, Double speedModifier, Integer weaponMounts, Integer ordnanceMounts) {
        this.loadoutID = loadoutID;
        this.loadoutName = loadoutName;
        this.chassisName = chassisName;
        this.mass = mass;
        this.accelerationModifier = accelerationModifier;
        this.decelerationModifier = decelerationModifier;
        this.yawRateModifier = yawRateModifier;
        this.pitchRateModifier = pitchRateModifier;
        this.rollRateModifier = rollRateModifier;
        this.speedModifier = speedModifier;
        this.weaponMounts = weaponMounts;
        this.ordnanceMounts = ordnanceMounts;
    }

    public UUID getLoadoutID() {
        return loadoutID;
    }

    public String getLoadoutName() {
        return loadoutName;
    }

    public String getChassisName() {
        return chassisName;
    }

    public Double getMass() {
        return mass;
    }

    public Double getAccelerationModifier() {
        return accelerationModifier;
    }

    public Double getDecelerationModifier() {
        return decelerationModifier;
    }

    public Double getYawRateModifier() {
        return yawRateModifier;
    }

    public Double getPitchRateModifier() {
        return pitchRateModifier;
    }

    public Double getRollRateModifier() {
        return rollRateModifier;
    }

    public Double getSpeedModifier() {
        return speedModifier;
    }

    public Integer getWeaponMounts() {
        return weaponMounts;
    }

    public Integer getOrdnanceMounts() {
        return ordnanceMounts;
    }

    public UUID getReactorID() {
        return reactorID;
    }

    public void setReactorID(UUID reactorID) {
        this.reactorID = reactorID;
    }

    public UUID getEngineID() {
        return engineID;
    }

    public void setEngineID(UUID engineID) {
        this.engineID = engineID;
    }

    public UUID getShieldID() {
        return shieldID;
    }

    public void setShieldID(UUID shieldID) {
        this.shieldID = shieldID;
    }

    public UUID getArmorOneID() {
        return armorOneID;
    }

    public void setArmorOneID(UUID armorOneID) {
        this.armorOneID = armorOneID;
    }

    public UUID getArmorTwoID() {
        return armorTwoID;
    }

    public void setArmorTwoID(UUID armorTwoID) {
        this.armorTwoID = armorTwoID;
    }

    public UUID getDroidInterfaceID() {
        return droidInterfaceID;
    }

    public void setDroidInterfaceID(UUID droidInterfaceID) {
        this.droidInterfaceID = droidInterfaceID;
    }

    public UUID getCapacitorID() {
        return capacitorID;
    }

    public void setCapacitorID(UUID capacitorID) {
        this.capacitorID = capacitorID;
    }

    public UUID getBoosterID() {
        return boosterID;
    }

    public void setBoosterID(UUID boosterID) {
        this.boosterID = boosterID;
    }

    public UUID getCountermeasureID() {
        return countermeasureID;
    }

    public void setCountermeasureID(UUID countermeasureID) {
        this.countermeasureID = countermeasureID;
    }

    public ArrayList<UUID> getWeaponIDs() {
        return weaponIDs;
    }

    public void setWeaponsID(ArrayList<UUID> weaponsID) {
        this.weaponIDs = weaponsID;
    }

    public ArrayList<UUID> getOrdnanceIDs() {
        return ordnanceIDs;
    }

    public void setOrdnanceID(ArrayList<UUID> ordnanceID) {
        this.ordnanceIDs = ordnanceID;
    }
}
