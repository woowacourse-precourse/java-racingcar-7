package racingcar.common.filter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import racingcar.common.exception.DuplicateCarNameException;
import racingcar.common.exception.InvalidCarNameException;
import racingcar.common.util.CarListCollector;
import racingcar.dto.RaceRequest;
import racingcar.dto.RaceResponse;
import racingcar.model.RacingCarList;
import racingcar.model.RacingCarProxy;

public class RacingCarListParsingFilter implements Filter<RaceRequest, RaceResponse> {
    private static final String NAME_DELIMITER = ",";
    private static final int MAX_CAR_NAME_LENGTH = 5;

    @Override
    public RaceResponse doFilter(RaceRequest request, RaceFilterChain chain) {
        RacingCarList racingCarList = createCarListFromRequest(request.command());
        RaceRequest updatedRequest = request.withCarList(racingCarList);
        return chain.doFilter(updatedRequest);
    }

    private RacingCarList createCarListFromRequest(String carNamesExpression) {
        List<String> carNames = parseCarNames(carNamesExpression);
        validateCarNames(carNames); // 유효성 검사 및 중복 체크
        return carNames.stream()
                .map(RacingCarProxy::create)
                .collect(CarListCollector.toCarList());
    }

    private List<String> parseCarNames(String expression) {
        return Arrays.stream(expression.split(NAME_DELIMITER))
                .map(String::trim)
                .toList();
    }

    private void validateCarNames(List<String> carNames) {
        HashSet<String> uniqueNames = new HashSet<>();
        for (String name : carNames) {
            if (name.length() > MAX_CAR_NAME_LENGTH) {
                throw new InvalidCarNameException();
            }
            if (!uniqueNames.add(name)) {
                throw new DuplicateCarNameException(); // 중복 예외 발생
            }
        }
    }
}
