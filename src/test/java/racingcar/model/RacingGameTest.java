package racingcar.model;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Application;

public class RacingGameTest extends NsTest {
    @ParameterizedTest
    @DisplayName("시행횟수를 테스트합니다.")
    @ValueSource(strings = {"0", "-1", "0.7", "8.8", "거북이"})
    void tryCount_테스트(String target) {
        CarName turtle = new CarName("거북이");
        CarName rabbit = new CarName("토끼");
        CarName seaKing = new CarName("용왕");

        Car car5 = new Car(turtle);
        Car car6 = new Car(rabbit);
        Car car7 = new Car(seaKing);

        Cars cars = new Cars(List.of(car5, car6, car7));

        Assertions.assertThatThrownBy(() -> new RacingGame(cars, target))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
