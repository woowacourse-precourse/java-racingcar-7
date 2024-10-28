package racingcar;

import racingcar.io.JavaReader;
import racingcar.io.JavaWriter;
import racingcar.io.Reader;
import racingcar.io.Writer;

public class Application {
    public static void main(String[] args) {
        Reader reader = new JavaReader();
        Writer writer = new JavaWriter();

        Game game = new Game(reader, writer);
        game.play();
    }
}
