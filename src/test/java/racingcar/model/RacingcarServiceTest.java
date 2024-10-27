package racingcar.model;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("레이싱카 서비스 테스트")
class RacingcarServiceTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    RacingcarService racingcarService = RacingcarService.getInstance();
    Map<String, String> player = new LinkedHashMap<>();

    @BeforeEach
    public void beforeEach() {
        System.setOut(new PrintStream(outContent));
        player.clear();
    }

    @Test
    @DisplayName("라운드 별 결과 출력")
    void testPrintRoundResult() {
        String expectedOutput = "test1 : -\ntest2 : --\ntest3 : ---\n\n";
        player.put("test1", "-");
        player.put("test2", "--");
        player.put("test3", "---");
        racingcarService.printRoundResult(player);
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
    }

    @Test
    @DisplayName("최대 전진 크기 구하기")
    void testGetMaxDashLength() {
        player.put("test1", "-----");
        player.put("test2", "-");
        player.put("test3", "--");
        assertThat(racingcarService.getMaxDashLength(player)).isEqualTo(5);
    }

    @Nested
    @DisplayName("우승자 뽑기")
    class pickWinner {
        @Test
        @DisplayName("단일 우승자 뽑기")
        void testPickSingleWinner() {
            player.put("test1", "-----");
            player.put("test2", "-");
            player.put("test3", "--");
            List<String> winner = List.of("test1");
            assertThat(racingcarService.pickWinner(player,5)).isEqualTo(winner);
        }

        @Test
        @DisplayName("복수 우승자 뽑기")
        void testPickMultiWinner() {
            player.put("test1", "-----");
            player.put("test2", "-");
            player.put("test3", "-----");
            List<String> winner = List.of("test1","test3");
            assertThat(racingcarService.pickWinner(player,5)).isEqualTo(winner);
        }
    }

}