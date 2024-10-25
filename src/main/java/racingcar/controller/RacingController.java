package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.RacingService;

public class RacingController {

    public static void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String racingCars = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String moveCount = Console.readLine();
        inputValid(racingCars, moveCount);
        RacingService.setupRacing(racingCars, moveCount);
        RacingService.startRacing();
        RacingService.racingResult();
    }

    private static void inputValid(String carNames, String moveCount) {
        if (carNames == null || carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("입력되지 않았습니다. 경주할 자동차 이름을 입력해주세요.");
        }
        String[] names = carNames.split(",");
        if (names.length < 2) {
            throw new IllegalArgumentException("경주를 하기 위해서는 2대 이상의 자동차가 필요합니다.");
        }
        String[] nameList = new String[names.length];
        int count = 0;
        for (String name : names) {
            name = name.trim(); // 앞뒤 공백 제거

            // 이름 길이 체크
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해야 합니다.");
            }

            // 특수문자 체크
            if (!name.matches("[a-zA-Z0-9\\s!@#$%^&*()-_=+]+")) { // 공백과 특정 특수문자 허용
                throw new IllegalArgumentException("자동차 이름은 알파벳, 숫자, 공백 및 특정 특수문자만 포함해야 합니다.");
            }

            // 중복 체크
            for (int j = 0; j < count; j++) {
                if (nameList[j].equals(name)) {
                    throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + name);
                }
            }

            nameList[count] = name;
            count++;
        }
        if (!moveCount.matches("\\d+")) {
            throw new IllegalArgumentException("문자 및 소수점은 입력할 수 없습니다. \n시도 횟수는 정수만 입력하셔야 됩니다.");
        } else if (Integer.parseInt(moveCount) < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다. \n시도 횟수는 1이상의 정수만 입력하셔야 됩니다.");
        }
    }
}
