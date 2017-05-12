
public class Entity {

	private int Xcordinate;
	private int Ycordinate;
	
	private String Name;
	private char Icon;
	
	private boolean passable = true;
	private boolean enemy = false;
	private boolean interactable = false;
	
	public Entity(char Icon,int Xcord,int Ycord){
		switch(Icon){
		case'#':
			Name="Wall";
			Icon='#';
			passable=false;
			Xcordinate=Xcord;
			Ycordinate=Ycord;
			break;
		case'@':
			Name="Player";
			Icon='@';
			Xcordinate=Xcord;
			Ycordinate=Ycord;
			break;
		case'S':
			Name="Snake";
			Icon='S';
			passable=false;
			enemy=true;
			Xcordinate=Xcord;
			Ycordinate=Ycord;
			break;
		case'$':
			Name="Chest";
			Icon='#';
			passable=false;
			Xcordinate=Xcord;
			Ycordinate=Ycord;
			break;
			
			
		}
	}
	
	public void setXcord(int Xcord){
		Xcordinate = Xcord;
	}
	
	public void setYcord(int Ycord){
		Ycordinate = Ycord;
	}
	
	public int getXcord(){
		return Xcordinate;
	}
	
	public int getYcord(){
		return Ycordinate;
	}
	
	public String getName(){
		return Name;
	}
	
	/*
	public char autoGeneratedIcon(){
		if(Name.length()>0){
			return Name.charAt(0);
		}else 
		if(customIcon==' '){
			return customIcon;
		}else{
			System.out.println("Error could not find a Icon");
			return '!';
		}
			
	}
	*/
	
	public char getIcon(){
		return Icon;
	}
	
	public void becomesPassable(){
		passable=true;
	}
	
	public void becomesImpassable(){
		passable=false;
	}
	
	public boolean isPassable(){
		return passable;
	}
	
	public void becomesEnemy(){
		enemy=true;
	}
	
	public void becomesNonEnemy(){
		enemy=false;
	}
	
	public boolean isEnemy(){
		return enemy;
	}
	
	
	
}
