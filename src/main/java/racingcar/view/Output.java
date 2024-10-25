package racingcar.view;

import racingcar.dto.CarDto;
import racingcar.dto.RoundDto;
import racingcar.dto.api.Api;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

import static racingcar.view.util.ViewMessage.라운드_결과_출력;
import static racingcar.view.util.ViewMessage.최종_우승자_출력;

public class Output {
    private Integer FIRST_ROUND = 0;
    private String ONE_STEP = "-";

    protected Output() {
    }

    public static Output of() {
        return new Output();
    }

    public void viewOneRound(Api<RoundDto> api) {
        RoundDto roundDto = api.getData();
        viewFirstRound(roundDto.getRound());

        List<CarDto> carDtos = roundDto.getCarDtos();
        carDtos.forEach(oneCar -> {
            viewOneCar(oneCar.getCarname(), oneCar.getDistance());
        });
        viewEnter();
    }

    public void viewResult(Api<String> api) {
        System.out.println(최종_우승자_출력.getMessage() + api.getData());
    }

    private void viewFirstRound(Integer round) {
        if(Objects.equals(round, FIRST_ROUND)) {
            System.out.println(라운드_결과_출력.getMessage());
        }
    }

    private void viewOneCar(String carname, Integer carDistance) {
        System.out.print(carname + " : ");
        System.out.print(countDistance(carDistance));
        viewEnter();
    }

    private StringBuilder countDistance(Integer carDistance) {
        StringBuilder distance = new StringBuilder();
        IntStream.range(0, carDistance).forEach(showDistance -> {
            distance.append(ONE_STEP);
        });
        return distance;
    }

    private void viewEnter() {
        System.out.println();
    }
}
