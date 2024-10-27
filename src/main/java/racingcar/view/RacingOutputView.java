package racingcar.view;

public class RacingOutputView {

    private static final String GUIDE_MESSAGE = "실행 결과";
    private static final String NAME_SCOPE = "%s : ";
    private static final String COUNT_MARK = "-";
    private static final String ENTER = System.lineSeparator();

    public void showGuide() {
        enter();
        System.out.println(GUIDE_MESSAGE);
    }

    public void showProgressResult(String name, int distance) {
        System.out.printf(NAME_SCOPE, name);
        System.out.println(COUNT_MARK.repeat(distance));
    }

    public void enter() {
        System.out.print(ENTER);
    }
}
