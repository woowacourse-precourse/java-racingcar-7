package racingcar.application.in;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.config.ApplicationContext;
import racingcar.domain.Car;
import racingcar.domain.Racing;

class RacingCarUseCaseTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final RacingCarUseCase racingCarUseCase;

    public RacingCarUseCaseTest() {
        ApplicationContext context = ApplicationContext.getInstance(Application.class);

        racingCarUseCase = context.getBean(RacingCarUseCase.class);
    }

    @Test
    void 한_명의_우승자가_나올_수_있다() {
        assertRandomNumberInRangeTest(
                () -> {
                    // Given
                    List<Car> cars = List.of(
                            Car.of("pobi"),
                            Car.of("woni"),
                            Car.of("jun")
                    );
                    int tryCount = 5;

                    // When
                    Racing res = racingCarUseCase.startRacing(cars, tryCount);

                    // Then
                    assertThat(res).isNotNull();
                    assertThat(res.getWinners())
                            .hasSize(1)
                            .containsExactly(cars.get(0));
                },
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP,
                MOVING_FORWARD, STOP, STOP
        );
    }

    @Test
    void 여러_명의_우승자가_나올_수_있다() {
        assertRandomNumberInRangeTest(
                () -> {
                    // Given
                    List<Car> cars = List.of(
                            Car.of("pobi"),
                            Car.of("woni"),
                            Car.of("jun")
                    );
                    int tryCount = 5;

                    // When
                    Racing res = racingCarUseCase.startRacing(cars, tryCount);

                    // Then
                    assertThat(res).isNotNull();
                    assertThat(res.getWinners())
                            .hasSize(2)
                            .containsExactly(cars.get(0), cars.get(1));
                },
                STOP, MOVING_FORWARD, STOP,
                MOVING_FORWARD, STOP, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD,
                MOVING_FORWARD, MOVING_FORWARD, STOP
        );
    }

    @Test
    void 시도_횟수가_0인_경우_모두_우승자이다() {
        // Given
        List<Car> cars = List.of(
                Car.of("pobi"),
                Car.of("woni"),
                Car.of("jun")
        );
        int tryCount = 0;

        // When
        Racing res = racingCarUseCase.startRacing(cars, tryCount);

        // Then
        assertThat(res).isNotNull();
        assertThat(res.getWinners())
                .hasSize(3)
                .containsExactly(cars.get(0), cars.get(1), cars.get(2));
    }

    @Test
    void 자동차_이름이_6자_이상인_경우_실패한다() {
        // Given
        String carName = "name_is_longer_than_6";

        // When
        ThrowingCallable throwing = () -> Car.of(carName);

        // Then
        assertThatThrownBy(throwing)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차_이름이_입력되지_않은_경우_실패한다() {
        // Given
        String carName = "";

        // When
        ThrowingCallable throwing = () -> Car.of(carName);

        // Then
        assertThatThrownBy(throwing)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 시도_횟수가_음수인_경우_실패한다() {
        // Given
        List<Car> cars = List.of(
                Car.of("pobi"),
                Car.of("woni"),
                Car.of("jun")
        );
        int tryCount = 0;

        // When
        ThrowingCallable throwing = () -> racingCarUseCase.startRacing(cars, tryCount);

        // Then
        assertThatThrownBy(throwing)
                .isInstanceOf(IllegalArgumentException.class);
    }
}