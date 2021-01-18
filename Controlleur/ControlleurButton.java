package Controlleur;

import Model.*;
import Vue.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.PlatformLoggingMXBean;

public class ControlleurButton implements ActionListener {

    protected Vue vue;
    protected Model model;

    public ControlleurButton(Vue vue, Model model){
        this.model = model;
        this.vue = vue;
    }

    /**
     * Doit faire la selection du joueur
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton jButton = ((JButton)e.getSource());
        int x = jButton.getMinimumSize().width;
        int y = jButton.getMinimumSize().height;

        System.out.println("Tour joueur noir : " + this.model.isBlackTurn());

        //Si on clic sur un joueur
        if (jButton.getText().equals("!") || jButton.getIcon() != null){
            for (Pion pion : this.model.getAllPionCouldPlay())
                if (pion.sameCoordonnee(jButton.getMinimumSize()))
                    Model.playerSelected = pion;
            this.vue.desableButtonAndPrintPlayeurs();
            this.vue.tracePossibility(x,y);
        }
        //Si on se déplace
        else {
            this.model.setBlackTurn(!this.model.isBlackTurn());
            Model.playerSelected.setXY(x,y);
            Model.color = jButton.getBackground();
            this.vue.printGagnant(this.model.isWon(Model.playerSelected,this.model.isBlackTurn()));
            this.vue.desableButtonAndPrintPlayeurs();
        }
    }
}
