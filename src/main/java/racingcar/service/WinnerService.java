package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.MoveForwardRecord;

public class WinnerService {

    public List<String> getWinners(List<MoveForwardRecord> moveForwardRecords) {
        int winnerCount = moveForwardRecords.get(0).getGoCount();

        return moveForwardRecords.stream().filter(record -> record.getGoCount() == winnerCount)
                .map(MoveForwardRecord::getCarName).collect(Collectors.toList());
    }

    public void countSortReverse(List<MoveForwardRecord> moveForwardRecords) {
        moveForwardRecords.sort((car1, car2) -> Integer.compare(car2.getGoCount(), car1.getGoCount()));
    }
}