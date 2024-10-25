package racingcar.model.dashboard;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.helper.CarsHelper;
import racingcar.model.car.Cars;

public class DashBoardTest {

    @Test
    @DisplayName("중간 결과 확인")
    void offerLapChart() {
        // given
        Cars mockCars = CarsHelper.mockWithoutWinner();
        DashBoard sut = DashBoard.from(mockCars);

        // when
        String actual = sut.offerLapChart();

        // then
        String expected = "a : \nb : --\nc : ---";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("우승자 없음")
    void noWinner() {
        // given
        Cars mockCars = CarsHelper.mockWithoutWinner();
        DashBoard sut = DashBoard.from(mockCars);

        // when
        String actual = sut.rankWinners();

        // then
        assertThat(actual.isBlank()).isTrue();
    }


    @Test
    @DisplayName("단독 우승자")
    void singleWinner() {
        // given
        Cars mockCars = CarsHelper.mockWithSingleWinner();
        DashBoard sut = DashBoard.from(mockCars);
        // when
        String actual = sut.rankWinners();
        // then
        assertThat(actual).isEqualTo("c");
    }

    @Test
    @DisplayName("단독 우승자")
    void multiWinner() {
        // given
        Cars mockCars = CarsHelper.mockWithMultiWinner();
        DashBoard sut = DashBoard.from(mockCars);
        // when
        String actual = sut.rankWinners();
        // then
        assertThat(actual).isEqualTo("b, c");
    }

}
