package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {
    public static List<Car> inputCarName() {
        List<Car> carList = new ArrayList<>();
        String[] carNameList = Console.readLine().split(",");

        for (String carName : carNameList) {
            checkNameLength(carName);
            carList.add(new Car(carName));
        }
        return carList;
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    public static int inputAttempt() {
        String attempt = Console.readLine();
        checkAttemptOK(attempt);
        return Integer.parseInt(attempt);
    }

    private static void checkAttemptOK(String attempt){
        for(int i = 0; i < attempt.length(); i++){
            if(!Character.isDigit(attempt.charAt(i))){
                throw new IllegalArgumentException("시도 횟수는 정수만 입력 가능합니다.");
            }
        }
    }
}

