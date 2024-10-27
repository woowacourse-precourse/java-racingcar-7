package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class TrialNumInput {
    // 시도 횟수 세팅 메소드
    public static int settingTrialNum() {
        // 입력 안내 문구 출력
        System.out.println("시도할 횟수는 몇 회인가요?");

        // 사용자 입력값 String 변수에 저장
        String inputData = Console.readLine();

        // 입력값 체크 메소드 numCheck() 를 호출하고, 그 반환값을 validTrialNum 에 저장
        int validTrialNum = numCheck(inputData);

        // settingTrialNum()메소드의 반환값
        return validTrialNum;
    }

    // 입력값 체크 메소드
    public static int numCheck(String inputData) {
        try {
            int validTrialNum = Integer.parseInt(inputData);     // 입력값을 int 로 변환
            if (validTrialNum <= 0) {           // 0 이하의 숫자일 시
                throw new IllegalArgumentException("시도 횟수는 0 이상의 정수가 입력되어야 합니다. 다시 시도해주세요.");
            }
            // numCheck()메소드의 반환값
            return validTrialNum;
        } catch (NumberFormatException e) {     // 숫자 포맷 예외발생 시
            throw new IllegalArgumentException("입력된 시도 횟수가 정수가 아닙니다. 다시 시도해주세요.");
        }
    }
}