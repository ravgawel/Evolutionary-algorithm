package model.mutator;

import model.problem.Chromosome;
import model.problem.Gene;
import model.problem.IProblem;

import java.util.List;

public interface IMutateStrategy<T extends Gene> {
    List<Chromosome<T>> mutateChromosomes(List<Chromosome<T>> chromosomes);

     float getMutationChance();
     void setMutationChance(float mutationChance);
}
