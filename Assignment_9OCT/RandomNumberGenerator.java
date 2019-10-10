import java.util.Date;

class RandomNumberGenerator extends Thread {

	public static void main(String[] args) {
		
		RandomNumberGenerator generator1 = new RandomNumberGenerator();
		generator1.start();
	}

	@Override
	public void run() {

		for(; ;) {
			Date d = new Date();
			System.out.print((d.getTime()%20)*12);
			try {
				Thread.sleep(2000);
			} catch(InterruptedException ie) {}
			System.out.print("\r");
		}
	}
}