package racingcar;

import static racingcar.Constant.*;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {
    public static List<Car> inputCarName() {
        List<Car> carList = new ArrayList<>();

        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String[] carNameList = Console.readLine().split(NAME_SEPARATOR);

        for (String carName : carNameList) {
            checkNameLength(carName.trim());
            carList.add(new Car(carName.trim()));
        }
        return carList;
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_INPUT_ERROR_MESSAGE);
        }
    }

    public static int inputAttempt() {
        System.out.println(ATTEMPT_INPUT_MESSAGE);
        String attempt = Console.readLine();
        checkAttemptOK(attempt);
        return Integer.parseInt(attempt);
    }

    private static void checkAttemptOK(String attempt){
        for(int i = 0; i < attempt.length(); i++){
            if(!Character.isDigit(attempt.charAt(i))){
                throw new IllegalArgumentException(ATTEMPT_INPUT_ERROR_MESSAGE);
            }
        }
    }
}

