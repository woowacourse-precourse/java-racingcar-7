package racingcar.filter;

import java.util.List;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.model.CarList;
import racingcar.model.Drivable;

public class RaceWinnerDecisionFilter implements Filter<RaceRequest, RaceResponse> {

    @Override
    public RaceResponse doFilter(RaceRequest request, RaceFilterChain filterChain) {
        CarList carList = request.carList();
        List<String> winners = getWinners(carList);
        return new RaceResponse(winners);
    }

    private List<String> getWinners(CarList cars) {
        int maxDistance = cars.getMaxDistance();
        return cars.getCars().stream().filter(car -> car.getDistance() == maxDistance).map(Drivable::getName).toList();
    }
}
