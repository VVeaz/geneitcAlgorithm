import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Individual> population = new ArrayList<>();
        for(int i=0; i<100; i++){
            population.add(new Individual());
        }
        for(Individual individual : population){
            individual.fitness();
            System.out.println(individual.dna+ " "+ individual.fit);
        }
        population.sort(Individual.comp());
        System.out.println("---------");
        int sumOfFit = 0;
        for(Individual individual :population){
            System.out.println(individual.dna+ " "+ individual.fit);
            sumOfFit+=individual.fit;
        }
        System.out.println(sumOfFit);
        for(Individual individual :population){
            individual.setPercentageShare(sumOfFit);
            System.out.println(individual.dna+ " "+ individual.fit+ " "+individual.percentageShare);

        }
        List<Individual> crossbreedingList = new ArrayList<>();

    }
}
