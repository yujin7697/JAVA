package Ch20;

import javax.swing.JFrame;

class C02GUI extends JFrame{
	C02GUI(){
		super("두번째 프레임창입니다.");
		setBounds(100, 100, 700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 버튼 클릭시 프로그램 종료
		setVisible(true);
	}
}

public class C02SwingMain {
	public static void main(String[] args) {
		new C02GUI();
	}
}
