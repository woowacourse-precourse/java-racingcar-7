package racingcar.repository;

import java.util.HashMap;
import java.util.Map;
import racingcar.domain.Input;
import racingcar.view.constant.Request;

public class InputRepository {

    private static InputRepository instance;
    private Map<Request, Input> inputMap;

    private InputRepository() {
        this.inputMap = new HashMap<>();
    }

    public void save(Request request, Input input) {
        inputMap.put(request, input);
    }

    public Input get(Request request) {
        return inputMap.get(request);
    }

    public static InputRepository getRepo() {
        if (instance == null) {
            instance = new InputRepository();
        }
        return instance;
    }
}
