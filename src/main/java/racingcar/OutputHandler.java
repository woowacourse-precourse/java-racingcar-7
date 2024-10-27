package racingcar;

import java.util.List;

public class OutputHandler {

    public void showCarNamesInputComments() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showMoveCountInputComments() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
    }

    public void showCarProceedScore(User user, int proceedScore) {
        System.out.println(user.getName() + " : " + "-".repeat(proceedScore));
    }

    public void showNewLine() {
        System.out.println();
    }

    public void showWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }

    public void showCarProceedComments() {
        System.out.println("실행 결과");
    }
}
