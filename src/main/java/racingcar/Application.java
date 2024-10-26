package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final int VALID_NAME_LENGTH = 5;

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 회수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());

        System.out.println("실행결과 ");

        for (int i = 0; i < count; i++) {
            String roundProgress = doRacing(input, count);
            System.out.println(roundProgress);
        }

        String winner = getWinner();
        System.out.println("최종 우승자 : " + winner);
    }

    private static String doRacing(String input, int count) {
        String[] cars = input.split(",");
        validateInput(cars);
        return "";
    }

    private static String getWinner() {
        return "";
    }

    private static void validateInput(String[] cars) {
        if (cars.length <= 1) {
            throw new IllegalArgumentException("자동차 이름을 최소 2개 입력해주세요.");
        }
        validateCarName(cars);
        checkDuplicateNames(cars);
    }

    private static void checkDuplicateNames(String[] cars) {
        for (int i = 0; i < cars.length; i++) {
            String currentCar = cars[i];  // 공백 제거
            if (isDuplicate(cars, currentCar, i)) {
                throw new IllegalArgumentException("중복된 자동차 이름이 있습니다: " + currentCar);
            }
        }
    }

    // 중복 여부를 검사하는 보조 메서드
    private static boolean isDuplicate(String[] cars, String car, int index) {
        for (int j = index + 1; j < cars.length; j++) {
            if (car.equals(cars[j])) {  // 공백 제거 후 비교
                return true;
            }
        }
        return false;
    }

    private static void validateCarName(String[] cars) {
        for (String car : cars) {
            if (car.contains(" ")) {
                throw new IllegalArgumentException("차량 이름에 공백이 포함될 수 없습니다.");
            }
            if (car.length() > VALID_NAME_LENGTH) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (!car.matches("[a-zA-Z]+")) {
                throw new IllegalArgumentException("자동차 이름은 알파벳만 포함할 수 있습니다.");
            }
        }
    }
}
