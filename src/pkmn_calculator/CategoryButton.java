/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmn_calculator;

import javax.swing.JButton;

/**
 *
 * @author Polack
 */
public class CategoryButton extends JButton{
    
    private int category;
    private String[] text = {"Att -> Def", "Att -> Sdef", "Satt -> Sdef", "Satt -> Def"};
    
    public CategoryButton(){
        
        super("Att -> Def");
        category = 0;
        
    }

    public int getCategory() {
        return category;
    }

    public void setCategory() {
        if(category == 3)
            category = 0;
        else
            category ++;
        
        this.setText(this.text[category]);
        
        
    }
    
    
}
