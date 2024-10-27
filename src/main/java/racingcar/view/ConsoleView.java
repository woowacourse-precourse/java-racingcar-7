package racingcar.view;

import java.util.List;

public class ConsoleView {
    public void printCarInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printIterationInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void displayResult() {
        System.out.println("실행 결과");
    }

    public void printRaceDetails(String name, Integer moveCount) {
        System.out.println(name + " : " + "-".repeat(moveCount));
    }

    public void printRaceWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.print(String.join(", ", winners));
    }
}
