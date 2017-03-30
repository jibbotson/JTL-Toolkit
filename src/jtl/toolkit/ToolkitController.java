package jtl.toolkit;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import jtl.toolkit.helpers.ComponentHelper;
import jtl.toolkit.helpers.LoadoutHelper;
import jtl.toolkit.helpers.ValidationHelper;
import jtl.toolkit.models.Armor;
import jtl.toolkit.models.Booster;
import jtl.toolkit.models.Capacitor;
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
    
    ArrayList<Loadout> loadouts;
    
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
    @FXML ComboBox newComponentType;
    @FXML ComboBox newComponentLevel;
    
    // </editor-fold>
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        componentHelper = new ComponentHelper();
        loadoutHelper = new LoadoutHelper();
        validationHelper = new ValidationHelper();
                   
        // Load Components
        reactors = componentHelper.getReactors();
        engines = componentHelper.getEngines();
        shields = componentHelper.getShields();
        armors = componentHelper.getArmors();
        boosters = componentHelper.getBoosters();
        capacitors = componentHelper.getCapacitors();
        interfaces = componentHelper.getInterfaces();
        weapons = componentHelper.getWeapons();
        ordnance = componentHelper.getOrdnance();
        countermeasures = componentHelper.getCountermeasures();
        
        // Load loadouts
        loadouts = loadoutHelper.getLoadouts();
        
        // Load Tables
        reloadComponentTables();
        
        reactorTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            removeComponentButton.setVisible(true);
        });
    }    
    
    @FXML
    private void saveNewComponent(ActionEvent event) {
        
        String componentType = (String) this.newComponentType.getValue();
        
        if(this.newComponentName.getText().length() > 0) {
            this.newComponentName.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
            
            if(componentType.equals("Reactor")){
                            
                Validation validation = this.validateInputTypes();
                
                if (validation.validationResult) {
                    
                    Reactor reactor = new Reactor();
                 
                    reactor.setComponentName(this.newComponentName.getText());
                    reactor.setComponentNotes(this.newComponentNotes.getText());
                    reactor.setLevel(Integer.parseInt(this.newComponentLevel.getValue().toString()));
                    reactor.setArmor(Double.parseDouble(this.newComponentFieldOneTextbox.getText()));
                    reactor.setHitpoints(Double.parseDouble(this.newComponentFieldTwoTextbox.getText()));
                    reactor.setMass(Double.parseDouble(this.newComponentFieldThreeTextbox.getText()));
                    reactor.setGenerationRate(Double.parseDouble(this.newComponentFieldFourTextbox.getText()));
                    
                    validation = validationHelper.validateReactor(validation, reactor);
                    
                    if(validation.validationResult){
                        
                        this.reactors.add(reactor);

                        componentHelper.saveReactors(this.reactors);

                        reloadComponentTables();

                        this.newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                        this.newComponentMessage.setText("Component saved...");

                    } else {
                        for(int i = 0; i < validation.statsInError.size(); i++) {
                            System.out.println(validation.statsInError.get(i));
                            System.out.println(validation.reasonsForError.get(i));
                        }
                    }
                    
                } else {
                    this.newComponentMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
                    this.newComponentMessage.setText("Component values must only contain numbers...");
                }
                
            }else if(componentType.equals("Engine")){

            }else if(componentType.equals("Shield")){

            }else if(componentType.equals("Armor")){

            }else if(componentType.equals("Droid Interface")){

            }else if(componentType.equals("Weapon")){

            }else if(componentType.equals("Ordnance")){

            }else if(componentType.equals("Countermeasure")){

            }else if(componentType.equals("Booster")){

            }else if(componentType.equals("Capacitor")){ 

            }
        } else {
            this.newComponentMessage.setText("You must provide a component name...");
            this.newComponentMessage.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
    }
    
    @FXML
    private void showNewComponentFields(ActionEvent event) {
        
        String componentType = (String) this.newComponentType.getValue();
        
        if(componentType.equals("Reactor")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_reactor.png"));
            
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Mass:");
            this.newComponentFieldFourLabel.setText("Generation Rate:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            this.newComponentFieldContainerFour.setVisible(true);
            
        }else if(componentType.equals("Engine")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_engine.png"));
            
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Energy Drain:");
            this.newComponentFieldFourLabel.setText("Mass:");
            this.newComponentFieldFiveLabel.setText("Pitch Rate:");
            this.newComponentFieldSixLabel.setText("Yaw Rate:");
            this.newComponentFieldSevenLabel.setText("Roll Rate:");
            this.newComponentFieldEightLabel.setText("Top Speed:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            this.newComponentFieldContainerFour.setVisible(true);
            this.newComponentFieldContainerFive.setVisible(true);
            this.newComponentFieldContainerSix.setVisible(true);
            this.newComponentFieldContainerSeven.setVisible(true);
            this.newComponentFieldContainerEight.setVisible(true);
            
        }else if(componentType.equals("Shield")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_shield.png"));
                 
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Energy Drain:");
            this.newComponentFieldFourLabel.setText("Mass:");
            this.newComponentFieldFiveLabel.setText("Front Hitpoints:");
            this.newComponentFieldSixLabel.setText("Back Hitpoints:");
            this.newComponentFieldSevenLabel.setText("Recharge Rate:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            this.newComponentFieldContainerFour.setVisible(true);
            this.newComponentFieldContainerFive.setVisible(true);
            this.newComponentFieldContainerSix.setVisible(true);
            this.newComponentFieldContainerSeven.setVisible(true);
            
        }else if(componentType.equals("Armor")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_armor.png"));
            
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Mass:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            
        }else if(componentType.equals("Droid Interface")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_droid_interface.png"));
            
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Energy Drain:");
            this.newComponentFieldFourLabel.setText("Mass:");
            this.newComponentFieldFiveLabel.setText("Command Speed:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            this.newComponentFieldContainerFour.setVisible(true);
            this.newComponentFieldContainerFive.setVisible(true);
            
        }else if(componentType.equals("Weapon")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_weapon.png"));
            
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Energy Drain:");
            this.newComponentFieldFourLabel.setText("Mass:");
            this.newComponentFieldFiveLabel.setText("Minimum Damage:");
            this.newComponentFieldSixLabel.setText("Maximum Damage:");
            this.newComponentFieldSevenLabel.setText("Vs. Shields:");
            this.newComponentFieldEightLabel.setText("Vs. Armor:");
            this.newComponentFieldNineLabel.setText("Energy Per Shot:");
            this.newComponentFieldTenLabel.setText("Refire Rate:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            this.newComponentFieldContainerFour.setVisible(true);
            this.newComponentFieldContainerFive.setVisible(true);
            this.newComponentFieldContainerSix.setVisible(true);
            this.newComponentFieldContainerSeven.setVisible(true);
            this.newComponentFieldContainerEight.setVisible(true);
            this.newComponentFieldContainerNine.setVisible(true);
            this.newComponentFieldContainerTen.setVisible(true);
            
        }else if(componentType.equals("Ordnance")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_ordnance.png"));
            
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Energy Drain:");
            this.newComponentFieldFourLabel.setText("Mass:");
            this.newComponentFieldFiveLabel.setText("Minimum Damage:");
            this.newComponentFieldSixLabel.setText("Maximum Damage:");
            this.newComponentFieldSevenLabel.setText("Vs. Shields:");
            this.newComponentFieldEightLabel.setText("Vs. Armor:");
            this.newComponentFieldNineLabel.setText("Refire Rate:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            this.newComponentFieldContainerFour.setVisible(true);
            this.newComponentFieldContainerFive.setVisible(true);
            this.newComponentFieldContainerSix.setVisible(true);
            this.newComponentFieldContainerSeven.setVisible(true);
            this.newComponentFieldContainerEight.setVisible(true);
            this.newComponentFieldContainerNine.setVisible(true);
            
        }else if(componentType.equals("Countermeasure")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_ordnance.png"));
            
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Energy Drain:");
            this.newComponentFieldFourLabel.setText("Mass:");
            this.newComponentFieldFiveLabel.setText("Minimum Chance:");
            this.newComponentFieldSixLabel.setText("Maximum Chance:");
            this.newComponentFieldSevenLabel.setText("Refire Rate:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            this.newComponentFieldContainerFour.setVisible(true);
            this.newComponentFieldContainerFive.setVisible(true);
            this.newComponentFieldContainerSix.setVisible(true);
            this.newComponentFieldContainerSeven.setVisible(true);
            
        }else if(componentType.equals("Booster")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_booster.png"));
            
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Energy Drain:");
            this.newComponentFieldFourLabel.setText("Mass:");
            this.newComponentFieldFiveLabel.setText("Energy:");
            this.newComponentFieldSixLabel.setText("Recharge Rate:");
            this.newComponentFieldSevenLabel.setText("Consumption Rate:");
            this.newComponentFieldEightLabel.setText("Top Speed:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            this.newComponentFieldContainerFour.setVisible(true);
            this.newComponentFieldContainerFive.setVisible(true);
            this.newComponentFieldContainerSix.setVisible(true);
            this.newComponentFieldContainerSeven.setVisible(true);
            this.newComponentFieldContainerEight.setVisible(true);
            
        }else if(componentType.equals("Capacitor")){
            this.resetFields();
            this.newComponentImage.setImage(new Image("images/asset_capacitor.png"));
            
            // Set labels
            this.newComponentFieldOneLabel.setText("Armor:");
            this.newComponentFieldTwoLabel.setText("Hitpoints:");
            this.newComponentFieldThreeLabel.setText("Energy Drain:");
            this.newComponentFieldFourLabel.setText("Mass:");
            this.newComponentFieldFiveLabel.setText("Energy:");
            this.newComponentFieldSixLabel.setText("Recharge Rate:");
            
            // Show fields
            this.newComponentFieldContainerOne.setVisible(true);
            this.newComponentFieldContainerTwo.setVisible(true);
            this.newComponentFieldContainerThree.setVisible(true);
            this.newComponentFieldContainerFour.setVisible(true);
            this.newComponentFieldContainerFive.setVisible(true);
            this.newComponentFieldContainerSix.setVisible(true);
        }
    }
    
    // Utility functions
    public void resetFields(){
        this.newComponentFieldOneTextbox.setText("0.0");
        this.newComponentFieldTwoTextbox.setText("0.0");
        this.newComponentFieldThreeTextbox.setText("0.0");
        this.newComponentFieldFourTextbox.setText("0.0");
        this.newComponentFieldFiveTextbox.setText("0.0");
        this.newComponentFieldSixTextbox.setText("0.0");
        this.newComponentFieldSevenTextbox.setText("0.0");
        this.newComponentFieldEightTextbox.setText("0.0");
        this.newComponentFieldNineTextbox.setText("0.0");
        this.newComponentFieldTenTextbox.setText("0.0");
        
        this.newComponentFieldContainerOne.setVisible(false);
        this.newComponentFieldContainerTwo.setVisible(false);
        this.newComponentFieldContainerThree.setVisible(false);
        this.newComponentFieldContainerFour.setVisible(false);
        this.newComponentFieldContainerFive.setVisible(false);
        this.newComponentFieldContainerSix.setVisible(false);
        this.newComponentFieldContainerSeven.setVisible(false);
        this.newComponentFieldContainerEight.setVisible(false);
        this.newComponentFieldContainerNine.setVisible(false);
        this.newComponentFieldContainerTen.setVisible(false);
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
        
        validation.componentLevel = (Integer) this.newComponentLevel.getValue();
        validation.componentType = (String) this.newComponentType.getValue();
        
        String fieldOne = this.newComponentFieldOneTextbox.getText();
        String fieldTwo = this.newComponentFieldTwoTextbox.getText();
        String fieldThree = this.newComponentFieldThreeTextbox.getText();
        String fieldFour = this.newComponentFieldFourTextbox.getText();
        String fieldFive = this.newComponentFieldFiveTextbox.getText();
        String fieldSix = this.newComponentFieldSixTextbox.getText();
        String fieldSeven = this.newComponentFieldSevenTextbox.getText();
        String fieldEight = this.newComponentFieldEightTextbox.getText();
        String fieldNine = this.newComponentFieldNineTextbox.getText();
        String fieldTen = this.newComponentFieldTenTextbox.getText();
        
        if(isDouble(fieldOne) || isInteger(fieldOne)) {
            this.newComponentFieldOneTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldOneTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldTwo) || isInteger(fieldTwo)) {
            this.newComponentFieldTwoTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldTwoTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldThree) || isInteger(fieldThree)) {
            this.newComponentFieldThreeTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldThreeTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldFour) || isInteger(fieldFour)) {
            this.newComponentFieldFourTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldFourTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldFive) || isInteger(fieldFive)) {
            this.newComponentFieldFiveTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldFiveTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldSix) || isInteger(fieldSix)) {
            this.newComponentFieldSixTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldSixTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldSeven) || isInteger(fieldSeven)) { 
            this.newComponentFieldSevenTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldSevenTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldEight) || isInteger(fieldEight)) {
            this.newComponentFieldEightTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldEightTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldNine) || isInteger(fieldNine)) {
            this.newComponentFieldNineTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldNineTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldTen) || isInteger(fieldTen)) {
            this.newComponentFieldTenTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            validation.validationResult = false;
            this.newComponentFieldTenTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
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
                Reactor reactor = (Reactor) this.reactorTable.getSelectionModel().getSelectedItem();
                reactors = componentHelper.deleteReactor(reactors, reactor.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Reactor", reactor.getComponentID());
                reloadComponentTables();
                break;
            case 1 :
                Engine engine = (Engine) this.engineTable.getSelectionModel().getSelectedItem();
                engines = componentHelper.deleteEngine(engines, engine.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Engine", engine.getComponentID());
                reloadComponentTables();
                break;
            case 2 :
                Shield shield = (Shield) this.shieldTable.getSelectionModel().getSelectedItem();
                shields = componentHelper.deleteShield(shields, shield.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Shield", shield.getComponentID());
                reloadComponentTables();
                break;
            case 3 :
                Armor armor = (Armor) this.armorTable.getSelectionModel().getSelectedItem();
                armors = componentHelper.deleteArmor(armors, armor.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Armor", armor.getComponentID());
                reloadComponentTables();
                break;
            case 4 :
                Capacitor capacitor = (Capacitor) this.capacitorTable.getSelectionModel().getSelectedItem();
                capacitors = componentHelper.deleteCapacitor(capacitors, capacitor.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Capacitor", capacitor.getComponentID());
                reloadComponentTables();
                break;
            case 5 :
                Booster booster = (Booster) this.boosterTable.getSelectionModel().getSelectedItem();
                boosters = componentHelper.deleteBooster(boosters, booster.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Booster", booster.getComponentID());
                reloadComponentTables();
                break;
            case 6 :
                DroidInterface droidInterface = (DroidInterface) this.interfaceTable.getSelectionModel().getSelectedItem();
                interfaces = componentHelper.deleteInterface(interfaces, droidInterface.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Interface", droidInterface.getComponentID());
                reloadComponentTables();
                break;
            case 7 :
                Weapon weapon = (Weapon) this.weaponTable.getSelectionModel().getSelectedItem();
                weapons = componentHelper.deleteWeapon(weapons, weapon.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Weapon", weapon.getComponentID());
                reloadComponentTables();
                break;
            case 8 :
                Ordnance ordnanceLauncher = (Ordnance) this.ordnanceTable.getSelectionModel().getSelectedItem();
                ordnance = componentHelper.deleteOrdnance(ordnance, ordnanceLauncher.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Ordnance", ordnanceLauncher.getComponentID());
                reloadComponentTables();
                break;
            case 9 :
                Countermeasure countermeasure = (Countermeasure) this.countermeasureTable.getSelectionModel().getSelectedItem();
                countermeasures = componentHelper.deleteCountermeasure(countermeasures, countermeasure.getComponentID());
                loadouts = loadoutHelper.updateLoadouts(loadouts, "Countermeasure", countermeasure.getComponentID());
                reloadComponentTables();
                break;
        }
        
        this.reloadComponentTables();
        this.removeComponentButton.setVisible(false);
    }
    
    
}
