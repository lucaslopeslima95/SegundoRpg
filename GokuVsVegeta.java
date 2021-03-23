import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;


import java.awt.Font;

public class GokuVsVegeta extends JFrame {

	JPanel contentPane;
	JButton btnSocoPlay = new JButton("Ataque");
	JButton btnEspecialPlay = new JButton("Kamehamehaa");
	JLabel lblper2 = new JLabel();
	JLabel labelNrRodada = new JLabel("1");
	JLabel labelNomeAtaque = new JLabel("");
	JLabel labelNvCpu = new JLabel("");
	JLabel labelHpPlayer = new JLabel();
	JLabel labelManaPlayer = new JLabel();
	JLabel lblNrMana = new JLabel("");
	JLabel labelHpCpu = new JLabel();
	JLabel lblCenarioLuta = new JLabel("");
	Random random = new Random(012);
	Timer timer = new Timer();
	Timer timer2 = new Timer();
	boolean flag = true;
	int contEspecial = 5;
	int nrInimigo = 0;
	int move = 65;
	int moveCpu = 381;
	private final JPanel panelDados = new JPanel();
	JLabel lblGoku = new JLabel("");

	public GokuVsVegeta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 542, 405);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		lblGoku.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\goku1.gif"));
		lblGoku.setBounds(120, 117, 162, 121);
		lblper2.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\Vegeta1.gif"));
		lblper2.setBounds(381, 104, 115, 134);
		getContentPane().add(lblper2);
		contentPane.add(lblGoku);
		panelDados.setLayout(null);
		panelDados.setBackground(Color.LIGHT_GRAY);
		panelDados.setBounds(0, 11, 526, 77);
		contentPane.add(panelDados);
		JLabel lblHp = new JLabel("Hp:");
		lblHp.setBounds(43, 29, 34, 15);
		panelDados.add(lblHp);
		lblHp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelHpPlayer.setBounds(87, 29, 34, 15);
		panelDados.add(labelHpPlayer);
		labelHpPlayer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelHpPlayer.setText("150");
		labelManaPlayer.setBounds(32, 55, 46, 15);
		panelDados.add(labelManaPlayer);
		labelManaPlayer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelManaPlayer.setText("Mana: ");
		lblNrMana.setBounds(97, 55, 16, 14);
		panelDados.add(lblNrMana);
		lblNrMana.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNrMana.setText(contEspecial + "");

		JLabel lblRodada = new JLabel("Rodada: ");
		lblRodada.setBounds(192, 11, 93, 15);
		panelDados.add(lblRodada);
		lblRodada.setFont(new Font("Dialog", Font.BOLD, 17));
		labelNrRodada.setBounds(278, 6, 60, 25);
		panelDados.add(labelNrRodada);
		labelNrRodada.setFont(new Font("FreeSerif", Font.BOLD | Font.ITALIC, 17));
		labelNrRodada.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblHp_1 = new JLabel("Hp:");
		lblHp_1.setBounds(343, 55, 34, 15);
		panelDados.add(lblHp_1);
		lblHp_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelHpCpu.setBounds(387, 55, 70, 15);
		panelDados.add(labelHpCpu);
		labelHpCpu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelHpCpu.setText("11");

		JPanel panelCpu = new JPanel();
		panelCpu.setBounds(350, 258, 154, 94);
		contentPane.add(panelCpu);
		panelCpu.setBackground(Color.LIGHT_GRAY);
		panelCpu.setLayout(null);

		JLabel lblNvCpu = new JLabel("Lv Cpu:");
		lblNvCpu.setBounds(10, 11, 62, 14);
		panelCpu.add(lblNvCpu);
		lblNvCpu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelNvCpu.setBounds(98, 11, 46, 14);
		panelCpu.add(labelNvCpu);
		labelNvCpu.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelNvCpu.setText("1");

		JLabel lblNomeAtaque = new JLabel("Ataque: ");
		lblNomeAtaque.setBounds(10, 69, 62, 14);
		panelCpu.add(lblNomeAtaque);
		lblNomeAtaque.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelNomeAtaque.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		labelNomeAtaque.setBounds(82, 69, 46, 14);
		panelCpu.add(labelNomeAtaque);

		JPanel panelPlayer = new JPanel();
		panelPlayer.setBounds(36, 258, 138, 94);
		contentPane.add(panelPlayer);
		panelPlayer.setBackground(Color.LIGHT_GRAY);
		panelPlayer.setLayout(null);
		btnSocoPlay.setBounds(10, 11, 117, 25);
		panelPlayer.add(btnSocoPlay);
		btnEspecialPlay.setBounds(10, 58, 117, 25);
		panelPlayer.add(btnEspecialPlay);
		lblCenarioLuta.setIcon(
				new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\cenarioGokuVSVegeta.jpg"));
		lblCenarioLuta.setBounds(0, 0, 526, 376);
		contentPane.add(lblCenarioLuta);
		btnEspecialPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				especialPlayer();
			}
		});
		btnSocoPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				socoPlayer();
			}
		});
		musicaFundo();
	}

	public void musicaFundo() {
		TimerTask musica = new TimerTask() {
			@Override
			public void run() {
				String path = "C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\music\\GokuvsVegeta.mp3";
				File mp3File = new File(path);
				MP3 musica = new MP3(mp3File);
				musica.play();
			}
		};
		timer2.schedule(musica, 0);
	}

	public void selecionaAtaqueCpu() {
		if (flag) {
			switch (random.nextInt(3)) {
			case 0:
				socoCpu();
				labelNomeAtaque.setText("Soco");
				break;
			case 1:
				chuteCpu();
				labelNomeAtaque.setText("Chute");
				break;
			case 2:
				especialCpu();
				labelNomeAtaque.setText("Especial");
				break;
			default:
				break;
			}
		}
	}

	public void testaVidaCpu(int hp) {
		if (hp <= 0) {
			flag = false;
			lblper2.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\vegetaDie.png"));
			lblper2.setBounds(381, 170, 115, 134);
			switch (JOptionPane.showConfirmDialog(panelDados, "Continuar Batalha")) {
			case 0:
				nrInimigo++;
				labelHpCpu.setText("" + (10 + nrInimigo));
				labelNvCpu.setText("" + (nrInimigo + 1));
				if (nrInimigo >= 50 && contEspecial < 5) {
					contEspecial++;
				}
				lblper2.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\Vegeta1.gif"));
				lblper2.setBounds(381, 104, 115, 134);
				labelNrRodada.setText("" + (Integer.parseInt(labelNrRodada.getText()) + 1));
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				System.exit(EXIT_ON_CLOSE);
			case 2:
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				System.exit(EXIT_ON_CLOSE);
			default:
				break;
			}
		} else if (hp > 0) {
			flag = true;
		}
	}

	public boolean testaVidaPlay(int hp) {
		if (hp <= 0) {
			switch (JOptionPane.showConfirmDialog(null, "Continuar Batalha")) {
			case 0:
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				nrInimigo++;
				labelHpPlayer.setText("" + 150);
				labelNrRodada.setText("" + (Integer.parseInt(labelNrRodada.getText()) + 1));
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				System.exit(EXIT_ON_CLOSE);
			case 2:
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				System.exit(EXIT_ON_CLOSE);
			default:
				break;
			}
		}
		return true;
	}

	public void chuteCpu() {

		TimerTask tarefa1 = new TimerTask() {
			@Override
			public void run() {
				lblper2.setIcon(
						new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\vegetaChute.png"));
				lblGoku.setIcon(
						new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\gokudamage.png"));
				labelHpPlayer.setForeground(Color.RED);
				lblper2.setBounds(170, 104, 145, 134);

			}
		};
		TimerTask tarefa2 = new TimerTask() {
			@Override
			public void run() {
				labelHpPlayer.setForeground(Color.BLACK);
				lblper2.setBounds(381, 104, 115, 134);
				lblper2.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\Vegeta1.gif"));
				lblGoku.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\goku1.gif"));
				lblGoku.setBounds(12, 117, 162, 121);
				labelHpPlayer.setText("" + (Integer.parseInt(labelHpPlayer.getText()) - (2 + (nrInimigo / 10))));
				btnSocoPlay.setEnabled(true);
				btnEspecialPlay.setEnabled(true);
			}
		};
		timer.schedule(tarefa1, 2000);
		timer.schedule(tarefa2, 3000);
	}

	public void socoCpu() {
		TimerTask tarefa1 = new TimerTask() {
			@Override
			public void run() {
				lblper2.setIcon(
						new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\vegetaSoco.png"));
				lblGoku.setIcon(
						new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\gokudamage.png"));
				labelHpPlayer.setForeground(Color.RED);
				lblper2.setBounds(170, 104, 145, 134);
			}
		};
		TimerTask tarefa2 = new TimerTask() {
			@Override
			public void run() {
				labelHpPlayer.setForeground(Color.BLACK);
				lblper2.setBounds(381, 104, 115, 134);
				lblper2.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\Vegeta1.gif"));
				lblGoku.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\goku1.gif"));
				lblGoku.setBounds(12, 117, 162, 121);
				labelHpPlayer.setText("" + (Integer.parseInt(labelHpPlayer.getText()) - (2 + (nrInimigo / 10))));
				btnSocoPlay.setEnabled(true);
				btnEspecialPlay.setEnabled(true);
			}
		};
		timer.schedule(tarefa1, 2000);
		timer.schedule(tarefa2, 3000);
	}

	public void especialCpu() {
		TimerTask tarefa1 = new TimerTask() {
			@Override
			public void run() {
				lblper2.setIcon(
						new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\VegetaEspecial.gif"));
				lblper2.setBounds(80, 20, 400, 340);
				labelHpPlayer.setForeground(Color.RED);
			}
		};

		TimerTask tarefa2 = new TimerTask() {
			@Override
			public void run() {
				labelHpPlayer.setForeground(Color.BLACK);

				lblper2.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\Vegeta1.gif"));
				lblper2.setBounds(381, 104, 115, 134);
				lblGoku.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\goku1.gif"));
				lblGoku.setBounds(12, 117, 162, 121);
				labelHpPlayer.setText("" + (Integer.parseInt(labelHpPlayer.getText()) - (2 + (nrInimigo / 10))));
				btnSocoPlay.setEnabled(true);
				btnEspecialPlay.setEnabled(true);
			}
		};
		TimerTask tarefa3 = new TimerTask() {
			@Override
			public void run() {
				lblGoku.setIcon(
						new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\gokudamage.png"));
			}
		};
		timer.schedule(tarefa1, 0);
		timer.schedule(tarefa3, 1000);
		timer.schedule(tarefa2, 5000);
	}

	public void socoPlayer() {
		move = 65;
		labelHpCpu.setText(Integer.toString(Integer.parseInt(labelHpCpu.getText()) - 7));
		labelHpCpu.setForeground(Color.RED);
		TimerTask tarefa1 = new TimerTask() {
			@Override
			public void run() {
				if (move <= 300) {
					lblGoku.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\goku3.png"));
					lblGoku.setBounds(move, 117, 170, 131);
					move = move + 20;
				} else if (move == 305) {
					move = 310;
					lblper2.setIcon(
							new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\vegetaDamege.png"));
				} else if (move == 310) {
					lblper2.setBounds(moveCpu, 104, 115, 134);
					moveCpu = moveCpu + 10;
					if (moveCpu > 500) {
						move = 315;
					}
				}
			}
		};
		TimerTask tarefa2 = new TimerTask() {
			@Override
			public void run() {
				if (move == 315) {
					testaVidaCpu(Integer.parseInt(labelHpCpu.getText()));
					labelHpCpu.setForeground(Color.BLACK);
					move = 320;
				}
			}
		};
		TimerTask tarefa3 = new TimerTask() {
			@Override
			public void run() {
				if (move == 320) {
					lblGoku.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\goku1.gif"));
					lblGoku.setBounds(65, 117, 170, 131);
					lblper2.setIcon(
							new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\Vegeta1.gif"));
					lblper2.setBounds(381, 117, 115, 134);

				}
			}
		};
		TimerTask tarefa4 = new TimerTask() {
			@Override
			public void run() {
				if (flag) {
					btnSocoPlay.setEnabled(false);
					btnEspecialPlay.setEnabled(false);
					selecionaAtaqueCpu();
				}

			}
		};
		timer.schedule(tarefa1, 0, 50);
		timer.schedule(tarefa2, 2000);
		timer.schedule(tarefa3, 2500);
		timer.schedule(tarefa4, 3000);
	}

	public void especialPlayer() {
		lblGoku.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\gokukameha.gif"));
		lblGoku.setBounds(120, 117, 325, 121);
		lblper2.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\VegetaDamege.png"));
		contEspecial--;
		lblNrMana.setText(Integer.toString(contEspecial));
		if (contEspecial > 0) {
			TimerTask tarefa1 = new TimerTask() {
				@Override
				public void run() {
					labelHpCpu.setForeground(Color.RED);
				}
			};
			TimerTask tarefa2 = new TimerTask() {
				@Override
				public void run() {
					lblGoku.setIcon(new ImageIcon("C:\\Users\\lopes\\Desktop\\Entra21\\SuperRpg\\src\\res\\goku1.gif"));
					labelHpCpu.setForeground(Color.BLACK);
					labelHpCpu.setText(Integer.toString(Integer.parseInt(labelHpCpu.getText()) - 20));
					testaVidaCpu(Integer.parseInt(labelHpCpu.getText()));
				}
			};
			timer.schedule(tarefa1, 0);
			timer.schedule(tarefa2, 2000);
		} else {
			JOptionPane.showMessageDialog(null, "Especial Acabou, Será Ultilizado um Ataque");
			socoPlayer();
		}
	}
}
