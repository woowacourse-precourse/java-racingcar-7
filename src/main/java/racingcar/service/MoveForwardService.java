package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.MoveForwardRecord;
import racingcar.view.OutputView;

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

    public void printMovingForwardProcess(String tryingCount) {
        OutputView.printMoveForwardResult();

        for (int i = 0; i < Integer.parseInt(tryingCount); i++) {
            increaseMoveForwardCount();
            moveForwardRecords.stream().map(MoveForwardRecord::getGoCount).forEach(System.out::println);
            OutputView.printMoveForwardRecord(moveForwardRecords);
            System.out.println();
        }
    }

    private void increaseMoveForwardCount() {
        moveForwardRecords.stream()
                .forEach(moveForwardRecord -> moveForwardRecord.updateGoCount(pickNumberInRange(0, 9)));
    }

}