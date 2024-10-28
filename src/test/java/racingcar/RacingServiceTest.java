package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService("a,b,c", "4");
    }

    @ParameterizedTest(name = "{3}")
    @CsvSource({
            "'aa,bb,cc', 3, 'cc', 입력받은 여러 자동차를 LinkedHashMap 으로 생성",
            "'aa', 1, 'aa', 입력받은 한 대의 자동차를 LinkedHashMap 으로 생성"
    })
    @DisplayName("자동차 이름 입력에 따라 LinkedHashMap이 올바르게 생성되는지 확인")
    void 자동차_추출_테스트(String carNameInput, int size, String carName, String description) {
        racingService.setCarNameInput(carNameInput);
        assertThat(racingService.getCarPositions()).hasSize(size);
        assertThat(racingService.getCarPositions().keySet()).contains(carName);
    }

    @Test
    @DisplayName("랜덤 값이 올바른 범위(0-9)에 있는지 확인")
    void 랜덤_값_테스트() {
        int result = racingService.createRandomValue();
        assertThat(result).isBetween(0, 9);
    }

    @ParameterizedTest(name = "{2}")
    @CsvSource({
            "5, 1, 전진 조건에 따른 이동해야 할 거리 확인",
            "1, 0, 정지 조건에 따른 이동해야 할 거리 확인"
    })
    @DisplayName("전진 및 정지 조건에 따른 이동 거리 계산이 올바른지 확인")
    void 이동_거리_테스트(int randomValue, int expected, String description) {
        int result = racingService.calculateMoveDistance(randomValue);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("자동차의 위치가 올바르게 변하는지 확인")
    void 자동차_위치_테스트() {
        int beforePosition = racingService.getCarPositions().get("a");
        racingService.moveCar("a", 4);

        assertThat(racingService.getCarPositions().get("a")).isGreaterThan(beforePosition);
    }

    @Test
    @DisplayName("최대 이동 거리를 가진 한 명의 사람을 우승자로 올바르게 반환하는지 확인")
    void 한_명의_우승자_테스트() {
        racingService.moveCar("a", 4);
        racingService.moveCar("b", 2);
        racingService.moveCar("c", 1);

        String[] result = racingService.getWinners();
        assertThat(result).containsExactly("a");
    }

    @Test
    @DisplayName("최대 이동 거리를 가진 여러 명의 사람을 우승자로 올바르게 반환하는지 확인")
    void 여러_명의_우승자_테스트() {
        racingService.moveCar("a", 4);
        racingService.moveCar("b", 8);
        racingService.moveCar("c", 1);

        String[] result = racingService.getWinners();
        assertThat(result).containsExactly("a", "b");
    }

    @Test
    @DisplayName("입력받은 시도 횟수만큼 턴이 수행되는지 확인")
    void 시도_횟수_확인_테스트() {
        racingService.startRace();
        int result = racingService.currentTurn;

        assertThat(result).isEqualTo(4);
    }
}

