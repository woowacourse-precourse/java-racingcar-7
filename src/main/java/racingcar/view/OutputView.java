package racingcar.view;

import java.util.List;

public class OutputView {

    public void printCarNamesPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printAttemptCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

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
