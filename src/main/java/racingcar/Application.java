package racingcar;

import delimiter.InputDelimiter;
import input.CarName;
import input.Move;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarName carName = new CarName();
        InputDelimiter inputDelimiter = new InputDelimiter();
        Move move = new Move();

        String inputCarName = carName.inputCarName();
        List<String> delimeteWithCommaList = inputDelimiter.delimiterWithComma(inputCarName);
        int numberOfMove = move.howManyMove();
    }
}
