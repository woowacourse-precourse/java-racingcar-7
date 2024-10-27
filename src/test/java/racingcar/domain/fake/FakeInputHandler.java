package racingcar.domain.fake;

import java.util.List;
import racingcar.interfaces.input.InputHandler;

public class FakeInputHandler implements InputHandler {
    @Override
    public List<String> getCarNames() {
        return List.of("honda", "bmw", "benz", "ford");
    }

    @Override
    public int getRaceCount() {
        return 5;
    }

    @Override
    public String readLine() {
        return "";
    }
}
