package racingcar.view;

import java.util.HashMap;
import java.util.List;

public class OutputView {

    public void printRequestName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRequestTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResultMessage() {
        System.out.println("실행 결과");
    }

    public void printRoundResult(HashMap<String, Integer> roundResult) {
        for (HashMap.Entry<String, Integer> entry : roundResult.entrySet()) {
            System.out.print(entry.getKey() + " : ");
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public void printWinner(List<String> winner) {
        String result = String.join(", ", winner);
        System.out.println("최종 우승자 = " + result);
    }
}
