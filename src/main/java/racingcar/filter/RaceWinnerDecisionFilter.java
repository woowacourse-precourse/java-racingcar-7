package racingcar.filter;

import java.util.List;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.model.CarList;
import racingcar.model.Drivable;

public class RaceWinnerDecisionFilter implements Filter<RaceRequest, RaceResponse> {

    @Override
    public void doFilter(RaceRequest request, RaceResponse response, RaceFilterChain filterChain) {
        CarList carList = request.getCarList();
        List<String> winners = getWinners(carList);
        response.updateWinners(winners);
        filterChain.doFilter(request, response);
    }

    private List<String> getWinners(CarList cars) {
        int maxDistance = cars.getMaxDistance();
        return cars.getCars().stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Drivable::getName)
                .toList();
    }
}
