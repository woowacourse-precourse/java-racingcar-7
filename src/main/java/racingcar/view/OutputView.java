package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import racingcar.model.Car;

public class OutputView {

    private static String getDistanceVisual(int distance) {
        StringBuilder visual = new StringBuilder();
        for (int i = 0; i < distance; i++) {
            visual.append("-");
        }
        return visual.toString();
    }

}
