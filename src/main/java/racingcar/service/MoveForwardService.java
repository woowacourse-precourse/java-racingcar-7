package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.MoveForwardRecord;

public class MoveForwardService {
    private List<MoveForwardRecord> moveForwardRecords;

    public void setMoveForwardRecord(List<String> input) {
        moveForwardRecords = input.stream()
                .map(name -> new MoveForwardRecord(name, 0))
                .collect(Collectors.toList());
    }

    public List<MoveForwardRecord> getMoveForwardRecords() {
        return moveForwardRecords;
    }
}