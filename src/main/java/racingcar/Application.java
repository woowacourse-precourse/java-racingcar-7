package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 입력 받기
        System.out.println("Put car names.");
        String racingName = Console.readLine();  // 레이싱 카 이름 목록
        System.out.println("How much try?");
        String tryNum = Console.readLine(); // 시도 횟수

        // 검증 수행
        Validate.isNameLengthValid(racingName); // 이름이 5글자 이하인지 검증
        Validate.isNameCommaSeparated(racingName); // 정확한 형식을 갖추고 있는지
        Validate.isNumeric(tryNum); // 시도횟수가 숫자인지

        // 레이싱 수행
        Racing race = new Racing(racingName); // 레이싱 카 생성

        System.out.println("\n 실행 결과");
        race.run(tryNum); // 레이싱 카 게임 시작
        race.win(); // 우승자 출력
    }
}
