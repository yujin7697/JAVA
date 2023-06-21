package Ch25;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class C01GUI extends JFrame implements ActionListener,KeyListener
{
	//
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JTextField txt1;
	JTextArea area1;
	JTextArea area2;
	Thread th1;
	Thread th2;
	C01GUI(){
		super(); //상위클래스 생성자 호출
		
		setTitle("Listner적용하기");
		
		//패널 추가
		JPanel pan1 = new JPanel();
		
		 
		
		//컴포넌트 객체 생성
		btn1 = new JButton("시작");
		btn2 = new JButton("중지");
		
		btn3 = new JButton("시작");
		btn4 = new JButton("중지");
		txt1 = new JTextField();
		area1 = new JTextArea();
		area2 = new JTextArea();
		JScrollPane scroll1 = new JScrollPane(area1);
		JScrollPane scroll2 = new JScrollPane(area2);
		
		//컴포넌트 위치 지정 
		scroll1.setBounds(50,50,190,280);
		scroll2.setBounds(300,50,190,280);
		//area1.setBounds(50,50,190,280);  // Scroll추가시 제거
		txt1.setBounds(50,350,190,30);
		btn1.setBounds(50,400,80,30);
		btn2.setBounds(160,400,80,30);
		btn3.setBounds(300,400,80,30);
		btn4.setBounds(410,400,80,30);
		
		//컴포넌트를 리스너에 등록
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		txt1.addKeyListener(this);
		
		//기타설정
		area1.setEditable(false);
		
		//패널에 컴포넌트 추가
		pan1.add(btn1);
		pan1.add(btn2);
		pan1.add(btn3);
		pan1.add(btn4);
		pan1.add(txt1);
		//pan1.add(area1);  // Scroll추가시 제거
		pan1.add(scroll1);
		pan1.add(scroll2);
		
		//레이아웃 null
		pan1.setLayout(null);
		
		//패널을 프레임에 추가
		add(pan1);	
		setBounds(100,100,600,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==btn1) {
//		 	스레드1 시작
			C03Worker1 worker1 = new C03Worker1(this);	//생성된 C01GUI 객체 주소
			th1 = new Thread(worker1);			//분리된 공간에 적용
			th1.start();								//실행
		
		}
		
		if(e.getSource()==btn2) {
			th1.interrupt();
						
		}
		if(e.getSource()==btn3) {
//		 	스레드2 시작
			C03Worker2 worker2 = new C03Worker2(this);	//생성된 C01GUI 객체 주소
			th2 = new Thread(worker2);			//분리된 공간에 적용
			th2.start();								//실행
			 
		}
		if(e.getSource()==btn4) {
			th2.interrupt();
			
		}
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//System.out.println(e.getKeyChar());
		//System.out.println(e.getKeyCode());
		if(e.getKeyCode()==10) //엔터키 입력 
		{
			String tmp = txt1.getText();
			area1.append(tmp+"\n");
			txt1.setText("");
			
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}


public class C03SwingThread {

	public static void main(String[] args) {
		
		new C01GUI();

	}

}
