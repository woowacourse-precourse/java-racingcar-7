package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Cars;
import racingcar.model.game.PositionBasedReferee;
import racingcar.model.game.Winners;

public class PositionBasedRefereeTest {

    private Cars cars;
    private String[] nameOfCars;
    private PositionBasedReferee positionBasedReferee;

    @BeforeEach
    void setUP() {
        nameOfCars = new String[]{"pobi", "jun"};
        cars = new Cars(nameOfCars);
        positionBasedReferee = new PositionBasedReferee();
    }

    @Test
    @DisplayName("가장 멀리 나간 자동차를 우승자로 반환한다.")
    void returnMaxPositionCarsAsWinners() {
        // given
        int indexOfWinner = 0;
        cars.move(indexOfWinner);
        cars.move(indexOfWinner);

        // when
        Winners winners = positionBasedReferee.judgeWinners(cars);
        List<String> namesOfWinner = winners.getNamesOfWinner();

        // then
        assertThat(namesOfWinner).isEqualTo(List.of(nameOfCars[indexOfWinner]));
    }
}
