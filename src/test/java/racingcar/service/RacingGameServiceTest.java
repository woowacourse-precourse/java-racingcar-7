package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class RacingGameServiceTest {
    private static final String CAR_OUTPUT_PATTERN = " : (-+)?";
    private RacingGameService racingGameService;
    private OutputView outputView;

    @BeforeEach
    void setUp() {
        outputView = new OutputView();
        racingGameService = new RacingGameService(outputView);
    }

    @Test
    @DisplayName("각 라운드에서 0부터 9까지의 숫자가 무작위로 생성되는지 테스트")
    void test_CarMovesForward() {

        int roundCount = 3;
        List<Car> cars = Arrays.asList(new Car("Car1",0), new Car("Car2",0));


        for (int i = 0; i < roundCount; i++) {
            racingGameService.playRound(cars);
            System.out.println("<ROUND " + i +">");
            for (Car car : cars) {
                assertTrue(car.getPosition() >= 0 && car.getPosition() <= 9);
                System.out.println("Car : " + car.getName()  + " Position : " +car.getPosition());
            }
        }
    }

    @Test
    @DisplayName("생성된 숫자가 4 이상일 경우 자동차가 전진하는지 확인하는 테스트")
    void testCarMoveWhenRandomValueOVER4() {
        Car car = new Car("testCar", 0);

        int randomValue = Randoms.pickNumberInRange(4, 9);
        if (randomValue >= 4) {
            car.move();
        }
        assertEquals(1, car.getPosition());
    }

    @Test
    @DisplayName("생성된 숫자가 4 미만일 경우 자동차가 전진하는지 확인하는 테스트")
    void testCarMoveWhenRandomValueLess4() {
        Car car = new Car("testCar", 0);

        int randomValue = Randoms.pickNumberInRange(0, 3);
        if (randomValue >= 4) {
            car.move();
        }
        assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차 이름과 -로 표시된 전진 결과가 올바르게 출력되는지 테스트")
    void testPrintResult() {

        int attemptCount = 5;
        List<Car> cars = Arrays.asList(new Car("SONATA", 0), new Car("ABANTE", 0));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        try {

            racingGameService.raceGame(cars, attemptCount);

            String output = outputStreamCaptor.toString();
            System.out.println("출력내용 " + outputStreamCaptor);

            for (Car car : cars) {
                assertTrue(output.contains(car.getName() + " : "));
                assertTrue(output.contains("SONATA")|| output.contains("ABANTE"));
                String regex = car.getName() + CAR_OUTPUT_PATTERN;
                assertTrue(output.matches("(?s).*" + regex + ".*"));
            }
        } finally {
            System.setOut( System.out);
        }
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 하나인 경우")
    void testFindSingleWinner() {
        Car car1 = new Car("Car1",5);
        Car car2 = new Car("Car2",4);
        Car car3 = new Car("Car3",3);

        List<Car> cars = Arrays.asList(car1,car2,car3);
        List<String> winner = racingGameService.findWinners(cars);

        assertTrue(winner.contains("Car1"));
    }

    @Test
    @DisplayName("가장 많이 전진한 자동차가 여러대인 경우")
    void testFindMultipleWinner() {
        Car car1 = new Car("Car1",5);
        Car car2 = new Car("Car2",5);
        Car car3 = new Car("Car3",5);

        List<Car> cars = Arrays.asList(car1,car2,car3);
        List<String> winners = racingGameService.findWinners(cars);

        assertEquals(3,winners.size());
        assertTrue(winners.containsAll(Arrays.asList("Car1","Car2","Car3")));
    }
}
