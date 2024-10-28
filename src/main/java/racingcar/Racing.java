package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class Racing {
    private final int MIN_MOVING_NUMBER = 4;
    private List<Car> cars = new ArrayList<>();
    private Map<Integer, List<String>> result = new HashMap<>();


    public void addCar(Car car) {
        cars.add(car);
    }

    public void playRacing(int attemptNumber) {
        for (int i = 0; i < attemptNumber; i++) {
            runRound();
            printRoundResults();
        }
        tallyRecord();
    }

    private void tallyRecord() {
        for (Car car : cars) {
            saveCompetitionRecord(car);
        }
        showWinner();
    }

    private void showWinner() {
        Integer winnerKey = Collections.max(result.keySet());
        List<String> winners = result.get(winnerKey);

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }

    private void saveCompetitionRecord(Car car) {
        result.computeIfAbsent(car.getRacingCount(), k -> new ArrayList<>()).add(car.getCarName());
    }

    private void runRound() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            car.drive(randomNumber >= MIN_MOVING_NUMBER);
        }
    }

    private void printRoundResults() {
        for (Car car : cars) {
            car.showRacingCarCompetition();
        }
        System.out.println();
    }
}