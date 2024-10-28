package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Utils.*;

public class Application {
    public static void main(String[] args) {
        String carNames = readLine();
        getNamesFromString(carNames);

        String tryCount = readLine();
        getTryCountFromString(tryCount);
    }
}
