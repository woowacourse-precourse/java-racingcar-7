package racingcar;

import racingcar.ui.StringPrinter;
import racingcar.ui.StringReader;
import racingcar.ui.UserInputRequester;
import racingcar.ui.reader.InputReader;

public class Application {
    public static void main(String[] args) {
        StringReader reader = new StringReader();
        StringPrinter printer = new StringPrinter();
        InputReader inputReader = new InputReader(new UserInputRequester(reader, printer));

        MyRacingProgram myRacingProgram = new MyRacingProgram(inputReader, printer);
        myRacingProgram.start();
    }
}
