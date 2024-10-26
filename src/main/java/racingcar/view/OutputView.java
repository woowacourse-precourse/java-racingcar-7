package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class OutputView {

    public void printRace(List<Car> carReportCards) {
        int tryTimes = carReportCards.getFirst().getReportCard().size();
        for (int i = 0; i < tryTimes; i++) {
            printEachRound(carReportCards, i);
            System.out.println();
        }
    }

    private void printEachRound(List<Car> carReportCards, int round) {
        for (Car car : carReportCards) {
            System.out.print(car.getName() + " : ");
            printProgress(car.getReportCard(), round);
            System.out.println();
        }
    }

    private void printProgress(List<Boolean> reportCard, int currentRound) {
        for (int i = 0; i <= currentRound; i++) {
            if (reportCard.get(i)) {
                System.out.print("-");
            }
        }
    }

    public List<String> calculateWinners(List<Car> carReportCards) {
        List<String> winners = new ArrayList<>();
        int maxMovementCount = -1;

        for (Car car : carReportCards) {
            int movementCount = calculateMovementCount(car.getReportCard());

            if (movementCount > maxMovementCount) {
                maxMovementCount = movementCount;
                winners.clear();
                winners.add(car.getName());
            } else if (movementCount == maxMovementCount) {
                winners.add(car.getName());
            }
        }

        return winners;
    }

    private int calculateMovementCount(List<Boolean> reportCard) {
        int movementCount = 0;
        for (boolean result : reportCard) {
            if (result) {
                movementCount++;
            }
        }
        return movementCount;
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }
}
