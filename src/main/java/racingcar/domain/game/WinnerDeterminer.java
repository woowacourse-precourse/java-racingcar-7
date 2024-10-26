package racingcar.domain.game;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.car.CarInfo;

public class WinnerDeterminer {
    private final GameRule gameRule;

    public WinnerDeterminer(GameRule gameRule) {
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
                .orElseThrow(() -> new IllegalArgumentException("참가자가 없습니다."));
    }
}
