import java.io.IOException;
class Timer extends Thread {
	public static void main(String[] args) {
		
		Timer t = new Timer();
		t.start();
	}

	@Override 
	public void run() {
		try {
			for(int i=0;i>=0;i++) {
				System.out.print(i);
				Thread.sleep(500);
				System.out.print("\r");
			}
		} catch (InterruptedException ie) {}
	}
}
