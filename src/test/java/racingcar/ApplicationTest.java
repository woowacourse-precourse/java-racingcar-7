package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    // System.out 출력을 저장할 스트림
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    // System.out을 outputStream으로 재지정
    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStream));
    }

    // 테스트 후 출력을 System.out으로 복원
    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    // 기능 테스트: 올바른 자동차 이름과 시도 횟수
    @Test
    void 기능_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(outputStream.toString()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    // 예외 테스트 1: 자동차 이름이 5자를 초과
    @Test
    void 자동차이름_길이_예외_테스트() {
        run("pobi,woni,abcdefg", "1");
        assertThat(outputStream.toString()).contains("5자 이하의 이름을 입력해주세요.");
    }

    // 예외 테스트 2: 시도 횟수가 0 이하
    @Test
    void 시도횟수_음수_예외_테스트() {
        run("pobi,woni", "-2");
        assertThat(outputStream.toString()).contains("한 라운드 이상 게임을 진행해야 합니다.");
    }

    // 예외 테스트 3: 시도 횟수가 문자
    @Test
    void 시도횟수_문자_예외_테스트() {
        run("pobi,woni", "IV");
        assertThat(outputStream.toString()).contains("정수를 입력하세요.");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}