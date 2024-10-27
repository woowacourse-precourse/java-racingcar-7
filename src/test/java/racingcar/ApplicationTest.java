package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.repository.CarRepository;
import racingcar.domain.repository.RaceRepository;

class ApplicationTest extends NsTest {

    private final CarRepository carRepository = CarRepository.getInstance();
    private final RaceRepository raceRepository = RaceRepository.getInstance();

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @BeforeEach
    void setUp() {
        carRepository.deleteAll();
        raceRepository.deleteAll();
    }

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "666666,1,22", "55555,,22",
            "55555, ,22", "55555,22,22"})
    void 자동차_이름_입력_포맷_예외_테스트(String carsName) {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException(carsName, "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"-1", "0", "", " "})
    void Lap_입력_포맷_예외_테스트(String lap) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc,zwd", lap))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
