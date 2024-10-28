package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.io.OutputHandler;
import racingcar.util.TestMoveStrategies.AlwaysMoveStrategy;

class RaceTest extends NsTest {

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
    void 시도_횟수만큼_자동차가_이동한다() {
        int trialCount = 3;
        MoveStrategy moveStrategy = new AlwaysMoveStrategy();
        Race race = new Race(cars, trialCount, moveStrategy, outputHandler);

        race.startRace();

        // 각 자동차가 trialCount(3) 만큼 이동했는지 확인
        cars.forEach(car -> assertThat(car.getPosition()).isEqualTo(trialCount));
    }

    @Override
    public void runMain() {}
}
