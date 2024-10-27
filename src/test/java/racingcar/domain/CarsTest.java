package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.validator.AttemptCountValidator;

public class CarsTest {

    @Test
    @DisplayName("자동차들 중 우승자를 반환시켜준다.")
    void findWinners_Success() {
        // given
        Car kia = new Car("Kia");
        kia.increaseDistance();
        kia.increaseDistance();

        Car hyun = new Car("Hyun");
        hyun.increaseDistance();

        Cars cars = new Cars(List.of(kia, hyun));

        // when
        List<Car> result = cars.findWinners();

        // then
        assertThat(result).extracting("name").contains(kia.getName());
    }
}
