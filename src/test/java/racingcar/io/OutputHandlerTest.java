package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.util.TestMoveStrategies.AlwaysMoveStrategy;

class OutputHandlerTest extends NsTest {

    private OutputHandler outputHandler;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        outputHandler = new OutputHandler();
        cars = List.of(
                new Car("pobi", new AlwaysMoveStrategy()),
                new Car("woni", new AlwaysMoveStrategy()),
                new Car("crong", new AlwaysMoveStrategy())
        );
    }

    @Test
    void 차수별_실행_결과를_출력한다() {
        cars.forEach(Car::move);  // 한 번 이동시킴
        outputHandler.printTrialResult(cars);
        assertThat(output()).contains("pobi : -", "woni : -", "crong : -");
    }

    @Override
    public void runMain() {}
}
