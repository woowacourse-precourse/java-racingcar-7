package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름, 시도할 횟수 입력
        Car car = new Car();
        car.input();
    }
}

class Car {
    public String[] carLst;
    public int time;
    public int[] numLst;
    public int[] forward;
    public void input(){
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        this.carLst = cars.split(",");
        System.out.print("시도할 횟수는 몇 회인가요?");
        try {
            this.time = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("IllegalArgumentException");
        }
        forward = new int[carLst.length];
    }

    private void giveRandomNumbers(){
        for (int i = 0; i < carLst.length; i++){
            numLst[i] = Randoms.pickNumberInRange(0, 9);
        }
    }
    private void move(){
        for (int i = 0; i < numLst.length; i++){
            if (numLst[i] >= 4){
                forward[i] += 1;
            }
        }
    }
    private void printAtTime(){
        for (int i = 0; i < carLst.length; i++){
            System.out.println(carLst[i] + " : " + "-".repeat(forward[i]));
        }
    }
}