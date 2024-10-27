package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import racingcar.Controller.Application;
import racingcar.Model.Car;
import racingcar.Service.RacingGame;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    void 공동_우승자_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,jun", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "jun : -", "최종 우승자 : pobi, woni, jun");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 시도_횟수_유효하지_않은_입력_예외_테스트() {
        assertThatThrownBy(() -> runException("pobi,woni", "0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(RacingGame.INVALID_ATTEMPT_COUNT_MESSAGE);
    }

    @Test
    void 예외_테스트() {
        assertThatThrownBy(() -> runException("pobi,javaji,tooLongName", "1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 문자열이거나 5자보다 길 수 없습니다.");
    }

    @Test
    void 자동차_이동_상태_확인_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "3");
                    String outputResult = output();
                    // 출력 결과에서 자동차의 현재 위치 확인
                    assertThat(outputResult).contains("pobi", "woni");
                    assertThat(outputResult).containsPattern("pobi : (-+)*"); // 차의 현재 위치가 '-'로 표현되어야 함
                    assertThat(outputResult).containsPattern("woni : (-+)*");
                },
                MOVING_FORWARD, STOP, MOVING_FORWARD
        );
    }

    private void runException(String carNames, String attempts) {
        // 자동차 이름을 생성하고 RacingGame 인스턴스를 생성
        List<Car> cars = List.of(carNames.split(",")).stream()
                .map(Car::new)
                .collect(Collectors.toList());

        // RacingGame의 인스턴스를 생성하고 startRace() 호출
        RacingGame racingGame = new RacingGame(cars, Integer.parseInt(attempts));
        racingGame.startRace(); // 예외가 발생해야 하는 부분
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
