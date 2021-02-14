package infra;

import java.util.ArrayList;

class MidWordFile {
	private ArrayList<FormattedCharacter> content;

	MidWordFile(ArrayList<FormattedCharacter> content) {
		this.content = content;
	}
	
	void add(String addedContent, int position) {
		ArrayList<FormattedCharacter> formattedCharacters = new ArrayList<FormattedCharacter>();
		int addedContentLength = addedContent.length();
		
		for (int i = 0; i < addedContentLength; i++) {
			formattedCharacters.add(new FormattedCharacter(addedContent.charAt(i)));
		}
		
		content.addAll(position, formattedCharacters);
	}
	
	ArrayList<FormattedCharacter> remove(int start, int end) {
		ArrayList<FormattedCharacter> contentRemoved = new ArrayList<FormattedCharacter>();
			
		for (int i = start; i <= end; i++) {
			contentRemoved.add(content.remove(start));
		}
		
		return contentRemoved;
	}
	
	boolean [] italic(int start, int end) {
		boolean [] states = new boolean[end - start + 1];
		
		for (int i = start; i <= end; i++) {
			states[i - start] = content.get(i).italic;
			content.get(i).italic = true;
		}
		
		return states;
	}
	
	boolean [] bold(int start, int end) {
		boolean [] states = new boolean[end - start + 1];
		
		for (int i = start; i <= end; i++) {
			states[i - start] = content.get(i).bold;
			content.get(i).bold = true;
		}
		
		return states;
	}
	
	boolean [] underline(int start, int end) {
		boolean [] states = new boolean[end - start + 1];
		
		for (int i = start; i <= end; i++) {
			states[i - start] = content.get(i).underline;
			content.get(i).underline = true;
		}
		
		return states;
	}
	
	void add(ArrayList<FormattedCharacter> addedContent, int position) {
		content.addAll(position, addedContent);
	}
	
	void italic(int start, int end, boolean [] states) {
		for (int i = 0; i < states.length; i++) {
			content.get(start + i).italic = states[i];
		}
	}
	
	void bold(int start, int end, boolean [] states) {
		for (int i = 0; i < states.length; i++) {
			content.get(start + i).bold = states[i];
		}
	}
	
	void underline(int start, int end, boolean [] states) {
		for (int i = 0; i < states.length; i++) {
			content.get(start + i).underline = states[i];
		}
	}
}