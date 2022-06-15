package MARKET;

import java.nio.channels.Channel;

public class VIP_DisCount {

    private static double BASE_DISCOUNT = 0.95;
    public double VIP_DISCOUNT  = 0.9;
    private static double SVIP_DISCOUNT = 0.85;

    public static double Change_SVIP_discount(double newSVIP){
        SVIP_DISCOUNT = newSVIP;
        return SVIP_DISCOUNT;
    }

    // 变量调用
    public static double getBASE_DISCOUNT(){
        return BASE_DISCOUNT;
    }
    public double getVIP_DISCOUNT(){
        return VIP_DISCOUNT;
    }
    public static double getSVIP_DISCOUNT(){
        return SVIP_DISCOUNT;
    }



}
