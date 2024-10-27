package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class ProgressedAmountRepository {

    private final Map<Round, List<ProgressedInformation>> scores = new TreeMap<>();

    void save(final Round round, final ProgressedInformation carProgressedInfo) {
        final List<ProgressedInformation> progressedInformations = scores.getOrDefault(round, new ArrayList<>());
        progressedInformations.add(carProgressedInfo);
        scores.put(round, progressedInformations);
    }
}
