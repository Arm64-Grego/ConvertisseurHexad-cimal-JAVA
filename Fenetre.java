package fenetre;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class Fenetre extends JFrame {
	
	private JTextField champEntree;
	private JTextField champSortie;

    public Fenetre() {
        // *********************** FENÊTRE PRINCIPALE ************************************
        setTitle("Titre");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.BLACK);
        setLayout(new BorderLayout()); // Ajout important pour bien placer les éléments
        //*******************************************************************************
        
        //********************* PARTIE CENTRAL / TEXTBOX + LABEL
        JPanel panneauCentre = new JPanel(new GridLayout(2, 2, 10,10));
        panneauCentre.setBorder(new EmptyBorder(40, 40, 40, 40));
        panneauCentre.setBackground(Color.BLACK);
        
        JLabel labelEntree = new JLabel("Texte à convertir : ");
        labelEntree.setForeground(Color.WHITE);
        champEntree = new JTextField();
        
        JLabel labelSortie = new JLabel("Résultat Hexadécimal :");
        labelSortie.setForeground(Color.WHITE);
        champSortie = new JTextField();
        champSortie.setEditable(false);
        
        panneauCentre.add(labelEntree);
        panneauCentre.add(champEntree);
        panneauCentre.add(labelSortie);
        panneauCentre.add(champSortie);
        
        add(panneauCentre, BorderLayout.CENTER);

        // ******************** PANNEAU DU BAS ******************************************
        JPanel panneauBas = new JPanel(new BorderLayout());
        panneauBas.setBackground(Color.BLACK);
        panneauBas.setBorder(new EmptyBorder(0, 0, 20, 0));

        // ---- Bouton "A propos" à gauche ----
        JButton boutonApropos = new JButton("A Propos");
        boutonApropos.addActionListener(e -> JOptionPane.showMessageDialog(
                this,
                "Convertisseur Hexadécimal\n" +
                "Créé par Charbonneau Grégory\n" +
                "Codé en Java avec Swing ☕",
                "À propos",
                JOptionPane.INFORMATION_MESSAGE
        ));
        panneauBas.add(boutonApropos, BorderLayout.WEST);

        // ---- Bouton "Quitter" à droite ----
        JButton boutonQuitter = new JButton("Quitter");
        boutonQuitter.addActionListener(e -> System.exit(0));
        panneauBas.add(boutonQuitter, BorderLayout.EAST);
        
        // ---- Bouton "Generer3 au centre ----
        JButton boutonGenerer = new JButton("Génèrer");
        boutonGenerer.addActionListener(e -> {
        	String texte = champEntree.getText();
        	if (texte.isEmpty()) {
        		JOptionPane.showMessageDialog(this , 
        				"Veuillez entrer un text avant de génèrer.",
        				"Erreur",
        				JOptionPane.WARNING_MESSAGE
        		);
        		return;
        
        	}
        	
        	StringBuilder hex = new StringBuilder();
        	for (char c : texte.toCharArray()) {
        		hex.append(String.format("%02X ", (int) c ));
        	}
        	champSortie.setText(hex.toString().trim());
        });
        panneauBas.add(boutonGenerer, BorderLayout.CENTER);
        
        

        // ---- Ajout du panneau en bas ----
        add(panneauBas, BorderLayout.SOUTH);

        // ---- Afficher la fenêtre ----
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Fenetre());
    }
}