package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

import java.util.HashMap;
import java.util.Map;

public class StartApp {

    // 자동차 이름 입력 (UserInput)
    // 자동차 이름 배열 반환
    public static String[] InsertCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String UserInput = "";

        // 자동차 이름이 입력되지 않았을 경우 예외 처리
        UserInput = Console.readLine();
        if (UserInput == null || UserInput.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        String[] cars = Refiner(UserInput);
        return cars;
    }

    // 자동차 이름을 쉼표 (,) 기준으로 분리
    public static String[] Refiner(String UserInput) {
        String defaultChar = ",";
        UserInput=UserInput.replaceAll(" " , "");
        String cars[] = UserInput.split(defaultChar);

        return cars;
    }

    // 자동차 HashMap 반환
    // 자동차 이름과 Default 이동 값 0 포함
    public static Map<String, Integer> CarMapping(String[] cars) {
        Map<String, Integer> carMap = new HashMap<>();

        // HashMap 생성
        // HashMap에 입력받은 자동차 이름과 Default 이동 횟수 0회 저장
        // 자동차 이름이 5자를 초과할 경우 예외 처리
        for (String car : cars) {
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로만 설정 가능합니다.");
            }
            carMap.put(car, 0);
        }
        return carMap;
    }

    // 시도 횟수 입력
    public static int InsertTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String UserInput = "";

        // 시도 횟수가 입력되지 않았을 경우 예외 처리

        try {
            UserInput = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }

        int time = Integer.parseInt(UserInput.trim());

        return time;
    }

}