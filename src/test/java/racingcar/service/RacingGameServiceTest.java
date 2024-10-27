package racingcar.service;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static racingcar.constant.ErrorMessages.CAR_NAME_DUPLICATE_ERROR_MESSAGE;

class RacingGameServiceTest {
    @Test
    public void 자동차를_생성한다(){
        final var racingGameService = new RacingGameService();
        String input = "pobi,woni,jun";
        List<Car> registeredCars = racingGameService.createCarsWithUniqueName(input);
        assertThat(registeredCars.size()).isEqualTo(3);
        assertThat(registeredCars.get(2).getName()).isEqualTo("jun");
    }

    @Test
    public void 자동차를_생성한다_중복된_이름인_경우(){
        final var racingGameService = new RacingGameService();
        String input = "pobi,woni,pobi";
        assertThatThrownBy(()->racingGameService.createCarsWithUniqueName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATE_ERROR_MESSAGE);
    }

}