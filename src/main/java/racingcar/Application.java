package racingcar;

import static racingcar.Parser.parseAttempts;
import static racingcar.Parser.parseCarNames;

import racingcar.prompt.CarRacingEnrollPrompt;
import racingcar.prompt.CarRacingResultPrompt;
import racingcar.prompt.Prompt;
import racingcar.prompt.PromptModel;

public class Application {

    public static void main(String[] args) {

        Prompt enrollPrompt = new CarRacingEnrollPrompt();
        Prompt resultPrompt = new CarRacingResultPrompt();
        PromptModel promptModel = new PromptModel();

        enrollPrompt.print(promptModel);

        CarRacing carRacing = new CarRacing(parseCarNames(promptModel.get("carNames")),
                parseAttempts(promptModel.get("attempts")));
        PromptModel result = carRacing.race();
        resultPrompt.print(result);
    }
}
