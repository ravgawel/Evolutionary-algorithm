package model.evaluator;

import model.problem.AntChromosome;
import model.problem.AntGene;
import model.problem.AntProblem;
import model.problem.Chromosome;

import java.util.ArrayList;
import java.util.List;

public class AntEvalStrategy implements IEvalStrategy<AntGene> {
    AntProblem antProblem;

    public AntEvalStrategy(AntProblem antProblem) {
        this.antProblem = antProblem;
    }

    @Override
    public List<Chromosome<AntGene>> evaluateChromosomes(List<Chromosome<AntGene>> chromosomes) {
        for(Chromosome chromosome: chromosomes)
            chromosome.setChromosomeFitnessValue(evaluateFitnessValue(chromosome));
        return chromosomes;
    }

    private float evaluateFitnessValue(Chromosome chromosome){
        List<AntGene> antGenes = chromosome.getGenes();
        int fitnessValue = 0;
        for (AntGene antGene : antGenes) {
            fitnessValue += antGene.getAntBoardField().getFoodPoints();
        }
        return (float) fitnessValue;

    }
}
