package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.dto.CarDto;
import racingcar.dto.RacingGameDto;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingGameTest {
    private static final int MOVING_FORWARD = 4;
    private RacingGame racingGame;
    private RacingGameDto racingGameDto;

    @BeforeEach
    public void setUp() {
        racingGame = new RacingGame("pobi,woni,jun", 5);
        racingGameDto = racingGame.toRacingGameDto();
    }

    @Test
    @DisplayName("자동차 이름 문자열이 쉼표로 구분되어 리스트로 올바르게 생성되었는지 확인")
    public void initializeCarsTest() {
        List<CarDto> cars = racingGameDto.cars().stream()
                .map(Car::toCarDtO)
                .toList();

        assertThat(cars).hasSize(3);    // pobi, woni, jun
        assertAll(
                () -> assertThat(cars.get(0).name()).isEqualTo("pobi"),
                () -> assertThat(cars.get(1).name()).isEqualTo("woni"),
                () -> assertThat(cars.get(2).name()).isEqualTo("jun")
        );
    }

    @Test
    public void playRoundTest() {
        List<CarDto> cars = racingGameDto.cars().stream()
                .map(Car::toCarDtO)
                .toList();

        racingGame.playRound();

        for (CarDto car : cars) {
            assertThat(car.position()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    public void getAllCarStatesTest() {
        List<String> states = racingGame.getAllCarStates();

        assertThat(states).isEqualTo(List.of("pobi : ", "woni : ", "jun : "));
    }

    @Test
    public void getWinnersTest() {
        racingGameDto.cars().get(0).move(MOVING_FORWARD);    // pobi
        racingGameDto.cars().get(1).move(MOVING_FORWARD);    // woni

        List<String> winners = racingGame.getWinners();

        assertThat(winners).isEqualTo(List.of("pobi", "woni"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"t,t", "pobi,pobi", "ab,th,ab"})
    void checkDuplicateTest(String carNames) {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new RacingGame(carNames, 2))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {",", ",,,", "pobi,"})
    void validateFormatTest(String carNames) {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> new RacingGame(carNames, 2))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }
}
