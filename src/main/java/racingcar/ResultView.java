package racingcar;

import java.util.List;

public class ResultView {

    public void printStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printCarPosition(Car car) {
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        String winnerString = String.join(", ", winners);
        System.out.println("최종 우승자 : " + winnerString);
    }
}
