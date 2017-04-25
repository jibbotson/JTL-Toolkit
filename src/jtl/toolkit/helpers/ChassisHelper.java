package jtl.toolkit.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import jtl.toolkit.models.Chassis;

public class ChassisHelper {
    
    ArrayList<Chassis> chassis;
    
    public ChassisHelper() {
        chassis = new ArrayList<>();
        chassis.add(getVaksai());
        chassis.add(getBWing());
        chassis.add(getZ95());
        chassis.add(getYWing());
        chassis.add(getXWing());
        chassis.add(getAdvancedXWing());
        chassis.add(getAWing());
        chassis.add(getSyck());
        chassis.add(getN1());
        chassis.add(getDunelizard());
        chassis.add(getKimogila());
        chassis.add(getKihraxz());
        chassis.add(getIxiyen());
        chassis.add(getRihkxyrk());
        chassis.add(getKrayt());
    }
    
    private Chassis getBWing() {
        Chassis BWing = new Chassis();
        
        BWing.setChassisShortName("B-Wing");
        BWing.setChassisLongName("B-Wing");
        BWing.setMass(0.0);
        BWing.setMaximumMass(245000.0);
        BWing.setAccelerationModifier(300.0);
        BWing.setDecelerationModifier(350.0);
        BWing.setYawRateModifier(75.0);
        BWing.setPitchRateModifier(75.0);
        BWing.setRollRateModifier(50.0);
        BWing.setSpeedModifier(0.90);
        BWing.setWeaponMounts(4);
        BWing.setOrdnanceMounts(2);
        
        return BWing;
    }

    private Chassis getVaksai() {
        Chassis vaksai = new Chassis();
        
        vaksai.setChassisShortName("Vaksai");
        vaksai.setChassisLongName("Vaksai Starfighter");
        vaksai.setMass(150000.0);
        vaksai.setMaximumMass(150000.0);
        vaksai.setAccelerationModifier(350.0);
        vaksai.setDecelerationModifier(350.0);
        vaksai.setYawRateModifier(400.0);
        vaksai.setPitchRateModifier(400.0);
        vaksai.setRollRateModifier(200.0);
        vaksai.setSpeedModifier(1.0);
        vaksai.setWeaponMounts(1);
        vaksai.setOrdnanceMounts(1);
        
        return vaksai;
    }
    
    private Chassis getZ95() {
        Chassis z95 = new Chassis();
        
        z95.setChassisShortName("Z-95");
        z95.setChassisLongName("Z-95 Headhunter");
        z95.setMass(0.0);
        z95.setMaximumMass(96000.0);
        z95.setAccelerationModifier(50.0);
        z95.setDecelerationModifier(50.0);
        z95.setYawRateModifier(600.0);
        z95.setPitchRateModifier(600.0);
        z95.setRollRateModifier(300.0);
        z95.setSpeedModifier(0.95);
        z95.setWeaponMounts(1);
        z95.setOrdnanceMounts(1);
        
        return z95;
    }
    
    private Chassis getYWing() {
        Chassis yWing = new Chassis();
        
        yWing.setChassisShortName("Y-Wing");
        yWing.setChassisLongName("BTL-S3 Y-Wing Starfighter");
        yWing.setMass(0.0);
        yWing.setMaximumMass(150000.0);
        yWing.setAccelerationModifier(250.0);
        yWing.setDecelerationModifier(300.0);
        yWing.setYawRateModifier(80.0);
        yWing.setPitchRateModifier(80.0);
        yWing.setRollRateModifier(40.0);
        yWing.setSpeedModifier(0.9);
        yWing.setWeaponMounts(2);
        yWing.setOrdnanceMounts(1);
        
        return yWing;
    }
    
    private Chassis getYWingLongprobe() {
        Chassis yWingLongprobe = new Chassis();
        
        yWingLongprobe.setChassisShortName("Y-Wing Longprobe");
        yWingLongprobe.setChassisLongName("BTL-A4 Y-Wing 'Longprobe'");
        yWingLongprobe.setMass(0.0);
        yWingLongprobe.setMaximumMass(170000.0);
        yWingLongprobe.setAccelerationModifier(250.0);
        yWingLongprobe.setDecelerationModifier(300.0);
        yWingLongprobe.setYawRateModifier(100.0);
        yWingLongprobe.setPitchRateModifier(100.0);
        yWingLongprobe.setRollRateModifier(50.0);
        yWingLongprobe.setSpeedModifier(0.9);
        yWingLongprobe.setWeaponMounts(2);
        yWingLongprobe.setOrdnanceMounts(2);
        
        return yWingLongprobe;
    }
    
    private Chassis getXWing() {
        Chassis xWing = new Chassis();
        
        xWing.setChassisShortName("X-Wing");
        xWing.setChassisLongName("T-65 X-Wing Starfighter");
        xWing.setMass(0.0);
        xWing.setMaximumMass(100000.0);
        xWing.setAccelerationModifier(25.0);
        xWing.setDecelerationModifier(30.0);
        xWing.setYawRateModifier(200.0);
        xWing.setPitchRateModifier(300.0);
        xWing.setRollRateModifier(150.0);
        xWing.setSpeedModifier(0.95);
        xWing.setWeaponMounts(3);
        xWing.setOrdnanceMounts(1);
        
        return xWing;
    }
    
    private Chassis getAdvancedXWing() {
        Chassis xWing = new Chassis();
        
        xWing.setChassisShortName("X-Wing");
        xWing.setChassisLongName("T-65 Advanced X-Wing Starfighter");
        xWing.setMass(180000.0);
        xWing.setMass(180000.0);
        xWing.setMaximumMass(180000.0);
        xWing.setAccelerationModifier(250.0);
        xWing.setDecelerationModifier(300.0);
        xWing.setYawRateModifier(200.0);
        xWing.setPitchRateModifier(300.0);
        xWing.setRollRateModifier(150.0);
        xWing.setSpeedModifier(0.95);
        xWing.setWeaponMounts(3);
        xWing.setOrdnanceMounts(1);
        
        return xWing;
    }
    
    private Chassis getAWing() {
        Chassis aWing = new Chassis();
        
        aWing.setChassisShortName("A-Wing");
        aWing.setChassisLongName("RZ-1 A-Wing Interceptor");
        aWing.setMass(0.0);
        aWing.setMaximumMass(66000.0);
        aWing.setAccelerationModifier(400.0);
        aWing.setDecelerationModifier(600.0);
        aWing.setYawRateModifier(250.0);
        aWing.setPitchRateModifier(250.0);
        aWing.setRollRateModifier(125.0);
        aWing.setSpeedModifier(1.0);
        aWing.setWeaponMounts(1);
        aWing.setOrdnanceMounts(1);
        
        return aWing;
    }
    
    private Chassis getSyck() {
        Chassis syck = new Chassis();
        
        syck.setChassisShortName("Syck");
        syck.setChassisLongName("MandalMotors M3-A 'Heavy Syck' Interceptor");
        syck.setMass(0.0);
        syck.setMaximumMass(96000.0);
        syck.setAccelerationModifier(500.0);
        syck.setDecelerationModifier(500.0);
        syck.setYawRateModifier(600.0);
        syck.setPitchRateModifier(600.0);
        syck.setRollRateModifier(300.0);
        syck.setSpeedModifier(0.95);
        syck.setWeaponMounts(1);
        syck.setOrdnanceMounts(1);
        
        return syck;
    }
    
    private Chassis getN1() {
        Chassis n1 = new Chassis();
        
        n1.setChassisShortName("N-1");
        n1.setChassisLongName("Naboo N-1 Starfighter");
        n1.setMass(0.0);
        n1.setMaximumMass(66000.0);
        n1.setAccelerationModifier(400.0);
        n1.setDecelerationModifier(600.0);
        n1.setYawRateModifier(250.0);
        n1.setPitchRateModifier(250.0);
        n1.setRollRateModifier(125.0);
        n1.setSpeedModifier(1.0);
        n1.setWeaponMounts(1);
        n1.setOrdnanceMounts(1);
        
        return n1;
    }
    
    private Chassis getDunelizard() {
        Chassis duneLizard = new Chassis();
        
        duneLizard.setChassisShortName("Dunelizard");
        duneLizard.setChassisLongName("MandalMotors G1-M4-C 'Dunelizard' Starfighter");
        duneLizard.setMass(0.0);
        duneLizard.setMaximumMass(160000.00);
        duneLizard.setAccelerationModifier(300.00);
        duneLizard.setDecelerationModifier(350.00);
        duneLizard.setYawRateModifier(300.00);
        duneLizard.setPitchRateModifier(300.00);
        duneLizard.setRollRateModifier(150.00);
        duneLizard.setSpeedModifier(0.95);
        duneLizard.setWeaponMounts(2);
        duneLizard.setOrdnanceMounts(1);
        
        return duneLizard;
    }
    
    private Chassis getKimogila() {
        Chassis kimogila = new Chassis();
        
        kimogila.setChassisShortName("Kimogila");
        kimogila.setChassisLongName("MandalMotors M12-L 'Kimogila' Starfighter");
        kimogila.setMass(0.0);
        kimogila.setMaximumMass(210000.00);
        kimogila.setAccelerationModifier(350.00);
        kimogila.setDecelerationModifier(350.00);
        kimogila.setYawRateModifier(100.00);
        kimogila.setPitchRateModifier(100.00);
        kimogila.setRollRateModifier(50.00);
        kimogila.setSpeedModifier(0.92);
        kimogila.setWeaponMounts(3);
        kimogila.setOrdnanceMounts(2);
        
        return kimogila;
    }
    
    private Chassis getKihraxz() {
        Chassis kihraxz = new Chassis();
        
        kihraxz.setChassisShortName("Kihraxz");
        kihraxz.setChassisLongName("TransGalMeg 'Kihraxz' Assault Fighter");
        kihraxz.setMass(0.0);
        kihraxz.setMaximumMass(40000.00);
        kihraxz.setAccelerationModifier(40.00);
        kihraxz.setDecelerationModifier(50.00);
        kihraxz.setYawRateModifier(400.00);
        kihraxz.setPitchRateModifier(400.00);
        kihraxz.setRollRateModifier(200.00);
        kihraxz.setSpeedModifier(1.0);
        kihraxz.setWeaponMounts(1);
        kihraxz.setOrdnanceMounts(1);
        
        return kihraxz;
    }
    
    private Chassis getIxiyen() {
        Chassis ixiyen = new Chassis();
        
        ixiyen.setChassisShortName("Ixiyen");
        ixiyen.setChassisLongName("TransGalMeg 'Ixiyen' Fast Attack Craft");
        ixiyen.setMass(0.0);
        ixiyen.setMaximumMass(178000.00);
        ixiyen.setAccelerationModifier(350.00);
        ixiyen.setDecelerationModifier(350.00);
        ixiyen.setYawRateModifier(200.00);
        ixiyen.setPitchRateModifier(200.00);
        ixiyen.setRollRateModifier(100.00);
        ixiyen.setSpeedModifier(0.95);
        ixiyen.setWeaponMounts(2);
        ixiyen.setOrdnanceMounts(2);
        
        return ixiyen;
    }
    
    private Chassis getRihkxyrk() {
        Chassis rihkxyrk = new Chassis();
        
        rihkxyrk.setChassisShortName("Rihkxryk");
        rihkxyrk.setChassisLongName("TransGalMeg 'Rihkxyrk' Attack Ship");
        rihkxyrk.setMass(0.0);
        rihkxyrk.setMaximumMass(190000.00);
        rihkxyrk.setAccelerationModifier(400.00);
        rihkxyrk.setDecelerationModifier(400.00);
        rihkxyrk.setYawRateModifier(100.00);
        rihkxyrk.setPitchRateModifier(100.00);
        rihkxyrk.setRollRateModifier(50.00);
        rihkxyrk.setSpeedModifier(0.97);
        rihkxyrk.setWeaponMounts(3);
        rihkxyrk.setOrdnanceMounts(1);
        
        return rihkxyrk;
    }
    
    private Chassis getKrayt() {
        Chassis krayt = new Chassis();
        
        krayt.setChassisShortName("Krayt");
        krayt.setChassisLongName("MandalMotors M22-T 'Krayt' Gunship");
        krayt.setMass(0.0);
        krayt.setMaximumMass(210000.00);
        krayt.setAccelerationModifier(350.00);
        krayt.setDecelerationModifier(350.00);
        krayt.setYawRateModifier(100.00);
        krayt.setPitchRateModifier(100.00);
        krayt.setRollRateModifier(50.00);
        krayt.setSpeedModifier(0.92);
        krayt.setWeaponMounts(4);
        krayt.setOrdnanceMounts(1);
        
        return krayt;
    }
    
    
    public ArrayList<Chassis> getChassis() {
        Collections.sort(chassis, (Chassis chassisOne, Chassis chassisTwo) -> chassisOne.getChassisLongName().compareTo(chassisTwo.getChassisLongName()));
        return chassis;
    }
}
