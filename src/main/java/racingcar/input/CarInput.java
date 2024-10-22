package racingcar.input;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

//자동차의 이름과 경기 횟수를 입력받음
public class CarInput {
    public void inputCarDetail() {
        //경주할 선수이름을 입력받기
        List<String> carName = new ArrayList<>();
        System.out.println("경주할 자동차 이름을 입력하세요.");
        String players = Console.readLine();
        carName.add(players);
        System.out.println("선수들 이름: " + carName);

        //경기횟수 입력받기
        System.out.println("시도할 횟수는 몇 회인가요?");
        String racingNumberInput = Console.readLine();
        int racingNumber = Integer.parseInt(racingNumberInput);
        System.out.println(racingNumber + "회 시도합니다.");
    }
}
