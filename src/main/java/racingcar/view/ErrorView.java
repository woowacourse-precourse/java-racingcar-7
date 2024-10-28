package racingcar.view;

public class ErrorView {
    public static void error_Empty() {
        throw new IllegalArgumentException(Message.ERROR_EMPTY);
    }

    public static void error_OneCar() {
        throw new IllegalArgumentException(Message.ERROR_ONECAR);
    }

    public static void error_OverName() {
        throw new IllegalArgumentException(Message.ERROR_OVERNAME);
    }

    public static void error_InvalidName() {
        throw new IllegalArgumentException(Message.ERROR_INVALIDNAME);
    }

    public static void error_SameName() {
        throw new IllegalArgumentException(Message.ERROR_SAMENAME);
    }

    public static void error_EmptyCount() {
        throw new IllegalArgumentException(Message.ERROR_EMPTYCOUNT);
    }

    public static void error_InvalidCount1() {
        throw new IllegalArgumentException(Message.ERROR_INVALIDCOUNT1);
    }

    public static void error_InvalidCount2() {
        throw new IllegalArgumentException(Message.ERROR_INVALIDCOUNT2);
    }


}
