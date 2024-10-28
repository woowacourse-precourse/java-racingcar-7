package racingcar;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CarTest {
    private static int INITIAL_POSITION = 0;
    @Test
    public void 자동차이름검증_빈문자열_예외발생() {
        String carName = "";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(carName))
                .withMessage("[ERROR] 자동차 이름은 빈 문자열일 수 없습니다");
    }

    @Test
    public void 자동차이름검증_null_예외발생() {
        String carName = null;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(carName))
                .withMessage("[ERROR] 자동차 이름은 빈 문자열일 수 없습니다");
    }

    @Test
    public void 자동차이름검증_6자리이상_예외발생() {
        String carName = "ComNewbie";

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car(carName))
                .withMessage("[ERROR] 자동차 이름의 길이는 5자리 이하 입니다");
    }

    @Test
    public void 자동차이름검증_성공() {
        String carName = "pobi";

        Car car = new Car(carName);

        assertThat(car.getName()).isEqualTo(carName);
    }

    @Test
    public void 자동차_전진_성공() {
        Car car = moveUntilPositionIncreased();

        if (car.getPosition() < 9) {
            assertThat(car.getPosition()).isGreaterThan(INITIAL_POSITION);
        }
    }

    @Test
    public void 자동차_위치_문자열_변환_성공() {
       Car car = moveUntilPositionIncreased();

        PositionSign positionSign = car.getPositionSign();

        assertThat(positionSign.toString()).contains("-");
        assertThat(positionSign.toString().length()).isGreaterThan(0);
    }

    private Car moveUntilPositionIncreased(){
        Car car = new Car("pobi");

        int initialPosition = car.getPosition();

        while (car.getPosition() == initialPosition) {
            car.forward(); // 위치가 증가할 때까지 계속 전진
        }
        return car;
    }
}