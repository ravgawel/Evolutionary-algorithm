package model.crossbreeder;

import model.problem.Chromosome;
import model.problem.Gene;
import model.problem.IProblem;

import java.util.List;

public interface ICrossStrategy<T extends Gene> {
    List<Chromosome<T>> crossChromosomes(List <Chromosome<T>> chromosomes);
}
