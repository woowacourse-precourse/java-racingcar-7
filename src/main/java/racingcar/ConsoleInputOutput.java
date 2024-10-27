package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class ConsoleInputOutput {

    public List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        return Arrays.asList(userInput.split(","));
    }

    public int getIteration() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String iterationInput = Console.readLine();
        try {
            return Integer.parseInt(iterationInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시행 횟수는 숫자만 입력할 수 있습니다.");
        }
    }
}
