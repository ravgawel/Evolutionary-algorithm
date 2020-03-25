package model.initializer;

import model.problem.Chromosome;
import model.problem.Gene;
import java.util.List;


public interface IInitStrategy<T extends Gene> {
    List<Chromosome<T>> initChromosomes(int chromosomesAmount, int chromosomeSize);

    List<T> initGenes(int genesAmount);
}
