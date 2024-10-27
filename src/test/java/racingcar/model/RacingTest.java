package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingTest {

    private Racing racing;

    @BeforeEach
    public void setUp() {
        String[] cars = {"pobi", "woni", "jun"};
        racing = new Racing(cars, 5);
    }

    @Test
    @DisplayName("Car 초기화")
    public void InitTest() {
        Assertions.assertThat(racing.getWinners()).isNotNull();
    }

    @Test
    @DisplayName("우승자 유무")
    public void getWinnersTest() {
        racing.start();
        String winners = racing.getWinners();
        Assertions.assertThat(winners).isNotEmpty();
    }
}