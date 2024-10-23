package racingcar.Service;

import racingcar.Car;

public class Output {
    public void firstPrint(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void cntPrint(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRace(Car[] cars){
        for(Car car : cars){
            System.out.print(car.getCarName()+" : ");
            printCarLo(car);
        }
    }

    public void printCarLo(Car car){
        for(int i=0;i<car.getCarLocation();i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
