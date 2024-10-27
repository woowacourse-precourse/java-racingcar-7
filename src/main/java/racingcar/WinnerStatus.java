package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerStatus {
    private List<CarStatus> carStatusList;

    public WinnerStatus(List<CarStatus> carStatusList) {
        this.carStatusList = carStatusList;
    }

    public List<String> getWinners() {
        int maxPosition = carStatusList.stream()
                .mapToInt(CarStatus::getPosition)
                .max()
                .orElse(0);

        return carStatusList.stream()
                .filter(carStatus -> carStatus.getPosition() == maxPosition)
                .map(CarStatus::getName)
                .collect(Collectors.toList());
    }
}
