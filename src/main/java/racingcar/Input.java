package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Input {

    public List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        return splitCarNames(inputCarNames);
    }

    public String getGameCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }

    public static List<String> splitCarNames(String inputCarNames){
        return List.of(inputCarNames.split(","));
    }
}
