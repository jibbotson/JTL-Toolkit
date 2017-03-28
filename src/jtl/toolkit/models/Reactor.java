package jtl.toolkit.models;

import java.util.UUID;

public class Reactor {
    
    private final UUID componentID;
    private Integer level;
    private Double armor;
    private Double hitpoints;
    private Double mass;
    private Double generationRate;
    private String componentNotes;
    private String componentName;
    
    public Reactor() {
        this.componentID = UUID.randomUUID();
    }
   
    public Reactor(Integer newLevel, 
                  Double newArmor, 
                  Double newHitpoints, 
                  Double newMass, 
                  Double newGenerationRate,
                  String newComponentNotes,
                  String newComponentName){
        
        this.componentID = UUID.randomUUID();
        this.level = newLevel;
        this.armor = newArmor;
        this.hitpoints = newHitpoints;
        this.mass = newMass;
        this.generationRate = newGenerationRate;
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

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getGenerationRate() {
        return generationRate;
    }

    public void setGenerationRate(Double generationRate) {
        this.generationRate = generationRate;
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
