package jtl.toolkit.helpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class ComponentHelper {
    
    public ArrayList<Reactor> getReactors(){
        
        ArrayList<Reactor> reactors = new ArrayList<>();
        System.out.println("hihi");
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/reactors.json")));
            System.out.println(jsonString);
            reactors = new Gson().fromJson(jsonString, new TypeToken<List<Reactor>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reactors;
    }
    
    public ArrayList<Engine> getEngines(){
        
        ArrayList<Engine> engines = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/engines.json")));
            
            engines = new Gson().fromJson(jsonString, new TypeToken<List<Engine>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return engines;
    }
    
    public ArrayList<Shield> getShields(){
        
        ArrayList<Shield> shields = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/shields.json")));
            
            shields = new Gson().fromJson(jsonString, new TypeToken<List<Armor>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return shields;
    }
    
    public ArrayList<Armor> getArmors(){
        
        ArrayList<Armor> armors = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/armors.json")));
            
            armors = new Gson().fromJson(jsonString, new TypeToken<List<Armor>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return armors;
    }
    
    public ArrayList<Booster> getBoosters(){
        
        ArrayList<Booster> boosters = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/boosters.json")));
            
            boosters = new Gson().fromJson(jsonString, new TypeToken<List<Booster>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return boosters;
    }
    
    public ArrayList<Capacitor> getCapacitors(){
        
        ArrayList<Capacitor> capacitors = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/capacitors.json")));
            
            capacitors = new Gson().fromJson(jsonString, new TypeToken<List<Capacitor>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return capacitors;
    }
    
    public ArrayList<DroidInterface> getInterfaces(){
        
        ArrayList<DroidInterface> interfaces = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/interfaces.json")));
            
            interfaces = new Gson().fromJson(jsonString, new TypeToken<List<DroidInterface>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return interfaces;
    }
    
    public ArrayList<Weapon> getWeapons(){
        
        ArrayList<Weapon> weapons = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/weapons.json")));
            
            weapons = new Gson().fromJson(jsonString, new TypeToken<List<Weapon>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return weapons;
    }
    
    public ArrayList<Ordnance> getOrdnance(){
        
        ArrayList<Ordnance> ordnance = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/ordnance.json")));
            
            ordnance = new Gson().fromJson(jsonString, new TypeToken<List<Ordnance>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ordnance;
    }
    
    public ArrayList<Countermeasure> getCountermeasures(){
        
        ArrayList<Countermeasure> countermeasures = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/components/countermeasures.json")));
            
            countermeasures = new Gson().fromJson(jsonString, new TypeToken<List<Countermeasure>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return countermeasures;
    } 
    
    public void saveReactors(ArrayList<Reactor> reactors) {
        try (Writer writer = new FileWriter("data/components/reactors.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(reactors, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveEngines(ArrayList<Engine> engines) {
        try (Writer writer = new FileWriter("data/components/engines.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(engines, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveShields(ArrayList<Shield> shields) {
        try (Writer writer = new FileWriter("data/components/shields.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(shields, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveBoosters(ArrayList<Booster> boosters) {
        try (Writer writer = new FileWriter("data/components/boosters.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(boosters, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveArmors(ArrayList<Armor> armors) {
        try (Writer writer = new FileWriter("data/components/armors.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(armors, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveCapacitors(ArrayList<Capacitor> capacitors) {
        try (Writer writer = new FileWriter("data/components/capacitors.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(capacitors, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveWeapons(ArrayList<Weapon> weapons) {
        try (Writer writer = new FileWriter("data/components/weapons.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(weapons, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveInterfaces(ArrayList<DroidInterface> interfaces) {
        try (Writer writer = new FileWriter("data/components/interfaces.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(interfaces, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveOrdnance(ArrayList<Ordnance> ordnance) {
        try (Writer writer = new FileWriter("data/components/ordnance.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(ordnance, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void saveCountermeasures(ArrayList<Countermeasure> countermeasures) {
        try (Writer writer = new FileWriter("data/components/countermeasures.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(countermeasures, writer);
        } catch (IOException ex) {
            Logger.getLogger(ComponentHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Reactor> deleteReactor(ArrayList<Reactor> reactors, UUID reactorID) {
        
        for(int i = 0; i < reactors.size(); i++) {
            if(reactorID.equals(reactors.get(i).getComponentID())){
                reactors.remove(i);
                break;
            }
        }
        
        saveReactors(reactors);
        return reactors;
    }
    
    public ArrayList<Engine> deleteEngine(ArrayList<Engine> engines, UUID engineID) {
        
        for(int i = 0; i < engines.size(); i++) {
            if(engineID.equals(engines.get(i).getComponentID())){
                engines.remove(i);
                break;
            }
        }
        
        saveEngines(engines);
        return engines;
    }
    
    public ArrayList<Shield> deleteShield(ArrayList<Shield> shields, UUID shieldID) {
        
        for(int i = 0; i < shields.size(); i++) {
            if(shieldID.equals(shields.get(i).getComponentID())){
                shields.remove(i);
                break;
            }
        }
        
        saveShields(shields);
        return shields;
    }
    
    public ArrayList<Armor> deleteArmor(ArrayList<Armor> armors, UUID armorID) {
        
        for(int i = 0; i < armors.size(); i++) {
            if(armorID.equals(armors.get(i).getComponentID())){
                armors.remove(i);
                break;
            }
        }
        
        saveArmors(armors);
        return armors;
    }
    
    public ArrayList<Booster> deleteBooster(ArrayList<Booster> boosters, UUID boosterID) {
        
        for(int i = 0; i < boosters.size(); i++) {
            if(boosterID.equals(boosters.get(i).getComponentID())){
                boosters.remove(i);
                break;
            }
        }
        
        saveBoosters(boosters);
        return boosters;
    }
    
    public ArrayList<Capacitor> deleteCapacitor(ArrayList<Capacitor> capacitors, UUID capacitorID) {
        
        for(int i = 0; i < capacitors.size(); i++) {
            if(capacitorID.equals(capacitors.get(i).getComponentID())){
                capacitors.remove(i);
                break;
            }
        }
        
        saveCapacitors(capacitors);
        return capacitors;
    }
    
    public ArrayList<DroidInterface> deleteInterface(ArrayList<DroidInterface> interfaces, UUID interfaceID) {
        
        for(int i = 0; i < interfaces.size(); i++) {
            if(interfaceID.equals(interfaces.get(i).getComponentID())){
                interfaces.remove(i);
                break;
            }
        }
        
        saveInterfaces(interfaces);
        return interfaces;
    }
    
    public ArrayList<Weapon> deleteWeapon(ArrayList<Weapon> weapons, UUID weaponID) {
        
        for(int i = 0; i < weapons.size(); i++) {
            if(weaponID.equals(weapons.get(i).getComponentID())){
                weapons.remove(i);
                break;
            }
        }
        
        saveWeapons(weapons);
        return weapons;
    }
    
    public ArrayList<Ordnance> deleteOrdnance(ArrayList<Ordnance> ordnance, UUID ordnanceID) {
        
        for(int i = 0; i < ordnance.size(); i++) {
            if(ordnanceID.equals(ordnance.get(i).getComponentID())){
                ordnance.remove(i);
                break;
            }
        }
        
        saveOrdnance(ordnance);
        return ordnance;
    }
    
    public ArrayList<Countermeasure> deleteCountermeasure(ArrayList<Countermeasure> countermeasures, UUID countermeasureID) {
        
        for(int i = 0; i < countermeasures.size(); i++) {
            if(countermeasureID.equals(countermeasures.get(i).getComponentID())){
                countermeasures.remove(i);
                break;
            }
        }
        
        saveCountermeasures(countermeasures);
        return countermeasures;
    }
}
