package racingcar.message;

public enum OutputMessage {
    SOLO_WINNER("최종 우승자 : "),
    JOINT_WINNER("공동 우승자 : ");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        System.out.print(message);
    }
}
