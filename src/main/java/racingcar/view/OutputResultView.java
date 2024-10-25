package racingcar.view;

import java.util.List;

public class OutputResultView {

    private static final String RESULT_WINNER = "최종 우승자 : ";

    public static void outputResult(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.println(RESULT_WINNER + result);
    }

}
