package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class RaceView {
    public static void displayRaceStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
