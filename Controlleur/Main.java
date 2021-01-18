package Controlleur;

import Model.Model;
import Vue.Vue;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater( new Runnable() {

            public void run() {
                Model model = new Model();
                ControlleurGroup f = new ControlleurGroup(model);
            }

        });
    }
}
