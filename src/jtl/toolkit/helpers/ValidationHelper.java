package jtl.toolkit.helpers;

import jtl.toolkit.models.Reactor;
import jtl.toolkit.models.Validation;
import jtl.toolkit.models.Weapon;

public class ValidationHelper {
    
    private final Double L10_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L10_WEAPON_MAXIMUM_ARMOR = 1200.00;
    private final Double L10_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L10_WEAPON_MAXIMUM_HITPOINTS = 1200.00;
    private final Double L10_WEAPON_MINIMUM_DRAIN = 1000.00;
    private final Double L10_WEAPON_MAXIMUM_DRAIN = 4000.00;
    private final Double L10_WEAPON_MINIMUM_MASS = 30000.00;
    private final Double L10_WEAPON_MAXIMUM_MASS = 60000.00;
    private final Double L10_WEAPON_MINIMUM_DAMAGE_MINIMUM = 1500.00;
    private final Double L10_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 3600.00;
    private final Double L10_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 3200.00;
    private final Double L10_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 5800.00;
    private final Double L10_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.4;
    private final Double L10_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.92;
    private final Double L10_WEAPON_MINIMUM_VERSUS_ARMOR = 0.4;
    private final Double L10_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.92;
    private final Double L10_WEAPON_MINIMUM_EPS = 18.0;
    private final Double L10_WEAPON_MAXIMUM_EPS = 50.0;
    private final Double L10_WEAPON_MINIMUM_REFIRE = 0.28;
    private final Double L10_WEAPON_MAXIMUM_REFIRE = 0.600;
    
    private final Double L10_REACTOR_MINIMUM_ARMOR = 300.00;
    private final Double L10_REACTOR_MAXIMUM_ARMOR = 1200.00;
    private final Double L10_REACTOR_MINIMUM_HITPOINTS = 300.00;
    private final Double L10_REACTOR_MAXIMUM_HITPOINTS = 1200.00;
    private final Double L10_REACTOR_MINIMUM_MASS = 30000.00;
    private final Double L10_REACTOR_MAXIMUM_MASS = 120000.00;
    private final Double L10_REACTOR_MINIMUM_GENERATION = 10000.00;
    private final Double L10_REACTOR_MAXIMUM_GENERATION = 60000.00;
                
    public Validation validateReactor(Validation validation, Reactor reactor) {
        
        System.out.println("VALIDATING REACTOR...");
        System.out.println(validation.componentLevel);
        System.out.println(validation.componentType);
        
        System.out.println(reactor.getArmor());
        System.out.println(reactor.getHitpoints());
        System.out.println(reactor.getMass());
        System.out.println(reactor.getGenerationRate());
        
        if(validation.componentLevel.equals(1)) {
            
        }else if(validation.componentLevel.equals(2)) {
            
        }else if(validation.componentLevel.equals(3)) {
            
        }else if(validation.componentLevel.equals(4)) {
            
        }else if(validation.componentLevel.equals(5)) {
            
        }else if(validation.componentLevel.equals(6)) {
            
        }else if(validation.componentLevel.equals(7)) {
            
        }else if(validation.componentLevel.equals(8)) {
            
        }else if(validation.componentLevel.equals(9)) {
            
        }else if(validation.componentLevel.equals(10)) {
            
            System.out.println("VALIDATING LEVEL 10 REACTOR...");
            
            System.out.println(reactor.getArmor());
            System.out.println(reactor.getHitpoints());
            System.out.println(reactor.getMass());
            System.out.println(reactor.getGenerationRate());
            
            if(!validateValue(reactor.getArmor(), this.L10_REACTOR_MINIMUM_ARMOR, this.L10_REACTOR_MAXIMUM_ARMOR)) {
                validation.validationResult = false;
                validation.statsInError.add("Armor");
                validation.reasonsForError.add("Invalid armor value...please re-enter.");
            }
            if(!validateValue(reactor.getHitpoints(), this.L10_REACTOR_MINIMUM_HITPOINTS, this.L10_REACTOR_MAXIMUM_HITPOINTS)) {
                validation.validationResult = false;
                validation.statsInError.add("Hitpoints");
                validation.reasonsForError.add("Invalid hitpoint value...please re-enter.");
            }
            if(!validateValue(reactor.getMass(), this.L10_REACTOR_MINIMUM_MASS, this.L10_REACTOR_MAXIMUM_MASS)) {
                validation.validationResult = false;
                validation.statsInError.add("Mass");
                validation.reasonsForError.add("Invalid mass value...please re-enter.");
            }
            if(!validateValue(reactor.getGenerationRate(), this.L10_REACTOR_MINIMUM_MASS, this.L10_REACTOR_MAXIMUM_MASS)) {
                validation.validationResult = false;
                validation.statsInError.add("Generation");
                validation.reasonsForError.add("Invalid generation value...please re-enter.");
            }
        }
        
        return validation;
    }
    
    public Validation validateWeapon(Validation validation, Weapon weapon) {
        
        if(validation.componentLevel.equals(1)) {
            
        }else if(validation.componentLevel.equals(2)) {
            
        }else if(validation.componentLevel.equals(3)) {
            
        }else if(validation.componentLevel.equals(4)) {
            
        }else if(validation.componentLevel.equals(5)) {
            
        }else if(validation.componentLevel.equals(6)) {
            
        }else if(validation.componentLevel.equals(7)) {
            
        }else if(validation.componentLevel.equals(8)) {
            
        }else if(validation.componentLevel.equals(9)) {
            
        }else if(validation.componentLevel.equals(10)) {
            if(!validateValue(weapon.getArmor(), this.L10_WEAPON_MINIMUM_ARMOR, this.L10_WEAPON_MAXIMUM_ARMOR)) {
                validation.validationResult = false;
                validation.statsInError.add("Armor");
                validation.reasonsForError.add("Invalid armor value...please re-enter.");
            }
            if(!validateValue(weapon.getHitpoints(), this.L10_WEAPON_MINIMUM_HITPOINTS, this.L10_WEAPON_MAXIMUM_HITPOINTS)) {
                validation.validationResult = false;
                validation.statsInError.add("Hitpoints");
                validation.reasonsForError.add("Invalid hitpoint value...please re-enter.");
            }
            if(!validateValue(weapon.getEnergyDrain(), this.L10_WEAPON_MINIMUM_DRAIN, this.L10_WEAPON_MAXIMUM_DRAIN)) {
                validation.validationResult = false;
                validation.statsInError.add("Energy Drain");
                validation.reasonsForError.add("Invalid energy drain value...please re-enter.");
            }
            if(!validateValue(weapon.getMass(), this.L10_WEAPON_MINIMUM_MASS, this.L10_WEAPON_MAXIMUM_MASS)) {
                validation.validationResult = false;
                validation.statsInError.add("Mass");
                validation.reasonsForError.add("Invalid mass value...please re-enter.");
            }
            if(!validateValue(weapon.getMinimumDamage(), this.L10_WEAPON_MINIMUM_DAMAGE_MINIMUM, this.L10_WEAPON_MINIMUM_DAMAGE_MAXIMUM)) {
                validation.validationResult = false;
                validation.statsInError.add("Minimum Damage");
                validation.reasonsForError.add("Invalid minimum damage value...please re-enter.");
            }
            if(!validateValue(weapon.getMaximumDamage(), this.L10_WEAPON_MAXIMUM_DAMAGE_MINIMUM, this.L10_WEAPON_MAXIMUM_DAMAGE_MAXIMUM)) {
                validation.validationResult = false;
                validation.statsInError.add("Maximum Damage");
                validation.reasonsForError.add("Invalid maximum damage value...please re-enter.");
            }
            if(!validateValue(weapon.getVersusArmor(), this.L10_WEAPON_MINIMUM_VERSUS_ARMOR, this.L10_WEAPON_MAXIMUM_VERSUS_ARMOR)) {
                validation.validationResult = false;
                validation.statsInError.add("Versus Armor");
                validation.reasonsForError.add("Invalid versus armor value...please re-enter.");
            }
            if(!validateValue(weapon.getVersusShields(), this.L10_WEAPON_MINIMUM_VERSUS_SHIELDS, this.L10_WEAPON_MAXIMUM_VERSUS_SHIELDS)) {
                validation.validationResult = false;
                validation.statsInError.add("Versus Shields");
                validation.reasonsForError.add("Invalid versus shields value...please re-enter.");
            }
            if(!validateValue(weapon.getEnergyPerShot(), this.L10_WEAPON_MINIMUM_EPS, this.L10_WEAPON_MAXIMUM_EPS)) {
                validation.validationResult = false;
                validation.statsInError.add("EPS");
                validation.reasonsForError.add("Invalid EPS value...please re-enter.");
            }
            if(!validateValue(weapon.getRefireRate(), this.L10_WEAPON_MINIMUM_REFIRE, this.L10_WEAPON_MAXIMUM_REFIRE)) {
                validation.validationResult = false;
                validation.statsInError.add("Refire Rate");
                validation.reasonsForError.add("Invalid refire rate value...please re-enter.");
            }
        }
        
        return validation;
    }
    
    public Boolean validateValue(Double actual, Double minimum, Double maximum) {
        return actual > minimum && actual < maximum;
    }    
}
