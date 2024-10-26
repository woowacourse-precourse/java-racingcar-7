package racingcar.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private RacingGame racingGame;

    @BeforeEach
    public void setUp() {
        //given
        racingGame = new RacingGame(List.of("pobi", "woni", "jun"));
    }

    @DisplayName("자동차 리스트 초기화 테스트")
    @Test
    public void testCarListInit() {
        //when
        List<Car> cars = racingGame.getCars();
        //then
        assertThat(cars).hasSize(3);
        assertThat(cars.get(0).getName()).isEqualTo("pobi");
        assertThat(cars.get(1).getName()).isEqualTo("woni");
        assertThat(cars.get(2).getName()).isEqualTo("jun");
    }
}
