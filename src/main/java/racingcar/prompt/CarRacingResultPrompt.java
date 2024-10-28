package racingcar.prompt;

import java.util.Iterator;

public class CarRacingResultPrompt implements Prompt {

    @Override
    public void print(PromptModel promptModel) {
        Iterator<String> iterator = promptModel.get();

        System.out.print("\n실행 결과\n");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + "\n\n");
        }
    }
}
