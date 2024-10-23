package racingcar;

import controller.RaceController;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner sc = new Scanner(System.in);
        RaceController raceController = new RaceController();
        try {
            raceController.run(sc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

