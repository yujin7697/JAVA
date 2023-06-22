package project;

import java.awt.Color;
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
	JTable tbl1;
	JTable tbl2;
	JTable tbl3;
	JTable tbl4;
	JTable tbl5;

	JTextArea area1;

	JScrollPane scroll1;
//	JScrollPane scroll2;

	DefaultTableModel model;

	DB_GUI() {
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

			String[] column1 = { "number" };
			String[] column2 = { "글쓴이" };
			String[] column3 = { "글제목" };
			String[] column4 = { "글내용" };
			String[] column5 = { "작성날짜" };

			DefaultTableModel model1 = new DefaultTableModel(column1, 0);
			DefaultTableModel model2 = new DefaultTableModel(column2, 0);
			DefaultTableModel model3 = new DefaultTableModel(column3, 0);
			DefaultTableModel model4 = new DefaultTableModel(column4, 0);
			DefaultTableModel model5 = new DefaultTableModel(column5, 0);

			tbl1 = new JTable(model1);
			tbl2 = new JTable(model2);
			tbl3 = new JTable(model3);
			tbl4 = new JTable(model4);
			tbl5 = new JTable(model5);

			JScrollPane scroll1 = new JScrollPane(tbl1);
			JScrollPane scroll2 = new JScrollPane(tbl2);
			JScrollPane scroll3 = new JScrollPane(tbl3);
			JScrollPane scroll4 = new JScrollPane(tbl4);
			JScrollPane scroll5 = new JScrollPane(tbl5);

			lbl1.setBounds(10, 10, 400, 80); // 대제목
			scroll1.setBounds(10, 100, 100, 30); // 게시글번호 칸
			scroll2.setBounds(130, 100, 730, 30); // 작성자 칸
			scroll3.setBounds(10, 150, 850, 30); // 제목 칸
			scroll4.setBounds(10, 200, 850, 530); // 내용 칸
			scroll5.setBounds(10, 750, 850, 30); // 시간 칸
			panel.add(scroll1);
			panel.add(scroll2);
			panel.add(scroll3);
			panel.add(scroll4);
			panel.add(scroll5);
			
			pstmt = conn.prepareStatement("select * from tbl_게시판");
			rs = pstmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					Object[] rowData = { rs.getInt("number"), rs.getString("글쓴이"), rs.getString("글제목"),
							rs.getString("글내용"), rs.getString("작성날짜") };
				}
			}

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
		tbl5.setFont(new Font("굴림", Font.BOLD, 10));

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
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
