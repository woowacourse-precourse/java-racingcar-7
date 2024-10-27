package racingcar.prompt;

import java.util.Optional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarRacingEnrollPromptTest extends PromptTest {

    @Test
    public void 사용자_입력_테스트() throws Exception {
        //Given
        CarRacingEnrollPrompt carRacingEnrollPrompt = new CarRacingEnrollPrompt();
        String input = "pobi,woni,jun\n5\n";
        setInput(input);
        String carNamesExpected = "pobi,woni,jun";
        String attemptsExpected = "5";

        //When
        Optional<PromptModel> optional = carRacingEnrollPrompt.print(null);

        //Then
        Assertions.assertThat(optional).isPresent();
        Assertions.assertThat(optional.get().get("carNames")).isEqualTo(carNamesExpected);
        Assertions.assertThat(optional.get().get("attempts")).isEqualTo(attemptsExpected);
    }

    @Test
    public void 빈_입력_테스트() throws Exception {
        //Given
        CarRacingEnrollPrompt carRacingEnrollPrompt = new CarRacingEnrollPrompt();
        String input = "";
        setInput(input);
        String carNamesExpected = "";
        String attemptsExpected = "";

        //When
        Optional<PromptModel> optional = carRacingEnrollPrompt.print(null);

        //Then
        Assertions.assertThat(optional).isPresent();
        Assertions.assertThat(optional.get().get("carNames")).isEqualTo(carNamesExpected);
        Assertions.assertThat(optional.get().get("attempts")).isEqualTo(attemptsExpected);
    }
}