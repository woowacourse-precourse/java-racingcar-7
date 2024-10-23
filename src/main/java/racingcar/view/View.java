package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Utils;

public class View {

    public String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        Console.close();
        String names = input.replace(" ", "");
        Utils.validateNames(names);
        return names.split(",");
    }

    public int inputTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String times = Console.readLine();
        Console.close();
        return Utils.parseNumber(times);
    }

}
