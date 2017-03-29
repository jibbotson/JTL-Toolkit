package jtl.toolkit.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import jtl.toolkit.ToolkitController;
import jtl.toolkit.models.Armor;
import jtl.toolkit.models.Capacitor;
import jtl.toolkit.models.Countermeasure;
import jtl.toolkit.models.DroidInterface;
import jtl.toolkit.models.Engine;
import jtl.toolkit.models.Ordnance;
import jtl.toolkit.models.Reactor;
import jtl.toolkit.models.Shield;
import jtl.toolkit.models.Weapon;

public class ComponentSaveHelper {
    
    public void saveReactors(ArrayList<Reactor> reactors) {
        try (Writer writer = new FileWriter("components/reactors.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(reactors, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveEngines(ArrayList<Engine> engines) {
        try (Writer writer = new FileWriter("components/engines.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(engines, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveShields(ArrayList<Shield> shields) {
        try (Writer writer = new FileWriter("components/shields.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(shields, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveArmors(ArrayList<Armor> armors) {
        try (Writer writer = new FileWriter("components/armors.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(armors, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveCapacitors(ArrayList<Capacitor> capacitors) {
        try (Writer writer = new FileWriter("components/capacitors.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(capacitors, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveWeapons(ArrayList<Weapon> weapons) {
        try (Writer writer = new FileWriter("components/weapons.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(weapons, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveInterfaces(ArrayList<DroidInterface> interfaces) {
        try (Writer writer = new FileWriter("components/interfaces.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(interfaces, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveOrdnance(ArrayList<Ordnance> ordnance) {
        try (Writer writer = new FileWriter("components/ordnance.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(ordnance, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveCountermeasures(ArrayList<Countermeasure> countermeasures) {
        try (Writer writer = new FileWriter("components/countermeasures.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(countermeasures, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
