import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


public class MyListener {
	public static void addAnActionListenerClear(JButton button) { // ход игрока
		ActionListener actList = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					button.setText("НОЛИК");
					button.setEnabled(false);
					button.setBackground(Color.green);
					String strBut = button.getActionCommand();
					whoseMoveIs(false);
					InGame.gamerWin();
					InGame.deleteBut(strBut);
					InGame.compWin();
					InGame.whatMove(InGame.getLastMove());
				}
		};
		button.addActionListener(actList);
	}
	public static void whoseMoveIs (boolean move) { // метод отслеживает чей ход
		
		move = true; // true - ход игрока
		if (move) {
			MainFrame.whoseMove.setText("GAMER");
		} else {
			MainFrame.whoseMove.setText("COMPUTER");

		}
	}
	

}
