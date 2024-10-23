package controller;

import racingcar.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RaceController {
    private static final int MIN_Car_Name = 1;
    private static final int MAX_Car_Name = 5;
    private static final int MIN_Race_Round = 1;

    private final List<Car> cars = new ArrayList<>();
    private int round;

    public void run(Scanner sc) {
        SetCars(sc);
    }

    private void SetCars(Scanner sc) {
        List<String> names;
        String[] input;
        System.out.println("경주할 차 이름을 입력해주세요.");
        input = sc.nextLine().split(","); //쉼표 기준으로 이름을 구분한다.
        names = Arrays.stream(input).map(String::trim).collect(Collectors.toList());
        names.forEach(name -> cars.add(new Car(name)));
    }


}
