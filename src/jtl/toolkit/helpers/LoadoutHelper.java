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
import jtl.toolkit.models.Loadout;

public class LoadoutHelper {
    
    public void saveLoadouts(ArrayList<Loadout> loadouts) {
        try (Writer writer = new FileWriter("data/loadouts.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(loadouts, writer);
        } catch (IOException ex) {
            Logger.getLogger(LoadoutHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Loadout> getLoadouts() {
        ArrayList<Loadout> loadouts = new ArrayList<>();
        
        try {
            String jsonString = new String(Files.readAllBytes(Paths.get("data/loadouts.json")));
            
            loadouts = new Gson().fromJson(jsonString, new TypeToken<List<Loadout>>(){}.getType());
            
        } catch (IOException ex) {
            Logger.getLogger(LoadoutHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return loadouts;
    }
   
    public ArrayList<Loadout> updateLoadouts(ArrayList<Loadout> loadouts, String componentType, UUID componentID) {
        
        if(componentType.equals("Reactor")) {
            for(int i = 0; i < loadouts.size(); i++) {
                if(componentID.equals(loadouts.get(i).getReactorID())){
                    loadouts.get(i).setReactorID(null);
                    break;
                }
            }
        } else if(componentType.equals("Engine")) {
            for(int i = 0; i < loadouts.size(); i++) {
                if(componentID.equals(loadouts.get(i).getEngineID())){
                    loadouts.get(i).setEngineID(null);
                    break;
                }
            }
        } else if(componentType.equals("Shield")) {
            for(int i = 0; i < loadouts.size(); i++) {
                if(componentID.equals(loadouts.get(i).getShieldID())){
                    loadouts.get(i).setShieldID(null);
                    break;
                }
            }
        }else if(componentType.equals("Armor")) {
            for(int i = 0; i < loadouts.size(); i++) {
                if(componentID.equals(loadouts.get(i).getArmorOneID())){
                    loadouts.get(i).setArmorOneID(null);
                    break;
                } else if(componentID.equals(loadouts.get(i).getArmorTwoID())) {
                    loadouts.get(i).setArmorTwoID(null);
                    break;
                }
            }
        } else if(componentType.equals("Capacitor")) {
            for(int i = 0; i < loadouts.size(); i++) {
                if(componentID.equals(loadouts.get(i).getCapacitorID())){
                    loadouts.get(i).setCapacitorID(null);
                    break;
                }
            }
        } else if(componentType.equals("Booster")) {
            for(int i = 0; i < loadouts.size(); i++) {
                if(componentID.equals(loadouts.get(i).getBoosterID())){
                    loadouts.get(i).setBoosterID(null);
                    break;
                }
            }
        } else if(componentType.equals("Interface")) {
            for(int i = 0; i < loadouts.size(); i++) {
                if(componentID.equals(loadouts.get(i).getDroidInterfaceID())){
                    loadouts.get(i).setDroidInterfaceID(null);
                    break;
                }
            }
        } else if(componentType.equals("Weapon")) {
            for(int i = 0; i < loadouts.size(); i++) {
                for(int x = 0; x < loadouts.get(i).getWeaponIDs().size(); x++) {
                    if(componentID.equals(loadouts.get(i).getWeaponIDs().get(x))){
                        loadouts.get(i).getWeaponIDs().remove(x);
                        break;
                    }
                }
            }
        } else if(componentType.equals("Ordnance")) {
            for(int i = 0; i < loadouts.size(); i++) {
                for(int x = 0; x < loadouts.get(i).getOrdnanceIDs().size(); x++) {
                    if(componentID.equals(loadouts.get(i).getOrdnanceIDs().get(x))){
                        loadouts.get(i).getOrdnanceIDs().remove(x);
                        break;
                    }
                }
            }
        } else if(componentType.equals("Countermeasure")) {
            for(int i = 0; i < loadouts.size(); i++) {
                if(componentID.equals(loadouts.get(i).getCountermeasureID())){
                    loadouts.get(i).setCountermeasureID(null);
                    break;
                }
            }
        }
        
        saveLoadouts(loadouts);
        return loadouts;
    }
}
