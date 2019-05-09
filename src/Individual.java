import sun.awt.datatransfer.DataTransferer;

import java.util.Comparator;
import java.util.Random;

public class Individual {
    public String dna;
    public int fit;
    public int percentageShare;
    public void fitness(){
        int f=0;
        for(int i=0; i<dna.length(); i++){
            if(dna.charAt(i) == '1'){
                f++;
            }

        }
        fit= f;
    }

    public Individual() {
        Random generator = new Random();
        StringBuilder d= new StringBuilder();
        for(int i=0; i<8; i++){
            int x= generator.nextInt(50);
            if(x%2==0){
                d.append('0');
            }else{
                d.append('1');
            }


        }
        dna = d.toString();
    }

    public Individual(String dnaFromParents) {

        dna = dnaFromParents;
    }

    public static Comparator<Individual> comp(){
        return new Comparator<Individual>(){
            @Override
            public int compare(Individual i1, Individual i2){
                return i2.fit-i1.fit;
            }
        };
    }
    public void setPercentageShare(int sumOfFit){
        double p = (1000.0*fit)/sumOfFit;
        percentageShare = (int) p;
    }
}
