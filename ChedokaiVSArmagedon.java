import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ChedokaiVSArmagedon extends JFrame {

	JPanel contentPane;
	JButton btnSocoPlay = new JButton("Soco");
	JButton btnEspecialPlay = new JButton("Especial");
	JLabel per1 = new JLabel(new ImageIcon(getClass().getResource("1_char-removebg-preview.png")));
	JLabel per2 = new JLabel(new ImageIcon(getClass().getResource("2char-removebg-preview.png")));
	JLabel pancada = new JLabel(new ImageIcon(getClass().getResource("pow-1601674_640.png")));
	JLabel labelNrRodada = new JLabel("1");
	JLabel labelNomeAtaque = new JLabel("");
	JLabel labelNvCpu = new JLabel("");
	JLabel labelHpPlayer = new JLabel();
	JLabel labelManaPlayer = new JLabel();
	JLabel lblNrMana = new JLabel("");
	JLabel labelHpCpu = new JLabel();
	Random random = new Random(012);
	Timer timer = new Timer();
	boolean flag = true;
	int contEspecial = 5;
	int nrInimigo = 0;
	int tamanhoX = 93, tamanhoY = 61;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChedokaiVSArmagedon frame = new ChedokaiVSArmagedon();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
			switch (JOptionPane.showInputDialog(null, "Deseja Continuar na Batalha\n1-Sim\n2-Não")) {
			case "sim":
				nrInimigo++;
				labelHpCpu.setText("" + (10 + nrInimigo));
				labelNvCpu.setText("" + (nrInimigo + 1));
				if (nrInimigo >= 50 && contEspecial < 5) {
					contEspecial++;
				}
				break;
			case "1":
				nrInimigo++;
				labelHpCpu.setText("" + (10 + nrInimigo));
				labelNvCpu.setText("" + (nrInimigo + 1));
				if (nrInimigo >= 50 && contEspecial < 5) {
					contEspecial++;
				}
				break;
			case "2":
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				System.exit(EXIT_ON_CLOSE);
			case "nao":
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				System.exit(EXIT_ON_CLOSE);
			default:
				break;
			}
		} else {
			flag = true;
		}
	}
	public boolean testaVidaPlay(int hp) {
		if (hp <= 0) {
			switch (JOptionPane.showInputDialog(null, "Morreu!!!\nDeseja Continuar na Batalha\n1 - Sim\n2-Não")) {
			case "sim":
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				nrInimigo++;
				labelHpPlayer.setText("" + 150);
				break;
			case "1":
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				nrInimigo++;
				labelHpPlayer.setText("" + 150);
				break;
			case "2":
				JOptionPane.showMessageDialog(null, "Voce matou: " + (nrInimigo + 1) + " Inimigos");
				System.exit(EXIT_ON_CLOSE);
			case "nao":
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
				pancada.setVisible(true);
				labelHpPlayer.setForeground(Color.RED);
				per2.setBounds((per2.getX() - 125), 117, tamanhoX, tamanhoY);
			}
		};
		TimerTask tarefa2 = new TimerTask() {
			@Override
			public void run() {
				pancada.setVisible(false);
				labelHpPlayer.setForeground(Color.BLACK);
				per2.setBounds(232, 117, tamanhoX, tamanhoY);
				labelNrRodada.setText("" + (Integer.parseInt(labelNrRodada.getText()) + 1));
				labelHpPlayer.setText("" + (Integer.parseInt(labelHpPlayer.getText()) - (3 + (nrInimigo / 10))));
			}
		};
		timer.schedule(tarefa1, 2000);
		timer.schedule(tarefa2, 3000);
	}

	public void socoCpu() {
		TimerTask tarefa1 = new TimerTask() {

			@Override
			public void run() {

				pancada.setVisible(true);
				labelHpPlayer.setForeground(Color.RED);
				per2.setBounds((per2.getX() - 125), 117, tamanhoX, tamanhoY);
			}
		};
		TimerTask tarefa2 = new TimerTask() {

			@Override
			public void run() {
				pancada.setVisible(false);
				labelHpPlayer.setForeground(Color.BLACK);
				per2.setBounds(232, 117, tamanhoX, tamanhoY);
				labelNrRodada.setText("" + (Integer.parseInt(labelNrRodada.getText()) + 1));
				labelHpPlayer.setText("" + (Integer.parseInt(labelHpPlayer.getText()) - (2 + (nrInimigo / 10))));
			}
		};
		timer.schedule(tarefa1, 2000);
		timer.schedule(tarefa2, 3000);
	}

	public void especialCpu() {

		TimerTask tarefa1 = new TimerTask() {
			@Override
			public void run() {
				pancada.setVisible(true);
				labelHpPlayer.setForeground(Color.RED);
				per2.setBounds((per2.getX() - 125), 117, tamanhoX, tamanhoY);
			}
		};
		TimerTask tarefa2 = new TimerTask() {
			@Override
			public void run() {
				pancada.setVisible(Boolean.FALSE);
				labelHpPlayer.setForeground(Color.BLACK);
				per2.setBounds(232, 117, tamanhoX, tamanhoY);
				labelNrRodada.setText("" + (Integer.parseInt(labelNrRodada.getText()) + 1));
				labelHpPlayer.setText("" + (Integer.parseInt(labelHpPlayer.getText()) - (4 + (nrInimigo / 20))));
			}
		};
		timer.schedule(tarefa1, 2000);
		timer.schedule(tarefa2, 3000);
	}

	public void socoPlayer() {
		TimerTask tarefa1 = new TimerTask() {

			@Override
			public void run() {
				pancada.setVisible(Boolean.TRUE);
				labelHpCpu.setForeground(Color.RED);
			}
		};

		TimerTask tarefa2 = new TimerTask() {

			@Override
			public void run() {
				pancada.setVisible(Boolean.FALSE);
				labelHpCpu.setForeground(Color.BLACK);
				per1.setBounds(72, 117, 93, 61);
				labelHpCpu.setText("" + (Integer.parseInt(labelHpCpu.getText()) - 7));
				testaVidaCpu(Integer.parseInt(labelHpCpu.getText()));
			}
		};
		timer.schedule(tarefa1, 0);
		timer.schedule(tarefa2, 500);
	}

	public void especialPlayer() {
		contEspecial--;
		lblNrMana.setText("" + contEspecial);
		if (contEspecial > 0) {
			TimerTask tarefa1 = new TimerTask() {
				@Override
				public void run() {
					pancada.setVisible(Boolean.TRUE);
					labelHpCpu.setForeground(Color.RED);
				}
			};
			TimerTask tarefa2 = new TimerTask() {
				@Override
				public void run() {
					pancada.setVisible(false);
					labelHpCpu.setForeground(Color.BLACK);
					per1.setBounds(72, 117, 93, 61);
					labelHpCpu.setText("" + (Integer.parseInt(labelHpCpu.getText()) - 20));
					testaVidaCpu(Integer.parseInt(labelHpCpu.getText()));
					
				}
			};
			timer.schedule(tarefa1, 0);
			timer.schedule(tarefa2, 500);
		} else {
			JOptionPane.showMessageDialog(null, "Especial Acabou, vai ser executado um soco");
			socoPlayer();
		}
	}

	public ChedokaiVSArmagedon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 350);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		per1.setBounds(72, 117, 93, 61);
		getContentPane().add(per1);
		per2.setBounds(232, 117, tamanhoX, tamanhoY);
		getContentPane().add(per2);
		getContentPane().add(pancada);
		
		pancada.setBounds(114, 38, 148, 106);
		pancada.setVisible(false);
		
		labelNvCpu.setText("1");
		btnEspecialPlay.setBounds(48, 235, 117, 25);
		contentPane.add(btnEspecialPlay);

		JLabel lblNvCpu = new JLabel("Lv Cpu:");
		lblNvCpu.setBounds(200, 189, 62, 14);
		contentPane.add(lblNvCpu);

		labelNvCpu.setBounds(302, 189, 46, 14);
		contentPane.add(labelNvCpu);

		JLabel lblNomeAtaque = new JLabel("Ataque: ");
		lblNomeAtaque.setBounds(200, 224, 62, 14);
		contentPane.add(lblNomeAtaque);

		labelNomeAtaque.setBounds(300, 224, 46, 14);
		contentPane.add(labelNomeAtaque);

		JLabel lblRodada = new JLabel("Rodada: ");
		lblRodada.setFont(new Font("Dialog", Font.BOLD, 17));
		lblRodada.setBounds(130, 12, 93, 15);
		contentPane.add(lblRodada);

		JLabel lblHp = new JLabel("Hp:");
		lblHp.setBounds(16, 32, 34, 15);
		contentPane.add(lblHp);

		JLabel lblHp_1 = new JLabel("Hp:");
		lblHp_1.setBounds(272, 32, 34, 15);
		contentPane.add(lblHp_1);

		labelHpPlayer.setBounds(60, 32, 70, 15);
		contentPane.add(labelHpPlayer);
		labelHpCpu.setBounds(300, 32, 70, 15);
		contentPane.add(labelHpCpu);
		labelManaPlayer.setText("Mana: ");

		labelManaPlayer.setBounds(16, 58, 46, 15);
		contentPane.add(labelManaPlayer);

		lblNrMana.setBounds(60, 58, 16, 14);
		contentPane.add(lblNrMana);
		labelHpCpu.setText("11");
		labelHpPlayer.setText("150");
		lblNrMana.setText(contEspecial + "");
		labelNrRodada.setFont(new Font("FreeSerif", Font.BOLD | Font.ITALIC, 17));
		labelNrRodada.setHorizontalAlignment(SwingConstants.CENTER);
		labelNrRodada.setBounds(220, 8, 60, 25);
		contentPane.add(labelNrRodada);

		btnSocoPlay.setBounds(48, 200, 117, 25);
		contentPane.add(btnSocoPlay);
		btnSocoPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				per1.setBounds((per1.getX() + 110), 117, 93, 61);
				socoPlayer();
				TimerTask tarefa3 = new TimerTask() {
					@Override
					public void run() {
						selecionaAtaqueCpu();
					}
				};
				timer.schedule(tarefa3, 1500);
			}
		});
		btnEspecialPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				per1.setBounds((per1.getX() + 110), 117, 93, 61);
				especialPlayer();
				TimerTask tarefa3 = new TimerTask() {
					@Override
					public void run() {
						selecionaAtaqueCpu();
					}
				};
				timer.schedule(tarefa3, 1500);
			}
		});
	}
}
