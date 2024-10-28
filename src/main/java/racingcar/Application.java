package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.NoSuchElementException;

import racingcar.StartApp;
import racingcar.Racing;
import racingcar.Racing;

import java.util.HashMap;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        String[] cars = StartApp.InsertCars();
        Map<String, Integer> carMap = StartApp.CarMapping(cars);

        int time = StartApp.InsertTimes();

        System.out.println();
        System.out.println("실행 결과");

        for(int i=0; i<time; i++) {
            Racing.Racing(carMap, cars);
        }

        Racing.Winner(carMap, cars);
    }
}
