package racingcar.prompt;

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
        String attemptsExpected = "5";

        //When
        carRacingEnrollPrompt.print(promptModel);

        //Then
        Assertions.assertThat(promptModel.get("carNames")).isEqualTo(carNamesExpected);
        Assertions.assertThat(promptModel.get("attempts")).isEqualTo(attemptsExpected);
    }

    @Test
    public void 빈_입력_테스트() throws Exception {
        //Given
        CarRacingEnrollPrompt carRacingEnrollPrompt = new CarRacingEnrollPrompt();
        PromptModel promptModel = new PromptModel();
        String input = "";
        setInput(input);
        String carNamesExpected = "";
        String attemptsExpected = "";

        //When
        carRacingEnrollPrompt.print(promptModel);

        //Then
        Assertions.assertThat(promptModel.get("carNames")).isEqualTo(carNamesExpected);
        Assertions.assertThat(promptModel.get("attempts")).isEqualTo(attemptsExpected);
    }
}