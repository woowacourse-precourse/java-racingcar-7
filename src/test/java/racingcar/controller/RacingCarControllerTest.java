package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.RacingCarInfoMsg.PRESENTATION_FINAL_WINNER;
import static racingcar.constant.RacingCarInfoMsg.TRACKING_START;
import static racingcar.constant.RacingCarInfoMsg.TYPE_RACE_COUNT;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.entity.RacingCar;
import racingcar.repository.RacingCarRepositoryImpl;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class RacingCarControllerTest extends NsTest {

    private static final RacingCarRepositoryImpl racingCarRepository = new RacingCarRepositoryImpl();
    private static final RacingCarService racingCarService = new RacingCarService(racingCarRepository);
    private static final RacingCarController racingCarController = new RacingCarController(racingCarService);
    private static final OutputView outputView = new OutputView();

    private final InputStream standardIn = System.in;
    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        System.setIn(standardIn);
    }

    @AfterAll
    static void cleanUp() {
        Console.close();
        racingCarRepository.deleteAll();
    }

    private void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Console.close();
    }

    @Test
    @DisplayName("setRacingCar 메서드를 통해 새로운 자동차 객체들을 생성할 수 있다.")
    void t001() {
        String input = "seo";
        setInput(input);

        racingCarController.setRacingCar(inputView);

        assertThat(racingCarService.getByName(input).isPresent()).isTrue();
    }

    @Test
    @DisplayName("setRacingCar 메서드를 통하여도 특정 글자수 이상의 자동차는 등록 불가하다")
    void t002() {
        String input = "seomoon";
        setInput(input);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.setRacingCar(inputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("setRacingCar 메서드를 통하여도 비어있는 이름의 등록은 불가하다")
    void t003() {
        String input = " ";
        setInput(input);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.setRacingCar(inputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("경주를 열게 되면, 시도할 횟수를 입력받기 위한 문구가 출력된다")
    void t004() {
        String input = "1";
        setInput(input);

        racingCarController.startRacingGame(inputView, outputView);

        assertThat(output()).contains(TYPE_RACE_COUNT.getMsg());
    }

    @Test
    @DisplayName("주행 횟수를 숫자가 아닌 내용으로 입력하면 예외가 발생한다")
    void t005() {
        String input = "둘";
        setInput(input);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.startRacingGame(inputView, outputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수를 소수로 입력하면 예외가 발생한다")
    void t006() {
        String input = "3.3";
        setInput(input);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.startRacingGame(inputView, outputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수를 음수로 입력하면 예외가 발생한다")
    void t007() {
        String input = "-3";
        setInput(input);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.startRacingGame(inputView, outputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 결과를 알리기 위한 문구가 출력됨")
    void t009() {
        String input = "10";
        setInput(input);

        racingCarController.startRacingGame(inputView, outputView);

        assertThat(output()).contains(TRACKING_START.getMsg());
    }

    @Test
    @DisplayName("주행 횟수만큼 각 자동차의 이름과 주행 내용이 출력됨")
    void t010() {
        String input = "10";
        setInput(input);
        List<String> testCarNames = new ArrayList<>(Arrays.asList("seo"));
        racingCarService.createAll(testCarNames);

        racingCarController.startRacingGame(inputView, outputView);

        assertThat(output().split("seo : ", -1).length - 1).isEqualTo(10);
    }

    @Test
    @DisplayName("최종 우승자 안내를 위한 문구가 출력됨")
    void t011() {
        String input = "10";
        setInput(input);
        List<String> testCarNames = new ArrayList<>(Arrays.asList("seo"));
        racingCarService.createAll(testCarNames);
        racingCarController.startRacingGame(inputView, outputView);

        racingCarController.finalAward(outputView);

        assertThat(output()).contains(PRESENTATION_FINAL_WINNER.getMsg());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}