package iohandler;

import domain.Car;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {

    public List<Car> inputCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        return stripCarNames(input);
    }

    private List<Car> stripCarNames(String input){
        String[] strings = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String string : strings) {
            cars.add(new Car(string.strip()));
        }
        return cars;
    }

    public int inputAttempt(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("유효한 숫자를 입력해야 합니다.");
        }
    }
}
