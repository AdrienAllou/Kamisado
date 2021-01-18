package Controlleur;

import Model.*;
import Vue.*;

import javax.swing.*;

public class ControlleurGroup {

    protected Model model;
    protected Vue vue;

    public ControlleurGroup(Model model){
        this.model = model;
        this.vue = new Vue(model);



        ControlleurButton controlleurButton = new ControlleurButton(this.vue, this.model);
        ControlleurMenu controlleurMenu = new ControlleurMenu(this.model, this.vue);

        this.vue.display();

        this.vue.desableButtonAndPrintPlayeurs();

        //addActionListener
        for(JButton jButton : vue.getPlateau())
            jButton.addActionListener(controlleurButton);
        this.vue.getNouvellePartie().addActionListener(controlleurMenu);
    }
}