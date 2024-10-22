package racingcar.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberTest {

    @Test
    @DisplayName("0 ~ 9 까지 범위의 난수 생성")
    void createRandomNumber() {
        // given
        Map<Integer, Integer> map = new HashMap<>();

        // when
        IntStream.range(0, 1000).forEach(i -> {
            int randomNumber = RandomNumber.pick();
            map.put(randomNumber, map.getOrDefault(randomNumber, 0) + 1);
        });

        // then
        assertThat(map).hasSize(10);
        System.out.println(map);
    }
}