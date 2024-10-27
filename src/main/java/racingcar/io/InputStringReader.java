package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import racingcar.AppConfig;

public class InputStringReader {

    private final AppConfig appConfig = AppConfig.getInstance();

    public String readCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분) : ");
        return Console.readLine();
    }

    public String readCount() {
        System.out.println("시도할 횟수는 몇 회인가요? : ");
        return Console.readLine();
    }
}
