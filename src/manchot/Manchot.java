package manchot;

import java.util.Random;

/**
 * manchot.Manchot class.
 */
public class Manchot implements ManchotInterface
{

    /**
     * Esperance.
     */
    private double esperance;

    /**
     * Variance.
     */
    private double variance;

    /**
     * Random.
     */
    private Random random;

    /**
     * Default constructor.
     *
     * @param esperance: Esperance
     * @param variance: Variance
     */
    public Manchot(double esperance, double variance)
    {
        this.random = new Random();
        this.esperance = esperance;
        this.variance = variance;
    }

    @Override
    public double tirerBras()
    {
        return random.nextGaussian() * this.variance + this.esperance;
    }
}
