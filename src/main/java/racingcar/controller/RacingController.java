package racingcar.controller;

import racingcar.service.RacingService;
import racingcar.view.ErrorView;
import racingcar.view.InputView;

public class RacingController {
    public static void start() {
        String racingCars = InputView.inputCar();
        String moveCount = InputView.inputCount();
        inputValid(racingCars, moveCount);
        RacingService.setupRacing(racingCars, moveCount);
        RacingService.startRacing();
        RacingService.racingResult();
    }

    private static void inputValid(String carNames, String moveCount) {
        if (carNames == null || carNames.trim().isEmpty()) {
            ErrorView.error_Empty();
        }
        String[] names = carNames.split(",");
        if (names.length < 2) {
            ErrorView.error_OneCar();
        }
        String[] nameList = new String[names.length];
        int count = 0;
        for (String name : names) {
            name = name.trim(); // 앞뒤 공백 제거

            // 이름 길이 체크
            if (name.length() > 5) {
                ErrorView.error_OverName();
            }

            // 특수문자 체크
            if (!name.matches("[a-zA-Z0-9\\s!@#$%^&*()-_=+]+")) { // 공백과 특정 특수문자 허용
                ErrorView.error_InvalidName();
            }

            // 중복 체크
            for (int j = 0; j < count; j++) {
                if (nameList[j].equals(name)) {
                    ErrorView.error_SameName();
                }
            }

            nameList[count] = name;
            count++;
        }
        if (moveCount == null || moveCount.trim().isEmpty()) {
            ErrorView.error_EmptyCount();
        } else if (moveCount.startsWith("-")) {
            ErrorView.error_InvalidCount2(); // 시작이 '-'인 경우 처리
        } else if (!moveCount.matches("\\d+")) {
            ErrorView.error_InvalidCount1();
        }
    }
}
