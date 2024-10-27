package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.RaceInfo;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public RaceInfo getRaceInfo(){
        String input = Console.readLine();
        List<String> names = Arrays.asList(input.split(","));
        String totalTryCnt = Console.readLine();

        return new RaceInfo(names, totalTryCnt);
    }
}
