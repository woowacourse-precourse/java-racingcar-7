package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Stream;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> cars = readCars();
    }

    /**
     * 자동차 이름이 5자 이하인지 검증하는 함수
     *
     * @param carName 자동차 이름
     * @throws IllegalArgumentException 자동차 이름이 5자 초과일 경우
     */
    private static void carNameValidCheck(String carName) throws IllegalArgumentException {
        if (carName.length() <= 5) return;
        throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
    }

    /**
     * 자동차 이름을 입력받아 배열로 반환하는 함수
     * 자동차 이름은 쉼표(,)로 구분 및 carNameValidCheck 메소드로 검증
     *
     * @return 자동차 이름 리스트
     */
    private static List<String> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> cars = Stream.of(Console.readLine()
                        .replaceAll(" ", "")
                        .split(","))
                .toList();
        if (cars.isEmpty()) throw new IllegalArgumentException("자동차 이름을 입력해주세요.");
        cars.forEach(Application::carNameValidCheck);
        return cars;
    }

    /**
     * 시도 횟수를 입력받아 반환하는 함수
     *
     * @return 시도 횟수
     * @throws IllegalArgumentException 시도 횟수가 숫자가 아닐 경우
     */
    private static int readTimes() throws IllegalArgumentException {
        System.out.println("시도할 회수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }

}
