package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    public List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String input= Console.readLine();
        return Arrays.asList(input.split(","));
    }
    public int getRaceCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceCount=Console.readLine();
        return Integer.parseInt(raceCount);
    }
}
