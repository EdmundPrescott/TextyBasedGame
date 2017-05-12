import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Screen{

	private static JTextArea screenContents;
	private static JFrame frame;
	private static JPanel userPanel;
	private static JPanel screen;
	private static int FrameX;
	private static int FrameY;
	private static char[][] board = { 
	    	new char[] { '@', '@', ' ', '@', '@', '@', '@', '@' },
	        new char[] { '@', '@', ' ', ' ', '@', '@', '@', '@' },
	        new char[] { '@', '@', 'T', ' ', '@', '@', '@', '@' },
	        new char[] { '@', '@', 'I', ' ', '@', '@', '@', '@' },
	        new char[] { '@', '@', ' ', ' ', ' ', '@', '@', '@' },
	        new char[] { '@', ' ', ' ', ' ', ' ', '@', '@', '@' },
	        new char[] { '@', 'p', '@', '@', '@', '@', '@', '@' } 
	    	};
	
	
	public Screen(int frameX,int frameY){
		FrameX=frameX;
		FrameY=frameY;
		
		newscreenContents();
		newScreen();
		newuserPanel();
        newFrame();
        frame.show();
	}
	
	
	public static void setBoard(char[][] newBoard){
		board=newBoard;
	}
	
	public static char[][] getBoard(){
		return board;
	}
	
    @SuppressWarnings("unused")
	private static void printBoard(){
    	for (int i = 0; i < board.length; i++) {
            System.out.print((i+1)+". ");
            char[] line = board[i];
            for (int j = 0; j < line.length; j++) {
            	System.out.print(line[j]);
            }
            System.out.println();
        }
    	System.out.println();
    }
    
    private static String toBoardString() { 
        String boardString = "";
        for (int i = 0; i < board.length; i++) {
            char[] line = board[i];
            for (int j = 0; j < line.length; j++) {
                boardString += line[j];
            }
            boardString += "\n";
        }
        return boardString;
    }
    
  	private static void newscreenContents(){
  		screenContents = new JTextArea(toBoardString());
  		screenContents.setFont(new Font("Courier", Font.PLAIN, 12));
  		screenContents.setBackground(Color.BLACK);
  		screenContents.setForeground(Color.CYAN);
  		screenContents.setEditable(false);
  		screenContents.setFocusable(false);//Possibly open to change
  	}
  	
  	private static void newFrame(){
  		frame = new JFrame();
  		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(FrameX,FrameY));
        frame.setResizable(false);//Possibly will keep this the same or make it a option in a options menu
        frame.setLocationRelativeTo(null);//I forget what this does but it's part of the working build so :/
        frame.setFocusable(true);
        frame.addKeyListener(new KeyListener() {

              @Override
              public void keyTyped(KeyEvent e) {}

              @Override
              public void keyReleased(KeyEvent e) {}

              @Override
              public void keyPressed(KeyEvent e) {
                  System.out.println("Pressed " + e.getKeyChar());
                  int code = e.getKeyCode();
                  if(code==KeyEvent.VK_1){
                	  board[5] = new char[] { 'b', 'o', 'o', 'B', '@', '@', '@', '@' };
                	  updateFrame();
                  }
                  
                  if(code==KeyEvent.VK_2){
                	  board[5] = new char[] { 'b', 'o', 'o', 'B', 'i', 'e', 's', '@' };
                	  updateFrame();
                  }
                  
              }
          });
          frame.add(screen);
          frame.add(userPanel);
          screen.setLocation(0,0);
          userPanel.setLocation(0,FrameY/2+FrameY/2/2);
  	}
  	
  	private static void newScreen(){
  		screen = new JPanel();
  		screen.setSize(new Dimension(FrameX,FrameY/2+FrameY/2/2));
  		screen.setLayout(new BorderLayout());
        screen.setBackground(Color.RED);
        screen.setFocusable(false);//Possibly open to change
        screen.add(screenContents);
  	}
  	
  	private static void newuserPanel(){
  		  userPanel = new JPanel();
          userPanel.setFocusable(false);
          userPanel.setSize(new Dimension(FrameX,FrameY/4));
          userPanel.setBackground(Color.BLUE);
  	}
    
    static void resizedScreen(int frameX,int frameY){
    	frame.setSize(new Dimension(frameX, frameY));
    	
    }

    static void updateFrame(){
    	newscreenContents();
    	newScreen();
    	frame.add(screen);
        frame.add(userPanel);
        frame.show();
    }
    
    static void example(){
    	board[5] = new char[] { 'b', 'o', 'o', 'B', '@', '@', '@', '@' };
    	updateFrame();
    }
	
}
