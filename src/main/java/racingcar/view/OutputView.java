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
    private static final int NONE_VISUAL_BAR = 0;

    public void printResult(CarRaceSnapshotDTOs carRaceSnapshotDTOs) {
        System.out.println(EXECUTION_RESULT_MESSAGE);

        for (CarRaceSnapshotDTO carRaceSnapshotDTO : carRaceSnapshotDTOs.carRaceSnapshotDTOs()) {
            printRaceSnapshot(carRaceSnapshotDTO);
        }
    }

    private void printRaceSnapshot(CarRaceSnapshotDTO carRaceSnapshotDTO) {
        List<String> carNames = carRaceSnapshotDTO.carNames();
        List<Integer> moveDistances = carRaceSnapshotDTO.moveDistances();

        for (int i = 0; i < carNames.size(); i++) {
            printCarMoveDistance(carNames.get(i), moveDistances.get(i));
        }
        System.out.println();
    }

    private void printCarMoveDistance(String carName, int moveDistance) {
        String visualBars = generateVisualBar(moveDistance);
        System.out.println(carName + CAR_MOVE_DISTANCE_FORMAT + visualBars);
    }

    private String generateVisualBar(int moveDistance) {
        return VISUAL_BAR_CHARACTER.repeat(Math.max(NONE_VISUAL_BAR, moveDistance));
    }

    public void printWinners(List<String> winners) {
        String formattedWinners = String.join(WINNER_SEPARATOR, winners);
        System.out.println(WINNERS_HEADER + formattedWinners);
    }
}
