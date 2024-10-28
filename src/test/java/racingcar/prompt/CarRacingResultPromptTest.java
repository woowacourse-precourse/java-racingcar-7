package racingcar.prompt;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CarRacingResultPromptTest extends PromptTest {

    @Test
    public void PromptModel_출력_테스트() throws Exception {
        //Given
        PromptModel promptModel = new PromptModel();
        String testLine = "출력할 테스트 문구";
        promptModel.add(testLine);
        String expected = String.format("\n실행 결과\n%s\n\n", testLine);

        //When
        CarRacingResultPrompt carRacingResultPrompt = new CarRacingResultPrompt();
        carRacingResultPrompt.print(promptModel);

        //Then
        Assertions.assertThat(getOutput()).isEqualTo(expected);
    }
}