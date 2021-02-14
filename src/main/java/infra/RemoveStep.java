package infra;

import java.util.ArrayList;

class RemoveStep implements IStep {
	private ArrayList<FormattedCharacter> contentRemoved;
	private int position;
	
	RemoveStep(ArrayList<FormattedCharacter> contentRemoved, int position) {
		this.contentRemoved = contentRemoved;
		this.position = position;
	}

	@Override
	public void undo(MidWordFile midWordFile) {
		midWordFile.add(contentRemoved, position);
	}

	@Override
	public void redo(MidWordFile midWordFile) {
		midWordFile.remove(position, position + contentRemoved.size() - 1);
	}
}