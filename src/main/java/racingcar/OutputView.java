package racingcar;

import java.util.List;

public class OutputView {
    void resultMessageLoop(List<RacingCar> racingCars) {
        for (RacingCar racingCar : racingCars) {
            printResultMessage(racingCar.getName(), racingCar.getScore());
        }
        System.out.println();
    }

    void printResultMessage(String name, Integer number) {
        System.out.print(name + " " + ":" + " ");
        for (int i = 0; i < number; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    void printWinnerMessage(List<String> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            if (i == winners.size() - 1) {
                System.out.print(winners.get(i));
                break;
            }
            System.out.print(winners.get(i) + ", ");
        }
    }
}