package jtl.toolkit.models;

public class Chassis {
    
    private String chassisLongName;
    private String chassisShortName;
    private Double mass;
    private Double maximumMass;
    private Double accelerationModifier;
    private Double decelerationModifier;
    private Double yawRateModifier;
    private Double pitchRateModifier;
    private Double rollRateModifier;
    private Double speedModifier;
    private Integer weaponMounts;
    private Integer ordnanceMounts;

    public Chassis() {
        chassisLongName = null;
        chassisShortName = null;
        mass = null;
        maximumMass = null;
        accelerationModifier = null;
        decelerationModifier = null;
        yawRateModifier = null;
        pitchRateModifier = null;
        rollRateModifier = null;
        speedModifier = null;
        weaponMounts = null;
        ordnanceMounts = null;
    }

    public String getChassisLongName() {
        return chassisLongName;
    }

    public void setChassisLongName(String chassisLongName) {
        this.chassisLongName = chassisLongName;
    }

    public String getChassisShortName() {
        return chassisShortName;
    }

    public void setChassisShortName(String chassisShortName) {
        this.chassisShortName = chassisShortName;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getMaximumMass() {
        return maximumMass;
    }

    public void setMaximumMass(Double maximumMass) {
        this.maximumMass = maximumMass;
    }

    public Double getAccelerationModifier() {
        return accelerationModifier;
    }

    public void setAccelerationModifier(Double accelerationModifier) {
        this.accelerationModifier = accelerationModifier;
    }

    public Double getDecelerationModifier() {
        return decelerationModifier;
    }

    public void setDecelerationModifier(Double decelerationModifier) {
        this.decelerationModifier = decelerationModifier;
    }

    public Double getYawRateModifier() {
        return yawRateModifier;
    }

    public void setYawRateModifier(Double yawRateModifier) {
        this.yawRateModifier = yawRateModifier;
    }

    public Double getPitchRateModifier() {
        return pitchRateModifier;
    }

    public void setPitchRateModifier(Double pitchRateModifier) {
        this.pitchRateModifier = pitchRateModifier;
    }

    public Double getRollRateModifier() {
        return rollRateModifier;
    }

    public void setRollRateModifier(Double rollRateModifier) {
        this.rollRateModifier = rollRateModifier;
    }

    public Double getSpeedModifier() {
        return speedModifier;
    }

    public void setSpeedModifier(Double speedModifier) {
        this.speedModifier = speedModifier;
    }

    public Integer getWeaponMounts() {
        return weaponMounts;
    }

    public void setWeaponMounts(Integer weaponMounts) {
        this.weaponMounts = weaponMounts;
    }

    public Integer getOrdnanceMounts() {
        return ordnanceMounts;
    }

    public void setOrdnanceMounts(Integer ordnanceMounts) {
        this.ordnanceMounts = ordnanceMounts;
    }
    
}
