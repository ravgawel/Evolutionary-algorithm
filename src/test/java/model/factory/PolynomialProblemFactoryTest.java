package model.factory;

import model.problem.IProblem;
import model.problem.PolynomialProblem;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class PolynomialProblemFactoryTest {
    PolynomialProblemFactory factory = new PolynomialProblemFactory();
    @Test
    public void createProblem() {
        float[] polynomial = new float[]{1,2,3};
        PolynomialProblem problem = (PolynomialProblem) factory.createProblem();
        assertTrue(Arrays.equals(polynomial, problem.getPolynomial()));
    }
}