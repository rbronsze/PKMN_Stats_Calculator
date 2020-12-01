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
public class StatControler {
    
    private CalculatorFrame f;
    private Calculator m;
    
    public StatControler(CalculatorFrame f, Calculator m){
        
        this.f = f;
        this.m = m;
        
    }
    
    private boolean isBaseStatOk(int stat){
        
        if(stat >= 0)
            return true;
        
        return false;
        
    }
    
    private boolean isIvStatOk(int stat){
        
        if(stat >= 0 && stat <= 31)
            return true;
        
        return false;
        
    }
    
    private boolean isEvStatOk(int stat){
        
        if(stat >= 0 && stat <= 252)
            return true;
        
        return false;
        
    }
    
    private boolean isNatureOk(double stat){
        
        if(stat == 0.9 || stat == 1.0 || stat == 1.1)
            return true;
        
        return false;
        
    }
    
    public void controlStat(int[] base, int[] iv, int[] ev, double[] nature, int p){
        
        if(isBaseStatOk(base[0]) && isBaseStatOk(base[1]) && isBaseStatOk(base[2]) && isBaseStatOk(base[3]) && isBaseStatOk(base[4]) && isBaseStatOk(base[5])){
            if(isIvStatOk(iv[0]) && isIvStatOk(iv[1]) && isIvStatOk(iv[2]) && isIvStatOk(iv[3]) && isIvStatOk(iv[4]) && isIvStatOk(iv[5])){
                if(isEvStatOk(iv[0]) && isEvStatOk(iv[1]) && isEvStatOk(iv[2]) && isEvStatOk(iv[3]) && isEvStatOk(iv[4]) && isEvStatOk(iv[5])){
                    if(isNatureOk(nature[0]) && isNatureOk(nature[1]) && isNatureOk(nature[2]) && isNatureOk(nature[3]) && isNatureOk(nature[4])){
                        m.calculAllStat(base, iv, ev, nature, p);
                    }
                    else{
                        System.out.println("Nature must be between 0.9 or 1.0 or 1.1");
                    }
                }
                else{
                    System.out.println("EV must be between 0 and 252");
                }
            }
            else{
                System.out.println("IV must be between 0 and 31");
            }
        }
        else{
            System.out.println("Base stat must be 0+");
        }
        
    }
    
    private boolean isPowerOk(int power){
        
        if(power >= 0)
            return true;
        
        return false;
    }
    
    private boolean isEffectivenessOk(double effectiveness){
        
        if(effectiveness == 0.25
           || effectiveness == 0.5
           || effectiveness == 1.0
           || effectiveness == 2.0
           || effectiveness == 4.0)
            return true;
        
        
        return false;
        
    }
    
    public void controlDamage(int power, boolean isStab, double effectiveness, int player, int type){
        
        
        if(isPowerOk(power)){
            if(isEffectivenessOk(effectiveness)){

                m.calculDamage(power, isStab, effectiveness, player, type);
            }else{
                System.out.println("Effectiveness must be, 0.25 || 0.5 || 1 || 2 || 4");
            }
        }else{
            System.out.println("Power must be 0+");
        }
    }
    
}
