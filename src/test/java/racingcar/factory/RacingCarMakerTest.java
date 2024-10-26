package racingcar.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.component.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarMakerTest {

    private RacingCarMaker racingCarMaker;

    @BeforeEach
    void setUp() {
        racingCarMaker = new RacingCarMaker();
    }

    @Test
    @DisplayName("5글자 초과 이름은 예외를 던진다.")
    public void throwExceptionWithNameOver5Length() {
        String name = "123456";
        assertThatThrownBy(() -> racingCarMaker.make(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("5글자 이하 이름으로 자동차를 만든다.")
    public void makeRacingCarWithName5OrBelowLength() {
        String name = "12345";
        RacingCar actualCar = racingCarMaker.make(name);
        RacingCar expectedCar = new RacingCar(name);
        assertThat(actualCar).usingRecursiveComparison()
                .comparingOnlyFields("name")
                .isEqualTo(expectedCar);

    }

}
