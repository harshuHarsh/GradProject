package Connect4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


    public class ListenerButtonOnePlayer  implements ActionListener 
    {
    	
    	public static int playerTurn=0;
    	public static int countOfCells;
    	public static int winner=0;
    	CheckWin win=new CheckWin();
        @Override
        public void actionPerformed(ActionEvent e)
        {
        	
           
        	try { 
        		
        		
        		for(int i=Board.getBoardSize()-2; i>=0; --i)  
                {
                	
                    for(int j=0; j<=Board.getBoardSize()-1; j++)
                    {
                    	 
                        if(Connect4.buttons[i][j]== e.getSource())
                        {  
                            
	                       
                           if(playerTurn%2==0)   
                           { 
                        	   
                                for(int k=0; k<=Board.getBoardSize(); ++i)
                                {
                                    
                                    if(Board.gameBoard[i-k][j].getCoinState() == 0)
                                    {
                                    
                                       Connect4.buttons[i-k][j].setIcon(Connect4.player1);         
                                       Board.gameBoard[i-k][j].setCoinAndRowPosition('R', i);   
                                       Board.gameBoard[i-k][j].setCoinState(1);   
                                   
                                       ++countOfCells;   
                                       winner=1;
                                       win.checkforWinningPlayer(winner);   
                                     
                                       break; 
                                    } 
                                
                                }

                                setCostumeToEmpty(i,j); 
                                System.out.println("Player 1 played!!!");
                                ++playerTurn; 
                               
                                if(i==0 && Connect4.buttons[0][j]== e.getSource() )
                                {
                                	 moveComputer(i);
                                	 System.out.println("Computer played!!!");
                                	
                                     ++playerTurn; 
                                    
                                     break;
                                }
                              
                                break;    
                            }

                            
                            if( playerTurn%2 == 1) 
                            { 
                                moveComputer(i);
                                
                                System.out.println("Computer played!!!");
                                ++playerTurn; 
                                break;
                            }
                          
                        } 
                    }           
                } 
        		
        		
    		   
            } 
        	
        	
            catch(Exception ex)
            { 
            	System.out.println(ex.getMessage());
            	
            	
            }
        } 
              
       

        
        public void moveComputer(int rowPosition)
	    {
	        int l,m;
	        boolean flag=false;

	        for(l=Board.getBoardSize()-1; (l>=0)&& !flag; --l)
	        { 
	            for(m=0; (m<Board.getBoardSize()) && !flag; ++m)
	            {
	            	
	                if(Board.gameBoard[l][m].getCoinState() == 0)
	                {
	                	
	                	Connect4.buttons[l][m].setIcon(Connect4.player2);         
	                    Board.gameBoard[l][m].setCoinAndRowPosition('B', rowPosition); 
	                    winner=2;
	                    Board.gameBoard[l][m].setCoinState(winner);  
	                  
	                    ++countOfCells;
	                    
	                    win.checkforWinningPlayer(2); 
	                    
	                    flag = true;  
	                    setCostumeToEmpty(l,m);
	                }
	            }
	        } 
	    }
	    public void setCostumeToEmpty(int rowPos, int columnPos)
	    {
	        try 
	        {
	            Board.gameBoard[rowPos-1][columnPos].setCoinState(0);    
	        }   
	        catch (Exception ex) 
	        { }      
	    }
        
    } 


