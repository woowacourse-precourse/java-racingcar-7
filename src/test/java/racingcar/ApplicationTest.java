package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

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

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void move는_4_미만의_숫자에선_전진하지_않는다(int randomNumber) {
        Car car = new Car("david");
        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void move는_4_이상의_숫자에선_전진한다(int randomNumber) {
        Car car = new Car("david");
        car.move(randomNumber);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "bag", "to", "hoby", "a"})
    void car_생성자는_이름이_5글자_미만인_경우에_정상적으로_생성된다(String name) {
        assertThatCode(() -> new Car(name)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"helloworld", "bagbag", "todavid"})
    void car_생성자는_이름이_5글자_미만인_경우에_IllegalArgumentExepciton을_던진다(String name) {
        assertThatThrownBy(() -> new Car(name)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1a", "2;", "3aa", "bbc"})
    void racing_game_생성자는_숫자가_아닌_입력을_받는_경우에_IllegalArgumentExepciton을_던진다(String numberOfTrials) {
        String[] names = {"hello", "bag", "to"};
        assertThatThrownBy(() -> new RacingGame(numberOfTrials, names)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "0"})
    void racing_game_생성자는_숫자를_입력_받는_경우에_정상적으로_생성된다(String numberOfTrials) {
        String[] names = {"hello", "bag", "to"};
        assertThatCode(() -> new RacingGame(numberOfTrials, names)).doesNotThrowAnyException();
    }

    @Test
    void getMaxPosition은_cars_중_가장_큰_position을_갖는_car의_position값을_리턴한다() {
        assertRandomNumberInRangeTest(
                () -> {
                    RacingGame game = new RacingGame("1", "pobi", "woni");
                    game.trial();
                    int position = game.getMaxPosition();

                    assertThat(position).isEqualTo(1);
                },
                MOVING_FORWARD, STOP
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
