package racingcar;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        GameSet gameSet = new GameSet();
        gameSet.init();
        Racing racing = new Racing(gameSet);
        racing.startRace();


    }

}
