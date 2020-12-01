/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkmn_calculator;

/**
 *
 * @author Polack
 */
public class PKMN_Calculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CalculatorFrame f = new CalculatorFrame();
        Calculator m = new Calculator(f);
        StatControler c = new StatControler(f, m);
        f.setControler(c);
        
    }
    
}
