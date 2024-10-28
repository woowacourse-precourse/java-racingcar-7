package racingcar.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ProgressedAmountRepository {

    private final Map<Round, List<ProgressedInformation>> scores = new HashMap<>();

    void save(final Round round, final ProgressedInformation carProgressedInfo) {
        final List<ProgressedInformation> progressedInformations = scores.getOrDefault(round, new ArrayList<>());
        progressedInformations.add(carProgressedInfo);
        scores.put(round, progressedInformations);
    }

    List<ProgressedInformation> findByRound(final Round round) {
        return scores.get(round);
    }
}
