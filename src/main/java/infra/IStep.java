package infra;

interface IStep {
	void undo(MidWordFile midWordFile);
	void redo(MidWordFile midWordFile);
}