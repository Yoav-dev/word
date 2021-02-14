package infra;

class UnderlineStep implements IStep {
	private int start;
	private int end;
	private boolean [] prevStates;
	
	UnderlineStep(int start, int end, boolean [] prevStates) {
		this.start = start;
		this.end = end;
		this.prevStates = prevStates;
	}

	@Override
	public void undo(MidWordFile midWordFile) {
		midWordFile.underline(start, end, prevStates);
	}

	@Override
	public void redo(MidWordFile midWordFile) {
		midWordFile.underline(start, end);
	}
}