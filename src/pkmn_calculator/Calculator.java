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
public class Calculator {
    
    private CalculatorFrame f;
    private int niveau = 50;
    
    public Calculator(CalculatorFrame f){
        
        this.f = f;
        
    }
    
    private int calculStat(int base, int iv, int ev, double nature){
        
        double stat = 0;
        
        if(nature == 0.0)
            stat = (((2*base + iv + (ev/4))*niveau)/100) + niveau + 10;
        else
            stat = ((((2*base + iv + (ev/4))*niveau)/100) + 5) * nature;
        
        return (int)stat;
        
    }
    
    public void calculAllStat(int[] base, int[] iv, int[] ev, double[] nature, int p){
        
        int pv = calculStat(base[0], iv[0], ev[0], 0.0);
        int att = calculStat(base[1], iv[1], ev[1], nature[0]);
        int def = calculStat(base[2], iv[2], ev[2], nature[1]);
        int satt = calculStat(base[3], iv[3], ev[3], nature[2]);
        int sdef = calculStat(base[4], iv[4], ev[4], nature[3]);
        int vit = calculStat(base[5], iv[5], ev[5], nature[4]);
        
        this.f.getStatPanel(p).getTotalPvLbl().setText(String.valueOf(pv));
        this.f.getStatPanel(p).getTotalAttLbl().setText(String.valueOf(att));
        this.f.getStatPanel(p).getTotalDefLbl().setText(String.valueOf(def));
        this.f.getStatPanel(p).getTotalSattLbl().setText(String.valueOf(satt));
        this.f.getStatPanel(p).getTotalSdefLbl().setText(String.valueOf(sdef));
        this.f.getStatPanel(p).getTotalVitLbl().setText(String.valueOf(vit));
        
        
    }
    
    private int getOpponent(int player){
        
        if(player == 0)
            return 1;
            
        return 0;
        
    }
    
    public void calculDamage(int power, boolean isStab, double effectiveness, int player, int type){
        
        int opponent = getOpponent(player);
        int att = 0, def = 0;
        double stab = 1.0;
        
        if(type == 0){
            att = Integer.valueOf(this.f.getStatPanel(player).getTotalAttLbl().getText());
            def = Integer.valueOf(this.f.getStatPanel(opponent).getTotalDefLbl().getText());
        }
        
        if(type == 1){
            att = Integer.valueOf(this.f.getStatPanel(player).getTotalAttLbl().getText());
            def = Integer.valueOf(this.f.getStatPanel(opponent).getTotalSdefLbl().getText());
        }
        
        if(type == 2){
            att = Integer.valueOf(this.f.getStatPanel(player).getTotalSattLbl().getText());
            def = Integer.valueOf(this.f.getStatPanel(opponent).getTotalSdefLbl().getText());
        }
        
        if(type == 3){
            att = Integer.valueOf(this.f.getStatPanel(player).getTotalSattLbl().getText());
            def = Integer.valueOf(this.f.getStatPanel(opponent).getTotalDefLbl().getText());
        }
        
        if(isStab){
            stab = 1.5;
        }
        
        
        int damage = (int)((((niveau*0.4 + 2)*att*power)/(def*50)) + 2);
        
        damage *= effectiveness*stab;
        
       
        this.f.getDmgPanel(player).getTotalValueLbl().setText(String.valueOf(damage));
        this.f.getDmgPanel(player).getSsTotalValueLbl().setText(String.valueOf((int)(damage*0.85)));
        
        this.f.getDmgPanel(player).getTotalCritValueLbl().setText(String.valueOf((int)(damage*1.5)));
        this.f.getDmgPanel(player).getSsTotalCritValueLbl().setText(String.valueOf((int)(damage*0.85*1.5)));   
        
    }
    
    
}
