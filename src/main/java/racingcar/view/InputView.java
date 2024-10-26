package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.Utils.ValidationUtils;

public class InputView {
    private static final ValidationUtils validationUtils=new ValidationUtils();

    public List<String> getCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String input= Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        validationUtils.validateCarNames(carNames);
        return carNames;
    }
    public int getRaceCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String raceCount=Console.readLine();
        validationUtils.validateRaceCount(raceCount);
        return Integer.parseInt(raceCount);
    }
}
