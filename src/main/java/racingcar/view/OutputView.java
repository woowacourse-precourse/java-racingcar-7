package racingcar.view;

import racingcar.model.LacingCar;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

public class OutputView {

    public static String userResultOutput(List<LacingCar> racingCars) {
        StringBuilder output = new StringBuilder();
        for(LacingCar racingCar : racingCars) {
            output.append(setResultOutput(racingCar.getCarName(), racingCar.getResultToMove())).append("\n");
        }
        return output.toString();
    }

    public static String setResultOutput(String carName, int resultToMove) {
        StringBuilder output = new StringBuilder(carName + " : ");
        for (int i = 0; i < resultToMove; i++) {
            output.append("-");
        }
        return output.toString();
    }

}
