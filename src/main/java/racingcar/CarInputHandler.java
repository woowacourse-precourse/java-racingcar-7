package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class CarInputHandler {
    public String userInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다 입력을 해야 합니다.");
        }
        return userInput;
    }

    public int userInputHowManyTimes() {
        System.out.println("시도할 횟수는 몇 회 인가요?");
        String userInput = Console.readLine();
        if (userInput == null || userInput.trim().isEmpty()) {
            throw new IllegalArgumentException("횟수가 입력 되지 않았습니다 입력을 해야 합니다.");
        }
        int numberOfMoves;
        try {
            numberOfMoves = Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("횟수는 1부터 2,147,483,,647까지 입력할 수 있습니다");
        }
        if (numberOfMoves <= 0) {
            throw new IllegalArgumentException("한번도 안 움직일수는 없습니다 횟수는 1 이상의 정수여야 합니다.");
        }
        return numberOfMoves;
    }

    public String[] splitCarNames(String carNames) {
        String[] separatedNames = carNames.split(",");
        Set<String> nameSet = new HashSet<>();
        for (int i = 0; i < separatedNames.length; i++) {
            separatedNames[i] = separatedNames[i].trim();
            if (separatedNames[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }
            if (!nameSet.add(separatedNames[i])) {
                throw new IllegalArgumentException("입력하신 자동차 이름중에 중복이 있습니다.");
            }
        }
        return separatedNames;
    }
}
