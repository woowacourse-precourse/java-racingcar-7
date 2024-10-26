package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceCar {
    private final RaceCarPrinter printer = new RaceCarPrinter();
    private HashMap<String, Integer> carMap;

    public void start(String[] carNames, int raceTimes) {
        carMap = initCars(carNames);
        runRace(raceTimes);
        printer.printWinner(checkWinner());
    }

    private void runRace(int raceTimes) {
        for (int i = 0; i < raceTimes; i++) {
            moveAllCars();
            printer.printRace(carMap);
        }
    }

    private void moveAllCars() {
        for (String key : carMap.keySet()) {
            int value = carMap.get(key);
            int number = randomNumber();
            carMap.put(key, value + number);
        }
    }

    private ArrayList<String> checkWinner() {
        ArrayList<String> winners = new ArrayList<>();
        int maxValue = findMaxValue();
        for (String key : carMap.keySet()) {
            if (carMap.get(key) == maxValue) {
                winners.add(key);
            }
        }
        return winners;
    }

    private int findMaxValue() {
        int maxValue = 0;
        for (int value : carMap.values()) {
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }

    private HashMap<String, Integer> initCars(String[] carNames) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String car : carNames) {
            map.put(car, 0);
        }
        return map;
    }

    private int randomNumber() {
        int num = Randoms.pickNumberInRange(0, 9);
        if (num < 4) {
            return 0;
        }
        return 1;
    }
}
