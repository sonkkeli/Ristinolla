
package ristinolla;

import javafx.scene.control.Button;

public class Pelilogiikka {
    private int siirrot;
    
    public Pelilogiikka(){
        this.siirrot = 0;  // parilliset = X ja parittomat = O
    }
    
    public void setVuoro(){
        this.siirrot++;
    }
    
    public void lopeta(){
        this.siirrot = 9;
    }
    
    public String getVuoro(){
        // palauttaa 1 tai 0, eli pariton tai parillinen, joka muutetaan myöhemmin X tai O 
        int vuoro = this.siirrot % 2;    
        if (vuoro == 0){
            return "X";
        } else {
            return "O";
        }
    }
    public String getSeuraavaVuoro(){
        if (this.siirrot >= 8){
            return "Loppu!";
        }
        if (this.getVuoro().equals("X")){
            return "O";
        } else {
            return "X";
        }
    }
    
    public boolean onkoVoitettu(Button[] napit){
        String[] ristinolla = {"X", "O"};
        
        for (String arvo : ristinolla){
            // vaakasuorat
            if (napit[0].getText().equals(arvo) && napit[1].getText().equals(arvo) && napit[2].getText().equals(arvo)){
                return true;
            }
            if (napit[3].getText().equals(arvo) && napit[4].getText().equals(arvo) && napit[5].getText().equals(arvo)){
                return true;
            }
            if (napit[6].getText().equals(arvo) && napit[7].getText().equals(arvo) && napit[8].getText().equals(arvo)){
                return true;
            }
            //pystysuorat
            if (napit[0].getText().equals(arvo) && napit[3].getText().equals(arvo) && napit[6].getText().equals(arvo)){
                return true;
            }
            if (napit[1].getText().equals(arvo) && napit[4].getText().equals(arvo) && napit[7].getText().equals(arvo)){
                return true;
            }
            if (napit[2].getText().equals(arvo) && napit[5].getText().equals(arvo) && napit[8].getText().equals(arvo)){
                return true;
            }
            //vinot
            if (napit[0].getText().equals(arvo) && napit[4].getText().equals(arvo) && napit[8].getText().equals(arvo)){
                return true;
            }
            if (napit[2].getText().equals(arvo) && napit[4].getText().equals(arvo) && napit[6].getText().equals(arvo)){
                return true;
            }            
        }
        return false;
    }
    
    
}
