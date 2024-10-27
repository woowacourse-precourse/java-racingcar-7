package racingcar.service;

import java.util.List;
import racingcar.common.util.StringUtil;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.filter.RaceFilterChain;

public class RaceServiceImpl implements RaceService {
    private final RaceFilterChain raceFilterChain;

    public RaceServiceImpl(RaceFilterChain raceFilterChain) {
        this.raceFilterChain = raceFilterChain;
    }

    @Override
    public String startRace(RaceRequest request) {
        RaceResponse response = raceFilterChain.doFilter(request);
        List<String> winners = response.winners();
        return StringUtil.joinWithComma(winners);
    }
}
