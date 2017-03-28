package jtl.toolkit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import jtl.toolkit.helpers.ComponentSaveHelper;
import jtl.toolkit.models.Armor;
import jtl.toolkit.models.Booster;
import jtl.toolkit.models.Capacitor;
import jtl.toolkit.models.Countermeasure;
import jtl.toolkit.models.DroidInterface;
import jtl.toolkit.models.Engine;
import jtl.toolkit.models.Ordnance;
import jtl.toolkit.models.Reactor;
import jtl.toolkit.models.Shield;
import jtl.toolkit.models.Weapon;

public class ToolkitController implements Initializable {
    
    ComponentSaveHelper saveHelper;
    
    // <editor-fold defaultstate="collapsed" desc="FXML Variables">


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
        
        this.reactors = new ArrayList<>();
        this.engines = new ArrayList<>();
        this.shields = new ArrayList<>();
        this.armors = new ArrayList<>();
        this.interfaces = new ArrayList<>();
        this.boosters = new ArrayList<>();
        this.capacitors = new ArrayList<>();
        this.weapons = new ArrayList<>();
        this.ordnance = new ArrayList<>();
        this.countermeasures = new ArrayList<>();
        
        
        // Load Components
        this.loadReactors();
        
        // Load Tables
        this.reloadComponentTables();
        
        this.reactorTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            this.removeComponentButton.setVisible(true);
        });
        
        
        System.out.println("Initialized...");
    }    
    
    @FXML
    private void saveNewComponent(ActionEvent event) {
        
        String componentType = (String) this.newComponentType.getValue();
        
        if(this.newComponentName.getText().length() > 0) {
            this.newComponentName.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
            
            if(componentType.equals("Reactor")){
            
                Reactor reactor = new Reactor();

                if(this.validateNumericFields()){

                    reactor.setComponentName(this.newComponentName.getText());
                    reactor.setComponentNotes(this.newComponentNotes.getText());
                    reactor.setLevel(Integer.parseInt(this.newComponentLevel.getValue().toString()));

                    reactor.setArmor(Double.parseDouble(this.newComponentFieldOneTextbox.getText()));
                    reactor.setHitpoints(Double.parseDouble(this.newComponentFieldTwoTextbox.getText()));
                    reactor.setMass(Double.parseDouble(this.newComponentFieldThreeTextbox.getText()));
                    reactor.setGenerationRate(Double.parseDouble(this.newComponentFieldFourTextbox.getText()));

                    this.reactors.add(reactor);

                    try (Writer writer = new FileWriter("components/reactors.json")) {
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        gson.toJson(this.reactors, writer);
                    } catch (IOException ex) {
                        Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    reloadComponentTables();

                    this.newComponentMessage.setStyle("-fx-text-fill: green; -fx-font-weight: bold;");
                    this.newComponentMessage.setText("Component saved...");
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
    
    public boolean validateNumericFields() {
        
        boolean valid = true;
        
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
            valid = false;
            this.newComponentFieldOneTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldTwo) || isInteger(fieldTwo)) {
            this.newComponentFieldTwoTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            valid = false;
            this.newComponentFieldTwoTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldThree) || isInteger(fieldThree)) {
            this.newComponentFieldThreeTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            valid = false;
            this.newComponentFieldThreeTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldFour) || isInteger(fieldFour)) {
            this.newComponentFieldFourTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            valid = false;
            this.newComponentFieldFourTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldFive) || isInteger(fieldFive)) {
            this.newComponentFieldFiveTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            valid = false;
            this.newComponentFieldFiveTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldSix) || isInteger(fieldSix)) {
            this.newComponentFieldSixTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            valid = false;
            this.newComponentFieldSixTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldSeven) || isInteger(fieldSeven)) { 
            this.newComponentFieldSevenTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            valid = false;
            this.newComponentFieldSevenTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldEight) || isInteger(fieldEight)) {
            this.newComponentFieldEightTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            valid = false;
            this.newComponentFieldEightTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldNine) || isInteger(fieldNine)) {
            this.newComponentFieldNineTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            valid = false;
            this.newComponentFieldNineTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        if(isDouble(fieldTen) || isInteger(fieldTen)) {
            this.newComponentFieldTenTextbox.setStyle("-fx-text-fill: black; -fx-font-weight: regular;");
        } else {
            valid = false;
            this.newComponentFieldTenTextbox.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        }
        
        return valid;
    }
    
    public void loadReactors(){
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("components/reactors.json")));
            
            ArrayList<Reactor> reactors = new ArrayList<>();
            
            reactors = new Gson().fromJson(jsonString, new TypeToken<List<Reactor>>(){}.getType());
            
            if(reactors != null){
                this.reactors = reactors;
            }
            
        } catch (IOException ex) {
            this.reactors = new ArrayList<>();
            
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error while loading your reactors...");
            alert.setContentText("How embarassing! Message Orickk on Discord with some details.");

            alert.showAndWait();
            
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void reloadComponentTables() {
        
        this.reactorTable.setItems(FXCollections.observableArrayList(reactors));
        this.reactorTable.setColumnResizePolicy((param) -> true );
    }
    
    @FXML
    private void removeComponent() {
        // TODO: get current table and switch
        this.removeReactor();
        this.reloadComponentTables();
        this.removeComponentButton.setVisible(false);
    }
    
    private void removeReactor() {
        
        Reactor reactor = (Reactor) this.reactorTable.getSelectionModel().getSelectedItem();
        
        for(int i = 0; i < this.reactors.size(); i++) {
            if(reactor.getComponentID().equals(this.reactors.get(i).getComponentID())){
                this.reactors.remove(i);
                break;
            }
        }
        
        saveHelper.saveReactors(this.reactors);
    }
}
