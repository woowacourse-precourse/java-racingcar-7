package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.accelerator.Accelerator;
import racingcar.accelerator.BrokenAccelerator;

class CarRacingTest {

    private final Accelerator accelerator = new BrokenAccelerator();

    private Car createCar(String carName) {
        return new Car(carName);
    }

    @Test
    public void 시도횟수_테스트() throws Exception {
        //Given
        String attempts = "5";
        int expected = 5;

        //When
        int actual = CarRacing.parseAttempts(attempts);

        //Then
        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 시도횟수_int범위초과_예외테스트() throws Exception {
        //Given
        String attempts = Long.toString(Long.MAX_VALUE);

        //When, Then
        Assertions.assertThatThrownBy(() -> CarRacing.parseAttempts(attempts))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 시도횟수_음수_예외테스트() throws Exception {
        //Given
        String attempts = "-1";

        //When, Then
        Assertions.assertThatThrownBy(() -> CarRacing.parseAttempts(attempts))
                .isInstanceOf(IllegalArgumentException.class);
    }
}