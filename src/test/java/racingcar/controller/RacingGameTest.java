package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingGameTest extends NsTest {

    private final InputStream originalSystemIn = System.in;

    @AfterEach
    void restoreSystemInStream() {
        System.setIn(originalSystemIn);
        Console.close();
    }

    private void setInput(String input) {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        System.setIn(inputStream);
    }

    @DisplayName("레이싱 게임 실행 및 결과 테스트")
    @Test
    void exec() {
        // given
        String input = "car1,car2,car3\n4\n";
        setInput(input);

        // when
        assertRandomNumberInRangeTest(() -> {
                    RacingGame racingGame = new RacingGame();
                    racingGame.exec();
                },
                4, 1, 5, // 라운드 1: car1=4, car2=1, car3=5
                1, 2, 2, // 라운드 2: car1=1, car2=2, car3=2
                7, 9, 8, // 라운드 3: car1=7, car2=9, car3=8
                8, 4, 7); // 라운드 4: car1=8, car2=4, car3=7

        // then
        assertThat(output()).contains(
                "car1 : ---", "car2 : --", "car3 : ---",
                "최종 우승자 : car1, car3"
        );
    }

    @Override
    protected void runMain() {
    }
}
