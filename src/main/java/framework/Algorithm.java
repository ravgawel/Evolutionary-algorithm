package framework;

import framework.stopstrategy.IStopStrategy;
import model.crossbreeder.ICrossStrategy;
import model.evaluator.IEvalStrategy;
import model.initializer.IInitStrategy;
import model.mutator.IMutateStrategy;
import model.problem.*;
import model.selector.ISelectStrategy;

import java.util.List;

public class Algorithm <T extends Gene> {
    private IStopStrategy stopStrategy;
    private IProblem<T> problem;
    private String name;
    private ICrossStrategy <T>crossStrategy;
    private IInitStrategy<T> initStrategy;
    private IMutateStrategy<T >mutateStrategy;
    private IEvalStrategy<T> evalStrategy;
    private ISelectStrategy selectStrategy;


    private Algorithm(AlgorithmBuilder<T> algorithmBuilder) {
        this.stopStrategy = algorithmBuilder.stopStrategy;
        this.problem = algorithmBuilder.problem;
        this.name = algorithmBuilder.name;
        this.crossStrategy = algorithmBuilder.crossStrategy;
        this.initStrategy = algorithmBuilder.initStrategy;
        this.mutateStrategy = algorithmBuilder.mutateStrategy;
        this.evalStrategy = algorithmBuilder.evalStrategy;
        this.selectStrategy = algorithmBuilder.selectStrategy;

    }

    public static class AlgorithmBuilder<T extends Gene> {
        IStopStrategy stopStrategy;
        IProblem<T> problem;
        String name;
        ICrossStrategy<T> crossStrategy;
        IInitStrategy<T> initStrategy;
        IMutateStrategy<T> mutateStrategy;
        IEvalStrategy<T> evalStrategy;
        ISelectStrategy selectStrategy;

        public AlgorithmBuilder(IStopStrategy stopStrategy, IProblem<T> problem) {
            this.stopStrategy = stopStrategy;
            this.problem = problem;
        }

        public AlgorithmBuilder<T> name(String name) {
            this.name = name;
            return this;
        }

        public AlgorithmBuilder<T> crossStrategy(ICrossStrategy<T> crossStrategy) {
            this.crossStrategy = crossStrategy;
            return this;
        }

        public AlgorithmBuilder<T> initStrategy(IInitStrategy<T> initStrategy) {
            this.initStrategy = initStrategy;
            return this;
        }

        public AlgorithmBuilder<T> mutateStrategy(IMutateStrategy<T> mutateStrategy) {
            this.mutateStrategy = mutateStrategy;
            return this;
        }

        public AlgorithmBuilder<T> evalStrategy(IEvalStrategy<T> evalStrategy) {
            this.evalStrategy = evalStrategy;
            return this;
        }

        public AlgorithmBuilder<T> selectStrategy(ISelectStrategy selectStrategy) {
            this.selectStrategy = selectStrategy;
            return this;
        }

        public Algorithm<T> build() {
            return new Algorithm<>(this);
        }
    }

    public List<Chromosome<T>> getProblemChromosomes() {
        return this.problem.getChromosomes();
    }

    public void setProblemChromosomes(List<Chromosome<T>> chromosomes) {
        this.problem.setChromosomes(chromosomes);
    }

    public String getName() {
        return name;
    }

    public IStopStrategy getStopStrategy() {
        return stopStrategy;
    }

    public IProblem getProblem() {
        return problem;
    }

    public ICrossStrategy<T> getCrossStrategy() {
        return crossStrategy;
    }

    public IInitStrategy<T> getInitStrategy() {
        return initStrategy;
    }

    public IMutateStrategy<T> getMutateStrategy() {
        return mutateStrategy;
    }

    public IEvalStrategy<T> getEvalStrategy() {
        return evalStrategy;
    }

    public ISelectStrategy getSelectStrategy() {
        return selectStrategy;
    }

    public void run() {
        //initialize
        setProblemChromosomes(this.initStrategy.initChromosomes(10, 1));
        while (true) {

            //ewaluacja
            setProblemChromosomes(this.evalStrategy.evaluateChromosomes(getProblemChromosomes()));

            if (!this.stopStrategy.isAlgorithmWorking()) {
                break;
            }

            //selekcja
            setProblemChromosomes(selectStrategy.selectPersistentChromosomes(getProblemChromosomes()));

            //krzyzowanie
            setProblemChromosomes(crossStrategy.crossChromosomes(getProblemChromosomes()));

            //mutacja
            setProblemChromosomes(mutateStrategy.mutateChromosomes(getProblemChromosomes()));
        }
    }

}
