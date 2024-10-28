package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.Utils.getNamesFromString;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String carNames = readLine();
        getNamesFromString(carNames);


    }
}
