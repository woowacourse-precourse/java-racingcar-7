package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinnerValidator {
    Integer winnersNumber;
    LinkedHashMap<String,Integer> cars = new LinkedHashMap<>();

    public ArrayList<String> findRacingWinners() {
        ArrayList<String> winnersCars = new ArrayList<>();

        RacingGame racingGame = new RacingGame();
        cars = racingGame.getCarNumber();

        winnersNumber = cars.values().stream().max(Integer::compare).orElse(0);

        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            if (cars.get(entry.getKey()).equals(winnersNumber) ) {
                winnersCars.add(entry.getKey());

            }
        }
        System.out.println(winnersCars);
        return winnersCars;
    }

    public void outputWinners(ArrayList<String> cars) {

        output();
        System.out.println(String.join(", ", cars));

    }
    public void output() {
        System.out.print("최종 우승자 : ");

    }

}
