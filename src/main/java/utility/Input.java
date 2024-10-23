package utility;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Input {
    public static List<String> cars;

    // 입력부: 경주할 자동차
    public static List<String> inputCars() throws IllegalArgumentException {
        // Error : 공백 입력, (,)가 아닌 구분자 사용, 5글자 초과
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = Arrays.asList(Console.readLine().strip().split(","));
        noValueEntered(cars);

        for (int i = 0; i < cars.size(); i++) {
            cars.set(i, cars.get(i).strip());
            String value = cars.get(i);

            noValueDelete(value);
            over5(value);
            commaX(value);
        }

        return cars;
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
    public static void commaX(String inputValue) {
        if (!inputValue.matches("^[\\p{L}\\p{N}\\s]*$")) {
            throw new IllegalArgumentException("쉼표(,)가 아닌 구분자가 입력되었습니다.\n");
        }
    }

    // 예외 : 입력된 값 X
    public static void noValueEntered(List<String> cars) {
        if (cars.size() == 1 && cars.getFirst().isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.\n");
        }
    }

    // 예외 : 0 이하
    public static void zeroLess(int inputValue) {
        if (inputValue <= 0) {
            throw new IllegalArgumentException("[ 시도 횟수 ] 0보다 큰 정수를 입력해야 합니다.\n");
        }
    }

    // 예외 : 5글자 초과 (ex) J Kim : 5글자로 가능 / Ju Kim : 6글자로 불가능
    public static void over5(String inputValue) {
        if (inputValue.length() > 5) {
            throw new IllegalArgumentException("[ 자동차 이름 ] 5글자 이하로 입려해야 합니다.\n");
        }
    }

    // 공백일 경우 값 삭제
    public static void noValueDelete(String inputValue) {
        if (inputValue.isEmpty()) {
            cars.remove(inputValue);
        }
    }
}
