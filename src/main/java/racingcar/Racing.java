package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Racing {
//    ### 3. 무작위 값 생성하기
//    ### 4. 생성된 랜덤수를 통한 전진여부 판단하기
//    ### 5. 최종 우승자 확인후 출력하기

    public void run() {
        // # 1. 경주할 자동차 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        // # 2. 시도할 횟수 입력받기
        System.out.println("시도할 횟수는 몇 회인가요?");
        int repeat = Integer.parseInt(Console.readLine());

        String[] racer = spliter(input);

    }

    // , 기준으로 분리하기
    public String[] spliter(String input) {
        return input.split(",");
    }

    // # 3. 무작위 값 생성하기
    public int randomGenerator(){
        return Randoms.pickNumberInRange(0,9);
    }


}
