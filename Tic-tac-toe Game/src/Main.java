
public class Main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	            MainFrame.createAndShowGUI();
	            System.out.println("ÂÍÓÒĞÈ ÏÎÒÎÊÀ");

//				InGame.graphOfComputer();
	        }
	    });
		try {
			Thread.sleep(3000);
			System.out.println("ÏÎÄÎÆÄÀËÈ 3 ÑÅÊ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Thread thr = new Thread (new Runnable() {
			public void run() {
				System.out.println("ÂÍÓÒĞÈ ÏÎÒÎÊÀ 2");

			}
			
		});
		
		thr.start();

	}
}
