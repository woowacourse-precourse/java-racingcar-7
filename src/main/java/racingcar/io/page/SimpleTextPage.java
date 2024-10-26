package racingcar.io.page;

public class SimpleTextPage extends AbstractSimpleTextPage {

    private boolean isNewLineEOF;

    private String content;

    public SimpleTextPage() {
        this.isNewLineEOF = false;
        this.content = "";
    }

    public SimpleTextPage(String content) {
        this.isNewLineEOF = false;
        this.content = content;
    }

    public SimpleTextPage(String content, boolean isNewLineEOF) {
        this.isNewLineEOF = isNewLineEOF;
        this.content = content;
    }

    @Override
    public void isNewLineAtEOF(boolean isNewLineAtEOF) {
        this.isNewLineEOF = isNewLineAtEOF;
    }

    @Override
    public boolean isNewLineAtEOF() {
        return this.isNewLineEOF;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getContent() {
        return this.content;
    }

}
