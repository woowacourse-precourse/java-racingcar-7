package racingcar.serviceTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.exception.ExceptionMessage;
import racingcar.service.SplitService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SplitServiceTest {
    private SplitService splitService;

    @BeforeEach
    void setUp() {
        splitService = SplitService.getInstance();
    }

    @Test
    @DisplayName("정상적인 이름 분리 테스트")
    void splitValidNames() {
        List<String> result = splitService.splitNames("pobi,woni,jun");

        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("pobi", result.get(0));
        Assertions.assertEquals("woni", result.get(1));
        Assertions.assertEquals("jun", result.get(2));
    }

    @Test
    @DisplayName("쉼표 형식 오류 테스트")
    void invalidCommaFormat() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                splitService.splitNames("pobi,,woni")
        );
        Assertions.assertEquals(ExceptionMessage.INVALID_NAME_FORMAT, exception.getMessage());
    }

    @Test
    @DisplayName("이름 길이 초과 테스트")
    void invalidNameLength() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                splitService.splitNames("pobi,woniiii,jun")
        );
        Assertions.assertEquals(ExceptionMessage.NAME_LENGTH_OVER, exception.getMessage());
    }

    @Test
    @DisplayName("자동차 수 초과 테스트")
    void invalidCarCount() {
        String names = IntStream.rangeClosed(1, 101)
                .mapToObj(i -> "c" + i)
                .collect(Collectors.joining(","));

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                splitService.splitNames(names)
        );
        Assertions.assertEquals(ExceptionMessage.CAR_COUNT_OVER, exception.getMessage());
    }

    @Test
    @DisplayName("중복 이름 확인 테스트")
    void checkDuplicateNames() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                splitService.splitNames("pobi,woni,pobi")
        );
        Assertions.assertEquals(ExceptionMessage.DUPLICATE_NAME, exception.getMessage());
    }
}