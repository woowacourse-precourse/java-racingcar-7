package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public static class Car {
        String name;
        int move_cnt;

        Car(String name, int move_cnt){
            this.name = name;
            this.move_cnt = move_cnt;
        }
    }


    

    public static void inputCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String user_input = readLine();
        saveCar(user_input);
    }

    public static void main(String[] args) {
        inputCar();
    }
}
