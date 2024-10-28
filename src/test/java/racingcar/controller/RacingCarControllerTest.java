package racingcar.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.constant.RacingCarInfoMsg.PRESENTATION_FINAL_WINNER;
import static racingcar.constant.RacingCarInfoMsg.TRACKING_START;
import static racingcar.constant.RacingCarInfoMsg.TYPE_RACE_COUNT;
import static racingcar.constant.RacingCarStatic.FINAL_WINNER_SEPARATOR;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.Application;
import racingcar.entity.RacingCar;
import racingcar.repository.RacingCarRepositoryImpl;
import racingcar.service.RacingCarService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

class RacingCarControllerTest extends NsTest {

    private final RacingCarRepositoryImpl racingCarRepository = new RacingCarRepositoryImpl();
    private final RacingCarService racingCarService = new RacingCarService(racingCarRepository);
    private final RacingCarController racingCarController = new RacingCarController(racingCarService);
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    @Test
    @DisplayName("setRacingCar 메서드를 통해 새로운 자동차 객체들을 생성할 수 있다.")
    void t001() {
        String testInput = "seo";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        racingCarController.setRacingCar(inputView);

        assertThat(racingCarService.getByName(testInput).isPresent()).isTrue();
    }

    @Test
    @DisplayName("setRacingCar 메서드를 통하여도 특정 글자수 이상의 자동차는 등록 불가하다")
    void t002() {
        String testInput = "seomoon";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.setRacingCar(inputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("경주를 열게 되면, 시도할 횟수를 입력받기 위한 문구가 출력된다")
    void t003() {
        String testInput = "1";
        InputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        racingCarController.startRacingGame(inputView, outputView);

        assertThat(output()).contains(TYPE_RACE_COUNT.getMsg());
    }

    @Test
    @DisplayName("주행 횟수를 숫자가 아닌 내용으로 입력하면 예외가 발생한다")
    void t004() {
        String testInput = "둘";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.startRacingGame(inputView, outputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수를 소수로 입력하면 예외가 발생한다")
    void t005() {
        String testInput = "3.3";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.startRacingGame(inputView, outputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수를 음수로 입력하면 예외가 발생한다")
    void t006() {
        String testInput = "-3";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.startRacingGame(inputView, outputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행 횟수를 음수로 입력하면 예외가 발생한다")
    void t007() {
        String testInput = "-3";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarController.startRacingGame(inputView, outputView))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("주행이 시작되면 저장된 자동차들의 distance가 변화함")
    void t008() {
        String testInput = "10";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        List<String> testCarNames = new ArrayList<>(Arrays.asList("pobi", "seo"));
        racingCarService.createAll(testCarNames);

        RacingCar pobiCar = racingCarService.getByName("pobi").get();
        RacingCar seoCar = racingCarService.getByName("seo").get();
        assertThat(pobiCar.getDistance()).isEqualTo(BigInteger.ZERO);
        assertThat(seoCar.getDistance()).isEqualTo(BigInteger.ZERO);

        racingCarController.startRacingGame(inputView, outputView);

        assertThat(pobiCar.getDistance()).isNotEqualTo(BigInteger.ZERO);
        assertThat(seoCar.getDistance()).isNotEqualTo(BigInteger.ZERO);
    }

    @Test
    @DisplayName("주행 결과를 알리기 위한 문구가 출력됨")
    void t009() {
        String testInput = "10";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));

        racingCarController.startRacingGame(inputView, outputView);

        assertThat(output()).contains(TRACKING_START.getMsg());
    }

    @Test
    @DisplayName("주행 횟수만큼 각 자동차의 이름과 주행 내용이 출력됨")
    void t010() {
        String testInput = "10";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        List<String> testCarNames = new ArrayList<>(Arrays.asList("seo"));
        racingCarService.createAll(testCarNames);

        racingCarController.startRacingGame(inputView, outputView);

        assertThat(output().split("seo : ", -1).length - 1).isEqualTo(10);
    }

    @Test
    @DisplayName("최종 우승자 안내를 위한 문구가 출력됨")
    void t011() {
        String testInput = "10";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        List<String> testCarNames = new ArrayList<>(Arrays.asList("seo"));
        racingCarService.createAll(testCarNames);
        racingCarController.startRacingGame(inputView, outputView);

        racingCarController.finalAward(outputView);

        assertThat(output()).contains(PRESENTATION_FINAL_WINNER.getMsg());
    }

    @Test
    @DisplayName("최종 우승자가 쉼표로 구분지어 출력됨")
    void t012() {
        String testInput = "0";
        System.setIn(new ByteArrayInputStream(testInput.getBytes()));
        List<String> testCarNames = new ArrayList<>(Arrays.asList("seo","pobi"));
        racingCarService.createAll(testCarNames);
        racingCarController.startRacingGame(inputView, outputView);

        racingCarController.finalAward(outputView);

        assertThat(output()).contains("최종 우승자 : pobi" + FINAL_WINNER_SEPARATOR + " seo");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}