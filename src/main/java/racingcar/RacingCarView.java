package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.raceDto.RacingRequest;

public class RacingCarView {

    public RacingRequest readInput() {

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String name = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int times = Integer.parseInt(Console.readLine());

        Console.close();

        return new RacingRequest(name, times);
    }

    public void printResult() {

    }
}
