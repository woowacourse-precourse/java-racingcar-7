package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.Utils.ValidationUtils;

public class InputView {
    private static final ValidationUtils validationUtils=new ValidationUtils();
    private static final String READ_CAR_NAME_MESSAGE="경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String READ_COUNT_MESSAGE="시도할 횟수는 몇 회인가요?";

    public List<String> getCarNames(){
        System.out.println(READ_CAR_NAME_MESSAGE);
        String input= Console.readLine();
        List<String> carNames = Arrays.asList(input.split(","));
        validationUtils.validateCarNames(carNames);
        return carNames;
    }
    public int getRaceCount(){
        System.out.println(READ_COUNT_MESSAGE);
        String raceCount=Console.readLine();
        validationUtils.validateRaceCount(raceCount);
        return Integer.parseInt(raceCount);
    }
}
