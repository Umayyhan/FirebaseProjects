package com.kingaspx.FirebaseProjects;

import com.formdev.flatlaf.FlatLightLaf;
import com.kingaspx.FirebaseProjects.util.FirebaseConfig;

/**
 *
 * @author lenovo
 */
public class Main {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new FirebaseConfig().initFirebase();
        
        new Menu().setVisible(true);
        
    }
    
}
