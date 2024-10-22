package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesInput = Console.readLine();
        String[] carNames = carNamesInput.split(",");
        List<Car> cars = new ArrayList<>();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int numberOfRounds = Integer.parseInt(Console.readLine());
    }

    class Car{
        private String name;
        private int position = 0;

        public Car(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        public int getPosition(){
            return position;
        }

        public void move(){
            position++;
        }

        public String displayPosition(){
            return "-".repeat(position);
        }
    }
}
