package racingcar.view;


public class OutputView {
    private static final String MOVE_EXPRESS = "-";
    private static final String CAR_POSITION_FORMAT = "%s : %s";

    private static void printCarPosition(String name, int distance) {
        String position = generateMoveExpression(distance);
        System.out.println(String.format(CAR_POSITION_FORMAT, name, position));
    }

    private static String generateMoveExpression(int distance) {
        return MOVE_EXPRESS.repeat(distance);
    }
}
