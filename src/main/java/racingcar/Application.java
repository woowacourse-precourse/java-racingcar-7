package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;


public class Application {

    public static String[] saveCar(String inputName){
        String[] carNames = inputName.split(",");

        for(String name : carNames){
            if(name.length() > 5){
                throw new IllegalArgumentException(name + " 5글자를 초과합니다.");
            }
            else if (name.length() <= 0) {
                throw new IllegalArgumentException("유효하지 않은 값입니다.");
            }
        }

        return carNames;
    }

    public static int saveMoveCount(String inputMoveCount) {
        int moveCount = Integer.parseInt(inputMoveCount);

        if(moveCount < 0){
            throw new IllegalArgumentException("이동 횟수가 유효하지 않습니다.");
        }

        return moveCount;
    }

    public static void moveCar(int[] moveStatus){
        for(int i=0 ; i < moveStatus.length ; i++) {
            if(canMove()) {
                moveStatus[i] += 1;
            }
        }
    }

    public static boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);

        return randomValue >= 4;
    }

    public static void printStatus(String[] carName, int[] moveStatus){
        for(int i = 0 ; i < carName.length ; i++){
            System.out.print(carName[i]+" : ");

            for(int j = 0 ; j < moveStatus[i] ; j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static int findMax(int[] moveStatus){
        int maxValue = 0;

        for (int status : moveStatus) {
            if (status > maxValue) {
                maxValue = status;
            }
        }

        return maxValue;
    }

    public static void printWinnver(String[] carName, int[] moveStatus){
        int maxValue = findMax(moveStatus);

        System.out.print("최종 우승자 : ");

        String winner = "";
        for(int i = 0 ; i < moveStatus.length ; i++){
            if(moveStatus[i] == maxValue){
                winner = updateWinner(winner, carName[i]);
            }
        }

        System.out.println(winner);
    }

    public static String updateWinner(String winner, String name){
        if(winner.isEmpty()){
            return name;
        }else{
            return winner+", "+name;
        }
    }


    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputMoveCount = Console.readLine();

        String[] carName = saveCar(inputName);
        int moveCount = saveMoveCount(inputMoveCount);
        int[] moveStatus = new int[carName.length];

        for(int i = 0 ; i < moveCount ; i++){
            moveCar(moveStatus);
            printStatus(carName, moveStatus);
        }

        printWinnver(carName, moveStatus);
    }
}
