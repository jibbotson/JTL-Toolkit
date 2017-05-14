package jtl.toolkit;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import javafx.scene.paint.Color;
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
    @FXML ImageView REComponentImage;
    
    // Containers
    @FXML AnchorPane loadoutControlsContainer;
    @FXML AnchorPane reverseEngineeringContainer;
    @FXML AnchorPane statQualityContainer;
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
    @FXML AnchorPane REComponentFieldContainerOne;
    @FXML AnchorPane REComponentFieldContainerTwo;
    @FXML AnchorPane REComponentFieldContainerThree;
    @FXML AnchorPane REComponentFieldContainerFour;
    @FXML AnchorPane REComponentFieldContainerFive;
    @FXML AnchorPane REComponentFieldContainerSix;
    @FXML AnchorPane REComponentFieldContainerSeven;
    @FXML AnchorPane REComponentFieldContainerEight;
    @FXML AnchorPane REComponentFieldContainerNine;
    @FXML AnchorPane REComponentFieldContainerTen;
    @FXML AnchorPane loadoutComponents;
    @FXML AnchorPane loadoutReport;
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
    
    @FXML Label REComponentFieldOneLabel;
    @FXML Label REComponentFieldTwoLabel;
    @FXML Label REComponentFieldThreeLabel;
    @FXML Label REComponentFieldFourLabel;
    @FXML Label REComponentFieldFiveLabel;
    @FXML Label REComponentFieldSixLabel;
    @FXML Label REComponentFieldSevenLabel;
    @FXML Label REComponentFieldEightLabel;
    @FXML Label REComponentFieldNineLabel;
    @FXML Label REComponentFieldTenLabel;
    
    @FXML Label finalResultsLabel;
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
    @FXML Label currentBoosterAcceleration;
    @FXML Label currentBoosterSpeed;
    @FXML Label currentInterfaceArmor;
    @FXML Label currentInterfaceHitpoints;
    @FXML Label currentInterfaceDrain;
    @FXML Label currentInterfaceMass;
    @FXML Label currentInterfaceSpeed;
    @FXML Label currentFrontArmorArmor;
    @FXML Label currentFrontArmorHitpoints;
    @FXML Label currentFrontArmorMass;
    @FXML Label currentRearArmorArmor;
    @FXML Label currentRearArmorHitpoints;
    @FXML Label currentRearArmorMass;
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
    
    @FXML Label loadoutGenerationRate;
    @FXML Label loadoutConsumptionRate;
    @FXML Label loadoutEnergyDifference;
    @FXML Label loadoutShieldReactorDrain;
    @FXML Label loadoutEngineReactorDrain;
    @FXML Label loadoutCapacitorReactorDrain;
    @FXML Label loadoutBoosterReactorDrain;
    @FXML Label loadoutInterfaceReactorDrain;
    @FXML Label loadoutCountermeasureReactorDrain;
    @FXML Label loadoutOrdnanceOneReactorDrain;
    @FXML Label loadoutOrdnanceTwoReactorDrain;
    @FXML Label loadoutOrdnanceThreeReactorDrain;
    @FXML Label loadoutWeaponOneReactorDrain;
    @FXML Label loadoutWeaponTwoReactorDrain;
    @FXML Label loadoutWeaponThreeReactorDrain;
    @FXML Label loadoutWeaponFourReactorDrain;
    @FXML Label requiredGenerationOne;
    @FXML Label requiredGenerationTwo;
    @FXML Label requiredGenerationThree;
    @FXML Label requiredGenerationFour;
    @FXML Label requiredGenerationFive;
    @FXML Label requiredGenerationSix;
    
    @FXML Label loadoutTotalProtection;
    @FXML Label loadoutFrontProtection;
    @FXML Label loadoutFrontReactorProtection;
    @FXML Label loadoutFrontEngineProtection;
    @FXML Label loadoutBackProtection;
    @FXML Label loadoutBackReactorProtection;
    @FXML Label loadoutBackEngineProtection;
    @FXML Label loadoutFrontShielding;
    @FXML Label loadoutRearShielding;
    @FXML Label loadoutFrontArmoring;
    @FXML Label loadoutRearArmoring;
    
    @FXML Label loadoutCapacitorEnergy;
    @FXML Label loadoutCapacitorRechargeRate;
    @FXML Label loadoutCapacitorFullRechargeTime;
    @FXML Label loadoutCapacitorFullFireTime;
    @FXML Label loadoutEPS;
    @FXML Label loadoutEPSBreakdown;
    @FXML Label loadoutMaximumMass;
    @FXML Label loadoutCurrentMass;
    @FXML Label loadoutMassDifference;
    @FXML Label loadoutShuntValue;
    
    @FXML Label REBonus;
    @FXML Label createLoadoutMessage;
    
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
    
    @FXML TextField REComponentFieldOneTextbox;
    @FXML TextField REComponentFieldTwoTextbox;
    @FXML TextField REComponentFieldThreeTextbox;
    @FXML TextField REComponentFieldFourTextbox;
    @FXML TextField REComponentFieldFiveTextbox;
    @FXML TextField REComponentFieldSixTextbox;
    @FXML TextField REComponentFieldSevenTextbox;
    @FXML TextField REComponentFieldEightTextbox;
    @FXML TextField REComponentFieldNineTextbox;
    @FXML TextField REComponentFieldTenTextbox;
    
    @FXML TextField REComponentFieldOneResult;
    @FXML TextField REComponentFieldTwoResult;
    @FXML TextField REComponentFieldThreeResult;
    @FXML TextField REComponentFieldFourResult;
    @FXML TextField REComponentFieldFiveResult;
    @FXML TextField REComponentFieldSixResult;
    @FXML TextField REComponentFieldSevenResult;
    @FXML TextField REComponentFieldEightResult;
    @FXML TextField REComponentFieldNineResult;
    @FXML TextField REComponentFieldTenResult;
    
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
    @FXML Button reverseEngineerButton;
    
    // Combo Boxes
    @FXML ComboBox chassisSelection;
    @FXML ComboBox loadoutSelection;
    @FXML ComboBox newComponentType;
    @FXML ComboBox newComponentLevel;
    @FXML ComboBox REComponentType;
    @FXML ComboBox REComponentLevel;
    @FXML ComboBox loadoutReactor;
    @FXML ComboBox loadoutEngine;
    @FXML ComboBox loadoutShield;
    @FXML ComboBox loadoutBooster;
    @FXML ComboBox loadoutInterface;
    @FXML ComboBox loadoutFrontArmor;
    @FXML ComboBox loadoutRearArmor;
    @FXML ComboBox loadoutCapacitor;
    @FXML ComboBox loadoutWeaponOne;
    @FXML ComboBox loadoutWeaponTwo;
    @FXML ComboBox loadoutWeaponThree;
    @FXML ComboBox loadoutWeaponFour;
    @FXML ComboBox loadoutCountermeasure;
    @FXML ComboBox loadoutOrdnanceOne;
    @FXML ComboBox loadoutOrdnanceTwo;
    @FXML ComboBox loadoutOrdnanceThree;
    @FXML ComboBox reactorOverload;
    @FXML ComboBox engineOverload;
    @FXML ComboBox capacitorOverload;
    @FXML ComboBox weaponOverload;
    @FXML ComboBox shieldShunt;
    @FXML ComboBox shieldAdjust;
    
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
            loadoutControlsContainer.setVisible(false);
            createLoadoutPane.setVisible(true);
            loadoutSelection.setDisable(true);
        } else {
            createLoadoutButton.setDisable(false);
        }
        
        reloadComponentTables();
        
        reactorTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
        
        engineTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
        
        shieldTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
        
        armorTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
        
        capacitorTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
        
        weaponTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
 
        countermeasureTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
        
        interfaceTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
        
        boosterTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
        
        ordnanceTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setDisable(false);
        });
        
    }  
    
    public void customResize(TableView<?> view) {

        AtomicLong width = new AtomicLong();
        view.getColumns().forEach(col -> {
            width.addAndGet((long) col.getWidth());
        });
        double tableWidth = view.getWidth();

        if (tableWidth > width.get()) {
            view.getColumns().forEach(col -> {
                col.setPrefWidth(col.getWidth()+((tableWidth-width.get())/view.getColumns().size()));
            });
        }
    }
    
    @FXML
    private void saveNewComponent(ActionEvent event) {
        
        String componentType = (String) newComponentType.getValue();
        
        Validation validation = validateInputTypes();
        
        if(validation.validationResult.equals(false)) {
            
            newComponentMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
            newComponentMessage.setText("Component values must only contain numbers...");
            
        } else if(newComponentName.getText().length() > 0) {
            
            newComponentName.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
            
            if(componentType.equals("Reactor")) {
                
                Reactor reactor = new Reactor();

                reactor.setComponentName(newComponentName.getText());
                reactor.setComponentNotes(newComponentNotes.getText());
                reactor.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                reactor.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                reactor.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                reactor.setMass(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                reactor.setGenerationRate(Double.parseDouble(newComponentFieldFourTextbox.getText()));

                validation = validationHelper.validateReactor(validation, reactor);

                if(validation.validationResult) {

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
                
            }else if(componentType.equals("Engine")) {
                    
                Engine engine = new Engine();

                engine.setComponentName(newComponentName.getText());
                engine.setComponentNotes(newComponentNotes.getText());
                engine.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                engine.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                engine.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                engine.setReactorDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                engine.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                engine.setPitchRate(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                engine.setYawRate(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                engine.setRollRate(Double.parseDouble(newComponentFieldSevenTextbox.getText()));
                engine.setTopSpeed(Double.parseDouble(newComponentFieldEightTextbox.getText()));

                validation = validationHelper.validateEngine(validation, engine);

                if(validation.validationResult) {

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
                    
            }else if(componentType.equals("Shield")) {
                
                Shield shield = new Shield();

                shield.setComponentName(newComponentName.getText());
                shield.setComponentNotes(newComponentNotes.getText());
                shield.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                shield.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                shield.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                shield.setReactorDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                shield.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                shield.setFrontHitpoints(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                shield.setBackHitpoints(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                shield.setRechargeRate(Double.parseDouble(newComponentFieldSevenTextbox.getText()));

                validation = validationHelper.validateShield(validation, shield);

                if(validation.validationResult) {

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
                
            }else if(componentType.equals("Armor")) {

                Armor armor = new Armor();

                armor.setComponentName(newComponentName.getText());
                armor.setComponentNotes(newComponentNotes.getText());
                armor.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                armor.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                armor.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                armor.setMass(Double.parseDouble(newComponentFieldThreeTextbox.getText()));

                validation = validationHelper.validateArmor(validation, armor);

                if(validation.validationResult) {

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
                    
            }else if(componentType.equals("Droid Interface")) {

                DroidInterface droidInterface = new DroidInterface();

                droidInterface.setComponentName(newComponentName.getText());
                droidInterface.setComponentNotes(newComponentNotes.getText());
                droidInterface.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                droidInterface.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                droidInterface.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                droidInterface.setReactorDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                droidInterface.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                droidInterface.setCommandSpeed(Double.parseDouble(newComponentFieldFiveTextbox.getText()));

                validation = validationHelper.validateInterface(validation, droidInterface);

                if(validation.validationResult) {

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
                
            }else if(componentType.equals("Weapon")) {
                
                Weapon weapon = new Weapon();

                weapon.setComponentName(newComponentName.getText());
                weapon.setComponentNotes(newComponentNotes.getText());
                weapon.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                weapon.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                weapon.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                weapon.setReactorDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                weapon.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                weapon.setMinimumDamage(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                weapon.setMaximumDamage(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                weapon.setVersusShields(Double.parseDouble(newComponentFieldSevenTextbox.getText()));
                weapon.setVersusArmor(Double.parseDouble(newComponentFieldEightTextbox.getText()));
                weapon.setEnergyPerShot(Double.parseDouble(newComponentFieldNineTextbox.getText()));
                weapon.setRefireRate(Double.parseDouble(newComponentFieldTenTextbox.getText()));

                validation = validationHelper.validateWeapon(validation, weapon);

                if(validation.validationResult) {

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
                
            }else if(componentType.equals("Ordnance")) {

                Ordnance ordnanceLauncher = new Ordnance();

                ordnanceLauncher.setComponentName(newComponentName.getText());
                ordnanceLauncher.setComponentNotes(newComponentNotes.getText());
                ordnanceLauncher.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                ordnanceLauncher.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                ordnanceLauncher.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                ordnanceLauncher.setReactorDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                ordnanceLauncher.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                ordnanceLauncher.setMinimumDamage(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                ordnanceLauncher.setMaximumDamage(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                ordnanceLauncher.setVersusShields(Double.parseDouble(newComponentFieldSevenTextbox.getText()));
                ordnanceLauncher.setVersusArmor(Double.parseDouble(newComponentFieldEightTextbox.getText()));
                ordnanceLauncher.setRefireRate(Double.parseDouble(newComponentFieldNineTextbox.getText()));

                validation = validationHelper.validateOrdnance(validation, ordnanceLauncher);

                if(validation.validationResult) {

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
                
            }else if(componentType.equals("Countermeasure")) {

                Countermeasure countermeasure = new Countermeasure();

                countermeasure.setComponentName(newComponentName.getText());
                countermeasure.setComponentNotes(newComponentNotes.getText());
                countermeasure.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                countermeasure.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                countermeasure.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                countermeasure.setReactorDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                countermeasure.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                countermeasure.setMinimumChance(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                countermeasure.setMaximumChance(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                countermeasure.setRefireRate(Double.parseDouble(newComponentFieldSevenTextbox.getText()));

                validation = validationHelper.validateCountermeasure(validation, countermeasure);

                if(validation.validationResult) {

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
                
            }else if(componentType.equals("Booster")) {

                Booster booster = new Booster();

                booster.setComponentName(newComponentName.getText());
                booster.setComponentNotes(newComponentNotes.getText());
                booster.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                booster.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                booster.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                booster.setReactorDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                booster.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                booster.setEnergy(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                booster.setRechargeRate(Double.parseDouble(newComponentFieldSixTextbox.getText()));
                booster.setConsumptionRate(Double.parseDouble(newComponentFieldSevenTextbox.getText()));
                booster.setAccelerationRate(Double.parseDouble(newComponentFieldEightTextbox.getText()));
                booster.setTopSpeed(Double.parseDouble(newComponentFieldNineTextbox.getText()));

                
                validation = validationHelper.validateBooster(validation, booster);

                if(validation.validationResult) {

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
                
            }else if(componentType.equals("Capacitor")) { 

                Capacitor capacitor = new Capacitor();
                
                capacitor.setComponentName(newComponentName.getText());
                capacitor.setComponentNotes(newComponentNotes.getText());
                capacitor.setLevel(Integer.parseInt(newComponentLevel.getValue().toString()));
                capacitor.setArmor(Double.parseDouble(newComponentFieldOneTextbox.getText()));
                capacitor.setHitpoints(Double.parseDouble(newComponentFieldTwoTextbox.getText()));
                capacitor.setReactorDrain(Double.parseDouble(newComponentFieldThreeTextbox.getText()));
                capacitor.setMass(Double.parseDouble(newComponentFieldFourTextbox.getText()));
                capacitor.setEnergy(Double.parseDouble(newComponentFieldFiveTextbox.getText()));
                capacitor.setRechargeRate(Double.parseDouble(newComponentFieldSixTextbox.getText()));

                
                validation = validationHelper.validateCapacitor(validation, capacitor);

                if(validation.validationResult) {

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
            loadLoadout();
            
        } else {
            newComponentMessage.setText("Enter a component name...");
            newComponentMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }
    
    @FXML
    private void showNewComponentFields(ActionEvent event) {
        
        String componentType = (String) newComponentType.getValue();
        SingleSelectionModel<Tab> selectionModel = existingComponentsTabPane.getSelectionModel();
        
        if(componentType.equals("Reactor")) {
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
            
        }else if(componentType.equals("Engine")) {
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
            
        }else if(componentType.equals("Shield")) {
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
            
        }else if(componentType.equals("Armor")) {
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
            
        }else if(componentType.equals("Droid Interface")) {
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
            
        }else if(componentType.equals("Weapon")) {
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
            
        }else if(componentType.equals("Ordnance")) {
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
            
        }else if(componentType.equals("Countermeasure")) {
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
            
        }else if(componentType.equals("Booster")) {
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
            newComponentFieldEightLabel.setText("Acceleration Rate:");
            newComponentFieldNineLabel.setText("Top Speed:");
            
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
            
        }else if(componentType.equals("Capacitor")) {
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
    
    @FXML
    private void showREComponentFields(ActionEvent event) {
        
        String componentType = (String) REComponentType.getValue();
        REBonus.setVisible(true);
        finalResultsLabel.setVisible(true);
        reverseEngineerButton.setVisible(true);
        
        if(componentType.equals("Reactor")) {
            resetREFields();
            REComponentImage.setImage(new Image("images/asset_reactor.png"));
            REComponentImage.setVisible(true);
            
            // Set labels
            REComponentFieldOneLabel.setText("Armor:");
            REComponentFieldTwoLabel.setText("Hitpoints:");
            REComponentFieldThreeLabel.setText("Mass:");
            REComponentFieldFourLabel.setText("Generation Rate:");
            
            // Show fields
            REComponentFieldContainerOne.setVisible(true);
            REComponentFieldContainerTwo.setVisible(true);
            REComponentFieldContainerThree.setVisible(true);
            REComponentFieldContainerFour.setVisible(true);
            
        }else if(componentType.equals("Engine")) {
            resetREFields();
            REComponentImage.setImage(new Image("images/asset_engine.png"));
            REComponentImage.setVisible(true);
            
            // Set labels
            REComponentFieldOneLabel.setText("Armor:");
            REComponentFieldTwoLabel.setText("Hitpoints:");
            REComponentFieldThreeLabel.setText("Energy Drain:");
            REComponentFieldFourLabel.setText("Mass:");
            REComponentFieldFiveLabel.setText("Pitch Rate:");
            REComponentFieldSixLabel.setText("Yaw Rate:");
            REComponentFieldSevenLabel.setText("Roll Rate:");
            REComponentFieldEightLabel.setText("Top Speed:");
            
            // Show fields
            REComponentFieldContainerOne.setVisible(true);
            REComponentFieldContainerTwo.setVisible(true);
            REComponentFieldContainerThree.setVisible(true);
            REComponentFieldContainerFour.setVisible(true);
            REComponentFieldContainerFive.setVisible(true);
            REComponentFieldContainerSix.setVisible(true);
            REComponentFieldContainerSeven.setVisible(true);
            REComponentFieldContainerEight.setVisible(true);
            
        }else if(componentType.equals("Shield")) {
            resetREFields();
            REComponentImage.setImage(new Image("images/asset_shield.png"));
            REComponentImage.setVisible(true);
                 
            // Set labels
            REComponentFieldOneLabel.setText("Armor:");
            REComponentFieldTwoLabel.setText("Hitpoints:");
            REComponentFieldThreeLabel.setText("Energy Drain:");
            REComponentFieldFourLabel.setText("Mass:");
            REComponentFieldFiveLabel.setText("Front Hitpoints:");
            REComponentFieldSixLabel.setText("Back Hitpoints:");
            REComponentFieldSevenLabel.setText("Recharge Rate:");
            
            // Show fields
            REComponentFieldContainerOne.setVisible(true);
            REComponentFieldContainerTwo.setVisible(true);
            REComponentFieldContainerThree.setVisible(true);
            REComponentFieldContainerFour.setVisible(true);
            REComponentFieldContainerFive.setVisible(true);
            REComponentFieldContainerSix.setVisible(true);
            REComponentFieldContainerSeven.setVisible(true);
            
        }else if(componentType.equals("Armor")) {
            resetREFields();
            REComponentImage.setImage(new Image("images/asset_armor.png"));
            REComponentImage.setVisible(true);
            
            // Set labels
            REComponentFieldOneLabel.setText("Armor:");
            REComponentFieldTwoLabel.setText("Hitpoints:");
            REComponentFieldThreeLabel.setText("Mass:");
            
            // Show fields
            REComponentFieldContainerOne.setVisible(true);
            REComponentFieldContainerTwo.setVisible(true);
            REComponentFieldContainerThree.setVisible(true);
            
        }else if(componentType.equals("Weapon")) {
            resetREFields();
            REComponentImage.setImage(new Image("images/asset_weapon.png"));
            REComponentImage.setVisible(true);
            
            // Set labels
            REComponentFieldOneLabel.setText("Armor:");
            REComponentFieldTwoLabel.setText("Hitpoints:");
            REComponentFieldThreeLabel.setText("Energy Drain:");
            REComponentFieldFourLabel.setText("Mass:");
            REComponentFieldFiveLabel.setText("Minimum Damage:");
            REComponentFieldSixLabel.setText("Maximum Damage:");
            REComponentFieldSevenLabel.setText("Vs. Shields:");
            REComponentFieldEightLabel.setText("Vs. Armor:");
            REComponentFieldNineLabel.setText("Energy Per Shot:");
            REComponentFieldTenLabel.setText("Refire Rate:");
            
            // Show fields
            REComponentFieldContainerOne.setVisible(true);
            REComponentFieldContainerTwo.setVisible(true);
            REComponentFieldContainerThree.setVisible(true);
            REComponentFieldContainerFour.setVisible(true);
            REComponentFieldContainerFive.setVisible(true);
            REComponentFieldContainerSix.setVisible(true);
            REComponentFieldContainerSeven.setVisible(true);
            REComponentFieldContainerEight.setVisible(true);
            REComponentFieldContainerNine.setVisible(true);
            REComponentFieldContainerTen.setVisible(true);
            
        }else if(componentType.equals("Booster")) {
            resetREFields();
            REComponentImage.setImage(new Image("images/asset_booster.png"));
            REComponentImage.setVisible(true);
            
            // Set labels
            REComponentFieldOneLabel.setText("Armor:");
            REComponentFieldTwoLabel.setText("Hitpoints:");
            REComponentFieldThreeLabel.setText("Energy Drain:");
            REComponentFieldFourLabel.setText("Mass:");
            REComponentFieldFiveLabel.setText("Energy:");
            REComponentFieldSixLabel.setText("Recharge Rate:");
            REComponentFieldSevenLabel.setText("Consumption Rate:");
            REComponentFieldEightLabel.setText("Top Speed:");
            
            // Show fields
            REComponentFieldContainerOne.setVisible(true);
            REComponentFieldContainerTwo.setVisible(true);
            REComponentFieldContainerThree.setVisible(true);
            REComponentFieldContainerFour.setVisible(true);
            REComponentFieldContainerFive.setVisible(true);
            REComponentFieldContainerSix.setVisible(true);
            REComponentFieldContainerSeven.setVisible(true);
            REComponentFieldContainerEight.setVisible(true);
            
        }else if(componentType.equals("Capacitor")) {
            resetREFields();
            REComponentImage.setImage(new Image("images/asset_capacitor.png"));
            REComponentImage.setVisible(true);
            
            // Set labels
            REComponentFieldOneLabel.setText("Armor:");
            REComponentFieldTwoLabel.setText("Hitpoints:");
            REComponentFieldThreeLabel.setText("Energy Drain:");
            REComponentFieldFourLabel.setText("Mass:");
            REComponentFieldFiveLabel.setText("Energy:");
            REComponentFieldSixLabel.setText("Recharge Rate:");
            
            // Show fields
            REComponentFieldContainerOne.setVisible(true);
            REComponentFieldContainerTwo.setVisible(true);
            REComponentFieldContainerThree.setVisible(true);
            REComponentFieldContainerFour.setVisible(true);
            REComponentFieldContainerFive.setVisible(true);
            REComponentFieldContainerSix.setVisible(true);
        }else if(componentType.equals("Droid Interface")) {
            resetREFields();
            REComponentImage.setImage(new Image("images/asset_droid_interface.png"));
            REComponentImage.setVisible(true);
            
            // Set labels
            REComponentFieldOneLabel.setText("Armor:");
            REComponentFieldTwoLabel.setText("Hitpoints:");
            REComponentFieldThreeLabel.setText("Energy Drain:");
            REComponentFieldFourLabel.setText("Mass:");
            REComponentFieldFiveLabel.setText("Command Speed:");
            
            // Show fields
            REComponentFieldContainerOne.setVisible(true);
            REComponentFieldContainerTwo.setVisible(true);
            REComponentFieldContainerThree.setVisible(true);
            REComponentFieldContainerFour.setVisible(true);
            REComponentFieldContainerFive.setVisible(true);
        }else{
            REComponentImage.setVisible(false);
            resetREFields();
        }
    }
    
    
    // Utility functions
    public void resetFields() {
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
        
        removeComponentButton.setDisable(true);
        reloadComponentTables();
    }
    
    @FXML
    public void reloadCalculations() {
        
        
    }
    
    @FXML
    public void saveLoadout() {
        
        Reactor reactor = (Reactor) loadoutReactor.getValue();
        if(reactor != null){
            currentLoadout.setReactorID(reactor.getComponentID());
        }else{
            currentLoadout.setReactorID(null);
        }
        
        Engine engine = (Engine) loadoutEngine.getValue();
        if(engine != null) {
            currentLoadout.setEngineID(engine.getComponentID());
        }else{
            currentLoadout.setEngineID(null);
        }
        
        Shield shield = (Shield) loadoutShield.getValue();
        if(shield != null) {
            currentLoadout.setShieldID(shield.getComponentID());
        }else{
            currentLoadout.setShieldID(null);
        }
        
        Booster booster = (Booster) loadoutBooster.getValue();
        if(booster != null) {
            currentLoadout.setBoosterID(booster.getComponentID());
        }else{
            currentLoadout.setBoosterID(null);
        }
        
        Capacitor capacitor = (Capacitor) loadoutCapacitor.getValue();
        if(capacitor != null) {
            currentLoadout.setCapacitorID(capacitor.getComponentID());
        }else{
            currentLoadout.setCapacitorID(null);
        }
        
        DroidInterface droidInterface = (DroidInterface) loadoutInterface.getValue();
        if(droidInterface != null){
            currentLoadout.setDroidInterfaceID(droidInterface.getComponentID());
        }else{
            currentLoadout.setDroidInterfaceID(null);
        }

        Armor frontArmor = (Armor) loadoutFrontArmor.getValue();
        if(frontArmor != null) {
            currentLoadout.setArmorFrontID(frontArmor.getComponentID());
        }else{
            currentLoadout.setArmorFrontID(null);
        }
        
        Armor backArmor = (Armor) loadoutRearArmor.getValue();
        if(backArmor != null) {
            currentLoadout.setArmorBackID(backArmor.getComponentID());
        }else{
            currentLoadout.setArmorBackID(null);
        }
        
        Countermeasure countermeasure = (Countermeasure) loadoutCountermeasure.getValue();
        if(countermeasure != null) {
            currentLoadout.setCountermeasureID(countermeasure.getComponentID());
        }else{
            currentLoadout.setCountermeasureID(null);
        }
        
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
            if(currentLoadout.getLoadoutID().equals(loadouts.get(i).getLoadoutID())) {
                existingLoadout = true;
                loadouts.set(i, currentLoadout);
            }
        }
        
        if(!existingLoadout) {
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
                    return "(" + reactor.getLevel() + ") " + reactor.getComponentName();
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
                    return "(" + engine.getLevel() + ") " + engine.getComponentName();
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
                    return "(" + shield.getLevel() + ") " + shield.getComponentName();
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
                    return "(" + armor.getLevel() + ") " + armor.getComponentName();
                }
            }

            @Override
            public Armor fromString(String string) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
        
        loadoutRearArmor.setItems(FXCollections.observableList(armors));
        loadoutRearArmor.setConverter(new StringConverter<Armor>() {
            @Override
            public String toString(Armor armor) {
                if (armor == null) {
                    return "Unable to retrieve armor...";
                } else {
                    return "(" + armor.getLevel() + ") " + armor.getComponentName();
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
                    return "(" + booster.getLevel() + ") " + booster.getComponentName();
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
                    return "(" + capacitor.getLevel() + ") " + capacitor.getComponentName();
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
                    return "(" + droidInterface.getLevel() + ") " + droidInterface.getComponentName();
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
                    return "(" + weapon.getLevel() + ") " + weapon.getComponentName();
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
                    return "(" + weapon.getLevel() + ") " + weapon.getComponentName();
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
                    return "(" + weapon.getLevel() + ") " + weapon.getComponentName();
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
                    return "(" + weapon.getLevel() + ") " + weapon.getComponentName();
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
                    return "(" + ordnance.getLevel() + ") " + ordnance.getComponentName();
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
                    return "(" + ordnance.getLevel() + ") " + ordnance.getComponentName();
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
                    return "(" + ordnance.getLevel() + ") " + ordnance.getComponentName();
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
                    return "(" + countermeasure.getLevel() + ") " + countermeasure.getComponentName();
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
                    if(currentLoadout.getReactorID().equals(reactors.get(i).getComponentID())) {
                        loadoutReactor.setValue(reactors.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getEngineID() != null) {
                for(int i = 0; i < engines.size(); i++) {
                    if(currentLoadout.getEngineID().equals(engines.get(i).getComponentID())) {
                        loadoutEngine.setValue(engines.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getShieldID() != null) {
                for(int i = 0; i < shields.size(); i++) {
                    if(currentLoadout.getShieldID().equals(shields.get(i).getComponentID())) {
                        loadoutShield.setValue(shields.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getArmorFrontID() != null) {
                for(int i = 0; i < armors.size(); i++) {
                    if(currentLoadout.getArmorFrontID().equals(armors.get(i).getComponentID())) {
                        loadoutFrontArmor.setValue(armors.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getArmorBackID() != null) {
                for(int i = 0; i < armors.size(); i++) {
                    if(currentLoadout.getArmorBackID().equals(armors.get(i).getComponentID())) {
                        loadoutRearArmor.setValue(armors.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getCapacitorID() != null) {
                for(int i = 0; i < capacitors.size(); i++) {
                    if(currentLoadout.getCapacitorID().equals(capacitors.get(i).getComponentID())) {
                        loadoutCapacitor.setValue(capacitors.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getBoosterID() != null) {
                for(int i = 0; i < boosters.size(); i++) {
                    if(currentLoadout.getBoosterID().equals(boosters.get(i).getComponentID())) {
                        loadoutBooster.setValue(boosters.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getCountermeasureID() != null) {
                for(int i = 0; i < countermeasures.size(); i++) {
                    if(currentLoadout.getCountermeasureID().equals(countermeasures.get(i).getComponentID())) {
                        loadoutCountermeasure.setValue(countermeasures.get(i));
                        break;
                    }
                }
            }

            if(currentLoadout.getDroidInterfaceID() != null) {
                for(int i = 0; i < interfaces.size(); i++) {
                    if(currentLoadout.getDroidInterfaceID().equals(interfaces.get(i).getComponentID())) {
                        loadoutInterface.setValue(interfaces.get(i));
                        break;
                    }
                }
            }

            for(int w = 0; w < currentLoadout.getWeaponIDs().size(); w++) {
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

            for(int w = 0; w < currentLoadout.getOrdnanceIDs().size(); w++) {
                for(int i = 0; i < ordnance.size(); i++) {
                    if(currentLoadout.getOrdnanceIDs().get(w).equals(ordnance.get(i).getComponentID())) {
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
            
            updateLoadoutReport();
            createLoadoutPane.setVisible(false);
            saveLoadoutButton.setDisable(false);
            deleteLoadoutButton.setDisable(false);
            clearComponentsButton.setDisable(false);
            loadoutComponents.setVisible(true);
            loadoutReport.setVisible(true);
        }
    }
    
    @FXML
    public void loadComponentStats() {
        
        Reactor reactor = (Reactor) loadoutReactor.getValue();
        Engine engine = (Engine) loadoutEngine.getValue();
        Shield shield = (Shield) loadoutShield.getValue();
        Capacitor capacitor = (Capacitor) loadoutCapacitor.getValue();
        Booster booster = (Booster) loadoutBooster.getValue();
        DroidInterface droidInterface = (DroidInterface) loadoutInterface.getValue();
        Armor frontArmor = (Armor) loadoutFrontArmor.getValue();
        Armor backArmor = (Armor) loadoutRearArmor.getValue();
        Weapon weaponOne = (Weapon) loadoutWeaponOne.getValue();
        Weapon weaponTwo = (Weapon) loadoutWeaponTwo.getValue();
        Weapon weaponThree = (Weapon) loadoutWeaponThree.getValue();
        Weapon weaponFour = (Weapon) loadoutWeaponFour.getValue();
        Ordnance ordnanceOne = (Ordnance) loadoutOrdnanceOne.getValue();
        Ordnance ordnanceTwo = (Ordnance) loadoutOrdnanceTwo.getValue();
        Ordnance ordnanceThree = (Ordnance) loadoutOrdnanceThree.getValue();
        Countermeasure countermeasure = (Countermeasure) loadoutCountermeasure.getValue();

        if(reactor != null) {
            currentReactorArmor.setText(doubleToString(reactor.getArmor(), 2));
            currentReactorHitpoints.setText(doubleToString(reactor.getHitpoints(), 2));
            currentReactorMass.setText(doubleToString(reactor.getMass(), 2));
            currentReactorGeneration.setText(doubleToString(reactor.getGenerationRate(), 2));    
        }else{
            currentReactorArmor.setText("0.00");
            currentReactorHitpoints.setText("0.00");
            currentReactorMass.setText("0.00");
            currentReactorGeneration.setText("0.00"); 
        }
        
        if(engine != null) {
            currentEngineArmor.setText(doubleToString(engine.getArmor(), 2));
            currentEngineHitpoints.setText(doubleToString(engine.getHitpoints(), 2));
            currentEngineDrain.setText(doubleToString(engine.getReactorDrain(), 2));
            currentEngineMass.setText(doubleToString(engine.getMass(), 2));   
            currentEnginePitch.setText(doubleToString(engine.getPitchRate(), 2));  
            currentEngineYaw.setText(doubleToString(engine.getYawRate(), 2)); 
            currentEngineRoll.setText(doubleToString(engine.getRollRate(), 2));   
            currentEngineSpeed.setText(doubleToString(engine.getTopSpeed(), 2));   
        }else{
            currentEngineArmor.setText("0.00");
            currentEngineHitpoints.setText("0.00");
            currentEngineDrain.setText("0.00");
            currentEngineMass.setText("0.00");   
            currentEnginePitch.setText("0.00");  
            currentEngineYaw.setText("0.00"); 
            currentEngineRoll.setText("0.00");   
            currentEngineSpeed.setText("0.00");   
        }
        
        if(shield != null) {
            currentShieldArmor.setText(doubleToString(shield.getArmor(), 2));
            currentShieldHitpoints.setText(doubleToString(shield.getHitpoints(), 2));
            currentShieldDrain.setText(doubleToString(shield.getReactorDrain(), 2));
            currentShieldMass.setText(doubleToString(shield.getMass(), 2));   
            currentShieldFrontHitpoints.setText(doubleToString(shield.getFrontHitpoints(), 2));  
            currentShieldBackHitpoints.setText(doubleToString(shield.getRearHitpoints(), 2)); 
            currentShieldRecharge.setText(doubleToString(shield.getRechargeRate(), 2));  
        }else{
            currentShieldArmor.setText("0.00");
            currentShieldHitpoints.setText("0.00");
            currentShieldDrain.setText("0.00");
            currentShieldMass.setText("0.00");   
            currentShieldFrontHitpoints.setText("0.00");  
            currentShieldBackHitpoints.setText("0.00"); 
            currentShieldRecharge.setText("0.00");  
        }
        
        if(booster != null) {
            currentBoosterArmor.setText(doubleToString(booster.getArmor(), 2));
            currentBoosterHitpoints.setText(doubleToString(booster.getHitpoints(), 2));
            currentBoosterDrain.setText(doubleToString(booster.getReactorDrain(), 2));
            currentBoosterMass.setText(doubleToString(booster.getMass(), 2));   
            currentBoosterEnergy.setText(doubleToString(booster.getEnergy(), 2));  
            currentBoosterRecharge.setText(doubleToString(booster.getRechargeRate(), 2)); 
            currentBoosterConsumption.setText(doubleToString(booster.getConsumptionRate(), 2));  
            currentBoosterAcceleration.setText(doubleToString(booster.getAccelerationRate(), 2));  
            currentBoosterSpeed.setText(doubleToString(booster.getTopSpeed(), 2));  
        }else{
            currentBoosterArmor.setText("0.00");
            currentBoosterHitpoints.setText("0.00");
            currentBoosterDrain.setText("0.00");
            currentBoosterMass.setText("0.00");   
            currentBoosterEnergy.setText("0.00");  
            currentBoosterRecharge.setText("0.00"); 
            currentBoosterConsumption.setText("0.00");  
            currentBoosterSpeed.setText("0.00"); 
        }
        
        if(frontArmor != null) {
            currentFrontArmorArmor.setText(doubleToString(frontArmor.getArmor(), 2));
            currentFrontArmorHitpoints.setText(doubleToString(frontArmor.getHitpoints(), 2));
            currentFrontArmorMass.setText(doubleToString(frontArmor.getMass(), 2));
        }else{
            currentFrontArmorArmor.setText("0.00");
            currentFrontArmorHitpoints.setText("0.00");
            currentFrontArmorMass.setText("0.00");
        }
        
        if(backArmor != null) {
            currentRearArmorArmor.setText(doubleToString(backArmor.getArmor(), 2));
            currentRearArmorHitpoints.setText(doubleToString(backArmor.getHitpoints(), 2));
            currentRearArmorMass.setText(doubleToString(backArmor.getMass(), 2));
        }else{
            currentRearArmorArmor.setText("0.00");
            currentRearArmorHitpoints.setText("0.00");
            currentRearArmorMass.setText("0.00");
        }
        
        if(capacitor != null) {
            currentCapacitorArmor.setText(doubleToString(capacitor.getArmor(), 2));
            currentCapacitorHitpoints.setText(doubleToString(capacitor.getHitpoints(), 2));
            currentCapacitorDrain.setText(doubleToString(capacitor.getReactorDrain(), 2));
            currentCapacitorMass.setText(doubleToString(capacitor.getMass(), 2));   
            currentCapacitorEnergy.setText(doubleToString(capacitor.getEnergy(), 2));  
            currentCapacitorRecharge.setText(doubleToString(capacitor.getRechargeRate(), 2));
        }else{
            currentCapacitorArmor.setText("0.00");
            currentCapacitorHitpoints.setText("0.00");
            currentCapacitorDrain.setText("0.00");
            currentCapacitorMass.setText("0.00");   
            currentCapacitorEnergy.setText("0.00");  
            currentCapacitorRecharge.setText("0.00");
        }
        
        if(countermeasure != null) {
            currentCountermeasureArmor.setText(doubleToString(countermeasure.getArmor(), 2));
            currentCountermeasureHitpoints.setText(doubleToString(countermeasure.getHitpoints(), 2));
            currentCountermeasureDrain.setText(doubleToString(countermeasure.getReactorDrain(), 2));
            currentCountermeasureMass.setText(doubleToString(countermeasure.getMass(), 2));   
            currentCountermeasureMinimumChance.setText(doubleToString(countermeasure.getMinimumChance(), 2));  
            currentCountermeasureMaximumChance.setText(doubleToString(countermeasure.getMaximumChance(), 2));
            currentCountermeasureRefire.setText(doubleToString(countermeasure.getRefireRate(), 3));
        }else{
            currentCountermeasureArmor.setText("0.00");
            currentCountermeasureHitpoints.setText("0.00");
            currentCountermeasureDrain.setText("0.00");
            currentCountermeasureMass.setText("0.00");   
            currentCountermeasureMinimumChance.setText("0.00");  
            currentCountermeasureMaximumChance.setText("0.00");
            currentCountermeasureRefire.setText("0.00");
        }
        
        if(droidInterface != null) {
            currentInterfaceArmor.setText(doubleToString(droidInterface.getArmor(), 2));
            currentInterfaceHitpoints.setText(doubleToString(droidInterface.getHitpoints(), 2));
            currentInterfaceDrain.setText(doubleToString(droidInterface.getReactorDrain(), 2));
            currentInterfaceMass.setText(doubleToString(droidInterface.getMass(), 2));
            currentInterfaceSpeed.setText(doubleToString(droidInterface.getCommandSpeed(), 2));
        }else{
            currentInterfaceArmor.setText("0.00");
            currentInterfaceHitpoints.setText("0.00");
            currentInterfaceDrain.setText("0.00");
            currentInterfaceMass.setText("0.00");
            currentInterfaceSpeed.setText("0.00");
        }
        
        if(weaponOne != null) {
            currentWeaponOneArmor.setText(doubleToString(weaponOne.getArmor(), 2));
            currentWeaponOneHitpoints.setText(doubleToString(weaponOne.getHitpoints(), 2));
            currentWeaponOneDrain.setText(doubleToString(weaponOne.getReactorDrain(), 2));
            currentWeaponOneMass.setText(doubleToString(weaponOne.getMass(), 2));   
            currentWeaponOneMinimumDamage.setText(doubleToString(weaponOne.getMinimumDamage(), 2));  
            currentWeaponOneMaximumDamage.setText(doubleToString(weaponOne.getMaximumDamage(), 2));   
            currentWeaponOneVersusShields.setText(doubleToString(weaponOne.getVersusShields(), 2));  
            currentWeaponOneVersusArmor.setText(doubleToString(weaponOne.getVersusArmor(), 3));
            currentWeaponOneRefire.setText(doubleToString(weaponOne.getRefireRate(), 3));
            currentWeaponOneEPS.setText(doubleToString(weaponOne.getEnergyPerShot(), 2));
        }else{
            currentWeaponOneArmor.setText("0.00");
            currentWeaponOneHitpoints.setText("0.00");
            currentWeaponOneDrain.setText("0.00");
            currentWeaponOneMass.setText("0.00");   
            currentWeaponOneMinimumDamage.setText("0.00");  
            currentWeaponOneMaximumDamage.setText("0.00");   
            currentWeaponOneVersusShields.setText("0.00");  
            currentWeaponOneVersusArmor.setText("0.00");
            currentWeaponOneRefire.setText("0.00");
            currentWeaponOneEPS.setText("0.00");
        }
        
        if(weaponTwo != null) {
            currentWeaponTwoArmor.setText(doubleToString(weaponTwo.getArmor(), 2));
            currentWeaponTwoHitpoints.setText(doubleToString(weaponTwo.getHitpoints(), 2));
            currentWeaponTwoDrain.setText(doubleToString(weaponTwo.getReactorDrain(), 2));
            currentWeaponTwoMass.setText(doubleToString(weaponTwo.getMass(), 2));   
            currentWeaponTwoMinimumDamage.setText(doubleToString(weaponTwo.getMinimumDamage(), 2));
            currentWeaponTwoMaximumDamage.setText(doubleToString(weaponTwo.getMaximumDamage(), 2));
            currentWeaponTwoVersusShields.setText(doubleToString(weaponTwo.getVersusShields(), 2));
            currentWeaponTwoVersusArmor.setText(doubleToString(weaponTwo.getVersusArmor(), 3));
            currentWeaponTwoRefire.setText(doubleToString(weaponTwo.getRefireRate(), 3));
            currentWeaponTwoEPS.setText(doubleToString(weaponTwo.getEnergyPerShot(), 2));
        }else{
            currentWeaponTwoArmor.setText("0.00");
            currentWeaponTwoHitpoints.setText("0.00");
            currentWeaponTwoDrain.setText("0.00");
            currentWeaponTwoMass.setText("0.00");   
            currentWeaponTwoMinimumDamage.setText("0.00");
            currentWeaponTwoMaximumDamage.setText("0.00");
            currentWeaponTwoVersusShields.setText("0.00");
            currentWeaponTwoVersusArmor.setText("0.00");
            currentWeaponTwoRefire.setText("0.00");
            currentWeaponTwoEPS.setText("0.00");
        }
        
        if(weaponThree != null) {
            currentWeaponThreeArmor.setText(doubleToString(weaponThree.getArmor(), 2));
            currentWeaponThreeHitpoints.setText(doubleToString(weaponThree.getHitpoints(), 2));
            currentWeaponThreeDrain.setText(doubleToString(weaponThree.getReactorDrain(), 2));
            currentWeaponThreeMass.setText(doubleToString(weaponThree.getMass(), 2));   
            currentWeaponThreeMinimumDamage.setText(doubleToString(weaponThree.getMinimumDamage(), 2)); 
            currentWeaponThreeMaximumDamage.setText(doubleToString(weaponThree.getMaximumDamage(), 2));  
            currentWeaponThreeVersusShields.setText(doubleToString(weaponThree.getVersusShields(), 2)); 
            currentWeaponThreeVersusArmor.setText(doubleToString(weaponThree.getVersusArmor(), 3));
            currentWeaponThreeRefire.setText(doubleToString(weaponThree.getRefireRate(), 3));
            currentWeaponThreeEPS.setText(doubleToString(weaponThree.getEnergyPerShot(), 2));
        }else{
            currentWeaponThreeArmor.setText("0.00");
            currentWeaponThreeHitpoints.setText("0.00");
            currentWeaponThreeDrain.setText("0.00");
            currentWeaponThreeMass.setText("0.00");   
            currentWeaponThreeMinimumDamage.setText("0.00"); 
            currentWeaponThreeMaximumDamage.setText("0.00");  
            currentWeaponThreeVersusShields.setText("0.00"); 
            currentWeaponThreeVersusArmor.setText("0.00");
            currentWeaponThreeRefire.setText("0.00");
            currentWeaponThreeEPS.setText("0.00");
        }
        
        if(weaponFour != null) {
            currentWeaponFourArmor.setText(doubleToString(weaponFour.getArmor(), 2));
            currentWeaponFourHitpoints.setText(doubleToString(weaponFour.getHitpoints(), 2));
            currentWeaponFourDrain.setText(doubleToString(weaponFour.getReactorDrain(), 2));
            currentWeaponFourMass.setText(doubleToString(weaponFour.getMass(), 2));   
            currentWeaponFourMinimumDamage.setText(doubleToString(weaponFour.getMinimumDamage(), 2));
            currentWeaponFourMaximumDamage.setText(doubleToString(weaponFour.getMaximumDamage(), 2));
            currentWeaponFourVersusShields.setText(doubleToString(weaponFour.getVersusShields(), 2));
            currentWeaponFourVersusArmor.setText(doubleToString(weaponFour.getVersusArmor(), 3));
            currentWeaponFourRefire.setText(doubleToString(weaponFour.getRefireRate(), 3));
            currentWeaponFourEPS.setText(doubleToString(weaponFour.getEnergyPerShot(), 2));
        }else{
            currentWeaponFourArmor.setText("0.00");
            currentWeaponFourHitpoints.setText("0.00");
            currentWeaponFourDrain.setText("0.00");
            currentWeaponFourMass.setText("0.00");   
            currentWeaponFourMinimumDamage.setText("0.00");
            currentWeaponFourMaximumDamage.setText("0.00");
            currentWeaponFourVersusShields.setText("0.00");
            currentWeaponFourVersusArmor.setText("0.00");
            currentWeaponFourRefire.setText("0.00");
            currentWeaponFourEPS.setText("0.00");
        }
        
        if(ordnanceOne != null) {
            currentOrdnanceOneArmor.setText(doubleToString(ordnanceOne.getArmor(), 2));
            currentOrdnanceOneHitpoints.setText(doubleToString(ordnanceOne.getHitpoints(),2 ));
            currentOrdnanceOneDrain.setText(doubleToString(ordnanceOne.getReactorDrain(), 2));
            currentOrdnanceOneMass.setText(doubleToString(ordnanceOne.getMass(), 2));   
            currentOrdnanceOneMinimumDamage.setText(doubleToString(ordnanceOne.getMinimumDamage(), 2));  
            currentOrdnanceOneMaximumDamage.setText(doubleToString(ordnanceOne.getMaximumDamage(), 2));   
            currentOrdnanceOneVersusShields.setText(doubleToString(ordnanceOne.getVersusShields(), 2));  
            currentOrdnanceOneVersusArmor.setText(doubleToString(ordnanceOne.getVersusArmor(), 2));
            currentOrdnanceOneRefire.setText(doubleToString(ordnanceOne.getRefireRate(), 2));
        }else{
            currentOrdnanceOneArmor.setText("0.00");
            currentOrdnanceOneHitpoints.setText("0.00");
            currentOrdnanceOneDrain.setText("0.00");
            currentOrdnanceOneMass.setText("0.00");   
            currentOrdnanceOneMinimumDamage.setText("0.00");  
            currentOrdnanceOneMaximumDamage.setText("0.00");   
            currentOrdnanceOneVersusShields.setText("0.00");  
            currentOrdnanceOneVersusArmor.setText("0.00");
            currentOrdnanceOneRefire.setText("0.00");
        }
        
        if(ordnanceTwo != null) {
            currentOrdnanceTwoArmor.setText(doubleToString(ordnanceTwo.getArmor(), 2));
            currentOrdnanceTwoHitpoints.setText(doubleToString(ordnanceTwo.getHitpoints(),2 ));
            currentOrdnanceTwoDrain.setText(doubleToString(ordnanceTwo.getReactorDrain(), 2));
            currentOrdnanceTwoMass.setText(doubleToString(ordnanceTwo.getMass(), 2));   
            currentOrdnanceTwoMinimumDamage.setText(doubleToString(ordnanceTwo.getMinimumDamage(), 2));
            currentOrdnanceTwoMaximumDamage.setText(doubleToString(ordnanceTwo.getMaximumDamage(), 2));
            currentOrdnanceTwoVersusShields.setText(doubleToString(ordnanceTwo.getVersusShields(), 2));
            currentOrdnanceTwoVersusArmor.setText(doubleToString(ordnanceTwo.getVersusArmor(), 2));
            currentOrdnanceTwoRefire.setText(doubleToString(ordnanceTwo.getRefireRate(), 2));
        }else{
            currentOrdnanceTwoArmor.setText("0.00");
            currentOrdnanceTwoHitpoints.setText("0.00");
            currentOrdnanceTwoDrain.setText("0.00");
            currentOrdnanceTwoMass.setText("0.00");   
            currentOrdnanceTwoMinimumDamage.setText("0.00");
            currentOrdnanceTwoMaximumDamage.setText("0.00");
            currentOrdnanceTwoVersusShields.setText("0.00");
            currentOrdnanceTwoVersusArmor.setText("0.00");
            currentOrdnanceTwoRefire.setText("0.00");
        }
        
        if(ordnanceThree != null) {
            currentOrdnanceThreeArmor.setText(doubleToString(ordnanceThree.getArmor(), 2));
            currentOrdnanceThreeHitpoints.setText(doubleToString(ordnanceThree.getHitpoints(),2 ));
            currentOrdnanceThreeDrain.setText(doubleToString(ordnanceThree.getReactorDrain(), 2));
            currentOrdnanceThreeMass.setText(doubleToString(ordnanceThree.getMass(), 2));   
            currentOrdnanceThreeMinimumDamage.setText(doubleToString(ordnanceThree.getMinimumDamage(), 2)); 
            currentOrdnanceThreeMaximumDamage.setText(doubleToString(ordnanceThree.getMaximumDamage(), 2));  
            currentOrdnanceThreeVersusShields.setText(doubleToString(ordnanceThree.getVersusShields(), 2)); 
            currentOrdnanceThreeVersusArmor.setText(doubleToString(ordnanceThree.getVersusArmor(), 2));
            currentOrdnanceThreeRefire.setText(doubleToString(ordnanceThree.getRefireRate(), 2));
        }else{
            currentOrdnanceThreeArmor.setText("0.00");
            currentOrdnanceThreeHitpoints.setText("0.00");
            currentOrdnanceThreeDrain.setText("0.00");
            currentOrdnanceThreeMass.setText("0.00");   
            currentOrdnanceThreeMinimumDamage.setText("0.00"); 
            currentOrdnanceThreeMaximumDamage.setText("0.00");  
            currentOrdnanceThreeVersusShields.setText("0.00"); 
            currentOrdnanceThreeVersusArmor.setText("0.00");
            currentOrdnanceThreeRefire.setText("0.00");
        }
        
        updateLoadoutReport();
        
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
                    return loadout.getLoadoutName() + " (" + loadout.getChassis().getChassisShortName() + ")";
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
        loadoutReport.setVisible(false);
        
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
        loadoutRearArmor.getSelectionModel().clearSelection();
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
        loadoutReport.setVisible(false);
        loadoutControlsContainer.setVisible(false);
        createLoadoutPane.setVisible(true);
    }
    
    @FXML
    public void cancelNewLoadout() {
        loadLoadouts();
        
        createLoadoutButton.setDisable(false);
        loadoutSelection.setDisable(false);
        createLoadoutPane.setVisible(false);
        loadoutControlsContainer.setVisible(true);
    }
    
    @FXML
    public void handleChassis() {
        
        Chassis chassis = (Chassis) chassisSelection.getValue();
        
        if(chassis != null) {
            if(chassis.getMass() > 0) {
                chassisMass.setDisable(true);
                chassisMass.setText(chassis.getMaximumMass().toString());
            } else {
                chassisMass.setText("0.00");
                chassisMass.setDisable(false);
                createLoadoutMessage.setVisible(false);
            }
        }
    }
    
    @FXML
    public void saveNewLoadout() {
        
        Chassis selectedChassis = (Chassis) chassisSelection.getValue();
        
        if(selectedChassis == null) {
            createLoadoutMessage.setText("You must select a chassis...");
            createLoadoutMessage.setVisible(true); 
        }else if(!isDouble(chassisMass.getText()) && !isInteger(chassisMass.getText())){
            System.out.println(selectedChassis.getMaximumMass());
            createLoadoutMessage.setText(("You must enter a mass between 0.00 and " + doubleToString(selectedChassis.getMaximumMass(), 2) + "..."));
            createLoadoutMessage.setVisible(true);
        }else if(chassisMass.getText().isEmpty() || Double.parseDouble(chassisMass.getText()) > selectedChassis.getMaximumMass()){
            System.out.println(selectedChassis.getMaximumMass());
            createLoadoutMessage.setText(("You must enter a mass between 0.00 and " + doubleToString(selectedChassis.getMaximumMass(), 2) + "..."));
            createLoadoutMessage.setVisible(true);
        }else if(loadoutName.getText().isEmpty()){
            createLoadoutMessage.setText("You must enter a loadout name...");
            createLoadoutMessage.setVisible(true);
        }else{
            createLoadoutMessage.setVisible(false);
            Loadout newLoadout = new Loadout();
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
            loadoutControlsContainer.setVisible(true);
            loadoutSelection.getSelectionModel().select(currentLoadout); 
        }
        
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
    
    @FXML
    public void updateLoadoutReport() {
        
        if(currentLoadout != null) {

            Double reactorGenerationMultiplier = 1.0;
            Double engineDrainMultiplier = 1.0;
            Double engineModMultiplier = 1.0;
            Double capacitorMultiplier = 1.0;
            Double weaponDrainMultiplier = 1.0;
            Double weaponDamageMultiplier = 1.0;
            Double shieldFrontAdjustMultiplier = 1.0;
            Double shieldRearAdjustMultiplier = 1.0;
            Double shieldShuntMultiplier = 0.0;

            // Set multipliers

            switch(reactorOverload.getValue().toString()) {
                case "Reactor Overload One" :
                    reactorGenerationMultiplier = 1.09;
                    break;
                case "Reactor Overload Two" :
                    reactorGenerationMultiplier = 1.29;
                    break;
                case "Reactor Overload Three" :
                    reactorGenerationMultiplier = 1.59;
                    break;
                case "Reactor Overload Four" :
                    reactorGenerationMultiplier = 1.89;
                    break;
            }

            switch(engineOverload.getValue().toString()) {
                case "Engine Overload One" :
                    engineDrainMultiplier = 1.25;
                    engineModMultiplier = 1.1;
                    break;
                case "Engine Overload Two" :
                    engineDrainMultiplier = 1.67;
                    engineModMultiplier = 1.2;
                    break;
                case "Engine Overload Three" :
                    engineDrainMultiplier = 3.33;
                    engineModMultiplier = 1.3;
                    break;
                case "Engine Overload Four" :
                    engineDrainMultiplier = 10.0;
                    engineModMultiplier = 1.4;
                    break;
            }

            switch(weaponOverload.getValue().toString()) {
                case "Weapon Overload One" :
                    weaponDrainMultiplier = 1.43;
                    weaponDamageMultiplier = 1.25;
                    break;
                case "Weapon Overload Two" :
                    weaponDrainMultiplier = 2.0;
                    weaponDamageMultiplier = 1.5;
                    break;
                case "Weapon Overload Three" :
                    weaponDrainMultiplier = 2.86;
                    weaponDamageMultiplier = 2.0;
                    break;
                case "Weapon Overload Four" :
                    weaponDrainMultiplier = 5.0;
                    weaponDamageMultiplier = 3.0;
                    break;
            }

            switch(capacitorOverload.getValue().toString()) {
                case "Capacitor Overload One" :
                    capacitorMultiplier = 1.25;
                    break;
                case "Capacitor Overload Two" :
                    capacitorMultiplier = 1.5;
                    break;
                case "Capacitor Overload Three" :
                    capacitorMultiplier = 1.75;
                    break;
                case "Capacitor Overload Four" :
                    capacitorMultiplier = 2.0;
                    break;
            }

            switch(shieldShunt.getValue().toString()) {
                case "Shield Shunt One" :
                    shieldShuntMultiplier = 0.25;
                    break;
                case "Shield Shunt Two" :
                    shieldShuntMultiplier = 0.50;
                    break;
                case "Shield Shunt Three" :
                    shieldShuntMultiplier = 0.75;
                    break;
                case "Shield Shunt Four" :
                    shieldShuntMultiplier = 1.00;
                    break;
            }

            switch(shieldAdjust.getValue().toString()) {
                case "Front Adjust Light" :
                    shieldFrontAdjustMultiplier = 1.25;
                    shieldRearAdjustMultiplier = 0.75;
                    break;
                case "Front Adjust Moderate" :
                    shieldFrontAdjustMultiplier = 1.50;
                    shieldRearAdjustMultiplier = 0.50;
                    break;
                case "Front Adjust Heavy" :
                    shieldFrontAdjustMultiplier = 1.75;
                    shieldRearAdjustMultiplier = 0.25;
                    break;
                case "Front Adjust Extreme" :
                    shieldFrontAdjustMultiplier = 2.0;
                    shieldRearAdjustMultiplier = 0.0;
                    break;
                case "Rear Adjust Light" :
                    shieldFrontAdjustMultiplier = 0.75;
                    shieldRearAdjustMultiplier = 1.25;
                    break;
                case "Rear Adjust Moderate" :
                    shieldFrontAdjustMultiplier = 0.5;
                    shieldRearAdjustMultiplier = 1.5;
                    break;
                case "Rear Adjust Heavy" :
                    shieldFrontAdjustMultiplier = 0.25;
                    shieldRearAdjustMultiplier = 1.75;
                    break;
                case "Rear Adjust Extreme" :
                    shieldFrontAdjustMultiplier = 0.0;
                    shieldRearAdjustMultiplier = 2.0;
                    break;
            }

            // Calculate values

            Double totalConsumptionRate = 0.0;
            Double totalGenerationRate = 0.0;
            Double totalCurrentMass = 0.0;
            

            Reactor currentReactor = (Reactor) loadoutReactor.getValue();

            if(currentReactor != null) {
                totalGenerationRate = currentReactor.getGenerationRate() * reactorGenerationMultiplier;
                loadoutGenerationRate.setText(doubleToString(totalGenerationRate, 2));
                totalCurrentMass += currentReactor.getMass();
            } else{
                loadoutGenerationRate.setText("0.00");
            }

            Engine currentEngine = (Engine) loadoutEngine.getValue();

            if(currentEngine != null) {
                loadoutEngineReactorDrain.setText(doubleToString(currentEngine.getReactorDrain() * engineDrainMultiplier, 2));
                totalCurrentMass += currentEngine.getMass();
                totalConsumptionRate += currentEngine.getReactorDrain() * engineDrainMultiplier;
            }else{
                loadoutEngineReactorDrain.setText("0.00");
            }

            Shield currentShield = (Shield) loadoutShield.getValue();

            if(currentShield != null) {
                loadoutShieldReactorDrain.setText(doubleToString(currentShield.getReactorDrain(), 2));
                loadoutFrontShielding.setText(doubleToString(currentShield.getFrontHitpoints(), 2));
                loadoutRearShielding.setText(doubleToString(currentShield.getRearHitpoints(), 2));
                totalCurrentMass += currentShield.getMass();
                totalConsumptionRate += currentShield.getReactorDrain();
            }else{
                loadoutEngineReactorDrain.setText("0.00");
                loadoutFrontShielding.setText("0.00");
                loadoutRearShielding.setText("0.00");
            }

            Armor currentFrontArmor = (Armor) loadoutFrontArmor.getValue();

            if(currentFrontArmor != null) {
                loadoutFrontArmoring.setText(doubleToString(currentFrontArmor.getArmor(), 2));
                totalCurrentMass += currentFrontArmor.getMass();
            }else{
                loadoutFrontArmoring.setText("0.00");
            }

            Armor currentRearArmor = (Armor) loadoutRearArmor.getValue();

            if(currentRearArmor != null) {
                loadoutRearArmoring.setText(doubleToString(currentRearArmor.getArmor(), 2));
                totalCurrentMass += currentRearArmor.getMass();
            }else{
                loadoutRearArmoring.setText("0.00");
            }

            Capacitor currentCapacitor = (Capacitor) loadoutCapacitor.getValue();

            if(currentCapacitor != null) {
                loadoutCapacitorReactorDrain.setText(doubleToString(currentCapacitor.getReactorDrain(), 2));
                loadoutCapacitorEnergy.setText(doubleToString(currentCapacitor.getEnergy() * capacitorMultiplier, 2));
                loadoutCapacitorRechargeRate.setText(doubleToString(currentCapacitor.getRechargeRate() * capacitorMultiplier, 2));
                loadoutShuntValue.setText(doubleToString((currentCapacitor.getEnergy() * capacitorMultiplier) * shieldShuntMultiplier, 2));
                totalCurrentMass += currentCapacitor.getMass();
                totalConsumptionRate += currentCapacitor.getReactorDrain();
            }else{
                loadoutCapacitorReactorDrain.setText("0.00");
                loadoutCapacitorEnergy.setText("0.00");
                loadoutCapacitorRechargeRate.setText("0.00");
            }

            Booster currentBooster = (Booster) loadoutBooster.getValue();

            if(currentBooster != null) {
                loadoutBoosterReactorDrain.setText(doubleToString(currentBooster.getReactorDrain(), 2));
                totalCurrentMass += currentBooster.getMass();
                totalConsumptionRate += currentBooster.getReactorDrain();
            }else{
                loadoutBoosterReactorDrain.setText("0.00");
            }

            DroidInterface currentInterface = (DroidInterface) loadoutInterface.getValue();

            if(currentInterface != null) {
                loadoutInterfaceReactorDrain.setText(doubleToString(currentInterface.getReactorDrain(), 2));
                totalCurrentMass += currentInterface.getMass();
                totalConsumptionRate += currentInterface.getReactorDrain();
            }else{
                loadoutInterfaceReactorDrain.setText("0.00");
            }

            Countermeasure currentCountermeasure = (Countermeasure) loadoutCountermeasure.getValue();

            if(currentCountermeasure != null) {
                loadoutCountermeasureReactorDrain.setText(doubleToString(currentCountermeasure.getReactorDrain() * weaponDrainMultiplier, 2));
                totalCurrentMass += currentCountermeasure.getMass();
                totalConsumptionRate += currentCountermeasure.getReactorDrain() * weaponDrainMultiplier;
            }else{
                loadoutCountermeasureReactorDrain.setText("0.00");
            }

            Weapon currentWeaponOne = (Weapon) loadoutWeaponOne.getValue();

            if(currentWeaponOne != null) {
                loadoutWeaponOneReactorDrain.setText(doubleToString(currentWeaponOne.getReactorDrain() * weaponDrainMultiplier, 2));
                totalCurrentMass += currentWeaponOne.getMass();
                totalConsumptionRate += currentWeaponOne.getReactorDrain() * weaponDrainMultiplier;
            }else{
                loadoutWeaponOneReactorDrain.setText("0.00");
            }

            Weapon currentWeaponTwo = (Weapon) loadoutWeaponTwo.getValue();

            if(currentWeaponTwo != null) {
                loadoutWeaponTwoReactorDrain.setText(doubleToString(currentWeaponTwo.getReactorDrain() * weaponDrainMultiplier, 2));
                totalCurrentMass += currentWeaponTwo.getMass();
                totalConsumptionRate += currentWeaponTwo.getReactorDrain() * weaponDrainMultiplier;
            }else{
                loadoutWeaponTwoReactorDrain.setText("0.00");
            }

            Weapon currentWeaponThree = (Weapon) loadoutWeaponThree.getValue();

            if(currentWeaponThree != null) {
                loadoutWeaponThreeReactorDrain.setText(doubleToString(currentWeaponThree.getReactorDrain() * weaponDrainMultiplier, 2));
                totalCurrentMass += currentWeaponThree.getMass();
                totalConsumptionRate += currentWeaponThree.getReactorDrain() * weaponDrainMultiplier;
            }else{
                loadoutWeaponThreeReactorDrain.setText("0.00");
            }

            Weapon currentWeaponFour = (Weapon) loadoutWeaponFour.getValue();

            if(currentWeaponFour != null) {
                loadoutWeaponFourReactorDrain.setText(doubleToString(currentWeaponFour.getReactorDrain() * weaponDrainMultiplier, 2));
                totalCurrentMass += currentWeaponFour.getMass();
                totalConsumptionRate += currentWeaponFour.getReactorDrain() * weaponDrainMultiplier;
            }else{
                loadoutWeaponFourReactorDrain.setText("0.00");
            }

            Ordnance currentOrdnanceOne = (Ordnance) loadoutOrdnanceOne.getValue();

            if(currentOrdnanceOne != null) {
                loadoutOrdnanceOneReactorDrain.setText(doubleToString(currentOrdnanceOne.getReactorDrain() * weaponDrainMultiplier, 2));
                totalCurrentMass += currentOrdnanceOne.getMass();
                totalConsumptionRate += currentOrdnanceOne.getReactorDrain() * weaponDrainMultiplier;
            }else{
                loadoutOrdnanceOneReactorDrain.setText("0.00");
            }

            Ordnance currentOrdnanceTwo = (Ordnance) loadoutOrdnanceTwo.getValue();

            if(currentOrdnanceTwo != null) {
                loadoutOrdnanceTwoReactorDrain.setText(doubleToString(currentOrdnanceTwo.getReactorDrain() * weaponDrainMultiplier, 2));
                totalCurrentMass += currentOrdnanceTwo.getMass();
                totalConsumptionRate += currentOrdnanceTwo.getReactorDrain() * weaponDrainMultiplier;
            }else{
                loadoutOrdnanceTwoReactorDrain.setText("0.00");
            }

            Ordnance currentOrdnanceThree = (Ordnance) loadoutOrdnanceThree.getValue();

            if(currentOrdnanceThree != null) {
                loadoutOrdnanceOneReactorDrain.setText(doubleToString(currentOrdnanceThree.getReactorDrain() * weaponDrainMultiplier, 2));
                totalCurrentMass += currentOrdnanceThree.getMass();
                totalConsumptionRate += currentOrdnanceThree.getReactorDrain() * weaponDrainMultiplier;
            }else{
                loadoutOrdnanceThreeReactorDrain.setText("0.00");
            }
            
            loadoutConsumptionRate.setText(doubleToString(totalConsumptionRate, 2));
            loadoutEnergyDifference.setText(doubleToString(totalGenerationRate - totalConsumptionRate, 2));
            loadoutMaximumMass.setText(doubleToString(currentLoadout.getChassis().getMass(), 2));
            loadoutCurrentMass.setText(doubleToString(totalCurrentMass, 2));
            loadoutMassDifference.setText(doubleToString(currentLoadout.getChassis().getMass() - totalCurrentMass, 2));

            if(Math.signum(currentLoadout.getChassis().getMass() - totalCurrentMass) == -1.0f) {
                loadoutMassDifference.setTextFill(Color.web("#e50909"));
            } else {
                loadoutMassDifference.setTextFill(Color.web("#25d025"));
            }
            
            if(Math.signum(totalGenerationRate - totalConsumptionRate) == -1.0f) {
                loadoutEnergyDifference.setTextFill(Color.web("#e50909"));
            } else {
                loadoutEnergyDifference.setTextFill(Color.web("#25d025"));
            }
            
            requiredGenerationOne.setText(doubleToString((totalConsumptionRate / reactorGenerationMultiplier) / 1.02, 2));
            requiredGenerationTwo.setText(doubleToString((totalConsumptionRate / reactorGenerationMultiplier) / 1.03, 2));
            requiredGenerationThree.setText(doubleToString((totalConsumptionRate / reactorGenerationMultiplier) / 1.04, 2));
            requiredGenerationFour.setText(doubleToString((totalConsumptionRate / reactorGenerationMultiplier) / 1.05, 2));
            requiredGenerationFive.setText(doubleToString((totalConsumptionRate / reactorGenerationMultiplier) / 1.06, 2));
            requiredGenerationSix.setText(doubleToString((totalConsumptionRate / reactorGenerationMultiplier) / 1.07, 2));
        }
    }

    private void resetREFields() {
        REComponentFieldOneTextbox.setText("0.00");
        REComponentFieldTwoTextbox.setText("0.00");
        REComponentFieldThreeTextbox.setText("0.00");
        REComponentFieldFourTextbox.setText("0.00");
        REComponentFieldFiveTextbox.setText("0.00");
        REComponentFieldSixTextbox.setText("0.00");
        REComponentFieldSevenTextbox.setText("0.00");
        REComponentFieldEightTextbox.setText("0.00");
        REComponentFieldNineTextbox.setText("0.00");
        REComponentFieldTenTextbox.setText("0.00");
        
        REComponentFieldOneResult.setText("0.00");
        REComponentFieldTwoResult.setText("0.00");
        REComponentFieldThreeResult.setText("0.00");
        REComponentFieldFourResult.setText("0.00");
        REComponentFieldFiveResult.setText("0.00");
        REComponentFieldSixResult.setText("0.00");
        REComponentFieldSevenResult.setText("0.00");
        REComponentFieldEightResult.setText("0.00");
        REComponentFieldNineResult.setText("0.00");
        REComponentFieldTenResult.setText("0.00");
     
        REComponentFieldContainerOne.setVisible(false);
        REComponentFieldContainerTwo.setVisible(false);
        REComponentFieldContainerThree.setVisible(false);
        REComponentFieldContainerFour.setVisible(false);
        REComponentFieldContainerFive.setVisible(false);
        REComponentFieldContainerSix.setVisible(false);
        REComponentFieldContainerSeven.setVisible(false);
        REComponentFieldContainerEight.setVisible(false);
        REComponentFieldContainerNine.setVisible(false);
        REComponentFieldContainerTen.setVisible(false);
    }
   
    @FXML
    public void setREBonus() {
        
        statQualityContainer.setVisible(true);
        reverseEngineeringContainer.setVisible(true);
        
        String level = REComponentLevel.getValue().toString();
        
        switch(level) {
            case "1":
                REBonus.setText("2% bonus");
                break;
            case "2":
                REBonus.setText("3% bonus");
                break;
            case "3":
                REBonus.setText("3% bonus");
                break;
            case "4":
                REBonus.setText("4% bonus");
                break;
            case "5":
                REBonus.setText("4% bonus");
                break;
            case "6":
                REBonus.setText("5% bonus");
                break;
            case "7":
                REBonus.setText("5% bonus");
                break;
            case "8":
                REBonus.setText("6% bonus");
                break;
            case "9":
                REBonus.setText("6% bonus");
                break;
            case "10":
                REBonus.setText("7% bonus");
                break;
            default :
                REBonus.setText("0% bonus");
                break;                
        }
    }
    
    @FXML
    public void reverseEngineer() {
        
        String level = REComponentLevel.getValue().toString();
        String type = REComponentType.getValue().toString();
        Double bonusValue = 0.0;
        
        switch(level) {
            case "1":
                bonusValue = 0.02;
                break;
            case "2":
                bonusValue = 0.03;
                break;
            case "3":
                bonusValue = 0.03;
                break;
            case "4":
                bonusValue = 0.04;
                break;
            case "5":
                bonusValue = 0.04;
                break;
            case "6":
                bonusValue = 0.05;
                break;
            case "7":
                bonusValue = 0.05;
                break;
            case "8":
                bonusValue = 0.06;
                break;
            case "9":
                bonusValue = 0.06;
                break;
            case "10":
                bonusValue = 0.07;
                break;
            default :
                bonusValue = 0.00;
                break;                
        }
        if(type.equals("Reactor")){
            
            Double armor = Double.parseDouble(REComponentFieldOneTextbox.getText());
            Double hitpoints = Double.parseDouble(REComponentFieldTwoTextbox.getText());
            Double mass = Double.parseDouble(REComponentFieldThreeTextbox.getText());
            Double generation = Double.parseDouble(REComponentFieldFourTextbox.getText());
            
            REComponentFieldOneResult.setText(doubleToString((armor * (1.0 + bonusValue)), 2));
            REComponentFieldTwoResult.setText(doubleToString((hitpoints * (1.0 + bonusValue)), 2));
            REComponentFieldThreeResult.setText(doubleToString((mass * (1.0 - bonusValue)), 2));
            REComponentFieldFourResult.setText(doubleToString((generation * (1.0 + bonusValue)), 2));
        
        }else if(type.equals("Engine")){
            
            Double armor = Double.parseDouble(REComponentFieldOneTextbox.getText());
            Double hitpoints = Double.parseDouble(REComponentFieldTwoTextbox.getText());
            Double drain = Double.parseDouble(REComponentFieldThreeTextbox.getText());
            Double mass = Double.parseDouble(REComponentFieldFourTextbox.getText());
            Double pitch = Double.parseDouble(REComponentFieldFiveTextbox.getText());
            Double yaw = Double.parseDouble(REComponentFieldSixTextbox.getText());
            Double roll = Double.parseDouble(REComponentFieldSevenTextbox.getText());
            Double speed = Double.parseDouble(REComponentFieldEightTextbox.getText());
            
            REComponentFieldOneResult.setText(doubleToString((armor * (1.0 + bonusValue)), 2));
            REComponentFieldTwoResult.setText(doubleToString((hitpoints * (1.0 + bonusValue)), 2));
            REComponentFieldThreeResult.setText(doubleToString((drain * (1.0 - bonusValue)), 2));
            REComponentFieldFourResult.setText(doubleToString((mass * (1.0 - bonusValue)), 2));
            REComponentFieldFiveResult.setText(doubleToString((pitch * (1.0 + bonusValue)), 2));
            REComponentFieldSixResult.setText(doubleToString((yaw * (1.0 + bonusValue)), 2));
            REComponentFieldSevenResult.setText(doubleToString((roll * (1.0 + bonusValue)), 2));
            REComponentFieldEightResult.setText(doubleToString((speed * (1.0 + bonusValue)), 2));
       
        }else if(type.equals("Shield")){
            
            Double armor = Double.parseDouble(REComponentFieldOneTextbox.getText());
            Double hitpoints = Double.parseDouble(REComponentFieldTwoTextbox.getText());
            Double drain = Double.parseDouble(REComponentFieldThreeTextbox.getText());
            Double mass = Double.parseDouble(REComponentFieldFourTextbox.getText());
            Double front = Double.parseDouble(REComponentFieldFiveTextbox.getText());
            Double rear = Double.parseDouble(REComponentFieldSixTextbox.getText());
            Double recharge = Double.parseDouble(REComponentFieldSevenTextbox.getText());
            
            REComponentFieldOneResult.setText(doubleToString((armor * (1.0 + bonusValue)), 2));
            REComponentFieldTwoResult.setText(doubleToString((hitpoints * (1.0 + bonusValue)), 2));
            REComponentFieldThreeResult.setText(doubleToString((drain * (1.0 - bonusValue)), 2));
            REComponentFieldFourResult.setText(doubleToString((mass * (1.0 - bonusValue)), 2));
            REComponentFieldFiveResult.setText(doubleToString((front * (1.0 + bonusValue)), 2));
            REComponentFieldSixResult.setText(doubleToString((rear * (1.0 + bonusValue)), 2));
            REComponentFieldSevenResult.setText(doubleToString((recharge * (1.0 + bonusValue)), 2));
        
        }else if(type.equals("Armor")){
            
            Double armor = Double.parseDouble(REComponentFieldOneTextbox.getText());
            Double hitpoints = Double.parseDouble(REComponentFieldTwoTextbox.getText());
            Double mass = Double.parseDouble(REComponentFieldThreeTextbox.getText());
            
            REComponentFieldOneResult.setText(doubleToString((armor * (1.0 + bonusValue)), 2));
            REComponentFieldTwoResult.setText(doubleToString((hitpoints * (1.0 + bonusValue)), 2));
            REComponentFieldThreeResult.setText(doubleToString((mass * (1.0 - bonusValue)), 2));
        
        }else if(type.equals("Capacitor")){
            
            Double armor = Double.parseDouble(REComponentFieldOneTextbox.getText());
            Double hitpoints = Double.parseDouble(REComponentFieldTwoTextbox.getText());
            Double drain = Double.parseDouble(REComponentFieldThreeTextbox.getText());
            Double mass = Double.parseDouble(REComponentFieldFourTextbox.getText());
            Double energy = Double.parseDouble(REComponentFieldFiveTextbox.getText());
            Double recharge = Double.parseDouble(REComponentFieldSixTextbox.getText());
            
            REComponentFieldOneResult.setText(doubleToString((armor * (1.0 + bonusValue)), 2));
            REComponentFieldTwoResult.setText(doubleToString((hitpoints * (1.0 + bonusValue)), 2));
            REComponentFieldThreeResult.setText(doubleToString((drain * (1.0 - bonusValue)), 2));
            REComponentFieldFourResult.setText(doubleToString((mass * (1.0 - bonusValue)), 2));
            REComponentFieldFiveResult.setText(doubleToString((energy * (1.0 + bonusValue)), 2));
            REComponentFieldSixResult.setText(doubleToString((recharge * (1.0 + bonusValue)), 2));
       
        }else if(type.equals("Booster")){
            
            Double armor = Double.parseDouble(REComponentFieldOneTextbox.getText());
            Double hitpoints = Double.parseDouble(REComponentFieldTwoTextbox.getText());
            Double drain = Double.parseDouble(REComponentFieldThreeTextbox.getText());
            Double mass = Double.parseDouble(REComponentFieldFourTextbox.getText());
            Double energy = Double.parseDouble(REComponentFieldFiveTextbox.getText());
            Double recharge = Double.parseDouble(REComponentFieldSixTextbox.getText());
            Double consumption = Double.parseDouble(REComponentFieldSevenTextbox.getText());
            Double speed = Double.parseDouble(REComponentFieldEightTextbox.getText());
            
            REComponentFieldOneResult.setText(doubleToString((armor * (1.0 + bonusValue)), 2));
            REComponentFieldTwoResult.setText(doubleToString((hitpoints * (1.0 + bonusValue)), 2));
            REComponentFieldThreeResult.setText(doubleToString((drain * (1.0 - bonusValue)), 2));
            REComponentFieldFourResult.setText(doubleToString((mass * (1.0 - bonusValue)), 2));
            REComponentFieldFiveResult.setText(doubleToString((energy * (1.0 + bonusValue)), 2));
            REComponentFieldSixResult.setText(doubleToString((recharge * (1.0 + bonusValue)), 2));
            REComponentFieldSevenResult.setText(doubleToString((consumption * (1.0 - bonusValue)), 2));
            REComponentFieldEightResult.setText(doubleToString((speed * (1.0 + bonusValue)), 2));
       
        }else if(type.equals("Droid Interface")){
            
            Double armor = Double.parseDouble(REComponentFieldOneTextbox.getText());
            Double hitpoints = Double.parseDouble(REComponentFieldTwoTextbox.getText());
            Double drain = Double.parseDouble(REComponentFieldThreeTextbox.getText());
            Double mass = Double.parseDouble(REComponentFieldFourTextbox.getText());
            Double speed = Double.parseDouble(REComponentFieldFiveTextbox.getText());
            
            REComponentFieldOneResult.setText(doubleToString((armor * (1.0 + bonusValue)), 2));
            REComponentFieldTwoResult.setText(doubleToString((hitpoints * (1.0 + bonusValue)), 2));
            REComponentFieldThreeResult.setText(doubleToString((drain * (1.0 - bonusValue)), 2));
            REComponentFieldFourResult.setText(doubleToString((mass * (1.0 - bonusValue)), 2));
            REComponentFieldFiveResult.setText(doubleToString((speed * (1.0 + bonusValue)), 2));
            
        }else if(type.equals("Weapon")){
            
            Double armor = Double.parseDouble(REComponentFieldOneTextbox.getText());
            Double hitpoints = Double.parseDouble(REComponentFieldTwoTextbox.getText());
            Double drain = Double.parseDouble(REComponentFieldThreeTextbox.getText());
            Double mass = Double.parseDouble(REComponentFieldFourTextbox.getText());
            Double minDamage = Double.parseDouble(REComponentFieldFiveTextbox.getText());
            Double maxDamage = Double.parseDouble(REComponentFieldSixTextbox.getText());
            Double vsShield = Double.parseDouble(REComponentFieldSevenTextbox.getText());
            Double vsArmor = Double.parseDouble(REComponentFieldEightTextbox.getText());
            Double eps = Double.parseDouble(REComponentFieldNineTextbox.getText());
            Double refire = Double.parseDouble(REComponentFieldTenTextbox.getText());
            
            REComponentFieldOneResult.setText(doubleToString((armor * (1.0 + bonusValue)), 2));
            REComponentFieldTwoResult.setText(doubleToString((hitpoints * (1.0 + bonusValue)), 2));
            REComponentFieldThreeResult.setText(doubleToString((drain * (1.0 - bonusValue)), 2));
            REComponentFieldFourResult.setText(doubleToString((mass * (1.0 - bonusValue)), 2));
            REComponentFieldFiveResult.setText(doubleToString((minDamage * (1.0 + bonusValue)), 2));
            REComponentFieldSixResult.setText(doubleToString((maxDamage * (1.0 + bonusValue)), 2));
            REComponentFieldSevenResult.setText(doubleToString((vsShield * (1.0 + bonusValue)), 2));
            REComponentFieldEightResult.setText(doubleToString((vsArmor * (1.0 + bonusValue)), 2));
            REComponentFieldNineResult.setText(doubleToString((eps * (1.0 - bonusValue)), 2));
            REComponentFieldTenResult.setText(doubleToString((refire * (1.0 - bonusValue)), 2));
        }
        
    }

    @FXML
    public void clearComponent(ActionEvent event){
        Button button = (Button) event.getSource();
        
        switch(button.getId()){
            case "clearReactorBtn" :
                loadoutReactor.getSelectionModel().clearSelection();
                break;
            case "clearEngineBtn" :
                loadoutEngine.getSelectionModel().clearSelection();
                break;
            case "clearShieldBtn" :
                loadoutShield.getSelectionModel().clearSelection();
                break;
            case "clearBoosterBtn" :
                loadoutBooster.getSelectionModel().clearSelection();
                break;
            case "clearInterfaceBtn" :
                loadoutInterface.getSelectionModel().clearSelection();
                break;
            case "clearCountermeasuresBtn" :
                loadoutCountermeasure.getSelectionModel().clearSelection();
                break;
            case "clearFrontArmorBtn" :
                loadoutFrontArmor.getSelectionModel().clearSelection();
                break;
            case "clearRearArmorBtn" :
                loadoutRearArmor.getSelectionModel().clearSelection();
                break;
            case "clearWeaponOneBtn" :
                loadoutWeaponOne.getSelectionModel().clearSelection();
                break;
            case "clearWeaponTwoBtn" :
                loadoutWeaponTwo.getSelectionModel().clearSelection();
                break;
            case "clearWeaponThreeBtn" :
                loadoutWeaponThree.getSelectionModel().clearSelection();
                break;
            case "clearWeaponFourBtn" :
                loadoutWeaponFour.getSelectionModel().clearSelection();
                break;
            case "clearCapacitorBtn" :
                loadoutCapacitor.getSelectionModel().clearSelection();
                break;
            case "clearOrdnanceOneBtn" :
                loadoutOrdnanceOne.getSelectionModel().clearSelection();
                break;
            case "clearOrdnanceTwoBtn" :
                loadoutOrdnanceTwo.getSelectionModel().clearSelection();
                break;
            case "clearOrdnanceThreeBtn" :
                loadoutOrdnanceThree.getSelectionModel().clearSelection();
                break;
        }
    }
    
    @FXML
    public void clearCurrentLoadout(){
        loadoutReactor.getSelectionModel().clearSelection();
        loadoutEngine.getSelectionModel().clearSelection();
        loadoutShield.getSelectionModel().clearSelection();
        loadoutCapacitor.getSelectionModel().clearSelection();
        loadoutBooster.getSelectionModel().clearSelection();
        loadoutCountermeasure.getSelectionModel().clearSelection();
        loadoutFrontArmor.getSelectionModel().clearSelection();
        loadoutRearArmor.getSelectionModel().clearSelection();
        loadoutInterface.getSelectionModel().clearSelection();
        loadoutWeaponOne.getSelectionModel().clearSelection();
        loadoutWeaponTwo.getSelectionModel().clearSelection();
        loadoutWeaponThree.getSelectionModel().clearSelection();
        loadoutWeaponFour.getSelectionModel().clearSelection();
        loadoutOrdnanceOne.getSelectionModel().clearSelection();
        loadoutOrdnanceTwo.getSelectionModel().clearSelection();
        loadoutOrdnanceThree.getSelectionModel().clearSelection();
        
        updateLoadoutReport();
    }
}
