/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmn_calculator;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Polack
 */
public class DamagePanel extends JPanel implements ActionListener{

    private JLabel puissanceLbl, stabLbl, effectivenessLbl, critLbl, ssTotalLbl, totalLbl, ssTotalValueLbl, totalValueLbl, ssTotalCritLbl, totalCritLbl, ssTotalCritValueLbl, totalCritValueLbl;
    private JButton effectivenessBtn, calculBtn;
    private CategoryButton typeBtn;
    private JCheckBox stabCheckBox, critCheckBox;
    private JTextField puissanceJtf;
    private int type;
    
    public DamagePanel(){
        
        type = 0;
        
        puissanceLbl = new JLabel("Base Power");
        stabLbl = new JLabel("STAB");
        effectivenessLbl = new JLabel("Effectiveness"); 
        critLbl = new JLabel("Crit");
        ssTotalLbl = new JLabel("85%");
        totalLbl = new JLabel("100%");
        ssTotalCritLbl = new JLabel("Crit 85%");
        totalCritLbl = new JLabel("Crit 100%");
        
        calculBtn = new JButton("Calcul");
        
        puissanceJtf = new JTextField();
        puissanceJtf.setDocument(new JTextIntLimited());
        
        stabCheckBox = new JCheckBox();
        
        effectivenessBtn = new JButton("1.0");
        effectivenessBtn.addActionListener(this);
        
        critCheckBox = new JCheckBox();
        
        ssTotalValueLbl = new JLabel("0");
        totalValueLbl = new JLabel("0");
        
        ssTotalCritValueLbl = new JLabel("0");
        totalCritValueLbl = new JLabel("0");
        
        typeBtn = new CategoryButton();
        typeBtn.addActionListener(this);
        
        this.setLayout(new GridLayout(2, 8));
        
        this.add(puissanceLbl);
        this.add(stabLbl);
        this.add(effectivenessLbl);
        //this.add(critLbl);
        this.add(ssTotalLbl);
        this.add(totalLbl);
        this.add(ssTotalCritLbl);
        this.add(totalCritLbl);
        this.add(calculBtn);
        
        this.add(puissanceJtf);
        this.add(stabCheckBox);
        this.add(effectivenessBtn);
        //this.add(critCheckBox);
        this.add(ssTotalValueLbl);
        this.add(totalValueLbl);
        this.add(ssTotalCritValueLbl);
        this.add(totalCritValueLbl);
        this.add(typeBtn);
        
    }

    public JLabel getSsTotalCritValueLbl() {
        return ssTotalCritValueLbl;
    }

    public JLabel getTotalCritValueLbl() {
        return totalCritValueLbl;
    }

    public JLabel getSsTotalValueLbl() {
        return ssTotalValueLbl;
    }

    public JLabel getTotalValueLbl() {
        return totalValueLbl;
    }

    public JButton getEffectivenessBtn() {
        return effectivenessBtn;
    }

    public JButton getCalculBtn() {
        return calculBtn;
    }

    public JCheckBox getStabCheckBox() {
        return stabCheckBox;
    }

    public JCheckBox getCritCheckBox() {
        return critCheckBox;
    }

    public JTextField getPuissanceJtf() {
        return puissanceJtf;
    }
    
    public int getType() {
        return type;
    }

    public CategoryButton getTypeBtn() {
        return typeBtn;
    }
    
    private void changeEffectiveness(){
        
        double value = Double.parseDouble(this.effectivenessBtn.getText());
        
        if(value != 4.0)
            this.effectivenessBtn.setText(String.valueOf(value*2));
        else
            this.effectivenessBtn.setText("0.25");
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == this.effectivenessBtn)
            changeEffectiveness();
        
        if(e.getSource() == this.typeBtn)
            this.typeBtn.setCategory();
        
    }
    
}
