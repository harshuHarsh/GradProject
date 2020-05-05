package Connect4;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Connect4 
{
  
    private static JFrame frame;                  
    public static JPanel panel;                   
    public static JButton[][] buttons;                            
    private static GridLayout grid;               
    public static ImageIcon empty ;
    public static ImageIcon player1 ;
    public static ImageIcon player2 ;
	
    
    public static void main(String[] args)
    {
    	new Connect4();
    	
    }
    public  Connect4() 
    {
    	
		try 
		{
	        empty = new ImageIcon(getClass().getResource("/Connect4/empty.png"));
	        player1 = new ImageIcon(getClass().getResource("/Connect4/player1.png"));
	        player2 = new ImageIcon(getClass().getResource("/Connect4/player2.png"));
	    	frame = new JFrame();
	        panel = new JPanel();	    
	        Board.playerNumberAndBoardSize();  
	        Board.createBoard();   
	        buttons = new JButton[Board.getBoardSize()][Board.getBoardSize()];    
	        grid = new GridLayout(Board.getBoardSize(),Board.getBoardSize());       
	        panel.setLayout(grid); 
	        Board.createButtons(); 	
	        frame.setContentPane(panel);
	        frame.pack();                 
	        frame.setLocationRelativeTo(null); 
	        frame.setVisible(true);      
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		}
	    catch(Exception e)
		{	    	
	    	e.printStackTrace();
	    }

    }
    public  static void addButtonsToBoard( ) 
    {
		for (int i = 0; i < Board.getBoardSize(); ++i)
		{
			for (int j = 0; j < Board.getBoardSize(); ++j) 
			{ 
				buttons[i][j] = new JButton(empty); 
				buttons[i][j].setBackground(Color.LIGHT_GRAY);
				buttons[i][j].setFocusPainted(false);
					
				if (Board.numberOfPlayer == 1) 
				{
					
					 buttons[i][j].addActionListener(new ListenerButtonOnePlayer());

					
					 
				}
				
				 if(Board.numberOfPlayer==2)   
	             {
	                    buttons[i][j].addActionListener(new ListenerButtonTwoPlayer());
	             }

				panel.add(buttons[i][j]);
			}
		}
	}
}
