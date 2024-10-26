package utils;

import java.text.BreakIterator;

public class LetterCounter {
    public static int letterCounter(String name){
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
