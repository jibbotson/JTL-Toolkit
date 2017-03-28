package jtl.toolkit.models;

import java.util.UUID;

public class Countermeasure {
    
    private final UUID componentID;
    private Integer level;
    private Double armor;
    private Double hitpoints;
    private Double energyDrain;
    private Double mass;
    private Double minimumChance;
    private Double maximumChance;
    private Double refireRate;
    private String componentNotes;
    private String componentName;
    
    public Countermeasure() {
        this.componentID = UUID.randomUUID();
    }
   
    public Countermeasure(Integer newLevel, 
                    Double newArmor, 
                    Double newHitpoints, 
                    Double newEnergyDrain, 
                    Double newMass, 
                    Double newMinimumChance, 
                    Double newMaximumChance, 
                    Double newRefireRate,
                    String newComponentNotes,
                    String newComponentName){
        
        this.componentID = UUID.randomUUID();
        this.level = newLevel;
        this.armor = newArmor;
        this.hitpoints = newHitpoints;
        this.energyDrain = newEnergyDrain;
        this.mass = newMass;
        this.minimumChance = newMinimumChance;
        this.maximumChance = newMaximumChance;
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

    public Double getEnergyDrain() {
        return energyDrain;
    }

    public void setEnergyDrain(Double energyDrain) {
        this.energyDrain = energyDrain;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getMinimumChance() {
        return minimumChance;
    }

    public void setMinimumChance(Double minimumChance) {
        this.minimumChance = minimumChance;
    }

    public Double getMaximumChance() {
        return maximumChance;
    }

    public void setMaximumChance(Double maximumChance) {
        this.maximumChance = maximumChance;
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
