package racingcar.view;

import java.util.List;
import racingcar.dto.CarRaceSnapshotDTO;
import racingcar.dto.CarRaceSnapshotDTOs;

public class OutputView {
    private static final String EXECUTION_RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNERS_HEADER = "최종 우승자 : ";
    private static final String VISUAL_BAR_CHARACTER = "-";
    private static final String CAR_MOVE_DISTANCE_FORMAT = " : ";
    private static final String WINNER_SEPARATOR = ",";

    public void printResult(CarRaceSnapshotDTOs carRaceSnapshotDTOs) {
        System.out.println(EXECUTION_RESULT_MESSAGE);

        for (CarRaceSnapshotDTO carRaceSnapshotDTO : carRaceSnapshotDTOs.carRaceSnapshotDTOs()) {
            printRaceSnapshot(carRaceSnapshotDTO);
        }
    }

    private void printRaceSnapshot(CarRaceSnapshotDTO carRaceSnapshotDTO) {
        List<String> carNames = carRaceSnapshotDTO.carNames();
        List<Integer> moveDistances = carRaceSnapshotDTO.moveDistances();

        for (int j = 0; j < carNames.size(); j++) {
            printCarMoveDistance(carNames.get(j), moveDistances.get(j));
        }
        System.out.println();
    }

    private void printCarMoveDistance(String carName, int moveDistance) {
        String visualBars = generateVisualBar(moveDistance);
        System.out.println(carName + CAR_MOVE_DISTANCE_FORMAT + visualBars);
    }

    private String generateVisualBar(int moveDistance) {
        return VISUAL_BAR_CHARACTER.repeat(Math.max(0, moveDistance));
    }

    public void printWinners(List<String> winners) {
        String formattedWinners = String.join(WINNER_SEPARATOR, winners);
        System.out.println(WINNERS_HEADER + formattedWinners);
    }
}
