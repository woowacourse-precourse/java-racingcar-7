package racingcar.service;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class InputService {
    private static final InputService instance = new InputService();

    private InputService() {}

    public static InputService getInstance() {
        return instance;
    }

    public List<String> getNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return List.of(Console.readLine().split(","));
    }

    public int getTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }
}
