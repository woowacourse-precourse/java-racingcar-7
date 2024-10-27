package racingcar.prompt;

import java.util.Optional;

public interface Prompt {

    Optional<PromptModel> print(PromptModel writeModel);
}
