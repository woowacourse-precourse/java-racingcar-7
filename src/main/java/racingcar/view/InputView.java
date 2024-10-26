package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class InputView {


    public String getCarNames() {
        String userInput = Console.readLine();
        validateInput(userInput);
        return userInput;
    }

    public int getNumberOfTurn() {
        String userInput = Console.readLine();
        validateInput(userInput);
        int numberOfTurn = validateNumber(userInput);
        return numberOfTurn;
    }

    public boolean isEmpty(String input) {
        return input == null || input.isBlank();
    }

    public void validateInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException("입력되지 않았습니다.");
        }
    }

    public void validateCarNames(ArrayList<String> carNames) {
        for (String carName : carNames) {
            if (isEmpty(carName)) {
                throw new IllegalArgumentException("[ERROR] 빈 문자열이 있습니다.");
            }
            if (carName.length() > 5) {
                throw new IllegalArgumentException("CarName이 5자 이상입니다." + carName.length());
            }
        }
    }

    public int validateNumber(String number) {
        int numberOfTurn = isInt(number);
        isPositiveNumber(numberOfTurn);
        return numberOfTurn;
    }

    public int isInt(String input) {
        int numberOfTurn;

        try {
            numberOfTurn = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 횟수는 숫자여야 합니다.");
        }
        return numberOfTurn;
    }

    public void isPositiveNumber(int number) {
        if (number < 1) {
            throw new IllegalArgumentException("[ERROR] 횟수는 1 이상이여야 합니다.");
        }
    }
}
