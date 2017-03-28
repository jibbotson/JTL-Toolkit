/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import jtl.toolkit.models.Reactor;

public class ComponentSaveHelper {
    
    public void saveReactors(ArrayList<Reactor> reactors) {
        try (Writer writer = new FileWriter("components/reactors.json")) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(reactors, writer);
        } catch (IOException ex) {
            Logger.getLogger(ToolkitController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
