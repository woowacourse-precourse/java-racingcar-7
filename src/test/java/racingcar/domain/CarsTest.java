package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.TestConstants.CAR_MOVE_COUNT;
import static racingcar.TestConstants.CAR_MOVE_TWICE;
import static racingcar.TestConstants.CAR_NAME_JUN;
import static racingcar.TestConstants.CAR_NAME_POBI;
import static racingcar.TestConstants.CAR_NAME_WONI;
import static racingcar.TestConstants.ONLY_WINNER;
import static racingcar.TestConstants.POBI_CAR_INDEX;
import static racingcar.TestConstants.START_LOCATION;
import static racingcar.TestConstants.WINNER_COUNT;
import static racingcar.TestConstants.WONI_CAR_INDEX;
import static racingcar.common.Constants.MOVE;
import static racingcar.common.Constants.ROUND_RESULT_PROMPT;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
    @Test
    @DisplayName("자동차 이름들을 넣을 경우 자동차들이 잘 생성된다.")
    void createCars () {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add(CAR_NAME_POBI);
        carNames.add(CAR_NAME_WONI);
        carNames.add(CAR_NAME_JUN);

        // when
        Cars cars = new Cars(carNames);

        // then
        assertThat(cars.size()).isEqualTo(carNames.size());
    }

    @Test
    @DisplayName("움직이도록 요청한 차가 잘 움직인다.")
    void moveCar () {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add(CAR_NAME_POBI);
        carNames.add(CAR_NAME_WONI);
        carNames.add(CAR_NAME_JUN);

        Cars cars = new Cars(carNames);

        // when
        cars.carMove(POBI_CAR_INDEX);

        // then
        assertThat(cars.checkCarMove(POBI_CAR_INDEX, CAR_MOVE_COUNT)).isTrue();
    }

    @Test
    @DisplayName("움직이도록 요청하지 않은 차는 움직이지 않는다.")
    void dontMoveCar () {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add(CAR_NAME_POBI);
        carNames.add(CAR_NAME_WONI);
        carNames.add(CAR_NAME_JUN);

        Cars cars = new Cars(carNames);

        // when
        cars.carMove(POBI_CAR_INDEX);

        // then
        assertThat(cars.checkCarMove(WONI_CAR_INDEX, START_LOCATION)).isTrue();
    }

    @Test
    @DisplayName("라운드 결과를 가져오도록 요청한 차의 라운드 결과를 잘 가져온다.")
    void getRountResult () {
        // given
        List<String> carNames = List.of(CAR_NAME_POBI, CAR_NAME_WONI, CAR_NAME_JUN);
        Cars cars = new Cars(carNames);

        cars.carMove(WONI_CAR_INDEX);
        cars.carMove(WONI_CAR_INDEX);

        // when
        String roundResult = cars.getRoundResult(WONI_CAR_INDEX);

        // then
        String expectedResult = CAR_NAME_WONI + ROUND_RESULT_PROMPT + MOVE.repeat(CAR_MOVE_TWICE);
        assertThat(roundResult).isEqualTo(expectedResult);

    }

    @Test
    @DisplayName("경기의 우승자를 가져온다. (우승자가 1명인 경우)")
    void getWinner () {
        // given
        List<String> carNames = List.of(CAR_NAME_POBI, CAR_NAME_WONI, CAR_NAME_JUN);
        Cars cars = new Cars(carNames);

        cars.carMove(POBI_CAR_INDEX);
        cars.carMove(POBI_CAR_INDEX);

        // when
        Winners winners = cars.findWinners();

        // then
        assertThat(winners.size()).isEqualTo(ONLY_WINNER);
    }

    @Test
    @DisplayName("경기의 우승자를 가져온다. (우승자가 여러 명인 경우)")
    void getWinners () {
        // given
        List<String> carNames = List.of(CAR_NAME_POBI, CAR_NAME_WONI, CAR_NAME_JUN);
        Cars cars = new Cars(carNames);

        cars.carMove(POBI_CAR_INDEX);
        cars.carMove(WONI_CAR_INDEX);

        // when
        Winners winners = cars.findWinners();

        // then
        assertThat(winners.size()).isEqualTo(WINNER_COUNT);
    }
}