package racingcar;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class WinnerValidator {
    final static String OUTPUT_MESSAGE = "최종 우승자 : ";
    LinkedHashMap<String, Integer> cars;

    public WinnerValidator(LinkedHashMap<String, Integer> cars) {
        this.cars = cars;
    }

    public ArrayList<String> findRacingWinners() {
        ArrayList<String> winnersCars = new ArrayList<>();
        Integer winnersNumber = cars.values().stream().max(Integer::compare).orElse(0);

        for (Map.Entry<String, Integer> entry : cars.entrySet()) {
            if (cars.get(entry.getKey()).equals(winnersNumber) ) {
                winnersCars.add(entry.getKey());
            }
        }
        return winnersCars;
    }

    public void outputWinners(ArrayList<String> winnerCars) {
        output();
        System.out.println(String.join(", ", winnerCars));
    }
    public void output() {
        System.out.print(OUTPUT_MESSAGE);
    }
}
