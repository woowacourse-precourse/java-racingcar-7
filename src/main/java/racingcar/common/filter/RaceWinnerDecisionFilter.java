package racingcar.common.filter;

import java.util.List;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.model.RacingCar;
import racingcar.model.RacingCarList;

public class RaceWinnerDecisionFilter implements Filter<RaceRequest, RaceResponse> {

    @Override
    public RaceResponse doFilter(RaceRequest request, RaceFilterChain filterChain) {
        RacingCarList racingCarList = request.racingCarList();
        List<String> winners = getWinners(racingCarList);
        return new RaceResponse(winners);
    }

    private List<String> getWinners(RacingCarList cars) {
        int maxDistance = cars.getMaxDistance();
        return cars.getCars().stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(RacingCar::getName)
                .toList();
    }
}
