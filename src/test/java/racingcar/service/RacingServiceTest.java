package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingServiceTest extends NsTest {

    private RacingGameService racingGameService;

    @BeforeEach
    void setUp() {
        racingGameService = new RacingGameService();
    }
    @Test
    void 자동차_이름이_정상적으로_입력된_경우_1(){
        String carNames = "pobi,woni";
        Integer tryCount = 3;
        Assertions.assertDoesNotThrow(() -> racingGameService.initializeRacingGame(carNames, tryCount));
    }

    @Test
    void 자동차_이름이_정상적으로_입력된_경우_2(){
        String carNames = "pobi,   woni";
        Integer tryCount = 3;
        Assertions.assertDoesNotThrow(() -> racingGameService.initializeRacingGame(carNames, tryCount));
    }
    @Test
    void 자동차_이름이_비어_있는_입력된_경우_1(){
        String carNames = "";
        Integer tryCount = 3;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.initializeRacingGame(carNames, tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 자동차_이름이_비어_있는_입력된_경우_2(){
        String carNames = "woni, ";
        Integer tryCount = 3;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.initializeRacingGame(carNames, tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 동일한_이름이_중복되어_입력된_경우(){
        String carNames = "pobi,pobi";
        Integer tryCount = 3;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.initializeRacingGame(carNames, tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 다섯자_이상의_자동차_이름이_입력된_경우(){
        String carNames = "abceda,pobi";
        Integer tryCount = 3;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.initializeRacingGame(carNames, tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도_횟수가_0인_경우(){
        String carNames = "pobi,wani";
        Integer tryCount = 0;
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingGameService.initializeRacingGame(carNames, tryCount))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {

    }
}
