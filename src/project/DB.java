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
import java.util.ArrayList;
import java.util.List;

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
	JLabel tbl1;
	JLabel tbl2;
	JLabel tbl3;
	JTable tbl4;
	JLabel tbl5;
	JTextArea comment; //댓글
	JTextArea area1;
	JScrollPane scroll1;
//	댓글을 저장할 리스트
	List<String> commentList = new ArrayList<>();

	// DefaultTableModel 변수 추가
	DefaultTableModel model4;

	DB_GUI(int number, String writer, String title, String date) {

		// Frame
		super("클릭한 게시물");
		setBounds(100, 100, 900, 900);
		setResizable(false);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Component
		btn1 = new JButton("나가기");
		lbl1 = new JLabel("게시물 조회");
		area1 = new JTextArea();
		JButton uploadBtn = new JButton("댓글 업로드");
		uploadBtn.setBounds(770,710,120,30);
		area1.setBounds(10, 90, 210, 500);

		JTextField srch = new JTextField();

		// ---------------------------------------------------------------
		String id = "root";
		String pw = "1234";
		String url = "jdbc:mysql://localhost:3306/게시판";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver Loading Success..");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("DB Connected..");

			tbl1 = new JLabel("NO : " + number);
			tbl2 = new JLabel("글쓴이 :" + writer);
			tbl3 = new JLabel("글제목 : " + title);
			tbl5 = new JLabel("작성날짜 : " + date);
			comment = new JTextArea(); //댓글

			String[] column4 = { "글내용" };
		
			model4 = new DefaultTableModel(column4, 0);
			tbl4 = new JTable(model4);
			tbl4.setRowHeight(300);
//			테이블 수정 불가능
			tbl4.setEnabled(false);

			JScrollPane scroll4 = new JScrollPane(tbl4);
			
			scroll4.setBounds(10, 200, 850, 300);
			lbl1.setBounds(10, 30, 400, 50);
			tbl1.setBounds(10, 100, 100, 50);
			tbl2.setBounds(130, 100, 730, 50);
			tbl3.setBounds(10, 150, 850, 50);
			tbl5.setBounds(10, 750, 850, 50);
			comment.setBounds(10,550,850,150);
			panel.add(tbl1);
			panel.add(tbl2);
			panel.add(tbl3);
			panel.add(tbl5);
			panel.add(comment);
			panel.add(uploadBtn);

			pstmt = conn.prepareStatement("SELECT 글내용 FROM tbl_게시판 WHERE number = ?");
			pstmt.setInt(1, number);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				String content = rs.getString("글내용");
				model4.addRow(new Object[] { content });
			}

//			tbl4.setModel(model4);
			scroll4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);			
			panel.add(scroll4);

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

		btn1.setBounds(770, 800, 90, 30);

		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "나가실?");
				dispose();
			}
		});
		uploadBtn.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        String commentText = comment.getText();
		        if (!commentText.isEmpty()) {
		            // 댓글 리스트에 추가
		            commentList.add(commentText);
		            // 모델 갱신
		            model4.addRow(new Object[] { commentText });
		            // 스크롤 조정
		            tbl4.scrollRectToVisible(tbl4.getCellRect(tbl4.getRowCount() - 1, 0, true));
		            // 댓글 입력 필드 초기화
		            comment.setText("");
		        }
		    }
		});

		area1.setEditable(false);

		btn1.setFont(new Font("굴림", Font.BOLD, 17));
		lbl1.setFont(new Font("굴림", Font.BOLD, 30));
		tbl1.setFont(new Font("굴림", Font.BOLD, 15));
		tbl2.setFont(new Font("굴림", Font.BOLD, 15));
		tbl3.setFont(new Font("굴림", Font.BOLD, 17));
		tbl4.setFont(new Font("굴림", Font.BOLD, 20));
		tbl5.setFont(new Font("굴림", Font.BOLD, 20));

		panel.add(btn1);
		panel.add(lbl1);
		panel.add(srch);

		add(panel);

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