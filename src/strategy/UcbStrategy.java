package strategy;

import manchot.Manchot;

import java.util.Arrays;

public class UcbStrategy implements StrategyInterface {

    private double k;
    private boolean logger;

    public UcbStrategy(double k, boolean logger)
    {
        this.k = k;
        this.logger = logger;
    }

    @Override
    public double run(int iterations, Manchot[] manchots) {

        int[] tiragesManchots = new int[manchots.length];
        double[] scoreManchots = new double[manchots.length];
        double scoreTotal = 0;
        double tiragesTotal = 0;

        for (int i = 0; i < manchots.length; i++) {
            tiragesManchots[i] ++;
            double score = manchots[i].tirerBras();
            scoreManchots[i] += score;
            scoreTotal += score;
            tiragesTotal ++;
        }

        for (int i = 0; i < iterations - manchots.length; i++) {

            // Choose best manchot.
            double bestUcb = 0;
            int bestManchot = 0;
            for (int u = 0; u < manchots.length; u++) {
                double ucb = (scoreManchots[u] / tiragesManchots[u]) + this.k * Math.sqrt(Math.log(tiragesTotal) / tiragesManchots[u]);
                if(ucb > bestUcb) {
                    bestUcb = ucb;
                    bestManchot = u;
                }
            }

            // Use best manchot.
            double score = manchots[bestManchot].tirerBras();
            scoreTotal += score;
            tiragesTotal ++;
            scoreManchots[bestManchot] += score;
            tiragesManchots[bestManchot] ++;
        }

        if(this.logger) {
            System.out.println("Répartition UCB : " + Arrays.toString(tiragesManchots));
        }

        return scoreTotal;
    }
}
