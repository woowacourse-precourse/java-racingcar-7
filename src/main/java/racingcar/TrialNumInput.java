package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class TrialNumInput {
    public static int settingTrialNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputData = Console.readLine();
        int validTrialNum = numCheck(inputData);

        return validTrialNum;
    }

    public static int numCheck(String inputData) {
        try {
            int validTrialNum = Integer.parseInt(inputData);   // 입력값을 int 로 변환
            if (validTrialNum <= 0) {           // 0 이하의 숫자일 시
                throw new IllegalArgumentException("시도 횟수는 0 이상의 정수가 입력되어야 합니다. 다시 시도해주세요.");
            }
            return validTrialNum;
        } catch (NumberFormatException e) {     // 숫자 포맷 예외발생 시
            throw new IllegalArgumentException("입력된 시도 횟수가 정수가 아닙니다. 다시 시도해주세요.");
        }
    }
}