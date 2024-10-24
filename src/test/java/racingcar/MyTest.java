package racingcar;

import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.car.*;
import racingcar.car.strategy.*;
import racingcar.game.RacingGame;
import racingcar.util.TestNumberGenerator;
import racingcar.util.Validator;
import racingcar.view.OutputHandler;

public class MyTest {
    private static final String WRONG_CAR_NAME_EXCEPTION = "경주할 자동차 이름을 잘 못 입력하셨습니다.";
    private static final String WRONG_ROUND_EXCEPTION = "시도할 횟수는 0이거나 비어있을 수 없습니다.";
    private static final int RANDOM_VALUE_THAT_MOVE = 4;
    private static final int RANDOM_VALUE_THAT_STOP = 3;
    private static final int MOVE_ONCE = 1;
    private static final int STOP = 0;
    private static final int ONE_ROUND = 1;

    // 출력 테스트를 위한 변수
    private ByteArrayOutputStream captor;

    // 매 테스트마다 System.setOut 초기화
    @BeforeEach
    public void initSetOut() {
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));
    }

    @AfterEach
    public void restoreSetOut() {
        System.setOut(System.out);
    }

    private static List<Car> generateCars(MoveStrategy moveStrategy) {
        List<String> carNames = List.of("car1", "car2", "car3");
        CarFactory carFactory = new CarFactory();

        return carFactory.createCars(carNames, moveStrategy);
    }

    private static List<Car> generateCars(MoveStrategy firstStrategy, MoveStrategy secondStrategy) {
        Car firstCar = new Car(firstStrategy, "car1");
        Car secondCar = new Car(secondStrategy, "car2");

        return List.of(firstCar, secondCar);
    }

    @DisplayName("자동차 이름 Validator 테스트")
    @Test
    public void 자동차_이름_예외_테스트() {
        String[] validCars = {
                // 정상 케이스 1. 기본
                "hyun,yenni", "HYUN,YENNI",
                // 정상 케이스 2. 구분자 양 옆 띄어쓰기
                "A, B, C, D", "car1, car2, car3", "car1 , car2",
                // 정상 케이스 3. 특수 문자 포함
                "XÆ, A-12", "@지존승현, !승현!, ~붕붕이~",
                // 정상 케이스 4. 긴 경우
                "hyun, yenni, pobi, test2,test2,12345,aaddd",
                // 정상 케이스 5. 참가하는 자동차가 하나인 경우
                "alone",
        };

        String[] invalidCars = {
                // 예외 케이스 1. 이름 글자 수 제한 초과
                "123456, hyun",
                // 예외 케이스 2. 이름에 띄어쓰기가 포함되어 있음
                "a bc, def", "ab cd, pobi",
                // 예외 케이스 3. 이름이 공백으로만 이루어져 있음
                " ,abc", "  ,  ",
                // 예외 케이스 4. 구분자(반점)이 여러개 있음
                ",,", "abc, def,",
                // 예외 케이스 5. 양 옆에 띄어쓰기가 있음
                " hyun, yenni", "hyun, yenni ",
                // 예외 케이스 6. 아무도 출전하지 않음
                "",
        };

        final Validator validator = new Validator();
        for (String cars : validCars) {
            assertThatNoException().isThrownBy(() -> validator.checkAboutCars(cars));
        }
        for (String cars : invalidCars) {
            assertThatIllegalArgumentException().isThrownBy(() -> validator.checkAboutCars(cars))
                    .withMessage(WRONG_CAR_NAME_EXCEPTION);
        }
    }

    @DisplayName("시도할 횟수 Validator 테스트")
    @Test
    public void 게임_시도횟수_예외_테스트() {
        final Validator validator = new Validator();

        for (int i = -1; i < 10; i++) { // -1부터 10까지 대입 테스트
            String currentRound = Integer.toString(i);

            if (i <= 0) {
                assertThatIllegalArgumentException().
                        isThrownBy(() -> validator.checkAboutRound(currentRound))
                        .withMessage(WRONG_ROUND_EXCEPTION);

                continue;
            }
            assertThatNoException().isThrownBy(() -> validator.checkAboutRound(currentRound));
        }

        // 빈 값 대입 테스트
        String emptyString = "";
        assertThatIllegalArgumentException().isThrownBy(() -> validator.checkAboutRound(emptyString));
    }

    @DisplayName("무작위 값에 따른 정지")
    @Test
    void 무작위_값_정지_테스트() {
        // given - 테스트 값 준비
        MoveStrategy moveStrategy = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_STOP));

        // when - 실제 테스트
        int actualResult = moveStrategy.getPossibleMoveAmount();

        // then - 검증
        assertThat(actualResult).isEqualTo(STOP);
    }

    @DisplayName("무작위 값에 따른 전진")
    @Test
    void 무작위_값_전진_테스트() {
        // given
        MoveStrategy moveStrategy = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_MOVE));

        // when
        int actualResult = moveStrategy.getPossibleMoveAmount();

        // then
        assertThat(actualResult).isEqualTo(MOVE_ONCE);
    }

    @DisplayName("자동차 위치 정지")
    @Test
    void 자동차_정지_테스트() {
        // given
        MoveStrategy moveStrategy = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_STOP));
        Car car = new Car(moveStrategy, "hyun");

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(STOP);
    }

    @DisplayName("자동차 위치 전진")
    @Test
    void 자동차_전진_테스트() {
        // given
        MoveStrategy moveStrategy = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_MOVE));
        Car car = new Car(moveStrategy, "yenni");

        // when
        car.move();

        // then
        assertThat(car.getPosition()).isEqualTo(MOVE_ONCE);
    }

    @DisplayName("자동차 현황 출력")
    @Test
    void 자동차_현황_출력_테스트() {
        // given
        String expectedOutput = "실행 결과\ncar1 : -\ncar2 : -\ncar3 : -";
        OutputHandler outputHandler = new OutputHandler();

        // 자동차 리스트 생성
        MoveStrategy moveStrategy = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_MOVE));
        List<Car> cars = generateCars(moveStrategy);
        cars.forEach(Car::move);

        // when
        outputHandler.printStatus(cars);

        // then
        String actualOutput = captor.toString().trim();
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @DisplayName("레이싱 단독 우승자 출력")
    @Test
    void 레이싱_단독_우승자_출력_테스트() {
        // given
        String expectedOutput = "최종 우승자 : car1";
        OutputHandler outputHandler = new OutputHandler();

        // 우승 자동차와 패배 자동차 리스트 생성
        MoveStrategy moveStrategyThatWillMove = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_MOVE));
        MoveStrategy moveStrategyThatWillStop = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_STOP));
        List<Car> cars = generateCars(moveStrategyThatWillMove, moveStrategyThatWillStop);
        cars.forEach(Car::move);

        // 게임 진행 후 우승자 가져오기
        RacingGame racingGame = new RacingGame(cars, 1);
        List<Car> winners = racingGame.getWinners();

        // when
        outputHandler.printWinner(winners);

        // then
        String actualOutput = captor.toString().trim();
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }

    @DisplayName("레이싱 공동 우승자 출력")
    @Test
    void 레이싱_공동_우승자_출력_테스트() {
        // given
        String expectedOutput = "최종 우승자 : car1, car2, car3";
        OutputHandler outputHandler = new OutputHandler();

        MoveStrategy moveStrategy = new RandomMoveStrategy(new TestNumberGenerator(RANDOM_VALUE_THAT_MOVE));
        List<Car> cars = generateCars(moveStrategy);

        // 게임 진행 후 우승자 가져오기
        RacingGame racingGame = new RacingGame(cars, ONE_ROUND);
        List<Car> winners = racingGame.getWinners();

        // when
        outputHandler.printWinner(winners);
        String actualOutput = captor.toString().trim();

        // then
        assertThat(actualOutput).isEqualTo(expectedOutput);
    }
}
