package racingcar.ui;

public class UserInputRequester {
    private final StringReader reader;
    private final StringPrinter printer;

    public UserInputRequester(StringReader reader, StringPrinter printer) {
        this.reader = reader;
        this.printer = printer;
    }

    public String request(String inputPrompt) {
        printer.print(inputPrompt);
        return reader.readLine();
    }
}