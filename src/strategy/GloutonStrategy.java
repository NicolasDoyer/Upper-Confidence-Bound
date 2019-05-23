package strategy;

import manchot.Manchot;

/**
 * GloutonStrategy class.
 */
public class GloutonStrategy implements StrategyInterface{

    @Override
    public double run(int iterations, Manchot[] manchots) {

        double bestValue = 0;
        int bestManchot = 0;

        for(int i = 0; i < manchots.length; i++)
        {
            double value = manchots[i].tirerBras();
            if(value > bestValue) {
                bestManchot = i;
                bestValue = value;
            }
        }

        double result = 0;
        for(int i = 0; i < iterations - manchots.length; i++)
        {
            result += manchots[bestManchot].tirerBras();
        }
        return result;
    }
}
