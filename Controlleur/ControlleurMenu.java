package Controlleur;

import Model.Model;
import Vue.Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurMenu implements ActionListener {

    private Model model;
    private Vue vue;

    public ControlleurMenu(Model model, Vue vue) {
        this.model = model;
        this.vue = vue;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.model = new Model();
        Model.color = null;
        Model.endGame = false;
        ControlleurGroup controlleurGroup = new ControlleurGroup(this.model);
    }
}
