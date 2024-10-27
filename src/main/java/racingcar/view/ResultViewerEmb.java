package racingcar.view;

public class ResultViewerEmb implements ResultViewer {
    @Override
    public void output(String message){
        System.out.print(message);
    }
}
