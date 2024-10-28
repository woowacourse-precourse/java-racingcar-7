package racingcar.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.generator.Generator;
import racingcar.model.Car;
import racingcar.model.CarNames;
import racingcar.model.Cars;
import racingcar.strategy.MoveStrategy;

// 테스트용 난수 생성기: 고정된 값 제공
class FixedGenerator implements Generator<Integer> {
    private final int fixedValue;

    public FixedGenerator(int fixedValue) {
        this.fixedValue = fixedValue;
    }

    @Override
    public Integer generate() {
        return fixedValue;
    }
}

// 이동 전략: 숫자가 4 이상일 때만 이동 가능
class ThresholdMoveStrategy implements MoveStrategy {
    private final int threshold;

    public ThresholdMoveStrategy(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public boolean canMove(int number) {
        return number >= threshold;
    }
}

class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void setUp() {
        // 기본적으로 이동 불가능 조건을 적용하여 초기화
        MoveStrategy moveStrategy = new ThresholdMoveStrategy(4);
        Generator<Integer> generator = new FixedGenerator(0);
        racingService = new RacingService(moveStrategy, generator);
    }

    @Test
    void 자동차_초기화_테스트() {
        CarNames carNames = new CarNames(Arrays.asList("car1", "car2"));
        Cars cars = racingService.initializeCars(carNames);

        assertThat(cars.getCars()).hasSize(2);
        assertThat(cars.getCars().get(0).getName()).isEqualTo("car1");
        assertThat(cars.getCars().get(1).getName()).isEqualTo("car2");
    }

    @Test
    void 라운드_실행_이동_테스트() {
        CarNames carNames = new CarNames(Arrays.asList("car1", "car2"));
        Cars cars = racingService.initializeCars(carNames);

        // 난수 4로 고정하여 이동 조건을 충족하도록 설정
        racingService = new RacingService(new ThresholdMoveStrategy(4), new FixedGenerator(4));
        racingService.playRound(cars);

        // 각 자동차가 이동했는지 확인
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Test
    void 라운드_실행_미이동_테스트() {
        CarNames carNames = new CarNames(Arrays.asList("car1", "car2"));
        Cars cars = racingService.initializeCars(carNames);

        // 난수 3으로 고정하여 이동 조건을 충족하지 않도록 설정
        racingService = new RacingService(new ThresholdMoveStrategy(4), new FixedGenerator(3));
        racingService.playRound(cars);

        // 각 자동차가 이동하지 않았는지 확인
        for (Car car : cars.getCars()) {
            assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
