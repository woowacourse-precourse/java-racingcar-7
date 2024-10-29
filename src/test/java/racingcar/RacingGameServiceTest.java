package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.CarDto;

import java.util.*;
import java.util.stream.Collectors;

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
