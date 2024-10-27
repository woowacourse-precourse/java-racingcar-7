package racingcar.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.MoveCount;
import racingcar.repository.CarMemoryRepository;
import racingcar.repository.CarRepository;
import racingcar.service.GameService;
import racingcar.service.GameServiceImpl;
import racingcar.view.OutputView;

class GameControllerTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream testOut = new ByteArrayOutputStream();
    private CarRepository carRepository;

    private GameService gameService;
    private GameController gameController;

    private OutputView outputView;

    private List<String> carNames;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(testOut));

        carRepository = new CarMemoryRepository();
        gameService = new GameServiceImpl(carRepository);
        outputView = new OutputView();
        gameController = new GameController(gameService, outputView);
    }

    @AfterEach
    void tearDown() {
        // System.out을 원래대로 복원
        System.setOut(originalOut);
    }

    private void initCarData() {
        carNames = Arrays.asList("Java", "Scala", "Rust", "Swish");
        for (String name : carNames) {
            Car car = new Car(new CarName(name));
            carRepository.save(car);
        }
    }

    @Test
    void 이동_예외() throws Exception {
        //given
        //아무런 데이터가 없을 때
        //when
        assertThrows(IllegalArgumentException.class, () -> gameController.executeRace(new MoveCount(5)));
    }

    @Test
    void 이동() throws Exception {
        //given
        initCarData();
        MoveCount moveCount = new MoveCount(5);
        //when
        gameController.executeRace(moveCount);

        //then
        String output = testOut.toString();

        assertTrue(output.contains(OutputView.RESULT_START_MESSAGE), "시작 메시지가 출력되지 않았습니다.");

        for (String carName : carNames) {
            String carStatus = carName + " : ";
            int count = countOccurrences(output, carStatus);
            assertEquals(5, count, carName + "의 현재 상태가 " + 5 + "번 출력되지 않았습니다.");
        }

        boolean winnerFound = false;
        for (String carName : carNames) {
            if (output.contains("최종 우승자 : " + carName)) {
                winnerFound = true;
                break;
            }
        }
        assertTrue(winnerFound, "승자 메시지가 올바르게 출력되지 않았습니다.");
    }


    /**
     * 문자열 내 특정 문자열의 출력 횟수를 셉니다.
     *
     * @param str 전체 문자열
     * @param sub 검색할 문자열
     * @return 부분 문자열의 출력 횟수
     */
    private int countOccurrences(String str, String sub) {
        return (str.length() - str.replace(sub, "").length()) / sub.length();
    }
}