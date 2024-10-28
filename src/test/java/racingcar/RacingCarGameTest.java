package racingcar;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class RacingCarGameTest {
    @Test
    void 라운드_테스트(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        try{
            camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest(
                    () -> {
                        RacingCarGame game = new RacingCarGame(Arrays.asList("faker", "keria"), 1);
                        game.round();
                        Assertions.assertThat(outputStream.toString().trim()).contains("faker : -", "keria :");
                    }, 5, 3
            );
        }finally{
            System.setOut(originalOut);
        }
    }
}
