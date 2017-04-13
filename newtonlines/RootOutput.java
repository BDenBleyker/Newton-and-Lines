/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newtonlines;

/**
 *
 * @author benne_000
 */
public class RootOutput {

    final int iteration;
    final double error;
    final double result;

    public RootOutput(double result, double error, int iteration) {
        this.iteration = iteration;
        this.error = error;
        this.result = result;
    }

    public int getIteration() {
        return iteration;
    }

    public double getError() {
        return error;
    }

    public double getResult() {
        return result;
    }

}
