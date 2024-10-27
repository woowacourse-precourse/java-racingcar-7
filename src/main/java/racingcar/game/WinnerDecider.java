package racingcar.game;

import racingcar.data.GameData;
import racingcar.data.RoundData;
import racingcar.dto.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerDecider {
    public List<Car> decideWinner(GameData gameData) {
        List<RoundData> roundDataList = gameData.getRoundData();
        RoundData roundData = roundDataList.get(roundDataList.size()-1);
        List<Car> result = roundData.getResult();

        int maxCount = getMaxCount(result);
        return result.stream()
                .filter(car -> car.getMoveCount() == maxCount)
                .collect(Collectors.toList());
    }

    private int getMaxCount(List<Car> result) {
        return result.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
