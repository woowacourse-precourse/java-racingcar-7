package racingcar;

import java.util.List;
import java.util.stream.IntStream;
import camp.nextstep.edu.missionutils.Randoms;
public class RacingCarGameSimulator implements Simulator {
    @Override
    public SimulationResult<String> simulate(List<Car> givenCars, int givenTrial){
        SimulationResult<String> result = new SimulationResult<>();
        result.add("실행 결과");

        for(int t = 0; t < givenTrial; t++){
            result.add(racingResult(givenCars));
        }

        Car highestStatusCar = givenCars.getFirst();
        List<Car> winners = givenCars.stream().filter(car -> car.getStatus() == highestStatusCar.getStatus()).toList();

        result.add("최종 우승자 : "+winners.toString().replace("[","").replace("]",""));

        return result;
    }

    public String racingResult(List<Car> cars) {
        StringBuilder graphWriter = new StringBuilder();

        cars.forEach(car->{
                carForward(car);
                graphWriter.append(getCarStatusGraph(car));});

        return graphWriter.toString();
    }

    private void carForward(Car car){
        if(Randoms.pickNumberInRange(0,9) >= 4){ // TODO: 하드코딩 상수 수정
            car.forward();
        }
    }

    private String getCarStatusGraph(Car car) {
        return car.getName() + " : " + getStatusString(car)+"\n";
    }

    private String getStatusString(Car car) {
        StringBuilder statusStringBuilder = new StringBuilder();
        IntStream.range(0, car.getStatus()).forEach(i -> statusStringBuilder.append("-"));

        return statusStringBuilder.toString();
    }
}
