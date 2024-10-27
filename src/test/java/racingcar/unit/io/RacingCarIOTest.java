package racingcar.unit.io;

import java.io.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.Console;

import racingcar.Application;

import static org.assertj.core.api.Assertions.*;

class RacingCarIOTest {

    private PrintStream stdOut;
    private OutputStream captor;

    /* ===============| 기반코드 |============= */
    @BeforeEach
    public void beforeEach() {
        this.stdOut = System.out;
        this.captor = new ByteArrayOutputStream();
        System.setOut( new PrintStream( this.captor ) );
    }

    @AfterEach
    public void afterEach() {
        System.setOut( stdOut );
        System.out.println(this.getOutput());
    }

    private String getOutput() {
        return this.captor.toString().trim();
    }

    private void virtualConsoleInput( String args ) {
        System.setIn(new ByteArrayInputStream( args.getBytes() ));
        Console.close();
    }

    /* ===============| getInput() |============= */

    @Test
    void 입력_빈문자열_예외처리_중간() {
        assertThatThrownBy(
                () -> {
                    virtualConsoleInput( "aaa,,bbb\n2" );
                    Application.main( new String[]{} );
                }
        ).isInstanceOf( IllegalArgumentException.class );
    }

    @Test
    void 입력_빈문자열_예외처리_맨앞() {
        assertThatThrownBy(
                () -> {
                    virtualConsoleInput( ",aaa,bbb\n2" );
                    Application.main( new String[]{} );
                }
        ).isInstanceOf( IllegalArgumentException.class );
    }

    @Test
    void 입력_빈문자열_예외처리_맨뒤() {
        assertThatThrownBy(
                () -> {
                    virtualConsoleInput( "aaa,bbb,\n2" );
                    Application.main( new String[]{} );
                }
        ).isInstanceOf( IllegalArgumentException.class );
    }

    @Test
    void 입력_시도횟수_음의정수_예외처리() {
        assertThatThrownBy(
                () -> {
                    virtualConsoleInput( "aaa,bbb\n-1" );
                    Application.main( new String[]{} );
                }
        ).isInstanceOf( IllegalArgumentException.class );
    }

    @Test
    void 입력_시도횟수_0_예외처리() {
        assertThatThrownBy(
                () -> {
                    virtualConsoleInput( "aaa,bbb\n0" );
                    Application.main( new String[]{} );
                }
        ).isInstanceOf( IllegalArgumentException.class );
    }


    /* ===============| printOutput() |============= */

}