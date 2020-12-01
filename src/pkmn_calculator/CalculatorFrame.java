/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmn_calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Polack
 */
public class CalculatorFrame extends JFrame implements ActionListener{
    
    private StatControler c;
    private StatPanel[] statPanel = new StatPanel[2];

    
//    private StatPanel pkmn1Panel = new StatPanel(false)
//                 , pkmn2Panel = new StatPanel(true);
    
    private DamagePanel[] dmgPanel = new DamagePanel[2];
    
    public CalculatorFrame(){
        
        
        
        statPanel[0] = new StatPanel(false);
        statPanel[1] = new StatPanel(true);
        
        dmgPanel[0] = new DamagePanel();
        dmgPanel[1] = new DamagePanel();
        
        
//        dmgPanel[0].setSize(500, 50);
//        dmgPanel[1].setSize(500, 50);
//        
//        statPanel[0].setSize(500, 200);
//        statPanel[1].setSize(500, 200);
        
        this.setLayout(new GridLayout(4, 0));
        
        this.add(dmgPanel[0]);
        this.add(statPanel[0]);
        
        this.add(statPanel[1]);
        this.add(dmgPanel[1]);
        
        this.statPanel[1].getButton().addActionListener(this);
        this.dmgPanel[0].getCalculBtn().addActionListener(this);
        this.dmgPanel[1].getCalculBtn().addActionListener(this);
        
        //this.pkmn1Panel.getButton();
        
        //fill();
        // Title
        this.setTitle("Pokemon Stat Calculator");
        
        // Size
        this.setSize(700, 500);
        
        // Location in screen
        this.setLocationRelativeTo(null);        
        
        // Closing
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Visibility              
        this.setVisible(true);
        
        
    }
    
    public StatPanel getStatPanel(int player) {
        return statPanel[player];
    }

    public DamagePanel getDmgPanel(int player) {
        return dmgPanel[player];
    }

    public void setControler(StatControler c){
        this.c = c;
    }
    
    private int checkIntValue(String text){
            
        int value;

        try{
            value = Integer.valueOf(text);
        }catch(Exception e){
            value = 0;
        }
        return value;

    }

    private double checkDoubleValue(String text){

        double value;

        try{
            value = Double.valueOf(text);
        }catch(Exception e){
            value = 1.0;
        }
        return value;

    }
    
    private void calculStat(){
        
        int[][] base = new int[2][6];
        int[][] iv = new int[2][6];
        int[][] ev = new int[2][6];
        
        double[][] nature = new double[2][5];
        
        for(int i = 0; i < 2; i++){
            base[i][0] = checkIntValue(statPanel[i].getBasePvJtf().getText());
            base[i][1] = checkIntValue(statPanel[i].getBaseAttJtf().getText());
            base[i][2] = checkIntValue(statPanel[i].getBaseDefJtf().getText());
            base[i][3] = checkIntValue(statPanel[i].getBaseSattJtf().getText());
            base[i][4] = checkIntValue(statPanel[i].getBaseSdefJtf().getText());
            base[i][5] = checkIntValue(statPanel[i].getBaseVitJtf().getText());


            iv[i][0] = checkIntValue(statPanel[i].getIvPvJtf().getText());
            iv[i][1] = checkIntValue(statPanel[i].getIvAttJtf().getText());
            iv[i][2] = checkIntValue(statPanel[i].getIvDefJtf().getText());
            iv[i][3] = checkIntValue(statPanel[i].getIvSattJtf().getText());
            iv[i][4] = checkIntValue(statPanel[i].getIvSdefJtf().getText());
            iv[i][5] = checkIntValue(statPanel[i].getIvVitJtf().getText());


            ev[i][0] = checkIntValue(statPanel[i].getEvPvJtf().getText());
            ev[i][1] = checkIntValue(statPanel[i].getEvAttJtf().getText());
            ev[i][2] = checkIntValue(statPanel[i].getEvDefJtf().getText());
            ev[i][3] = checkIntValue(statPanel[i].getEvSattJtf().getText());
            ev[i][4] = checkIntValue(statPanel[i].getEvSdefJtf().getText());
            ev[i][5] = checkIntValue(statPanel[i].getEvVitJtf().getText());


            nature[i][0] = checkDoubleValue(statPanel[i].getNatureAttBtn().getText());
            nature[i][1] = checkDoubleValue(statPanel[i].getNatureDefBtn().getText());
            nature[i][2] = checkDoubleValue(statPanel[i].getNatureSattBtn().getText());
            nature[i][3] = checkDoubleValue(statPanel[i].getNatureSdefBtn().getText());
            nature[i][4] = checkDoubleValue(statPanel[i].getNatureVitBtn().getText());
        }
        
        c.controlStat(base[0], iv[0], ev[0], nature[0], 0);
        c.controlStat(base[1], iv[1], ev[1], nature[1], 1);
    }
    
    private void calculDamage(int player){
        
        
        int power = Integer.valueOf(this.dmgPanel[player].getPuissanceJtf().getText());
        boolean isStab = this.dmgPanel[player].getStabCheckBox().isSelected();
        double effectiveness = Double.valueOf(this.dmgPanel[player].getEffectivenessBtn().getText());
        int type = this.dmgPanel[player].getTypeBtn().getCategory();
        
        c.controlDamage(power, isStab, effectiveness, player, type);
        
        
    }
    
    private void fill(){
        
        this.statPanel[0].getBasePvJtf().setText("80");
        this.statPanel[0].getBaseAttJtf().setText("116");
        this.statPanel[0].getBaseDefJtf().setText("75");
        this.statPanel[0].getBaseSattJtf().setText("65");
        this.statPanel[0].getBaseSdefJtf().setText("75");
        this.statPanel[0].getBaseVitJtf().setText("119");
        
        this.statPanel[0].getIvPvJtf().setText("31");
        this.statPanel[0].getIvAttJtf().setText("31");
        this.statPanel[0].getIvDefJtf().setText("31");
        this.statPanel[0].getIvSattJtf().setText("0");
        this.statPanel[0].getIvSdefJtf().setText("31");
        this.statPanel[0].getIvVitJtf().setText("31");
        
        this.statPanel[0].getEvPvJtf().setText("0");
        this.statPanel[0].getEvAttJtf().setText("252");
        this.statPanel[0].getEvDefJtf().setText("6");
        this.statPanel[0].getEvSattJtf().setText("0");
        this.statPanel[0].getEvSdefJtf().setText("0");
        this.statPanel[0].getEvVitJtf().setText("252");
        
        this.statPanel[1].getBasePvJtf().setText("74");
        this.statPanel[1].getBaseAttJtf().setText("94");
        this.statPanel[1].getBaseDefJtf().setText("131");
        this.statPanel[1].getBaseSattJtf().setText("54");
        this.statPanel[1].getBaseSdefJtf().setText("116");
        this.statPanel[1].getBaseVitJtf().setText("20");
        
        this.statPanel[1].getIvPvJtf().setText("31");
        this.statPanel[1].getIvAttJtf().setText("31");
        this.statPanel[1].getIvDefJtf().setText("31");
        this.statPanel[1].getIvSattJtf().setText("31");
        this.statPanel[1].getIvSdefJtf().setText("31");
        this.statPanel[1].getIvVitJtf().setText("31");
        
        this.statPanel[1].getEvPvJtf().setText("252");
        this.statPanel[1].getEvAttJtf().setText("0");
        this.statPanel[1].getEvDefJtf().setText("24");
        this.statPanel[1].getEvSattJtf().setText("0");
        this.statPanel[1].getEvSdefJtf().setText("232");
        this.statPanel[1].getEvVitJtf().setText("0");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.statPanel[1].getButton()){
            calculStat();
        }
        
        if(e.getSource() == this.dmgPanel[0].getCalculBtn()){
            calculDamage(0);
        }
        
        if(e.getSource() == this.dmgPanel[1].getCalculBtn()){
            calculDamage(1);
        }
        
    }

}
