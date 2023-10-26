import java.awt.*;
import java.awt.event.*;
import java.awt.print.PrinterException;
import javax.swing.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.*;

public class JaHTML extends JFrame implements ActionListener {
    JMenuBar menubar = new JMenuBar();
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
	JMenu add1 = new JMenu("Add");
	JToolBar toolbar = new JToolBar();

    JMenuItem newFile = new JMenuItem("New");
    JMenuItem openFile = new JMenuItem("Open");
    JMenuItem saveFile = new JMenuItem("Save");
    JMenuItem exit = new JMenuItem("Exit");

    JMenuItem cut = new JMenuItem("Cut");
    JMenuItem copy = new JMenuItem("Copy");
    JMenuItem paste = new JMenuItem("Paste");
    JMenuItem selectall = new JMenuItem("Select All");
	
	JMenuItem setheader = new JMenuItem("<header>");
	JMenuItem setp = new JMenuItem("<p>");
	JMenuItem setimg = new JMenuItem("Image");
	JMenuItem seta = new JMenuItem("Link");
	JMenuItem setdiv = new JMenuItem("<div>");
	JMenuItem sethr = new JMenuItem("<hr>");
	JMenuItem setfooter = new JMenuItem("<footer>");
	JMenuItem setstructure = new JMenuItem("Structure");


    JMenuItem about = new JMenuItem("About");

    JTextArea textArea = new JTextArea();

    JaHTML() {
        setTitle("JaHTML");
        setBounds(100, 100, 820, 620);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon(getClass().getResource("JaHTMLicon.png"));
        setIconImage(icon.getImage());

        setJMenuBar(menubar);
		
        menubar.add(file);
        menubar.add(edit);
		menubar.add(add1);
		menubar.add(help);

        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);
        file.add(exit);

        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectall);
        help.add(about);
		
		add1.add(setp);
		add1.add(setdiv);
		add1.add(sethr);
		add1.add(seta);
		add1.add(setimg);
		add1.add(setheader);
		add1.add(setfooter);
		add1.add(setstructure);
		
		
        JScrollPane scrollpane = new JScrollPane(textArea);
        add(scrollpane);
		int tabSize = textArea.getTabSize();
		tabSize = 4;
		textArea.setTabSize(tabSize);
        textArea.setFont((new Font(Font.SANS_SERIF, Font.PLAIN, 14)));
        scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollpane.setBorder(BorderFactory.createEmptyBorder());
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);


        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);
        exit.addActionListener(this);
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectall.addActionListener(this);
        about.addActionListener(this);
		
		setp.addActionListener(this);
		setimg.addActionListener(this);
		seta.addActionListener(this);
		setdiv.addActionListener(this);
		setheader.addActionListener(this);
		setfooter.addActionListener(this);
		sethr.addActionListener(this);
		setstructure.addActionListener(this);

        newFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));
        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_DOWN_MASK));
        cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));
        copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.CTRL_DOWN_MASK));
        selectall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));
        about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J, KeyEvent.CTRL_DOWN_MASK));
		
		setp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, KeyEvent.ALT_DOWN_MASK));
		seta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.ALT_DOWN_MASK));
		setimg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, KeyEvent.ALT_DOWN_MASK));
		sethr.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, KeyEvent.ALT_DOWN_MASK));
		setdiv.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.ALT_DOWN_MASK));
		

    }

    public static void main(String[] args) throws Exception{

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        new JaHTML().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("New")) {
            textArea.setText(null);
        } else if (e.getActionCommand().equalsIgnoreCase("Save")) {

            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter(".html", "html");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);

            int action = fileChooser.showSaveDialog(null);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if (!fileName.contains(".html"))
                    fileName = fileName + ".html";

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
                    textArea.write(writer);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        } else if (e.getActionCommand().equalsIgnoreCase("Open")) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter textFilter = new FileNameExtensionFilter(".html", "html");
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(textFilter);

            int action = fileChooser.showOpenDialog(null);
            if (action != JFileChooser.APPROVE_OPTION) {
                return;
            } else {
                String fileName = fileChooser.getSelectedFile().getAbsolutePath().toString();
                if (!fileName.contains(".html"))
                    fileName = fileName + ".html";

                try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                textArea.setText(""); // clear the text area
                String line;
                while ((line = reader.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        } else if (e.getActionCommand().equalsIgnoreCase("Exit")) {

            System.exit(0);

        } else if (e.getActionCommand().equalsIgnoreCase("Cut")) {
            textArea.cut();

        } else if (e.getActionCommand().equalsIgnoreCase("Copy")) {
            textArea.copy();
        } else if (e.getActionCommand().equalsIgnoreCase("Paste")) {
            textArea.paste();
        } else if (e.getActionCommand().equalsIgnoreCase("Select All")) {
            textArea.selectAll();
		/* HTML Tags */
		} else if (e.getActionCommand().equalsIgnoreCase("<Header>")) {
            textArea.insert("<header></header>", textArea.getCaretPosition());
		} else if (e.getActionCommand().equalsIgnoreCase("<p>")) {
            textArea.insert("<p></p>", textArea.getCaretPosition());
		} else if (e.getActionCommand().equalsIgnoreCase("Image")) {
            textArea.insert("<img src=\"\" alt=\"\" width=\"auto\" height=\"auto\">", textArea.getCaretPosition());
		} else if (e.getActionCommand().equalsIgnoreCase("Link")) {
            textArea.insert("<a href=\"\"></a>", textArea.getCaretPosition());
		} else if (e.getActionCommand().equalsIgnoreCase("<hr>")) {
            textArea.insert("<hr style=\"height:auto;border-width:auto;color:auto;background-color:auto\">", textArea.getCaretPosition());
		} else if (e.getActionCommand().equalsIgnoreCase("<div>")) {
            textArea.insert("<div></div>", textArea.getCaretPosition());
		} else if (e.getActionCommand().equalsIgnoreCase("<footer>")) {
            textArea.insert("<footer></footer>", textArea.getCaretPosition());
		} else if (e.getActionCommand().equalsIgnoreCase("Structure")) {
            textArea.append("<!DOCTYPE html>\n");
			textArea.append("<html lang=\"en\">\n");
			textArea.append("	<head>\n");
			textArea.append("		<title></title>\n");
			textArea.append("		<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
			textArea.append("	</head>\n");
			textArea.append("		<body>\n");
			textArea.append("			\n");
			textArea.append("		</body>\n");
			textArea.append("</html>\n");
		/* About */
        } else if (e.getActionCommand().equalsIgnoreCase("About")) {
            new About().setVisible(true);

        }

    }
}
