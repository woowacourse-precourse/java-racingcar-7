package racingcar.Service;

import racingcar.Car;

public class Output {
    public void firstPrint(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void cntPrint(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void finalWinPrint(String[] winCarList){
        System.out.print("최종 우승자 : ");
        System.out.print(winCarList[0]);

        for(int i=1;i<winCarList.length;i++){
            System.out.print(", " + winCarList[i]);
        }
    }

    public void printRace(Car[] cars){
        for(Car car : cars){
            System.out.print(car.getCarName()+" : ");
            printCarLo(car);
        }
        System.out.println();
    }

    public void printCarLo(Car car){
        for(int i=0;i<car.getCarLocation();i++){
            System.out.print("-");
        }
        System.out.println();
    }
}
