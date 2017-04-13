package jtl.toolkit;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionModel;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;
import jtl.toolkit.helpers.ChassisHelper;
import jtl.toolkit.helpers.ComponentHelper;
import jtl.toolkit.helpers.LoadoutHelper;
import jtl.toolkit.helpers.ValidationHelper;
import jtl.toolkit.models.Armor;
import jtl.toolkit.models.Booster;
import jtl.toolkit.models.Capacitor;
import jtl.toolkit.models.Chassis;
import jtl.toolkit.models.Countermeasure;
import jtl.toolkit.models.DroidInterface;
import jtl.toolkit.models.Engine;
import jtl.toolkit.models.Loadout;
import jtl.toolkit.models.Ordnance;
import jtl.toolkit.models.Reactor;
import jtl.toolkit.models.Shield;
import jtl.toolkit.models.Validation;
import jtl.toolkit.models.Weapon;

public class ToolkitController implements Initializable {
    
    ComponentHelper componentHelper;
    LoadoutHelper loadoutHelper;
    ValidationHelper validationHelper;
    ChassisHelper chassisHelper;
    
    ArrayList<Loadout> loadouts;
    ArrayList<Chassis> chassis;
    
    Loadout currentLoadout;
    
    ArrayList<Reactor> reactors;
    ArrayList<Engine> engines;
    ArrayList<Shield> shields;
    ArrayList<Armor> armors;
    ArrayList<DroidInterface> interfaces;
    ArrayList<Booster> boosters;
    ArrayList<Capacitor> capacitors;
    ArrayList<Weapon> weapons;
    ArrayList<Ordnance> ordnance;
    ArrayList<Countermeasure> countermeasures;
    
    // <editor-fold defaultstate="collapsed" desc="FXML Variables">
    // Tables
    @FXML TableView reactorTable;
    @FXML TableView engineTable;
    @FXML TableView shieldTable;
    @FXML TableView armorTable;
    @FXML TableView capacitorTable;
    @FXML TableView weaponTable;
    @FXML TableView ordnanceTable;
    @FXML TableView countermeasureTable;
    @FXML TableView boosterTable;
    @FXML TableView interfaceTable;
    
    // Image Views
    @FXML ImageView newComponentImage;
    
    // Containers
    @FXML AnchorPane newComponentFieldContainerOne;
    @FXML AnchorPane newComponentFieldContainerTwo;
    @FXML AnchorPane newComponentFieldContainerThree;
    @FXML AnchorPane newComponentFieldContainerFour;
    @FXML AnchorPane newComponentFieldContainerFive;
    @FXML AnchorPane newComponentFieldContainerSix;
    @FXML AnchorPane newComponentFieldContainerSeven;
    @FXML AnchorPane newComponentFieldContainerEight;
    @FXML AnchorPane newComponentFieldContainerNine;
    @FXML AnchorPane newComponentFieldContainerTen;
    @FXML AnchorPane loadoutComponents;
    @FXML AnchorPane loadoutWeaponTwoContainer;
    @FXML AnchorPane loadoutWeaponThreeContainer;
    @FXML AnchorPane loadoutWeaponFourContainer;
    @FXML AnchorPane loadoutOrdnanceTwoContainer;
    @FXML AnchorPane loadoutOrdnanceThreeContainer;
    @FXML TabPane existingComponentsTabPane;
    @FXML Pane createLoadoutPane;
    
    // Labels
    @FXML Label newComponentFieldOneLabel;
    @FXML Label newComponentFieldTwoLabel;
    @FXML Label newComponentFieldThreeLabel;
    @FXML Label newComponentFieldFourLabel;
    @FXML Label newComponentFieldFiveLabel;
    @FXML Label newComponentFieldSixLabel;
    @FXML Label newComponentFieldSevenLabel;
    @FXML Label newComponentFieldEightLabel;
    @FXML Label newComponentFieldNineLabel;
    @FXML Label newComponentFieldTenLabel;
    
    @FXML Label newComponentMessage;
    @FXML Label currentReactorArmor;
    @FXML Label currentReactorHitpoints;
    @FXML Label currentReactorMass;
    @FXML Label currentReactorGeneration;
    @FXML Label currentEngineArmor;
    @FXML Label currentEngineHitpoints;
    @FXML Label currentEngineDrain;
    @FXML Label currentEngineMass;
    @FXML Label currentEnginePitch;
    @FXML Label currentEngineYaw;
    @FXML Label currentEngineRoll;
    @FXML Label currentEngineSpeed;
    @FXML Label currentShieldArmor;
    @FXML Label currentShieldHitpoints;
    @FXML Label currentShieldDrain;
    @FXML Label currentShieldMass;
    @FXML Label currentShieldFrontHitpoints;
    @FXML Label currentShieldBackHitpoints;
    @FXML Label currentShieldRecharge;
    @FXML Label currentCapacitorArmor;
    @FXML Label currentCapacitorHitpoints;
    @FXML Label currentCapacitorDrain;
    @FXML Label currentCapacitorMass;
    @FXML Label currentCapacitorEnergy;
    @FXML Label currentCapacitorRecharge;
    @FXML Label currentBoosterArmor;
    @FXML Label currentBoosterHitpoints;
    @FXML Label currentBoosterDrain;
    @FXML Label currentBoosterMass;
    @FXML Label currentBoosterEnergy;
    @FXML Label currentBoosterRecharge;
    @FXML Label currentBoosterConsumption;
    @FXML Label currentBoosterSpeed;
    @FXML Label currentInterfaceArmor;
    @FXML Label currentInterfaceHitpoints;
    @FXML Label currentInterfaceDrain;
    @FXML Label currentInterfaceMass;
    @FXML Label currentInterfaceSpeed;
    @FXML Label currentFrontArmorArmor;
    @FXML Label currentFrontArmorHitpoints;
    @FXML Label currentFrontArmorMass;
    @FXML Label currentBackArmorArmor;
    @FXML Label currentBackArmorHitpoints;
    @FXML Label currentBackArmorMass;
    @FXML Label currentWeaponOneArmor;
    @FXML Label currentWeaponOneHitpoints;
    @FXML Label currentWeaponOneDrain;
    @FXML Label currentWeaponOneMass;
    @FXML Label currentWeaponOneMinimumDamage;
    @FXML Label currentWeaponOneMaximumDamage;
    @FXML Label currentWeaponOneVersusShields;
    @FXML Label currentWeaponOneVersusArmor;
    @FXML Label currentWeaponOneRefire;
    @FXML Label currentWeaponOneEPS;
    @FXML Label currentWeaponTwoArmor;
    @FXML Label currentWeaponTwoHitpoints;
    @FXML Label currentWeaponTwoDrain;
    @FXML Label currentWeaponTwoMass;
    @FXML Label currentWeaponTwoMinimumDamage;
    @FXML Label currentWeaponTwoMaximumDamage;
    @FXML Label currentWeaponTwoVersusShields;
    @FXML Label currentWeaponTwoVersusArmor;
    @FXML Label currentWeaponTwoRefire;
    @FXML Label currentWeaponTwoEPS;
    @FXML Label currentWeaponThreeArmor;
    @FXML Label currentWeaponThreeHitpoints;
    @FXML Label currentWeaponThreeDrain;
    @FXML Label currentWeaponThreeMass;
    @FXML Label currentWeaponThreeMinimumDamage;
    @FXML Label currentWeaponThreeMaximumDamage;
    @FXML Label currentWeaponThreeVersusShields;
    @FXML Label currentWeaponThreeVersusArmor;
    @FXML Label currentWeaponThreeRefire;
    @FXML Label currentWeaponThreeEPS;
    @FXML Label currentWeaponFourArmor;
    @FXML Label currentWeaponFourHitpoints;
    @FXML Label currentWeaponFourDrain;
    @FXML Label currentWeaponFourMass;
    @FXML Label currentWeaponFourMinimumDamage;
    @FXML Label currentWeaponFourMaximumDamage;
    @FXML Label currentWeaponFourVersusShields;
    @FXML Label currentWeaponFourVersusArmor;
    @FXML Label currentWeaponFourRefire;
    @FXML Label currentWeaponFourEPS;
    @FXML Label currentOrdnanceOneArmor;
    @FXML Label currentOrdnanceOneHitpoints;
    @FXML Label currentOrdnanceOneDrain;
    @FXML Label currentOrdnanceOneMass;
    @FXML Label currentOrdnanceOneMinimumDamage;
    @FXML Label currentOrdnanceOneMaximumDamage;
    @FXML Label currentOrdnanceOneVersusShields;
    @FXML Label currentOrdnanceOneVersusArmor;
    @FXML Label currentOrdnanceOneRefire;
    @FXML Label currentOrdnanceTwoArmor;
    @FXML Label currentOrdnanceTwoHitpoints;
    @FXML Label currentOrdnanceTwoDrain;
    @FXML Label currentOrdnanceTwoMass;
    @FXML Label currentOrdnanceTwoMinimumDamage;
    @FXML Label currentOrdnanceTwoMaximumDamage;
    @FXML Label currentOrdnanceTwoVersusShields;
    @FXML Label currentOrdnanceTwoVersusArmor;
    @FXML Label currentOrdnanceTwoRefire;
    @FXML Label currentOrdnanceThreeArmor;
    @FXML Label currentOrdnanceThreeHitpoints;
    @FXML Label currentOrdnanceThreeDrain;
    @FXML Label currentOrdnanceThreeMass;
    @FXML Label currentOrdnanceThreeMinimumDamage;
    @FXML Label currentOrdnanceThreeMaximumDamage;
    @FXML Label currentOrdnanceThreeVersusShields;
    @FXML Label currentOrdnanceThreeVersusArmor;
    @FXML Label currentOrdnanceThreeRefire;
    @FXML Label currentCountermeasureArmor;
    @FXML Label currentCountermeasureHitpoints;
    @FXML Label currentCountermeasureDrain;
    @FXML Label currentCountermeasureMass;
    @FXML Label currentCountermeasureMinimumChance;
    @FXML Label currentCountermeasureMaximumChance;
    @FXML Label currentCountermeasureRefire;
    
    // Text Fields
    @FXML TextField newComponentFieldOneTextbox;
    @FXML TextField newComponentFieldTwoTextbox;
    @FXML TextField newComponentFieldThreeTextbox;
    @FXML TextField newComponentFieldFourTextbox;
    @FXML TextField newComponentFieldFiveTextbox;
    @FXML TextField newComponentFieldSixTextbox;
    @FXML TextField newComponentFieldSevenTextbox;
    @FXML TextField newComponentFieldEightTextbox;
    @FXML TextField newComponentFieldNineTextbox;
    @FXML TextField newComponentFieldTenTextbox;
    @FXML TextField chassisMass;
    @FXML TextField loadoutName;
    
    @FXML TextField newComponentName;
    @FXML TextArea newComponentNotes;
    
    // Buttons
    @FXML Button saveComponentButton;
    @FXML Button clearNewComponentFieldsButton;
    @FXML Button removeComponentButton;
    @FXML Button saveLoadoutButton;
    @FXML Button clearComponentsButton;
    @FXML Button deleteLoadoutButton;
    @FXML Button createLoadoutButton;
    
    // Combo Boxes
    @FXML ComboBox chassisSelection;
    @FXML ComboBox loadoutSelection;
    @FXML ComboBox newComponentType;
    @FXML ComboBox newComponentLevel;
    @FXML ComboBox loadoutReactor;
    @FXML ComboBox loadoutEngine;
    @FXML ComboBox loadoutShield;
    @FXML ComboBox loadoutBooster;
    @FXML ComboBox loadoutInterface;
    @FXML ComboBox loadoutFrontArmor;
    @FXML ComboBox loadoutBackArmor;
    @FXML ComboBox loadoutCapacitor;
    @FXML ComboBox loadoutWeaponOne;
    @FXML ComboBox loadoutWeaponTwo;
    @FXML ComboBox loadoutWeaponThree;
    @FXML ComboBox loadoutWeaponFour;
    @FXML ComboBox loadoutCountermeasure;
    @FXML ComboBox loadoutOrdnanceOne;
    @FXML ComboBox loadoutOrdnanceTwo;
    @FXML ComboBox loadoutOrdnanceThree;
    
    // </editor-fold>
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        componentHelper = new ComponentHelper();
        loadoutHelper = new LoadoutHelper();
        validationHelper = new ValidationHelper();
        chassisHelper = new ChassisHelper();
        
        loadChassis();
        loadComponents();
        loadLoadouts();
        
        if(loadouts == null || loadouts.isEmpty()) {
            createLoadoutPane.setVisible(true);
            loadoutSelection.setDisable(true);
        } else {
            createLoadoutButton.setDisable(false);
        }
        
        reloadComponentTables();
        
        reactorTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setVisible(true);
        });
    }    
    
    @FXML
    private void saveNewComponent(ActionEvent event) {
        
        String componentType = (String) newComponentType.getValue();
        
        Validation validation = validateInputTypes();
        
        if(validation.validationResult.equals(false)){
            
            newComponentMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            newComponentMessage.setText("Component values must only contain numbers...");
            
        } else if(newComponentName.getText().length() > 0) {
            
            newComponentName.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
            
            if(componentType.equals("Reactor")){
                
                Reactor reactor = new Reactor();

                reactor.setComponentName(newComponentName.getText());
                reactor.setComponentNotes(newComponentNotes.getText());
                reactor.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                reactor.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                reactor.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                reactor.setMass(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                reactor.setGenerationRate(Double.parseDouble(newComponentFieldFourTextbox.getText()));

                validation = validationHelper.validateReactor(validation, reactor);

                if(validation.validationResult){

                    reactors.add(reactor);

                    componentHelper.saveReactors(reactors);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                }
                
            }else if(componentType.equals("Engine")){
                    
                Engine engine = new Engine();

                engine.setComponentName(newComponentName.getText());
                engine.setComponentNotes(newComponentNotes.getText());
                engine.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                engine.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                engine.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                engine.setEnergyDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                engine.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                engine.setPitchRate(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                engine.setYawRate(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                engine.setRollRate(Double.parseDouble(newComponentFieldSevenTextbox.getText()));
                engine.setTopSpeed(Double.parseDouble(newComponentFieldEightTextbox.getText()));

                validation = validationHelper.validateEngine(validation, engine);

                if(validation.validationResult){

                    engines.add(engine);

                    componentHelper.saveEngines(engines);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                }
                    
            }else if(componentType.equals("Shield")){
                
                Shield shield = new Shield();

                shield.setComponentName(newComponentName.getText());
                shield.setComponentNotes(newComponentNotes.getText());
                shield.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                shield.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                shield.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                shield.setEnergyDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                shield.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                shield.setFrontHitpoints(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                shield.setBackHitpoints(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                shield.setRechargeRate(Double.parseDouble(newComponentFieldSevenTextbox.getText()));

                validation = validationHelper.validateShield(validation, shield);

                if(validation.validationResult){

                    shields.add(shield);

                    componentHelper.saveShields(shields);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                }
                
            }else if(componentType.equals("Armor")){

                Armor armor = new Armor();

                armor.setComponentName(newComponentName.getText());
                armor.setComponentNotes(newComponentNotes.getText());
                armor.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                armor.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                armor.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                armor.setMass(Double.parseDouble(newComponentFieldThreeTextbox.getText()));

                validation = validationHelper.validateArmor(validation, armor);

                if(validation.validationResult){

                    armors.add(armor);

                    componentHelper.saveArmors(armors);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                }
                    
            }else if(componentType.equals("Droid Interface")){

                DroidInterface droidInterface = new DroidInterface();

                droidInterface.setComponentName(newComponentName.getText());
                droidInterface.setComponentNotes(newComponentNotes.getText());
                droidInterface.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                droidInterface.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                droidInterface.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                droidInterface.setEnergyDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                droidInterface.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                droidInterface.setCommandSpeed(Double.parseDouble(newComponentFieldFiveTextbox.getText()));

                validation = validationHelper.validateInterface(validation, droidInterface);

                if(validation.validationResult){

                    interfaces.add(droidInterface);

                    componentHelper.saveInterfaces(interfaces);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                }
                
            }else if(componentType.equals("Weapon")){
                
                Weapon weapon = new Weapon();

                weapon.setComponentName(newComponentName.getText());
                weapon.setComponentNotes(newComponentNotes.getText());
                weapon.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                weapon.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                weapon.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                weapon.setEnergyDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                weapon.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                weapon.setMinimumDamage(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                weapon.setMaximumDamage(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                weapon.setVersusShields(Double.parseDouble(newComponentFieldSevenTextbox.getText()));
                weapon.setVersusArmor(Double.parseDouble(newComponentFieldEightTextbox.getText()));
                weapon.setEnergyPerShot(Double.parseDouble(newComponentFieldNineTextbox.getText()));
                weapon.setRefireRate(Double.parseDouble(newComponentFieldTenTextbox.getText()));

                validation = validationHelper.validateWeapon(validation, weapon);

                if(validation.validationResult){

                    weapons.add(weapon);

                    componentHelper.saveWeapons(weapons);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                }  
                
            }else if(componentType.equals("Ordnance")){

                Ordnance ordnanceLauncher = new Ordnance();

                ordnanceLauncher.setComponentName(newComponentName.getText());
                ordnanceLauncher.setComponentNotes(newComponentNotes.getText());
                ordnanceLauncher.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                ordnanceLauncher.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                ordnanceLauncher.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                ordnanceLauncher.setEnergyDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                ordnanceLauncher.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                ordnanceLauncher.setMinimumDamage(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                ordnanceLauncher.setMaximumDamage(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                ordnanceLauncher.setVersusShields(Double.parseDouble(newComponentFieldSevenTextbox.getText()));
                ordnanceLauncher.setVersusArmor(Double.parseDouble(newComponentFieldEightTextbox.getText()));
                ordnanceLauncher.setRefireRate(Double.parseDouble(newComponentFieldNineTextbox.getText()));

                validation = validationHelper.validateOrdnance(validation, ordnanceLauncher);

                if(validation.validationResult){

                    ordnance.add(ordnanceLauncher);

                    componentHelper.saveOrdnance(ordnance);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                } 
                
            }else if(componentType.equals("Countermeasure")){

                Countermeasure countermeasure = new Countermeasure();

                countermeasure.setComponentName(newComponentName.getText());
                countermeasure.setComponentNotes(newComponentNotes.getText());
                countermeasure.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                countermeasure.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                countermeasure.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                countermeasure.setEnergyDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                countermeasure.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                countermeasure.setMinimumChance(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                countermeasure.setMaximumChance(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                countermeasure.setRefireRate(Double.parseDouble(newComponentFieldSevenTextbox.getText()));

                validation = validationHelper.validateCountermeasure(validation, countermeasure);

                if(validation.validationResult){

                    countermeasures.add(countermeasure);

                    componentHelper.saveCountermeasures(countermeasures);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                } 
                
            }else if(componentType.equals("Booster")){

                Booster booster = new Booster();

                booster.setComponentName(newComponentName.getText());
                booster.setComponentNotes(newComponentNotes.getText());
                booster.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                booster.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                booster.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                booster.setEnergyDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                booster.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                booster.setEnergy(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                booster.setRechargeRate(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                booster.setConsumptionRate(Double.parseDouble(newComponentFieldSevenTextbox.getText()));
                booster.setTopSpeed(Double.parseDouble(newComponentFieldEightTextbox.getText()));

                
                validation = validationHelper.validateBooster(validation, booster);

                if(validation.validationResult){

                    boosters.add(booster);

                    componentHelper.saveBoosters(boosters);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                }
                
            }else if(componentType.equals("Capacitor")){ 

                Capacitor capacitor = new Capacitor();
                
                capacitor.setComponentName(newComponentName.getText());
                capacitor.setComponentNotes(newComponentNotes.getText());
                capacitor.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                capacitor.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                capacitor.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                capacitor.setEnergyDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                capacitor.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                capacitor.setEnergy(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                capacitor.setRechargeRate(Double.parseDouble(newComponentFieldSixTextbox.getText()));

                
                validation = validationHelper.validateCapacitor(validation, capacitor);

                if(validation.validationResult){

                    capacitors.add(capacitor);

                    componentHelper.saveCapacitors(capacitors);

                    reloadComponentTables();

                    newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    newComponentMessage.setText("Component saved...");

                } else {
                    for(int i = 0; i < validation.statsInError.size(); i++) {
                        System.out.println(validation.statsInError.get(i));
                        System.out.println(validation.reasonsForError.get(i));
                    }
                }
            }
            
            loadComponents();
            
        } else {
            newComponentMessage.setText("You must provide a component name...");
            newComponentMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }
    
    @FXML
    private void showNewComponentFields(ActionEvent event) {
        
        String componentType = (String) newComponentType.getValue();
        SingleSelectionModel<Tab> selectionModel = existingComponentsTabPane.getSelectionModel();
        
        if(componentType.equals("Reactor")){
            resetFields();
            selectionModel.select(0);
            newComponentImage.setImage(new Image("images/asset_reactor.png"));
            
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Mass:");
            newComponentFieldFourLabel.setText("Generation Rate:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            newComponentFieldContainerFour.setVisible(true);
            
        }else if(componentType.equals("Engine")){
            resetFields();
            selectionModel.select(1);
            newComponentImage.setImage(new Image("images/asset_engine.png"));
            
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Energy Drain:");
            newComponentFieldFourLabel.setText("Mass:");
            newComponentFieldFiveLabel.setText("Pitch Rate:");
            newComponentFieldSixLabel.setText("Yaw Rate:");
            newComponentFieldSevenLabel.setText("Roll Rate:");
            newComponentFieldEightLabel.setText("Top Speed:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            newComponentFieldContainerFour.setVisible(true);
            newComponentFieldContainerFive.setVisible(true);
            newComponentFieldContainerSix.setVisible(true);
            newComponentFieldContainerSeven.setVisible(true);
            newComponentFieldContainerEight.setVisible(true);
            
        }else if(componentType.equals("Shield")){
            resetFields();
            selectionModel.select(2);
            newComponentImage.setImage(new Image("images/asset_shield.png"));
                 
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Energy Drain:");
            newComponentFieldFourLabel.setText("Mass:");
            newComponentFieldFiveLabel.setText("Front Hitpoints:");
            newComponentFieldSixLabel.setText("Back Hitpoints:");
            newComponentFieldSevenLabel.setText("Recharge Rate:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            newComponentFieldContainerFour.setVisible(true);
            newComponentFieldContainerFive.setVisible(true);
            newComponentFieldContainerSix.setVisible(true);
            newComponentFieldContainerSeven.setVisible(true);
            
        }else if(componentType.equals("Armor")){
            resetFields();
            selectionModel.select(3);
            newComponentImage.setImage(new Image("images/asset_armor.png"));
            
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Mass:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            
        }else if(componentType.equals("Droid Interface")){
            resetFields();
            selectionModel.select(6);
            newComponentImage.setImage(new Image("images/asset_droid_interface.png"));
            
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Energy Drain:");
            newComponentFieldFourLabel.setText("Mass:");
            newComponentFieldFiveLabel.setText("Command Speed:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            newComponentFieldContainerFour.setVisible(true);
            newComponentFieldContainerFive.setVisible(true);
            
        }else if(componentType.equals("Weapon")){
            resetFields();
            selectionModel.select(7);
            newComponentImage.setImage(new Image("images/asset_weapon.png"));
            
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Energy Drain:");
            newComponentFieldFourLabel.setText("Mass:");
            newComponentFieldFiveLabel.setText("Minimum Damage:");
            newComponentFieldSixLabel.setText("Maximum Damage:");
            newComponentFieldSevenLabel.setText("Vs. Shields:");
            newComponentFieldEightLabel.setText("Vs. Armor:");
            newComponentFieldNineLabel.setText("Energy Per Shot:");
            newComponentFieldTenLabel.setText("Refire Rate:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            newComponentFieldContainerFour.setVisible(true);
            newComponentFieldContainerFive.setVisible(true);
            newComponentFieldContainerSix.setVisible(true);
            newComponentFieldContainerSeven.setVisible(true);
            newComponentFieldContainerEight.setVisible(true);
            newComponentFieldContainerNine.setVisible(true);
            newComponentFieldContainerTen.setVisible(true);
            
        }else if(componentType.equals("Ordnance")){
            resetFields();
            selectionModel.select(8);
            newComponentImage.setImage(new Image("images/asset_ordnance.png"));
            
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Energy Drain:");
            newComponentFieldFourLabel.setText("Mass:");
            newComponentFieldFiveLabel.setText("Minimum Damage:");
            newComponentFieldSixLabel.setText("Maximum Damage:");
            newComponentFieldSevenLabel.setText("Vs. Shields:");
            newComponentFieldEightLabel.setText("Vs. Armor:");
            newComponentFieldNineLabel.setText("Refire Rate:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            newComponentFieldContainerFour.setVisible(true);
            newComponentFieldContainerFive.setVisible(true);
            newComponentFieldContainerSix.setVisible(true);
            newComponentFieldContainerSeven.setVisible(true);
            newComponentFieldContainerEight.setVisible(true);
            newComponentFieldContainerNine.setVisible(true);
            
        }else if(componentType.equals("Countermeasure")){
            resetFields();
            selectionModel.select(9);
            newComponentImage.setImage(new Image("images/asset_ordnance.png"));
            
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Energy Drain:");
            newComponentFieldFourLabel.setText("Mass:");
            newComponentFieldFiveLabel.setText("Minimum Chance:");
            newComponentFieldSixLabel.setText("Maximum Chance:");
            newComponentFieldSevenLabel.setText("Refire Rate:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            newComponentFieldContainerFour.setVisible(true);
            newComponentFieldContainerFive.setVisible(true);
            newComponentFieldContainerSix.setVisible(true);
            newComponentFieldContainerSeven.setVisible(true);
            
        }else if(componentType.equals("Booster")){
            resetFields();
            selectionModel.select(5);
            newComponentImage.setImage(new Image("images/asset_booster.png"));
            
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Energy Drain:");
            newComponentFieldFourLabel.setText("Mass:");
            newComponentFieldFiveLabel.setText("Energy:");
            newComponentFieldSixLabel.setText("Recharge Rate:");
            newComponentFieldSevenLabel.setText("Consumption Rate:");
            newComponentFieldEightLabel.setText("Top Speed:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            newComponentFieldContainerFour.setVisible(true);
            newComponentFieldContainerFive.setVisible(true);
            newComponentFieldContainerSix.setVisible(true);
            newComponentFieldContainerSeven.setVisible(true);
            newComponentFieldContainerEight.setVisible(true);
            
        }else if(componentType.equals("Capacitor")){
            resetFields();
            selectionModel.select(4);
            newComponentImage.setImage(new Image("images/asset_capacitor.png"));
            
            // Set labels
            newComponentFieldOneLabel.setText("Armor:");
            newComponentFieldTwoLabel.setText("Hitpoints:");
            newComponentFieldThreeLabel.setText("Energy Drain:");
            newComponentFieldFourLabel.setText("Mass:");
            newComponentFieldFiveLabel.setText("Energy:");
            newComponentFieldSixLabel.setText("Recharge Rate:");
            
            // Show fields
            newComponentFieldContainerOne.setVisible(true);
            newComponentFieldContainerTwo.setVisible(true);
            newComponentFieldContainerThree.setVisible(true);
            newComponentFieldContainerFour.setVisible(true);
            newComponentFieldContainerFive.setVisible(true);
            newComponentFieldContainerSix.setVisible(true);
        }
    }
    
    // Utility functions
    public void resetFields(){
        newComponentFieldOneTextbox.setText("0.0");
        newComponentFieldTwoTextbox.setText("0.0");
        newComponentFieldThreeTextbox.setText("0.0");
        newComponentFieldFourTextbox.setText("0.0");
        newComponentFieldFiveTextbox.setText("0.0");
        newComponentFieldSixTextbox.setText("0.0");
        newComponentFieldSevenTextbox.setText("0.0");
        newComponentFieldEightTextbox.setText("0.0");
        newComponentFieldNineTextbox.setText("0.0");
        newComponentFieldTenTextbox.setText("0.0");
        
        newComponentFieldContainerOne.setVisible(false);
        newComponentFieldContainerTwo.setVisible(false);
        newComponentFieldContainerThree.setVisible(false);
        newComponentFieldContainerFour.setVisible(false);
        newComponentFieldContainerFive.setVisible(false);
        newComponentFieldContainerSix.setVisible(false);
        newComponentFieldContainerSeven.setVisible(false);
        newComponentFieldContainerEight.setVisible(false);
        newComponentFieldContainerNine.setVisible(false);
        newComponentFieldContainerTen.setVisible(false);
    }
    
    public boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public Validation validateInputTypes() {
        
        Validation validation = new Validation();
        
        validation.componentLevel = Integer.parseInt(newComponentLevel.getValue().toString());
        validation.componentType = (String) newComponentType.getValue();
        
        String fieldOne = newComponentFieldOneTextbox.getText();
        String fieldTwo = newComponentFieldTwoTextbox.getText();
        String fieldThree = newComponentFieldThreeTextbox.getText();
        String fieldFour = newComponentFieldFourTextbox.getText();
        String fieldFive = newComponentFieldFiveTextbox.getText();
        String fieldSix = newComponentFieldSixTextbox.getText();
        String fieldSeven = newComponentFieldSevenTextbox.getText();
        String fieldEight = newComponentFieldEightTextbox.getText();
        String fieldNine = newComponentFieldNineTextbox.getText();
        String fieldTen = newComponentFieldTenTextbox.getText();
        
        if(isDouble(fieldOne) || isInteger(fieldOne)) {
            newComponentFieldOneTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldOneTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldTwo) || isInteger(fieldTwo)) {
            newComponentFieldTwoTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldTwoTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldThree) || isInteger(fieldThree)) {
            newComponentFieldThreeTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldThreeTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldFour) || isInteger(fieldFour)) {
            newComponentFieldFourTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldFourTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldFive) || isInteger(fieldFive)) {
            newComponentFieldFiveTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldFiveTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldSix) || isInteger(fieldSix)) {
            newComponentFieldSixTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldSixTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldSeven) || isInteger(fieldSeven)) { 
            newComponentFieldSevenTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldSevenTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldEight) || isInteger(fieldEight)) {
            newComponentFieldEightTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldEightTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldNine) || isInteger(fieldNine)) {
            newComponentFieldNineTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldNineTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldTen) || isInteger(fieldTen)) {
            newComponentFieldTenTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            newComponentFieldTenTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        return validation;
    }
    
    private void reloadComponentTables() {
        if(reactors !=  null && reactorTable != null) reactorTable.setItems(FXCollections.observableArrayList(reactors));
        if(engines !=  null && engineTable != null) engineTable.setItems(FXCollections.observableArrayList(engines));
        if(shields !=  null && shieldTable != null) shieldTable.setItems(FXCollections.observableArrayList(shields));
        if(armors !=  null && armorTable != null) armorTable.setItems(FXCollections.observableArrayList(armors));
        if(boosters !=  null && boosterTable != null) boosterTable.setItems(FXCollections.observableArrayList(boosters));
        if(capacitors !=  null && capacitorTable != null) capacitorTable.setItems(FXCollections.observableArrayList(capacitors));
        if(interfaces !=  null && interfaceTable != null) interfaceTable.setItems(FXCollections.observableArrayList(interfaces));
        if(weapons !=  null && weaponTable != null) weaponTable.setItems(FXCollections.observableArrayList(weapons));
        if(ordnance !=  null && ordnanceTable != null) ordnanceTable.setItems(FXCollections.observableArrayList(ordnance));
        if(countermeasures !=  null && countermeasureTable != null) countermeasureTable.setItems(FXCollections.observableArrayList(countermeasures));
    }
    
    @FXML
    private void removeComponent() {
        // TODO: get current table and switch
        Integer tabIndex = existingComponentsTabPane.getSelectionModel().getSelectedIndex();
        
        switch(tabIndex) {
            case 0 :
                Reactor reactor = (Reactor) reactorTable.getSelectionModel().getSelectedItem();
                reactors = componentHelper.deleteReactor(reactors, reactor.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Reactor", reactor.getComponentID());
                reloadComponentTables();
                break;
            case 1 :
                Engine engine = (Engine) engineTable.getSelectionModel().getSelectedItem();
                engines = componentHelper.deleteEngine(engines, engine.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Engine", engine.getComponentID());
                reloadComponentTables();
                break;
            case 2 :
                Shield shield = (Shield) shieldTable.getSelectionModel().getSelectedItem();
                shields = componentHelper.deleteShield(shields, shield.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Shield", shield.getComponentID());
                reloadComponentTables();
                break;
            case 3 :
                Armor armor = (Armor) armorTable.getSelectionModel().getSelectedItem();
                armors = componentHelper.deleteArmor(armors, armor.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Armor", armor.getComponentID());
                reloadComponentTables();
                break;
            case 4 :
                Capacitor capacitor = (Capacitor) capacitorTable.getSelectionModel().getSelectedItem();
                capacitors = componentHelper.deleteCapacitor(capacitors, capacitor.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Capacitor", capacitor.getComponentID());
                reloadComponentTables();
                break;
            case 5 :
                Booster booster = (Booster) boosterTable.getSelectionModel().getSelectedItem();
                boosters = componentHelper.deleteBooster(boosters, booster.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Booster", booster.getComponentID());
                reloadComponentTables();
                break;
            case 6 :
                DroidInterface droidInterface = (DroidInterface) interfaceTable.getSelectionModel().getSelectedItem();
                interfaces = componentHelper.deleteInterface(interfaces, droidInterface.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Interface", droidInterface.getComponentID());
                reloadComponentTables();
                break;
            case 7 :
                Weapon weapon = (Weapon) weaponTable.getSelectionModel().getSelectedItem();
                weapons = componentHelper.deleteWeapon(weapons, weapon.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Weapon", weapon.getComponentID());
                reloadComponentTables();
                break;
            case 8 :
                Ordnance ordnanceLauncher = (Ordnance) ordnanceTable.getSelectionModel().getSelectedItem();
                ordnance = componentHelper.deleteOrdnance(ordnance, ordnanceLauncher.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Ordnance", ordnanceLauncher.getComponentID());
                reloadComponentTables();
                break;
            case 9 :
                Countermeasure countermeasure = (Countermeasure) countermeasureTable.getSelectionModel().getSelectedItem();
                countermeasures = componentHelper.deleteCountermeasure(countermeasures, countermeasure.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Countermeasure", countermeasure.getComponentID());
                reloadComponentTables();
                break;
        }
        
        reloadComponentTables();
        removeComponentButton.setVisible(false);
    }
    
    @FXML
    public void reloadCalculations() {
        
        
    }
    
    @FXML
    public void saveLoadout() {
        
        Reactor reactor = (Reactor) loadoutReactor.getValue();
        if(reactor != null) currentLoadout.setReactorID(reactor.getComponentID());
        
        Engine engine = (Engine) loadoutEngine.getValue();
        if(engine != null) currentLoadout.setEngineID(engine.getComponentID());
        
        Shield shield = (Shield) loadoutShield.getValue();
        if(shield != null) currentLoadout.setShieldID(shield.getComponentID());
        
        Booster booster = (Booster) loadoutBooster.getValue();
        if(booster != null) currentLoadout.setBoosterID(booster.getComponentID());
        
        Capacitor capacitor = (Capacitor) loadoutCapacitor.getValue();
        if(capacitor != null) currentLoadout.setCapacitorID(capacitor.getComponentID());
        
        DroidInterface droidInterface = (DroidInterface) loadoutInterface.getValue();
        if(droidInterface != null) currentLoadout.setDroidInterfaceID(droidInterface.getComponentID());

        Armor frontArmor = (Armor) loadoutFrontArmor.getValue();
        if(frontArmor != null) currentLoadout.setArmorFrontID(frontArmor.getComponentID());
        
        Armor backArmor = (Armor) loadoutBackArmor.getValue();
        if(backArmor != null) currentLoadout.setArmorBackID(backArmor.getComponentID());
        
        Countermeasure countermeasure = (Countermeasure) loadoutCountermeasure.getValue();
        if(countermeasure != null) currentLoadout.setCountermeasureID(countermeasure.getComponentID());
        
        Weapon weaponOne = (Weapon) loadoutWeaponOne.getValue();
        Weapon weaponTwo = (Weapon) loadoutWeaponTwo.getValue();
        Weapon weaponThree = (Weapon) loadoutWeaponThree.getValue();
        Weapon weaponFour = (Weapon) loadoutWeaponFour.getValue();
        
        ArrayList<UUID> weaponIDs = new ArrayList<>();
        if(weaponOne != null) weaponIDs.add(weaponOne.getComponentID());
        if(weaponTwo != null) weaponIDs.add(weaponTwo.getComponentID());
        if(weaponThree != null) weaponIDs.add(weaponThree.getComponentID());
        if(weaponFour != null) weaponIDs.add(weaponFour.getComponentID());
        
        currentLoadout.setWeaponIDs(weaponIDs);
        
        Ordnance ordnanceOne = (Ordnance) loadoutOrdnanceOne.getValue();
        Ordnance ordnanceTwo = (Ordnance) loadoutOrdnanceTwo.getValue();
        Ordnance ordnanceThree = (Ordnance) loadoutOrdnanceThree.getValue();
        
        ArrayList<UUID> ordnanceIDs = new ArrayList<>();
        if(ordnanceOne != null) ordnanceIDs.add(ordnanceOne.getComponentID());
        if(ordnanceTwo != null) ordnanceIDs.add(ordnanceTwo.getComponentID());
        if(ordnanceThree != null) ordnanceIDs.add(ordnanceThree.getComponentID());
        
        currentLoadout.setOrdnanceIDs(ordnanceIDs);
        
        // TODO: do we need this?
        Boolean existingLoadout = false;
        for(int i = 0; i < loadouts.size(); i++) {
            if(currentLoadout.getLoadoutID().equals(loadouts.get(i).getLoadoutID())){
                existingLoadout = true;
                loadouts.set(i, currentLoadout);
            }
        }
        
        if(!existingLoadout){
            loadouts.add(currentLoadout);
        }
        
        loadoutHelper.saveLoadouts(loadouts);
    }
    
    public void loadComponents() {
        
        reactors = componentHelper.getReactors();
        loadoutReactor.setItems(FXCollections.observableList(reactors));
        loadoutReactor.setConverter(new StringConverter<Reactor>() {
            @Override
            public String toString(Reactor reactor) {
                if (reactor == null) {
                    return "Unable to retrieve reactor...";
                } else {
                    return "L" + reactor.getLevel() + " - " + reactor.getComponentName();
                }
            }

            @Override
            public Reactor fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        engines = componentHelper.getEngines();
        loadoutEngine.setItems(FXCollections.observableList(engines));
        
        loadoutEngine.setConverter(new StringConverter<Engine>() {
            @Override
            public String toString(Engine engine) {
                if (engine == null) {
                    return "Unable to retrieve engine...";
                } else {
                    return "L" + engine.getLevel() + " - " + engine.getComponentName();
                }
            }

            @Override
            public Engine fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        shields = componentHelper.getShields();
        loadoutShield.setItems(FXCollections.observableList(shields));
        loadoutShield.setConverter(new StringConverter<Shield>() {
            @Override
            public String toString(Shield shield) {
                if (shield == null) {
                    return "Unable to retrieve shield...";
                } else {
                    return "L" + shield.getLevel() + " - " + shield.getComponentName();
                }
            }

            @Override
            public Shield fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        armors = componentHelper.getArmors();
        loadoutFrontArmor.setItems(FXCollections.observableList(armors));
        loadoutFrontArmor.setConverter(new StringConverter<Armor>() {
            @Override
            public String toString(Armor armor) {
                if (armor == null) {
                    return "Unable to retrieve armor...";
                } else {
                    return "L" + armor.getLevel() + " - " + armor.getComponentName();
                }
            }

            @Override
            public Armor fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        loadoutBackArmor.setItems(FXCollections.observableList(armors));
        loadoutBackArmor.setConverter(new StringConverter<Armor>() {
            @Override
            public String toString(Armor armor) {
                if (armor == null) {
                    return "Unable to retrieve armor...";
                } else {
                    return "L" + armor.getLevel() + " - " + armor.getComponentName();
                }
            }

            @Override
            public Armor fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        boosters = componentHelper.getBoosters();
        loadoutBooster.setItems(FXCollections.observableList(boosters));
        loadoutBooster.setConverter(new StringConverter<Booster>() {
            @Override
            public String toString(Booster booster) {
                if (booster == null) {
                    return "Unable to retrieve booster...";
                } else {
                    return "L" + booster.getLevel() + " - " + booster.getComponentName();
                }
            }

            @Override
            public Booster fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        capacitors = componentHelper.getCapacitors();
        loadoutCapacitor.setItems(FXCollections.observableList(capacitors));
        loadoutCapacitor.setConverter(new StringConverter<Capacitor>() {
            @Override
            public String toString(Capacitor capacitor) {
                if (capacitor == null) {
                    return "Unable to retrieve capacitor...";
                } else {
                    return "L" + capacitor.getLevel() + " - " + capacitor.getComponentName();
                }
            }

            @Override
            public Capacitor fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        interfaces = componentHelper.getInterfaces();        
        loadoutInterface.setItems(FXCollections.observableList(interfaces));
        loadoutInterface.setConverter(new StringConverter<DroidInterface>() {
            @Override
            public String toString(DroidInterface droidInterface) {
                if (droidInterface == null) {
                    return "Unable to retrieve shield...";
                } else {
                    return "L" + droidInterface.getLevel() + " - " + droidInterface.getComponentName();
                }
            }

            @Override
            public DroidInterface fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        weapons = componentHelper.getWeapons();        
        loadoutWeaponOne.setItems(FXCollections.observableList(weapons));
        loadoutWeaponOne.setConverter(new StringConverter<Weapon>() {
            @Override
            public String toString(Weapon weapon) {
                if (weapon == null) {
                    return "Unable to retrieve weapon...";
                } else {
                    return "L" + weapon.getLevel() + " - " + weapon.getComponentName();
                }
            }

            @Override
            public Weapon fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        loadoutWeaponTwo.setItems(FXCollections.observableList(weapons));
        loadoutWeaponTwo.setConverter(new StringConverter<Weapon>() {
            @Override
            public String toString(Weapon weapon) {
                if (weapon == null) {
                    return "Unable to retrieve weapon...";
                } else {
                    return "L" + weapon.getLevel() + " - " + weapon.getComponentName();
                }
            }

            @Override
            public Weapon fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        loadoutWeaponThree.setItems(FXCollections.observableList(weapons));
        loadoutWeaponThree.setConverter(new StringConverter<Weapon>() {
            @Override
            public String toString(Weapon weapon) {
                if (weapon == null) {
                    return "Unable to retrieve weapon...";
                } else {
                    return "L" + weapon.getLevel() + " - " + weapon.getComponentName();
                }
            }

            @Override
            public Weapon fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        loadoutWeaponFour.setItems(FXCollections.observableList(weapons));
        loadoutWeaponFour.setConverter(new StringConverter<Weapon>() {
            @Override
            public String toString(Weapon weapon) {
                if (weapon == null) {
                    return "Unable to retrieve weapon...";
                } else {
                    return "L" + weapon.getLevel() + " - " + weapon.getComponentName();
                }
            }

            @Override
            public Weapon fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        ordnance = componentHelper.getOrdnance();        
        loadoutOrdnanceOne.setItems(FXCollections.observableList(ordnance));
        loadoutOrdnanceOne.setConverter(new StringConverter<Ordnance>() {
            @Override
            public String toString(Ordnance ordnance) {
                if (ordnance == null) {
                    return "Unable to retrieve ordnance...";
                } else {
                    return "L" + ordnance.getLevel() + " - " + ordnance.getComponentName();
                }
            }

            @Override
            public Ordnance fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });     
        
        loadoutOrdnanceTwo.setItems(FXCollections.observableList(ordnance));
        loadoutOrdnanceTwo.setConverter(new StringConverter<Ordnance>() {
            @Override
            public String toString(Ordnance ordnance) {
                if (ordnance == null) {
                    return "Unable to retrieve ordnance...";
                } else {
                    return "L" + ordnance.getLevel() + " - " + ordnance.getComponentName();
                }
            }

            @Override
            public Ordnance fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });     
        
        loadoutOrdnanceThree.setItems(FXCollections.observableList(ordnance));
        loadoutOrdnanceThree.setConverter(new StringConverter<Ordnance>() {
            @Override
            public String toString(Ordnance ordnance) {
                if (ordnance == null) {
                    return "Unable to retrieve ordnance...";
                } else {
                    return "L" + ordnance.getLevel() + " - " + ordnance.getComponentName();
                }
            }

            @Override
            public Ordnance fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        countermeasures = componentHelper.getCountermeasures();        
        loadoutCountermeasure.setItems(FXCollections.observableList(countermeasures));
        loadoutCountermeasure.setConverter(new StringConverter<Countermeasure>() {
            @Override
            public String toString(Countermeasure countermeasure) {
                if (countermeasure == null) {
                    return "Unable to retrieve countermeasure...";
                } else {
                    return "L" + countermeasure.getLevel() + " - " + countermeasure.getComponentName();
                }
            }

            @Override
            public Countermeasure fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }
    
    @FXML
    public void loadLoadout() {
        
        clearComponents();
        
        currentLoadout = (Loadout) loadoutSelection.getValue();
                
        if(currentLoadout != null) {
            
            switch(currentLoadout.getChassis().getWeaponMounts()) {
                case 2 : 
                    loadoutWeaponTwoContainer.setVisible(true);
                    break;
                case 3 :
                    loadoutWeaponTwoContainer.setVisible(true);
                    loadoutWeaponThreeContainer.setVisible(true);
                    break;
                case 4:
                    loadoutWeaponTwoContainer.setVisible(true);
                    loadoutWeaponThreeContainer.setVisible(true);
                    loadoutWeaponFourContainer.setVisible(true);
            }

            switch(currentLoadout.getChassis().getOrdnanceMounts()) {
                case 2 : 
                    loadoutOrdnanceTwoContainer.setVisible(true);
                    break;
                case 3 :
                    loadoutOrdnanceTwoContainer.setVisible(true);
                    loadoutOrdnanceThreeContainer.setVisible(true);
                    break;
            }
            
            if(currentLoadout.getReactorID() != null) {
                for(int i = 0; i < reactors.size(); i++) {
                    if(currentLoadout.getReactorID().equals(reactors.get(i).getComponentID())){
                        loadoutReactor.setValue(reactors.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getEngineID() != null) {
                for(int i = 0; i < engines.size(); i++) {
                    if(currentLoadout.getEngineID().equals(engines.get(i).getComponentID())){
                        loadoutEngine.setValue(engines.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getShieldID() != null) {
                for(int i = 0; i < shields.size(); i++) {
                    if(currentLoadout.getShieldID().equals(shields.get(i).getComponentID())){
                        loadoutShield.setValue(shields.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getArmorFrontID() != null) {
                for(int i = 0; i < armors.size(); i++) {
                    if(currentLoadout.getArmorFrontID().equals(armors.get(i).getComponentID())){
                        loadoutFrontArmor.setValue(armors.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getArmorBackID() != null) {
                for(int i = 0; i < armors.size(); i++) {
                    if(currentLoadout.getArmorBackID().equals(armors.get(i).getComponentID())){
                        loadoutBackArmor.setValue(armors.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getCapacitorID() != null) {
                for(int i = 0; i < capacitors.size(); i++) {
                    if(currentLoadout.getCapacitorID().equals(capacitors.get(i).getComponentID())){
                        loadoutCapacitor.setValue(capacitors.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getBoosterID() != null) {
                for(int i = 0; i < boosters.size(); i++) {
                    if(currentLoadout.getBoosterID().equals(boosters.get(i).getComponentID())){
                        loadoutBooster.setValue(boosters.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getCountermeasureID() != null) {
                for(int i = 0; i < countermeasures.size(); i++) {
                    if(currentLoadout.getCountermeasureID().equals(countermeasures.get(i).getComponentID())){
                        loadoutCountermeasure.setValue(countermeasures.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getDroidInterfaceID() != null) {
                for(int i = 0; i < interfaces.size(); i++) {
                    if(currentLoadout.getDroidInterfaceID().equals(interfaces.get(i).getComponentID())){
                        loadoutInterface.setValue(interfaces.get(i));
                        break;
                    }
                }
            }

            for(int w = 0; w < currentLoadout.getWeaponIDs().size(); w++){
                for(int i = 0; i < weapons.size(); i++) {
                    if(currentLoadout.getWeaponIDs().get(w).equals(weapons.get(i).getComponentID())) {
                        switch(w) {
                            case 0 :
                                loadoutWeaponOne.setValue(weapons.get(i));
                                break;
                            case 1 :
                                loadoutWeaponTwo.setValue(weapons.get(i));
                                break;
                            case 2 :
                                loadoutWeaponThree.setValue(weapons.get(i));
                                break;
                            case 3:
                                loadoutWeaponFour.setValue(weapons.get(i));
                                break;
                        }
                    }
                }            
            }

            for(int w = 0; w < currentLoadout.getOrdnanceIDs().size(); w++){
                for(int i = 0; i < ordnance.size(); i++) {
                    if(currentLoadout.getOrdnanceIDs().get(w).equals(ordnance.get(i).getComponentID())){
                        switch(w) {
                            case 0 :
                                loadoutOrdnanceOne.setValue(ordnance.get(i));
                                break;
                            case 1 :
                                loadoutOrdnanceTwo.setValue(ordnance.get(i));
                                break;
                            case 2 :
                                loadoutOrdnanceThree.setValue(ordnance.get(i));
                                break;
                        }
                    }
                }            
            }
            
            loadComponentStats();
            createLoadoutPane.setVisible(false);
            saveLoadoutButton.setDisable(false);
            deleteLoadoutButton.setDisable(false);
            clearComponentsButton.setDisable(false);
            loadoutComponents.setVisible(true);
        }
    }
    
    public void loadComponentStats() {
        
        Reactor reactor = (Reactor) loadoutReactor.getValue();
        Engine engine = (Engine) loadoutEngine.getValue();
        Shield shield = (Shield) loadoutShield.getValue();
        Capacitor capacitor = (Capacitor) loadoutCapacitor.getValue();
        Booster booster = (Booster) loadoutBooster.getValue();
        DroidInterface droidInterface = (DroidInterface) loadoutInterface.getValue();
        Armor frontArmor = (Armor) loadoutFrontArmor.getValue();
        Armor backArmor = (Armor) loadoutBackArmor.getValue();
        Weapon weaponOne = (Weapon) loadoutWeaponOne.getValue();
        Weapon weaponTwo = (Weapon) loadoutWeaponTwo.getValue();
        Weapon weaponThree = (Weapon) loadoutWeaponThree.getValue();
        Weapon weaponFour = (Weapon) loadoutWeaponFour.getValue();
        Ordnance ordnanceOne = (Ordnance) loadoutOrdnanceOne.getValue();
        Ordnance ordnanceTwo = (Ordnance) loadoutOrdnanceTwo.getValue();
        Ordnance ordnanceThree = (Ordnance) loadoutOrdnanceThree.getValue();
        Countermeasure countermeasure = (Countermeasure) loadoutCountermeasure.getValue();

        if(reactor != null){
            currentReactorArmor.setText(doubleToString(reactor.getArmor(), 2));
            currentReactorHitpoints.setText(doubleToString(reactor.getHitpoints(), 2));
            currentReactorMass.setText(doubleToString(reactor.getMass(), 2));
            currentReactorGeneration.setText(doubleToString(reactor.getGenerationRate(), 2));    
        }
        
        if(engine != null){
            currentEngineArmor.setText(doubleToString(engine.getArmor(), 2));
            currentEngineHitpoints.setText(doubleToString(engine.getHitpoints(), 2));
            currentEngineDrain.setText(doubleToString(engine.getEnergyDrain(), 2));
            currentEngineMass.setText(doubleToString(engine.getMass(), 2));   
            currentEnginePitch.setText(doubleToString(engine.getPitchRate(), 2));  
            currentEngineYaw.setText(doubleToString(engine.getYawRate(), 2)); 
            currentEngineRoll.setText(doubleToString(engine.getRollRate(), 2));   
            currentEngineSpeed.setText(doubleToString(engine.getTopSpeed(), 2));   
        }
        
        if(shield != null){
            currentShieldArmor.setText(doubleToString(shield.getArmor(), 2));
            currentShieldHitpoints.setText(doubleToString(shield.getHitpoints(), 2));
            currentShieldDrain.setText(doubleToString(shield.getEnergyDrain(), 2));
            currentShieldMass.setText(doubleToString(shield.getMass(), 2));   
            currentShieldFrontHitpoints.setText(doubleToString(shield.getFrontHitpoints(), 2));  
            currentShieldBackHitpoints.setText(doubleToString(shield.getBackHitpoints(), 2)); 
            currentShieldRecharge.setText(doubleToString(shield.getRechargeRate(), 2));  
        }
        
        if(booster != null){
            currentBoosterArmor.setText(doubleToString(booster.getArmor(), 2));
            currentBoosterHitpoints.setText(doubleToString(booster.getHitpoints(), 2));
            currentBoosterDrain.setText(doubleToString(booster.getEnergyDrain(), 2));
            currentBoosterMass.setText(doubleToString(booster.getMass(), 2));   
            currentBoosterEnergy.setText(doubleToString(booster.getEnergy(), 2));  
            currentBoosterRecharge.setText(doubleToString(booster.getRechargeRate(), 2)); 
            currentBoosterConsumption.setText(doubleToString(booster.getConsumptionRate(), 2));  
            currentBoosterSpeed.setText(doubleToString(booster.getTopSpeed(), 2));  
        }
        
        if(frontArmor != null){
            currentFrontArmorArmor.setText(doubleToString(frontArmor.getArmor(), 2));
            currentFrontArmorHitpoints.setText(doubleToString(frontArmor.getHitpoints(), 2));
            currentFrontArmorMass.setText(doubleToString(frontArmor.getMass(), 2));
        }
        
        if(backArmor != null){
            currentFrontArmorArmor.setText(doubleToString(backArmor.getArmor(), 2));
            currentFrontArmorHitpoints.setText(doubleToString(backArmor.getHitpoints(), 2));
            currentFrontArmorMass.setText(doubleToString(backArmor.getMass(), 2));
        }
        
        if(capacitor != null){
            currentCapacitorArmor.setText(doubleToString(capacitor.getArmor(), 2));
            currentCapacitorHitpoints.setText(doubleToString(capacitor.getHitpoints(), 2));
            currentCapacitorDrain.setText(doubleToString(capacitor.getEnergyDrain(), 2));
            currentCapacitorMass.setText(doubleToString(capacitor.getMass(), 2));   
            currentCapacitorEnergy.setText(doubleToString(capacitor.getEnergy(), 2));  
            currentCapacitorRecharge.setText(doubleToString(capacitor.getRechargeRate(), 2));
        }
        
        if(countermeasure != null){
            currentCountermeasureArmor.setText(doubleToString(countermeasure.getArmor(), 2));
            currentCountermeasureHitpoints.setText(doubleToString(countermeasure.getHitpoints(), 2));
            currentCountermeasureDrain.setText(doubleToString(countermeasure.getEnergyDrain(), 2));
            currentCountermeasureMass.setText(doubleToString(countermeasure.getMass(), 2));   
            currentCountermeasureMinimumChance.setText(doubleToString(countermeasure.getMinimumChance(), 2));  
            currentCountermeasureMaximumChance.setText(doubleToString(countermeasure.getMaximumChance(), 2));
            currentCountermeasureRefire.setText(doubleToString(countermeasure.getRefireRate(), 3));
        }
        
        if(droidInterface != null){
            currentInterfaceArmor.setText(doubleToString(droidInterface.getArmor(), 2));
            currentInterfaceHitpoints.setText(doubleToString(droidInterface.getHitpoints(), 2));
            currentInterfaceDrain.setText(doubleToString(droidInterface.getEnergyDrain(), 2));
            currentInterfaceMass.setText(doubleToString(droidInterface.getMass(), 2));
        }
        
        if(weaponOne != null){
            currentWeaponOneArmor.setText(doubleToString(weaponOne.getArmor(), 2));
            currentWeaponOneHitpoints.setText(doubleToString(weaponOne.getHitpoints(), 2));
            currentWeaponOneDrain.setText(doubleToString(weaponOne.getEnergyDrain(), 2));
            currentWeaponOneMass.setText(doubleToString(weaponOne.getMass(), 2));   
            currentWeaponOneMinimumDamage.setText(doubleToString(weaponOne.getMinimumDamage(), 2));  
            currentWeaponOneMaximumDamage.setText(doubleToString(weaponOne.getMaximumDamage(), 2));   
            currentWeaponOneVersusShields.setText(doubleToString(weaponOne.getVersusShields(), 2));  
            currentWeaponOneVersusArmor.setText(doubleToString(weaponOne.getVersusArmor(), 3));
            currentWeaponOneRefire.setText(doubleToString(weaponOne.getRefireRate(), 3));
            currentWeaponOneEPS.setText(doubleToString(weaponOne.getEnergyPerShot(), 2));
        }
        
        if(weaponTwo != null){
            currentWeaponTwoArmor.setText(doubleToString(weaponTwo.getArmor(), 2));
            currentWeaponTwoHitpoints.setText(doubleToString(weaponTwo.getHitpoints(), 2));
            currentWeaponTwoDrain.setText(doubleToString(weaponTwo.getEnergyDrain(), 2));
            currentWeaponTwoMass.setText(doubleToString(weaponTwo.getMass(), 2));   
            currentWeaponTwoMinimumDamage.setText(doubleToString(weaponTwo.getMinimumDamage(), 2));
            currentWeaponTwoMaximumDamage.setText(doubleToString(weaponTwo.getMaximumDamage(), 2));
            currentWeaponTwoVersusShields.setText(doubleToString(weaponTwo.getVersusShields(), 2));
            currentWeaponTwoVersusArmor.setText(doubleToString(weaponTwo.getVersusArmor(), 3));
            currentWeaponTwoRefire.setText(doubleToString(weaponTwo.getRefireRate(), 3));
            currentWeaponTwoEPS.setText(doubleToString(weaponTwo.getEnergyPerShot(), 2));
        }
        
        if(weaponThree != null){
            currentWeaponThreeArmor.setText(doubleToString(weaponThree.getArmor(), 2));
            currentWeaponThreeHitpoints.setText(doubleToString(weaponThree.getHitpoints(), 2));
            currentWeaponThreeDrain.setText(doubleToString(weaponThree.getEnergyDrain(), 2));
            currentWeaponThreeMass.setText(doubleToString(weaponThree.getMass(), 2));   
            currentWeaponThreeMinimumDamage.setText(doubleToString(weaponThree.getMinimumDamage(), 2)); 
            currentWeaponThreeMaximumDamage.setText(doubleToString(weaponThree.getMaximumDamage(), 2));  
            currentWeaponThreeVersusShields.setText(doubleToString(weaponThree.getVersusShields(), 2)); 
            currentWeaponThreeVersusArmor.setText(doubleToString(weaponThree.getVersusArmor(), 3));
            currentWeaponThreeRefire.setText(doubleToString(weaponThree.getRefireRate(), 3));
            currentWeaponThreeEPS.setText(doubleToString(weaponThree.getEnergyPerShot(), 2));
        }
        
        if(weaponFour != null){
            currentWeaponFourArmor.setText(doubleToString(weaponFour.getArmor(), 2));
            currentWeaponFourHitpoints.setText(doubleToString(weaponFour.getHitpoints(), 2));
            currentWeaponFourDrain.setText(doubleToString(weaponFour.getEnergyDrain(), 2));
            currentWeaponFourMass.setText(doubleToString(weaponFour.getMass(), 2));   
            currentWeaponFourMinimumDamage.setText(doubleToString(weaponFour.getMinimumDamage(), 2));
            currentWeaponFourMaximumDamage.setText(doubleToString(weaponFour.getMaximumDamage(), 2));
            currentWeaponFourVersusShields.setText(doubleToString(weaponFour.getVersusShields(), 2));
            currentWeaponFourVersusArmor.setText(doubleToString(weaponFour.getVersusArmor(), 3));
            currentWeaponFourRefire.setText(doubleToString(weaponFour.getRefireRate(), 3));
            currentWeaponFourEPS.setText(doubleToString(weaponFour.getEnergyPerShot(), 2));
        }
        
        if(ordnanceOne != null){
            currentOrdnanceOneArmor.setText(doubleToString(ordnanceOne.getArmor(), 2));
            currentOrdnanceOneHitpoints.setText(doubleToString(ordnanceOne.getHitpoints(),2 ));
            currentOrdnanceOneDrain.setText(doubleToString(ordnanceOne.getEnergyDrain(), 2));
            currentOrdnanceOneMass.setText(doubleToString(ordnanceOne.getMass(), 2));   
            currentOrdnanceOneMinimumDamage.setText(doubleToString(ordnanceOne.getMinimumDamage(), 2));  
            currentOrdnanceOneMaximumDamage.setText(doubleToString(ordnanceOne.getMaximumDamage(), 2));   
            currentOrdnanceOneVersusShields.setText(doubleToString(ordnanceOne.getVersusShields(), 2));  
            currentOrdnanceOneVersusArmor.setText(doubleToString(ordnanceOne.getVersusArmor(), 2));
            currentOrdnanceOneRefire.setText(doubleToString(ordnanceOne.getRefireRate(), 2));
        }
        
        if(ordnanceTwo != null){
            currentOrdnanceTwoArmor.setText(doubleToString(ordnanceTwo.getArmor(), 2));
            currentOrdnanceTwoHitpoints.setText(doubleToString(ordnanceTwo.getHitpoints(),2 ));
            currentOrdnanceTwoDrain.setText(doubleToString(ordnanceTwo.getEnergyDrain(), 2));
            currentOrdnanceTwoMass.setText(doubleToString(ordnanceTwo.getMass(), 2));   
            currentOrdnanceTwoMinimumDamage.setText(doubleToString(ordnanceTwo.getMinimumDamage(), 2));
            currentOrdnanceTwoMaximumDamage.setText(doubleToString(ordnanceTwo.getMaximumDamage(), 2));
            currentOrdnanceTwoVersusShields.setText(doubleToString(ordnanceTwo.getVersusShields(), 2));
            currentOrdnanceTwoVersusArmor.setText(doubleToString(ordnanceTwo.getVersusArmor(), 2));
            currentOrdnanceTwoRefire.setText(doubleToString(ordnanceTwo.getRefireRate(), 2));
        }
        
        if(ordnanceThree != null){
            currentOrdnanceThreeArmor.setText(doubleToString(ordnanceThree.getArmor(), 2));
            currentOrdnanceThreeHitpoints.setText(doubleToString(ordnanceThree.getHitpoints(),2 ));
            currentOrdnanceThreeDrain.setText(doubleToString(ordnanceThree.getEnergyDrain(), 2));
            currentOrdnanceThreeMass.setText(doubleToString(ordnanceThree.getMass(), 2));   
            currentOrdnanceThreeMinimumDamage.setText(doubleToString(ordnanceThree.getMinimumDamage(), 2)); 
            currentOrdnanceThreeMaximumDamage.setText(doubleToString(ordnanceThree.getMaximumDamage(), 2));  
            currentOrdnanceThreeVersusShields.setText(doubleToString(ordnanceThree.getVersusShields(), 2)); 
            currentOrdnanceThreeVersusArmor.setText(doubleToString(ordnanceThree.getVersusArmor(), 2));
            currentOrdnanceThreeRefire.setText(doubleToString(ordnanceThree.getRefireRate(), 2));
        }
    }
    
    public void loadLoadouts() {
        loadouts = loadoutHelper.getLoadouts();
        loadoutSelection.setItems(FXCollections.observableList(loadouts));
        loadoutSelection.setConverter(new StringConverter<Loadout>() {
            @Override
            public String toString(Loadout loadout) {
                if (loadout == null) {
                    return "Unable to retrieve loadout...";
                } else {
                    return loadout.getLoadoutName() + " - " + loadout.getChassis().getChassisShortName();
                }
            }

            @Override
            public Loadout fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        loadoutSelection.getSelectionModel().clearSelection();
    }
    
    public void loadChassis() {
        
        chassis = chassisHelper.getChassis();
        chassisSelection.setItems(FXCollections.observableList(chassis));
        chassisSelection.setConverter(new StringConverter<Chassis>() {
            @Override
            public String toString(Chassis chassis) {
                if (chassis == null) {
                    return "Unable to retrieve loadout...";
                } else {
                    return chassis.getChassisLongName();
                }
            }

            @Override
            public Chassis fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        chassisSelection.getSelectionModel().clearSelection();
    }
    
    @FXML
    public void deleteLoadout() {
        
        for(int i = 0; i < loadouts.size(); i++) {
            if(currentLoadout.getLoadoutID().equals(loadouts.get(i).getLoadoutID())) {
                loadouts.remove(i);
                break;
            }
        }
        deleteLoadoutButton.setDisable(true);
        saveLoadoutButton.setDisable(true);
        clearComponentsButton.setDisable(true);
        loadoutComponents.setVisible(false);
        
        loadoutHelper.saveLoadouts(loadouts);
        loadLoadouts();
        clearComponents();
        
       
    }
    
    @FXML
    public void clearComponents() {
        loadoutReactor.getSelectionModel().clearSelection();
        loadoutEngine.getSelectionModel().clearSelection();
        loadoutShield.getSelectionModel().clearSelection();
        loadoutBooster.getSelectionModel().clearSelection();
        loadoutCapacitor.getSelectionModel().clearSelection();
        loadoutInterface.getSelectionModel().clearSelection();
        loadoutFrontArmor.getSelectionModel().clearSelection();
        loadoutBackArmor.getSelectionModel().clearSelection();
        loadoutWeaponOne.getSelectionModel().clearSelection();
        loadoutWeaponTwo.getSelectionModel().clearSelection();
        loadoutWeaponThree.getSelectionModel().clearSelection();
        loadoutWeaponFour.getSelectionModel().clearSelection();
        loadoutOrdnanceOne.getSelectionModel().clearSelection();
        loadoutOrdnanceTwo.getSelectionModel().clearSelection();
        loadoutOrdnanceThree.getSelectionModel().clearSelection();
        loadoutCountermeasure.getSelectionModel().clearSelection();
        
        loadoutWeaponTwoContainer.setVisible(false);
        loadoutWeaponThreeContainer.setVisible(false);
        loadoutWeaponFourContainer.setVisible(false);
        loadoutOrdnanceTwoContainer.setVisible(false);
        loadoutOrdnanceThreeContainer.setVisible(false);
    }
    
    @FXML
    public void createLoadout() {
        clearComponents();
        
        loadoutSelection.getItems().removeAll();
        loadoutSelection.getSelectionModel().clearSelection();
        loadoutSelection.setDisable(true);
        
        saveLoadoutButton.setDisable(true);
        createLoadoutButton.setDisable(true);
        deleteLoadoutButton.setDisable(true);
        clearComponentsButton.setDisable(true);
        
        loadoutComponents.setVisible(false);
        createLoadoutPane.setVisible(true);
    }
    
    @FXML
    public void cancelNewLoadout() {
        loadLoadouts();
        createLoadoutButton.setDisable(false);
        loadoutSelection.setDisable(false);
        createLoadoutPane.setVisible(false);
    }
    
    @FXML
    public void handleChassis() {
        
        Chassis chassis = (Chassis) chassisSelection.getValue();
        
        if(chassis != null) {
            if(chassis.getMass() > 0) {
                chassisMass.setText(chassis.getMaximumMass().toString());
            } else {
                chassisMass.setDisable(false);
            }
        }
    }
    
    @FXML
    public void saveNewLoadout() {
        
        Loadout newLoadout = new Loadout();
        
        Chassis selectedChassis = (Chassis) chassisSelection.getValue();
        selectedChassis.setMass(Double.parseDouble(chassisMass.getText()));
        
        newLoadout.setChassis(selectedChassis);
        newLoadout.setLoadoutName(loadoutName.getText());
        
        loadouts.add(newLoadout);
        loadoutHelper.saveLoadouts(loadouts);
        
        // Clear new loadout fields
        chassisSelection.getSelectionModel().clearSelection();
        loadoutName.setText("");
        chassisMass.setText("");
        
        // Display / hide controls
        createLoadoutPane.setVisible(false);
        loadoutComponents.setVisible(true);
        saveLoadoutButton.setDisable(false);
        createLoadoutButton.setDisable(false);
        clearComponentsButton.setDisable(false);
        deleteLoadoutButton.setDisable(false);
        
        loadLoadouts();
        currentLoadout = newLoadout;
        loadoutSelection.setDisable(false);
        loadoutSelection.getSelectionModel().select(currentLoadout);
    }
    
    public String doubleToString(Double value, int precision) {
        switch (precision) {
            case 2:
                return new DecimalFormat("#0.00").format(value);
            case 3:
                return new DecimalFormat("#0.000").format(value);
            default:
                return new DecimalFormat("#0.0").format(value);
        }
    }
    
}
