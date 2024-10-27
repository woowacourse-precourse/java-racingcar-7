package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.fake.ForwardNumberGenerator;
import racingcar.fake.StopNumberGenerator;
import racingcar.fake.FakeStringValidator;
import racingcar.util.generator.NumberGenerator;
import racingcar.util.validator.StringValidator;

class CarTest {

    private NumberGenerator forwardNumberGenerator;
    private NumberGenerator stopNumberGenerator;
    private StringValidator fakeStringValidator;

    @BeforeEach
    void setUp() {
        forwardNumberGenerator = new ForwardNumberGenerator();
        stopNumberGenerator = new StopNumberGenerator();
        fakeStringValidator = new FakeStringValidator();
    }

    @Test
    @DisplayName("무작위 값이 기준값 미만이므로 자동차가 전진 하지않는다.")
    void stopTest() throws Exception {
        //given
        final CarName carName = CarName.of("전진 하지 않는 자동차", fakeStringValidator);
        final Score score = new Score(0);
        final Car car = new Car(carName, score, stopNumberGenerator);

        //when
        car.go(1);

        //then
        assertThat(car.getScore()).isZero();

    }

    @Test
    @DisplayName("무작위 값이 기준값 이상이므로 자동차가 전진 한다.")
    void forwardTest() throws Exception {
        //given
        final CarName carName = CarName.of("전진 하는 자동차", fakeStringValidator);
        final Score score = new Score(0);
        final Car car = new Car(carName, score, forwardNumberGenerator);

        //when
        car.go(2);

        //then
        assertThat(car.getScore()).isEqualTo(2);

    }

    @Test
    @DisplayName("스코어가 최대 스코어 이므로 isWinner()는 true를 반환한다.")
    void isWinnerTest() throws Exception {
        //given
        final int maxScore = 10;
        final CarName carName = CarName.of("우승 자동차", fakeStringValidator);
        final Score score = new Score(maxScore);
        final Car car = new Car(carName, score, forwardNumberGenerator);

        //when
        final boolean winner = car.isWinner(maxScore);

        //then
        assertThat(winner).isTrue();
    }

}