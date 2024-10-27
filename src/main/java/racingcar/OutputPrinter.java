package racingcar;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputPrinter {
    public void promptCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void promptAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
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
        System.out.print("-".repeat(length));
    }
}