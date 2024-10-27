package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import java.io.PrintStream;
import java.io.OutputStream;
import java.util.List;
import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

public class RaceGameTest {
    private StringBuffer output;

    @BeforeEach
    void setUp() {
        output = new StringBuffer();
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                output.append((char) b);
            }
        }));
    }

    @Test
    @DisplayName("우승자가 한 명일 경우 정확한 우승자 반환")
    void 기능_테스트1() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");

        RaceGame.printWinner(winners);
        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi");
    }

    @Test
    @DisplayName("공동 우승자가 있을 경우 모든 우승자 반환")
    void 기능_테스트2() {
        List<String> winners = new ArrayList<>();
        winners.add("pobi");
        winners.add("woni");

        RaceGame.printWinner(winners);
        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi, woni");
    }

    @Test
    @DisplayName("최대 거리 계산 테스트")
    void 기능_테스트3() {
        String[] carList = {"pobi", "woni", "jun"};
        int[] carIndex = {3, 2, 1};

        RaceGame.maxDistance(carIndex, carList);
        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi");
    }

    @Test
    @DisplayName("모든 자동차가 동일한 거리를 가질 때 모두 우승자로 선정")
    void 기능_테스트4() {
        String[] carList = {"pobi", "woni", "jun"};
        int[] carIndex = {2, 2, 2};

        RaceGame.maxDistance(carIndex, carList);
        assertThat(output.toString().trim()).isEqualTo("최종 우승자 : pobi, woni, jun");
    }
}