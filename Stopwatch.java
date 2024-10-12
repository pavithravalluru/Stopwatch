import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Stopwatch implements ActionListener{
    JFrame frame=new JFrame();
    JButton starButton=new JButton("Start");
    JButton resetButton=new JButton("reset");
    JLabel timLabel=new JLabel();
    int elapsedTime=0;
    int seconds=0;
    int minutes=0;
    int hours=0;
    boolean started=false;
    String seconds_string=String.format("%02d",seconds);
    String minutes_string=String.format("%02d",minutes);
    String hours_string=String.format("%02d",hours);

    

    Timer timer=new Timer(1000,new ActionListener() {

        public void actionPerformed(ActionEvent e)
        {
            elapsedTime+=1000;
            hours=(elapsedTime/3600000);
            minutes=(elapsedTime/60000)%60;
            seconds=(elapsedTime/1000)%60;
            seconds_string=String.format("%02d", seconds);
            minutes_string=String.format("%02d",minutes);
            hours_string=String.format("%02d",hours);
            timLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        }
    });

    Stopwatch()
    {
        timLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
        timLabel.setBounds(100,100,200,100);
        timLabel.setFont(new Font("Verdana",Font.PLAIN,35));
        timLabel.setBorder(BorderFactory.createBevelBorder(1));
        timLabel.setOpaque(true);
        timLabel.setHorizontalAlignment(JTextField.CENTER);
         
        starButton.setBounds(100,200,100,50);
        starButton.setFont(new Font("Verdana",Font.PLAIN,35));
        starButton.setFocusable(false);
        starButton.addActionListener(this);

        resetButton.setBounds(200,200,100,50);
        resetButton.setFont(new Font("Verdana",Font.PLAIN,35));
        resetButton.setFocusable(false);
        resetButton.addActionListener(this);


        frame.add(starButton);
        frame.add(resetButton);
        frame.add(timLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);

    }
   @Override
   public void actionPerformed(ActionEvent e)
   {
    if(e.getSource()==starButton)
    {
        
        
        if(started==false)
        {
            started=true;
            starButton.setText("Stop");
            start();
        }
        else{
            started=false;
            starButton.setText("Start");
            stop();
        }
    }
    if(e.getSource()==resetButton)
    {
        started=false;
        start();
        starButton.setText("Start");
        reset();
    }

   }

   void start()
   {

    timer.start();
   }
   void stop()
   {
    timer.stop();

   }
   void reset()
   {

    timer.stop();
    elapsedTime=0;
    seconds=0;
    minutes=0;
    hours=0;
    seconds_string=String.format("%02d", seconds);
    minutes_string=String.format("%02d",minutes);
    hours_string=String.format("%02d",hours);
    timLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
   }
    
}