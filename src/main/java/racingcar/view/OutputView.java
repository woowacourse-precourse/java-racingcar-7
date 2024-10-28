package racingcar.view;

public class OutputView {

    private static final String PROMPT = "실행 결과";
    public static final OutputView INSTANCE = new OutputView();
    private OutputView(){}
    public void print(String text){
        System.out.println(text);
    }
    public void printPrompt(){
        System.out.println("\n" + PROMPT);
    }
}
