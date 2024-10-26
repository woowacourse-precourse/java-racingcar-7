package racingcar.racingcarController;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashMap;
import java.util.LinkedHashMap;

import racingcar.racingcarView.View;
import racingcar.racingcarModel.Model;


public class Controller {
    private View view;
    private Model model;

    public Controller(View View, Model Model) {
    this.view = View;
    this.model = Model;
    }

    public void run() {
        view.printNameInputMessage();
        String nameInput = Console.readLine();
        view.printTryInputMessage();
        int tryInput = Integer.parseInt(Console.readLine());

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
