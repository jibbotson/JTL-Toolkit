package jtl.toolkit.helpers;

import jtl.toolkit.models.Armor;
import jtl.toolkit.models.Booster;
import jtl.toolkit.models.Capacitor;
import jtl.toolkit.models.Countermeasure;
import jtl.toolkit.models.DroidInterface;
import jtl.toolkit.models.Engine;
import jtl.toolkit.models.Ordnance;
import jtl.toolkit.models.Reactor;
import jtl.toolkit.models.Shield;
import jtl.toolkit.models.Validation;
import jtl.toolkit.models.Weapon;

public class ValidationHelper {
    
    private final Double L1_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L1_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L1_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L1_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L1_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L1_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L1_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L2_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L2_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L2_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L2_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L2_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L2_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L2_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L2_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L3_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L3_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L3_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L3_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L3_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L3_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L3_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L4_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L4_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L4_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L4_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L4_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L4_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L4_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L4_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L5_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L5_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L5_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L5_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L5_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L5_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L5_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L6_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L6_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L6_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L6_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L6_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L6_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L6_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L6_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L7_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L7_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L7_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L7_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L7_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L7_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L7_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L8_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L8_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L8_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L8_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L8_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L8_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L8_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L8_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L9_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L9_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L9_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L9_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L9_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L9_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L9_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L10_REACTOR_MINIMUM_ARMOR = 0.00;
    private final Double L10_REACTOR_MAXIMUM_ARMOR = 0.00;
    private final Double L10_REACTOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L10_REACTOR_MAXIMUM_HITPOINTS = 10.00;
    private final Double L10_REACTOR_MINIMUM_MASS = 0.00;
    private final Double L10_REACTOR_MAXIMUM_MASS = 0.00;
    private final Double L10_REACTOR_MINIMUM_GENERATION = 0.00;
    private final Double L10_REACTOR_MAXIMUM_GENERATION = 0.00;
    
    private final Double L1_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L1_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L1_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L1_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L1_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L1_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L1_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L1_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L1_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L1_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L1_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L1_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L1_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L1_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L1_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L2_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L2_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L2_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L2_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L2_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L2_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L2_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L2_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L2_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L2_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L2_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L2_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L2_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L2_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L2_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L2_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L3_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L3_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L3_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L3_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L3_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L3_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L3_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L3_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L3_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L3_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L3_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L3_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L3_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L3_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L3_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L4_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L4_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L4_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L4_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L4_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L4_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L4_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L4_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L4_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L4_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L4_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L4_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L4_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L4_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L4_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L4_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L5_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L5_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L5_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L5_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L5_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L5_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L5_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L5_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L5_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L5_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L5_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L5_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L5_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L5_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L5_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L6_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L6_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L6_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L6_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L6_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L6_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L6_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L6_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L6_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L6_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L6_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L6_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L6_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L6_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L6_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L6_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L7_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L7_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L7_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L7_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L7_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L7_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L7_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L7_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L7_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L7_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L7_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L7_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L7_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L7_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L7_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L8_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L8_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L8_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L8_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L8_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L8_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L8_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L8_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L8_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L8_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L8_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L8_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L8_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L8_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L8_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L8_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L9_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L9_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L9_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L9_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L9_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L9_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L9_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L9_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L9_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L9_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L9_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L9_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L9_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L9_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L9_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L10_ENGINE_MINIMUM_ARMOR = 0.00;
    private final Double L10_ENGINE_MAXIMUM_ARMOR = 0.00;
    private final Double L10_ENGINE_MINIMUM_HITPOINTS = 0.00;
    private final Double L10_ENGINE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L10_ENGINE_MINIMUM_DRAIN = 0.00;
    private final Double L10_ENGINE_MAXIMUM_DRAIN = 0.00;
    private final Double L10_ENGINE_MINIMUM_MASS = 0.00;
    private final Double L10_ENGINE_MAXIMUM_MASS = 0.00;
    private final Double L10_ENGINE_MINIMUM_PITCH = 0.00;
    private final Double L10_ENGINE_MAXIMUM_PITCH = 0.00; 
    private final Double L10_ENGINE_MINIMUM_YAW = 0.00;
    private final Double L10_ENGINE_MAXIMUM_YAW = 0.00; 
    private final Double L10_ENGINE_MINIMUM_ROLL = 0.00;
    private final Double L10_ENGINE_MAXIMUM_ROLL = 0.00; 
    private final Double L10_ENGINE_MINIMUM_SPEED = 0.00;
    private final Double L10_ENGINE_MAXIMUM_SPEED = 0.00; 
    
    private final Double L1_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L1_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L1_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L1_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L1_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L1_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L1_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L1_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L1_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L1_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L1_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L1_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L1_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L2_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L2_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L2_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L2_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L2_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L2_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L2_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L2_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L2_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L2_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L2_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L2_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L2_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L2_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L3_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L3_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L3_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L3_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L3_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L3_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L3_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L3_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L3_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L3_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L3_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L3_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L3_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L4_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L4_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L4_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L4_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L4_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L4_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L4_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L4_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L4_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L4_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L4_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L4_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L4_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L4_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L5_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L5_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L5_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L5_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L5_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L5_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L5_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L5_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L5_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L5_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L5_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L5_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L5_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L6_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L6_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L6_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L6_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L6_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L6_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L6_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L6_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L6_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L6_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L6_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L6_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L6_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L6_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L7_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L7_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L7_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L7_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L7_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L7_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L7_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L7_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L7_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L7_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L7_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L7_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L7_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L8_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L8_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L8_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L8_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L8_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L8_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L8_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L8_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L8_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L8_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L8_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L8_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L8_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L8_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L9_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L9_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L9_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L9_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L9_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L9_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L9_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L9_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L9_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L9_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L9_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L9_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L9_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L10_SHIELD_MINIMUM_ARMOR = 0.00;
    private final Double L10_SHIELD_MAXIMUM_ARMOR = 0.00;
    private final Double L10_SHIELD_MINIMUM_HITPOINTS = 0.00;
    private final Double L10_SHIELD_MAXIMUM_HITPOINTS = 0.00;
    private final Double L10_SHIELD_MINIMUM_DRAIN = 0.00;
    private final Double L10_SHIELD_MAXIMUM_DRAIN = 0.00;
    private final Double L10_SHIELD_MINIMUM_MASS = 0.00;
    private final Double L10_SHIELD_MAXIMUM_MASS = 0.00;
    private final Double L10_SHIELD_MINIMUM_FRONT = 0.00;
    private final Double L10_SHIELD_MAXIMUM_FRONT = 0.00;
    private final Double L10_SHIELD_MINIMUM_BACK = 0.00;
    private final Double L10_SHIELD_MAXIMUM_BACK = 0.00;
    private final Double L10_SHIELD_MINIMUM_RECHARGE = 0.00;
    private final Double L10_SHIELD_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L1_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L1_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L1_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L1_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L1_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L2_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L2_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L2_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L2_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L2_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L2_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L3_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L3_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L3_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L3_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L3_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L4_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L4_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L4_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L4_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L4_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L4_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L5_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L5_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L5_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L5_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L5_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L6_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L6_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L6_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L6_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L6_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L6_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L7_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L7_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L7_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L7_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L7_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L8_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L8_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L8_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L8_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L8_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L8_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L9_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L9_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L9_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L9_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L9_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L10_ARMOR_MINIMUM_ARMOR = 0.00;
    private final Double L10_ARMOR_MAXIMUM_ARMOR = 0.00;
    private final Double L10_ARMOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L10_ARMOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L10_ARMOR_MINIMUM_MASS = 0.00;
    private final Double L10_ARMOR_MAXIMUM_MASS = 0.00;
    
    private final Double L1_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L1_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L1_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L1_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L1_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L1_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L1_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L1_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L1_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L1_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L1_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L2_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L2_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L2_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L2_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L2_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L2_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L2_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L2_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L2_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L2_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L2_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L2_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L3_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L3_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L3_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L3_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L3_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L3_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L3_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L3_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L3_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L3_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L3_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L4_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L4_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L4_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L4_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L4_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L4_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L4_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L4_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L4_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L4_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L4_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L4_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L5_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L5_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L5_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L5_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L5_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L5_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L5_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L5_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L5_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L5_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L5_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L6_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L6_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L6_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L6_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L6_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L6_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L6_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L6_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L6_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L6_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L6_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L6_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L7_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L7_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L7_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L7_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L7_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L7_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L7_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L7_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L7_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L7_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L7_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L8_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L8_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L8_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L8_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L8_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L8_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L8_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L8_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L8_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L8_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L8_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L8_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L9_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L9_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L9_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L9_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L9_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L9_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L9_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L9_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L9_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L9_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L9_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L10_CAPACITOR_MINIMUM_ARMOR = 0.00;
    private final Double L10_CAPACITOR_MAXIMUM_ARMOR = 0.00;
    private final Double L10_CAPACITOR_MINIMUM_HITPOINTS = 0.00;
    private final Double L10_CAPACITOR_MAXIMUM_HITPOINTS = 0.00;
    private final Double L10_CAPACITOR_MINIMUM_DRAIN = 0.00;
    private final Double L10_CAPACITOR_MAXIMUM_DRAIN = 0.00;
    private final Double L10_CAPACITOR_MINIMUM_MASS = 0.00;
    private final Double L10_CAPACITOR_MAXIMUM_MASS = 0.00;
    private final Double L10_CAPACITOR_MINIMUM_ENERGY = 0.00;
    private final Double L10_CAPACITOR_MAXIMUM_ENERGY = 0.00;
    private final Double L10_CAPACITOR_MINIMUM_RECHARGE = 0.00;
    private final Double L10_CAPACITOR_MAXIMUM_RECHARGE = 0.00;
    
    private final Double L1_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L1_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L1_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L1_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L1_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L1_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L1_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L1_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L1_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L1_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L1_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L1_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L1_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L1_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L1_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L2_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L2_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L2_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L2_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L2_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L2_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L2_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L2_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L2_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L2_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L2_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L2_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L2_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L2_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L2_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L2_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L3_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L3_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L3_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L3_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L3_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L3_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L3_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L3_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L3_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L3_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L3_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L3_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L3_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L3_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L3_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L4_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L4_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L4_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L4_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L4_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L4_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L4_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L4_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L4_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L4_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L4_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L4_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L4_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L4_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L4_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L4_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L5_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L5_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L5_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L5_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L5_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L5_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L5_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L5_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L5_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L5_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L5_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L5_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L5_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L5_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L5_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L6_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L6_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L6_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L6_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L6_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L6_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L6_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L6_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L6_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L6_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L6_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L6_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L6_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L6_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L6_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L6_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L7_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L7_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L7_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L7_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L7_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L7_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L7_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L7_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L7_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L7_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L7_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L7_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L7_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L7_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L7_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L8_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L8_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L8_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L8_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L8_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L8_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L8_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L8_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L8_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L8_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L8_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L8_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L8_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L8_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L8_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L8_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L9_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L9_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L9_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L9_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L9_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L9_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L9_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L9_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L9_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L9_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L9_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L9_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L9_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L9_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L9_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L10_BOOSTER_MINIMUM_ARMOR = 0.00;
    private final Double L10_BOOSTER_MAXIMUM_ARMOR = 0.00;
    private final Double L10_BOOSTER_MINIMUM_HITPOINTS = 0.00;
    private final Double L10_BOOSTER_MAXIMUM_HITPOINTS = 0.00;
    private final Double L10_BOOSTER_MINIMUM_DRAIN = 0.00;
    private final Double L10_BOOSTER_MAXIMUM_DRAIN = 0.00;
    private final Double L10_BOOSTER_MINIMUM_MASS = 0.00;
    private final Double L10_BOOSTER_MAXIMUM_MASS = 0.00;
    private final Double L10_BOOSTER_MINIMUM_ENERGY = 0.00;
    private final Double L10_BOOSTER_MAXIMUM_ENERGY = 0.00;
    private final Double L10_BOOSTER_MINIMUM_RECHARGE = 0.00;
    private final Double L10_BOOSTER_MAXIMUM_RECHARGE = 0.00;
    private final Double L10_BOOSTER_MINIMUM_CONSUMPTION = 0.00;
    private final Double L10_BOOSTER_MAXIMUM_CONSUMPTION = 0.00;
    private final Double L10_BOOSTER_MINIMUM_SPEED = 0.00;
    private final Double L10_BOOSTER_MAXIMUM_SPEED = 0.00;
    
    private final Double L1_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L1_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L1_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L1_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L1_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L1_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L1_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L1_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L1_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L2_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L2_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L2_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L2_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L2_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L2_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L2_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L2_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L2_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L2_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L3_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L3_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L3_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L3_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L3_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L3_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L3_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L3_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L3_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L4_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L4_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L4_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L4_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L4_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L4_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L4_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L4_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L4_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L4_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L5_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L5_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L5_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L5_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L5_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L5_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L5_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L5_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L5_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L6_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L6_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L6_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L6_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L6_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L6_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L6_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L6_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L6_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L6_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L7_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L7_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L7_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L7_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L7_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L7_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L7_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L7_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L7_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L8_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L8_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L8_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L8_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L8_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L8_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L8_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L8_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L8_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L8_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L9_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L9_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L9_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L9_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L9_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L9_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L9_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L9_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L9_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L10_INTERFACE_MINIMUM_ARMOR = 0.00;
    private final Double L10_INTERFACE_MAXIMUM_ARMOR = 0.00;
    private final Double L10_INTERFACE_MINIMUM_HITPOINTS = 0.00;
    private final Double L10_INTERFACE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L10_INTERFACE_MINIMUM_DRAIN = 0.00;
    private final Double L10_INTERFACE_MAXIMUM_DRAIN = 0.00;
    private final Double L10_INTERFACE_MINIMUM_MASS = 0.00;
    private final Double L10_INTERFACE_MAXIMUM_MASS = 0.00;
    private final Double L10_INTERFACE_MINIMUM_SPEED = 0.00;
    private final Double L10_INTERFACE_MAXIMUM_SPEED = 0.00;
    
    private final Double L1_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L1_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L1_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L1_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L1_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L1_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L1_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L1_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L1_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L1_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L1_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L1_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L1_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L1_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L1_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L1_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L1_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L1_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L1_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L2_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L2_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L2_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L2_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L2_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L2_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L2_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L2_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L2_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L2_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L2_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L2_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L2_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L2_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L2_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L2_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L2_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L2_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L2_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L2_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L3_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L3_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L3_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L3_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L3_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L3_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L3_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L3_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L3_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L3_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L3_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L3_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L3_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L3_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L3_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L3_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L3_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L3_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L3_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L4_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L4_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L4_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L4_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L4_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L4_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L4_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L4_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L4_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L4_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L4_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L4_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L4_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L4_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L4_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L4_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L4_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L4_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L4_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L4_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L5_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L5_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L5_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L5_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L5_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L5_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L5_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L5_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L5_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L5_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L5_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L5_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L5_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L5_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L5_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L5_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L5_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L5_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L5_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L6_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L6_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L6_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L6_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L6_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L6_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L6_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L6_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L6_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L6_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L6_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L6_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L6_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L6_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L6_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L6_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L6_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L6_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L6_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L6_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L7_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L7_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L7_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L7_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L7_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L7_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L7_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L7_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L7_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L7_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L7_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L7_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L7_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L7_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L7_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L7_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L7_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L7_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L7_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L8_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L8_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L8_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L8_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L8_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L8_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L8_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L8_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L8_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L8_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L8_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L8_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L8_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L8_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L8_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L8_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L8_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L8_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L8_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L8_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L9_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L9_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L9_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L9_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L9_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L9_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L9_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L9_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L9_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L9_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L9_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L9_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L9_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L9_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L9_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L9_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L9_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L9_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L9_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L10_WEAPON_MINIMUM_ARMOR = 0.00;
    private final Double L10_WEAPON_MAXIMUM_ARMOR = 0.00;
    private final Double L10_WEAPON_MINIMUM_HITPOINTS = 0.00;
    private final Double L10_WEAPON_MAXIMUM_HITPOINTS = 0.00;
    private final Double L10_WEAPON_MINIMUM_DRAIN = 0.00;
    private final Double L10_WEAPON_MAXIMUM_DRAIN = 0.00;
    private final Double L10_WEAPON_MINIMUM_MASS = 0.00;
    private final Double L10_WEAPON_MAXIMUM_MASS = 0.00;
    private final Double L10_WEAPON_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L10_WEAPON_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L10_WEAPON_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L10_WEAPON_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L10_WEAPON_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L10_WEAPON_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L10_WEAPON_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L10_WEAPON_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L10_WEAPON_MINIMUM_EPS = 0.00;
    private final Double L10_WEAPON_MAXIMUM_EPS = 0.00;
    private final Double L10_WEAPON_MINIMUM_REFIRE = 0.00;
    private final Double L10_WEAPON_MAXIMUM_REFIRE = 0.00;
    
    private final Double L1_COUNTERMEASURE_MINIMUM_ARMOR = 0.00;
    private final Double L1_COUNTERMEASURE_MAXIMUM_ARMOR = 0.00;
    private final Double L1_COUNTERMEASURE_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_COUNTERMEASURE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L1_COUNTERMEASURE_MINIMUM_DRAIN = 0.00;
    private final Double L1_COUNTERMEASURE_MAXIMUM_DRAIN = 0.00;
    private final Double L1_COUNTERMEASURE_MINIMUM_MASS = 0.00;
    private final Double L1_COUNTERMEASURE_MAXIMUM_MASS = 0.00;
    private final Double L1_COUNTERMEASURE_MINIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L1_COUNTERMEASURE_MINIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L1_COUNTERMEASURE_MAXIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L1_COUNTERMEASURE_MAXIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L1_COUNTERMEASURE_MINIMUM_REFIRE = 0.00;
    private final Double L1_COUNTERMEASURE_MAXIMUM_REFIRE = 0.00;
    
    private final Double L3_COUNTERMEASURE_MINIMUM_ARMOR = 0.00;
    private final Double L3_COUNTERMEASURE_MAXIMUM_ARMOR = 0.00;
    private final Double L3_COUNTERMEASURE_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_COUNTERMEASURE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L3_COUNTERMEASURE_MINIMUM_DRAIN = 0.00;
    private final Double L3_COUNTERMEASURE_MAXIMUM_DRAIN = 0.00;
    private final Double L3_COUNTERMEASURE_MINIMUM_MASS = 0.00;
    private final Double L3_COUNTERMEASURE_MAXIMUM_MASS = 0.00;
    private final Double L3_COUNTERMEASURE_MINIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L3_COUNTERMEASURE_MINIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L3_COUNTERMEASURE_MAXIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L3_COUNTERMEASURE_MAXIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L3_COUNTERMEASURE_MINIMUM_REFIRE = 0.00;
    private final Double L3_COUNTERMEASURE_MAXIMUM_REFIRE = 0.00;
    
    private final Double L5_COUNTERMEASURE_MINIMUM_ARMOR = 0.00;
    private final Double L5_COUNTERMEASURE_MAXIMUM_ARMOR = 0.00;
    private final Double L5_COUNTERMEASURE_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_COUNTERMEASURE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L5_COUNTERMEASURE_MINIMUM_DRAIN = 0.00;
    private final Double L5_COUNTERMEASURE_MAXIMUM_DRAIN = 0.00;
    private final Double L5_COUNTERMEASURE_MINIMUM_MASS = 0.00;
    private final Double L5_COUNTERMEASURE_MAXIMUM_MASS = 0.00;
    private final Double L5_COUNTERMEASURE_MINIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L5_COUNTERMEASURE_MINIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L5_COUNTERMEASURE_MAXIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L5_COUNTERMEASURE_MAXIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L5_COUNTERMEASURE_MINIMUM_REFIRE = 0.00;
    private final Double L5_COUNTERMEASURE_MAXIMUM_REFIRE = 0.00;
    
    private final Double L7_COUNTERMEASURE_MINIMUM_ARMOR = 0.00;
    private final Double L7_COUNTERMEASURE_MAXIMUM_ARMOR = 0.00;
    private final Double L7_COUNTERMEASURE_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_COUNTERMEASURE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L7_COUNTERMEASURE_MINIMUM_DRAIN = 0.00;
    private final Double L7_COUNTERMEASURE_MAXIMUM_DRAIN = 0.00;
    private final Double L7_COUNTERMEASURE_MINIMUM_MASS = 0.00;
    private final Double L7_COUNTERMEASURE_MAXIMUM_MASS = 0.00;
    private final Double L7_COUNTERMEASURE_MINIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L7_COUNTERMEASURE_MINIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L7_COUNTERMEASURE_MAXIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L7_COUNTERMEASURE_MAXIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L7_COUNTERMEASURE_MINIMUM_REFIRE = 0.00;
    private final Double L7_COUNTERMEASURE_MAXIMUM_REFIRE = 0.00;
    
    private final Double L9_COUNTERMEASURE_MINIMUM_ARMOR = 0.00;
    private final Double L9_COUNTERMEASURE_MAXIMUM_ARMOR = 0.00;
    private final Double L9_COUNTERMEASURE_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_COUNTERMEASURE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L9_COUNTERMEASURE_MINIMUM_DRAIN = 0.00;
    private final Double L9_COUNTERMEASURE_MAXIMUM_DRAIN = 0.00;
    private final Double L9_COUNTERMEASURE_MINIMUM_MASS = 0.00;
    private final Double L9_COUNTERMEASURE_MAXIMUM_MASS = 0.00;
    private final Double L9_COUNTERMEASURE_MINIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L9_COUNTERMEASURE_MINIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L9_COUNTERMEASURE_MAXIMUM_CHANCE_MINIMUM = 0.00;
    private final Double L9_COUNTERMEASURE_MAXIMUM_CHANCE_MAXIMUM = 0.00;
    private final Double L9_COUNTERMEASURE_MINIMUM_REFIRE = 0.00;
    private final Double L9_COUNTERMEASURE_MAXIMUM_REFIRE = 0.00;
    
    private final Double L1_ORDNANCE_MINIMUM_ARMOR = 0.00;
    private final Double L1_ORDNANCE_MAXIMUM_ARMOR = 0.00;
    private final Double L1_ORDNANCE_MINIMUM_HITPOINTS = 0.00;
    private final Double L1_ORDNANCE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L1_ORDNANCE_MINIMUM_DRAIN = 0.00;
    private final Double L1_ORDNANCE_MAXIMUM_DRAIN = 0.00;
    private final Double L1_ORDNANCE_MINIMUM_MASS = 0.00;
    private final Double L1_ORDNANCE_MAXIMUM_MASS = 0.00;
    private final Double L1_ORDNANCE_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L1_ORDNANCE_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L1_ORDNANCE_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L1_ORDNANCE_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L1_ORDNANCE_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L1_ORDNANCE_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L1_ORDNANCE_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L1_ORDNANCE_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L1_ORDNANCE_MINIMUM_REFIRE = 0.00;
    private final Double L1_ORDNANCE_MAXIMUM_REFIRE = 0.00;
    
    private final Double L3_ORDNANCE_MINIMUM_ARMOR = 0.00;
    private final Double L3_ORDNANCE_MAXIMUM_ARMOR = 0.00;
    private final Double L3_ORDNANCE_MINIMUM_HITPOINTS = 0.00;
    private final Double L3_ORDNANCE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L3_ORDNANCE_MINIMUM_DRAIN = 0.00;
    private final Double L3_ORDNANCE_MAXIMUM_DRAIN = 0.00;
    private final Double L3_ORDNANCE_MINIMUM_MASS = 0.00;
    private final Double L3_ORDNANCE_MAXIMUM_MASS = 0.00;
    private final Double L3_ORDNANCE_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L3_ORDNANCE_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L3_ORDNANCE_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L3_ORDNANCE_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L3_ORDNANCE_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L3_ORDNANCE_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L3_ORDNANCE_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L3_ORDNANCE_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L3_ORDNANCE_MINIMUM_REFIRE = 0.00;
    private final Double L3_ORDNANCE_MAXIMUM_REFIRE = 0.00;
    
    private final Double L5_ORDNANCE_MINIMUM_ARMOR = 0.00;
    private final Double L5_ORDNANCE_MAXIMUM_ARMOR = 0.00;
    private final Double L5_ORDNANCE_MINIMUM_HITPOINTS = 0.00;
    private final Double L5_ORDNANCE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L5_ORDNANCE_MINIMUM_DRAIN = 0.00;
    private final Double L5_ORDNANCE_MAXIMUM_DRAIN = 0.00;
    private final Double L5_ORDNANCE_MINIMUM_MASS = 0.00;
    private final Double L5_ORDNANCE_MAXIMUM_MASS = 0.00;
    private final Double L5_ORDNANCE_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L5_ORDNANCE_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L5_ORDNANCE_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L5_ORDNANCE_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L5_ORDNANCE_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L5_ORDNANCE_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L5_ORDNANCE_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L5_ORDNANCE_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L5_ORDNANCE_MINIMUM_REFIRE = 0.00;
    private final Double L5_ORDNANCE_MAXIMUM_REFIRE = 0.00;
    
    private final Double L7_ORDNANCE_MINIMUM_ARMOR = 0.00;
    private final Double L7_ORDNANCE_MAXIMUM_ARMOR = 0.00;
    private final Double L7_ORDNANCE_MINIMUM_HITPOINTS = 0.00;
    private final Double L7_ORDNANCE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L7_ORDNANCE_MINIMUM_DRAIN = 0.00;
    private final Double L7_ORDNANCE_MAXIMUM_DRAIN = 0.00;
    private final Double L7_ORDNANCE_MINIMUM_MASS = 0.00;
    private final Double L7_ORDNANCE_MAXIMUM_MASS = 0.00;
    private final Double L7_ORDNANCE_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L7_ORDNANCE_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L7_ORDNANCE_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L7_ORDNANCE_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L7_ORDNANCE_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L7_ORDNANCE_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L7_ORDNANCE_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L7_ORDNANCE_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L7_ORDNANCE_MINIMUM_REFIRE = 0.00;
    private final Double L7_ORDNANCE_MAXIMUM_REFIRE = 0.00;
    
    private final Double L9_ORDNANCE_MINIMUM_ARMOR = 0.00;
    private final Double L9_ORDNANCE_MAXIMUM_ARMOR = 0.00;
    private final Double L9_ORDNANCE_MINIMUM_HITPOINTS = 0.00;
    private final Double L9_ORDNANCE_MAXIMUM_HITPOINTS = 0.00;
    private final Double L9_ORDNANCE_MINIMUM_DRAIN = 0.00;
    private final Double L9_ORDNANCE_MAXIMUM_DRAIN = 0.00;
    private final Double L9_ORDNANCE_MINIMUM_MASS = 0.00;
    private final Double L9_ORDNANCE_MAXIMUM_MASS = 0.00;
    private final Double L9_ORDNANCE_MINIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L9_ORDNANCE_MINIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L9_ORDNANCE_MAXIMUM_DAMAGE_MINIMUM = 0.00;
    private final Double L9_ORDNANCE_MAXIMUM_DAMAGE_MAXIMUM = 0.00;
    private final Double L9_ORDNANCE_MINIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L9_ORDNANCE_MAXIMUM_VERSUS_SHIELDS = 0.00;
    private final Double L9_ORDNANCE_MINIMUM_VERSUS_ARMOR = 0.00;
    private final Double L9_ORDNANCE_MAXIMUM_VERSUS_ARMOR = 0.00;
    private final Double L9_ORDNANCE_MINIMUM_REFIRE = 0.00;
    private final Double L9_ORDNANCE_MAXIMUM_REFIRE = 0.00;
    
                
    public Validation validateReactor(Validation validation, Reactor reactor) {
                
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
            if(!validateValue(reactor.getGenerationRate(), this.L10_REACTOR_MINIMUM_GENERATION, this.L10_REACTOR_MAXIMUM_GENERATION)) {
                validation.validationResult = false;
                validation.statsInError.add("Generation");
                validation.reasonsForError.add("Invalid generation value...please re-enter.");
            }
        }
        validation.validationResult = true;
        return validation;
    }
    
    public Validation validateEngine(Validation validation, Engine engine) {
                
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
            
        }
        
        return validation;
    }
    
    public Validation validateShield(Validation validation, Shield shield) {
                
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
            
        }
        
        return validation;
    }
    
    public Validation validateBooster(Validation validation, Booster booster) {
                
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
            
        }
        
        return validation;
    }
    
    public Validation validateArmor(Validation validation, Armor armor) {
                
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
            
        }
        
        return validation;
    }
    
    public Validation validateCapacitor(Validation validation, Capacitor capacitor) {
                
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
            
        }
        
        return validation;
    }
    
    public Validation validateInterface(Validation validation, DroidInterface droidInterface) {
                
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
        validation.validationResult = true;
        return validation;
    }
    
    public Validation validateOrdnance(Validation validation, Ordnance ordnance) {
                
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
            
        }
        
        return validation;
    }
    
    public Validation validateCountermeasure(Validation validation, Countermeasure countermeasure) {
                
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
            
        }
        
        return validation;
    }
    
    public Boolean validateValue(Double actual, Double minimum, Double maximum) {
        return actual > minimum && actual < maximum;
    }    
}
