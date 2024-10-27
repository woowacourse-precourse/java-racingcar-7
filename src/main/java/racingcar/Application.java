package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // 자동차 이름 입력
        System.out.println(Message.RACING_CAR_NAME_INPUT.getMessage());
        String inputCarName = Console.readLine();

        // 입력된 자동차 이름 저장 후 검증
        List<String> names = Arrays.stream(inputCarName.split(","))
                .map(String::trim)
                .toList();
        for (String name : names) {
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException(Message.ILLEGAL_NAME_LENGTH.getMessage());
            }
        }

        // 시도 횟수 입력
        System.out.println(Message.TRY_COUNT.getMessage());
        String inputTryCount = Console.readLine();

        // 입력된 이름을 기반으로 Car 객체를 생성하여 리스트에 저장
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name));
        }

        // 레이싱 게임 전체 사이클
        System.out.println(Message.RESULT.getMessage());
        for (int i = 0; i < Integer.parseInt(inputTryCount); i++) {
            // 자동차 무빙 기능
            for (Car car : cars) {
                car.move();
            }

            // 중간 실행 결과 출력
            for (Car car : cars) {
                StringBuilder result = new StringBuilder(car.getName() + " : ");
                int carPosition = car.getPosition();
                for (int j = 0; j < carPosition; j++) {
                    result.append("-");
                }
                System.out.println(result.toString());
            }
            System.out.println();
        }
    }
}
