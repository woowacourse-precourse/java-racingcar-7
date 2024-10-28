package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorMessage;
import racingcar.model.Cars;
import racingcar.model.Round;
import racingcar.utils.FixedRandomGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RoundTest {

    @DisplayName("자동차가 이동할 때 랜덤 값이 기준값 이상일 경우 이동한다.")
    @Test
    public void execute_CarShouldMove_WhenRandomValueIsGreaterThanThreshold() {
        Cars cars = new Cars("pobi,woni");
        FixedRandomGenerator fixedRandomGenerator = new FixedRandomGenerator(5);
        Round round = new Round(fixedRandomGenerator);

        round.execute(cars);

        // 최소 한 대의 자동차가 이동했을 것이라 가정
        assertThat(cars.getCars()).anyMatch(car -> car.getPosition() > 0);
    }

    @DisplayName("랜덤 값이 유효하지 않을 경우 예외가 발생한다.")
    @Test
    public void generateRandomValue_InvalidValue_ShouldThrowException() {
        FixedRandomGenerator fixedRandomGenerator = new FixedRandomGenerator(10);
        Round round = new Round(fixedRandomGenerator);

        assertThatThrownBy(() -> round.execute(new Cars("pobi,woni")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.RANDOM_VALUE_OUT_OF_BOUNDS.getMessage());
    }
}