package racingcar.io;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.Car;
import racingcar.util.TestMoveStrategies.AlwaysMoveStrategy;

class OutputHandlerTest extends NsTest {

    private List<Car> cars;
    private OutputHandler outputHandler;

    @BeforeEach
    void setUp() {
        cars = List.of(
                new Car("pobi"),
                new Car("woni"),
                new Car("crong")
        );
        outputHandler = new OutputHandler();
    }

    @Test
    void 차수별_실행_결과를_출력한다() {
        cars.forEach(car -> car.move(new AlwaysMoveStrategy()));  // 한 번 이동시킴
        outputHandler.printTrialResult(cars);
        assertThat(output()).contains("pobi : -", "woni : -", "crong : -");
    }

    @Test
    void 단독_우승자를_출력한다() {
        // pobi를 두 번 이동시켜 우승자로 만듦
        cars.get(0).move(new AlwaysMoveStrategy());
        cars.get(0).move(new AlwaysMoveStrategy());
        cars.get(1).move(new AlwaysMoveStrategy());  // woni는 한 번만 이동
        cars.get(2).move(new AlwaysMoveStrategy());  // crong도 한 번만 이동

        outputHandler.printFinalWinner(List.of("pobi"));
        assertThat(output()).contains("최종 우승자 : pobi");
    }

    @Test
    void 공동_우승자를_출력한다() {
        // pobi와 woni가 같은 위치에서 우승
        cars.get(0).move(new AlwaysMoveStrategy());  // pobi 한 번 이동
        cars.get(1).move(new AlwaysMoveStrategy());  // woni도 한 번 이동
        // crong은 이동하지 않음

        outputHandler.printFinalWinner(List.of("pobi", "woni"));
        assertThat(output()).contains("최종 우승자 : pobi, woni");
    }

    @Override
    public void runMain() {}
}
