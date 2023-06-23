package project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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

public class Search {

	public static void main(String[] args) {
	    DefaultTableModel model = new DefaultTableModel();
	    String searchKeyword = ""; // 원하는 검색 키워드를 입력하세요
	    new Search_GUI(searchKeyword, model);
	}

}

class Search_GUI extends JFrame implements ActionListener, KeyListener {
	

	JButton btn1;

	JLabel lbl1;
	JTable tbl2;
	DefaultTableModel searchModel;
	
	JTextArea area1;
	
	JScrollPane scroll1;
	JScrollPane scroll2;

	Search_GUI(String searchKeyword, DefaultTableModel model) {
		

		// Frame
		super("검색된 글");
		setBounds(100, 100, 900, 900);


		// Panel
		JPanel panel = new JPanel(); // 패널생성
		panel.setLayout(null);


		// Component
		btn1 = new JButton("나가기");

		lbl1 = new JLabel();
		tbl2 = new JTable();

		area1 = new JTextArea();
		// area1.setBounds(10,90,210,300);
		scroll1 = new JScrollPane(area1);
		scroll2 = new JScrollPane(area1);
		
		JTextField srch = new JTextField();
		searchModel = new DefaultTableModel();
		// Positioning
		lbl1.setBounds(10, 10, 860, 80);		//제목
		tbl2.setBounds(10, 100, 860, 680);		//작성 글 
		
		lbl1.setText("'"+searchKeyword+"'" + "(으)로 검색된 결과입니다.");
        for (int row = 0; row < model.getRowCount(); row++) {
            String title = (String) model.getValueAt(row, 2);
            String author = (String) model.getValueAt(row, 1);
            if (title.equalsIgnoreCase(searchKeyword) || author.equalsIgnoreCase(searchKeyword)) {
                Object[] rowData = {
                    model.getValueAt(row, 0),
                    author,
                    title,
                    model.getValueAt(row, 3)
                };
                searchModel.addRow(rowData);
            }
        }
		
		btn1.setBounds(770, 800, 90, 30);		//나가기

		
//		scroll1.setBounds(10, 130, 860, 200);	//인기글 스크롤
//		scroll2.setBounds(10, 340, 860, 450);	//메인글 스크롤
		
//		srch.setBounds(15,800,140,30);			//검색

		// Event처리
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "나가실?");
                dispose(); // 현재 GUI 창 닫기
                
                new Main_GUI(); // GUI1으로 돌아가기
			}
		});		//글작성
		
		lbl1.addKeyListener(this);
		area1.setEditable(false);
		
		btn1.setFont(new Font("굴림",Font.BOLD,12));
		lbl1.setFont(new Font("굴림",Font.BOLD,30));
		
		// Add_Panel_Component
		panel.add(btn1);

		
		panel.add(lbl1);
		panel.add(tbl2);
		

//			panel.add(area1);
		panel.add(scroll1);
		panel.add(scroll2);
		
		panel.add(srch);

		// Frame
		add(panel); // 프레임에 panel추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}