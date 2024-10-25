package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.CarDetail;
import racingcar.domain.Cars;
import racingcar.domain.Race;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingCarController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }


    public void racing() {
        String[] carNames = inputView.inputCarNames().split(",");
        Cars cars = Cars.from(List.of(carNames));

        int raceRound = inputView.inputRaceRound();
        Race race = Race.from(raceRound, cars);

        outputView.printRaceStartMessage();
        race.play();

        carDetails.forEach(carDetail -> {
            StringBuilder sb = new StringBuilder(carDetail.name() + " : ");
            int distance = carDetail.distance();
            while (distance-- > 0) {
                sb.append("-");
            }
            System.out.println(sb);
        });
        System.out.println();
        List<CarDetail> victoryCarDetails = cars.getVictoryCarNames();
        String result = victoryCarDetails.stream().map(CarDetail::name).collect(Collectors.joining(", "));
        System.out.print("최종 우승자 : " + result);
    }
}
