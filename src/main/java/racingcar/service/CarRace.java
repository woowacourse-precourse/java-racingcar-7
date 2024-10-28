package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class CarRace {
    Car[] cars;
    int raceCount;

    public void race(String carsInput, String count) {
        getCars(carsInput);
        raceCount = Integer.parseInt(count);

        for (int i = 0; i < raceCount; i++) {
            playRace();
        }

        getWinner();
    }

    private void getCars(String carsInput) {
        String[] carNames = carsInput.split(",");
        cars = new Car[carNames.length];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(carNames[i]);
        }
    }

    private void playRace() {
        for (Car car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) car.move();
        }
        showRaceStatus();
    }

    private void showRaceStatus() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private void getWinner() {
        int maxMove = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (maxMove < car.getMoveCount()) {
                maxMove = car.getMoveCount();
                winners = new ArrayList<>();
                winners.add(car.getName());
            } else if (maxMove == car.getMoveCount()) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
