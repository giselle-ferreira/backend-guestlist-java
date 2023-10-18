package giselletech.apiguestlist.myutils;

import java.util.Random;

public class MyUtils {
    public static Long generateRandomId(){
        Random randomId = new Random();
        return randomId.nextLong(1000);
    }
}
