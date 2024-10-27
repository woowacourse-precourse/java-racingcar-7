package racingcar.racingcarController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import racingcar.racingcarModel.CarModel;
import racingcar.racingcarModel.ExceptionModel;
import racingcar.racingcarView.CarView;

public class Controller {
    private CarView carView;
    private CarModel carModel;
    private ExceptionModel exceptionModel;

    public Controller(CarView carView, CarModel carModel, ExceptionModel exceptionModel) {
        this.carView = carView;
        this.carModel = carModel;
        this.exceptionModel = exceptionModel;
    }

    public void run() {
        carView.printNameInputMessage();
        String nameInput = carView.readInput();
        carView.printTryInputMessage();
        String beforetryinput = carView.readInput();

        //예외 검사
        exceptionModel.executeExceptionalHandling(() -> {
            exceptionModel.emptyCarName(nameInput);
            exceptionModel.emptyCarNames(nameInput);
            exceptionModel.overFiveCarNames(nameInput);
            exceptionModel.uniqueCarNames(nameInput);
            exceptionModel.emptyTryInput(beforetryinput);
            exceptionModel.isNumberTryInput(beforetryinput);
            exceptionModel.isPositiveNumberTryInput(beforetryinput);
        });

        int tryInput = Integer.parseInt(beforetryinput);

        LinkedHashMap<String, Integer> carInfo = carModel.initializeCarInfo(nameInput);

        carView.printRunResults();

        for (int i = 0; i < tryInput; i++) {
            for (HashMap.Entry<String, Integer> entry : carInfo.entrySet()) {
                carInfo.put(entry.getKey(), carModel.isForward(entry.getValue()));
                System.out.println(entry.getKey()+ " : " + "-".repeat(entry.getValue()) );

            }
            System.out.println();
        }

        int maxValue = carModel.maxValue(carInfo);
        String winner = carModel.winnerCar(carInfo,maxValue);
        carView.printWinners(winner);



    }



}
