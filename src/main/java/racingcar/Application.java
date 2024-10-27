package racingcar;

import racingcar.prompt.CarRacingEnrollPrompt;
import racingcar.prompt.CarRacingResultPrompt;
import racingcar.prompt.Prompt;
import racingcar.prompt.PromptModel;

public class Application {

    public static void main(String[] args) {

        Prompt enrollPrompt = new CarRacingEnrollPrompt();
        Prompt resultPrompt = new CarRacingResultPrompt();
        PromptModel promptModel = new PromptModel();
        CarRacingEnroll carRacingEnroll = new CarRacingEnroll();

        enrollPrompt.print(promptModel);

        CarRacing carRacing = carRacingEnroll.lineUp(promptModel);
        PromptModel result = carRacing.race();
        resultPrompt.print(result);
    }
}
