package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static racingcar.service.exception.CarNamesExceptionMessage.CAR_NAME_DUPLICATED;
import static racingcar.service.exception.CarNamesExceptionMessage.CAR_NAME_MUST_UNDER_LENGTH_FIVE;
import static racingcar.service.exception.CarNamesExceptionMessage.INVALID_CAR_NAME;
import static racingcar.service.exception.CarNamesExceptionMessage.INVALID_CAR_NAMES;
import static racingcar.service.exception.RaceCountExceptionMessage.RACE_COUNT_CANNOT_BLANK;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.Car;
import racingcar.domain.car.Name;
import racingcar.domain.car.Position;
import racingcar.domain.car.Vehicle;
import racingcar.domain.race.RaceManager;
import racingcar.domain.strategy.RandomStrategy;
import racingcar.service.exception.CarNamesException;
import racingcar.service.exception.RaceCountException;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private final RaceManager raceManager = new RaceManager();

    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    void 자동차의_난수_전략이_4_미만을_생성하면_정지한다() {
        // given
        Name name = Name.from("A");
        Position position = Position.from(0);
        RandomStrategy doNotMove = RandomStrategy.from(STOP);
        // when
        Car car = Car.of(name, position, doNotMove);
        Vehicle notMovedCar = car.moveForwardRandomly();
        // then
        assertEquals(car, notMovedCar);
        assertEquals(car.getPosition(), notMovedCar.getPosition());
        assertEquals(car.getPosition().getValue(), notMovedCar.getPosition().getValue());
    }

    @Test
    void 자동차의_난수_전략이_4_이상을_생성하면_전진한다() {
        // given
        Name name = Name.from("A");
        Position position = Position.from(0);
        RandomStrategy move = RandomStrategy.from(MOVING_FORWARD);
        // when
        Car car = Car.of(name, position, move);
        Vehicle movedCar = car.moveForwardRandomly();
        // then
        assertNotEquals(car, movedCar);
        assertNotEquals(car.getPosition(), movedCar.getPosition());
        assertEquals(car.getPosition().getValue(), movedCar.getPosition().getValue() - 1);
    }

    @Test
    void 자동차_이름이_빈_문자열이라면_예외발생() {
        // given
        String carNames = "a,,c";
        // when & then
        CarNamesException e = assertThrows(CarNamesException.class, () -> raceManager.setCars(carNames));
        assertEquals(e.getMessage(), INVALID_CAR_NAME.message());
    }

    @Test
    void 자동차_이름이_공백문자라면_예외발생() {
        // given
        String carNames = "a, ,c";
        // when & then
        CarNamesException e = assertThrows(CarNamesException.class, () -> raceManager.setCars(carNames));
        assertEquals(e.getMessage(), INVALID_CAR_NAMES.message());
    }

    @Test
    void 자동차_이름이_한글_또는_영어_또는_숫자_또는_콤마가_아니라면_예외발생() {
        // given & when
        String carNames = "a,?,c";
        // when & then
        CarNamesException e = assertThrows(CarNamesException.class, () -> raceManager.setCars(carNames));
        assertEquals(e.getMessage(), INVALID_CAR_NAMES.message());
    }

    @Test
    void 자동차_이름을_분리하기_위해_슬래시를_사용한다면_예외발생() {
        // given
        String carNames = "a/b/c";
        // when & then
        CarNamesException e = assertThrows(CarNamesException.class, () -> raceManager.setCars(carNames));
        assertEquals(e.getMessage(), INVALID_CAR_NAMES.message());
    }

    @Test
    void 자동차_이름을_분리하기_위해_공백문자를_사용한다면_예외발생() {
        // given
        String carNames = "a b c";
        // when & then
        CarNamesException e = assertThrows(CarNamesException.class, () -> raceManager.setCars(carNames));
        assertEquals(e.getMessage(), INVALID_CAR_NAMES.message());
    }

    @Test
    void 자동차_이름을_분리하기_위해_파이프를_사용한다면_예외발생() {
        // given
        String carNames = "a|b|c";
        // when & then
        CarNamesException e = assertThrows(CarNamesException.class, () -> raceManager.setCars(carNames));
        assertEquals(e.getMessage(), INVALID_CAR_NAMES.message());
    }

    @Test
    void 자동차_이름_길이가_5를_초과한다면_예외발생() {
        // given
        String carNames = "aaaaaa,b,c";
        // when & then
        CarNamesException e = assertThrows(CarNamesException.class, () -> raceManager.setCars(carNames));
        assertEquals(e.getMessage(), CAR_NAME_MUST_UNDER_LENGTH_FIVE.message());
    }

    @Test
    void 자동차_이름이_중복된다면_예외발생() {
        // given
        String carNames = "a,a,c";
        // when & then
        CarNamesException e = assertThrows(CarNamesException.class, () -> raceManager.setCars(carNames));
        assertEquals(e.getMessage(), CAR_NAME_DUPLICATED.message());
    }

    @Test
    void 경주_횟수가_빈_문자열이라면_예외발생() {
        // given
        String raceCount = "     ";
        // when & then
        RaceCountException e = assertThrows(RaceCountException.class, () -> raceManager.setRaceCount(raceCount));
        assertEquals(e.getMessage(), RACE_COUNT_CANNOT_BLANK.message());
    }
}
