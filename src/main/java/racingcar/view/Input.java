package racingcar.view;


import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.utils.CustomErrorMessage;
import racingcar.utils.CustomException;

public class Input {
    private static final String DELIMITER = ",";
    private static final String INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    // 경주할 자동차 이름을 입력받고 유효성을 검사하여 반환
    public List<String> getCarName() {
        System.out.println(INPUT_MESSAGE);
        String input = Console.readLine();
        List<String> carName = splitCarName(input);

        if (!isValidCarName(carName)) {
            throw new IllegalArgumentException(CustomErrorMessage.INVALID_CAR_NAME);
        }

        return carName;
    }

    // 시도할 회수를 입력받고 유효성을 검사하여 반환
    public int getRound() {
        System.out.println(ROUND_MESSAGE);
        int input;

        try {
            input = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(CustomErrorMessage.INVALID_ROUNT_NUM);
        }

        if (!isValidRound(input)) {
            throw new IllegalArgumentException(CustomErrorMessage.INVALID_ROUND);
        }

        return input;
    }

    // 자동차 이름을 쉼표로 구분하여 리스트로 반환
    private List<String> splitCarName(String carInput) {
        return Arrays.asList(carInput.split(DELIMITER));
    }

    // 자동차 이름의 유효성 검사 (각 이름이 5자 이하인지 확인)
    private boolean isValidCarName(List<String> carName) {
        for (String name : carName) {
            if (name.length() > 5) {
                return false;
            }
        }
        return true;
    }



    // 시도 횟수가 1 이상인지 검사
    private boolean isValidRound(int round) {
        if (round < 1) {
            return false;
        }
        return true;
    }
}
