package racingcar;

import static racingcar.Constant.*;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputUtils {
    public static List<Car> inputCarName() {
        List<Car> carList = new ArrayList<>();

        System.out.println(CAR_NAME_INPUT_MESSAGE);
        String carNameInput = Console.readLine();
        checkWithString(carNameInput);
        String[] carNameList = carNameInput.split(NAME_SEPARATOR);

        for (String carName : carNameList) {
            checkWithWord(carName,carList);
            carList.add(new Car(carName));
        }
        return carList;
    }

    private static void checkWithString(String carNameInput){
        checkNoInput(carNameInput);
        checkInvalidComma(carNameInput);
    }

    private static void checkWithWord(String carName, List<Car> carList){
        checkNameLength(carName);
        checkBlankName(carName);
        checkDuplicateName(carName,carList);
    }

    private static void checkNameLength(String carName) {
        if (carName.length() > CAR_NAME_LENGTH_LIMIT) {
            throw new IllegalArgumentException(NAME_INPUT_LENGTH_ERROR);
        }
    }

    private static void checkNoInput(String carNameInput) {
        if (carNameInput.trim().isEmpty()) {
            throw new IllegalArgumentException(NAME_NO_INPUT_ERROR);
        }
    }

    private static void checkBlankName(String carNameInput) {
        if (carNameInput.charAt(0) == ' '
                || carNameInput.charAt(carNameInput.length()-1) == ' ') {
            throw new IllegalArgumentException(NAME_INPUT_BLANK_ERROR);
        }
    }

    private static void checkInvalidComma(String carNameInput) {
        if (carNameInput.contains(",,")
                || carNameInput.charAt(0) == NAME_SEPARATOR.charAt(0)
                || carNameInput.charAt(carNameInput.length()-1) == NAME_SEPARATOR.charAt(0)) {
            throw new IllegalArgumentException(NAME_INPUT_INVALID_COMMA);
        }
    }

    private static void checkDuplicateName(String carName, List<Car> carList) {
        for (Car car:carList){
            if(car.getName().equals(carName)){
                throw new IllegalArgumentException(NAME_INPUT_DUPLICATE_ERROR);
            }
        }
    }

    public static int inputAttempt() {
        try {
            System.out.println(ATTEMPT_INPUT_MESSAGE);
            String attempt = Console.readLine();
            checkAttemptOK(attempt);
            return Integer.parseInt(attempt);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ATTEMPT_INPUT_ERROR_MESSAGE);
        }
    }

    private static void checkAttemptOK(String attempt){
        for(int i = 0; i < attempt.length(); i++){
            if(!Character.isDigit(attempt.charAt(i))){
                throw new IllegalArgumentException(ATTEMPT_INPUT_ERROR_MESSAGE);
            }
        }
    }
}

