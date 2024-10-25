package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class User {


    public List<String> grantCarName() {
        List<String> cars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = inputValidate(Console.readLine());

        inputLastIndexValidate(input);

        String[] carName = input.split(",");

        for (String car : carName) {
            nameLengthValidate(car);
            nameDuplicateValidate(car, cars);
            cars.add(inputValidate(car));
        }

        tooManyCarsValidate(cars);

        return cars;
    }

    public int moves() {
        int moves;
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            moves = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력해주세요. ");
        }

        moveValidate(moves);
        tooManyMovesValidate(moves);

        Console.close();

        return moves;
    }

    private String inputValidate(String string) {
        string = string.trim();
        if (string.isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다. ");
        }
        return string;
    }

    private void inputLastIndexValidate(String string) {
        if (string.endsWith(",")) {
            throw new IllegalArgumentException("문자열의 끝에 구분자가 위치해있습니다.");
        }
    }

    private void nameLengthValidate(String string) {
        if (string.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 최대 5자까지 허용됩니다. ");
        }
    }

    private void nameDuplicateValidate(String string, List<String> list) {
        if (list.contains(string)) {
            throw new IllegalArgumentException("자동차의 이름이 중복되었습니다. ");
        }
    }

    private void tooManyCarsValidate(List<String> list) {
        if (list.size() > 10) {
            throw new IllegalArgumentException("자동차는 10대까지 허용됩니다. ");
        }
    }

    private void tooManyMovesValidate(int move) {
        if (move > 10) {
            throw new IllegalArgumentException("이동 횟수는 10회까지 허용됩니다. ");
        }
    }

    private void moveValidate(int move) {
        if (move < 1) {
            throw new IllegalArgumentException("1회 이상 이동해야합니다. ");
        }
    }

}
