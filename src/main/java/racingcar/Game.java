package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Game {


    public void startGame() {
        List<Car> cars;
        int totalMoves;
        String input;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = readLine();
        cars = parseCars(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        totalMoves = parseMoveCount(input);

        System.out.println("\n실행 결과");
        for(int i = 0 ; i < totalMoves ; i++){
            for(Car car : cars){
                car.move();
            }
            printCarsPosition(cars);
        }
        printWinners(cars);
    }

    private List<Car> parseCars(String input){

    }

    private int parseMoveCount(String input){

    }

    private void printCarsPosition(List<Car> cars){

    }

    private void printWinners(List<Car> cars){

    }
}
