package racingcar.view;

import java.util.List;

public class OutputView {


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

    public void rankResult(List<String> carNames){

        String rankResult = "";

        for(int i = 0;i<carNames.size();i++){

            if(i==0){
                rankResult += carNames.get(i);
            }
            else{
                rankResult += ", "+carNames.get(i);
            }

        }

        System.out.print("최종 우승자 : "+rankResult);
    }


}
