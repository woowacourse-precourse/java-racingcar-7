package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public List<String> getCarNames() {
        String[] carNames = Console.readLine().split(",");

        return Arrays.stream(carNames)
            .map(String::trim)
            .collect(Collectors.toList());
    }

    public int getTryNum() {
        int tryNum = Integer.parseInt(Console.readLine());
        return tryNum;
    }
}
