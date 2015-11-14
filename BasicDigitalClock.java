package basic.digital.clock;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.Timer;

public class BasicDigitalClock extends JPanel implements ActionListener{

    String H, M, S;
    String hourS, minS, secS;
    private static final long serialVersionUID = 1L;

    Color brown = new Color(139, 69, 19);
    public double sec = 55;
    public double min = 59;
    public double hour = 12;
    
    public static void main(String[] args) {

        JFrame frame = new JFrame("The Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        BasicDigitalClock bdg = new BasicDigitalClock();
        frame.add(bdg, BorderLayout.CENTER);

        frame.setSize(540, 200);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
    
    public BasicDigitalClock(){
        setBackground(Color.LIGHT_GRAY);

        setFocusable(true);

        Timer timer = new Timer(1000/60, this);
        timer.start();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 150, 540, 50);
        g.setColor(brown);
            g.fillRect(40, 20, 460, 120);
            g.fillRect(40, 130, 50, 20);
            g.fillRect(450, 130, 50, 20);
        g.setColor(Color.WHITE);
            g.fillRect(60, 40, 420, 80);
        g.setColor(Color.BLACK);
        g.setFont(new Font("TimesRoman", Font.BOLD, 100));
        /*
        String secS = (sec < 10 ? "0" : "") + Double.toString(sec); if you want to implement yourown time
        String minS = (min < 10 ? "0" : "") + Double.toString(min);
        String hourS = (hour < 10 ? "0" : "") + Double.toString(hour);
        String secs = secS.substring(0, 2);
        String mins = minS.substring(0, 2);
        String hours = hourS.substring(0, 2);
        */
            g.drawString(H, 70, 115); // change to hours to work
            g.drawString(M, 210, 115); // same here but to mins
            g.drawString(S, 350, 115); // change to secs
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {  
        Date date=new Date();    
        H = new SimpleDateFormat("HH").format(date); // Remove this for your own time
        M = new SimpleDateFormat("mm").format(date); // Remove this for your own time
        S = new SimpleDateFormat("ss").format(date); // Remove this for your own time
        /*
            try {
		Thread.sleep(125);
		sec+=0.125;
	    } catch (InterruptedException e1) {
		e1.printStackTrace();
	    }
            if(min == 60){
                min = 0;
            }
            if(sec == 60){
                sec = 0;
            }
            if(sec == 0){
                min++;
            }
            if(min == 60){
                hour++;
            }
            if(hour == 13){
                hour = 1;
            }

             If you want to place a specific time, place it in the min, sec, hours. 
             If you want to add animation, then the part in above this works,
             so the animation fits nicely
        */
        repaint();
    }
}
