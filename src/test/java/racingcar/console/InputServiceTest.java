package racingcar.console;

import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputServiceTest {
    private InputService inputService;

    @BeforeEach
    void setUp() {
        inputService = InputService.init();
    }

    @AfterEach
    void clear() {
        Console.close();
    }

    private void setInput(final String input) {
        final var inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    @Test
    void 올바른_경기_참여자_입력값은_racing_car_list_생성에_성공할_것이다() {
        setInput("Alice,Bob");

        final var racingCarList = inputService.readRacingCarList();
        assertAll(
            () -> Assertions.assertThat(racingCarList).isNotNull()
        );
    }

    @Test
    void 올바른_입력값은_총_바큇수_객체_생성에_성공할_것이다() {
        setInput("3");

        final var totalLaps = inputService.readTotalLaps();

        assertAll(
            () -> assertThat(totalLaps).isNotNull(),
            () -> {
                assert totalLaps != null;
                assertThat(totalLaps.count()).isEqualTo(3L);
            }
        );
    }
}