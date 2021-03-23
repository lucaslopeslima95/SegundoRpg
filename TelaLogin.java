import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;

public class TelaLogin extends JFrame {
	public static void main(String[]args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					try {
					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					            UIManager.setLookAndFeel(info.getClassName());
					            break;
					        }
					    }
					} catch (UnsupportedLookAndFeelException e) {
					} catch (ClassNotFoundException e) {
					} catch (InstantiationException e) {
					} catch (IllegalAccessException e) {
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private JTextField TFLogin;
	private JPasswordField pwdSenha;
	private int mouseX;
	
	private int mouseY;
	public TelaLogin() {
		getContentPane().setLayout(null);
		setBounds(100, 100, 813, 424);
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.BLACK);
		panelPrincipal.setBounds(0, 0, 807, 395);
		panelPrincipal.setLayout(null);
		getContentPane().add(panelPrincipal);
		setLocationRelativeTo(null);
		addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX()+ e.getX() - mouseX,getY()+ e.getY() - mouseY);
			}
		});
		panelPrincipal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelLogin.setBounds(33, 212, 250, 148);
		panelLogin.setLayout(null);
		panelPrincipal.add(panelLogin);
		panelLogin.setBackground(new Color(1.0f,1.0f,1.0f,0.4f));
		
		pwdSenha = new JPasswordField();
		pwdSenha.setText("aluno");
		pwdSenha.setToolTipText("");
		pwdSenha.setEchoChar('*');
		pwdSenha.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pwdSenha.setBounds(41, 62, 162, 25);
		panelLogin.add(pwdSenha);
		
		TFLogin = new JTextField();
		TFLogin.setText("UserName");
		TFLogin.setBorder(new LineBorder(Color.BLACK, 1, true));
		TFLogin.setBounds(41, 25, 162, 26);
		panelLogin.add(TFLogin);
		TFLogin.setColumns(10);
		JPanel pnlBtn = new JPanel();
		pnlBtn.setBounds(64, 112, 120, 25);
		panelLogin.add(pnlBtn);
		pnlBtn.setBackground(Color.LIGHT_GRAY);
		pnlBtn.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		pnlBtn.setBackground(new Color(204, 204, 204));
		pnlBtn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		pnlBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlBtn.setBackground(Color.LIGHT_GRAY);
				EscolhaPersonagem internalFrame = new EscolhaPersonagem();
				internalFrame.setVisible(true);
				dispose();

			}
			@Override
			public void mouseEntered(MouseEvent e) {
				pnlBtn.setBackground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pnlBtn.setBackground(Color.gray);
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				pnlBtn.setBackground(Color.LIGHT_GRAY);
			}
		});
		pnlBtn.setLayout(null);
		
		JLabel lblBotaoAcessar = new JLabel("Entrar");
		lblBotaoAcessar.setBounds(36, 2, 44, 22);
		pnlBtn.add(lblBotaoAcessar);
		lblBotaoAcessar.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 13));
		
		JLabel labelAbertura = new JLabel("");
		labelAbertura.setHorizontalAlignment(SwingConstants.TRAILING);
		labelAbertura.setBackground(Color.BLACK);
		labelAbertura.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\CenarioTemploAOF3.jpg"));
		labelAbertura.setBounds(0, 0, 804, 384);
		labelAbertura.setVisible(true);
		panelPrincipal.add(labelAbertura);
		
	}
}
