package model.factory;


import model.problem.IProblem;
import model.problem.PolynomialProblem;

public class PolynomialProblemFactory implements IProblemFactory {


    public IProblem createProblem() {
        return new PolynomialProblem(new float[]{1,2,3});
    }
}
