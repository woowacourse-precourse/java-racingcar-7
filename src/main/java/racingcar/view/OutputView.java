package racingcar.view;

import java.util.ArrayList;

public class OutputView {

    public String outputWinner(ArrayList<String> winners) {
        return String.join(", ", winners);
    }
}
