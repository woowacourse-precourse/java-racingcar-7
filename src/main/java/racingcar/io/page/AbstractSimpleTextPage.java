package racingcar.io.page;

public abstract class AbstractSimpleTextPage implements Page<String> {

    @Override
    public void render() {
        this.print();
    }

    @Override
    public void render(String content) {
        this.setContent(content);
        this.print();
    }

    private void print() {
        String content = this.getContent() + (this.isNewLineAtEOF() ? "\n" : "");
        System.out.print(content);
    }
}
