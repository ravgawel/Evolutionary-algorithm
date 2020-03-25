package model.problem;

import java.util.List;

public interface IProblem <T extends Gene> {

    void setChromosomes(List<Chromosome<T>> chromosomes);
    List<Chromosome<T>> getChromosomes();


}
