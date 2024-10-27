package racingcar.server.model.dashboard;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.server.helper.CarsHelper.mocNoWinner;
import static racingcar.server.helper.CarsHelper.mockMultiWinners;
import static racingcar.server.helper.CarsHelper.mockSingleWinner;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.app.server.model.car.Cars;
import racingcar.app.server.model.dashboard.DashBoard;

public class DashBoardTest {

    @Test
    @DisplayName("우승자 없음")
    void noWinner() {
        // given
        Cars mockCars = mocNoWinner();
        DashBoard sut = DashBoard.from(mockCars);

        // when
        List<String> actual = sut.offerLWinners();

        // then
        assertThat(actual.isEmpty()).isTrue();
    }


    @Test
    @DisplayName("단독 우승자 : Ruby")
    void singleWinner() {
        // given
        Cars mockCars = mockSingleWinner();
        DashBoard sut = DashBoard.from(mockCars);

        // when
        List<String> actual = sut.offerLWinners();

        // then
        assertThat(actual).contains("Ruby");
    }

    @Test
    @DisplayName("공동 우승자 : Rust, Ruby")
    void multiWinner() {
        // given
        Cars mockCars = mockMultiWinners();
        DashBoard sut = DashBoard.from(mockCars);

        // when
        List<String> actual = sut.offerLWinners();

        // then
        assertThat(actual).contains("Rust", "Ruby");
    }

}
