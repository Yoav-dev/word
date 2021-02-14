package infra;

import java.util.ArrayList;

public class WordFile {
	private ArrayList<FormattedCharacter> content = new ArrayList<FormattedCharacter>();
	MidWordFile midWordFile = new MidWordFile(content);
	private History history = new History(midWordFile);
	
	synchronized public void add(String addedContent, int position) {
		midWordFile.add(addedContent, position);
		history.add(new AddStep(addedContent, position));
	}
	
	synchronized public void add(String addedContent) {
		add(addedContent, content.size());
	}
	
	synchronized public void remove(int start, int end) {
		ArrayList<FormattedCharacter> contentRemoved = midWordFile.remove(start, end);
		history.add(new RemoveStep(contentRemoved, start));
	}
	
	synchronized public void italic(int start, int end) {
		boolean [] states = midWordFile.italic(start, end);
		history.add(new ItalicStep(start, end, states));
	}
	
	synchronized public void bold(int start, int end) {
		boolean [] states = midWordFile.bold(start, end);
		history.add(new BoldStep(start, end, states));
	}
	
	synchronized public void underline(int start, int end) {
		boolean [] states = midWordFile.underline(start, end);
		history.add(new UnderlineStep(start, end, states));
	}

	synchronized public void undo() {
		history.undo();
	}
	
	synchronized public void redo() {
		history.redo();
	}
	
	synchronized public FormattedCharacter [] getContent() {
		FormattedCharacter [] content = new FormattedCharacter[this.content.size()];
		
		for (int i = 0; i < content.length; i++) {
			content[i] = this.content.get(i);
		}
		
		return content;
	}
}