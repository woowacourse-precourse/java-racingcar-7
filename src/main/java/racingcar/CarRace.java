package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarRace {

    public static String race(String inputCar, String inputRaceCount){

        List<String> cars;
        int raceCount = 0;

        try {
            cars = parseString(inputCar);
            raceCount = parseInt(inputRaceCount);

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }

        // 최종 우승자
        String winner = "";
        return winner;
    }

    private static List<String> parseString(String input){
        List<String> splitString = Arrays.asList(input.split(","));
        splitString.forEach(s -> {
            if (s.length() > 5) {
                throw new IllegalArgumentException("자동차 이름이 너무 깁니다. (조건: 5 이하) " + s);
            }
        });
        return splitString;
    }

    private static int parseInt(String input){
        try{
            int number = Integer.parseInt(input);
            if(number < 0){
                throw new IllegalArgumentException("음수는 입력할 수 없습니다." + number);
            }
            return number;
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }
    }

}
