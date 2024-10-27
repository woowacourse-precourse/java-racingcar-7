package racingcar.common.util;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

public class UTF8ConsoleWriter {
	private UTF8ConsoleWriter() {
	}

	private static final PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out, StandardCharsets.UTF_8),
		true);

	public static void print(String s) {
		out.print(s);
	}

	public static void println(String s) {
		out.println(s);
	}

	public static void flush() {
		out.flush();
	}
}
