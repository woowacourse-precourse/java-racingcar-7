package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.car.CarImpl;
import racingcar.car.ICar;
import racingcar.display.IOutputDisplay;
import racingcar.display.OutputDisplayImpl;

public class CarRacingGameTests {

    @Test
    public void checkWinnerList() {
        // given
        IOutputDisplay outputDisplay = new OutputDisplayImpl();
        List<ICar> carList = new ArrayList<>();
        int round = 10;
        for (int i = 0; i < 4; i++) {
            carList.add(
                    new CarImpl("car" + i)
            );
        }

        CarRacingGame carRacingGame = new CarRacingGame(outputDisplay, carList, round);

        // when
        List<ICar> winnerList = carRacingGame.start();

        // then
        ICar randomWinner = winnerList.getFirst();
        // 우승자의 위치가 모두 같은지 확인
        for (ICar car : winnerList) {
            assertThat(car.getPosition())
                    .isEqualTo(randomWinner.getPosition());
        }

        // 우승자를 제외한 모든 자동차가 우승자보다 뒤에 있는지 확인
        for (ICar car : carList) {
            if (winnerList.contains(car)) {
                continue;
            }

            assertThat(car.getPosition())
                    .isLessThan(randomWinner.getPosition());
        }
    }

    @Test
    public void error_alreadyGameDone() {
        // given
        IOutputDisplay outputDisplay = new OutputDisplayImpl();
        List<ICar> carList = new ArrayList<>();
        int round = 10;
        for (int i = 0; i < 4; i++) {
            carList.add(
                    new CarImpl("car" + i)
            );
        }

        CarRacingGame carRacingGame = new CarRacingGame(outputDisplay, carList, round);

        // when
        carRacingGame.start();

        Throwable throwable = catchThrowable(carRacingGame::start);

        // then
        assertThat(throwable)
                .hasMessageContaining(ErrorMessage.ALREADY_GAME_DONE.getMessage());
    }
}
