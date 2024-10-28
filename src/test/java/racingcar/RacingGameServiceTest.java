package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.model.CarDto;
import racingcar.model.CarService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingGameServiceTest {
    List<CarDto> winners=new ArrayList<>();

    @BeforeEach
    void setUp() {
        winners.add(new CarDto());
        winners.add(new CarDto());
    }

    @Test
    void isWinnerSameName() {
        assertTrue(isWinnersSameName());
    }


    private Boolean isWinnersSameName() {
        Map<String, Long> nameCollect = winners.stream()
                .collect(Collectors.groupingBy(CarDto::getName, Collectors.counting()));

        return nameCollect.values().stream().anyMatch(count -> count > 1);
    }

}
