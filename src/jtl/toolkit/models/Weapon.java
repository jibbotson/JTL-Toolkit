package jtl.toolkit.models;

import java.util.UUID;

public class Weapon {
    
    private final UUID componentID;
    private Integer level;
    private Double armor;
    private Double hitpoints;
    private Double energyDrain;
    private Double mass;
    private Double minimumDamage;
    private Double maximumDamage;
    private Double versusShields;
    private Double versusArmor;
    private Double energyPerShot;
    private Double refireRate;
    private String componentNotes;
    private String componentName;

    public Weapon() {
        this.componentID = UUID.randomUUID();
    }
    
    public Weapon(Integer newLevel, 
                  Double newArmor, 
                  Double newHitpoints, 
                  Double newReactorDrain, 
                  Double newMass, 
                  Double newMinimumDamage, 
                  Double newMaximumDamage, 
                  Double newVersusShields, 
                  Double newVersusArmor,
                  Double newEnergyPerShot,
                  Double newRefireRate,
                  String newComponentNotes,
                  String newComponentName){
        
        this.componentID = UUID.randomUUID();
        this.level = newLevel;
        this.armor = newArmor;
        this.hitpoints = newHitpoints;
        this.energyDrain = newReactorDrain;
        this.mass = newMass;
        this.minimumDamage = newMinimumDamage;
        this.maximumDamage = newMaximumDamage;
        this.versusShields = newVersusShields;
        this.versusArmor = newVersusArmor;
        this.energyPerShot = newEnergyPerShot;
        this.refireRate = newRefireRate;
        this.componentNotes = newComponentNotes;
        this.componentName = newComponentName;
    }

    public UUID getComponentID() {
        return componentID;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Double getArmor() {
        return armor;
    }

    public void setArmor(Double armor) {
        this.armor = armor;
    }

    public Double getHitpoints() {
        return hitpoints;
    }

    public void setHitpoints(Double hitpoints) {
        this.hitpoints = hitpoints;
    }

    public Double getReactorDrain() {
        return energyDrain;
    }

    public void setReactorDrain(Double energyDrain) {
        this.energyDrain = energyDrain;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getMinimumDamage() {
        return minimumDamage;
    }

    public void setMinimumDamage(Double minimumDamage) {
        this.minimumDamage = minimumDamage;
    }

    public Double getMaximumDamage() {
        return maximumDamage;
    }

    public void setMaximumDamage(Double maximumDamage) {
        this.maximumDamage = maximumDamage;
    }

    public Double getVersusShields() {
        return versusShields;
    }

    public void setVersusShields(Double versusShields) {
        this.versusShields = versusShields;
    }

    public Double getVersusArmor() {
        return versusArmor;
    }

    public void setVersusArmor(Double versusArmor) {
        this.versusArmor = versusArmor;
    }

    public Double getEnergyPerShot() {
        return energyPerShot;
    }

    public void setEnergyPerShot(Double energyPerShot) {
        this.energyPerShot = energyPerShot;
    }
    
    public Double getRefireRate() {
        return refireRate;
    }

    public void setRefireRate(Double refireRate) {
        this.refireRate = refireRate;
    }
    
    public String getComponentNotes() {
        return componentNotes;
    }

    public void setComponentNotes(String componentNotes) {
        this.componentNotes = componentNotes;
    }
    
    public String getComponentName() {
        return componentName;
    }

    public void setComponentName(String componentName) {
        this.componentName = componentName;
    }
}
