package controller;

import domain.Attempt;
import domain.Car;
import java.util.List;
import service.RacingService;
import validator.AttemptValidator;
import view.InputView;
import view.OutputView;

public class RacingController {
    private final RacingService racingService = new RacingService();
    private List<Car> carsList;
    private Attempt attempt;

    public void set() {
        String input = InputView.inputCars();
        carsList = racingService.getCarsList(input);

        attempt = new Attempt(InputView.inputAttempt());

        race();
        result();
    }

    public void race() {
        System.out.println("실행 결과");
        for (int i = 0; i < attempt.getAttempt(); i++) {
            racingService.moveCars(carsList);
            OutputView.showRoundResult(carsList);
        }
    }

    private void result() {
        System.out.print("최종 우승자 : ");
        racingService.getWinners(carsList);
    }


}
