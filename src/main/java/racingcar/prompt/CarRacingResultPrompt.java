package racingcar.prompt;

import java.util.Iterator;

public class CarRacingResultPrompt implements Prompt {

    @Override
    public void print(PromptModel promptModel) {
        Iterator<String> iterator = promptModel.get();

        System.out.println("\n실행 결과");
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + "\n");
        }
    }
}
