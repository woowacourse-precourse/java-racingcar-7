package racingcar.view;

public class OutputView {

    public void printInsertRacingCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printCountOfTry(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printResult(){
        System.out.println("실행 결과");
    }

    public void printCarsMove(final String carName,final int moveCount){

        String moveCountmark = "";

        for(int i=0; i<moveCount;i++){
            moveCountmark+="-";
        }

        System.out.println(carName+" : "+moveCountmark);

    }


}
