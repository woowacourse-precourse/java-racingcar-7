package racingcar.view;

import java.util.List;

public class RacingGameView {
    public void printCarNameInputPrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRoundCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRoundResult(List<String> carStates) {
        carStates.forEach(System.out::println);
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}