package controll;

public class StartRunnable implements Runnable {
	private Caretaker root;
	public StartRunnable(Caretaker c) {
		this.root=c;
	}
	@Override
	public void run() {
		root.startF();
	}

}
