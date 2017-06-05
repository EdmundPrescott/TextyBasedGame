public class Board {
	
	private static int Xcordinate=0;
	private static int Ycordinate=0;
	private static Entity[][] board;
	private static char[][] textBoard;
	
	
	public Board(int x,int y){
		System.out.println(x*y+" randomly generated numbers");
		generateBoard(x,y);
		printBoard();
	}	
	
	public static void printBoard(){
		for(int i=0;i<board[i].length;i++){
			for(int j=0;j<board.length;j++){
				System.out.print(board[j][i].getIcon());
			}
			System.out.println();
		}
	}
	
	public static void printBoardStupidly(){
		for(int i=0;i<board[i].length;i++){
			for(int j=0;j<board.length;j++){
				System.out.print(board[j][i].getName());
			}
			System.out.println();
		}
	}
	
	public static char[][] getBoard(){
		System.out.println("Bloop");
		return textBoard;
	}

	public static void generateBoard(int x, int y){
		board=new Entity[x][y];
		textBoard=new char[x][y];
		for(int i=0;i<y;i++){
			for(int j=0;j<x;j++){
				//System.out.println("X: "+j+" Y: "+i);
				int random=(int) (Math.random()*100)+1;
				if(random<91){
					board[j][i]=new Entity('.',j,i);
					textBoard[j][i]=board[j][i].getIcon();
				}
				
				if(random<96&&random>90){
					board[j][i]=new Entity('#',x,y);
					textBoard[j][i]=board[j][i].getIcon();
				}
				
				if(random>95){
					board[j][i]=new Entity('S',x,y);
					textBoard[j][i]=board[j][i].getIcon();
				}
		}}
		
		board[x/2][y/2]= new Entity('@',x/2,y/2);
		Xcordinate=x/2;Ycordinate=y/2;
		textBoard[x/2][y/2]=board[x/2][y/2].getIcon();
		
	}
	
	public static void movePlayer(char direction){
		switch(direction){
		case'w':
			if(Ycordinate-1>=0)
			if(board[Xcordinate][Ycordinate-1].isPassable()==true){
				textBoard[Xcordinate][Ycordinate-1]=textBoard[Xcordinate][Ycordinate];
				textBoard[Xcordinate][Ycordinate]='.';
				board[Xcordinate][Ycordinate-1]=board[Xcordinate][Ycordinate];
				board[Xcordinate][Ycordinate]=new Entity('.',Xcordinate,Ycordinate);
				Ycordinate-=1;
				System.out.println("><>o");
			}
			break;
		case'a':
			if(Xcordinate-1>=0){
			if(board[Xcordinate-1][Ycordinate].isPassable()==true){
				textBoard[Xcordinate-1][Ycordinate]=textBoard[Xcordinate][Ycordinate];
				textBoard[Xcordinate][Ycordinate]='.';
				board[Xcordinate-1][Ycordinate]=board[Xcordinate][Ycordinate];
				board[Xcordinate][Ycordinate]=new Entity('.',Xcordinate,Ycordinate);
				Xcordinate-=1;
				System.out.println("><>o");
			}
			}
			break;
		case's':
			if(Ycordinate+1<board[Xcordinate].length){
			if(board[Xcordinate][Ycordinate+1].isPassable()==true){
				textBoard[Xcordinate][Ycordinate+1]=textBoard[Xcordinate][Ycordinate];
				textBoard[Xcordinate][Ycordinate]='.';
				board[Xcordinate][Ycordinate+1]=board[Xcordinate][Ycordinate];
				board[Xcordinate][Ycordinate]=new Entity('.',Xcordinate,Ycordinate);
				Ycordinate+=1;
				System.out.println("><>o");
			}
			}
			break;
		case'd':
			if(Xcordinate+1<board.length){
			if(board[Xcordinate+1][Ycordinate].isPassable()==true){
				textBoard[Xcordinate+1][Ycordinate]=textBoard[Xcordinate][Ycordinate];
				textBoard[Xcordinate][Ycordinate]='.';
				board[Xcordinate+1][Ycordinate]=board[Xcordinate][Ycordinate];
				board[Xcordinate][Ycordinate]=new Entity('.',Xcordinate,Ycordinate);
				Xcordinate+=1;
				System.out.println("><>o");
			}
			}
			break;
		default:
			System.out.println("A invalid direction was entered");
			break;
		
		}
	}
	
}