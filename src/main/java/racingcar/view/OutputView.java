package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder output = new StringBuilder(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                output.append('-');
            }
            System.out.println(output);
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        StringBuilder winnerNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            winnerNames.append(winners.get(i).getName());
            if (i < winners.size() - 1) {
                winnerNames.append(", ");
            }
        }
        System.out.println("최종 우승자 : " + winnerNames);
    }
}
