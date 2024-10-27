package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fake.ForwardNumberGenerator;
import racingcar.fake.StopNumberGenerator;
import racingcar.fake.fakeStringValidator;
import racingcar.util.generator.NumberGenerator;
import racingcar.util.validator.StringValidator;

class RacingTest {

    private NumberGenerator forwardNumberGenerator;
    private NumberGenerator stopNumberGenerator;
    private StringValidator fakeStringValidator;

    @BeforeEach
    void setUp() {
        forwardNumberGenerator = new ForwardNumberGenerator();
        stopNumberGenerator = new StopNumberGenerator();
        fakeStringValidator = new fakeStringValidator();
    }

    @Test
    @DisplayName("모든 자동차들을 움직인다.")
    void moveTest() throws Exception {
        //given
        final CarName carName1 = CarName.of("앞으로 가는 자동차", fakeStringValidator);
        final CarName carName2 = CarName.of("정지 하는 자동차", fakeStringValidator);
        final Score score1 = new Score(0);
        final Score score2 = new Score(0);
        final Car car1 = new Car(carName1, score1, forwardNumberGenerator);
        final Car car2 = new Car(carName2, score2, stopNumberGenerator);
        final Racing racing = new Racing(List.of(car1, car2));

        //when
        final List<Car> cars = racing.move(1);

        //then
        assertAll(
                () -> assertThat(cars.getFirst().getScore()).isEqualTo(1),
                () -> assertThat(cars.get(1).getScore()).isZero()
        );
    }

    @Test
    @DisplayName("우승자를 가져온다.")
    void getWinnersTest() throws Exception {
        //given
        final CarName carName1 = CarName.of("앞으로 가는 자동차1", fakeStringValidator);
        final CarName carName2 = CarName.of("앞으로 가는 자동차2", fakeStringValidator);
        final CarName carName3 = CarName.of("정지 하는 자동차1", fakeStringValidator);
        final CarName carName4 = CarName.of("정지 하는 자동차2", fakeStringValidator);
        final Score score1 = new Score(0);
        final Score score2 = new Score(0);
        final Score score3 = new Score(0);
        final Score score4 = new Score(0);
        final Car car1 = new Car(carName1, score1, forwardNumberGenerator);
        final Car car2 = new Car(carName2, score2, forwardNumberGenerator);
        final Car car3 = new Car(carName3, score3, stopNumberGenerator);
        final Car car4 = new Car(carName4, score4, stopNumberGenerator);
        final Racing racing = new Racing(List.of(car1, car2, car3, car4));

        //when
        final List<Car> winners = racing.getWinners();

        //then
        assertAll(
                () -> assertThat(winners.getFirst()).isEqualTo(car1),
                () -> assertThat(winners.get(1)).isEqualTo(car2)
        );

    }
}