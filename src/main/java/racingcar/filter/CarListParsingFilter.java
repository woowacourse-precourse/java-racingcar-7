package racingcar.filter;

import java.util.Arrays;
import java.util.List;
import racingcar.collector.CarListCollector;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.exception.InvalidCarNameException;
import racingcar.model.CarList;
import racingcar.model.RacingCarProxy;

public class CarListParsingFilter implements Filter<RaceRequest, RaceResponse> {
    private static final String NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    @Override
    public void doFilter(RaceRequest request, RaceResponse raceResponse, RaceFilterChain chain) {
        CarList carList = createCarListFromRequest(request.getCommand());
        RaceRequest updatedRequest = request.withCarList(carList);
        chain.doFilter(updatedRequest, raceResponse);
    }

    private CarList createCarListFromRequest(String carNamesExpression) {
        List<String> carNames = parseCarNames(carNamesExpression);
        return carNames.stream()
                .map(RacingCarProxy::create)
                .collect(CarListCollector.toCarList());
    }

    private List<String> parseCarNames(String expression) {
        return Arrays.stream(expression.split(NAME_DELIMITER))
                .map(String::trim)
                .filter(this::isValidCarName)
                .toList();
    }

    private boolean isValidCarName(String name) {
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new InvalidCarNameException();
        }
        return true;
    }
}
