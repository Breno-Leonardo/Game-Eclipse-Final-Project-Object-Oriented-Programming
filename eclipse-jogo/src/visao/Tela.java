package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

import modelo.Arqueiro;
import modelo.Guerreiro;
import modelo.Mago;
import modelo.Humano;
import modelo.Inimigo;

/**
 * Interface Grafica Do Jogo Eclipse
 * 
 * @author Breno 
 * @version 1.0
 */
public class Tela {
	private Humano heroi;// cria heroi sem classe
	private Inimigo inimigo1 = new Inimigo("Lagarta Dragão", 100, "Chuva Ácida");
	private Inimigo inimigo2 = new Inimigo("Besta", 300, "Machado");
	private Inimigo inimigo3 = new Inimigo("Mago Supremo", 1000, "Sucção de Alma");

	private JFrame frame;
	private JTextField tNome;
	private JButton btnMago, btnArqueiro, btnGuerreiro, btnIniciar, btnIniciarComb, btnHistoria, btnFecharComb1,
			btnFecharComb2, btnFecharComb3, ataque1, ataque2, btnFechar, ataque1_1, ataque2_1, ataque2_2, ataque1_2,
			btnPoder3, btnPoder2, btnPoder1;
	JPanel combate1 = new JPanel(), combate2 = new JPanel(), combate3 = new JPanel();
	private JLabel vida, vida_1, telaCombate1, telaCombate2, telaCombate3, vida_2, vida_3, vida_4, vida_5, fim,
			lblTitulo, lblNome, lblClasse, telaInicial, perg;
	private Integer vidaMonstro, vidaHeroi;
	private JTextPane tpVidaHeroi_2, tpVidaMonstro, tpVidaHeroi, lore, tpClasse, tpVidaMonstro_1, tpVidaHeroi_1,
			textoComb1, textoComb2, textoComb3, tpVidaMonstro_2, poder1, poder2, poder3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Tela() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(1366, 768);
		frame.setUndecorated(true);// seta como sem bordas
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

//INICIO COMBATE 3
		combate3.setVisible(false);// tela combate 3
		combate3.setBounds(0, 0, 1366, 768);
		frame.getContentPane().add(combate3);
		combate3.setLayout(null);

		btnFecharComb3 = new JButton("SAIR");// botao de sair combate 3
		btnFecharComb3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JLabel lblTentativasFim = new JLabel("");
		lblTentativasFim.setForeground(Color.WHITE);
		lblTentativasFim.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		lblTentativasFim.setBounds(357, 665, 700, 87);
		lblTentativasFim.setText("Tentativas De  Salvar a Princesa: " + Humano.getTentativas());
		lblTentativasFim.setVisible(false);
		combate3.add(lblTentativasFim);

		btnFecharComb3.setForeground(Color.BLACK);
		btnFecharComb3.setFont(new Font("Pixel-Art", Font.PLAIN, 13));
		btnFecharComb3.setFocusTraversalPolicyProvider(true);
		btnFecharComb3.setFocusPainted(false);
		btnFecharComb3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnFecharComb3.setBackground(Color.WHITE);
		btnFecharComb3.setBounds(1289, 11, 67, 31);
		combate3.add(btnFecharComb3);

		btnPoder3 = new JButton("STATUS");// botao caracteristicas combate 3
		btnPoder3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poder3.setVisible(!poder3.isVisible());
				poder3.setText("ITEM:" + heroi.getNomeItem() + "\n" + "FORCA:" + heroi.getForca() + "\n" + "AGILIDADE:"
						+ heroi.getAgilidade() + "\n" + "PODER MAGICO:" + heroi.getPoderMagico() + "\n");
			}
		});
		btnPoder3.setForeground(Color.BLACK);
		btnPoder3.setFont(new Font("Pixel-Art", Font.PLAIN, 13));
		btnPoder3.setFocusTraversalPolicyProvider(true);
		btnPoder3.setFocusPainted(false);
		btnPoder3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPoder3.setBackground(Color.WHITE);
		btnPoder3.setBounds(10, 11, 67, 31);
		combate3.add(btnPoder3);

		poder3 = new JTextPane();// painel de caracteristicas combate 3
		poder3.setVisible(false);
		poder3.setForeground(Color.WHITE);
		poder3.setBackground(Color.BLACK);
		poder3.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		poder3.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		poder3.setBounds(74, 53, 315, 166);
		combate3.add(poder3);

		ataque1_2 = new JButton("");// botao ataque 1 combate 3
		ataque1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vidaMonstro = Integer.parseInt(tpVidaMonstro_2.getText()) - heroi.ataque(1);
				tpVidaMonstro_2.setText(vidaMonstro.toString());
				if (vidaMonstro <= 0) {// se o monstro for derrotado ele vai para a tela final
					tpVidaHeroi_2.setVisible(false);
					tpVidaMonstro_2.setVisible(false);
					ataque1_2.setVisible(false);
					ataque2_2.setVisible(false);
					vida_4.setVisible(false);
					vida_5.setVisible(false);
					textoComb3.setVisible(false);
					poder3.setVisible(false);
					fim.setVisible(true);
					poder3.setVisible(false);
					lblTentativasFim.setVisible(true);
					telaCombate3.setIcon(new ImageIcon(Tela.class.getClassLoader().getResource("Final.png")));

				} else {// mago ataca ate a vida do heroi chegar a 10
					textoComb3.setText(inimigo3.getNome() + " ataca com " + inimigo3.getNomeDoAtaque());
					vidaHeroi = Integer.parseInt(tpVidaHeroi_2.getText()) - 30;
					if (vidaHeroi == 10) {
						textoComb3.setFont(new Font("Pixel-Art", Font.PLAIN, 20));
						textoComb3.setText(
								"O amuleto que a princesa outrora entregou ao heroi comeca a brilhar e se funde a ele lhe dando um imenso poder");
						heroi.upgrade(1000);
						btnPoder3.doClick();
						if (!poder3.isVisible())// caso o menu de poder estiver aberto no momento
							btnPoder3.doClick();
					}
					tpVidaHeroi_2.setText(vidaHeroi.toString());
				}
			}
		});
		ataque1_2.setForeground(Color.BLACK);
		ataque1_2.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		ataque1_2.setFocusTraversalPolicyProvider(true);
		ataque1_2.setFocusPainted(false);
		ataque1_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		ataque1_2.setBackground(Color.WHITE);
		ataque1_2.setBounds(207, 515, 133, 73);
		combate3.add(ataque1_2);

		ataque2_2 = new JButton("");// botao ataque 2 combate 3
		ataque2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vidaMonstro = Integer.parseInt(tpVidaMonstro_2.getText()) - heroi.ataque(1, 2);
				tpVidaMonstro_2.setText(vidaMonstro.toString());
				if (vidaMonstro <= 0) {
					tpVidaHeroi_2.setVisible(false);
					tpVidaMonstro_2.setVisible(false);
					ataque1_2.setVisible(false);
					ataque2_2.setVisible(false);
					vida_4.setVisible(false);
					vida_5.setVisible(false);
					textoComb3.setVisible(false);
					fim.setVisible(true);
					poder3.setVisible(false);
					lblTentativasFim.setVisible(true);
					telaCombate3.setIcon(new ImageIcon(Tela.class.getClassLoader().getResource("Final.png")));

				} else {
					textoComb3.setText(inimigo3.getNome() + " ataca com " + inimigo3.getNomeDoAtaque());
					// cast
					vidaHeroi = Integer.parseInt(tpVidaHeroi_2.getText()) - 30;
					if (vidaHeroi == 10) {
						textoComb3.setFont(new Font("Pixel-Art", Font.PLAIN, 20));
						textoComb3.setText(
								"O amuleto que a princesa outrora entregou ao heroi comeca a brilhar e se funde a ele lhe dando um imenso poder");
						heroi.upgrade(1000);
						btnPoder3.doClick();
						if (!poder3.isVisible())// caso o menu de poder estiver aberto no momento
							btnPoder3.doClick();
					}
					tpVidaHeroi_2.setText(vidaHeroi.toString());
				}
			}
		});

		ataque2_2.setForeground(Color.BLACK);
		ataque2_2.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		ataque2_2.setFocusTraversalPolicyProvider(true);
		ataque2_2.setFocusPainted(false);
		ataque2_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		ataque2_2.setBackground(Color.WHITE);
		ataque2_2.setBounds(369, 513, 253, 73);
		combate3.add(ataque2_2);

		vida_4 = new JLabel("VIDA");// texto vida monstro combate 3
		vida_4.setForeground(Color.WHITE);
		vida_4.setFont(new Font("Pixel-Art", Font.PLAIN, 37));
		vida_4.setBounds(804, 150, 120, 83);
		combate3.add(vida_4);

		vida_5 = new JLabel("VIDA");// texto vida heroi combate 3
		vida_5.setForeground(Color.WHITE);
		vida_5.setFont(new Font("Pixel-Art", Font.PLAIN, 37));
		vida_5.setBounds(411, 252, 120, 83);
		combate3.add(vida_5);

		tpVidaMonstro_2 = new JTextPane();// caixa de vida monstro combate 3
		tpVidaMonstro_2.setText(String.valueOf(inimigo3.getVida()));
		tpVidaMonstro_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		tpVidaMonstro_2.setEditable(false);
		tpVidaMonstro_2.setBounds(822, 216, 75, 49);
		combate3.add(tpVidaMonstro_2);

		tpVidaHeroi_2 = new JTextPane();// caixa de vida heroi combate 3
		tpVidaHeroi_2.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		tpVidaHeroi_2.setEditable(false);
		tpVidaHeroi_2.setBounds(434, 314, 67, 49);
		combate3.add(tpVidaHeroi_2);

		textoComb3 = new JTextPane();// texto combate combate 3
		textoComb3.setForeground(Color.WHITE);
		textoComb3.setBackground(Color.BLACK);
		textoComb3.setFont(new Font("Pixel-Art", Font.PLAIN, 20));
		textoComb3.setEditable(false);
		textoComb3.setBounds(1031, 617, 325, 117);
		combate3.add(textoComb3);

		fim = new JLabel("FIM");// texto fim combate 3
		fim.setVisible(false);
		fim.setForeground(Color.WHITE);
		fim.setFont(new Font("Pixel-Art", Font.PLAIN, 57));
		fim.setBounds(603, 571, 153, 83);
		combate3.add(fim);

		telaCombate3 = new JLabel("New label");// imagem combate 3
		telaCombate3.setIcon(new ImageIcon(Tela.class.getClassLoader().getResource("lutaFinal.png")));
		telaCombate3.setBounds(0, 0, 1366, 768);
		combate3.add(telaCombate3);

// FIM COMBATE 3

// INICIO COMBATE 2
		combate2.setBounds(0, 0, 1366, 768);// tela combate 2
		combate2.setVisible(false);
		frame.getContentPane().add(combate2);
		combate2.setLayout(null);

		btnFecharComb2 = new JButton("SAIR");// botao sair combate 2
		btnFecharComb2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFecharComb2.setForeground(Color.BLACK);
		btnFecharComb2.setFont(new Font("Pixel-Art", Font.PLAIN, 13));
		btnFecharComb2.setFocusTraversalPolicyProvider(true);
		btnFecharComb2.setFocusPainted(false);
		btnFecharComb2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnFecharComb2.setBackground(Color.WHITE);
		btnFecharComb2.setBounds(1289, 11, 67, 31);
		combate2.add(btnFecharComb2);

		btnPoder2 = new JButton("STATUS");// botao caracteristica combate 2
		btnPoder2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poder2.setVisible(!poder2.isVisible());
				poder2.setText("ITEM:" + heroi.getNomeItem() + "\n" + "FORCA:" + heroi.getForca() + "\n" + "AGILIDADE:"
						+ heroi.getAgilidade() + "\n" + "PODER MAGICO:" + heroi.getPoderMagico() + "\n");
			}
		});
		btnPoder2.setForeground(Color.BLACK);
		btnPoder2.setFont(new Font("Pixel-Art", Font.PLAIN, 13));
		btnPoder2.setFocusTraversalPolicyProvider(true);
		btnPoder2.setFocusPainted(false);
		btnPoder2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPoder2.setBackground(Color.WHITE);
		btnPoder2.setBounds(10, 11, 67, 31);
		combate2.add(btnPoder2);

		poder2 = new JTextPane();// painel caracteristicas combate 2
		poder2.setVisible(false);
		poder2.setForeground(Color.WHITE);
		poder2.setBackground(Color.BLACK);
		poder2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		poder2.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		poder2.setBounds(49, 47, 315, 166);
		combate2.add(poder2);

		ataque1_1 = new JButton("");// ataque 1 combate 2
		ataque1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vidaMonstro = Integer.parseInt(tpVidaMonstro_1.getText()) - heroi.ataque(1);
				tpVidaMonstro_1.setText(vidaMonstro.toString());
				if (vidaMonstro <= 0) {// vencendo o monstro o heroi vai para o prox combate
					heroi.upgrade();// aumenta as caracteristicas do heroi
					combate2.setVisible(false);
					combate3.setVisible(true);

				} else {// montro ataca
					textoComb2.setText(inimigo2.getNome() + " ataca com " + inimigo2.getNomeDoAtaque());
					vidaHeroi = Integer.parseInt(tpVidaHeroi_1.getText()) - 25;
					if (vidaHeroi <= 0) {// heroi morreu
						Humano.setTentativas(Humano.getTentativas() + 1);
						JOptionPane.showMessageDialog(null, "Voce Morreu", "ERROR", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						Tela window = new Tela();// reinicia a aplicacao
						window.frame.setVisible(true);
						window.frame.setLocationRelativeTo(null);
					}
					tpVidaHeroi_1.setText(vidaHeroi.toString());
				}
			}
		});
		ataque1_1.setForeground(Color.BLACK);
		ataque1_1.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		ataque1_1.setFocusTraversalPolicyProvider(true);
		ataque1_1.setFocusPainted(false);
		ataque1_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		ataque1_1.setBackground(Color.WHITE);
		ataque1_1.setBounds(45, 670, 133, 73);
		combate2.add(ataque1_1);

		ataque2_1 = new JButton("");// ataque 2 combate 2
		ataque2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vidaMonstro = Integer.parseInt(tpVidaMonstro_1.getText()) - heroi.ataque(1, 2);
				tpVidaMonstro_1.setText(vidaMonstro.toString());
				if (vidaMonstro <= 0) {
					heroi.upgrade();
					combate2.setVisible(false);
					combate3.setVisible(true);

				} else {
					textoComb2.setText(inimigo2.getNome() + " ataca com " + inimigo2.getNomeDoAtaque());
					vidaHeroi = Integer.parseInt(tpVidaHeroi_1.getText()) - 25;
					if (vidaHeroi <= 0) {
						JOptionPane.showMessageDialog(null, "Voce Morreu", "ERROR", JOptionPane.INFORMATION_MESSAGE);
						frame.dispose();
						Tela window = new Tela();// reinicia a aplicacao
						window.frame.setVisible(true);
						window.frame.setLocationRelativeTo(null);
					}
					tpVidaHeroi_1.setText(vidaHeroi.toString());
				}
			}
		});
		ataque2_1.setForeground(Color.BLACK);
		ataque2_1.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		ataque2_1.setFocusTraversalPolicyProvider(true);
		ataque2_1.setFocusPainted(false);
		ataque2_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		ataque2_1.setBackground(Color.WHITE);
		ataque2_1.setBounds(212, 670, 253, 73);
		combate2.add(ataque2_1);

		textoComb2 = new JTextPane();// texto combate 2
		textoComb2.setForeground(Color.WHITE);
		textoComb2.setBackground(Color.BLACK);
		textoComb2.setFont(new Font("Pixel-Art", Font.PLAIN, 25));
		textoComb2.setEditable(false);
		textoComb2.setBounds(1093, 626, 237, 117);
		combate2.add(textoComb2);

		vida_2 = new JLabel("VIDA");// texto vida monstro combate 2
		vida_2.setForeground(Color.WHITE);
		vida_2.setFont(new Font("Pixel-Art", Font.PLAIN, 37));
		vida_2.setBounds(472, 237, 120, 83);
		combate2.add(vida_2);

		vida_3 = new JLabel("VIDA");// texto vida heroi combate 2
		vida_3.setForeground(Color.WHITE);
		vida_3.setFont(new Font("Pixel-Art", Font.PLAIN, 37));
		vida_3.setBounds(535, 660, 120, 83);
		combate2.add(vida_3);

		tpVidaMonstro_1 = new JTextPane();// caixa de vida monstro combate 2
		tpVidaMonstro_1.setText(String.valueOf(inimigo2.getVida()));
		tpVidaMonstro_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		tpVidaMonstro_1.setEditable(false);
		tpVidaMonstro_1.setBounds(497, 314, 67, 49);
		combate2.add(tpVidaMonstro_1);

		tpVidaHeroi_1 = new JTextPane();// caixa de vida heroi combate 2
		tpVidaHeroi_1.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		tpVidaHeroi_1.setEditable(false);
		tpVidaHeroi_1.setBounds(662, 680, 67, 49);
		combate2.add(tpVidaHeroi_1);

		telaCombate2 = new JLabel("New label");// imagem combate 2
		telaCombate2.setIcon(new ImageIcon(Tela.class.getClassLoader().getResource("arena2.png")));
		telaCombate2.setBounds(0, 0, 1366, 768);
		combate2.add(telaCombate2);
// FIM COMBATE 2

// INICIO COMBATE 1
		combate1.setBounds(0, 0, 1366, 768);// tela combate 1
		combate1.setVisible(false);
		combate1.setLayout(null);
		frame.getContentPane().add(combate1);

		btnFecharComb1 = new JButton("SAIR");// botao fechar combate 1
		btnFecharComb1.setBounds(1289, 11, 67, 31);
		btnFecharComb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		tpVidaMonstro = new JTextPane();// caixa de vida monstro combate 1
		tpVidaMonstro.setEditable(false);
		tpVidaMonstro.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		tpVidaMonstro.setBounds(982, 358, 67, 49);
		tpVidaMonstro.setText(String.valueOf(inimigo1.getVida()));
		combate1.add(tpVidaMonstro);

		btnPoder1 = new JButton("STATUS");// botao caracteristicas combate 1
		btnPoder1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				poder1.setVisible(!poder1.isVisible());
				poder1.setText("ITEM:" + heroi.getNomeItem() + "\n" + "FORCA:" + heroi.getForca() + "\n" + "AGILIDADE:"
						+ heroi.getAgilidade() + "\n" + "PODER MAGICO:" + heroi.getPoderMagico() + "\n");
			}
		});
		btnPoder1.setForeground(Color.BLACK);
		btnPoder1.setFont(new Font("Pixel-Art", Font.PLAIN, 13));
		btnPoder1.setFocusTraversalPolicyProvider(true);
		btnPoder1.setFocusPainted(false);
		btnPoder1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnPoder1.setBackground(Color.WHITE);
		btnPoder1.setBounds(10, 11, 67, 31);
		combate1.add(btnPoder1);

		poder1 = new JTextPane();// painel caracteristicas combate 1
		poder1.setVisible(false);
		poder1.setForeground(Color.WHITE);
		poder1.setBackground(Color.BLACK);
		poder1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		poder1.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		poder1.setBounds(74, 53, 315, 166);
		combate1.add(poder1);

		tpVidaHeroi = new JTextPane();// caixa vida heroi combate 1
		tpVidaHeroi.setEditable(false);
		tpVidaHeroi.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
		tpVidaHeroi.setBounds(193, 486, 67, 49);
		combate1.add(tpVidaHeroi);

		vida_1 = new JLabel("VIDA");// texto vida monstro combate 1
		vida_1.setForeground(Color.WHITE);
		vida_1.setFont(new Font("Pixel-Art", Font.PLAIN, 37));
		vida_1.setBounds(864, 338, 120, 83);
		combate1.add(vida_1);

		vida = new JLabel("VIDA");// texto vida heroi combate 1
		vida.setForeground(Color.WHITE);
		vida.setFont(new Font("Pixel-Art", Font.PLAIN, 37));
		vida.setBounds(74, 468, 120, 83);
		combate1.add(vida);

		ataque1 = new JButton("");// botao ataque 1 combate 1
		ataque1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vidaMonstro = Integer.parseInt(tpVidaMonstro.getText()) - heroi.ataque(1);
				tpVidaMonstro.setText(vidaMonstro.toString());
				if (vidaMonstro <= 0) {
					heroi.upgrade();
					combate1.setVisible(false);
					combate2.setVisible(true);

				} else {
					textoComb1.setText(inimigo1.getNome() + " ataca com " + inimigo1.getNomeDoAtaque());
					heroi.tomarDano(50);// ligacao dinamica
					tpVidaHeroi.setText(heroi.getVida().toString());
				}
			}
		});
		ataque1.setForeground(Color.BLACK);
		ataque1.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		ataque1.setFocusTraversalPolicyProvider(true);
		ataque1.setFocusPainted(false);
		ataque1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		ataque1.setBackground(Color.WHITE);
		ataque1.setBounds(273, 644, 133, 73);
		combate1.add(ataque1);

		ataque2 = new JButton("");// botao ataque 2 combate 1
		ataque2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer vidaMonstro = Integer.parseInt(tpVidaMonstro.getText()) - heroi.ataque(1, 2);
				tpVidaMonstro.setText(vidaMonstro.toString());
				if (vidaMonstro <= 0) {
					heroi.upgrade();
					combate1.setVisible(false);
					combate2.setVisible(true);

				} else {
					textoComb1.setText(inimigo1.getNome() + " ataca com " + inimigo1.getNomeDoAtaque());
					vidaHeroi = Integer.parseInt(tpVidaHeroi.getText()) - 10;
					tpVidaHeroi.setText(vidaHeroi.toString());
				}
			}
		});
		ataque2.setForeground(Color.BLACK);
		ataque2.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		ataque2.setFocusTraversalPolicyProvider(true);
		ataque2.setFocusPainted(false);
		ataque2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		ataque2.setBackground(Color.WHITE);
		ataque2.setBounds(438, 644, 253, 73);
		combate1.add(ataque2);

		textoComb1 = new JTextPane();// texto combate 1
		textoComb1.setForeground(Color.WHITE);
		textoComb1.setBackground(Color.BLACK);
		textoComb1.setFont(new Font("Pixel-Art", Font.PLAIN, 25));
		textoComb1.setEditable(false);
		textoComb1.setBounds(1137, 358, 219, 118);
		combate1.add(textoComb1);

		btnFecharComb1.setForeground(Color.BLACK);// botao sair combate 1
		btnFecharComb1.setFont(new Font("Pixel-Art", Font.PLAIN, 13));
		btnFecharComb1.setFocusTraversalPolicyProvider(true);
		btnFecharComb1.setFocusPainted(false);
		btnFecharComb1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnFecharComb1.setBackground(Color.WHITE);
		combate1.add(btnFecharComb1);

		telaCombate1 = new JLabel("New label");// imagem combate 1
		telaCombate1.setIcon(new ImageIcon(Tela.class.getClassLoader().getResource("arena1.png")));
		telaCombate1.setBounds(0, 0, 1406, 768);
		combate1.add(telaCombate1);
// FIM CODIGO COMBATE 1

//INICIO CODIGO TELA INICIAL
		lore = new JTextPane();// painel historia tela inicial
		lore.setVisible(false);

		JLabel lblTentativas = new JLabel("");
		lblTentativas.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
		lblTentativas.setBounds(536, 573, 393, 87);
		frame.getContentPane().add(lblTentativas);
		lblTentativas.setText("Tentativas De  Salvar a Princesa: " + Humano.getTentativas());
		lblTentativas.setVisible(false);

		lore.setForeground(Color.WHITE);
		lore.setBackground(Color.BLACK);
		lore.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		lore.setFont(new Font("Comic Sans MS", Font.PLAIN, 25));
		lore.setText(
				"Uma princesa foi raptada, atraves dela um poderoso mago almeja realizar um ritual no qual mergulhar\u00E1 o mundo em um eclipse eterno em troca da vida da princesa.");
		lore.setBounds(526, 243, 315, 268);
		frame.getContentPane().add(lore);

		tNome = new JTextField();// cadastro de nome, tela inicial
		tNome.setVisible(false);
		tNome.setFont(new Font("Pixel-Art", Font.PLAIN, 27));
		tNome.setColumns(10);
		tNome.setBounds(474, 181, 557, 50);
		frame.getContentPane().add(tNome);

		tpClasse = new JTextPane();// painel de classe tela inicial
		tpClasse.setText("CLASSE");
		tpClasse.setEditable(false);
		tpClasse.setVisible(false);
		tpClasse.setFont(new Font("Pixel-Art", Font.PLAIN, 27));
		tpClasse.setBounds(668, 269, 196, 40);
		frame.getContentPane().add(tpClasse);

		btnIniciarComb = new JButton("INICIAR");// botao iniciar combate apos esscolhe classe e nome, tela inicial
		btnIniciarComb.setVisible(false);
		btnIniciarComb.setForeground(Color.BLACK);
		btnIniciarComb.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		btnIniciarComb.setFocusTraversalPolicyProvider(true);
		btnIniciarComb.setFocusPainted(false);
		btnIniciarComb.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnIniciarComb.setBackground(Color.WHITE);
		btnIniciarComb.setBounds(644, 492, 133, 73);
		frame.getContentPane().add(btnIniciarComb);
		btnIniciarComb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {// tratamento de erro
					btnIniciarComb.setVisible(false);
					btnGuerreiro.setVisible(false);
					btnArqueiro.setVisible(false);
					btnMago.setVisible(false);
					if (tpClasse.getText().equals("GUERREIRO")) {
						heroi = new Guerreiro(tNome.getText());
					} else if (tpClasse.getText().equals("ARQUEIRO")) {
						heroi = new Arqueiro(tNome.getText());
					} else if (tpClasse.getText().equals("MAGO")) {
						heroi = new Mago(tNome.getText());
					}

					ataque1.setText(heroi.getNomeAtaque1());// nome dos ataques
					ataque2.setText(heroi.getNomeAtaque2());
					ataque1_1.setText(heroi.getNomeAtaque1());
					ataque2_1.setText(heroi.getNomeAtaque2());
					ataque1_2.setText(heroi.getNomeAtaque1());
					ataque2_2.setText(heroi.getNomeAtaque2());
					tpVidaHeroi.setText(heroi.getVida().toString());// vida inicial do heroi
					tpVidaHeroi_1.setText(heroi.getVida().toString());
					tpVidaHeroi_2.setText(heroi.getVida().toString());
					textoComb1.setText(heroi.getNome() + " VS " + inimigo1.getNome());
					textoComb2.setText(heroi.getNome() + " VS " + inimigo2.getNome());
					textoComb3.setText(heroi.getNome() + " VS " + inimigo3.getNome());
					combate1.setVisible(true);
				} catch (Exception e1) {// exibe msg de erro e reinicia a aplicacao
					JOptionPane.showMessageDialog(null, "Escolha Uma Classe", "ERROR", JOptionPane.INFORMATION_MESSAGE);
					frame.dispose();
					Tela window = new Tela();// reinicia a aplicacao
					window.frame.setVisible(true);
					window.frame.setLocationRelativeTo(null);
				}
			}
		});

		lblTitulo = new JLabel("ECLIPSE");// logo tela inicial
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Pixel-Art", Font.PLAIN, 90));
		lblTitulo.setBounds(451, -36, 632, 255);
		frame.getContentPane().add(lblTitulo);

		btnGuerreiro = new JButton("GUERREIRO");// botao guerreiro tela inicial
		btnGuerreiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpClasse.setText("GUERREIRO");
			}
		});
		btnGuerreiro.setVisible(false);
		btnGuerreiro.setForeground(Color.BLACK);
		btnGuerreiro.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		btnGuerreiro.setFocusTraversalPolicyProvider(true);
		btnGuerreiro.setFocusPainted(false);
		btnGuerreiro.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnGuerreiro.setBackground(Color.WHITE);
		btnGuerreiro.setBounds(430, 373, 133, 73);
		frame.getContentPane().add(btnGuerreiro);

		btnMago = new JButton("MAGO");// botao mago tela inicial
		btnMago.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpClasse.setText("MAGO");
			}
		});
		btnMago.setVisible(false);
		btnMago.setForeground(Color.BLACK);
		btnMago.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		btnMago.setFocusTraversalPolicyProvider(true);
		btnMago.setFocusPainted(false);
		btnMago.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnMago.setBackground(Color.WHITE);
		btnMago.setBounds(846, 373, 133, 73);
		frame.getContentPane().add(btnMago);

		btnArqueiro = new JButton("ARQUEIRO");// botao arqueiro tela inicial
		btnArqueiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpClasse.setText("ARQUEIRO");
			}
		});
		btnArqueiro.setVisible(false);
		btnArqueiro.setForeground(Color.BLACK);
		btnArqueiro.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		btnArqueiro.setFocusTraversalPolicyProvider(true);
		btnArqueiro.setFocusPainted(false);
		btnArqueiro.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnArqueiro.setBackground(Color.WHITE);
		btnArqueiro.setBounds(644, 373, 133, 73);
		frame.getContentPane().add(btnArqueiro);

		lblNome = new JLabel("NOME");// texto nome tela inicial
		lblNome.setVisible(false);
		lblNome.setFont(new Font("Pixel-Art", Font.PLAIN, 26));
		lblNome.setBounds(371, 173, 93, 59);
		frame.getContentPane().add(lblNome);

		lblClasse = new JLabel("CLASSE");// texto classe tela inicial
		lblClasse.setVisible(false);
		lblClasse.setFont(new Font("Pixel-Art", Font.PLAIN, 26));
		lblClasse.setBounds(538, 256, 151, 59);
		frame.getContentPane().add(lblClasse);

		perg = new JLabel("New label");// imagem pergaminho tela inicial
		perg.setVisible(false);
		perg.setIcon(new ImageIcon(Tela.class.getClassLoader().getResource("perg.png")));
		perg.setBounds(202, 0, 1366, 768);
		frame.getContentPane().add(perg);

		btnHistoria = new JButton("HISTORIA");// botao mostra historia tela inicial
		btnHistoria.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnHistoria.setBackground(Color.WHITE);
		btnHistoria.setForeground(Color.BLACK);
		btnHistoria.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		btnHistoria.setFocusTraversalPolicyProvider(true);
		btnHistoria.setFocusPainted(false);
		btnHistoria.setBounds(726, 522, 133, 73);
		btnHistoria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lore.setVisible(!lore.isVisible());
			}
		});
		frame.getContentPane().add(btnHistoria);

		btnIniciar = new JButton("INICIAR");// botao iniciar tela inicial
		btnIniciar.setForeground(Color.BLACK);
		btnIniciar.setFont(new Font("Pixel-Art", Font.PLAIN, 14));
		btnIniciar.setFocusTraversalPolicyProvider(true);
		btnIniciar.setFocusPainted(false);
		btnIniciar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnIniciar.setBackground(Color.WHITE);
		btnIniciar.setBounds(526, 522, 133, 73);
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {// inicia tela de escolha de classe
				perg.setVisible(true);
				btnIniciarComb.setVisible(true);
				lblNome.setVisible(true);
				tNome.setVisible(true);
				lblTentativas.setVisible(true);
				lblClasse.setVisible(true);
				tpClasse.setVisible(true);
				btnGuerreiro.setVisible(true);
				btnArqueiro.setVisible(true);
				btnMago.setVisible(true);
				btnHistoria.setVisible(false);
				btnIniciar.setVisible(false);
			}
		});
		frame.getContentPane().add(btnIniciar);

		btnFechar = new JButton("SAIR");// botao sair tela inicial
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setForeground(Color.BLACK);
		btnFechar.setFont(new Font("Pixel-Art", Font.PLAIN, 13));
		btnFechar.setFocusTraversalPolicyProvider(true);
		btnFechar.setFocusPainted(false);
		btnFechar.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnFechar.setBackground(Color.WHITE);
		btnFechar.setBounds(1289, 11, 67, 31);
		frame.getContentPane().add(btnFechar);

		telaInicial = new JLabel("");// imagem tela inicial
		telaInicial.setIcon(new ImageIcon(Tela.class.getClassLoader().getResource("telaInicial.png")));
		telaInicial.setBounds(0, 0, 1366, 768);
		frame.getContentPane().add(telaInicial);
//FIM CODIGO DA TELA INICIAL		
	}
}
