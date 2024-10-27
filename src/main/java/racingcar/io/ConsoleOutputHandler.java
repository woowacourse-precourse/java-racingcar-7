package racingcar.io;

import java.util.List;
import racingcar.Car;

public class ConsoleOutputHandler {

    public void printCarNameInstruction(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCountInstruction(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printExecumentInstruction(Car car){
        System.out.print(car.getCarName()+ " : " );
        printProgressLine(car.getForwardCount());
    }

    public void printProgressLine(int forwardCount){
        for(int i=0;i<forwardCount;i++)
        System.out.print("-");

        System.out.println();
    }


}
