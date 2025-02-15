package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {
    @Test
    void 라운드_테스트(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try{
            assertRandomNumberInRangeTest(
                    () -> {
                        RacingCarGame game = new RacingCarGame(Arrays.asList("faker", "keria"), 1);
                        game.round();
                        assertThat(outputStream.toString().trim()).contains("faker : -", "keria :");
                    }, 5, 3
            );
        }finally{
            System.setOut(originalOut);
        }
    }

    @Test
    void 우승자_고르기_테스트(){
        assertRandomNumberInRangeTest(
                ()->{
                    RacingCarGame game = new RacingCarGame(Arrays.asList("faker", "keria"), 1);
                    game.start();
                    assertThat(game.selectWinners().toString()).isEqualTo("[faker]");
                }, 5, 3
        );
    }
}
