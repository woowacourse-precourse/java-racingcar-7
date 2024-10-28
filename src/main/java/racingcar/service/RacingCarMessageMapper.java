package racingcar.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import racingcar.domain.car.Name;
import racingcar.domain.racing.Result;
import racingcar.domain.racing.Results;
import racingcar.dto.RacingCarResponse;

public final class RacingCarMessageMapper {

    private RacingCarMessageMapper() {}

    public static RacingCarResponse toResponse(final Results results, final List<Name> winners) {
        List<Map<String, Integer>> racingResults = toRacingResults(results);

        List<String> winnerNames = winners.stream()
                .map(Name::value)
                .toList();

        return new RacingCarResponse(racingResults, winnerNames);
    }

    private static List<Map<String, Integer>> toRacingResults(final Results results) {
        List<Map<String, Integer>> racingResults = new ArrayList<>();
        for (Result result : results.getResults()) {
            racingResults.add(toRacingResult(result));
        }
        return racingResults;
    }

    private static Map<String, Integer> toRacingResult(final Result result) {
        Map<String, Integer> racingResults = new LinkedHashMap<>();
        result.getResult()
                .forEach((name, position) -> racingResults.put(name.value(), position.value()));
        return racingResults;
    }

}
