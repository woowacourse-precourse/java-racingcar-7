package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final InputView INPUT_VIEW = new InputView();

    private InputView() {
    }

    public static InputView getInstance() {
        return INPUT_VIEW;
    }

    /**
     * 컨트롤러에서 OutputView 를 정해주고, 그 뷰를 통해서 message 를 전달한다.
     * 이용자는 메세지를 보고 입력 값을 결정한다.
     *
     * @param outputView 메시지를 보여줄 outputView
     * @param message input 요청에 필요한 메시지
     * @return
     */
    public String requestString(OutputView outputView, String message) {
        if (!message.isBlank()) {
            outputView.printLine(message);
        }
        return Console.readLine();
    }

    public void close() {
        Console.close();
    }
}
