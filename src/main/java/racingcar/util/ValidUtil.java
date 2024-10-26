package racingcar.util;

public class ValidUtil {
    public static boolean isNumeric(String input){
        try{
            Integer.parseInt(input);
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public static boolean isEmpty(String input){
        return input == null || input.isEmpty();
    }

    public static boolean isPositive(String input){
        return Integer.parseInt(input) > 0;
    }


}
