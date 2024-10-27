package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CarNameInput {
    public static String[] settingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        checkForConsecutiveCommas(input);
        String[] inputData = input.split(",");
        carNumCheck(inputData);

        // 유효한 이름만 저장할 배열 생성
        String[] validCarNames = new String[inputData.length];
        nameLengthCheck(inputData, validCarNames);

        return validCarNames;
    }

    // 연속된 쉼표 체크 메소드
    public static void checkForConsecutiveCommas(String input) {
        if (input.contains(",,")) {
            throw new IllegalArgumentException("쉼표 사이에 빈 이름이 포함될 수 없습니다. 유효한 이름을 입력해주세요.");
        }
    }

    // 자동차 개수 체크 메소드
    public static void carNumCheck(String[] inputData) {
        if (inputData.length < 2) {
            throw new IllegalArgumentException("자동차 이름은 최소 두 개 이상 입력해야 합니다. 다시 시도해주세요.");
        }
    }

    // 이름 길이 체크 메소드
    public static String[] nameLengthCheck(String[] inputData, String[] validCarNames) {
        // 5글자 이하의 이름만 배열에 저장
        int index = 0;
        for (String name : inputData) {
            name = name.trim();    // 앞뒤공백 제거
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1~5글자 이하로 입력해야 합니다. 다시 시도해주세요");
            }
            validCarNames[index++] = name;
        }
        return validCarNames;
    }
}



