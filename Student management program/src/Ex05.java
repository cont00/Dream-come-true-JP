/*
 * 学生管理プログラム
 * AWT 패키지는 자바 1.0 그림 그리기와 이벤트들 (AWTパッケージはJava1.0画描きとイベント)
 * DBと接続するための命令文
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// JAVA DB 연결 패키지 (JAVA DB 連結パッケージ)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// SWING 패키지는 자바 1.4 (SWINGパッケージはJava1.4)
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Ex05 extends JFrame implements ActionListener, MouseListener {

	private String user = "hr";
	private String pw = "123456";
	private String url = "jdbc:oracle:thin:@192.168.0.15:1521:xe";
	//DBに接続するためのID, PW, URLを変数として宣言
	
	private JButton regBtn = new JButton();
	private JButton updBtn = new JButton();
	private JButton delBtn = new JButton();
	private JButton serBtn = new JButton();

	private JLabel name_label = new JLabel();
	private JLabel kor_label = new JLabel();
	private JLabel eng_label = new JLabel();
	private JLabel math_label = new JLabel();
	private JLabel gender_label = new JLabel();
	private JLabel remark_label = new JLabel();
	private JLabel year_label = new JLabel();
	private JLabel class_label = new JLabel();
	
	private JTextArea remark_txt = new JTextArea();
	private JTextField name_txt = new JTextField();
	private JTextField kor_txt = new JTextField();
	private JTextField eng_txt = new JTextField();
	private JTextField math_txt = new JTextField();
	private JTextField gender_txt = new JTextField();
	private JTextField year_txt =  new JTextField();
	private JTextField class_txt = new JTextField();
	
	private Image backgroundImage = null;
	private Image screenImage = null;
	private ImageIcon exitImage = null;
	private ImageIcon menuImage = null;

	private ImageIcon nameImage = null;
	private ImageIcon korImage = null;
	private ImageIcon engImage = null;
	private ImageIcon mathImage = null;
	private ImageIcon genderImage = null;
	private ImageIcon remarkImage = null;
	private ImageIcon yearImage = null;
	private ImageIcon gradeImage = null;

	private ImageIcon regBtnImage = null;
	private ImageIcon updBtnImage = null;
	private ImageIcon delBtnImage = null;
	private ImageIcon serBtnImage = null;

	private Graphics screenGraphics = null;

	private int mouseX, mouseY;

	private String[] col_names = new String[] { "순번", "이름", "국어", "영어", "수학", "성별", "비고란", "년도", "학반" };
	// 文字配列宣言 "number","name","korean","english","math","gender","remarks","year","grader"

	private DefaultTableModel dtm = new DefaultTableModel(col_names, 0);
	private JTable jtable = new JTable(dtm);
	
	boolean isASC = false;
	
	Ex05() {
		setSize(582, 500);
		setUndecorated(true); // 원래 그림 지우기 (原本イメージ削除)
		setBackground(new Color(0, 0, 0, 0));

		getContentPane().setLayout(null);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		backgroundImage = new ImageIcon(Ex05.class.getResource("kano19.jpg")).getImage();
		exitImage = new ImageIcon(Ex05.class.getResource("exit.jpg"));
		menuImage = new ImageIcon(Ex05.class.getResource("menubar.png"));

		nameImage = new ImageIcon(Ex05.class.getResource("name.png"));
		korImage = new ImageIcon(Ex05.class.getResource("kor.png"));
		engImage = new ImageIcon(Ex05.class.getResource("eng.png"));
		mathImage = new ImageIcon(Ex05.class.getResource("math.png"));
		genderImage = new ImageIcon(Ex05.class.getResource("gender.png"));
		remarkImage = new ImageIcon(Ex05.class.getResource("remark.png"));
		yearImage = new ImageIcon(Ex05.class.getResource("year.png"));
		gradeImage = new ImageIcon(Ex05.class.getResource("group.png"));
		
		regBtnImage = new ImageIcon(Ex05.class.getResource("insert.png"));
		updBtnImage = new ImageIcon(Ex05.class.getResource("update.png"));
		delBtnImage = new ImageIcon(Ex05.class.getResource("delete.png"));
		serBtnImage = new ImageIcon(Ex05.class.getResource("search.png"));

		name_txt.setBounds(65, 41, 92, 23);
		getContentPane().add(name_txt);
		name_txt.setColumns(10);

		name_label.setBounds(12, 40, 50, 19);
		name_label.setIcon(nameImage);
		getContentPane().add(name_label);

		kor_label.setBounds(12, 76, 50, 19);
		kor_label.setIcon(korImage);
		getContentPane().add(kor_label);

		kor_txt.setColumns(10);
		kor_txt.setBounds(65, 74, 92, 23);
		getContentPane().add(kor_txt);

		eng_label.setBounds(12, 109, 50, 19);
		eng_label.setIcon(engImage);
		getContentPane().add(eng_label);

		eng_txt.setColumns(10);
		eng_txt.setBounds(65, 107, 92, 23);
		getContentPane().add(eng_txt);

		math_label.setBounds(12, 142, 50, 19);
		math_label.setIcon(mathImage);
		getContentPane().add(math_label);

		math_txt.setColumns(10);
		math_txt.setBounds(65, 140, 92, 23);
		getContentPane().add(math_txt);

		gender_label.setBounds(12, 175, 50, 19);
		gender_label.setIcon(genderImage);
		getContentPane().add(gender_label);

		gender_txt.setColumns(10);
		gender_txt.setBounds(65, 173, 92, 23);
		getContentPane().add(gender_txt);

		remark_label.setBounds(12, 211, 50, 19);
		remark_label.setIcon(remarkImage);
		getContentPane().add(remark_label);

		remark_txt.setBounds(65, 209, 92, 103);
		getContentPane().add(remark_txt);
		
		year_label.setBounds(12, 326, 50, 19);
		year_label.setIcon(yearImage);
		getContentPane().add(year_label);
		
		year_txt.setColumns(10);
		year_txt.setBounds(65, 322, 92, 23);
		getContentPane().add(year_txt);
		
		class_label.setBounds(12, 364, 50, 19);
		class_label.setIcon(gradeImage);
		getContentPane().add(class_label);
		
		class_txt.setColumns(10);
		class_txt.setBounds(65, 360, 92, 23);
		getContentPane().add(class_txt);

		JButton exit_btn = new JButton();
		exit_btn.setBounds(543, 0, 39, 33);
		exit_btn.setIcon(exitImage); // 종료 버튼 이미지 (終了ボタンイメージ)
		exit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		getContentPane().add(exit_btn);

		JLabel menubar = new JLabel();
		menubar.setIcon(menuImage); // 메뉴바 이미지 (メニューバーイメージ)
		menubar.setBounds(0, 0, 544, 32);
		getContentPane().add(menubar);

		updBtn.setBounds(156, 416, 132, 23);
		updBtn.setIcon(updBtnImage);
		getContentPane().add(updBtn);

		delBtn.setBounds(300, 416, 132, 23);
		delBtn.setIcon(delBtnImage);
		getContentPane().add(delBtn);

		serBtn.setBounds(444, 416, 132, 23);
		serBtn.setIcon(serBtnImage);
		getContentPane().add(serBtn);

		regBtn.setBounds(12, 416, 132, 23);
		regBtn.setIcon(regBtnImage);
		getContentPane().add(regBtn);
		
		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setBounds(169, 41, 401, 342);
		getContentPane().add(scrollPane);
		
		//下のボタンは、昇順/降順の設定のためのボタンを作成
		JButton button = new JButton("국어 오름/내림"); //korean 昇順 / 降順
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doSort("KOR");
			}
		});
		button.setBounds(12, 467, 132, 23);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("영어 오름/내림"); // english 昇順 / 降順
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSort("ENG");
			}
		});
		button_1.setBounds(156, 467, 132, 23);
		getContentPane().add(button_1);
		
		JButton button_2 = new JButton("수학 오름/내림"); // math 昇順 / 降順
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSort("MATH");
			}
		});
		button_2.setBounds(300, 467, 132, 23);
		getContentPane().add(button_2);
		
		JButton button_3 = new JButton("이름 오름/내림"); // name 昇順 / 降順
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doSort("NAME");
			}
		});
		button_3.setBounds(444, 467, 132, 23);
		getContentPane().add(button_3);

		regBtn.addActionListener(this);
		updBtn.addActionListener(this);
		delBtn.addActionListener(this);
		serBtn.addActionListener(this);
		
		jtable.addMouseListener(this);

		menubar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menubar.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
	}
	@Override
	public void paint(Graphics g) {
		screenImage = createImage(582, 500);
		screenGraphics = screenImage.getGraphics();
		screenDraw(screenGraphics);
		g.drawImage(screenImage, 0, 0, null);
	}
	public void screenDraw(Graphics g) {
		g.drawImage(backgroundImage, 0, 0, null);
		paintComponents(g);
		this.repaint();
		try {
			Thread.sleep(5);
		} catch (Exception e) {
		
		}
	}
	public static void main(String[] args) {
		new Ex05();
	}
	/*
	 * textField 이름(name) textField_1 국어(korean), textField_2 영어(english), textField_3 수학(math), textField_4 성별(gender)
	 * textArea 비고(remarks)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 등록버튼 부름 (登録ボタン持ってくる)
		if (e.getSource().equals(regBtn)) {
			doInsert();
			doSelect();
		} else if (e.getSource().equals(serBtn)) {
			doSelect();
		} else if(e.getSource().equals(updBtn)){
			doUpdate();
			doSelect();
		} else if(e.getSource().equals(delBtn)){
			doDelete();
			doSelect();
		}
	}
	public void doUpdate(){
		System.out.println("수정"); // 修整
		// DB 가서 수정 해야됨 (DBに移動して修整)
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		// 下のコマンドは,DBに入力された値を読み込むこと
		try{
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(
					    " UPDATE STUDENT_INFO " +
						" SET NAME = ?, KOR = ? , ENG = ?, MATH = ?, " + 
						" GENDER = ? , REMARK = ?, YEAR = ?, CLASS = ? " +
						" WHERE STU_INDEX = ?");
			pstmt.setString(1, name_txt.getText());
			pstmt.setInt(2, Integer.parseInt(kor_txt.getText()));
			pstmt.setInt(3, Integer.parseInt(eng_txt.getText()));
			pstmt.setInt(4, Integer.parseInt(math_txt.getText()));
			pstmt.setString(5, gender_txt.getText());
			pstmt.setString(6, remark_txt.getText());
			pstmt.setInt(7, Integer.parseInt(year_txt.getText()));
			pstmt.setInt(8, Integer.parseInt(class_txt.getText()));
			pstmt.setInt(9, Integer.parseInt( (String) jtable.getValueAt(jtable.getSelectedRow(), 0) ) );
			
			System.out.println("실행전"); // before
			pstmt.executeUpdate();	// insert update delete
									// select executeQuery();
			System.out.println("실행후"); // After
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "숫자로 형변환"); // Convert to Numeric
		}catch(Exception e){
			
		}finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void doDelete(){
		// DB 가서 삭제 해야됨 (DBに移動して削除)
		System.out.println("삭제"); // 削除
		Connection con = null;
		PreparedStatement pstmt = null;
		// 下のコマンドは,DBに入力された値を削除すること
		try{
			con = DriverManager.getConnection(url, user, pw);
			pstmt = con.prepareStatement(" DELETE STUDENT_INFO "
					+ " WHERE STU_INDEX=? ");
			pstmt.setInt(1, Integer.parseInt( (String)jtable.getValueAt(jtable.getSelectedRow(), 0)) );
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				con.close();
			}catch (Exception e) {
				
			}
		}
	}
	public void doInsert(){
		Student stu = new Student();
		stu.setName(name_txt.getText());
		stu.setKor(Integer.parseInt(kor_txt.getText()));
		stu.setEng(Integer.parseInt(eng_txt.getText()));
		stu.setMath(Integer.parseInt(math_txt.getText()));
		stu.setGender(gender_txt.getText());
		stu.setRemark(remark_txt.getText());
		stu.setYear(Integer.parseInt(year_txt.getText()));
		stu.setStu_class(Integer.parseInt(class_txt.getText()));

		// DB연결 객체 (DB接続オブジェクト)
		Connection conn = null;
		// sql 구문 나타내는 객체 (SQL構文を示すオブジェクト)
		PreparedStatement pstmt = null;

		try {
			String insertSQL = 
					"INSERT INTO STUDENT_INFO "+
					" (STU_INDEX,NAME,KOR,ENG,MATH,GENDER,REMARK) "+
					" VALUES "+
					" (STUDENT_INFO_KEY.NEXTVAL,?,?,?,?,?,?,?,?)";
					// class 파일 추가 확인 (class ファイルの追加確認)
					Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, stu.getName());
			pstmt.setInt(2, stu.getKor());
			pstmt.setInt(3, stu.getEng());
			pstmt.setInt(4, stu.getMath());
			pstmt.setString(5, stu.getGender());
			pstmt.setString(6, stu.getRemark());
			pstmt.setInt(7, stu.getYear());
			pstmt.setInt(8, stu.getStu_class());
			pstmt.executeUpdate();
			// System.out.println("DB 연결성공");   DBに連結されたかを確認するために入れたコマンド
			JOptionPane.showMessageDialog(this, "학생이 등록되었습니다."); //学生が登録されました
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					pstmt.close();
					conn.close();
				} catch (Exception e11) {
					e11.printStackTrace();
				}
			}
		}
	}
	public void doSelect(){
		dtm.setRowCount(0);
		
		Connection conn = null; // DB랑 연결하는 객체 (DBと連結するオブジェクト)
		PreparedStatement pstmt = null; // SQL 문 연결하는 객체 (SQLとつながるオブジェクト)
		ResultSet rs = null; // 조회한 테이블 값을 가지고 있는 객체 (照会したテーブル値を持つオブジェクト)
		// DB 연결을 시도합니다.  (下のコマンドは,DB接続のための命令文)
		try {
			/*
			 * insert update delete -> executeUpdate();
			 * select -> executeQuery();
			 */
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement("SELECT * FROM STUDENT_INFO ORDER BY YEAR DESC, CLASS DESC ");
			rs = pstmt.executeQuery();
			
			// DBにある値をString型配列に持ってきて入力するためのWhile文宣言
			while (rs.next()) {
				String[] stu_ary = new String[9];
				
				stu_ary[0] = rs.getString("STU_INDEX");
				stu_ary[1] = rs.getString("NAME");
				stu_ary[2] = String.valueOf(rs.getInt("KOR"));
				stu_ary[3] = String.valueOf(rs.getInt("ENG"));
				stu_ary[4] = String.valueOf(rs.getInt("MATH"));
				stu_ary[5] = rs.getString("GENDER");
				stu_ary[6] = rs.getString("REMARK");
				stu_ary[7] = String.valueOf(rs.getInt("YEAR"));
				stu_ary[8] = String.valueOf(rs.getInt("CLASS"));
				dtm.addRow(stu_ary);
			}
		}
		// DB 연결이 피치 못할 사정에 실패 하면 예외로 빠집니다. (DBへの接続途中,エラーが発生したとき,例外から外れること)
		catch (Exception e1) {
			e1.printStackTrace();
		}
		// DB 연결과 조회가 완료되면 DB 연결을 종료할 겁니다. (DBの接続と照会が完了したら,DB接続を終了する)
		finally {
			if (conn != null) {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	public void doSort(String field) {
		dtm.setRowCount(0);
		
		Connection conn = null; // DB랑 연결하는 객체
		PreparedStatement pstmt = null; // SQL 문 연결하는 객체
		ResultSet rs = null; // 조회한 테이블 값을 가지고 있는 객체

		try {
			conn = DriverManager.getConnection(url, user, pw);
			if (isASC) {
				pstmt = conn.prepareStatement("SELECT * FROM STUDENT_INFO ORDER BY "+ field + " ASC");
				isASC= false;
			}
			else {
				pstmt = conn.prepareStatement("SELECT * FROM STUDENT_INFO ORDER BY "+ field + " DESC");
				isASC = true;
			}
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String[] stu_ary = new String[9];
				
				stu_ary[0] = rs.getString("STU_INDEX");
				stu_ary[1] = rs.getString("NAME");
				stu_ary[2] = String.valueOf(rs.getInt("KOR"));
				stu_ary[3] = String.valueOf(rs.getInt("ENG"));
				stu_ary[4] = String.valueOf(rs.getInt("MATH"));
				stu_ary[5] = rs.getString("GENDER");
				stu_ary[6] = rs.getString("REMARK");
				stu_ary[7] = String.valueOf(rs.getInt("YEAR"));
				stu_ary[8] = String.valueOf(rs.getInt("CLASS"));
				dtm.addRow(stu_ary);
			}
		} catch(Exception e){
			
		} finally {
			if (conn != null) {
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	public void	mouseClicked(MouseEvent e){}
	public void	mouseEntered(MouseEvent e){}
	public void	mouseExited(MouseEvent e){}
	public void	mousePressed(MouseEvent e){

		int select_row = jtable.getSelectedRow();
		
		name_txt.setText( (String)(jtable.getValueAt(select_row, 1)) );
		kor_txt.setText( (String)(jtable.getValueAt(select_row, 2)) );
		eng_txt.setText( (String)(jtable.getValueAt(select_row, 3)) );
		math_txt.setText( (String)(jtable.getValueAt(select_row, 4)) );
		gender_txt.setText( (String)(jtable.getValueAt(select_row, 5)) );
		remark_txt.setText( (String)(jtable.getValueAt(select_row, 6)) );
	}
	public void	mouseReleased(MouseEvent e){}
}