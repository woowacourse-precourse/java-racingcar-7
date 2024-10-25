package racingcar.view;

import java.util.List;

public class OutputView {

    public void printGetCarsNameGuide() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,)로 구분)");
    }

    public void printGetAttemptCountGuide() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winners));
    }
}
