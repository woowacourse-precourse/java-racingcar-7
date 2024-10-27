package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.*;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void 이름_분류_테스트(){
        //given
        InputManager inputManager = new ConsoleInputManager();
        List<String> comparisonValue = Arrays.asList("pobi", "woni");

        //when
        List<String> classifiedName = inputManager.splitName("pobi,woni");

        //then
        assertEquals(comparisonValue, classifiedName, "결과는 {pobi,woni}여야 합니다.");
    }

    @Test
    void 이름이_5자_이상_입력되어_에러_발생_테스트(){
        //given
        InputManager inputManager = new ConsoleInputManager();
        String input = "Alice,Bob,Charles";

        //when
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            inputManager.splitName(input);
        });

        //then
        assertEquals(exception.getMessage(), "이름은 5자 이하로 입력하세요.");
    }

    @Test
    void 랜덤값_경계값_입력_판단_테스트(){
        //given
        Car car = new RacingCar("siwu");

        //when
        boolean judge = car.judge(4);

        //then
        assertEquals(judge, true, "4가 들어올 경우 true가 반환되어야 합니다.");
    }

    @Test
    void 랜덤값_true_입력_판단_테스트(){
        //given
        Car car = new RacingCar("siwu");

        //when
        boolean judge = car.judge(9);

        //then
        assertEquals(judge, true, "9가 들어올 경우 true가 반환되어야 합니다.");
    }

    @Test
    void 랜덤값_false_입력_판단_테스트(){
        //given
        Car car = new RacingCar("siwu");

        //when
        boolean judge = car.judge(2);

        //then
        assertEquals(judge, false, "2가 들어올 경우 false가 반환되어야 합니다.");
    }

    @Test
    void 주행거리_판단_테스트_전진(){
        //given
        Referee referee = new CarRacingReferee();
        TestCar testCar = new TestCar("siwu", 5);

        //when
        Car car = referee.judgeMovement(testCar);

        //then
        assertEquals(1, car.getDistance(), "주행 거리 판단이 잘못되었습니다.");
        assertEquals(testCar, car);
    }

    @Test
    void 주행거리_판단_테스트_멈춤(){
        //given
        Referee referee = new CarRacingReferee();
        TestCar testCar = new TestCar("siwu", 2);

        //when
        Car car = referee.judgeMovement(testCar);

        //then
        assertEquals(0, car.getDistance());
        assertEquals(car, testCar);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
