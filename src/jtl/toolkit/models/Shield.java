package jtl.toolkit.models;

import java.util.UUID;

public class Shield {
    
    private final UUID componentID;
    private Integer level;
    private Double armor;
    private Double hitpoints;
    private Double energyDrain;
    private Double mass;
    private Double frontHitpoints;
    private Double backHitpoints;
    private Double rechargeRate;
    private String componentNotes;
    private String componentName;
    
    public Shield() {
        this.componentID = UUID.randomUUID();
    }
   
    public Shield(Integer newLevel, 
                  Double newArmor, 
                  Double newHitpoints, 
                  Double newReactorDrain, 
                  Double newMass, 
                  Double newFrontHitpoints, 
                  Double newBackHitpoints, 
                  Double newRechargeRate,
                  String newComponentNotes,
                  String newComponentName){
        
        this.componentID = UUID.randomUUID();
        this.level = newLevel;
        this.armor = newArmor;
        this.hitpoints = newHitpoints;
        this.energyDrain = newReactorDrain;
        this.mass = newMass;
        this.frontHitpoints = newFrontHitpoints;
        this.backHitpoints = newBackHitpoints;
        this.rechargeRate = newRechargeRate;
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

    public Double getFrontHitpoints() {
        return frontHitpoints;
    }

    public void setFrontHitpoints(Double frontHitpoints) {
        this.frontHitpoints = frontHitpoints;
    }

    public Double getRearHitpoints() {
        return backHitpoints;
    }

    public void setBackHitpoints(Double backHitpoints) {
        this.backHitpoints = backHitpoints;
    }

    public Double getRechargeRate() {
        return rechargeRate;
    }

    public void setRechargeRate(Double rechargeRate) {
        this.rechargeRate = rechargeRate;
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
