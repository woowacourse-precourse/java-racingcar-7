package racingcar.gameplayer.game.racinggame.domain.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.gameplayer.game.common.domain.PositiveNumber;
import racingcar.gameplayer.game.racinggame.app.dto.GameResult;

class CarsTest {

    Names names;
    Cars cars;

    @BeforeEach
    void before() {
        names = new Names("pobi,koo,jang");
        cars = new Cars(names);
    }

    @Test
    @DisplayName("이름 리스트 길이만큼의 Car객체가 생성된다")
    void createCarsWhenNamesGiven() throws NoSuchFieldException, IllegalAccessException {
        // given
        Class<?> carsClass = cars.getClass();
        Field carListField = carsClass.getDeclaredField("cars");
        carListField.setAccessible(true);

        // when
        List<Car> carList = (List<Car>) carListField.get(cars);

        // then
        assertThat(carList.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("proceedRound가 roundCount만큼 반복한다")
    void iterateProceedRoundAsRoundCountTimes() {
        // given
        int count = 3;
        PositiveNumber roundCount = new PositiveNumber(count);

        // when
        GameResult gameResult = cars.proceedRound(roundCount);

        // then
        assertThat(gameResult.results().size()).isEqualTo(count);
    }
}