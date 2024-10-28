package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String nameOfCars = Console.readLine();
        checkInput(nameOfCars, "string");

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountString = Console.readLine();
        checkInput(tryCountString, "number");
        int tryCount = Integer.parseInt(tryCountString);

    }

    static void checkInput(String stringInput, String type) {
        String regex = "";

        switch (type) {
            case "string":
                regex = "^([가-힣a-zA-Z]{1,5})(,([가-힣a-zA-Z]{1,5}))*$";
                break;
            case "number":
                regex = "^\\d+$";
                break;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(stringInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException();
        }
    }
}
