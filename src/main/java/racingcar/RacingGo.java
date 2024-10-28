package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGo {
    private List<Car> cars;
    private int moveCount;

    public RacingGo(List<String> carNames, int moveCount) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
        this.moveCount = moveCount;
    }

    public void play() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < moveCount; i++) {
            for (Car car : cars) {
                car.move();
                System.out.println(car);
            }
            System.out.println();
        }
        announceWinners();
    }

    private void announceWinners() {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }


}
