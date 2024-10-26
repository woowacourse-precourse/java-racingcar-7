package util;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    public static List<String> car;

    // 입력부: 경주할 자동차
    public static List<String> inputCar() throws IllegalArgumentException {
        // Error : 공백 입력, (,)가 아닌 구분자 사용, 5글자 초과
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        car = new ArrayList<>(Arrays.asList(Console.readLine().strip().split(",")));
        noValueEntered(car);
        noValueDelete(car);
        System.out.println(car.toString());

        for (int i = 0; i < car.size(); i++) {
            car.set(i, car.get(i).strip());
            String value = car.get(i);

            commaX(value);
            over5(value);
        }

        return car;
    }

    // 입력부: 시도 횟수
    public static int inputNumTry() throws IllegalArgumentException {
        // Error : 0이하 입력, 실수 입력(정수가 아닌 수), 문자 입력
        System.out.println("시도할 횟수는 몇 회인가요?");
        int numTry = Integer.parseInt(Console.readLine());
        zeroLess(numTry);

        return numTry;
    }

    // 예외 : (,)이 아닌 구분자 사용 (ex) 모든 언어의 문자(알파벳),숫자,공백을 제외한 나머지 입력 문자들은 전부 예외처리
    private static void commaX(String inputValue) {
        if (!inputValue.matches("^[\\p{L}\\p{N}\\s]*$")) {
            throw new IllegalArgumentException("쉼표(,)가 아닌 구분자가 입력되었습니다.");
        }
    }

    // 예외 : 입력된 값 X
    private static void noValueEntered(List<String> cars) {
        if (cars.size() == 1 && cars.getFirst().isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
    }

    // 예외 : 0 이하
    private static void zeroLess(int inputValue) {
        if (inputValue <= 0) {
            throw new IllegalArgumentException("[ 시도 횟수 ] 0보다 큰 정수를 입력해야 합니다.");
        }
    }

    // 예외 : 5글자 초과 (ex) J Kim : 5글자로 가능 / Ju Kim : 6글자로 불가능
    private static void over5(String inputValue) {
        if (inputValue.length() > 5) {
            throw new IllegalArgumentException("[ 자동차 이름 ] 5글자 이하로 입력해야 합니다.");
        }
    }

    // 공백일 경우 값 삭제
    private static void noValueDelete(List<String> cars) {
        cars.removeIf(String::isBlank);
    }

    // Test
    public static void test(String[] args) {
        try {
            List<String> testNameCars = inputCar();
            System.out.printf("Successful: 자동차 이름 %s\n", testNameCars);

            int testNumTry = inputNumTry();
            System.out.printf("Successful: 시도 횟수 %d\n", testNumTry);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Error");
        }
    }
}
