package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.HashMap;

public class Input {

    public HashMap<String,Integer> getCarNames() {
        String[] input = readLine().split(",");
        HashMap<String,Integer> carNames = new HashMap<>();
        Arrays.stream(input).forEach(s->carNames.put(s, 0));
        return carNames;
    }

    public int getAttemptedNumber() {
        return Integer.parseInt(readLine());
    }

}
