package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameContext {
    private final List<Car> cars;
    private final int round;

    private GameContext(List<Car> cars, int round) {
        if (cars.size() > 100) {
            throw new IllegalArgumentException();
        }

        if (round > 10_000 || round <= 0) {
            throw new IllegalArgumentException();
        }
        this.cars = cars;
        this.round = round;
    }

    public static GameContext getGameContext(String carNameInput, int round) {
        List<Car> cars = new ArrayList<>();
        Arrays.stream(carNameInput.split(","))
                .map(s -> new Car(s, () -> Randoms.pickNumberInRange(0, 9)))
                .forEach(cars::add);
        return new GameContext(cars, round);
    }

    public static GameContext getGameContext(List<Car> cars, int round) {
        return new GameContext(cars, round);
    }

    public List<Car> getCars() {
        return cars;
    }

    public int getRound() {
        return round;
    }

    public void run() {
        for (int i = 0; i < round; i++) {
            playRound();
        }
    }

    public List<String> findWinners() {
        int topCarPlace = 0;
        List<Car> winner = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPlace() > topCarPlace) {
                winner.clear();
                winner.add(car);
                topCarPlace = car.getPlace();
            } else if (car.getPlace() == topCarPlace) {
                winner.add(car);
            }
        }
        return getWinnersNameList(winner);
    }

    private void playRound() {
        for (Car car : cars) {
            car.move();
            car.printPlace();
        }
        System.out.println();
    }

    private List<String> getWinnersNameList(List<Car> winner) {
        return winner.stream().map(Car::getCarName).toList();
    }
}
