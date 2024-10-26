package racingcar;

import delimiter.InputDelimiter;
import input.CarName;
import input.Move;
import java.util.List;
import racingGame.WholeCycleGame;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarName carName = new CarName();
        InputDelimiter inputDelimiter = new InputDelimiter();
        Move move = new Move();
        WholeCycleGame wholeCycleGame = new WholeCycleGame();

        String inputCarName = carName.inputCarName();
        // 이름 바꿔야될듯
        List<String> delimeteWithCommaList = inputDelimiter.delimiterWithComma(inputCarName);
        int numberOfMove = move.howManyMove();

        wholeCycleGame.gameStart(delimeteWithCommaList, numberOfMove);
    }
}
