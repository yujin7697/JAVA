package Ch20;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

class C06GUI extends JFrame implements ActionListener,KeyListener,MouseListener{
	JButton btn1;
	JButton btn2;
	JTextField txt1;
	JTextField txt2;
	JTextArea area1;
	
	C06GUI(){
//		Frame
		super("여섯번째 프레임창입니다.");
		setBounds(100, 100, 700, 700);
		
//		Panel
		JPanel panel = new JPanel();	//패널 생성
		panel.setLayout(null);
		
//		BTN_Component
		btn1 = new JButton("Button1");
		btn1.setBounds(10,10,100,30);
		btn2 = new JButton("Button2");
		btn2.setBounds(120,10,100,30);
		
//		TXT_Component
		txt1 = new JTextField();
		txt1.setBounds(10,50,100,30);
		txt2 = new JTextField();
		txt2.setBounds(120,50,100,30);
		
//		TXTAREA_Component
		area1 = new JTextArea();
		area1.setBounds(10,90,210,300);
		
//		ScrollPan_Component
		JScrollPane scroll1 = new JScrollPane(area1);
		scroll1.setBounds(10,90,210,300);
		
//		Event처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		txt1.addKeyListener(this);
		txt2.addKeyListener(this);
		area1.addMouseListener(this);
		
//		Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(txt1);
		panel.add(txt2);
//		panel.add(area1);
		panel.add(scroll1);
		
		
//		Frame
		add(panel); //프레임에 panel추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x 버튼 클릭시 프로그램 종료
		setVisible(true);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("이벤트 발생");
		if(e.getSource()==btn1) {
			System.out.println("Button1클릭");
		}else if(e.getSource()==btn2) {
			System.out.println("Button2클릭");
		}
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
//		키를 뗏을 때(UNICODE 지원)
//		System.out.println("KeyTyped() : "+ e.getKeyChar());
		
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
//		키를 눌렀을 때		
//		System.out.println("KeyPressed() : "+ e.getKeyChar());
//		System.out.println("KeyPressed() : "+ e.getKeyCode());
		if(e.getSource()==txt1) {
			if(e.getKeyCode()==10) {
				System.out.println("txt1's Enter");
				String str=txt1.getText();
				area1.append(str+"\n");
				txt1.setText("");
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
//		키를 뗏을 때(UNICODE 미지원)
//		System.out.println("KeyReleased()");
	}
	@Override
	public void mouseClicked(MouseEvent e) {
//		System.out.println("mouseClicked...");
//		System.out.println(e.getPoint().x + " " + e.getPoint().y);
		int offset = area1.viewToModel(e.getPoint());
//		System.out.println(offset);
		
		try {
			int row = area1.getLineOfOffset(offset);
			System.out.println(row);
			int startOffset=area1.getLineStartOffset(row);	//행의 첫 문자를 알 수 있음
			int endOffset=area1.getLineEndOffset(row);		//행의 마지막 문자를 알 수 있음
			String txt = area1.getText(startOffset, endOffset-startOffset);
			System.out.println(txt);
		} catch (BadLocationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
//		System.out.println("mousePressed...");
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
//		System.out.println("mouseReleased...");
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
//		System.out.println("mouseEntered...");
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
//		System.out.println("mouseExited...");
		
	}
}

public class C06SwingMain {
	public static void main(String[] args) {
		new C06GUI();
	}
}
