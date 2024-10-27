package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService("a,b,c", "4");
    }

    @Test
    @DisplayName("입력받은 여러 자동차를 구분자(,) 기준으로 추출하여 HashMap 으로 생성")
    void 자동차_추출_테스트1() {
        String input = "aa,bb,cc";
        racingService.setCarNameInput(input);
        assertThat(racingService.getCarMap()).hasSize(3);
        assertThat(racingService.getCarMap().keySet()).contains("cc");
    }

    @Test
    @DisplayName("입력받은 자동차가 한 대일 경우 추출하여 HashMap 으로 생성")
    void 자동차_추출_테스트2() {
        String input = "aa";
        racingService.setCarNameInput(input);
        assertThat(racingService.getCarMap()).hasSize(1);
        assertThat(racingService.getCarMap().keySet()).contains("aa");
    }

    @Test
    @DisplayName("랜덤 값이 올바른 범위에 포함되는지 확인")
    void 랜덤_값_테스트() {
        int result = racingService.createRandomValue();
        assertThat(result).isBetween(0, 9);
    }

    @Test
    @DisplayName("전진 조건에 따른 이동해야 할 거리가 맞는지 확인")
    void 이동_거리_테스트1() {
        int result = racingService.decideMovement(5);
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("정지 조건에 따른 이동해야 할 거리가 맞는지 확인")
    void 이동_거리_테스트2() {
        int result = racingService.decideMovement(1);
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차의 위치가 올바르게 변하는지 확인")
    void 자동차_위치_테스트() {
        int beforePosition = racingService.getCarMap().get("a");
        racingService.updateMovement("a", 4);
        assertThat(racingService.getCarMap().get("a")).isGreaterThan(beforePosition);
    }

    @Test
    @DisplayName("최대 이동 거리를 가진 한 명의 사람을 우승자로 알려주는지 확인")
    void 우승자_확인_테스트1() {
        racingService.updateMovement("a", 4);
        racingService.updateMovement("a", 4);
        racingService.updateMovement("a", 4);

        racingService.updateMovement("b", 2);
        racingService.updateMovement("c", 1);

        String[] result = racingService.getWinners();
        assertThat(result).containsExactly("a");
    }

    @Test
    @DisplayName("최대 이동 거리를 가진 여러 명의 사람을 우승자로 알려주는지 확인")
    void 우승자_확인_테스트2() {
        racingService.updateMovement("a", 4);
        racingService.updateMovement("a", 4);

        racingService.updateMovement("b", 8);
        racingService.updateMovement("b", 8);

        racingService.updateMovement("c", 1);

        String[] result = racingService.getWinners();
        assertThat(result).contains("a");
        assertThat(result).contains("b");
    }

    @Test
    @DisplayName("입력받은 시도 횟수만큼 턴을 수행하는지 확인")
    void 시도_횟수_확인_테스트() {
        racingService.startRaceGame();
        int result = racingService.executionCount;
        assertThat(result).isEqualTo(4);
    }
}

