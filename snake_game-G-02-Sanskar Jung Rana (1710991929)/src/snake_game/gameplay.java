package snake_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class gameplay extends JPanel implements KeyListener,ActionListener{
	
	
	//private static final long serialVersionUID = 1L;
	private ImageIcon titleImage;
	private int[] snakexlen = new int[750];
	private int[] snakeylen = new int[750];
	
	private boolean right=false;
	private boolean left=false;
	private boolean up=false;
	private boolean down=false;
	
	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;
	private ImageIcon snakeimage;
	
	private int[] enemyxpos = {25,50,75,100,125,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625,650,675,700,725,750,775,800,825,850};
	private int[] enemyypos= {75,100,125,150,150,175,200,225,250,275,300,325,350,375,400,425,450,475,500,525,550,575,600,625};
	
	private ImageIcon enemyimage;
	private Random random= new Random();
	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);
	
	private Timer timer;
	private int delay=100;
	
	private int lengthofsnake=3;
	private int moves=0;
	private int score = 0;
	public gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(true);
		timer=new Timer(delay,this);
		timer.start();
		
	}
	public void paint(Graphics g) {
		
		if(moves==0)
		{
			snakexlen[0]=100;
			snakexlen[1]=75;
			snakexlen[2]=50;
			
			snakeylen[0]=100;
			snakeylen[1]=100;
			snakeylen[2]=100;
		}
		
		//border of title image
		g.setColor(Color.white);
		g.drawRect(24,10,851,55);
		
		titleImage = new ImageIcon("snaketitle.png");
		titleImage.paintIcon(this, g, 25, 11);
		
		
		//border of gameplay
		g.setColor(Color.white);
		g.drawRect(24,74,851,577);
		g.setColor(Color.black);
		g.fillRect(25, 75, 850, 575);
		
		
		
		//draw the scroes
		g.setColor(Color.white);
		g.setFont(new Font("arial",Font.PLAIN,14));
		g.drawString("Scores : "+score, 780, 30);
		g.drawString("Scores : "+lengthofsnake, 780, 50);
		
		rightmouth=new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this,g,snakexlen[0],snakeylen[0]);
		
		for(int a=0;a<lengthofsnake;a++)
		{
			if(a==0 && right)
			{
				rightmouth=new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this,g,snakexlen[a],snakeylen[a]);
			}
			
			if(a==0 && left)
			{
				leftmouth=new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this,g,snakexlen[a],snakeylen[a]);
			}
			
			if(a==0 && up)
			{
				upmouth=new ImageIcon("upmouth.png");
				upmouth.paintIcon(this,g,snakexlen[a],snakeylen[a]);
			}
			
			if(a==0 && down)
			{
				downmouth=new ImageIcon("downmouth.png");
				downmouth.paintIcon(this,g,snakexlen[a],snakeylen[a]);
			}
			
			if(a!=0)
			{
				snakeimage=new ImageIcon("snakeimage.png");
				snakeimage.paintIcon(this,g,snakexlen[a],snakeylen[a]);		
			}
		}
		enemyimage = new ImageIcon("enemy.png");
		
		if(enemyxpos[xpos]==snakexlen[0] && enemyypos[ypos]==snakeylen[0])
		{
			lengthofsnake++;
			score++;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}
		enemyimage.paintIcon(this, g, enemyxpos[xpos], enemyypos[ypos]);
		
		for(int b=1;b<lengthofsnake;b++)
		{
			if(snakexlen[b]==snakexlen[0] && snakeylen[b]==snakeylen[0] )
			{
				right=false;
				left=false;
				up=false;
				down=false;
			
				g.setColor(Color.white);
				g.setFont(new Font("arial",Font.BOLD,50));
				g.drawString("GAME OVER!", 300, 300);
				
				g.setFont(new Font("arial",Font.BOLD,20));
				g.drawString("Press SPACE To restart", 350, 340);
				
			}
			
		}
		
		g.dispose();
	}
	
	public void actionPerformed(ActionEvent arg0)
	{
		if(right)
		{
			for(int i=lengthofsnake-1;i>=0;i--)
			{
				snakeylen[i+1]=snakeylen[i];
			}
			
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakexlen[i]=snakexlen[i]+25;
				}else
				{
					snakexlen[i]=snakexlen[i-1];
				}
				if(snakexlen[i]>850)
				{
					snakexlen[i]=25;
				}
			}
			repaint();
		}
		
		if(left)
		{
			for(int i=lengthofsnake-1;i>=0;i--)
			{
				snakeylen[i+1]=snakeylen[i];
			}
			
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakexlen[i]=snakexlen[i]-25;
				}else
				{
					snakexlen[i]=snakexlen[i-1];
				}
				if(snakexlen[i]<25)
				{
				snakexlen[i]=850;
				}
			}
			repaint();
		}
		
		if(up)
		{
			for(int i=lengthofsnake-1;i>=0;i--)
			{
				snakexlen[i+1]=snakexlen[i];
			}
			
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakeylen[i]=snakeylen[i]-25;
				}else
				{
					snakeylen[i]=snakeylen[i-1];
				}
				if(snakeylen[i]<75)
				{
					snakeylen[i]=625;
				}
			}
			repaint();
		}
		
		
		if(down)
		{
			for(int i=lengthofsnake-1;i>=0;i--)
			{
				snakexlen[i+1]=snakexlen[i];
			}
			
			for(int i=lengthofsnake;i>=0;i--)
			{
				if(i==0)
				{
					snakeylen[i]=snakeylen[i]+25;
				}else
				{
					snakeylen[i]=snakeylen[i-1];
				}
				if(snakeylen[i]>625)
				{
					snakeylen[i]=75;
				}
			}
			repaint();
		}
		
		
	}
	
	public void keyReleased(KeyEvent arg0)
	{
		
	}
	public void keyTyped(KeyEvent arg0)
	{
		
	}

	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT)
		{
			moves++;
			if(!left)
			{
				right=true;
			}else
			{
				right=false;
				left=true;
			}
			up=false;
			down=false;
		}
		
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT)
		{
			moves++;
			if(!right)
			{
				left=true;
			}else
			{
				left=false;
				right=true;
			}
			up=false;
			down=false;
		}
		
		
		if(e.getKeyCode()==KeyEvent.VK_UP)
		{
			moves++;
			if(!down)
			{
				up=true;
			}else
			{
				up=false;
				down=true;
			}
			right=false;
			left=false;
		}
		
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN)
		{
			moves++;
			if(!up)
			{
				down=true;
			}else
			{
				down=false;
				up=true;
			}
			right=false;
			left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_SPACE)
		{
			lengthofsnake=3;
			moves=0;
			score=0;
			repaint();
		}
		
	}
}
