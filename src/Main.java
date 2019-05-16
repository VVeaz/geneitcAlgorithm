import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        List<Individual> population = new ArrayList<>();
        int numberOfPopulation = 100;
        for(int i=0; i<numberOfPopulation; i++){
            population.add(new Individual());
        }

        for(int t=0; t<50000; t++) {
            int sumOfFit = 0;
            for (Individual individual : population) {
                individual.fitness();
                sumOfFit += individual.fit;
            }
            population.sort(Individual.comp());


            List<Individual> crossbreedingList = new ArrayList<>();
            for (Individual individual : population) {
                individual.setPercentageShare(sumOfFit);
                for (int i = 0; i < individual.percentageShare; i++) {
                    crossbreedingList.add(individual);
                }
            }
            if(sumOfFit == 800){
                System.out.println("time: "+t);
                break;
            }
            System.out.println(population.get(0).dna +" "+population.get(0).fit+"  //best in "+ t);
            System.out.println(population.get(population.size() - 1).dna+" "+population.get(population.size() - 1).fit+"   //worst in"+t);
            System.out.println("---------------------------------------");
            Random generator = new Random();
            population.clear();
            for (int i = 0; i < numberOfPopulation; i++) {
                int motherIndex = generator.nextInt(crossbreedingList.size());
                int fatherIndex = generator.nextInt(crossbreedingList.size());
                population.add(new Individual(crossbreedingList.get(motherIndex).dna.substring(0, 4) +
                        crossbreedingList.get(fatherIndex).dna.substring(4, 8)));
            }
            crossbreedingList.clear();


        }
        for(Individual individual : population){
            System.out.println(individual.dna+ " "+ individual.fit+ " "+individual.percentageShare);
        }



    }
}
