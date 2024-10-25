package racingcar.service;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.global.error.Error.NAME_BLANK_EXCEPION;
import static racingcar.global.error.Error.NAME_LENGTH_EXCEPION;
import static racingcar.global.error.Error.TRY_COUNT_EXCEPION;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.MoveForwardRecord;
import racingcar.global.error.NameError;
import racingcar.global.error.TryCountError;
import racingcar.view.OutputView;

public class RacingService {

    private final String COMMA = ",";
    private final String COLON = " : ";
    private final String BAR = "-";
    private String POSITIVE_NUMBER_REG = "\\d+";
    private List<MoveForwardRecord> moveForwardRecords;

    public List<String> splitCarName(String input) {
        return Arrays.stream(input.split(COMMA)).collect(Collectors.toList());
    }

    public void validateCarName(List<String> carNames) {

        if (!validateNameNotNull(carNames)) {
            throw new NameError(NAME_BLANK_EXCEPION);
        }
        if (!validateNameLength(carNames)) {
            throw new NameError(NAME_LENGTH_EXCEPION);
        }
    }

    public void validateTryCount(String count) {

        if (!validatePositiveIntegerCount(count)) {
            throw new TryCountError(TRY_COUNT_EXCEPION);
        }
    }

    private boolean validateNameNotNull(List<String> carNames) {

        return carNames.stream().allMatch(name -> name != null && !name.isEmpty());
    }

    private boolean validateNameLength(List<String> carNames) {
        return carNames.stream().allMatch(name -> name.length() <= 5);
    }

    private boolean validatePositiveIntegerCount(String count) {
        if (count.matches(POSITIVE_NUMBER_REG)) {
            return Integer.parseInt(count) > 0;
        }
        return false;
    }

    public void go(String tryCounts) {

        OutputView.printMoveForwardResult();
        for (int i = 0; i < Integer.parseInt(tryCounts); i++) {
            updateMoveForwardRecord();
            printMoveForwardRecord();
        }

    }

    private boolean biggerThanThree(int num) {
        return num > 3;
    }

    public void setMoveForwardRecord(List<String> input) {
        moveForwardRecords = input.stream()
                .map(name -> new MoveForwardRecord(name, 0))
                .collect(Collectors.toList());
    }

    private void updateMoveForwardRecord() {
        moveForwardRecords.stream()
                .filter(record -> biggerThanThree(pickNumberInRange(0, 9)))
                .forEach(record -> record.updateGoCount());
    }

    private void printMoveForwardRecord() {
        moveForwardRecords.stream()
                .forEach(record -> System.out.println(record.getCarName() + COLON + BAR.repeat(record.getGoCount())));
        System.out.println();
    }

    public void printWinner() {
        countSortReverse();
        List<String> winners = getWinners();
        OutputView.printWinner(winners);
    }

    private void countSortReverse() {
        moveForwardRecords.stream().sorted((car1, car2) -> Integer.compare(car2.getGoCount(), car1.getGoCount()));
    }

    private List<String> getWinners() {
        int winnerCount = moveForwardRecords.get(0).getGoCount();

        return moveForwardRecords.stream().filter(record -> record.getGoCount() == winnerCount)
                .map(MoveForwardRecord::getCarName).collect(Collectors.toList());
    }
}
