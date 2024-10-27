package racingcar.prompt;

import java.util.Iterator;
import java.util.Optional;

public class CarRacingResultPrompt implements Prompt {

    @Override
    public Optional<PromptModel> print(PromptModel writeModel) {
        Iterator<String> iterator = writeModel.get();

        System.out.println("\n실행 결과");
        while (iterator.hasNext()) {
            System.out.println(iterator.next() + "\n");
        }

        return Optional.empty();
    }
}
