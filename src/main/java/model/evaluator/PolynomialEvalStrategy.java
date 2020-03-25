package model.evaluator;

import model.problem.Chromosome;
import model.problem.FloatChromosome;
import model.problem.FloatGene;
import model.problem.PolynomialProblem;

import java.util.List;


public class PolynomialEvalStrategy implements IEvalStrategy<FloatGene> {

    PolynomialProblem problem;

    public PolynomialEvalStrategy(PolynomialProblem problem) {
        this.problem = problem;
    }

    public List<Chromosome<FloatGene>> evaluateChromosomes(List<Chromosome<FloatGene>> chromosomes) {
        for (Chromosome chromosome : chromosomes) {
            chromosome.setChromosomeFitnessValue(evaluateFitnessValue((FloatChromosome) chromosome));
        }
        return chromosomes;
    }

    private float evaluateFitnessValue(FloatChromosome chromosome) {
        if (problem.isSearchingForMax()) {
            return polynomialValue((chromosome.getGenes().get(0)).getValue(), problem.getPolynomial());
        } else {
            return -polynomialValue((chromosome.getGenes().get(0)).getValue(), problem.getPolynomial());
        }
    }

    private float polynomialValue(float x, float[] polynomial) {
        float outp = 0;

        for (int i = 0; i < polynomial.length; i++) {
            outp += polynomial[i] * Math.pow(x, i);
        }

        return outp;

    }
}
