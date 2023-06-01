/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dashboard;

import classes.VehiclePlant;

/**
 *
 * @author Juan
 */
public class GlobalUI {
    private static final MainInterface mainInterface = new MainInterface();

    public static MainInterface getMainUI() {
        return mainInterface;
    }
        /**
     * Opens project MainPage
     */
    public static void openMainPage() {
        getMainUI().setVisible(true);
    }
}
