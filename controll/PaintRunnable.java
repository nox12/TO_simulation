package controll;

public class PaintRunnable implements Runnable{
	private Caretaker root;
	public PaintRunnable(Caretaker c) {
		this.root=c;
	}
	@Override
	public void run() {
		if(root.getStart()) {
			if(root.getPaint()) {
				root.setPaint(false);
				root.repaint();
				try {
					Thread.sleep(33);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				finally {
					root.setPaint(true);
				}
			}
		}
		
	}
	
}
