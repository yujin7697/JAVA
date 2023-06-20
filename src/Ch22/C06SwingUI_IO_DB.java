package Ch22;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Ch01.C02SystemOut;

class GUI extends JFrame implements ActionListener,KeyListener{
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JTextField txt1;
	
	JTextField txt2;
	JTextArea area1;
	JScrollPane scroll1;
	
	//DB INSERT FRAME_WINDOW
	JFrame Frm_Insert;
	JFrame Frm_Update;
	JFrame Frm_Delete;
	JFrame Frm_Select;
	
	String id="root";
	String pw="1234";
	String url="jdbc:mysql://localhost:3306/tmpdb";
	
//	JDBC참조변수
	Connection conn = null;			
	PreparedStatement pstmt = null;		
	ResultSet rs = null;
	
	GUI(){
		//Frame
		super("프레임창입니다");
		setBounds(100,100,550,400);
		
		//Panel
		JPanel panel = new JPanel();		//패널생성
		panel.setLayout(null);
		
		//Component
		btn1 = new JButton("IO_저장하기");
		btn2 = new JButton("IO_불러오기");
		btn3 = new JButton("DB_INSERT");
		btn4 = new JButton("DB_UPDATE");
		btn5 = new JButton("DB_DELETE");
		btn6 = new JButton("DB_SELECT");
		txt1=new JTextField();
		txt2=new JTextField();
		area1=new JTextArea();
		//area1.setBounds(10,90,210,300);
		scroll1=new JScrollPane(area1);
		
		
		//Positioning
		txt1.setBounds(10,270,350,30);
		btn1.setBounds(370,10,120,30);
		btn2.setBounds(370,50,120,30);
		btn3.setBounds(370,90,120,30);	//DB_INSERT
		btn4.setBounds(370,130,120,30);	//DB_UPDATE
		btn5.setBounds(370,170,120,30);	//DB_UPDATE
		btn6.setBounds(370,210,120,30);	//DB_UPDATE
		scroll1.setBounds(10,10,350,250);
		
		
		//Event처리
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		btn3.addActionListener(this); //DB
		btn4.addActionListener(this); //DB
		btn5.addActionListener(this); //DB
		btn6.addActionListener(this); //DB
		txt1.addKeyListener(this);
		area1.setEditable(false);

		
		
		//Add_Panel_Component
		panel.add(btn1);
		panel.add(btn2);
		panel.add(btn3);
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		panel.add(txt1);
		panel.add(txt2);
//		panel.add(area1);
		panel.add(scroll1);
		
		//Frame
		add(panel);	//프레임에 panel추가
		
//		DB Connection
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	//드라이버 적재
			System.out.println("Driver Loading Success..");
			conn = DriverManager.getConnection(url,id,pw);
			System.out.println("DB Connected..");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		//System.out.println("이벤트 발생");
		if(e.getSource()==btn1) {
			System.out.println("저장하기 클릭");
			
			String context = area1.getText();
			String dirPath = "c:\\iotest\\";
			String filename = UUID.randomUUID().toString();
			
			try {
				Writer out = new FileWriter(dirPath+filename+".txt");
				out.write(new Date().toString()+"\n");
				out.write(context);
				out.flush();
				out.close();
			
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			

		}else if(e.getSource()==btn2) {
			System.out.println("불러오기 클릭");
			JFileChooser fileChooser = new JFileChooser();
			
			File defaultdirpath = new File("c:\\iotest\\");	//기본경로 File객체
			fileChooser.setCurrentDirectory(defaultdirpath);//기본경로 설정
			
			int returnValue= fileChooser.showOpenDialog(null);
			String filename=null;
			if(returnValue==JFileChooser.APPROVE_OPTION)	//파일선택한경우
			{
				filename=fileChooser.getSelectedFile().toString();
			}
			System.out.println(filename);
			
			try {
				Reader in = new FileReader(filename);
				area1.setText("");
				StringBuffer buffer=new StringBuffer();
				while(true)
				{
					int data=in.read();
					if(data==-1)
						break;
					buffer.append((char)data);
				}
				in.close();
				area1.append(buffer.toString());
			
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==btn3)
		{
			//DB_INSERT
			System.out.println("DB_INSERT");
			if(Frm_Insert==null) {
				
//				프레임창 생성
				Frm_Insert = new JFrame("DB_INSERT");
				Frm_Insert.setBounds(650,100,300,400);
				
//				Panel 객체 생성
				JPanel panel = new JPanel();
				
//				Component 객체 생성
				JTextArea area = new JTextArea();
				JScrollPane scroll = new JScrollPane(area);
				JButton btn = new JButton("Insert");
				
//				Position 지정
				scroll.setBounds(10,10,250,100);
				btn.setBounds(10,120,100,30);
				
//				btn_Event
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Insert_BTN");
//						pstmt 객체 sql쿼리 저장
						try {
							pstmt = conn.prepareStatement("insert into tbl_memo values(null,?,now())"); //null : auto_implement
							pstmt.setString(1, area.getText());
							int result = pstmt.executeUpdate();
							if(result>0) {
								JOptionPane.showMessageDialog(null, "Insert성공","DBCONN",JOptionPane.INFORMATION_MESSAGE);
								Frm_Insert.setVisible(false); //프레임창 닫기
							}
							else {
								//에러창 띄우기
								JOptionPane.showMessageDialog(null, "Insert실패","DBCONN",JOptionPane.ERROR_MESSAGE);
							}
//							pstmt.executeUpdate() DB 저장
//							자원정리
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						} finally {
							try{pstmt.close();}catch(Exception e1){e1.printStackTrace();}
							
						}
						
					}}); //입력 객체를 전달
				
//				Component를 Panel에 추가
				panel.add(scroll);
				panel.add(btn);
				panel.setLayout(null);
				
//				Frame에 panel추가
				Frm_Insert.getContentPane().add(panel);
				
				//X 버튼 누를때 setVisible(false)로 설정됨
				Frm_Insert.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);	//Dispose 창 숨김처리
				Frm_Insert.setVisible(true);	
				
				Frm_Insert.getContentPane().setLayout(null);
			}else
			{
				Frm_Insert.setVisible(true);
			}
			
			//JTextArea의 내용을 메모를 가져와서 tbl_memo 저장한다
			
			

		}
		else if(e.getSource()==btn4) {
			//DB_UPDATE
			System.out.println("DB_UPDATE");
			
			if(Frm_Update==null) {
				
				Frm_Update = new JFrame("DB_UPDATE");
				Frm_Update.setBounds(650,100,300,400);
				
//				---------------------------------------------------------------------------
//				Panel 객체 생성
				JPanel panel = new JPanel();
				
//				Component 객체 생성
				JTextField txt = new JTextField("ID : ");
				JTextArea area = new JTextArea();
				JScrollPane scroll = new JScrollPane(area);
				JButton btn = new JButton("Update");
				
//				Position 지정
				txt.setBounds(10,10,80,30);
				scroll.setBounds(10,50,250,100);
				btn.setBounds(10,270,100,30);
				
//				btn_event
				btn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("Update_BTN");
//						pstmt 객체 sql쿼리 저장
						try {
							pstmt = conn.prepareStatement("update tbl_memo set contents=?,regdate=now() from no=?");
							pstmt.setString(1, area.getText());
							pstmt.setInt(2, Integer.parseInt(txt.getText()));
							int result = pstmt.executeUpdate();
							if(result>0) {
								JOptionPane.showMessageDialog(null, "Update성공","DBCONN",JOptionPane.INFORMATION_MESSAGE);
								Frm_Insert.setVisible(false); //프레임창 닫기
							}
							else {
								//에러창 띄우기
								JOptionPane.showMessageDialog(null, "Update실패","DBCONN",JOptionPane.ERROR_MESSAGE);
							}
//							pstmt.executeUpdate() DB 저장
//							자원정리
						} catch (SQLException e1) {
							
							e1.printStackTrace();
						} finally {
							try{pstmt.close();}catch(Exception e1){e1.printStackTrace();}
							
						}
						
					}});
				
//				Component를 Panel에 추가
				panel.add(txt);
				panel.add(scroll);
				panel.add(btn);
				
				
				panel.setLayout(null);
				
//				Frame에 panel추가
				Frm_Update.getContentPane().add(panel);
				
//				---------------------------------------------------------------------------
				
				//X 버튼 누를때 setVisible(false)로 설정됨
				Frm_Update.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Frm_Update.setVisible(true);	
			}else
			{
				Frm_Update.setVisible(true);
			}

			//메모를 조회하여 가져온다 / Select(memo_id) 의 결과
			//조회된 메모를 수정하여 update 한다
			

			
		}
		else if(e.getSource()==btn5) {
			//DB_DELETE
			System.out.println("DB_DELETE");
			
			if(Frm_Delete==null) {
				
				Frm_Delete = new JFrame("DB_DELETE");
				Frm_Delete.setBounds(650,100,300,400);
				//X 버튼 누를때 setVisible(false)로 설정됨
				Frm_Delete.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Frm_Delete.setVisible(true);	
			}else
			{
				Frm_Delete.setVisible(true);
			}
			
		}
		else if(e.getSource()==btn6) {
			//DB_SELECT
			System.out.println("DB_SELECT");
			
//			if(Frm_Select==null) {
				
				Frm_Select = new JFrame("DB_SELECT");
				Frm_Select.setBounds(650,100,400,400);
				
//				panel 생성
				JPanel panel = new JPanel();
				
				
//				table 구조 생성
				String [] column = {"No","Contents","RegDate"};
				Object [][] data = {
						{"1","haha1","2023-06-20"},
						{"2","haha2","2023-06-20"},
						{"3","haha3","2023-06-20"}
				};
				DefaultTableModel model = new DefaultTableModel(data,column);
				
//				tbl_memo 로부터 데이터 가져오기
				try {
					pstmt=conn.prepareStatement("select * from tbl_memo");
					rs = pstmt.executeQuery();
					if(rs!=null) {
						while(rs.next()) {
							Object[] rowData = {rs.getInt("no"),rs.getString("contents"),rs.getString("regdate")};
							model.addRow(rowData);
							System.out.print(rs.getInt("no") + " ");
							System.out.print(rs.getString("contents") + " ");
							System.out.print(rs.getString("regdate") + "\n");
						}
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {rs.close();} catch (SQLException e1) {e1.printStackTrace();}
					try {pstmt.close();} catch (SQLException e1) {e1.printStackTrace();}
				}
				
//				Component 생성
				JTable table = new JTable(model);
				JScrollPane scroll = new JScrollPane(table);	
				scroll.setBounds(10,10,300,300);
				
//				table 열의 크기 지정
				table.getColumnModel().getColumn(0).setPreferredWidth(5);
				
//				Component 를 panel에 추가&Layout
				panel.add(scroll);
				panel.setLayout(null);
				Frm_Select.getContentPane().add(panel);
				
				//X 버튼 누를때 setVisible(false)로 설정됨
				Frm_Select.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				Frm_Select.setVisible(true);	
			
				
			}else
			{
				Frm_Select.setVisible(true);
			}
			
		
//		}
		 
		
		
	}



	@Override
	public void keyTyped(KeyEvent e) {	
		//키를 눌렀을때/뗏을때(UNICODE 지원)
//		System.out.println("keyTyped() : "+e.getKeyChar());
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//키를 눌렀을때
//		System.out.println("keyPressed() : "+e.getKeyChar());
//		System.out.println("keyPressed() : "+e.getKeyCode());
		if(e.getSource()==txt1)
		{
			if(e.getKeyCode()==10)
			{
				System.out.println("txt1's Enter");
				String str= txt1.getText();
				area1.append(str+"\n");
				txt1.setText("");
			}
			
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		//키를 뗏을때(UNICODE 미지원)
//		System.out.println("keyReleased() : " + e.getKeyChar());
//		System.out.println("keyReleased() : " + e.getKeyCode());

	}
	
}


public class C06SwingUI_IO_DB {

	public static void main(String[] args) {
		new GUI();
	}
}
