package jtl.toolkit;

import java.net.URL;
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
    @FXML TabPane existingComponentsTabPane;
    
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
    
    @FXML TextField newComponentName;
    @FXML TextArea newComponentNotes;
    
    // Buttons
    @FXML Button saveComponentButton;
    @FXML Button clearNewComponentFieldsButton;
    @FXML Button removeComponentButton;
    
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
                    return "Unable to retrieve shield...";
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
                    return "Unable to retrieve shield...";
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
                    return "Unable to retrieve shield...";
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
                    return "Unable to retrieve shield...";
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
        
        currentLoadout = (Loadout) loadoutSelection.getValue();
        
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
                if(currentLoadout.getWeaponIDs().get(w).equals(weapons.get(i).getComponentID())){
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
                
                break;
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
                
                break;
            }            
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
                    return loadout.getLoadoutName() + " - " + loadout.getChassisName();
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
    
    
}
