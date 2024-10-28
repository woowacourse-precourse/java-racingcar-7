package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.service.RaceService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GenerateResultsMessageTest {
    private OutputView outputView = new OutputView();

    @Test
    @DisplayName("최종 우승자 메시지를 생성하는 메서드")
    void generateResultsMessage() {
        List<String> winnerNames = Arrays.asList("pobi", "jun");
        String expectedMessage = "최종 우승자 : pobi, jun";

        String actualMessage = outputView.generateResultMessage(winnerNames);

        assertEquals(expectedMessage, actualMessage, "생성된 메시지가 예상과 다릅니다.");
    }
}
