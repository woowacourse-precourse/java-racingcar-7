package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

import static racingcar.Constants.*;
import static racingcar.Utils.*;

public class CarRacing {

    public void init() {
        // inputStringsArr = [ 자동차 이름들, 시도횟수 ]
        final ArrayList<String> inputStringsArr = inputStrings();

        final int attempts = convertAttempts(inputStringsArr.get(1));
        final ArrayList<Car> cars = createCarObjects(convertCarNames(inputStringsArr.get(0)));

        final ArrayList<String> winners = racingStart(cars, attempts);

        printGameWinners(winners);

    }

    private ArrayList<String> inputStrings() {
        ArrayList<String> inputStringArr = new ArrayList<>();

        println(INPUT_CAR_NAMES);
        inputStringArr.add(Console.readLine());
        println(INPUT_ATTEMPTS);
        inputStringArr.add(Console.readLine());

        return inputStringArr;
    }

    ArrayList<Car> createCarObjects(final ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
        return cars;
    }

    private ArrayList<String> racingStart(final ArrayList<Car> cars, final int attempts) {
        println(RESULT_NOTICE);
        for (int i = 0; i < attempts; i++) {
            // 랜덤 값 생성하고 자동차 전진
            for (Car car : cars) {
                car.run();
            }
            printGameStatus(cars);
        }
        return determineWinner(cars);
    }

    private void printGameStatus(final ArrayList<Car> cars) {
        for (Car car : cars) {
            println(makeMovedAmountString(car.name, car.movedAmount));
        }
        println("\n");
    }

    public String makeMovedAmountString(final String carName, final int movedAmount) {
        String movedAmountString = "-".repeat(movedAmount);
        if (movedAmount == 0) {
            movedAmountString = "";
        }
        return String.format("%s : %s", carName, movedAmountString);
    }

    public ArrayList<String> determineWinner(final ArrayList<Car> cars) {
        int maxMovedAmount = 0;
        ArrayList<Car> candidateCars = new ArrayList<>();

        // 참가 자동차 배열을 순회하면서 movedAmount가 가장 큰 자동차 저장
        for (Car car : cars) {
            if (car.movedAmount > maxMovedAmount) {
                maxMovedAmount = car.movedAmount;
                candidateCars.clear();
            } else if (car.movedAmount < maxMovedAmount) {
                continue;
            }
            candidateCars.add(car);
        }

        return getWinnerNames(candidateCars);
    }

    private ArrayList<String> getWinnerNames(final ArrayList<Car> winners) {
        ArrayList<String> winnerNames = new ArrayList<>();

        winners.forEach(car -> winnerNames.add(car.name));

        return winnerNames;
    }

    private void printGameWinners(final ArrayList<String> winners) {
        println(WINNER_NOTICE + String.join(", ", winners));
    }

}