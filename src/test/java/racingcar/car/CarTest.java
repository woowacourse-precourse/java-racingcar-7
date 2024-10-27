package racingcar.car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.name.Name;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car(new Name("a"));
    }

    @DisplayName("랜덤 값의 수가 4 이상일 경우, 1칸 앞으로 이동한다.")
    @Test
    void Given_RandomNumOverFour_Then_GoForward() {
        // Given
        int initStatus = car.getStatus();

        // When
        car.move(4);

        // Then
        assertThat(car.getStatus()).isEqualTo(initStatus + 1);
    }

    @DisplayName("랜덤 값의 수가 3 이하일 경우, 이동하지 않는다.")
    @Test
    void Given_RandomNumUnderThree_Then_Stop() {
        // Given
        int initStatus = car.getStatus();

        // When
        car.move(3);

        // Then
        assertThat(car.getStatus()).isEqualTo(initStatus);
    }

    @DisplayName("얼마나 이동했는지를 나타내는 `-`표시가 올바르게 출력되는지 확인한다.")
    @Test
    void Given_RandomNumberOverFour_When_NumIsFourTwice_Then_PrintTwice() {
        car.move(4);
        assertThat(car.getRaceStatus()).isEqualTo("a : -");
        car.move(4);
        assertThat(car.getRaceStatus()).isEqualTo("a : --");
    }

    @DisplayName("얼마나 이동했는지를 나타내는 `-`표시가 올바르게 출력되는지 확인한다.")
    @Test
    void Given_RandomNumberOverFourUnderThree_When_NumIsCorrect_Then_PrintOne() {
        car.move(4);
        assertThat(car.getRaceStatus()).isEqualTo("a : -");
        car.move(3);
        assertThat(car.getRaceStatus()).isEqualTo("a : -");
    }
}