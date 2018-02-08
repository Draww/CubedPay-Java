package co.melondev.cubedpay.authorization;

/**
 * @author Clutch
 * @since 02/07/2018
 */
public class ExponentialBackoff {

    private int base = 2;
    private int maximum = 60;
    private int backoffs = 0;

    public int next() {
        return Math.min(base^this.backoffs++, this.maximum);
    }
}
