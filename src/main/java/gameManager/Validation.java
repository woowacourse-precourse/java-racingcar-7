package gameManager;

import java.util.Arrays;

public class Validation {

    public static String[] nameCheck(String input){
        isNullOrEmpty(input);
        gamerNumberCheck(input);
        String[] names = splitNames(input);
        nameLengthCheck(names);
        return names;
    }
    public static int roundCheck(String input){
        isNullOrEmpty(input);
        int round = parseToInt(input);
        negativeNumberCheck(round);
        return round;
    }

    private static void isNullOrEmpty(String input){
        if(input == null || input.trim().isEmpty()){
            throw new IllegalArgumentException();
        }
    }

    private static void gamerNumberCheck(String input){
        if(!input.contains(","))
            throw new IllegalArgumentException();
    }

    private static String[] splitNames(String input){
        return input.split(",", -1);
    }

    private static void nameLengthCheck(String[] names) throws IllegalArgumentException {
        Arrays.stream(names)
                .filter(name -> name.length() >= 6)
                .findAny()
                .ifPresent(name -> {
                    throw new IllegalArgumentException();
                });
    }

    private static int parseToInt(String round){
        try{
            return Integer.parseInt(round);
        }catch(NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }

    private static void negativeNumberCheck(int round){
        if(round < 0){
            throw new IllegalArgumentException();
        }
    }
}
