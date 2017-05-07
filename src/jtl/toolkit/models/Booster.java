package jtl.toolkit.models;

import java.util.UUID;

public class Booster {
    
    private final UUID componentID;
    private Integer level;
    private Double armor;
    private Double hitpoints;
    private Double energyDrain;
    private Double mass;
    private Double energy;
    private Double rechargeRate;
    private Double consumptionRate;
    private Double accelerationRate;
    private Double topSpeed;
    private String componentNotes;
    private String componentName;
    
    public Booster() {
        this.componentID = UUID.randomUUID();
    }
   
    public Booster(Integer newLevel, 
                   Double newArmor, 
                   Double newHitpoints, 
                   Double newReactorDrain, 
                   Double newMass, 
                   Double newEnergy, 
                   Double newRechargeRate, 
                   Double newConsumptionRate, 
                   Double newAccelerationRate,
                   Double newTopSpeed,
                   String newComponentNotes,
                   String newComponentName){
        
        this.componentID = UUID.randomUUID();
        this.level = newLevel;
        this.armor = newArmor;
        this.hitpoints = newHitpoints;
        this.energyDrain = newReactorDrain;
        this.mass = newMass;
        this.energy = newEnergy;
        this.rechargeRate = newRechargeRate;
        this.consumptionRate = newConsumptionRate;
        this.accelerationRate = newAccelerationRate;
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

    public Double getEnergy() {
        return energy;
    }

    public void setEnergy(Double energy) {
        this.energy = energy;
    }

    public Double getRechargeRate() {
        return rechargeRate;
    }

    public void setRechargeRate(Double rechargeRate) {
        this.rechargeRate = rechargeRate;
    }

    public Double getConsumptionRate() {
        return consumptionRate;
    }

    public void setConsumptionRate(Double consumptionRate) {
        this.consumptionRate = consumptionRate;
    }
    
    public Double getAccelerationRate() {
        return accelerationRate;
    }

    public void setAccelerationRate(Double accelerationRate) {
        this.accelerationRate = accelerationRate;
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
