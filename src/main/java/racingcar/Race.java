package racingcar;

import java.util.*;

public class Race {
    public List<Car> cars;
    public int moveCnt;

    public Race(List<Car> cars, int moveCnt) {
        this.cars = cars;
        this.moveCnt = moveCnt;
    }
    public void startRace() {
        System.out.println("실행 결과");

        for (int i = 0; i < moveCnt; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
            }
            System.out.println();
        }
    }
    public List<String> getWinners() {
        int max = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() > max) max = car.getDistance();
        }

        for (Car car : cars) {
            if (car.getDistance() == max) winners.add(car.getName());
        }
        return winners;
    }
}
