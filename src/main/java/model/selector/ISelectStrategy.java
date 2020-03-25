package model.selector;

import model.problem.Chromosome;
import model.problem.Gene;

import java.util.List;

public interface ISelectStrategy <T extends Gene> {

    List<Chromosome<T>> selectPersistentChromosomes(List<Chromosome<T>> chromosomes);

    List<Chromosome<T>> selectChromosomesWithBiggestFitness(List<Chromosome<T>> chromosomes);
}
