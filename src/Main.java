import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Individual> population = new ArrayList<>();
        for(int i=0; i<100; i++){
            population.add(new Individual());
        }

        for(int t=0; t<50000; t++) {
            int sumOfFit = 0;
            for (Individual individual : population) {
                individual.fitness();
                sumOfFit += individual.fit;
            }
            population.sort(Individual.comp());

            //System.out.println("---------");
            //System.out.println(sumOfFit);
            List<Individual> crossbreedingList = new ArrayList<>();
            for (Individual individual : population) {
                individual.setPercentageShare(sumOfFit);
                for (int i = 0; i < individual.percentageShare; i++) {
                    crossbreedingList.add(individual);
                }
            }
            if(sumOfFit == 800){
                System.out.println(t);
                break;
            }
//        for(Individual individual : crossbreedingList){
//            System.out.println(individual.dna+ " "+ individual.fit+ " "+individual.percentageShare);
//        }
            Random generator = new Random();
            population.clear();
            for (int i = 0; i < 100; i++) {
                int motherIndex = generator.nextInt(crossbreedingList.size());
                int fatherIndex = generator.nextInt(crossbreedingList.size());
                population.add(new Individual(crossbreedingList.get(motherIndex).dna.substring(0, 4) +
                        crossbreedingList.get(fatherIndex).dna.substring(0, 4)));
            }
            crossbreedingList.clear();

//        for(Individual individual : population){
//            System.out.println(individual.dna+ " "+ individual.fit+ " "+individual.percentageShare);
//        }

        }
        for(Individual individual : population){
            System.out.println(individual.dna+ " "+ individual.fit+ " "+individual.percentageShare);
        }



    }
}
