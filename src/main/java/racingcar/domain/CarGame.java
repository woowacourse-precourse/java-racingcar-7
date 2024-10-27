package racingcar.domain;

import racingcar.view.Output;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    // 자동차 객체 생성
    public static List<Car> createCar(String[] carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }

        return cars;
    }

    // 주어진 횟수 동안 실행
    public static void moveCar(List<Car> cars, int n) {
        for (int i = 0; i < n; i++) {
            for (Car car : cars) {
                car.move();
                Output.printCarDistance(car.getName(), car.getDistance());
            }
            System.out.println();
        }
    }

    // 최대 전진 횟수 구하기
    public static int findMaxDistance(List<Car> cars) {
        int maxDistance = 0, distance;

        for (Car car : cars) {
            distance = car.getDistance();
            if (distance > maxDistance)
                maxDistance = distance;
        }

        return maxDistance;
    }

    // 최대 전진 횟수를 가지는 자동차 이름 구하기
    public static List<String> findWinner(List<Car> cars, int maxDistance) {
        List<String> winners = new ArrayList<>();
        ;
        int distance;

        for (Car car : cars) {
            distance = car.getDistance();
            if (distance == maxDistance)
                winners.add(car.getName());
        }

        return winners;
    }
}
