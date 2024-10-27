package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    public void setUp() {
        racingGame = new RacingGame("pobi,woni,jun", 5);
    }

    @Test
    @DisplayName("자동차 이름 문자열이 쉼표로 구분되어 리스트로 올바르게 생성되었는지 확인")
    public void initializeCarsTest() {
        List<Car> cars= racingGame.getCars();

        assertThat(cars).hasSize(3);    // pobi, woni, jun
        assertAll(
                () -> assertThat(cars.get(0).getName()).isEqualTo("pobi"),
                () -> assertThat(cars.get(1).getName()).isEqualTo("woni"),
                () -> assertThat(cars.get(2).getName()).isEqualTo("jun")
        );
    }

    @Test
    public void playRoundTest() {
        List<Car> cars = racingGame.getCars();

        racingGame.playRound();

        for (Car car : cars) {
            assertThat(car.getPosition()).isGreaterThanOrEqualTo(0);
        }
    }

    @Test
    public void getAllCarStatesTest() {
        List<String> states = racingGame.getAllCarStates();

        assertThat(states).isEqualTo(List.of("pobi : ", "woni : ", "jun : "));
    }

    @Test
    public void getWinnersTest() {
        racingGame.getCars().get(0).move(4);    // pobi
        racingGame.getCars().get(1).move(4);    // woni

        List<String> winners = racingGame.getWinners();

        assertThat(winners).isEqualTo(List.of("pobi", "woni"));
    }
}
