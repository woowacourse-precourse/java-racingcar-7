package racingcar.prompt;

import static racingcar.prompt.CarRacingEnrollPrompt.ATTEMPT_KEY;
import static racingcar.prompt.CarRacingEnrollPrompt.CAR_NAMES_KEY;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarRacingEnrollPromptTest extends PromptTest {

    @Test
    public void 사용자_입력_테스트() throws Exception {
        //Given
        CarRacingEnrollPrompt carRacingEnrollPrompt = new CarRacingEnrollPrompt();
        PromptModel promptModel = new PromptModel();
        String input = "pobi,woni,jun\n5\n";
        setInput(input);
        String carNamesExpected = "pobi,woni,jun";
        String attemptExpected = "5";

        //When
        carRacingEnrollPrompt.print(promptModel);

        //Then
        Assertions.assertThat(promptModel.get(CAR_NAMES_KEY)).isEqualTo(carNamesExpected);
        Assertions.assertThat(promptModel.get(ATTEMPT_KEY)).isEqualTo(attemptExpected);
    }

    @Test
    public void 빈_입력_테스트() throws Exception {
        //Given
        CarRacingEnrollPrompt carRacingEnrollPrompt = new CarRacingEnrollPrompt();
        PromptModel promptModel = new PromptModel();
        String input = "";
        setInput(input);
        String carNamesExpected = "";
        String attemptExpected = "";

        //When
        carRacingEnrollPrompt.print(promptModel);

        //Then
        Assertions.assertThat(promptModel.get(CAR_NAMES_KEY)).isEqualTo(carNamesExpected);
        Assertions.assertThat(promptModel.get(ATTEMPT_KEY)).isEqualTo(attemptExpected);
    }
}