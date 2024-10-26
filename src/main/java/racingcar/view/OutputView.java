package racingcar.view;

public class OutputView {

    private final int startIndex = 0;
    public void print(String winner){
        System.out.printf("최종 우승자 : %s\n", winner);
    }

    public void printCarsMove(String carName, int position){
        System.out.printf("%s : ");

        for(int i = startIndex; i < position; i++){
            System.out.printf("-");
        }
        System.out.println();

    }
}
