package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름, 시도할 횟수 입력
        Car car = new Car();
        car.inputCar();
        car.inputNum();
        car.check();
        // 결과 도출
        car.process();
        car.result();
    }
}

class Car {
    private String[] carLst;
    private int time;
    private int[] numLst;
    private int[] forward;
    private int cnt;
    private int[] winnerLst;

    public void inputCar(){
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        this.carLst = cars.split(",");
    }
    public void inputNum(){
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
    private int max(int[] lst){
        int maxValue = 0;
        for (int i : lst){
            if (i > maxValue){
                maxValue = i;
            }
        }
        return maxValue;
    }
    private int[] append(int[] lst, int val){
        int[] newLst = new int[lst.length + 1];
        for (int i = 0; i < lst.length; i++){
            newLst[i] = lst[i];
        }
        newLst[lst.length + 1] = val;
        return newLst;
    }
    private void findWinnerNumber(){
        int forwardMax = max(forward);
        for (int i = 0; i < forward.length; i++) {
            if (forward[i] == forwardMax) {
                winnerLst = append(winnerLst, i);
            }
        }
    }
    private String findWinner(){
        String winner = carLst[winnerLst[0]];
        if (winnerLst.length == 1){
            return winner;
        }
        for (int i = 1; i < winnerLst.length; i++){
            winner = winner + ", " + carLst[winnerLst[i]];
        }
        return winner;
    }
    public void check(){
        for (String car : carLst){
            if (car.length() > 5){
                throw new IllegalArgumentException("IllegalArgumentException");
            }
        }
        if (time < 0){
            throw new IllegalArgumentException("IllegalArgumentException");
        }
    }
    public void process(){
        System.out.println("실행 결과");
        for (int i = 0; i < time; i++){
            giveRandomNumbers();
            move();
            printAtTime();
            System.out.println();
        }
    }
    public void result(){
        findWinnerNumber();
        System.out.println("최종 우승자 : " + findWinner());
    }
}