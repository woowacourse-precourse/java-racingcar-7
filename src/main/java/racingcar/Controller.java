package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;


public class Controller {
    private View View;
    private Model Model;

    public Controller(View View, Model Model) {
    this.View = View;
    this.Model = Model;
    }

    public void run() {
        View.printNameInputMessage();
        String nameInput = Console.readLine();
        View.printTryInputMessage();
        int tryInput = Integer.parseInt(Console.readLine());

        Map<String, Integer> carInfo = Model.initializeCarInfo(nameInput);

        View.printRunResults();

        for (int i = 0; i < tryInput; i++) {
            for (Map.Entry<String, Integer> entry : carInfo.entrySet()) {
                carInfo.put(entry.getKey(), Model.isForward(entry.getValue()));
                System.out.println(entry.getKey()+ " : " + "-".repeat(entry.getValue()) );

            }
            System.out.println();
        }

        int maxValue = Model.maxValue(carInfo);
        String winner = Model.winnerCar(carInfo,maxValue);
        View.printWinners(winner);




    }



}
