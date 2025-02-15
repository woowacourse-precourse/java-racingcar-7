package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputView {
    private static final String WINNER_MESSAGE = "최종 우승자";

    private static String getDistanceVisual(int distance) {
        StringBuilder visual = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            visual.append("-");
        }
        return visual.toString();
    }

    public static void displayCarRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getDistanceVisual(car.getDistance()));
        }
        System.out.println();
    }

    public static void printWinnerMessage(List<Car> cars) {
        int maxDistance = 0;
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.getDistance() > maxDistance) {
                maxDistance = car.getDistance();
            }
        }

        for (Car car : cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car.getName());
            }
        }

        System.out.println(WINNER_MESSAGE + " : " + String.join(", ", winners));
    }
}
