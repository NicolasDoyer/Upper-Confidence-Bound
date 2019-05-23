package strategy;

import manchot.Manchot;

import java.util.Random;

public class RandomStrategy implements StrategyInterface
{

    private Random random;

    public RandomStrategy() {
        this.random = new Random();
    }

    @Override
    public double run(int iterations, Manchot[] manchots)
    {
        double result = 0;
        for(int i = 0; i < iterations; i++)
        {
            int randomIndex = random.nextInt(manchots.length);
            result += manchots[randomIndex].tirerBras();
        }

        return result;
    }
}
