package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.Controller.PlayController;
import racingcar.Model.Car;
import racingcar.Model.GameCars;
import racingcar.Validation.InputValidator;
import racingcar.View.GameView;

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

    //InputController test
    @Nested
    class InputValidatorTest {

        @Test
        public void testEmptyInputThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> InputValidator.validate(""));
        }

        @Test
        public void testTrailingCommaThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> InputValidator.validate("Car1,Car2,"));
        }

        @Test
        public void testSingleParticipantThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> InputValidator.validate("Car1"));
        }

        @Test
        public void testDuplicateNamesThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> InputValidator.validate("Car1,Car1"));
        }

        @Test
        public void testSpecialCharacterInNameThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> InputValidator.validate("Car@1,Car2"));
        }

        @Test
        public void testNameLengthExceedsFiveThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> InputValidator.validate("Car12345,Car2"));
        }
    }


    //GameCars test
    @Nested
    class GameCarsTest {

        @Test
        public void testAddCars() {
            String[] carNames = {"Car1", "Car2", "Car3"};
            GameCars gameCars = new GameCars(carNames);

            assertEquals(3, gameCars.getCars().size());
        }

        @Test
        public void testPlayGames() {
            String[] carNames = {"Car1", "Car2"};
            GameCars gameCars = new GameCars(carNames);

            gameCars.playGames();
        }

        @Test
        public void testFindWinnerCars() {
            String[] carNames = {"Car1", "Car2"};
            GameCars gameCars = new GameCars(carNames);
            gameCars.getCars().get(0).ongoing();
            gameCars.getCars().get(0).ongoing();
            gameCars.getCars().get(1).ongoing();

            List<Car> winners = gameCars.findWinnerCars();
            assertEquals(1, winners.size());
        }
    }


    @Nested
    class GameViewTest {

        @Test
        public void testShowGameProgress() {
            GameView gameView = new GameView();
            List<Car> cars = List.of(new Car("Car1"), new Car("Car2"));

            assertDoesNotThrow(() -> gameView.showGameProgress(cars));
        }

        @Test
        public void testShowWinnerCars() {
            GameView gameView = new GameView();
            List<Car> cars = List.of(new Car("Car1"));

            assertDoesNotThrow(() -> gameView.showWinnerCars(cars));
        }
    }

    @Nested
    class PlayControllerTest {

        private GameCars gameCars;
        private GameView gameView;
        private PlayController playController;

        @BeforeEach
        public void setUp() {
            String[] carNames = {"Car1", "Car2"};
            gameCars = new GameCars(carNames);
            gameView = new GameView();
            playController = new PlayController(gameCars, 3, gameView);
        }

        @Test
        public void testDetermineWinners() {
            // 진행 거리를 수동으로 설정하여 우승자 검증
            gameCars.getCars().get(0).ongoing(); // Car1 진행 거리 1
            gameCars.getCars().get(0).ongoing(); // Car1 진행 거리 2
            gameCars.getCars().get(1).ongoing(); // Car2 진행 거리 1

            List<Car> winners = gameCars.findWinnerCars();
            assertEquals(1, winners.size()); // 우승자가 한 명인지 확인
            assertEquals("Car1", winners.get(0).getName()); // Car1이 우승자인지 확인
        }

        @Test
        //
        public void testDisplayWinners() {
            // System.out 출력을 가로채서 결과를 검증
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            System.setOut(new PrintStream(outputStream));

            // 진행 거리를 설정하여 우승자 결과 출력
            gameCars.getCars().get(0).ongoing();
            playController.startGame();

            String output = outputStream.toString();
            // 우승자 출력이 포함되어 있는지 확인
            assertEquals(true, output.contains("최종 우승자 : Car1") || output.contains("최종 우승자 : Car2"),
                    "우승자출력이 원하는 내용과 다릅니다");

            // System.out을 원래 상태로 복원
            System.setOut(System.out);
        }
    }



@Override
public void runMain() {
    Application.main(new String[]{});
}

}