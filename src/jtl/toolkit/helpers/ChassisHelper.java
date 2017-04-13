package jtl.toolkit.helpers;

import java.util.ArrayList;
import jtl.toolkit.models.Chassis;

public class ChassisHelper {
    
    ArrayList<Chassis> chassis;
    
    public ChassisHelper() {
        chassis = new ArrayList<>();
        chassis.add(getVaksai());
        chassis.add(getBWing());
    }
    
    private Chassis getBWing() {
        Chassis BWing = new Chassis();
        
        BWing.setChassisShortName("B-Wing");
        BWing.setChassisLongName("B-Wing");
        BWing.setMass(0.00);
        BWing.setMaximumMass(245000.00);
        BWing.setAccelerationModifier(300.00);
        BWing.setDecelerationModifier(350.00);
        BWing.setYawRateModifier(75.00);
        BWing.setPitchRateModifier(75.00);
        BWing.setRollRateModifier(50.00);
        BWing.setSpeedModifier(0.90);
        BWing.setWeaponMounts(4);
        BWing.setOrdnanceMounts(2);
        
        return BWing;
    }

    private Chassis getVaksai() {
        Chassis vaksai = new Chassis();
        
        vaksai.setChassisShortName("Vaksai");
        vaksai.setChassisLongName("Vaksai Starfighter");
        vaksai.setMass(150000.00);
        vaksai.setMaximumMass(150000.00);
        vaksai.setAccelerationModifier(350.00);
        vaksai.setDecelerationModifier(350.00);
        vaksai.setYawRateModifier(400.00);
        vaksai.setPitchRateModifier(400.00);
        vaksai.setRollRateModifier(200.00);
        vaksai.setSpeedModifier(1.0);
        vaksai.setWeaponMounts(1);
        vaksai.setOrdnanceMounts(1);
        
        return vaksai;
    }
    
    
    public ArrayList<Chassis> getChassis() {
        return chassis;
    }
}
