package racingcar;

import camp.nextstep.edu.missionutils.Console;

import static javax.management.Query.or;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] cars = Console.readLine().split(",");

        for (String car: cars) {
            if (car.length() > 5 || car.trim().isEmpty()) {
                throw new IllegalArgumentException("잘못된 입력 형식입니다.");
            }
            System.out.println(car);
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            int count = Integer.parseInt(Console.readLine());
            System.out.println(count);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. 숫자만 입력해주세요.");
        }

        // TODO: 출력부 구현
        System.out.println("\n실행 결과");

    }
}
