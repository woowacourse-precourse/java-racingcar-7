package racingcar.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import racingcar.view.InputView;

public class ValidateInput {
    private static final int MAX_NAME_LENGTH = 5; // 자동차 이름의 최대 길이
    private static List<String> cars = new ArrayList<>(); // 자동차 이름 목록

    public static List<String> name() {
        String carNames = InputView.getCarNamesInput();

        //이름 입력값 검증(각 기능은 오류메시지 참고)
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("입력된 값이 없습니다.");
        }
        
        if (carNames.charAt(0) == ',' || carNames.charAt(carNames.length() - 1) == ',') {
            throw new IllegalArgumentException("구분자는 이름으로 입력 할 수 없습니다."); // 이름 양 끝에 쉼표가 있는지 확인
        }

        String[] splitStr = carNames.split(","); // 입력된 문자열을 쉼표로 분리하여 배열에 저장
        cars.addAll(Arrays.asList(splitStr)); // 배열 요소를 리스트에 추가

        for (String car : cars) {
            if (car.length() > MAX_NAME_LENGTH) {
                throw new IllegalArgumentException("이름은 5자 이하로 하세요.");
            }
        }
        
        Set<String> uniqueNames = new HashSet<>(cars); // 중복을 확인하기 위해 집합 생성
        for (String number : uniqueNames) {
            if (Collections.frequency(cars, number) > 1) {
                throw new IllegalArgumentException("중복 이름은 허용되지 않습니다.");
            }
        }
        
        if (cars.contains("")) {
            throw new IllegalArgumentException("공백은 이름으로 사용 할 수 없습니다.");
        }
        return cars;
    }

    public static int validateAttempts() {
        String attemptInput = InputView.getNumberAttempts();

        if (!isNumeric(attemptInput)) {
            throw new IllegalArgumentException("시도 횟수를 양의 정수로 입력하세요"); // 숫자가 아닌 경우 예외 발생
        }

        int attempts = Integer.parseInt(attemptInput);
        if (attempts <= 0) {
            throw new IllegalArgumentException("0 초과의 시도 횟수를 입력하세요."); // 0보다 큰 숫자인지 확인
        }
        return attempts;  // 시도 횟수를 정수로 반환
    }

    private static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}