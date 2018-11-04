// Lotto 当籤番号確認プログラム

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.json.JSONObject;

public class NanumLotto extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	
	private String number1 = "0";
	private String number2 = "0";
	private String number3 = "0";
	private String number4 = "0";
	private String number5 = "0";
	private String number6 = "0";
	private String number7 = "0";
	private String number8 = "+";

	public static void setUIFont(FontUIResource f) { // 폰트지정 (Font 指定)
		Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource) {
				UIManager.put(key, f);
			}
		}
	}
	NanumLotto() throws FontFormatException, IOException {
		setTitle("로또번호확인");
		String fName = "BMJUA_ttf.ttf";
		InputStream is = NanumLotto.class.getResourceAsStream(fName);
		Font f = Font.createFont(Font.TRUETYPE_FONT, is);
		f = f.deriveFont(20f);// 글자크기20으로지정20f는float 형식이라f입력 (文字サイズ20で指定20fはfloat形式だからf入力)
		setUIFont(new FontUIResource(f));// 전체컴퍼넌트글자체지정 (全コンポーネント字体指定)

		setVisible(true);
		setSize(630, 350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("최근로또번호"); // 最新Lotto番号
		lblNewLabel.setBounds(12, 10, 340, 43);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_5 = new JLabel("보너스번호"); // ボーナス番号
		lblNewLabel_5.setBounds(520, 10, 340, 43);
		getContentPane().add(lblNewLabel_5);

		JButton button = new JButton("해당회차로"); // 該当回次移動
		// 下のコマンドは,Lotto 公式ホームページに接続して,入力した回次の当選番号を持って来るためにある
		button.addActionListener(
			(e)->{
				String number = textField_7.getText();
				try{
				URL url = new URL("http://www.nlotto.co.kr/common.do?"
		          + "method=getLottoNumber&drwNo="+number);
				URLConnection uc = url.openConnection();
				InputStreamReader isr = new InputStreamReader(uc.getInputStream(),"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String str = "";
					str = br.readLine();
				System.out.println(str);
				
				JSONObject result = new JSONObject(str);
				System.out.println(result.get("drwtNo1"));
				System.out.println(result.get("drwtNo2"));
				System.out.println(result.get("drwtNo3"));
				System.out.println(result.get("drwtNo4"));
				System.out.println(result.get("drwtNo5"));
				System.out.println(result.get("drwtNo6"));
				
				System.out.println("보너스번호 = "+result.get("bnusNo"));
				
				number1 = String.valueOf(result.get("drwtNo1"));
				number2 = String.valueOf(result.get("drwtNo2"));
				number3 = String.valueOf(result.get("drwtNo3"));
				number4 = String.valueOf(result.get("drwtNo4"));
				number5 = String.valueOf(result.get("drwtNo5"));
				number6 = String.valueOf(result.get("drwtNo6"));
				number7 = String.valueOf(result.get("bnusNo"));
				this.repaint();
				}catch(Exception e1){
					e1.printStackTrace();
				}
			}
		);
		button.setBounds(208, 260, 144, 26);
		getContentPane().add(button);

		JPanel panel1 = new JPanel(); // Lotto 番号出力 panel
		panel1.setBounds(24, 70, 100, 100);
		getContentPane().add(panel1);

		JPanel panel2 = new JPanel(); // Lotto 番号出力 panel
		panel2.setBounds(148, 70, 100, 100);
		getContentPane().add(panel2);

		JPanel panel3 = new JPanel(); // Lotto 番号出力 panel
		panel3.setBounds(270, 70, 100, 100);
		getContentPane().add(panel3);

		JPanel panel4 = new JPanel(); // Lotto 番号出力 panel
		panel4.setBounds(392, 70, 100, 100);
		getContentPane().add(panel4);

		JPanel panel5 = new JPanel(); // Lotto 番号出力 panel
		panel5.setBounds(504, 70, 100, 100);
		getContentPane().add(panel5);

		JPanel panel6 = new JPanel(); // Lotto 番号出力 panel
		panel6.setBounds(616, 70, 100, 100);
		getContentPane().add(panel6);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(24, 161, 313, 43);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("번호입력확인"); // 番号入力確認
		lblNewLabel_2.setBounds(24, 204, 259, 19);
		getContentPane().add(lblNewLabel_2);

		JLabel label = new JLabel("1"); // 추첨번호시작 (抽選番号の始まり)
		label.setBounds(12, 235, 10, 15);
		getContentPane().add(label);

		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setBounds(34, 233, 57, 19);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel label_1 = new JLabel("2");
		label_1.setBounds(93, 235, 12, 15);
		getContentPane().add(label_1);

		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(117, 233, 57, 19);
		getContentPane().add(textField_2);

		JLabel label_2 = new JLabel("3");
		label_2.setBounds(184, 233, 14, 15);
		getContentPane().add(label_2);

		textField_3 = new JTextField();
		textField_3.setText("0");
		textField_3.setColumns(10);
		textField_3.setBounds(210, 233, 57, 19);
		getContentPane().add(textField_3);

		JLabel label_3 = new JLabel("4");
		label_3.setBounds(269, 235, 14, 15);
		getContentPane().add(label_3);

		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setColumns(10);
		textField_4.setBounds(295, 233, 57, 19);
		getContentPane().add(textField_4);

		JLabel label_4 = new JLabel("5");
		label_4.setBounds(356, 235, 14, 15);
		getContentPane().add(label_4);

		textField_5 = new JTextField();
		textField_5.setText("0");
		textField_5.setColumns(10);
		textField_5.setBounds(379, 233, 57, 19);
		getContentPane().add(textField_5);

		JLabel label_5 = new JLabel("6");
		label_5.setBounds(448, 235, 14, 15);
		getContentPane().add(label_5);

		textField_6 = new JTextField();
		textField_6.setText("0");
		textField_6.setColumns(10);
		textField_6.setBounds(465, 233, 57, 19);
		getContentPane().add(textField_6); // 추첨번호끝 (抽選番号の最後)

		JLabel lblNewLabel_3 = new JLabel("회차"); // 回次
		lblNewLabel_3.setBounds(34, 260, 90, 26);
		getContentPane().add(lblNewLabel_3);

		textField_7 = new JTextField();
		textField_7.setText("1");
		textField_7.setBounds(115, 260, 77, 26);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JButton button_1 = new JButton("번호확인"); // 番号確認
		button_1.setBounds(378, 262, 144, 26);
		getContentPane().add(button_1);
		button_1.addActionListener(
		// 下のコマンドは自分が入力した番号と公式ホームページの当選番号を比べて当選可否と順位を教えること
			(e)->{
				int cnt = 0;
				boolean temp = false;
				String comnum[] = { number1, number2, number3, number4, number5, number6, number7};
				String num[] = { textField_1.getText(), textField_2.getText(), textField_3.getText(),
								 textField_4.getText(), textField_5.getText(), textField_6.getText(), };
				for (int i = 0; i < num.length; i++) {
					for(int j = 0; j < comnum.length; j++) {
						if (num[i].equals(comnum[j])) {
							cnt++;
						}
					}
				}
				if (cnt == 6) {
					lblNewLabel_1.setText("1등 당첨되었습니다."); // 1等当たりました
					// メッセージ出力文
					JOptionPane.showMessageDialog(null, "1등 당첨되었습니다.", "당첨확인!", JOptionPane.PLAIN_MESSAGE); // 1等当たりました, 当選確認
				}
				else if (cnt == 5) {
					for (int i = 0; i < num.length; i++) {
						if (num[i].equals(number7)) {
							temp = true;
						}
					}
					if (cnt == 5 && temp == true) {
						lblNewLabel_1.setText("2등 당첨되었습니다."); // 2等当たりました
						JOptionPane.showMessageDialog(null, "2등 당첨되었습니다.", "당첨확인!", JOptionPane.PLAIN_MESSAGE); // 2等当たりました, 当選確認
					}
					else if (cnt == 5) {
						lblNewLabel_1.setText("3등 당첨되었습니다."); // 3等当たりました
						JOptionPane.showMessageDialog(null, "3등 당첨되었습니다.", "당첨확인!", JOptionPane.PLAIN_MESSAGE); // 3等当たりました, 当選確認
					}
				}
				else if (cnt == 4) {
					lblNewLabel_1.setText("4등 당첨되었습니다."); // 4等当たりました
					JOptionPane.showMessageDialog(null, "4등 당첨되었습니다.", "당첨확인!", JOptionPane.PLAIN_MESSAGE); // 4等当たりました, 当選確認
				}
				else if (cnt == 3) {
					lblNewLabel_1.setText("5등 당첨되었습니다."); // 5等当たりました
					JOptionPane.showMessageDialog(null, "5등 당첨되었습니다.", "당첨확인!", JOptionPane.PLAIN_MESSAGE); // 5等当たりました, 当選確認
				}
					
				else {
					lblNewLabel_1.setText("꽝입니다. 다음기회에..."); // すかです。次の機会に。。。
					JOptionPane.showMessageDialog(null, "꽝입니다.", "탕첨확인!", JOptionPane.PLAIN_MESSAGE); // すかです, 当選確認
				}
			}
		);
		this.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		Font f = new Font("BMHANNA_11yrs.ttf", Font.BOLD, 30); // 폰트지정 (font指定)
		super.paint(g);

		g.setColor(Color.orange); // 사각형컬러지정 (四角形色相指定)
		g.fillRoundRect(30, 90, 60, 60, 30, 30); // 사각형의x, y좌표와크기, 모서리라운드설정 (四角形のx, y座標と大きさ,角のラウンド設定)
		g.setFont(f); // 폰트설정 (font設定)
		g.setColor(Color.black); // 폰트컬러지정 (font色相指定)
		g.drawString(number1, 50, 130); // 폰트의문자열, x, y좌표지정 (font文字列,x,y座標指定)

		g.setColor(Color.orange);
		g.fillRoundRect(110, 90, 60, 60, 30, 30);
		g.setColor(Color.black);
		g.drawString(number2, 130, 130);

		g.setColor(Color.cyan);
		g.fillRoundRect(190, 90, 60, 60, 30, 30);
		g.setColor(Color.black);
		g.drawString(number3, 210, 130);

		g.setColor(Color.orange);
		g.fillRoundRect(270, 90, 60, 60, 30, 30);
		g.setColor(Color.black);
		g.drawString(number4, 290, 130);

		g.setColor(Color.yellow);
		g.fillRoundRect(350, 90, 60, 60, 30, 30);
		g.setColor(Color.black);
		g.drawString(number5, 370, 130);

		g.setColor(Color.orange);
		g.fillRoundRect(430, 90, 60, 60, 30, 30);
		g.setColor(Color.black);
		g.drawString(number6, 450, 130);
		
		g.setColor(Color.red);
		g.fillRoundRect(550, 90, 60, 60, 30, 30);
		g.setColor(Color.black);
		g.drawString(number7, 570, 130);
		
		g.setColor(Color.black);
		g.drawString(number8, 515, 130);
	}

	public static void main(String[] args) throws Exception {
		new NanumLotto();
	}
}