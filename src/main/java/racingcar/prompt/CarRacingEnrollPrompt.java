package racingcar.prompt;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

public class CarRacingEnrollPrompt implements Prompt {

    private String readNonEmptyLine() {
        String input;
        try {
            input = Console.readLine();
        } catch (NoSuchElementException e) {
            input = "";
        }
        return input;
    }

    @Override
    public void print(PromptModel promptModel) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        promptModel.add("carNames", readNonEmptyLine());

        System.out.println("시도할 횟수는 몇 회인가요?");
        promptModel.add("attempts", readNonEmptyLine());

        Console.close();
    }
}
