package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.RandomNumberGeneratorImpl;
import racingcar.view.InputInterface;
import racingcar.view.InputView;
import racingcar.view.ResultView;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class GameController {
    private final InputInterface inputView;

    public GameController(InputInterface inputView) {
        this.inputView = inputView;
    }

    public void run() {
        List<Car> cars = initCars();
        int tryCount = getTryCount();
        playRace(cars, tryCount);
        List<String> winners = getWinners(cars);
        ResultView.printWinners(winners);
    }

    private List<Car> initCars() {
        String[] carNames = getCarNames();
        validateCarNames(carNames);
        return createCars(carNames);
    }

    private String[] getCarNames() {
        return inputView.getCarNames();
    }

    private List<Car> createCars(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name, new RandomNumberGeneratorImpl()));
        }
        return cars;
    }

    private void validateCarNames(String[] carNames){
        Set<String> nameSet = new HashSet<>();
        for (String name : carNames){
            if(nameSet.contains(name)){
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
            nameSet.add(name);
        }

        if (nameSet.isEmpty()) {
            throw new IllegalArgumentException("자동차는 최소 1대 이상이어야 합니다.");
        }
    }

    private int getTryCount() {
        return inputView.getTryCount();
    }

    private void playRace(List<Car> cars, int tryCount) {
        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            raceOnce(cars);
            printRaceStatus(cars);
        }
    }

    private void raceOnce(List<Car> cars) {
        for (Car car : cars) {
            car.move();
        }
    }

    private void printRaceStatus(List<Car> cars) {
        ResultView.printProgress(cars);
    }

    private List<String> getWinners(List<Car> cars) {
                int maxPosition = 0;
                for (Car car : cars) {
                    if (car.getPosition() > maxPosition) {
                        maxPosition = car.getPosition();
                    }
                }

                List<String> winners = new ArrayList<>();
                for (Car car : cars) {
                    if (car.getPosition() == maxPosition) {
                  winners.add(car.getName());
            }
        }
        return winners;
    }
}