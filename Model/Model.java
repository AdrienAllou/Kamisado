package Model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Model {

    protected List<Pion> pionJoueurBlanc = new ArrayList<Pion>();
    protected List<Pion> pionJoueurNoir = new ArrayList<Pion>();

    //Default Color
    protected static final Color[] COLOR_INIT_PION_DEFAULT = new Color[]{
            Color.GRAY,Color.GREEN,Color.RED,Color.YELLOW,Color.PINK,Color.magenta,Color.BLUE,Color.ORANGE
    };

    //List des pions qui peuvent jouer
    protected List<Pion> pionJouable = new ArrayList<Pion>();

    //Plateau de jeu virtuelle
    protected int[] plateauDeJeuJouage = new int[128];

    public static Pion playerSelected;

    protected boolean isBlackTurn = false;

    public static Color color;
    public static boolean endGame = false;

    public Model(){
        for(int i = 1; i <= 8; i++){
            pionJoueurBlanc.add(new Pion(i,1,COLOR_INIT_PION_DEFAULT[i-1],0));
            pionJoueurNoir.add(new Pion(i,8,COLOR_INIT_PION_DEFAULT[8-i],1));
            pionJouable.add(pionJoueurBlanc.get(i-1));
            pionJouable.add(pionJoueurNoir.get(i-1));
        }
    }

    public boolean isWon(Pion pion, boolean isBlack){
        if(!isBlack && pion.getY() == 1)
            return true;
        else return isBlack && pion.getY() == 8;
    }

    public List<Pion> getAllPion(){
        List<Pion> allPion = new ArrayList<Pion>();
        for (Pion pion : pionJoueurBlanc)
            allPion.add(pion);
        for (Pion pion : pionJoueurNoir)
            allPion.add(pion);
        return allPion;
    }

    public List<Pion> getpionJoueurBlanc() {
        return pionJoueurBlanc;
    }


    public List<Pion> getAllPionCouldPlay(){
        return this.pionJouable;
    }

    public void clearPionPosition(){
        Arrays.fill(plateauDeJeuJouage, 0);
    }

    public int[] getPlateauDeJeuJouage() {
        return plateauDeJeuJouage;
    }

    public List<Pion> getPionJoueurNoir() {
        return pionJoueurNoir;
    }

    public void setPionJoueurNoir(List<Pion> pionJoueurNoir) {
        this.pionJoueurNoir = pionJoueurNoir;
    }

    public boolean isBlackTurn() {
        return isBlackTurn;
    }

    public void setBlackTurn(boolean blackTurn) {
        isBlackTurn = blackTurn;
    }

    public static int getIndexColorDefine(Color color2){
        for (int i = 0; i < COLOR_INIT_PION_DEFAULT.length; i++) {
            if (COLOR_INIT_PION_DEFAULT[i].equals(color2)){
                return i;
            }
        }
        return -1;
    }
}