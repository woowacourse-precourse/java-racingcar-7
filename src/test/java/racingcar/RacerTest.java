package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Racer;
import racingcar.service.AcceleratorService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacerTest {

    @Test
    @DisplayName("Racer 인스턴스 생성 테스트 - 유효한 자동차 이름")
    void createRacer_withValidCarNames() {
        Racer racer = Racer.of("car1,car2,car3");
        assertThat(racer).isNotNull();
    }

    @Test
    @DisplayName("Racer 인스턴스 생성 테스트 - 중복된 자동차 이름 입력 시 예외 발생")
    void createRacer_withDuplicateNames_throwsException() {
        assertThrows(IllegalArgumentException.class, () -> Racer.of("car1,car1,car2"));
    }

    @Test
    @DisplayName("Racer의 플레이 기능 테스트")
    void play_withAcceleratorService() {
        AcceleratorService accelerator = new AcceleratorService(() -> 5); // 항상 이동 가능한 경우
        Racer racer = Racer.of("car1,car2");

        racer.play(accelerator);
        String intermediateResult = racer.getResult().middleResult();

        assertThat(intermediateResult).contains("car1 : -", "car2 : -");
    }


    @Test
    @DisplayName("최종 우승자 결정 테스트")
    void getWinner() {
        AcceleratorService accelerator = new AcceleratorService(() -> 5);
        Racer racer = Racer.of("car1,car2");
        racer.play(accelerator);
        assertThat(racer.getWinner().finalResult()).contains("car1", "car2");
    }
}
