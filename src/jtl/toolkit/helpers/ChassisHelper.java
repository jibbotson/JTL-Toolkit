package jtl.toolkit.helpers;

import java.util.ArrayList;
import jtl.toolkit.models.Chassis;

public class ChassisHelper {
    
    ArrayList<Chassis> chassis;
    
    public ChassisHelper() {
        chassis = new ArrayList<>();
        chassis.add(getVaksai());
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
