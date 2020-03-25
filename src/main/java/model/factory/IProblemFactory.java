package model.factory;

import model.crossbreeder.ICrossStrategy;
import model.evaluator.IEvalStrategy;
import model.initializer.IInitStrategy;
import model.mutator.IMutateStrategy;
import model.problem.IProblem;

public interface IProblemFactory
{
    IProblem createProblem();
}
