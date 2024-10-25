package race;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Race {


    public String racing(String carString, String attempts) {

        Map<String, Integer> cars = storeCars(carString);

        int attempt = attemptToInt(attempts);

        cars.forEach((key, value) -> {
            int newValue = playRacingCar(value);
            cars.put(key, newValue);

            printCarForward(cars);
        });

        String winners = findWinners(cars);

        return winners;
    }

    private Map<String, Integer> storeCars(String input) {

        Map<String, Integer> cars = new HashMap<>();

        String[] tokens = input.split(",");

        for (String token : tokens) {

            CheckException.checkNameOfCar(token);
            cars.put(token, 0);
        }

        return cars;
    }

    private int attemptToInt(String input) {

        int attempt = Integer.parseInt(input);

        CheckException.checkAttempt(attempt);

        return attempt;
    }

    private int playRacingCar(int value) {

        if (getRandomNum()) {
            value++;
        }

        return value;
    }

    private boolean getRandomNum() {

        int randomNum = Randoms.pickNumberInRange(0, 9);

        if (randomNum >= 4)
            return true;
        else
            return false;
    }

    private void printCarForward(Map<String, Integer> cars) {

        System.out.println("실핼 결과");

        cars.forEach((key, value) -> {
            System.out.print(key + " : ");
            printForward(value);
        });
    }

    private void printForward(int value) {

        for (int i = 0; i < value; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private String findWinners(Map<String, Integer> cars) {

        List<String> winners = new ArrayList<>();
        int maxNum = 0;

        for(int i: cars.values()) {
            maxNum = Math.max(maxNum, i);
        }

        int finalMaxNum = maxNum;
        cars.forEach((key, value) -> {
            if (value == finalMaxNum) {
                winners.add(key);
            }
        });

        return String.join(", ", winners);
    }
}
