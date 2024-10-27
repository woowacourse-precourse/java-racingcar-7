package racingcar.view;

import java.util.List;

public class OutputView {

    public void printCarDistances(List<String> carNames, List<Integer> distances) {
        for (int i = 0; i < carNames.size(); i++) {
            System.out.print(carNames.get(i) + " : ");
            System.out.println("-".repeat(distances.get(i)));
        }
        System.out.println();
    }

    public void printRacingResult() {
        System.out.println();
        System.out.println("실행결과");
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
