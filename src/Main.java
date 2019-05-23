import manchot.Manchot;
import strategy.GloutonStrategy;
import strategy.RandomStrategy;
import strategy.UcbStrategy;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int iteration = 15000;
        RandomStrategy randomStrategy = new RandomStrategy();
        GloutonStrategy gloutonStrategy = new GloutonStrategy();
        UcbStrategy ucbStrategy = new UcbStrategy(Math.sqrt(2), true);
        Manchot[] manchots = buildManchots(15);


        System.out.println("Score Random : " + randomStrategy.run(iteration, manchots));
        System.out.println("Score Meilleur : " + gloutonStrategy.run(iteration, manchots));
        System.out.println("Score UCB : " + ucbStrategy.run(iteration, manchots));
    }

    public static Manchot[] buildManchots(int number) {
        Manchot[] manchots = new Manchot[number];
        Random random = new Random();

        for(int i = 0; i < number; i++) {
            double esperance = -10 + (10 - (-10)) * random.nextDouble();
            double variance = 10 * random.nextDouble();
            manchots[i] = new Manchot(esperance,variance);
        }

        return manchots;
    }
}
