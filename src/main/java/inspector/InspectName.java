package inspector;

import constant.Constant;
import java.text.BreakIterator;

public class InspectName {
    public void inspecting(String[] targetGroup){
        for (String content : targetGroup) {
            detectNameLengthLimit(content);
        }
    }

    private void detectNameLengthLimit(String name){
        if(letterCounter(name) > Constant.RACING_CAR_NAME_LIMIT){
            throw new IllegalArgumentException("글자 수가 넘음");
        }
    }

    public int letterCounter(String name){
        /* BreakIterator 클래스는 유니코드의 문자열의 경계 단위로 글자 수를 세는 클래스이다.
        이는 utf8mb4 인코딩 방식을 포함한 모든 유니코드를 지원한다. */
        int count = 0;
        BreakIterator counter = BreakIterator.getCharacterInstance();
        counter.setText(name);
        while(counter.next() != BreakIterator.DONE){
            count++;
        }
        return count;
    }
}