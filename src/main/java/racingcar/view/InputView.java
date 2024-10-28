package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import racingcar.util.InputParser;

public class InputView {
    public static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameString = readLine();
        return InputParser.nameParse(nameString);
    }

    public static int getTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String numberString = readLine();
        System.out.println(); // 기능요구 사항에 따른 줄바꿈 용도
        return InputParser.tryNumberParse(numberString);
    }
}
