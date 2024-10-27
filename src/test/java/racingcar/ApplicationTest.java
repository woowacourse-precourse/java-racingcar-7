package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.controller.RaceController;
import racingcar.domain.Car;
import racingcar.model.Race;
import racingcar.view.RaceView;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private Race race;
    private RaceView raceView;
    private RaceController raceController;

    @BeforeEach
    void setUp() {
        raceView = new RaceView();
        raceController = new RaceController();
    }

    // 기능 목록 작동 테스트

    @Test
    void 자동차_객체_생성_테스트() {
        // 자동차 객체 생성
        Car car = new Car("yong");
        assertThat(car.getCarName()).isEqualTo("yong");
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    void 전진_조건_검증_테스트() {
        Car car = new Car("yong");
        car.forwardIfAboveFour(MOVING_FORWARD);
        assertThat(car.getDistance()).isEqualTo(1); // 4 이상일 때 전진

        car.forwardIfAboveFour(STOP);
        assertThat(car.getDistance()).isEqualTo(1); // 3 이하일 때 멈춤
    }

    @Test
    void 우승자_선정_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("yong"));
        cars.add(new Car("chang"));
        cars.add(new Car("si"));

        race = new Race(cars);
        race.getCars().get(0).forwardIfAboveFour(MOVING_FORWARD);   // yong 전진
        race.getCars().get(2).forwardIfAboveFour(MOVING_FORWARD);   // si 전진

        List<Car> winners = race.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("carName").containsExactlyInAnyOrder("yong", "si");
    }

    @Test
    void 자동차_이름_입력_검증_테스트() {
        // 정상 입력
        String validInput = "yong,chang,si";
        assertThatCode(() -> raceView.inputCarsName(validInput))
                .doesNotThrowAnyException();

        // 5글자 초과 이름 입력
        String longNameInput = "yongyongyongyong,chang,si";
        assertThatThrownBy(() -> raceView.inputCarsName(longNameInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 형식이 올바르지 않습니다.");

        // 빈 이름 포함된 입력 테스트
        String invalidInput = "yong,,si";
        assertThatThrownBy(() -> raceView.inputCarsName(invalidInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 형식이 올바르지 않습니다.");

        String emptyInput = "yong, ,si";
        assertThatThrownBy(() -> raceView.inputCarsName(emptyInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름 형식이 올바르지 않습니다.");

        // 중복된 이름 포함된 입력 테스트
        String duplicateInput = "yong,chang,yong";
        assertThatThrownBy(() -> raceView.inputCarsName(duplicateInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되는 자동차 이름이 존재합니다.");
    }

    @Test
    void 이동_횟수_검증_테스트() {
        // 정상적인 입력 테스트
        String validTryCount = "5";
        assertThatCode(() -> raceView.inputTryTime(validTryCount))
                .doesNotThrowAnyException();

        // 음수 입력 테스트
        String negativeTryCount = "-1";
        assertThatThrownBy(() -> raceView.inputTryTime(negativeTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");

        // 0 입력 테스트
        String zeroTryCount = "0";
        assertThatThrownBy(() -> raceView.inputTryTime(zeroTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("시도 횟수는 1 이상이어야 합니다.");

        // 숫자가 아닌 입력 테스트
        String nonNumericTryCount = "abc";
        assertThatThrownBy(() -> raceView.inputTryTime(nonNumericTryCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자를 입력해주세요");
    }

    @Test
    void 레이스_결과_출력_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("yong"));
        cars.add(new Car("chang"));
        race = new Race(cars);

        // 두 번의 레이스 진행
        race.runRace();
        race.runRace();

        // 결과 출력 검증
        assertThat(race.getCars()).hasSize(2);
        for (Car car : race.getCars()) {
            // 2번의 전진을 했으므로 최대 거리는 2
            assertThat(car.getDistance()).isBetween(0, 2);
        }
    }

    @Test
    void 레이스_우승자_출력_테스트() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("yong"));
        cars.add(new Car("chang"));
        cars.add(new Car("si"));
        race = new Race(cars);

        race.getCars().get(0).forwardIfAboveFour(MOVING_FORWARD); // yong 전진
        race.getCars().get(1).forwardIfAboveFour(MOVING_FORWARD); // chang 전진
        race.getCars().get(2).forwardIfAboveFour(STOP); // si 멈춤

        List<Car> winners = race.getWinners();
        assertThat(winners).hasSize(2);
        assertThat(winners).extracting("carName").containsExactlyInAnyOrder("yong", "chang");
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


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
