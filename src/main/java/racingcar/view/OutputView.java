package racingcar.view;

import java.util.List;
import racingcar.dto.CarDto;

public class OutputView {

    private static final String RUN_RESULT_MESSAGE = "실행 결과";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : ";
    private static final String DISTANCE_MARK = "-";
    private static final int IF_DONT_MOVE = 0;

    public void printRunResultMessage() {
        lineAlignment();
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public void lineAlignment() {
        System.out.println();
    }

    public void printCarMoveDistance(final CarDto carDto) {
        System.out.println(carDto.name() + " : " +
                generateDistanceString(carDto.distance()));
    }

    public void printFinalWinner(final List<String> finalWinner) {
        System.out.print(FINAL_WINNER_MESSAGE);
        System.out.println(String.join(", ", finalWinner));
    }

    private String generateDistanceString(final int distance) {

        return DISTANCE_MARK.repeat(Math.max(IF_DONT_MOVE, distance));
    }
}
