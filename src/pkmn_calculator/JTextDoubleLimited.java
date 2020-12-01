/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmn_calculator;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Polack
 */
public class JTextDoubleLimited extends PlainDocument {
 
public JTextDoubleLimited(){
    
    super();
 
}
public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException{
    
        try{
            Double.parseDouble(str);
            super.insertString(offset, str, attr);
        }catch(Exception e){
        }
    }
}
