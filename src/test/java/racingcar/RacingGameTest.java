package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(strings = {"자동차,레이싱카"})
    public void racingCarPreparation(String input) throws Exception {
        try {
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

    @Test
    public void printWinner() throws Exception {
        //given
        RacingCar 자동차 = new RacingCar("자동차");
        List<RacingCar> racingCarList = List.of(자동차);
        RacingCars racingCars = new RacingCars(racingCarList);
        RacingGame racingGame = new RacingGame(racingCars, 0);

        //when
        racingGame.printWinner();

        //then
    }

    @Test
    public void printWinners() throws Exception {
        //given
        RacingCar 자동차 = new RacingCar("자동차");
        RacingCar 레이싱카 = new RacingCar("레이싱카");
        List<RacingCar> racingCarList = List.of(자동차, 레이싱카);
        RacingCars racingCars = new RacingCars(racingCarList);
        RacingGame racingGame = new RacingGame(racingCars, 0);

        //when
        racingGame.printWinner();

        //then
    }

    private void command(final String... args) {
        final byte[] buf = String.join("\n", args).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

}