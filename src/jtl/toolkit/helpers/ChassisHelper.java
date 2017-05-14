package jtl.toolkit.helpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import jtl.toolkit.models.Chassis;

public class ChassisHelper {
    
    ArrayList<Chassis> chassis;
    
    public ChassisHelper() {
        chassis = new ArrayList<>();
        
        // Add neutral ships
        chassis.add(getVaksai());
        chassis.add(getSyck());
        chassis.add(getN1());
        chassis.add(getDunelizard());
        chassis.add(getKimogila());
        chassis.add(getKihraxz());
        chassis.add(getIxiyen());
        chassis.add(getRihkxyrk());
        chassis.add(getKrayt());
        
        // Add rebel ships
        chassis.add(getBWing());
        chassis.add(getZ95());
        chassis.add(getYWing());
        chassis.add(getYWingLongprobe());
        chassis.add(getXWing());
        chassis.add(getAdvancedXWing());
        chassis.add(getAWing());
        
        // Add imperial ships
        chassis.add(getTIEFighter());
        chassis.add(getTIEINFighter());
        chassis.add(getTIEInterceptor());
        chassis.add(getTIEBomber());
        chassis.add(getTIEAggressor());
        chassis.add(getTIEAdvanced());
        chassis.add(getTIEOppressor());
        chassis.add(getRGI());
        
        // Add other ships
        chassis.add(getJSF());
        chassis.add(getBell());
        chassis.add(getFirespray());
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Neutral ships">
    
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
    
    private Chassis getSyck() {
        Chassis syck = new Chassis();
        
        syck.setChassisShortName("Syck");
        syck.setChassisLongName("MandalMotors M3-A 'Heavy Syck' Interceptor");
        syck.setMass(0.0);
        syck.setMaximumMass(97000.0);
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
        n1.setMaximumMass(66625.0);
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
        duneLizard.setMaximumMass(150750.00);
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
        kimogila.setMaximumMass(202250.00);
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
        kihraxz.setMaximumMass(40740.00);
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
        rihkxyrk.setMaximumMass(193250.00);
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
        krayt.setMaximumMass(212250.00);
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
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Rebel ships">
    
        private Chassis getBWing() {
        Chassis BWing = new Chassis();
        
        BWing.setChassisShortName("B-Wing");
        BWing.setChassisLongName("B-Wing");
        BWing.setMass(0.0);
        BWing.setMaximumMass(246000.0);
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

    private Chassis getZ95() {
        Chassis z95 = new Chassis();
        
        z95.setChassisShortName("Z-95");
        z95.setChassisLongName("Z-95 Headhunter");
        z95.setMass(0.0);
        z95.setMaximumMass(97000.0);
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
        yWing.setMaximumMass(153750.0);
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
        yWingLongprobe.setMaximumMass(174250.0);
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
        xWing.setMaximumMass(102500.0);
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
        aWing.setMaximumMass(66625.0);
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
    
    
    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Imperial ships">
        
    private Chassis getTIEFighter() {
        Chassis TIEFighter = new Chassis();
        
        TIEFighter.setChassisShortName("TIE Fighter");
        TIEFighter.setChassisLongName("TIE Fighter");
        TIEFighter.setMass(0.0);
        TIEFighter.setMaximumMass(97000.00);
        TIEFighter.setAccelerationModifier(500.00);
        TIEFighter.setDecelerationModifier(500.00);
        TIEFighter.setYawRateModifier(500.00);
        TIEFighter.setPitchRateModifier(500.00);
        TIEFighter.setRollRateModifier(250.00);
        TIEFighter.setSpeedModifier(0.98);
        TIEFighter.setWeaponMounts(1);
        TIEFighter.setOrdnanceMounts(1);
        
        return TIEFighter;
    }
    
    private Chassis getTIEINFighter() {
        Chassis TIEINFighter = new Chassis();
        
        TIEINFighter.setChassisShortName("TIE/In Fighter");
        TIEINFighter.setChassisLongName("TIE/In Fighter");
        TIEINFighter.setMass(0.0);
        TIEINFighter.setMaximumMass(80000.00);
        TIEINFighter.setAccelerationModifier(400.00);
        TIEINFighter.setDecelerationModifier(600.00);
        TIEINFighter.setYawRateModifier(300.00);
        TIEINFighter.setPitchRateModifier(300.00);
        TIEINFighter.setRollRateModifier(200.00);
        TIEINFighter.setSpeedModifier(0.97);
        TIEINFighter.setWeaponMounts(1);
        TIEINFighter.setOrdnanceMounts(1);
        
        return TIEINFighter;
    }
    
    private Chassis getTIEInterceptor() {
        Chassis TIEInterceptor = new Chassis();
        
        TIEInterceptor.setChassisShortName("TIE Interceptor");
        TIEInterceptor.setChassisLongName("TIE/In Interceptor");
        TIEInterceptor.setMass(0.0);
        TIEInterceptor.setMaximumMass(51250.00);
        TIEInterceptor.setAccelerationModifier(400.00);
        TIEInterceptor.setDecelerationModifier(600.00);
        TIEInterceptor.setYawRateModifier(300.00);
        TIEInterceptor.setPitchRateModifier(300.00);
        TIEInterceptor.setRollRateModifier(150.00);
        TIEInterceptor.setSpeedModifier(1.00);
        TIEInterceptor.setWeaponMounts(1);
        TIEInterceptor.setOrdnanceMounts(1);
        
        return TIEInterceptor;
    }
    
    private Chassis getTIEBomber() {
        Chassis TIEBomber = new Chassis();
        
        TIEBomber.setChassisShortName("TIE Bomber");
        TIEBomber.setChassisLongName("TIE/sa Bomber");
        TIEBomber.setMass(0.0);
        TIEBomber.setMaximumMass(194750.00);
        TIEBomber.setAccelerationModifier(300.00);
        TIEBomber.setDecelerationModifier(300.00);
        TIEBomber.setYawRateModifier(80.00);
        TIEBomber.setPitchRateModifier(80.00);
        TIEBomber.setRollRateModifier(40.00);
        TIEBomber.setSpeedModifier(0.95);
        TIEBomber.setWeaponMounts(2);
        TIEBomber.setOrdnanceMounts(2);
        
        return TIEBomber;
    }
    
    private Chassis getTIEAggressor() {
        Chassis TIEAggressor = new Chassis();
        
        TIEAggressor.setChassisShortName("TIE Aggressor");
        TIEAggressor.setChassisLongName("TIE Aggressor");
        TIEAggressor.setMass(0.0);
        TIEAggressor.setMaximumMass(123000.00);
        TIEAggressor.setAccelerationModifier(200.00);
        TIEAggressor.setDecelerationModifier(300.00);
        TIEAggressor.setYawRateModifier(150.00);
        TIEAggressor.setPitchRateModifier(200.00);
        TIEAggressor.setRollRateModifier(100.00);
        TIEAggressor.setSpeedModifier(0.95);
        TIEAggressor.setWeaponMounts(2);
        TIEAggressor.setOrdnanceMounts(1);
        
        return TIEAggressor;
    }
    
    private Chassis getTIEAdvanced() {
        Chassis TIEAdvanced = new Chassis();
        
        TIEAdvanced.setChassisShortName("TIE Advanced");
        TIEAdvanced.setChassisLongName("TIE Advanced");
        TIEAdvanced.setMass(0.0);
        TIEAdvanced.setMaximumMass(66625.00);
        TIEAdvanced.setAccelerationModifier(400.00);
        TIEAdvanced.setDecelerationModifier(600.00);
        TIEAdvanced.setYawRateModifier(300.00);
        TIEAdvanced.setPitchRateModifier(300.00);
        TIEAdvanced.setRollRateModifier(150.00);
        TIEAdvanced.setSpeedModifier(1.00);
        TIEAdvanced.setWeaponMounts(2);
        TIEAdvanced.setOrdnanceMounts(1);
        
        return TIEAdvanced;
    }
    
    private Chassis getTIEOppressor() {
        Chassis TIEOppressor = new Chassis();
        
        TIEOppressor.setChassisShortName("TIE Oppressor");
        TIEOppressor.setChassisLongName("TIE Oppressor");
        TIEOppressor.setMass(0.0);
        TIEOppressor.setMaximumMass(173750.00);
        TIEOppressor.setAccelerationModifier(350.00);
        TIEOppressor.setDecelerationModifier(360.00);
        TIEOppressor.setYawRateModifier(100.00);
        TIEOppressor.setPitchRateModifier(100.00);
        TIEOppressor.setRollRateModifier(50.00);
        TIEOppressor.setSpeedModifier(0.90);
        TIEOppressor.setWeaponMounts(2);
        TIEOppressor.setOrdnanceMounts(3);
        
        return TIEOppressor;
    }
    
    private Chassis getRGI() {
        Chassis RGI = new Chassis();
        
        RGI.setChassisShortName("Royal Guard Interceptor");
        RGI.setChassisLongName("Royal Guard Interceptor");
        RGI.setMass(80000.0);
        RGI.setMaximumMass(80000.00);
        RGI.setAccelerationModifier(400.00);
        RGI.setDecelerationModifier(600.00);
        RGI.setYawRateModifier(300.00);
        RGI.setPitchRateModifier(300.00);
        RGI.setRollRateModifier(150.00);
        RGI.setSpeedModifier(1.0);
        RGI.setWeaponMounts(1);
        RGI.setOrdnanceMounts(1);
        
        return RGI;
    }
    
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Other ships">
    
    private Chassis getJSF() {
        Chassis JSF = new Chassis();
        
        JSF.setChassisShortName("Eta-2 Actis Interceptor");
        JSF.setChassisLongName("Eta-2 Actis Interceptor");
        JSF.setMass(90000.0);
        JSF.setMaximumMass(90000.00);
        JSF.setAccelerationModifier(400.00);
        JSF.setDecelerationModifier(400.00);
        JSF.setYawRateModifier(400.00);
        JSF.setPitchRateModifier(400.00);
        JSF.setRollRateModifier(200.00);
        JSF.setSpeedModifier(0.95);
        JSF.setWeaponMounts(2);
        JSF.setOrdnanceMounts(1);
        
        return JSF;
    }

    private Chassis getBell() {
        Chassis bell = new Chassis();
        
        bell.setChassisShortName("Belbullab-22");
        bell.setChassisLongName("Belbullab-22");
        bell.setMass(90000.0);
        bell.setMaximumMass(90000.00);
        bell.setAccelerationModifier(400.00);
        bell.setDecelerationModifier(400.00);
        bell.setYawRateModifier(400.00);
        bell.setPitchRateModifier(400.00);
        bell.setRollRateModifier(200.00);
        bell.setSpeedModifier(0.95);
        bell.setWeaponMounts(2);
        bell.setOrdnanceMounts(1);
        
        return bell;
    }
    
    private Chassis getFirespray() {
        Chassis firespray = new Chassis();
        
        firespray.setChassisShortName("KSE Firespray");
        firespray.setChassisLongName("KSE Firespray");
        firespray.setMass(0.00);
        firespray.setMaximumMass(214500.00);
        firespray.setAccelerationModifier(350.00);
        firespray.setDecelerationModifier(350.00);
        firespray.setYawRateModifier(100.00);
        firespray.setPitchRateModifier(100.00);
        firespray.setRollRateModifier(50.00);
        firespray.setSpeedModifier(0.90);
        firespray.setWeaponMounts(2);
        firespray.setOrdnanceMounts(2);
        
        return firespray;
    }
    
    // </editor-fold>
    

    
    public ArrayList<Chassis> getChassis() {
        Collections.sort(chassis, (Chassis chassisOne, Chassis chassisTwo) -> chassisOne.getChassisLongName().compareTo(chassisTwo.getChassisLongName()));
        return chassis;
    }
}
