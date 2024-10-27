package racingcar.racingcarController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import racingcar.racingcarModel.Model;
import racingcar.racingcarView.View;


public class Controller {
    private View view;
    private Model model;

    public Controller(View View, Model Model) {
    this.view = View;
    this.model = Model;
    }

    public void run() {
        view.printNameInputMessage();
        String nameInput = view.readInput();
        view.printTryInputMessage();
        int tryInput = Integer.parseInt(view.readInput());

        LinkedHashMap<String, Integer> carInfo = model.initializeCarInfo(nameInput);

        view.printRunResults();

        for (int i = 0; i < tryInput; i++) {
            for (HashMap.Entry<String, Integer> entry : carInfo.entrySet()) {
                carInfo.put(entry.getKey(), model.isForward(entry.getValue()));
                System.out.println(entry.getKey()+ " : " + "-".repeat(entry.getValue()) );

            }
            System.out.println();
        }

        int maxValue = model.maxValue(carInfo);
        String winner = model.winnerCar(carInfo,maxValue);
        view.printWinners(winner);




    }



}
