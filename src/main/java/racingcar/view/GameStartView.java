package racingcar.view;

import racingcar.dto.GameStartDTO;
import camp.nextstep.edu.missionutils.Console;

public class GameStartView {
    public GameStartDTO gameStart(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInputString = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String roundInputString = Console.readLine();

        return new GameStartDTO(carsInputString, roundInputString);
    }
}
