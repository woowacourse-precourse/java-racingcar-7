package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

class CarMakerTest {

    private CarMaker carMaker;

    @BeforeEach
    void setUp() {
        carMaker = new CarMaker(new CarNameValidator());
    }

    @Test
    void 정상_입력() {
        //given
        String carNames = "car1,car2,car3";

        //when
        List<Car> carList = carMaker.makeCars(carNames);

        //then
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("car1");
        assertThat(carList.get(1).getName()).isEqualTo("car2");
        assertThat(carList.get(2).getName()).isEqualTo("car3");
    }

    @Test
    void 공백_포함_가능() {
        //given
        String carNames = "car1 ,car2 , car3  ";

        //when
        List<Car> carList = carMaker.makeCars(carNames);

        //then
        assertThat(carList).hasSize(3);
        assertThat(carList.get(0).getName()).isEqualTo("car1");
        assertThat(carList.get(1).getName()).isEqualTo("car2");
        assertThat(carList.get(2).getName()).isEqualTo("car3");
    }

    @Test
    void 공백_입력() {
        //given
        String carNames = "";

        //when & then
        assertThatThrownBy(() -> carMaker.makeCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 한 대 이상의 자동차가 필요합니다.");
    }

    @Test
    void 자동차_이름_5자_초과() {
        //given
        String carNames = "car1,carcarcarcar2";

        //when & then
        assertThatThrownBy(() -> carMaker.makeCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 5자 이하만 가능합니다.");
    }

    @Test
    void 자동차_이름_중복() {
        //given
        String carNames = "car1,car1";

        //when & then
        assertThatThrownBy(() -> carMaker.makeCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차의 이름은 서로 중복될 수 없습니다.");
    }

    @Test
    void 특수_문자_포함() {
        //given
        String carNames = "car#,car@,car&";

        //when & then
        assertThatThrownBy(() -> carMaker.makeCars(carNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 제어문자 및 메타문자를 포함할 수 없습니다.");
    }
}