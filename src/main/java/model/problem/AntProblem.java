package model.problem;

import java.util.List;

public class AntProblem implements IProblem<AntGene> {

    private List<Chromosome<AntGene>> chromosomes;

    @Override
    public void setChromosomes(List<Chromosome<AntGene>> chromosomes) {
        this.chromosomes = chromosomes;
    }

    @Override
    public List<Chromosome<AntGene>> getChromosomes() {
        return this.chromosomes ;
    }
}
