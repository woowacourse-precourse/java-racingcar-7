package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarRace {

    public static String race(String inputCarNames, String inputRaceCount){

        List<RacingCar> racingCars = new ArrayList<>();;
        int raceCount = 0;

        try {
            List<String> parseCarNames = parseString(inputCarNames);
            parseCarNames.forEach((car -> {
                racingCars.add(new RacingCar(car));
            }));
            raceCount = parseInt(inputRaceCount);

        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e);
        }

        // 자동차 경주 진행
        for(int i=0; i<raceCount; i++){
            racingCars.forEach(racingCar -> {
                racingCar.move();
                racingCar.printMoveState();
            });
        }

        // 최종 우승자 선정
        String winner = String.join(", ", determineWinner(racingCars));
        return winner;
    }

    // 최종 우승자 계산
    private static List<String> determineWinner(List<RacingCar> cars){
        List<String> winners = new ArrayList<>();
        int maxDistance = 0;

        for (RacingCar car : cars) {
            int currentDistance = car.getDistance();
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                winners.clear();
                winners.add(car.getName());
            } else if (currentDistance == maxDistance) {
                winners.add(car.getName());
            }
        }

        return winners;
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
