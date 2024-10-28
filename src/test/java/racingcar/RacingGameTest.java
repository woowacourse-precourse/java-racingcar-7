package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"자동차,레이싱카"})
    public void racingCarPreparation(String input) throws Exception {
        try{
            //given
            command(input);
            RacingGame racingGame = new RacingGame();

            //when
            racingGame.racingCarPreparation();

            //then
        } finally {
            Console.close();
        }
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}