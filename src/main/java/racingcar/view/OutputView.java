package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.model.cars.Cars;

public class OutputView {
    private static final String RESULT_BY_ROUND_SUBJECT_TEXT = "\n실행 결과";
    private static final String WINNER_SUBJECT_TEXT = "최종 우승자 : ";
    private static final String MOVE_FORWARD_SYMBOL = "-";

    private static OutputView instance;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }

    public void printResultByRound(Cars cars) {
        System.out.println(RESULT_BY_ROUND_SUBJECT_TEXT);
        Map<String, Integer> result = cars.getResult();
        for (String name : result.keySet()) {
            System.out.println(String.join(" : ", name, MOVE_FORWARD_SYMBOL.repeat(result.get(name))));
        }
        System.out.println();
    }

    public void printWinners(Cars cars) {
        List<String> winners = cars.findWinners();
        System.out.print(WINNER_SUBJECT_TEXT);
        System.out.println(String.join(", ", winners));
    }
}
