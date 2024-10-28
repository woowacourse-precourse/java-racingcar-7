package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class View {
    public String input() {
        return Console.readLine();
    }

    public String playerInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return input();
    }


    public String roundInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return input();
    }

    public void displayRoundStatus(List<String> roundStatus) {
        System.out.println("실행 결과");
        System.out.println(String.join("\n", roundStatus));
        System.out.println();
    }

    public void outputResult(List<String> result) {
        System.out.print("최종 우승자 : ");
        String resultString = String.join(", ", result);
        System.out.println(resultString);
    }
}
