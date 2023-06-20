package Ch20Ex;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C04GUI extends JFrame{
	C04GUI(){
//		Frame
		super("네번째 프레임창입니다.");
		setBounds(100, 100, 700, 700);
		
//		Panel
		JPanel panel = new JPanel();	//패널 생성
		panel.setLayout(null);
		
//		BTN_Component
		JButton btn1 = new JButton("파일로 저장");
		btn1.setBounds(230,10,100,30);
		JButton btn2 = new JButton("1:1 요청");
		btn2.setBounds(230,50,100,30);
		JButton btn3 = new JButton("대화기록 보기");
		btn3.setBounds(230,90,100,30);
		
//		TXT_Component
		JTextField txt1 = new JTextField();
		txt1.setBounds(10,330,210,30);
//		JTextField txt2 = new JTextField();
//		txt2.setBounds(120,400,100,30);
		
//		TXTAREA_Component
		JTextArea area1 = new JTextArea();
		area1.setBounds(10,10,210,300);
		
//		ScrollPan_Component
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,10,210,300);
		
//		Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(txt1);
//		panel.add(txt2);
//		panel.add(area1);
		panel.add(scroll1);
		
		
//		Frame
		add(panel); //프레임에 panel추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 버튼 클릭시 프로그램 종료
		setVisible(true);
	}
}

public class C01Prac {
	public static void main(String[] args) {
		new C04GUI();
	}
}

