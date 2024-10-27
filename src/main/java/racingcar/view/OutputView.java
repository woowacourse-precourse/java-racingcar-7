package racingcar.view;

import java.util.List;
import racingcar.model.RacingCars;

public class OutputView {

    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String RESULT_SEPARATOR = " : ";
    private static final String MOVE_MARKER = "-";
    private static final String COMMA = ",";
    private static final String FINAL_WINNER = "최종 우승자 : ";
    private static final String NO_WINNER = "우승자가 없습니다.";

    public void printRaceStart() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRaceStatus(RacingCars racingCars) {
        racingCars.getCars().forEach(car -> printCarStatus(car.getName(), car.getPosition()));
        System.out.println();
    }

    private void printCarStatus(String name, int position) {
        String progress = MOVE_MARKER.repeat(position);
        System.out.println(name + RESULT_SEPARATOR + progress);
    }

    public void printWinners(List<String> names) {
        if (names == null || names.isEmpty()) {
            System.out.println(NO_WINNER);
            return;
        }
        String winners = String.join(COMMA, names);
        System.out.println(FINAL_WINNER + winners);
    }

}
