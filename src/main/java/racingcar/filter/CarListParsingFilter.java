package racingcar.filter;

import java.util.Arrays;
import java.util.List;
import racingcar.common.util.CarListCollector;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.exception.InvalidCarNameException;
import racingcar.model.CarList;
import racingcar.model.RacingCarProxy;

public class CarListParsingFilter implements Filter<RaceRequest, RaceResponse> {
    private static final String NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    @Override
    public RaceResponse doFilter(RaceRequest request, RaceFilterChain chain) {
        CarList carList = createCarListFromRequest(request.command());
        RaceRequest updatedRequest = request.withCarList(carList);
        return chain.doFilter(updatedRequest);
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
