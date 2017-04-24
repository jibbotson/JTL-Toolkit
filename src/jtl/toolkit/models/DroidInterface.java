package jtl.toolkit.models;

import java.util.UUID;

public class DroidInterface {
    
    private final UUID componentID;
    private Integer level;
    private Double armor;
    private Double hitpoints;
    private Double energyDrain;
    private Double mass;
    private Double commandSpeed;
    private String componentNotes;
    private String componentName;
    
    public DroidInterface() {
        this.componentID = UUID.randomUUID();
    }    
   
    public DroidInterface(Integer newLevel, 
                    Double newArmor, 
                    Double newHitpoints, 
                    Double newReactorDrain, 
                    Double newMass, 
                    Double newCommandSpeed,
                    String newComponentNotes,
                    String newComponentName){
        
        this.componentID = UUID.randomUUID();
        this.level = newLevel;
        this.armor = newArmor;
        this.hitpoints = newHitpoints;
        this.energyDrain = newReactorDrain;
        this.mass = newMass;
        this.commandSpeed = newCommandSpeed;
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

    public Double getCommandSpeed() {
        return commandSpeed;
    }

    public void setCommandSpeed(Double commandSpeed) {
        this.commandSpeed = commandSpeed;
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
