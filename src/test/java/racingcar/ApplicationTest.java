package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.CarCreator.createCar;

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
    void 입력_구분_테스트() {

        String nameString = "test1,test2";
        List<String> participants = Arrays.stream(nameString.split(",")).toList();

        Assertions.assertThat(participants).isEqualTo(List.of("test1", "test2"));

    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 중복_이름_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 차_생성_테스트() {

        List<String> carNames = List.of("aya","bub");
        List<Car> cars = createCar(carNames);
        assertThat(cars)
                .extracting(Car::getName)
                .isEqualTo(List.of("aya", "bub"));
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
