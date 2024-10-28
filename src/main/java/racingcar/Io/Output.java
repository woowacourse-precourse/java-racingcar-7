package racingcar.Io;

import java.util.List;
import racingcar.domain.Car;
import racingcar.service.CarService;

public class Output {

    public static void currentProgress(List<Car> cars) {
        cars.forEach(CarService::printCarInfo);
        System.out.println();
    }

    public static void winners(List<Car> winners) {
        StringBuilder output = new StringBuilder();
        output.append("최종 우승자 : ");
        winners.stream()
                .map(winner -> winner.getName() + ", ")
                .forEach(output::append);
        System.out.println(output.substring(0, output.length() - 2));
    }
}
