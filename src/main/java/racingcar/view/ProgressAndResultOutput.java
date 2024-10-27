package racingcar.view;

import java.util.List;

public class ProgressAndResultOutput {
    private enum OutputMessage{
        PROGRESS_OUTPUT_PROMPT("실행 결과"),
        NAME_STEP_SEPARATOR(" : "),
        STEP_SYMBOL("-"),
        WINNER_OUTPUT_PROMPT("최종 우승자 : "),
        WINNER_SEPARATOR(", ");

        final private String message;

        public String getMessage(){
            return message;
        }

        OutputMessage(String message) {
            this.message = message;
        }
    }


    public void startProgressOutput(){
        System.out.println();
        System.out.println(OutputMessage.PROGRESS_OUTPUT_PROMPT.getMessage());
    }
    public void displayRoundProgress(List<String> carsName, List<Integer>carsStep){
        for(int i = 0; i < carsName.size(); i++){
            System.out.println(carsName.get(i) + OutputMessage.NAME_STEP_SEPARATOR.getMessage() + OutputMessage.STEP_SYMBOL.getMessage().repeat(carsStep.get(i)));
        }
        System.out.println();
    }

    public void winnerOutput(List<String> winner){
        System.out.print(OutputMessage.WINNER_OUTPUT_PROMPT.getMessage());
        if(winner.size() != 1){
            for(int i = 0; i < winner.size()-1; i++){
                System.out.print(winner.get(i) + OutputMessage.WINNER_SEPARATOR.getMessage());
            }
        }
        System.out.println(winner.getLast());
    }
}
