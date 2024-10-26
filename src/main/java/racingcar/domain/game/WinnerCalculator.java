package racingcar.domain.game;

import static racingcar.utils.ExceptionConstants.NO_PARTICIPANTS;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.CarInfo;

public class WinnerCalculator {
    private final GameRule gameRule;

    public WinnerCalculator(GameRule gameRule) {
        this.gameRule = gameRule;
    }

    public List<String> getWinnerNames(List<CarInfo> carInfos) {
        int maxPosition = getMaxPosition(carInfos);

        return carInfos.stream()
                .filter(carInfo -> gameRule.winCondition(carInfo.getCurrentPosition(), maxPosition))
                .map(CarInfo::getName)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<CarInfo> carInfos) {
        return carInfos.stream()
                .mapToInt(CarInfo::getCurrentPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException(NO_PARTICIPANTS.getErrorMessage()));
    }
}
