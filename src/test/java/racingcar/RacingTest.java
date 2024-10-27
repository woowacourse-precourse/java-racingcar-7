package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.service.RacingService;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.List;


class RacingTest {
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("레이싱 한 라운드 수행 후 랜덤 값에 따른 출력 검증")
    void raceSingleRound() {
        // given
        RacingService racingService = new RacingService();
        List<Car> carList = List.of(new Car("hello"));

        // when
        racingService.raceSingleRound(carList);

        // then
        String output = outputStreamCaptor.toString().trim(); // 출력 결과를 문자열로 변환 후 공백 제거

        if (carList.getFirst().getPosition().equals(BigInteger.ZERO)) {
            assertThat(output).isEqualTo("hello :");
        }
        else {
            assertThat(output).isEqualTo("hello : -");
        }
    }
}