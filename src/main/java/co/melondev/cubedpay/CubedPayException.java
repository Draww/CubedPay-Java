package co.melondev.cubedpay;

import java.io.IOException;

/**
 * @author theminecoder
 */
public class CubedPayException extends IOException {

    private int code;

    public CubedPayException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }


}
