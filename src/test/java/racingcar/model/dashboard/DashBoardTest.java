package racingcar.model.dashboard;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.helper.CarsHelper.mocNoWinner;
import static racingcar.helper.CarsHelper.mockMultiWinners;
import static racingcar.helper.CarsHelper.mockSingleWinner;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Cars;

public class DashBoardTest {

    @Test
    @DisplayName("우승자 없음")
    void noWinner() {
        // given
        Cars mockCars = mocNoWinner();
        DashBoard sut = DashBoard.from(mockCars);

        // when
        String actual = sut.offerLWinners();

        // then
        assertThat(actual.isBlank()).isTrue();
    }


    @Test
    @DisplayName("단독 우승자 : Ruby")
    void singleWinner() {
        // given
        Cars mockCars = mockSingleWinner();
        DashBoard sut = DashBoard.from(mockCars);

        // when
        String actual = sut.offerLWinners();

        // then
        assertThat(actual).isEqualTo("Ruby");
    }

    @Test
    @DisplayName("공동 우승자 : Rust, Ruby")
    void multiWinner() {
        // given
        Cars mockCars = mockMultiWinners();
        DashBoard sut = DashBoard.from(mockCars);

        // when
        String actual = sut.offerLWinners();

        // then
        assertThat(actual).isEqualTo("Rust, Ruby");
    }

}
