package racingcar;

import racingcar.service.InputService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputService inputService = InputService.getInstance();

        List<String> names = inputService.getNames();
        int count = inputService.getTryCount();
    }
}
