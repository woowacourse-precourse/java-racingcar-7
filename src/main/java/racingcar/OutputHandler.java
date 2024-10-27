package racingcar;

import java.util.ArrayList;
import java.util.List;

public class OutputHandler {
    public void printStartMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + generateHyphens(car.getPosition()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

    private String generateHyphens(int position) {
        StringBuilder hyphens = new StringBuilder();
        hyphens.append("-".repeat(position));
        return hyphens.toString();
    }
}
