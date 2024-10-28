package racingcar.io;

import racingcar.Cars;
import racingcar.Constants;

public class Output {
    private final Cars cars;

    public Output(Cars cars) {
        this.cars = cars;
    }

    public void printPrefix() {
        System.out.println(Constants.OUTPUT_START_PROMPT);
    }

    public void printProcess() {
        cars.getCarsMap()
                .forEach((carName, position)-> {
                    String bar = convertPositionToBar(position);
                    String processOutput = String.format(Constants.OUTPUT_PROCESS_PROMPT, carName, bar);
                    System.out.println(processOutput);
                });
        //한칸 띄우기
        System.out.println();
    }

    public void printResult() {
        String resultOutput = String.format(Constants.OUTPUT_FINAL_RESULT_PROMPT, cars.getWinner());
        System.out.println(resultOutput);
    }

    private String convertPositionToBar(Integer position) {
        return Constants.OUTPUT_BAR.repeat(position);
    }
}
