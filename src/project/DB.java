package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class DB extends MyWriter_GUI {

	public static void main(String[] args) {
		new DB_GUI();
	}

}

class DB_GUI extends JFrame implements ActionListener, KeyListener {
	JButton btn1;
	JLabel lbl1;
	JLabel tbl1;JLabel tbl2;JLabel tbl3;JTable tbl4;JLabel tbl5;
	JTextArea area1;
	JScrollPane scroll1;
//	JScrollPane scroll2;
//	DefaultTableModel model;
	int number; String writer; String title; String date;
	
	DB_GUI(int number, String writer, String title, String date) {
		
		// Frame
		super("클릭한 게시물");
		setBounds(100, 100, 900, 900);
		setResizable(false);

		// Panel
		JPanel panel = new JPanel(); // 패널생성
		panel.setLayout(null);

		// Component
		btn1 = new JButton("나가기");

		lbl1 = new JLabel("게시물 조회");
		
		
		area1 = new JTextArea();
		area1.setBounds(10, 90, 210, 300);
//		scroll1 = new JScrollPane(area1);
//		scroll2 = new JScrollPane(area1);

		JTextField srch = new JTextField();

		// ---------------------------------------------------------------
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/게시판";

		// JDBC참조변수
		Connection conn = null; // DB연결용 참조변수
		PreparedStatement pstmt = null; // SQL쿼리 전송용 참조변수
		ResultSet rs = null; // SQL쿼리 결과(SELECT결과) 수신용 참조변수

		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이브 적재
			System.out.println("Driver Loading Success..");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connected..");
			
			tbl1 = new JLabel("NO : " + number);
			tbl2 = new JLabel("글쓴이 :" + writer);
			tbl3 = new JLabel("글제목 : " + title);
			tbl5 = new JLabel("작성날짜 : " + date);
			

//			String[] column1 = {"number"};
//			String[] column2 = {"글쓴이"};
//			String[] column3 = {"글제목"};
			String[] column4 = {"글내용"};
//			String[] column5 = {"작성날짜"};
//
//			DefaultTableModel model1 = new DefaultTableModel(column1, 0);
//			DefaultTableModel model2 = new DefaultTableModel(column2, 0);
//			DefaultTableModel model3 = new DefaultTableModel(column3, 0);
			DefaultTableModel model4 = new DefaultTableModel(column4, 0);
//			DefaultTableModel model5 = new DefaultTableModel(column5, 0);
//
//			tbl1 = new JTable(model1);
//			tbl2 = new JTable(model2);
//			tbl3 = new JTable(model3);
			tbl4 = new JTable(model4);
//			tbl5 = new JTable(model5);

//			JScrollPane scroll1 = new JScrollPane(tbl1);
//			JScrollPane scroll2 = new JScrollPane(tbl2);
//			JScrollPane scroll3 = new JScrollPane(tbl3);
			JScrollPane scroll4 = new JScrollPane(tbl4);
//			JScrollPane scroll5 = new JScrollPane(tbl5);

			lbl1.setBounds(10, 30, 400, 50); // 대제목
			tbl1.setBounds(10, 100, 100, 50); // 게시글번호 칸
			tbl2.setBounds(130, 100, 730, 50); // 작성자 칸
			tbl3.setBounds(10, 150, 850, 50); // 제목 칸
			tbl5.setBounds(10, 750, 850, 50); // 시간 칸
			scroll4.setBounds(10, 200, 850, 530); // 내용 칸
			panel.add(tbl1);
			panel.add(tbl2);
			panel.add(tbl3);
			panel.add(tbl5);
			panel.add(scroll4);

//			pstmt = conn.prepareStatement("select * from tbl_게시판");
//			rs = pstmt.executeQuery();

//			if (rs != null) {
//				while (rs.next()) {
//					int postNumber = rs.getInt("number");
//					String writer = rs.getString("글쓴이");
//					String title = rs.getString("글제목");
//					String content = rs.getString("글내용");
//					String date = rs.getString("작성날짜");
//					model1.addRow(new Object[]{postNumber});
//					model2.addRow(new Object[]{writer});
//					model3.addRow(new Object[]{title});
//					model4.addRow(new Object[]{content});
//					model5.addRow(new Object[]{date});
//					
//				}
//			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {

				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ------------------------------------------------------------------

		// Positioning

		btn1.setBounds(770, 800, 90, 30); // 나가기

		// Event처리
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "나가실?");
				dispose(); // 현재 GUI 창 닫기

//                new GUI(); // GUI1으로 돌아가기
			}
		}); // 글작성

		area1.setEditable(false);

		btn1.setFont(new Font("굴림", Font.BOLD, 17));
		lbl1.setFont(new Font("굴림", Font.BOLD, 30));
		tbl1.setFont(new Font("굴림", Font.BOLD, 15));
		tbl2.setFont(new Font("굴림", Font.BOLD, 15));
		tbl3.setFont(new Font("굴림", Font.BOLD, 17));
		tbl4.setFont(new Font("굴림", Font.BOLD, 20));
		tbl5.setFont(new Font("굴림", Font.BOLD, 20));

		// Add_Panel_Component
		panel.add(btn1);

		panel.add(lbl1);

		panel.add(srch);

		// Frame
		add(panel); // 프레임에 panel추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {}

}
