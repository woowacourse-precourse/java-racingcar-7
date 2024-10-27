package racingcar.io.output;

public abstract class Output {

    public static void playGameInit() {
        System.out.println(OutputMessage.PLAY_GAME_DESCRIPTION.getMessage());
    }

    public static void howManyTry() {
        System.out.println(OutputMessage.HOW_MANY_TRY.getMessage());
    }

    public static void executionResult() {
        System.out.println(OutputMessage.EXECUTION_RESULT.getMessage());
    }

    public static void playerResult(String name, int range) {
        String dash = repeatDash(range);
        System.out.printf(OutputMessage.USER_PROGRESS.getMessage() + "\n", name, dash);
    }

    public static void winner(String name) {
        System.out.printf(OutputMessage.WINNER.getMessage(), name);
    }

    private static String repeatDash(int range) {
        return "-".repeat(range);
    }
}
