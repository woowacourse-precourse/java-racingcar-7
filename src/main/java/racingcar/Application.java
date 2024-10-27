package racingcar;

import static racingcar.Parser.parseAttempts;
import static racingcar.Parser.parseCarNames;

import java.util.Optional;
import racingcar.prompt.CarRacingEnrollPrompt;
import racingcar.prompt.CarRacingResultPrompt;
import racingcar.prompt.Prompt;
import racingcar.prompt.PromptModel;

public class Application {

    public static void main(String[] args) {

        Prompt enrollPrompt = new CarRacingEnrollPrompt();
        Prompt resultPrompt = new CarRacingResultPrompt();

        Optional<PromptModel> enrollWrapper = enrollPrompt.print(null);
        PromptModel enroll = null;
        if (enrollWrapper.isPresent()) {
            enroll = enrollWrapper.get();
        }

        CarRacing carRacing = new CarRacing(parseCarNames(enroll.get("carNames")),
                parseAttempts(enroll.get("attempts")));
        PromptModel result = carRacing.race();
        resultPrompt.print(result);
    }
}
