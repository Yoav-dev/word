package infra;

class BoldStep implements IStep {
	private int start;
	private int end;
	private boolean [] prevStates;
	
	BoldStep(int start, int end, boolean [] prevStates) {
		this.start = start;
		this.end = end;
		this.prevStates = prevStates;
	}

	@Override
	public void undo(MidWordFile midWordFile) {
		midWordFile.bold(start, end, prevStates);
	}

	@Override
	public void redo(MidWordFile midWordFile) {
		midWordFile.bold(start, end);
	}
}