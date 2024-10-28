package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> getNames(){
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(","));
        return names;
    }

    public String getTotalTtyCnt(){
        String totalTryCnt = Console.readLine();
        return totalTryCnt;
    }
}
