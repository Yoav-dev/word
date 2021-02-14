package main;

import org.junit.jupiter.api.Test;

import infra.IPrinter;
import infra.WordFile;
import ui.ConsolePrinter;

public class Tests {
	@Test
	public void test() {
		IPrinter printer = new ConsolePrinter();
		WordFile wordFile = new WordFile();
		wordFile.add("abc");
		wordFile.undo();
		printer.print(wordFile.getContent());
	}
}