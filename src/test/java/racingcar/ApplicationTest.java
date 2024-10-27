package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
        Car testCar = new TestCar("siwu", 5);

        //when
        Car car = referee.judgeMovement(testCar);

        //then
        assertEquals(1, car.getDistance(), "주행 거리 판단 결과 전진이 아닙니다.");
        assertEquals(testCar, car);
    }

    @Test
    void 주행거리_판단_테스트_멈춤(){
        //given
        Referee referee = new CarRacingReferee();
        Car testCar = new TestCar("siwu", 2);

        //when
        Car car = referee.judgeMovement(testCar);

        //then
        assertEquals(0, car.getDistance(), "주행 거리 판단 결과 멈춤이 아닙니다.");
        assertEquals(car, testCar);
    }

    @Test
    void 최종_우승자_출력_테스트() {
        // given
        OutputManager outputManager = new ConsoleOutputManager();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<Car> winnerCars = Arrays.asList(
                new RacingCar("pobi"),
                new RacingCar("edi"),
                new RacingCar("rupi")
        );

        // when
        outputManager.printWinner(winnerCars);

        // then
        String expectedOutput = "최종 우승자 : pobi, edi, rupi" + System.lineSeparator();
        String actualOutput = outputStream.toString();
        System.out.println("Actual Output: " + actualOutput);
        assertEquals(expectedOutput, actualOutput, "우승자 출력이 잘못되었습니다.");
    }

    @Test
    void 자동차_생성_테스트() {
        //given
        Race race = new Race(new ConsoleInputManager(), new ConsoleOutputManager(), new CarRacingReferee());
        List<String> carNames = Arrays.asList("Car1", "Car2", "Car3");

        //when
        List<Car> cars = race.createParticipant(carNames);

        //then
        assertEquals(3, cars.size(), "자동차 목록 크기는 입력 크기와 일치해야 합니다.");
        assertEquals("Car1", cars.get(0).getName(), "첫 번째 자동차 이름이 일치해야 합니다.");
        assertEquals("Car2", cars.get(1).getName(), "두 번째 자동차 이름이 일치해야 합니다.");
        assertEquals("Car3", cars.get(2).getName(), "세 번재 자동차 이름이 일치해야 합니다.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
