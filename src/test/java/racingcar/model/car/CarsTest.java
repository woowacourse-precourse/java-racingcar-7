package racingcar.model.car;

import org.junit.jupiter.api.Test;
import racingcar.model.CarNames;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @Test
    void 이름들로_자동차를_생성하는_데_성공한다() {
        // given
        String rawCarNames = "car1,car2,car3";
        Cars expected = new Cars(List.of(new Car("car1"), new Car("car2"), new Car("car3")));

        // when
        CarNames carNames = new CarNames(rawCarNames);
        Cars real = new Cars(
                carNames.splitByComma()
                        .stream()
                        .map(Car::new)
                        .toList()
        );

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 경주가_끝나면_라운드의_상태를_나타내는_문자열을_만드는_데_성공한다() {
        // given
        Cars cars = new Cars(List.of(new Car("car1"), new Car("car2"), new Car("car3")));

        // when
        String real = cars.race();

        // then
        assertThat(real).isInstanceOf(String.class).contains("car1", "car2", "car3", " : ");
    }

    @Test
    void 단일_우승자를_구하는_데_성공한다() {
        // given
        Car car1 = new Car("car1") {
            @Override
            int pickRandomNumber() {
                return 4;
            }
        };

        Car car2 = new Car("car2") {
            @Override
            int pickRandomNumber() {
                return 3;
            }
        };

        Car car3 = new Car("car3") {
            @Override
            int pickRandomNumber() {
                return 3;
            }
        };

        Cars cars = new Cars(List.of(car1, car2, car3));

        // when
        cars.race();
        String real = cars.winners();

        // then
        assertThat(real).isInstanceOf(String.class).contains("car1");
    }

    @Test
    void 복수_우승자를_구하는_데_성공한다() {
        // given
        Car car1 = new Car("car1") {
            @Override
            int pickRandomNumber() {
                return 4;
            }
        };

        Car car2 = new Car("car2") {
            @Override
            int pickRandomNumber() {
                return 4;
            }
        };

        Car car3 = new Car("car3") {
            @Override
            int pickRandomNumber() {
                return 3;
            }
        };

        Cars cars = new Cars(List.of(car1, car2, car3));

        // when
        cars.race();
        String real = cars.winners();

        // then
        assertThat(real).isInstanceOf(String.class).contains("car1", ",", "car2");
    }

    @Test
    void 같은_오브젝트인_경우_equals_가_true_를_반환한다() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        Cars carsOriginal = new Cars(List.of(car1, car2, car3));
        Cars carsTarget = carsOriginal;

        boolean expected = true;

        // when
        boolean real = carsOriginal.equals(carsTarget);

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 비교_대상_오브젝트가_null_인_경우_equals_가_false_를_반환한다() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        Cars carsOriginal = new Cars(List.of(car1, car2, car3));
        Cars carsTarget = null;

        boolean expected = false;

        // when
        boolean real = carsOriginal.equals(carsTarget);

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 비교_대상_오브젝트와_클래스가_다른_경우_equals_가_false_를_반환한다() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        Cars carsOriginal = new Cars(List.of(car1, car2, car3));
        String target = "test";

        boolean expected = false;

        // when
        boolean real = carsOriginal.equals(target);

        // then
        assertThat(real).isEqualTo(expected);
    }

    @Test
    void 자동차_이름이_다른_경우_equals_가_false_를_반환한다() {
        // given
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        Cars carsOriginal = new Cars(List.of(car1, car2));
        Cars carsTarget = new Cars(List.of(car2, car3));

        boolean expected = false;

        // when
        boolean real = carsOriginal.equals(carsTarget);

        // then
        assertThat(real).isEqualTo(expected);
    }
}
