package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.RacingCar;

public class RacingServiceTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;
    private RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameService();
    }

    @Test
    void 자동차_이름이_정상적으로_입력된_경우_1() {
        String carNames = "pobi,woni";
        Assertions.assertDoesNotThrow(() -> racingGameService.initializeRacingGame(carNames));
    }

    @Test
    void 자동차_이름이_정상적으로_입력된_경우_2() {
        String carNames = "pobi,   woni";
        Assertions.assertDoesNotThrow(() -> racingGameService.initializeRacingGame(carNames));
    }

    @Test
    void 자동차_이름이_비어_있는_입력된_경우_1() {
        String carNames = "";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.initializeRacingGame(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 자동차_이름이_비어_있는_입력된_경우_2() {
        String carNames = "woni, ";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.initializeRacingGame(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 동일한_이름이_중복되어_입력된_경우() {
        String carNames = "pobi,pobi";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.initializeRacingGame(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 다섯자_이상의_자동차_이름이_입력된_경우() {
        String carNames = "abceda,pobi";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.initializeRacingGame(carNames))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_0인_경우() {
        String tryCount = "0";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.convertTryCountToInt(tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_음수인_경우() {
        String tryCount = "-11";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.convertTryCountToInt(tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수에_정수를_입력하지_않은_경우() {
        String tryCount = "ab";
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.convertTryCountToInt(tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 우승자_가져오기_테스트() {
        // Arrange
        RacingGameService racingGameService = new RacingGameService();
        List<RacingCar> racingCars = new ArrayList<>();

        // 자동차 객체 생성
        RacingCar car1 = new RacingCar("pobi");
        RacingCar car2 = new RacingCar("woni");
        RacingCar car3 = new RacingCar("jun");

        // 자동차의 위치 설정
        car1.move(MOVING_FORWARD); // pobi의 위치 3
        car2.move(STOP); // woni의 위치 2
        car3.move(MOVING_FORWARD); // jun의 위치 3

        racingCars.add(car1);
        racingCars.add(car2);
        racingCars.add(car3);

        // Act
        List<RacingCar> winners = racingGameService.getWinners(racingCars);

        // Assert
        assertEquals(2, winners.size()); // pobi, jun이 우승자여야 하므로
        assertEquals("pobi", winners.get(0).getName()); // 첫 번째 우승자 확인
        assertEquals("jun", winners.get(1).getName()); // 두 번째 우승자 확인
    }

    @Test
    void 단일_우승자_테스트() {
        // Arrange
        RacingGameService racingGameService = new RacingGameService();
        List<RacingCar> racingCars = new ArrayList<>();

        // 자동차 객체 생성
        RacingCar car1 = new RacingCar("pobi");
        RacingCar car2 = new RacingCar("woni");

        // 자동차의 위치 설정
        car1.move(STOP); // pobi의 위치 2
        car2.move(MOVING_FORWARD); // woni의 위치 3

        racingCars.add(car1);
        racingCars.add(car2);

        // Act
        List<RacingCar> winners = racingGameService.getWinners(racingCars);

        // Assert
        assertEquals(1, winners.size()); // woni만 우승자여야 하므로
        assertEquals("woni", winners.get(0).getName()); // 우승자 확인
    }

    @Test
    void 동일한_위치의_자동차들_테스트() {
        // Arrange
        RacingGameService racingGameService = new RacingGameService();
        List<RacingCar> racingCars = new ArrayList<>();

        // 자동차 객체 생성
        RacingCar car1 = new RacingCar("pobi");
        RacingCar car2 = new RacingCar("woni");

        // 자동차의 위치 설정
        car1.move(MOVING_FORWARD); // pobi의 위치 4
        car2.move(MOVING_FORWARD); // woni의 위치 4

        racingCars.add(car1);
        racingCars.add(car2);

        // Act
        List<RacingCar> winners = racingGameService.getWinners(racingCars);

        // Assert
        assertEquals(2, winners.size()); // pobi와 woni 모두 우승자여야 하므로
        assertEquals("pobi", winners.get(0).getName()); // 첫 번째 우승자 확인
        assertEquals("woni", winners.get(1).getName()); // 두 번째 우승자 확인
    }

    @Override
    protected void runMain() {

    }
}
