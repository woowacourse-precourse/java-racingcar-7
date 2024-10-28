package racingcar.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private Car car1;
    private Car car2;
    private Cars cars;

    @BeforeEach
    void setUp() {
        car1 = new Car("pobi");
        car2 = new Car("crong");
        cars = new Cars(List.of(car1, car2));
    }

    @Test
    void 모든_자동차_이동() {
        // 각 자동차를 이동시키기 위해 임의의 값을 설정
        car1.move(5); // 전진 조건 충족 (4 이상)
        car2.move(3); // 전진 조건 미충족 (4 미만)

        // 이동 후 위치가 적절히 업데이트되었는지 확인
        assertThat(car1.getPosition()).isEqualTo(5);
        assertThat(car2.getPosition()).isEqualTo(0);
    }


    @Test
    void 우승자_확인() {
        // 이동 시켜 우승자 선정
        car1.move(5);  // pobi가 최대 위치로 이동
        car2.move(5);  // crong도 최대 위치로 이동

        List<String> winners = cars.getWinners();

        // 우승자 리스트에 두 자동차가 포함되는지 확인
        assertThat(winners).containsExactlyInAnyOrder("pobi", "crong");
    }
}
