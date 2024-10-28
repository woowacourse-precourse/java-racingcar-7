package racingcar;

import java.util.List;
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
        List<String> carRacingRecord = carRacing.race();
        promptModel.add(carRacingRecord);
        resultPrompt.print(promptModel);
    }
}
