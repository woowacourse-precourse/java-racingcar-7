package racingcar.controller;

import java.util.List;
import java.util.Map;

public record RaceResultDTO(
        List<String> winner,
        Map<Integer, List<CarDTO>> raceProcedure
) {
}