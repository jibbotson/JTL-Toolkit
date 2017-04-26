package jtl.toolkit.models;

import java.util.UUID;

public class Engine {
    
    private final UUID componentID;
    private Integer level;
    private Double armor;
    private Double hitpoints;
    private Double reactorDrain;
    private Double mass;
    private Double pitchRate;
    private Double yawRate;
    private Double rollRate;
    private Double topSpeed;
    private String componentNotes;
    private String componentName;
    
    public Engine() {
        this.componentID = UUID.randomUUID();
    }
   
    public Engine(Integer newLevel, 
                  Double newArmor, 
                  Double newHitpoints, 
                  Double newReactorDrain, 
                  Double newMass, 
                  Double newPitchRate,
                  Double newYawRate,
                  Double newTopSpeed,
                  String newComponentNotes,
                  String newComponentName){
        
        this.componentID = UUID.randomUUID();
        this.level = newLevel;
        this.armor = newArmor;
        this.hitpoints = newHitpoints;
        this.reactorDrain = newReactorDrain;
        this.mass = newMass;
        this.pitchRate = newPitchRate;
        this.yawRate = newYawRate;
        this.topSpeed = newTopSpeed;
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
        return reactorDrain;
    }

    public void setReactorDrain(Double reactorDrain) {
        this.reactorDrain = reactorDrain;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getPitchRate() {
        return pitchRate;
    }

    public void setPitchRate(Double pitchRate) {
        this.pitchRate = pitchRate;
    }

    public Double getYawRate() {
        return yawRate;
    }

    public void setYawRate(Double yawRate) {
        this.yawRate = yawRate;
    }

    public Double getRollRate() {
        return rollRate;
    }

    public void setRollRate(Double rollRate) {
        this.rollRate = rollRate;
    }

    public Double getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(Double topSpeed) {
        this.topSpeed = topSpeed;
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
