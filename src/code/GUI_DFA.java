package code;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
class GUI_DFA extends JFrame implements ActionListener
{
	private JPanel pBase;
	private JPanel pMenu;
	private JPanel pLoadFile;
	private JButton btLoadTestFile;
	private JButton btLoadAutomatonFile;
	private JButton btPlay;
	private JButton btReset;
	private JTextArea taCode;
	private JTextArea taMsgs;
	private JScrollPane spCode;
	private JScrollPane spMsgs;
	private JLabel lbnameAutomaton;

	public GUI_DFA()
	{
		super("Analizador Lexico	");
		this.setLocation(400,  200);

		pBase = new JPanel();
		pBase.setLayout(new BoxLayout(pBase,BoxLayout.PAGE_AXIS ));
		pMenu = new JPanel(new FlowLayout(FlowLayout.CENTER));
		pLoadFile = new JPanel(new FlowLayout(FlowLayout.LEFT));

		ImageIcon load = convertImage("/img/open.png");
		ImageIcon run = convertImage("/img/play.png");
		ImageIcon reset = convertImage("/img/reset.png");
		ImageIcon automaton = convertImage("/img/automaton.png");
		lbnameAutomaton = new JLabel(" ");
		

		btLoadTestFile = new JButton(load);
		btLoadTestFile.addActionListener(this);
		btPlay = new JButton(run);
		btPlay.addActionListener(this);
		btReset = new JButton(reset);
		btReset.addActionListener(this);
		btLoadAutomatonFile = new JButton(automaton);
		btLoadAutomatonFile.addActionListener(this);


		taCode = new JTextArea("");
		taCode.setEditable(true);
		spCode = new JScrollPane(taCode);
		taMsgs = new JTextArea("");
		
		spMsgs = new JScrollPane(taMsgs);

		pMenu.add(btLoadTestFile);
		pMenu.add(btPlay);
		pMenu.add(btLoadAutomatonFile);
		pMenu.add(btReset);
	
		pLoadFile.add(lbnameAutomaton);
		
		pBase.add(pMenu);
		pBase.add(pLoadFile);
		
		pBase.add(spCode);
		pBase.add(new JLabel(" "));
		pBase.add(spMsgs);
		add(pBase);
		pack();
	}

	private ImageIcon convertImage(String path)
	{
		ImageIcon origen = new ImageIcon(getClass().getResource(path));
		Image conversion = origen.getImage();
		Image tam = conversion.getScaledInstance(20, 15, Image.SCALE_SMOOTH);
		ImageIcon fin = new ImageIcon(tam);

		return fin;
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == btLoadTestFile)
		{
			JFileChooser selectorArchivos = new JFileChooser();
			selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int resultado = selectorArchivos.showOpenDialog(this);
			File source = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado
			
			if(resultado == JFileChooser.APPROVE_OPTION)
			{
				try(FileReader fr =new FileReader(source))
				{
			        String cadena="";
			        int valor=fr.read();
			        while(valor!=-1){
			            cadena=cadena+(char)valor;
			            valor=fr.read();
			        }
			        taCode.setText(cadena);
			    }
				 catch (IOException e1) {e1.printStackTrace();}
			}
		}

		if(e.getSource() == btPlay)
		{
			String cad = taCode.getText();
			DFA a = new DFA(cad);
			a.printValues();

			//taMsgs.setText(a.evaluate(this.tfString.getText()));
		}

		if(e.getSource() == btReset)
		{
			taCode.setText("");
			taMsgs.setText("");

		}

		if(e.getSource() == btLoadAutomatonFile)
		{
			JFileChooser selectorArchivos = new JFileChooser();
			selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			int resultado = selectorArchivos.showOpenDialog(this);
			File source = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado
			lbnameAutomaton.setText("Automata seleccionado: " + selectorArchivos.getDescription(source));
	
			if (resultado == JFileChooser.APPROVE_OPTION) {
				try (FileReader fr = new FileReader(source)) {
					String cadena = "";
					int valor = fr.read();
					while (valor != -1) {
						cadena = cadena + (char) valor;
						valor = fr.read();
					}
					this.taMsgs.setText("Juan es puto");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	public static void main(String [] args)
	{
		GUI_DFA uI = new GUI_DFA();
		uI.setVisible(true);
		uI.setSize(500, 400);
		uI.setDefaultCloseOperation(uI.EXIT_ON_CLOSE);
	}

}
