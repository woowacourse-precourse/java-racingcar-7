package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import racingcar.game.Game;
import racingcar.io.Input;
import racingcar.io.OutputManager;
import racingcar.vehicle.Car;

public class Application {

    public static void main(String[] args) {
        Input in = new Input();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carName = in.nextLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String cnt = in.nextLine();
        System.out.println();
        Game game = new Game();
        HashMap<String, Car> result = game.gameStart(carName, cnt);
        List<String> winner = game.winnerPlayer(result);
        OutputManager.getInstance().print("최종 우승자 : " + String.join(", ", winner));
    }
}
