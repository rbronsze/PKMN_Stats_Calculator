/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmn_calculator;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Polack
 */
public class StatPanel extends JPanel implements ActionListener{
    
    private JLabel pvLbl, attLbl, defLbl, sattLbl, sdefLbl, vitLbl, baseLbl, ivLbl, evLbl, natureLbl;
    
    private JTextField basePvJtf, baseAttJtf, baseDefJtf, baseSattJtf, baseSdefJtf, baseVitJtf;
    private JTextField ivPvJtf, ivAttJtf, ivDefJtf, ivSattJtf, ivSdefJtf, ivVitJtf;
    private JTextField evPvJtf, evAttJtf, evDefJtf, evSattJtf, evSdefJtf, evVitJtf;
    private JButton natureAttBtn, natureDefBtn, natureSattBtn, natureSdefBtn, natureVitBtn;
    
    private JLabel naturePvLbl;
    
    private JLabel totalLbl;
//            totalPvLbl, totalAttLbl, totalDefLbl, totalSattLbl, totalSdefLbl, totalVitLbl;
    private JTextField[][] stat;
    private Object[][] tab;
    private JLabel[] total;
    
    private JButton button;
    
    public StatPanel(boolean isVisible){
        
        String[] columnName = {"PV", "Att", "Def", "Satt", "Sdef", "Vit"};
        String [] lineName = {"Base", "IV", "EV"};
        //String [] lineName = {" ", "Base", "IV", "EV", "Nature", "Total"};
        
        stat = new JTextField[3][6];
        total = new JLabel[6];
        tab = new JTextField[6][7];
       
        this.setLayout(new GridLayout(6, 7));
        
//        for(int i = 0; i < 6; i++){
//            for(int j = 0; j < 7; j++){
//                
//            }
//        }
//        for(int i = 0; i < 6; i++){
//            if(i == 0){
//                if(isVisible){
//                    button = new JButton("Calcul");
//                    this.add(button);
//                }else{
//                    this.initLabel(lineName[i]); 
//                } 
//            }else{
//                this.initLabel(lineName[i]); 
//            }
//                
//            for(int j = 0; j < 6; j++){
//                if(i == 4){ // Nature
//                    if(j == 0){ // PV
//                        this.initLabel("N/A");
//                    }else{
//                        stat[i][j] = this.initJtf();
//                    }
//                }else{
//                    if(i == 5){
//                        total[j] = this.initLabel("0");
//                    }
//                    stat[i][j] = this.initJtf();
//                }
//                
//                
//            }
//        }
        
        
        button = new JButton("Calcul");
        button.setVisible(isVisible);
        this.add(button);

        for(int i = 0; i < 6; i++)
            this.initLabel(columnName[i]); 
        
        for(int i = 0; i < 3; i++){
            this.initLabel(lineName[i]); 
            for(int j = 0; j < 6; j++){
                stat[i][j] = this.initJtf();
            }
        }
        
        natureLbl = this.initLabel("Nature");
        naturePvLbl = this.initLabel("N/A");
        natureAttBtn = this.initButton("1.0");
        natureDefBtn = this.initButton("1.0");
        natureSattBtn = this.initButton("1.0");
        natureSdefBtn = this.initButton("1.0");
        natureVitBtn = this.initButton("1.0");
        
        totalLbl = this.initLabel("Total");
        for(int i = 0; i < 6; i++)
            total[i] = this.initLabel("0");
//        baseLbl = this.initLabel("Base");
//        
//        basePvJtf = this.initJtf();
//        baseAttJtf = this.initJtf();
//        baseDefJtf = this.initJtf();
//        baseSattJtf = this.initJtf();
//        baseSdefJtf = this.initJtf();
//        baseVitJtf = this.initJtf();
//        
//        ivLbl = this.initLabel("IV");
//        ivPvJtf = this.initJtf();
//        ivAttJtf = this.initJtf();
//        ivDefJtf = this.initJtf();
//        ivSattJtf = this.initJtf();
//        ivSdefJtf = this.initJtf();
//        ivVitJtf = this.initJtf();
//        
//        evLbl = this.initLabel("EV");
//        evPvJtf = this.initJtf();
//        evAttJtf = this.initJtf();
//        evDefJtf = this.initJtf();
//        evSattJtf = this.initJtf();
//        evSdefJtf = this.initJtf();
//        evVitJtf = this.initJtf();
        
        
        
        
//        totalPvLbl = this.initLabel("0");
//        totalAttLbl = this.initLabel("0");
//        totalDefLbl = this.initLabel("0");
//        totalSattLbl = this.initLabel("0");
//        totalSdefLbl = this.initLabel("0");
//        totalVitLbl  = this.initLabel("0");
        
        
        
//        this.add(baseLbl);
//        this.add(basePvJtf);
//        this.add(baseAttJtf);
//        this.add(baseDefJtf);
//        this.add(baseSattJtf);
//        this.add(baseSdefJtf);
//        this.add(baseVitJtf);
//        
//        this.add(ivLbl);
//        this.add(ivPvJtf);
//        this.add(ivAttJtf);
//        this.add(ivDefJtf);
//        this.add(ivSattJtf);
//        this.add(ivSdefJtf);
//        this.add(ivVitJtf);
//        
//        this.add(evLbl);
//        this.add(evPvJtf);
//        this.add(evAttJtf);
//        this.add(evDefJtf);
//        this.add(evSattJtf);
//        this.add(evSdefJtf);
//        this.add(evVitJtf);
//        
//        this.add(natureLbl);
//        this.add(naturePvLbl);
//        this.add(natureAttBtn);
//        this.add(natureDefBtn);
//        this.add(natureSattBtn);
//        this.add(natureSdefBtn);
//        this.add(natureVitBtn);
//        
//        this.add(totalLbl);
//        this.add(total[0]);
//        this.add(total[1]);
//        this.add(total[2]);
//        this.add(total[3]);
//        this.add(total[4]);
//        this.add(total[5]);
        
        //this.setBackground(color);
        
    }
    
    private JTextField initJtf(){
        
        JTextField jtf = new JTextField();
        jtf.setDocument(new JTextIntLimited());
        jtf.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(jtf);
        
        
        return jtf;
        
    }
    
    private JButton initButton(String text){
        
        JButton btn = new JButton(text);
        btn.addActionListener(this);
        this.add(btn);
        
        return btn;
    }
    
    private JLabel initLabel(String text){
        
        JLabel lbl = new JLabel(text);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lbl);
        
        return lbl;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        double value = Double.parseDouble(((JButton)e.getSource()).getText());
        
        if(value == 1.0)
            ((JButton)e.getSource()).setText("1.1");
        if(value == 1.1)
            ((JButton)e.getSource()).setText("0.9");
        if(value == 0.9)
            ((JButton)e.getSource()).setText("1.0");
        
        
        
    }

    public JTextField getBasePvJtf() {
        return stat[0][0];
    }

    public JTextField getBaseAttJtf() {
        return stat[0][1];
    }

    public JTextField getBaseDefJtf() {
        return stat[0][2];
    }

    public JTextField getBaseSattJtf() {
        return stat[0][3];
    }

    public JTextField getBaseSdefJtf() {
        return stat[0][4];
    }

    public JTextField getBaseVitJtf() {
        return stat[0][5];
    }

    public JTextField getIvPvJtf() {
        return stat[1][0];
    }

    public JTextField getIvAttJtf() {
        return stat[1][1];
    }

    public JTextField getIvDefJtf() {
        return stat[1][2];
    }

    public JTextField getIvSattJtf() {
        return stat[1][3];
    }

    public JTextField getIvSdefJtf() {
        return stat[1][4];
    }

    public JTextField getIvVitJtf() {
        return stat[1][5];
    }

    public JTextField getEvPvJtf() {
        return stat[2][0];
    }

    public JTextField getEvAttJtf() {
        return stat[2][1];
    }

    public JTextField getEvDefJtf() {
        return stat[2][2];
    }

    public JTextField getEvSattJtf() {
        return stat[2][3];
    }

    public JTextField getEvSdefJtf() {
        return stat[2][4];
    }

    public JTextField getEvVitJtf() {
        return stat[2][5];
    }

    public JButton getNatureAttBtn() {
        return natureAttBtn;
    }

    public JButton getNatureDefBtn() {
        return natureDefBtn;
    }

    public JButton getNatureSattBtn() {
        return natureSattBtn;
    }

    public JButton getNatureSdefBtn() {
        return natureSdefBtn;
    }

    public JButton getNatureVitBtn() {
        return natureVitBtn;
    }

    public JButton getButton() {
        return button;
    }

//    public void setTotalPvLbl(JLabel totalPvLbl) {
//        this.total[0] = totalPvLbl;
//    }
//
//    public void setTotalAttLbl(JLabel totalAttLbl) {
//        this.total[1] = totalAttLbl;
//    }
//
//    public void setTotalDefLbl(JLabel totalDefLbl) {
//        this.total[2] = totalDefLbl;
//    }

    public JLabel getTotalPvLbl() {
        return total[0];
    }

    public JLabel getTotalAttLbl() {
        return total[1];
    }

    public JLabel getTotalDefLbl() {
        return total[2];
    }

    public JLabel getTotalSattLbl() {
        return total[3];
    }

    public JLabel getTotalSdefLbl() {
        return total[4];
    }

    public JLabel getTotalVitLbl() {
        return total[5];
    }

//    public void setTotalSattLbl(JLabel totalSattLbl) {
//        this.totalSattLbl = totalSattLbl;
//    }
//
//    public void setTotalSdefLbl(JLabel totalSdefLbl) {
//        this.totalSdefLbl = totalSdefLbl;
//    }
//
//    public void setTotalVitLbl(JLabel totalVitLbl) {
//        this.totalVitLbl = totalVitLbl;
//    }

    
    
}
