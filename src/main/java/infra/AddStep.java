package infra;

class AddStep implements IStep {
	private String contentAdded;
	private int position;
	
	AddStep(String contentAdded, int position) {
		this.contentAdded = contentAdded;
		this.position = position;
	}
	
	@Override
	public void undo(MidWordFile midWordFile) {
		midWordFile.remove(position, position + contentAdded.length() - 1);
	}

	@Override
	public void redo(MidWordFile midWordFile) {
		midWordFile.add(contentAdded, position);
	}
}