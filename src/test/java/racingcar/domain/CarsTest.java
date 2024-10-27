package racingcar.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.strategy.AlwaysMoveStrategy;
import racingcar.domain.strategy.MoveStrategy;

public class CarsTest {

    private MoveStrategy moveStrategy;

    @BeforeEach
    void setUp() {
        this.moveStrategy = new AlwaysMoveStrategy();
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,jun"})
    void 자동차_생성_테스트(String carNames) {
        Cars cars = new Cars(carNames, moveStrategy);

        assertThat(cars).isInstanceOf(Cars.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi,woni,woni"})
    void 자동차_생성시_중복된_이름_입력_예외_테스트(String carNames) {
        assertThatThrownBy(() -> new Cars(carNames, moveStrategy))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("중복된 이름이 존재합니다.");
    }

}
