package Vue;

import Model.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Vue extends JFrame {

    protected Model model;

    //Stockage de tout les bouttons
    protected List<JButton> plateau = new ArrayList<JButton>();
    //JPanel pour le plateau de jeu
    private JPanel plateauJeu = new JPanel(new GridLayout(8,8));

    //MakeMenu
    JMenuItem nouvellePartie;

    public Vue(Model model){
        this.model = model;
        makeMenu();
    }


    public JPanel initPlateau(){
        //Ligne 1
        choiseColorAndAdd(Color.GRAY);
        choiseColorAndAdd(Color.GREEN);
        choiseColorAndAdd(Color.RED);
        choiseColorAndAdd(Color.YELLOW);
        choiseColorAndAdd(Color.PINK);
        choiseColorAndAdd(Color.MAGENTA);
        choiseColorAndAdd(Color.BLUE);
        choiseColorAndAdd(Color.ORANGE);

        //Ligne 2
        choiseColorAndAdd(Color.MAGENTA);
        choiseColorAndAdd(Color.GRAY);
        choiseColorAndAdd(Color.YELLOW);
        choiseColorAndAdd(Color.BLUE);
        choiseColorAndAdd(Color.GREEN);
        choiseColorAndAdd(Color.PINK);
        choiseColorAndAdd(Color.ORANGE);
        choiseColorAndAdd(Color.RED);

        //Ligne 3
        choiseColorAndAdd(Color.BLUE);
        choiseColorAndAdd(Color.YELLOW);
        choiseColorAndAdd(Color.GRAY);
        choiseColorAndAdd(Color.MAGENTA);
        choiseColorAndAdd(Color.RED);
        choiseColorAndAdd(Color.ORANGE);
        choiseColorAndAdd(Color.PINK);
        choiseColorAndAdd(Color.GREEN);

        //Ligne 4
        choiseColorAndAdd(Color.YELLOW);
        choiseColorAndAdd(Color.RED);
        choiseColorAndAdd(Color.GREEN);
        choiseColorAndAdd(Color.GRAY);
        choiseColorAndAdd(Color.ORANGE);
        choiseColorAndAdd(Color.BLUE);
        choiseColorAndAdd(Color.MAGENTA);
        choiseColorAndAdd(Color.PINK);
        

        //Ligne 5
        choiseColorAndAdd(Color.PINK);
        choiseColorAndAdd(Color.MAGENTA);
        choiseColorAndAdd(Color.BLUE);
        choiseColorAndAdd(Color.ORANGE);
        choiseColorAndAdd(Color.GRAY);
        choiseColorAndAdd(Color.GREEN);
        choiseColorAndAdd(Color.RED);
        choiseColorAndAdd(Color.YELLOW);


        //Ligne 6
        choiseColorAndAdd(Color.GREEN);
        choiseColorAndAdd(Color.PINK);
        choiseColorAndAdd(Color.ORANGE);
        choiseColorAndAdd(Color.RED);
        choiseColorAndAdd(Color.MAGENTA);
        choiseColorAndAdd(Color.GRAY);
        choiseColorAndAdd(Color.YELLOW);
        choiseColorAndAdd(Color.BLUE);


        //Ligne 7
        choiseColorAndAdd(Color.RED);
        choiseColorAndAdd(Color.ORANGE);
        choiseColorAndAdd(Color.PINK);
        choiseColorAndAdd(Color.GREEN);
        choiseColorAndAdd(Color.BLUE);
        choiseColorAndAdd(Color.YELLOW);
        choiseColorAndAdd(Color.GRAY);
        choiseColorAndAdd(Color.MAGENTA);


        //Ligne 8
        choiseColorAndAdd(Color.ORANGE);
        choiseColorAndAdd(Color.BLUE);
        choiseColorAndAdd(Color.MAGENTA);
        choiseColorAndAdd(Color.PINK);
        choiseColorAndAdd(Color.YELLOW);
        choiseColorAndAdd(Color.RED);
        choiseColorAndAdd(Color.GREEN);
        choiseColorAndAdd(Color.GRAY);
        return plateauJeu;
    }

    private void choiseColorAndAdd(Color color){
        JButton jButton = new JButton();
        jButton.setMaximumSize(new Dimension(50,50));
        jButton.setBackground(color);
        jButton.setBorderPainted(false);
        addElementsOnInitPlateau(jButton);
    }

    private void addElementsOnInitPlateau(JButton ... jButtons){
        for (JButton jButton : jButtons){
            plateau.add(jButton);
            plateauJeu.add(jButton);
        }
    }

    /**
     * Desactive tout les boutton où il n'y a pas de joueur
     * Affiche une joueur
     */
    public void desableButtonAndPrintPlayeurs(){
        if (!Model.endGame) {
            //Cache la position du joueur
            for (int i = 0; i < 8; i++)
                for (int j = 0; j < 8; j++)
                    plateau.get(i * 8 + j).setMinimumSize(new Dimension(j + 1, i + 1));
            for (JButton button : this.plateau) {
                button.setEnabled(false);
                button.setText("");
                button.setIcon(null);
                button.setBorderPainted(false);
            }
            if (!this.model.isBlackTurn()) {
                for (Pion joueur : this.model.getpionJoueurBlanc()) {
                    //Recupération du boutton
                    JButton jButton = this.plateau.get((joueur.getY() - 1) * 8 + joueur.getX() - 1);
                    //Mettre les icones
                    try {
                        ImageIcon icon = new ImageIcon(getClass().getResource("../img/" + joueur.getNAME_IMAGE() + ".png"));
                        jButton.setIcon(icon);
                    } catch (Exception ignored) {
                        jButton.setText("!");
                    }
                    //L'activer ou non
                    if (Model.color == null)
                        jButton.setEnabled(true);
                    else if (Model.color.equals(joueur.getDefaltColor()))
                        jButton.setEnabled(true);
                }
                for (Pion joueur : this.model.getPionJoueurNoir()) {
                    JButton jButton = this.plateau.get((joueur.getY() - 1) * 8 + joueur.getX() - 1);
                    try {
                        ImageIcon icon = new ImageIcon(getClass().getResource("../img/" + joueur.getNAME_IMAGE() + ".png"));
                        jButton.setIcon(icon);
                    } catch (Exception ignored) {
                        jButton.setText("!");
                    }
                }
            } else {
                for (Pion joueur : this.model.getpionJoueurBlanc()) {
                    JButton jButton = this.plateau.get((joueur.getY() - 1) * 8 + joueur.getX() - 1);
                    try {
                        ImageIcon icon = new ImageIcon(getClass().getResource("../img/" + joueur.getNAME_IMAGE() + ".png"));
                        jButton.setIcon(icon);
                    } catch (Exception ignored) {
                        jButton.setText("!");
                    }
                }
                for (Pion joueur : this.model.getPionJoueurNoir()) {
                    JButton jButton = this.plateau.get((joueur.getY() - 1) * 8 + joueur.getX() - 1);
                    try {
                        ImageIcon icon = new ImageIcon(getClass().getResource("../img/" + joueur.getNAME_IMAGE() + ".png"));
                        jButton.setIcon(icon);
                    } catch (Exception ignored) {
                        jButton.setText("!");
                    }
                    if (Model.color == null)
                        jButton.setEnabled(true);
                    else if (Model.color.equals(joueur.getDefaltColor()))
                        jButton.setEnabled(true);
                }
            }
        }else{
            for (JButton button : this.plateau)
                button.setEnabled(false);
        }
    }

    public void tracePossibility(int x, int y){
        //Les coordonnee commence à 1:1
        x--;
        y--;
        if (this.model.isBlackTurn()){
            printVerticalNoir(x,y);
        }else{
            printVerticalBlanc(x,y);
        }
    }

    private void printVerticalNoir(int xbase, int ybase){
        boolean isFirst = true;
        int f = 0;
        int x = xbase, y = ybase;
        while (x > 0){
            x--;
            y--;
            JButton jButton = plateau.get(y * 8 + x);
            if (jButton.getText().equals("!") || jButton.getIcon() != null)
                break;
            setButtonValide(jButton);
            isFirst = false;
        }
        if (isFirst)
            f++;
        isFirst = true;
        x = xbase;
        y = ybase;
        while (y > 0) {
            y--;
            JButton jButton = plateau.get(y * 8 + x);
            if (jButton.getText().equals("!") || jButton.getIcon() != null)
                break;
            setButtonValide(jButton);
            isFirst = false;
        }
        if (isFirst)
            f++;
        isFirst = true;
        x = xbase;
        y = ybase;
        while (x < 7){
            x++;
            y--;
            JButton jButton = plateau.get(y * 8 + x);
            if (jButton.getText().equals("!") || jButton.getIcon() != null)
                break;
            setButtonValide(jButton);
            isFirst = false;
        }
        if (isFirst)
            f++;
        if (f == 3){
            this.model.setBlackTurn(!this.model.isBlackTurn());
            this.desableButtonAndPrintPlayeurs();
        }
    }

    private void printVerticalBlanc(int xbase, int ybase){
        boolean isFirst = true;
        int f = 0;
        int x = xbase, y = ybase;
        while (x > 0){
            x--;
            y++;
            JButton jButton = plateau.get(y * 8 + x);
            if (jButton.getText().equals("!") || jButton.getIcon() != null)
                break;
            setButtonValide(jButton);
            isFirst = false;
        }
        if (isFirst)
            f++;
        isFirst = true;
        x = xbase;
        y = ybase;
        while (x < 7){
            x++;
            y++;
            JButton jButton = plateau.get(y * 8 + x);
            if (jButton.getText().equals("!") || jButton.getIcon() != null)
                break;
            setButtonValide(jButton);
            isFirst = false;
        }
        if (isFirst)
            f++;
        isFirst = true;
        x = xbase;
        y = ybase;
        while (y < 7) {
            y++;
            JButton jButton = plateau.get(y * 8 + x);
            if (jButton.getText().equals("!") || jButton.getIcon() != null)
                break;
            setButtonValide(jButton);
            isFirst = false;
        }
        if (isFirst)
            f++;
        if (f == 3){
            this.model.setBlackTurn(!this.model.isBlackTurn());
            this.desableButtonAndPrintPlayeurs();
        }
    }

    private void setButtonValide(JButton jButton){
        jButton.setText("?");
        jButton.setBorderPainted(true);
        jButton.setEnabled(true);

    }

    public void display(){
        setContentPane(initPlateau());
        setTitle("Kamisado");
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    /***
     * Affiche le gagnant
     * @return void
     */
    public void printGagnant(boolean isWon){
        Model.endGame = isWon;
        if ( isWon ){
            JOptionPane win = new JOptionPane();
            if (this.model.isBlackTurn()) {
                JOptionPane.showMessageDialog(this, "The winner is : White", "Winner !", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "The winner is : Black", "Winner !", JOptionPane.INFORMATION_MESSAGE);
            }
            JDialog fenErr = win.createDialog(this, "Erreur");
        }
    }

    /**
     * Crée le menue
     * @return void
     */
    public void makeMenu(){
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Option");
        this.nouvellePartie = new JMenuItem("Nouvelle partie");
        menu.add(nouvellePartie);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    public List<JButton> getPlateau() {
        return plateau;
    }

    public void setPlateau(List<JButton> plateau) {
        this.plateau = plateau;
    }

    public JPanel getPlateauJeu() {
        return plateauJeu;
    }

    public JMenuItem getNouvellePartie() {
        return nouvellePartie;
    }

    public void setPlateauJeu(JPanel plateauJeu) {
        this.plateauJeu = plateauJeu;
    }
}
