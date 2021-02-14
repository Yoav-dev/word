package infra;

import java.util.Stack;

class History {
	private Stack<IStep> steps = new Stack<IStep>();
	private Stack<IStep> undoneSteps = new Stack<IStep>();
	private MidWordFile midWordFile;
	
	History(MidWordFile midWordFile) {
		this.midWordFile = midWordFile;
	}

	void add(IStep step) {
		steps.push(step);
		undoneSteps.clear();
	}

	void undo() {
		if (!steps.isEmpty()) {
			IStep step = steps.pop();
			step.undo(midWordFile);
			undoneSteps.push(step);
		}
	}
	
	void redo() {
		if (!undoneSteps.isEmpty()) {
			IStep step = undoneSteps.pop();
			step.redo(midWordFile);
			steps.push(step);
		}
	}
}