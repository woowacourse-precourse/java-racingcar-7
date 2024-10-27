package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CarNameInput {
    // 자동차 이름 세팅 메소드
    public static String[] settingCarName() {
        // 입력 안내 문구 출력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        // 사용자 입력값 쉼표 기준으로 나누어 저장
        String[] inputData = Console.readLine().split(",");

        // 유요한 이름만 저장할 배열 생성
        String[] validCarNames = new String[inputData.length];

        // 이름 길이 체크 메소드 호출
        nameLengthCheck(inputData, validCarNames);

        // settingCarName()메소드의 반환값
        return validCarNames;
    }

    // 이름 길이 체크 메소드
    public static String[] nameLengthCheck(String[] inputData, String[] validCarNames) {
        // 5글자 이하의 이름만 배열에 저장
        int index = 0;
        for (String name : inputData) {
            name = name.trim();    // 앞뒤공백 제거
            if (name.length() > 5 | name.length() == 0) {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하이어야 합니다. 다시 시도해주세요");
            }
            validCarNames[index++] = name;
        }
        // nameLengthCheck()메소드의 반환값
        return validCarNames;
    }
}



