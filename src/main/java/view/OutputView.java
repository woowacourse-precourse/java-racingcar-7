package view;

import domain.Car;
import java.util.List;

public class OutputView {
    private OutputView() {}

    public static void showRoundResult(List<Car> carsList) {
        carsList.forEach((car) -> {
            System.out.println(car.getName() + " : " + "-".repeat(car.getScore()));
        });
        System.out.println();
    }

    public static void showWinners(List<String> winners) {
        System.out.println(String.join(", ", winners));
    }
}
