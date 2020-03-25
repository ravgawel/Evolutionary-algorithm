package model.selector;

import model.problem.Chromosome;
import model.problem.Gene;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SelectTopNStrategy implements ISelectStrategy<Gene> {
    private int n;

    public SelectTopNStrategy(int n) {
        this.n = n;
    }

    public List<Chromosome<Gene>> selectPersistentChromosomes(List<Chromosome<Gene>> chromosomes) {
        return chromosomes.stream().sorted().limit(n).collect(Collectors.toList());
    }


    public List<Chromosome<Gene>> selectChromosomesWithBiggestFitness(List<Chromosome<Gene>> chromosomes){
        Collections.sort(chromosomes);
        Collections.reverse(chromosomes);
        return chromosomes.stream().limit(n).collect(Collectors.toList());
    }
}
