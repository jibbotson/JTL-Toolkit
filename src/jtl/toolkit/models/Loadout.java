package jtl.toolkit.models;

import java.util.ArrayList;
import java.util.UUID;

public class Loadout {
    
    private final UUID loadoutID;
    
    private String loadoutName;
    private Chassis chassis;
    
    private UUID reactorID;
    private UUID engineID;
    private UUID shieldID;
    private UUID armorFrontID;
    private UUID armorBackID;
    private UUID droidInterfaceID;
    private UUID capacitorID;
    private UUID boosterID;
    private UUID countermeasureID;
    private ArrayList<UUID> weaponIDs;
    private ArrayList<UUID> ordnanceIDs;
    
    public Loadout() {
        this.loadoutID = UUID.randomUUID();
        this.loadoutName = "";
        
        this.weaponIDs = new ArrayList<>();
        this.ordnanceIDs = new ArrayList<>();
        
        this.reactorID = null;
        this.engineID = null;
        this.shieldID = null;
        this.boosterID = null;
        this.capacitorID = null;
        this.shieldID = null;
        this.armorBackID = null;
        this.armorFrontID = null;
        this.countermeasureID = null;
        this.droidInterfaceID = null;
    }

    public UUID getLoadoutID() {
        return loadoutID;
    }

    public String getLoadoutName() {
        return loadoutName;
    }

    public void setLoadoutName(String loadoutName) {
        this.loadoutName = loadoutName;
    }

    public Chassis getChassis() {
        return chassis;
    }

    public void setChassis(Chassis chassis) {
        this.chassis = chassis;
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

    public UUID getArmorFrontID() {
        return armorFrontID;
    }

    public void setArmorFrontID(UUID armorFrontID) {
        this.armorFrontID = armorFrontID;
    }

    public UUID getArmorBackID() {
        return armorBackID;
    }

    public void setArmorBackID(UUID armorBackID) {
        this.armorBackID = armorBackID;
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

    public void setWeaponIDs(ArrayList<UUID> weaponIDs) {
        this.weaponIDs = weaponIDs;
    }

    public ArrayList<UUID> getOrdnanceIDs() {
        return ordnanceIDs;
    }

    public void setOrdnanceIDs(ArrayList<UUID> ordnanceIDs) {
        this.ordnanceIDs = ordnanceIDs;
    }
    
    
    
}
