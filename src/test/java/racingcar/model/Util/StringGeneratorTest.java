package racingcar.model.Util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car.Car;

import java.util.List;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class StringGeneratorTest {

    private StringGenerator stringGenerator;

    @BeforeEach
    void setUp() {
        stringGenerator = new StringGenerator();
    }

    @Test
    void 자동차_이동_결과_생성_테스트() {
        List<Car> cars = Arrays.asList(
                new MockCar("pobi", 1),  // pobi는 1번 이동
                new MockCar("woni", 0)   // woni는 이동하지 않음
        );

        String result = stringGenerator.generateRaceResult(cars).toString();
        assertThat(result).contains("pobi : -", "woni : ", "실행 결과\n");
    }

    @Test
    void 우승자_결과_생성_테스트() {
        List<Car> winners = Arrays.asList(
                new MockCar("pobi"),
                new MockCar("woni")
        );

        String result = stringGenerator.generateWinnerResult(winners).toString();
        assertThat(result).isEqualTo("최종 우승자 : pobi, woni");
    }

    private static class MockCar extends Car {
        private final String name;
        private final int position;

        MockCar(String name) {
            this(name, 0);  // 기본 position 값을 0으로 설정
        }

        MockCar(String name, int position) {
            this.name = name;
            this.position = position;
        }
        @Override
        public String getName() {
            return name;
        }

        @Override
        public String getRaceResult(String colon, String moveChar) {
            return name + colon + moveChar.repeat(position);
        }
    }
}
