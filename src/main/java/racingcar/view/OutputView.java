package racingcar.view;

import java.util.ArrayList;

public class OutputView {

    public void outputWinner(ArrayList<String> winners) {
        System.out.println(String.join(", ", winners));
    }
}
