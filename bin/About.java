import javax.swing.*;
import java.awt.*;

public class About extends JFrame{


    About(){
        setTitle("About");
		
        setBounds(100, 100, 410, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);
        ImageIcon icon = new ImageIcon(getClass().getResource("JaHTMLicon.png"));
        setIconImage(icon.getImage());


        JLabel iconLabel= new JLabel(new ImageIcon(getClass().getResource("JaHTMLlogo.png")));
        iconLabel.setBounds(130, 40, 140, 130);
        add(iconLabel);

        JLabel textLabel = new JLabel("<html>JaHTML<br>Open source HTML editor written on Java<br>v0.1<br>  </html>");
        textLabel.setFont(new Font("SAN_SERIF", Font.PLAIN, 18));
        textLabel.setBounds(30, 95, 500, 300);
        add(textLabel);
		this.setResizable(false);
        this.setVisible(true);
    }

    public static void main(String[] args){
        new About().setVisible(true);
    }
}
