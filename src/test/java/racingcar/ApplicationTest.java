package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.persistence.InMemoryCarRacerRepository;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @AfterEach
    void tearDown() {
        InMemoryCarRacerRepository repository = InMemoryCarRacerRepository.getInstance();
        repository.clear();
    }

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

    @DisplayName("시도할 횟수를 숫자가 아닌 문자로 입력하였을 시 예외를 발생시킨다.")
    @Test
    void noNumberException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "s"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("시도할 횟수를 음수로 입력하였을 시 예외를 발생시킨다.")
    @Test
    void noPositiveNumberException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,java", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("자동차 이름이 비어있다면 예외를 발생시킨다.")
    @Test
    void blankNameException() {
        assertSimpleTest(() -> {
                    assertThatThrownBy(() -> runException(" ,java", "-1"))
                            .isInstanceOf(IllegalArgumentException.class);
                    assertThatThrownBy(() -> runException("java,", "-1"))
                            .isInstanceOf(IllegalArgumentException.class);
                    assertThatThrownBy(() -> runException(",java", "-1"))
                            .isInstanceOf(IllegalArgumentException.class);
                }
        );
    }

    @DisplayName("자동차 이름이 중복될 경우 예외를 발생시킨다.")
    @Test
    void duplicateNameException() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,pobi", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
