package racingcar.model.simulator;

import java.util.List;
import java.util.stream.IntStream;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.car.Car;
import racingcar.model.util.Simulator;

public class RacingCarGameSimulator implements Simulator<List<Car>, String> {
    private final int MOVE_THRESHOLD = 4;

    @Override
    public SimulationResult<String> simulate(List<Car> givenCars, int givenTrial) {
        SimulationResult<String> result = new SimulationResult<>();
        List<Car> simulationCars = List.copyOf(givenCars);

        for (int t = 0; t < givenTrial; t++) {
            result.add(race(simulationCars));
        }

        List<Car> winners = selectWinners(simulationCars);

        String winnerResult = "최종 우승자 : " + winners.toString().replace("[", "").replace("]", "");
        result.add(winnerResult);

        return result;
    }

    private List<Car> selectWinners(List<Car> givenCars) {
        Car highestStatusCar = givenCars.getFirst();
        return givenCars.stream().filter(car -> car.compareTo(highestStatusCar) == 0).toList();
    }

    private String race(List<Car> cars) {
        StringBuilder graphWriter = new StringBuilder();

        cars.forEach(car -> {
            carForward(car);
            graphWriter.append(getCarStatusGraph(car));
        });

        return graphWriter.toString();
    }

    private void carForward(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= MOVE_THRESHOLD) {
            car.forward();
        }
    }

    private String getCarStatusGraph(Car car) {
        return car.getName() + " : " + getStatusString(car) + "\n";
    }

    private String getStatusString(Car car) {
        StringBuilder statusStringBuilder = new StringBuilder();
        IntStream.range(0, car.getStatus()).forEach(i -> statusStringBuilder.append("-"));

        return statusStringBuilder.toString();
    }
}
