package racingcar;

import racingcar.enums.PrintText;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputPrinter {
    public void promptCarNames() {
        System.out.println(PrintText.CAR_NAME_PROMPT.getPrint());
    }

    public void promptAttemptCount() {
        System.out.println(PrintText.ATTEMPT_COUNT_PROMPT.getPrint());
    }

    public void showRace(LinkedHashMap<Car, Integer> cars) {
        cars.forEach(this::printProgress);
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));
            if (winners.size() > i + 1) {
                System.out.print(", ");
            }
        }
    }

    private void printProgress(Car car, Integer progress) {
        System.out.print(car.getCarName() + " : ");
        printProgressBars(progress);
        System.out.println();
    }

    private void printProgressBars(int length) {
        System.out.print(PrintText.MOVE_SYMBOL.getPrint().repeat(length));
    }
}