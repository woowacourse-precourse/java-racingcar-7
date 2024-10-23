package racingcar.service;

import java.util.List;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.filter.RaceFilterChain;
import racingcar.util.StringUtil;

public class RaceServiceImpl implements RaceService {
    private final RaceFilterChain raceFilterChain;

    public RaceServiceImpl(RaceFilterChain raceFilterChain) {
        this.raceFilterChain = raceFilterChain;
    }

    @Override
    public String startRace(RaceRequest request) {
        RaceResponse response = new RaceResponse();
        raceFilterChain.doFilter(request, response);
        List<String> winners = response.winners();
        return StringUtil.joinWithComma(winners);
    }
}
