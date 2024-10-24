package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.RoundDto;
import racingcar.dto.api.Api;

import java.util.List;
import java.util.stream.IntStream;

public class Output {

    protected Output() {
    }

    public static Output of() {
        return new Output();
    }

    public void viewOneRound(Api api) {
        RoundDto roundDto = (RoundDto) api.getData();
        if(roundDto.getRound() == 1) {
            viewFirstRound();
        }
        List<CarDto> carDtos = roundDto.getCarDtos();
        carDtos.forEach(oneCar -> {
            viewOneCar(oneCar.getCarname(), oneCar.getDistance());
        });
        System.out.println();
    }

    public void viewResult(Api api) {
        System.out.println("최종 우승자 : " + api.getData());
    }

    private void viewFirstRound() {
        System.out.println("실행 결과");
    }

    private void viewOneCar(String carname, Integer carDistance) {
        System.out.print(carname + " : ");
        IntStream.range(0, carDistance).forEach(showDistance -> {
            System.out.print("-");
        });
        System.out.println();
    }
}
