package racingcar.output.process;

import racingcar.entity.Car;

import java.util.List;

public class ProcessOutputHandlerImpl implements ProcessOutputHandler {
    @Override
    public void printFirstPhrase() {
        System.out.print("\n실행 결과");
    }

    @Override
    public void printHistory(List<Car> racingHistory) {
        System.out.println(); // 각 시도마다 실행 결과 구분을 위한 개행
        for (Car car : racingHistory) {
            String progressBar = "-".repeat(Math.max(0, car.getDistance()));
            System.out.println(car.getCarName() + " : " + progressBar);
        }
    }
}
