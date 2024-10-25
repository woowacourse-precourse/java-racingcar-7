package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class View {

    public String readInput() {
        return Console.readLine();
    }

    public void printCarNamePrompt() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountPrompt() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResultPrompt() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printStatus(Map<String, StringBuilder> roundResult) {
        for (String carName : roundResult.keySet()) {
            System.out.println(carName + " : " + roundResult.get(carName));
        }
    }

    public void printWinners(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
