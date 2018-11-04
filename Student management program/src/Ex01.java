import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// JAVA DB 연결 패키지
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// SWING 패키지는 자바 1.4
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

public class Ex01 extends JFrame implements ActionListener, MouseListener {

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

	private JTextArea remark_txt = new JTextArea();
	private JTextField name_txt = new JTextField();
	private JTextField kor_txt = new JTextField();
	private JTextField eng_txt = new JTextField();
	private JTextField math_txt = new JTextField();
	private JTextField gender_txt = new JTextField();

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

	private ImageIcon regBtnImage = null;
	private ImageIcon updBtnImage = null;
	private ImageIcon delBtnImage = null;
	private ImageIcon serBtnImage = null;

	private Graphics screenGraphics = null;

	private int mouseX, mouseY;

	private String[] col_names = new String[] { "순번", "이름", "국어", "영어", "수학", "성별", "비고란" };
	// 文字配列宣言 "number","name","korean","english","math","gender","remarks","year","grader"

	private DefaultTableModel dtm = new DefaultTableModel(col_names, 0);
	private JTable jtable = new JTable(dtm);

	Ex01() {
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));

		getContentPane().setLayout(null);

		setSize(582, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

		backgroundImage = new ImageIcon(Ex01.class.getResource("image.jpg")).getImage();
		exitImage = new ImageIcon(Ex01.class.getResource("exit.jpg"));
		menuImage = new ImageIcon(Ex01.class.getResource("menubar.png"));

		nameImage = new ImageIcon(Ex01.class.getResource("name.png"));
		korImage = new ImageIcon(Ex01.class.getResource("kor.png"));
		engImage = new ImageIcon(Ex01.class.getResource("eng.png"));
		mathImage = new ImageIcon(Ex01.class.getResource("math.png"));
		genderImage = new ImageIcon(Ex01.class.getResource("gender.png"));
		remarkImage = new ImageIcon(Ex01.class.getResource("remark.png"));

		regBtnImage = new ImageIcon(Ex01.class.getResource("insert.png"));
		updBtnImage = new ImageIcon(Ex01.class.getResource("update.png"));
		delBtnImage = new ImageIcon(Ex01.class.getResource("delete.png"));
		serBtnImage = new ImageIcon(Ex01.class.getResource("search.png"));

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

		JButton exit_btn = new JButton();
		exit_btn.setBounds(543, 0, 39, 33);
		exit_btn.setIcon(exitImage);
		exit_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});

		getContentPane().add(exit_btn);

		JLabel menubar = new JLabel();
		menubar.setIcon(menuImage);
		menubar.setBounds(0, 0, 544, 32);
		getContentPane().add(menubar);

		updBtn.setBounds(154, 322, 132, 23);
		updBtn.setIcon(updBtnImage);
		getContentPane().add(updBtn);

		delBtn.setBounds(294, 322, 132, 23);
		delBtn.setIcon(delBtnImage);
		getContentPane().add(delBtn);

		serBtn.setBounds(438, 322, 132, 23);
		serBtn.setIcon(serBtnImage);
		getContentPane().add(serBtn);

		regBtn.setBounds(12, 322, 132, 23);
		regBtn.setIcon(regBtnImage);
		getContentPane().add(regBtn);

		JScrollPane scrollPane = new JScrollPane(jtable);
		scrollPane.setBounds(169, 41, 401, 271);
		getContentPane().add(scrollPane);

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
		screenImage = createImage(582, 364);
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
		new Ex01();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
		System.out.println("수정");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(
					    " UPDATE STUDENT_INFO "+
						" SET NAME=?, KOR =? , ENG=?, MATH=?, "+ 
						" 	     GENDER=? , REMARK=? "+
						" 	WHERE STU_INDEX=? ");
			pstmt.setString(1, name_txt.getText());
			pstmt.setInt(2, Integer.parseInt(kor_txt.getText()));
			pstmt.setInt(3, Integer.parseInt(eng_txt.getText()));
			pstmt.setInt(4, Integer.parseInt(math_txt.getText()));
			pstmt.setString(5, gender_txt.getText());
			pstmt.setString(6, remark_txt.getText());
	pstmt.setInt(7, Integer.parseInt(
				(String) jtable.getValueAt(jtable.getSelectedRow(), 0) 
			)  );
			System.out.println("실행전");
			pstmt.executeUpdate();	// insert update delete
									// select executeQuery();
			System.out.println("실행후");
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(this, "숫자로 형변환");
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
		System.out.println("삭제");
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = DriverManager.getConnection(url, user, pw);
			pstmt = con.prepareStatement(" DELETE STUDENT_INFO "
					+ " WHERE STU_INDEX=? ");
			pstmt.setInt(1, 
					Integer.parseInt(
					(String)jtable.getValueAt(jtable.getSelectedRow(), 0))
					);
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

		System.out.println(stu.toString());


		Connection conn = null;

		PreparedStatement pstmt = null;

		try {
			String insertSQL = 
		"INSERT INTO STUDENT_INFO "+
		" (STU_INDEX,NAME,KOR,ENG,MATH,GENDER,REMARK) "+
		" VALUES "+
		" (STUDENT_INFO_KEY.NEXTVAL,?,?,?,?,?,?)";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, stu.getName());
			pstmt.setInt(2, stu.getKor());
			pstmt.setInt(3, stu.getEng());
			pstmt.setInt(4, stu.getMath());
			pstmt.setString(5, stu.getGender());
			pstmt.setString(6, stu.getRemark());
			pstmt.executeUpdate();
			// System.out.println("DB 연결성공");
			JOptionPane.showMessageDialog(this, "학생이 등록되었습니다.");
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
//		System.out.println("조회버튼 누름");
		dtm.setRowCount(0);

		Connection conn = null; // DB랑 연결하는 객체
		PreparedStatement pstmt = null; // SQL 문 연결하는 객체
		ResultSet rs = null; // 조회한 테이블 값을 가지고 있는 객체

		// DB 연결을 시도합니다.
		try {
			/*
			 * insert update delete -> executeUpdate();
			 * select -> executeQuery();
			 */
			conn = DriverManager.getConnection(url, user, pw);
			pstmt = conn.prepareStatement("SELECT * FROM STUDENT_INFO ORDER BY STU_INDEX ASC");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String[] stu_ary = new String[7];
				stu_ary[0] = rs.getString("STU_INDEX");
				stu_ary[1] = rs.getString("NAME");
				stu_ary[2] = String.valueOf(rs.getInt("KOR"));
				stu_ary[3] = String.valueOf(rs.getInt("ENG"));
				stu_ary[4] = String.valueOf(rs.getInt("MATH"));
				stu_ary[5] = rs.getString("GENDER");
				stu_ary[6] = rs.getString("REMARK");
				dtm.addRow(stu_ary);
			}
		}
		// DB 연결이 피치 못할 사정에 실패 하면 예외로 빠집니다.
		catch (Exception e1) {
			e1.printStackTrace();
		}
		// DB 연결과 조회가 완료되면 DB 연결을 종료할 겁니다.
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