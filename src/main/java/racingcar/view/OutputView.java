package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.modle.vehicle.car.Car;

public class OutputView {
    private static final String GAME_RESULT = "실행 결과";
    private static final String MOVEMENT_GRAPH = "-";
    private static final String NU_SAME_LENGTH_MESSAGE = "두 리스트의 길이가 같아야 합니다.";
    private static final String REQUEST_PLAY_COUNT_MESSAGE = "시도할 횟수는 몇 회 인가요?.";
    private static final String WINNER = "최종 우승자 : ";

    public static void printWinner(List<String> winner) {
        if(winner.size() > 1){
            String winnerName = String.join(", ", winner);
            System.out.println(WINNER + winnerName);
        } else {
            System.out.println(WINNER + winner.get(0));
        }
    }

    public static void printResultMessage() {
        System.out.println(GAME_RESULT);
    }
    public static void requestPlayCount() {
        System.out.println(REQUEST_PLAY_COUNT_MESSAGE);
    }

    public static void printRoundMovementGraph(List<String> names, List<Integer> positions) {
        lsitToMap(names, positions)
                .forEach(OutputView::printPlayerMovementGraph);
        System.out.println();
    }

    private static void printPlayerMovementGraph(String name, int position) {
        System.out.println(name + " : " + MOVEMENT_GRAPH.repeat(position));
    }

    private static Map<String, Integer> lsitToMap(List<String> names, List<Integer> positions) {
        validateLength(names, positions);

        return IntStream.range(0, names.size())
                .boxed()
                .collect(Collectors.toMap(names::get, positions::get));
    }

    private static void validateLength(List<String> names, List<Integer> positions) {
        if(names.size() != positions.size()) {
            throw  new IllegalArgumentException(NU_SAME_LENGTH_MESSAGE);
        }
    }
}
