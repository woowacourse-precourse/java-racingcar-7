package racingcar.view;

public class OutputView {
    private static final String OUTPUT_RESULT = "실행결과";
    private static final String OUTPUT_FINAL_WINNER = "최종 우승자 : ";

    public void result(){
        System.out.println(OUTPUT_RESULT);
        return;
    }
    public void finalWinner(String finalWinner){
        System.out.println(OUTPUT_FINAL_WINNER + finalWinner);
    }
}
