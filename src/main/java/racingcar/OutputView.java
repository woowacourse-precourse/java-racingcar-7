package racingcar;

import java.util.List;

public class OutputView {
    public OutputView() {
        System.out.println("\n실행 결과");
    }

    public void printRoundStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getForwardCount()));
        }
        System.out.println();
    }

    public void printFinalWinners(List<Car> cars) {
        StringBuilder finalWinners = new StringBuilder();
        for (Car car : cars) {
            finalWinners.append(car.getName()).append(", ");
        }
        System.out.println("최종 우승자 : " + finalWinners.substring(0, finalWinners.length() - 2));
    }
}
