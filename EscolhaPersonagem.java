import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;

public class EscolhaPersonagem extends JFrame {
	Timer timer = new Timer();
	GokuVsVegeta gv = new GokuVsVegeta();
	GokuVsMajinboo gm = new GokuVsMajinboo();
	JLabel lblPosEscolhaChar = new JLabel();
	Timer timer2 = new Timer();

	public EscolhaPersonagem() {
		setBounds(0, 0, 542, 426);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		JPanel panelPrincipal = new JPanel();
		panelPrincipal.setBackground(new Color(255, 153, 51));
		panelPrincipal.setBounds(0, 0, 726, 387);
		getContentPane().add(panelPrincipal);
		panelPrincipal.setLayout(null);

		JLabel lblMajinboo = new JLabel("");
	
		JLabel lblNewLabel = new JLabel("CHOICE YOUR ENEMY");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		lblNewLabel.setForeground(Color.GREEN);
		lblNewLabel.setBounds(149, 360, 194, 27);
		panelPrincipal.add(lblNewLabel);
		panelPrincipal.add(lblPosEscolhaChar);
		JLabel lblkuririn = new JLabel("");
		JLabel lblMostraHP = new JLabel("");
		lblMostraHP.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMostraHP.setBounds(439, 299, 68, 22);
		panelPrincipal.add(lblMostraHP);

		JLabel lblMostraKi = new JLabel("");
		lblMostraKi.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMostraKi.setBounds(439, 254, 68, 22);
		panelPrincipal.add(lblMostraKi);

		JLabel lblHp = new JLabel("HP:");
		lblHp.setForeground(Color.BLACK);
		lblHp.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblHp.setBounds(449, 287, 26, 14);
		panelPrincipal.add(lblHp);

		JLabel lblKi = new JLabel("KI:");
		lblKi.setForeground(Color.BLACK);
		lblKi.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblKi.setBounds(449, 235, 26, 14);
		panelPrincipal.add(lblKi);

		JLabel lblMostraNomePer = new JLabel("");
		lblMostraNomePer.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostraNomePer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblMostraNomePer.setBounds(418, 204, 89, 22);
		panelPrincipal.add(lblMostraNomePer);

		JLabel lblNomePer = new JLabel("Nome:");
		lblNomePer.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		lblNomePer.setForeground(Color.BLACK);
		lblNomePer.setBounds(439, 189, 46, 14);
		panelPrincipal.add(lblNomePer);

		JLabel lblPersonagem = new JLabel("");
		lblPersonagem.setBackground(Color.GRAY);
		lblPersonagem.setBounds(173, 83, 160, 282);
		panelPrincipal.add(lblPersonagem);
		lblPosEscolhaChar.setBounds(31, 88, 476, 299);

		JLabel lblPrincipal = new JLabel("");
		lblPrincipal.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\fundo.png"));
		lblPrincipal.setBounds(0, 0, 534, 387);
		panelPrincipal.add(lblPrincipal);

		lblkuririn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPersonagem
						.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\kuririn.png"));
				lblMostraNomePer.setText("Kuririn");
				lblMostraKi.setText("1500");
				lblMostraHP.setText("100");
			}

			public void mouseExited(MouseEvent e) {
				lblPersonagem.setIcon(null);
				lblMostraNomePer.setText(null);
				lblMostraKi.setText(null);
				lblMostraHP.setText(null);
			}

		});
		lblkuririn.setBounds(10, 299, 58, 39);
		panelPrincipal.add(lblkuririn);
		JLabel lblVegeta = new JLabel("");
		lblVegeta.setBounds(10, 164, 58, 39);
		panelPrincipal.add(lblVegeta);
		lblVegeta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPersonagem
						.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\vegeta.png"));
				lblMostraNomePer.setText("Vegeta");
				lblMostraKi.setText("2000");
				lblMostraHP.setText("200");
			}

			public void mouseExited(MouseEvent e) {
				lblPersonagem.setIcon(null);
				lblMostraNomePer.setText(null);
				lblMostraKi.setText(null);
				lblMostraHP.setText(null);
			}

			public void mouseClicked(MouseEvent e) {

				lblPosEscolhaChar.setIcon(new ImageIcon(
						"C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\animacaoGokuVsVegeta.gif"));
				timer2.cancel();

				TimerTask tarefa1 = new TimerTask() {
					@Override
					public void run() {

						gv.setVisible(true);
						dispose();
					}
				};
				timer.schedule(tarefa1, 3000);

			}

		});

		TimerTask tarefa = new TimerTask() {

			@Override
			public void run() {
				lblPrincipal
						.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\fundo.png"));
			}
		};

		timer.schedule(tarefa, 2800);
		lblMajinboo.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\miniaturaMajinboo.png"));
		lblMajinboo.setBounds(22, 235, 40, 28);
		panelPrincipal.add(lblMajinboo);
		lblMajinboo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPersonagem
						.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\Majinboo.png"));
				lblMostraNomePer.setText("Majinboo");
				lblMostraKi.setText("1800");
				lblMostraHP.setText("15");
			}

			public void mouseExited(MouseEvent e) {
				lblPersonagem.setIcon(null);
				lblMostraNomePer.setText(null);
				lblMostraKi.setText(null);
				lblMostraHP.setText(null);
			}

			public void mouseClicked(MouseEvent e) {

				gm.setVisible(true);
				lblPosEscolhaChar.setIcon(
						new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\gokuVsMajinboo.png"));
				timer2.cancel();

				TimerTask tarefa1 = new TimerTask() {
					@Override
					public void run() {

						gv.setVisible(true);
						dispose();
					}
				};
				timer.schedule(tarefa1, 3000);

			}

		});

	}
}
