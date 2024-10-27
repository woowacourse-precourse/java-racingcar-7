package racingcar.service.dependency.random_maker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("DefaultRandomNumberMaker 테스트")
public class DefaultRandomNumberMakerTest {

    private final DefaultRandomNumberMaker defaultRandomNumberMaker = new DefaultRandomNumberMaker();

    @Test
    @DisplayName("makeRandomNumber() : 최대_최소_사이의_랜덤_숫자를_생성한다")
    void 최대_최소_사이의_랜덤_숫자를_생성한다() {

        // given
        int tryCount = 100;

        // when & then
        IntStream.range(0, tryCount).forEach(i -> {
            int randomNumber = defaultRandomNumberMaker.makeRandomNumber();
            assertThat(randomNumber).isBetween(defaultRandomNumberMaker.RANDOM_MIN, defaultRandomNumberMaker.RANDOM_MAX);
        });
    }
}
