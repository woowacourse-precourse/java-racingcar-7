package racingcar.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class MessageFormatterTest {

    @Test
    public void 우승자_이름_1명_출력_테스트() {
        List<String> winners = List.of("sean");

        assertThat(MessageFormatter.getWinnersName(winners))
                .isEqualTo("sean");
    }

    @Test
    public void 우승자_이름_여러명_출력_테스트() {
        List<String> winners = List.of("sean", "cool", "happy");

        assertThat(MessageFormatter.getWinnersName(winners))
                .isEqualTo("sean, cool, happy");
    }

    @Test
    public void 자동차_3번_이동_상태_출력() {
        assertThat(MessageFormatter.getCarInformation("sean", 3))
                .isEqualTo("sean : ---");
    }

    @Test
    public void 자동차_0번_이동_상태_출력() {
        assertThat(MessageFormatter.getCarInformation("sean", 0))
                .isEqualTo("sean : ");
    }
}