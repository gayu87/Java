/****************************************************************************************
    Created by: Gayatri Patel
    Data:      11/10/2016
    course:   CSC 5991
    project:  1 part1


 ****************************************************************************************/
package projectone;

// import
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


    
// classd
public class Projectone extends JFrame implements ActionListener {
     
	
    Timer timer = new Timer(35, this);
            
    static class Ball {
    	 // variables for ball 1
        int x = 0, velx = 0;
         // variable for ball 2
        int y= 0, vely = 0;
        int size = 50;
        Color color, strokeColor;
        boolean isMoving = true;
         // draw method
        public void draw(Graphics g)
        {
            int x0 = x - size / 2, y0 = y - size / 2;
            final int s = 3;
            g.setColor(strokeColor);
            g.fillOval(x0 - s, y0 - s, size + s * 2, size + s * 2);
            g.setColor(color);
            g.fillOval(x0, y0, size, size);
        }
         // stop method
        public void step()
        {
        	if(!isMoving)
        		return;
        	
            if (x < 0 || x > 540)
                velx = -velx;
                    
            x = x + velx;
            if (y < 0 || y > 540)
                vely = -vely;
                    
            y = y + vely;          	
        }
    }
 
     // class BallControlPanel
    static class BallControlPanel extends JPanel
    {
    	Ball ball;

    	JTextField velocity, radius; 
    	  
    	// handler
        class Handler implements ActionListener
        {
            // method actionPerformed
            public void actionPerformed(ActionEvent e) 
            {
                String one = velocity.getText();
                String three = radius.getText();
                
                if(!one.isEmpty())
                {
                    double hypot = Math.sqrt(ball.velx * ball.velx + ball.vely * ball.vely);
                    double new_speed = Integer.parseInt(one);
                	ball.velx *= new_speed / hypot;
                	ball.vely *= new_speed / hypot;
                	
                
                }
            
                if (!three.isEmpty())
                {
                	ball.size= Integer.parseInt(three);
                	
                }                
            }         
        }
         // class ColorButtonHandler
        class ColorButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e) 
            {
            	ball.color = JColorChooser.showDialog(null, "Ball color", ball.color);
            }
        }
         //  class StrokeButtonHandler
        class StrokeButtonHandler implements ActionListener
        {
            public void actionPerformed(ActionEvent e) 
            {
            	ball.strokeColor = JColorChooser.showDialog(null, "Ball color", ball.strokeColor);
            }
        }
        //  class ButtonListener
        class ButtonListener implements ActionListener {
        	boolean shouldMove;
        	
        	ButtonListener(boolean shouldMove_)
        	{
        		shouldMove = shouldMove_;
        	}
        	// method actionPerformed
            public void actionPerformed(ActionEvent buttonPressed)
            {
            	ball.isMoving = shouldMove;
            }
            
        }
        
        BallControlPanel(Ball ball_)
    	{
            super();
            
            ball = ball_;
             // create button start and stop 
            JButton moveButton = new JButton();
            moveButton.setText("Start");
            moveButton.addActionListener(new ButtonListener(true));
            add(moveButton);
            JButton stopButton = new JButton();
            stopButton.setText("Stop");
            stopButton.addActionListener(new ButtonListener(false));
            add(stopButton);

            JLabel name;  // variable for name
            name = new JLabel("velocity of Ball: ");
            add(name);
            velocity = new JTextField (2);
            add(velocity);
            
            // radius for ball
            name = new JLabel("Radius for Ball: ");
            add(name);
            radius = new JTextField (2);
            add(radius);
            JButton sizesButton= new JButton("Go");
            add(sizesButton);
            // button handler
            sizesButton.addActionListener(new Handler());        		
               
            JButton colorButton = new JButton("Fill");
            colorButton.addActionListener(new ColorButtonHandler());
            add(colorButton);

            JButton strokeButton = new JButton("Stroke");
            strokeButton.addActionListener(new StrokeButtonHandler());
            add(strokeButton);
    	}
    }
    
    Ball ball1, ball2;
            
    BallPanel ballPanel = new BallPanel();
             // class BallPanel
    class BallPanel extends JPanel
    {
    	BallPanel()
    	{
            repaint();
    	}
    	// method paintComponen
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            
            // Draw each ball
            ball1.draw(g);
            ball2.draw(g);
                        
            timer.start();
        }        	
    }
    
    public Projectone()
    {
    	JPanel buttonPanel = new JPanel();  // creating panel for the buttons and the textboxes
    	buttonPanel.setBorder(BorderFactory.createLineBorder(Color.black));  // reating boarder for the panel
    	///  Adding components    
        ball1 = new Ball();
        ball2 = new Ball();
        
        // Initialize balls
        ball1.x = 25;
        ball1.y = 0;
        ball1.velx = 6;
        ball1.vely = 6;
        ball1.color = Color.GREEN;
        ball1.strokeColor = Color.ORANGE;

        ball2.x = 200;
        ball2.y = 100;
        ball2.velx = 26;
        ball2.vely = 8;
        ball2.color = Color.blue;
        ball1.strokeColor = Color.BLACK;
                                            
        this.add(ballPanel);
        add(new BallControlPanel(ball1), BorderLayout.NORTH);
        add(new BallControlPanel(ball2), BorderLayout.SOUTH);
    }
     // mathod actionPerformed
    public void actionPerformed(ActionEvent e)
    {
        int dx = ball2.x - ball1.x, dy = ball2.y - ball1.y;
        int r = (ball1.size + ball2.size) / 2;
        
        // This bounce algorithm is terrible! It ignores proper physics totally.
        if(Math.abs(dx) < r && Math.abs(dy) < r)
        {
        	if(Math.abs(dx) < r)
        	{
        		ball1.velx = -ball1.velx;
        		ball2.velx = -ball2.velx;
        	}

        	if(Math.abs(dy) < r)
        	{
        		ball1.vely = -ball1.vely;
        		ball2.vely = -ball2.vely;
        	}
        }
          
        ball1.step();
    	ball2.step();
        ballPanel.repaint();
        
        int x = ballPanel.getHeight();
        x = ballPanel.getWidth();
        x = ballPanel.getX();
    }
    
     // main method
	public static void main(String[] args)
	{
	    Projectone p = new Projectone();
	   
	    p.setTitle("ProjectOne");
	    p.setSize(800, 700);
	    p.setVisible(true);
	    p.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	} // end of main method

}  // end of ProjectOne
