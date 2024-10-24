package racingcar.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingServiceTest {

    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService(() -> true); // 무조건 움직임
    }

    @Test
    @DisplayName("getRacingResult 메서드를 호출하면 예상한 결과를 반환한다.")
    void getRacingResult() {
        String result = racingService.getRacingResult("car1,car2", "3");
        String expected = """
           car1 : -
           car2 : -

           car1 : --
           car2 : --

           car1 : ---
           car2 : ---

           최종 우승자 : car1, car2""";

        Assertions.assertThat(result.trim()).isEqualTo(expected);
    }
}