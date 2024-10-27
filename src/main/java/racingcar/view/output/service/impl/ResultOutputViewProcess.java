package racingcar.view.output.service.impl;

import racingcar.view.output.service.ResultOutputService;

import java.util.stream.Stream;

public class ResultOutputView implements ResultOutputService {
    @Override
    public void executionResults(Stream<String> executionResult) {
        System.out.println("실행 결과");
        executionResult.forEach(System.out::println);
    }

    @Override
    public void winningCarsInfo(String winningCars) {
        System.out.printf("최종 우승자 : %s", winningCars);
    }
}
