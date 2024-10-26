package racingcar.dto;

import java.util.List;
import java.util.stream.Collectors;

public record CarMoveCountDto(String name, int moveCount) {

    public static List<String> getCollectNameWithSameMoveCount(List<CarMoveCountDto> carMoveCountDtoList, int maxMoveCount) {
        return carMoveCountDtoList.stream()
                .filter(carMoveCountDto -> carMoveCountDto.moveCount() == maxMoveCount)
                .map(CarMoveCountDto::name)
                .collect(Collectors.toList());
    }

    public static int getMaxMoveCount(List<CarMoveCountDto> carMoveCountDtoList) {
        int maxMoveCount = carMoveCountDtoList.stream()
                .mapToInt(CarMoveCountDto :: moveCount)
                .max()
                .orElse(0);
        return maxMoveCount;
    }
}
