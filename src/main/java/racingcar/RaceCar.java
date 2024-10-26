package racingcar;

import java.util.ArrayList;
import java.util.HashMap;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceCar {
    private final RaceCarPrinter printer = new RaceCarPrinter();

    public void start(String[] carNames, int raceTimes) {
        int carNums = carNames.length;
        HashMap<String, Integer> carMap = initCars(carNames);

        for (int i = 0; i < raceTimes; i++) {
            for (String key : carMap.keySet()) {
                int value = carMap.get(key);
                int number = randomNumber();
                carMap.put(key, value + number);
            }
            printer.printRace(carMap);
        }
        ArrayList<String> winner = checkWinner(carMap);
        printer.printWinner(winner);
    }

    private ArrayList<String> checkWinner(HashMap<String, Integer> carMap) {
        int maxValue = 0;
        ArrayList<String> array = new ArrayList<>();
        for (int value : carMap.values()) {
            maxValue = Math.max(maxValue, value);
        }
        for (String key : carMap.keySet()) {
            if (carMap.get(key) == maxValue) {
                array.add(key);
            }
        }
        return array;
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
