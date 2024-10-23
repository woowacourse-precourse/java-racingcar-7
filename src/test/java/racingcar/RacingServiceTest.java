package racingcar;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class RacingServiceTest {


    private RacingService racingService;

    @BeforeEach
    void setUp() {
        racingService = new RacingService();
    }

    @Test
    @DisplayName("입력받은 여러 자동차를 구분자(,) 기준으로 추출")
    void 자동차_추출_테스트1() {
        String input = "aa,bb,cc";
        String[] result = racingService.convertCarInputToArray(input);
        assertThat(result).contains("aa", "bb", "cc");
    }

    @Test
    @DisplayName("입력받은 자동차가 한 대일 경우 추출")
    void 자동차_추출_테스트2() {
        String input = "aa";
        String[] result = racingService.convertCarInputToArray(input);
        assertThat(result).containsExactly("aa");
    }

    @Test
    @DisplayName("랜덤 값이 올바른 범위에 포함되는지 확인")
    void 랜덤_값_테스트() {
        int result = racingService.createRandomValue();
        assertThat(result).isBetween(0, 9);
    }
}

