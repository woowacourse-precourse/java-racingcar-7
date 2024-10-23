package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class Application {
    private ArrayList<Car> array;
    private int count;

    public static void main(String[] args) {
        Application app = new Application();
        app.input();
        app.racing();
        app.printResult();
    }

    public void input(){
        Str str = new Str();
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputString = Console.readLine();

        array = str.arrayToList(inputString);

        System.out.println("시도할 횟수는 몇 회인가요?");
        count = Integer.parseInt(Console.readLine());
    }

    private void racing(){
        for(int i = 0; i< count; i++){
            for(Car car : array){
                car.update(1);
                printStatus(car);
            }
            System.out.println("");
        }
    }

    private void printStatus(Car car){
        StringBuilder stringBuilder = new StringBuilder(car.name + " : ");
        for(int i = 0; i< car.value; i++){
            stringBuilder.append("-");
        }
        System.out.println(stringBuilder.toString());
    }

    private void printResult(){
        StringBuilder result = new StringBuilder("최종 우승자 : ");
        for(Car car : array){
            if(car.isMax())
                result.append(car.name).append(", ");
        }
        result.setLength(result.length()-2);
        System.out.println(result.toString());
    }

}