package racingcar.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Set;
import org.junit.jupiter.api.Test;
import racingcar.Application;

class RacingCarServiceTest extends NsTest{

    GameSetup racingCarService = new GameSetup();

    @Test
    void 자동차_이름_5자_초과_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarService.splitCarName("jijijiji, coco"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 5자 이하로 입력해 주세요.")
        );
    }

    @Test
    void 자동차_이름_중복_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> racingCarService.splitCarName("jiji, jiji"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("자동차 이름은 중복될 수 없습니다.")
        );
    }

    @Test
    void 문자열_분리_테스트() {
        String carNameList = "jiji, kiki , didi";
        Set<String> carNames = racingCarService.splitCarName(carNameList);

        assertThat(carNames).hasSize(3);
        assertThat(carNames).containsExactlyInAnyOrder("jiji", "kiki", "didi");
    }

    @Test
    void 횟수_문자열_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "one"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("게임 횟수는 양수를 입력해 주세요.")
        );
    }

    @Test
    void 횟수_0_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("게임 횟수는 양수를 입력해 주세요.")
        );
    }

    @Test
    void 횟수_음수_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining("게임 횟수는 양수를 입력해 주세요.")
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
