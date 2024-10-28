package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars_name = Console.readLine();
        // 자동차 이름 길이 검사
        String[] cars_list = ValidateCarNames.validateCarNames(cars_name);
        // 각 자동차의 전진 횟수를 저장할 리스트 생성
        ArrayList<Integer> advanceCountList = CreateAdvanceCount.createAdvanceCount(cars_list);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int count = Integer.parseInt(Console.readLine());
        System.out.println("\n실행결과");

        // 시도 횟수 만큼 각 자동차 전진 유무 확인
        TryAdvanceCar.carMove(count,cars_list,advanceCountList);

        // 가장 많이 전진한 횟수
        int max_advance_count = Collections.max(advanceCountList);
        ArrayList<String> winner = WinnerList.winnerList(advanceCountList,cars_list,max_advance_count);

        System.out.println("최종 우승자 : " + String.join(",", winner));

    }
}
