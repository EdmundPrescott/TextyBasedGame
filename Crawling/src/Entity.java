public class Entity {

	private int Xcordinate;
	private int Ycordinate;
	
	private String Name;
	private char Icon;
	private int Health;
	private int Attack;
	
	private boolean passable = true;
	private boolean enemy = false;
	private boolean interactable = false;
	private boolean event = false;
	private boolean visible = false;
	
	
	public Entity(char icon,int Xcord,int Ycord){
		switch(icon){
		case'#':
			Name="Wall";
			Icon=icon;
			passable=false;
			event=true;
			Xcordinate=Xcord;
			Ycordinate=Ycord;
			break;
		case'@':
			Name="Player";
			Icon=icon;
			Health=6;
			Attack=2;
			Xcordinate=Xcord;
			Ycordinate=Ycord;
			break;
		case'S':
			Name="Snake";
			Icon=icon;
			passable=false;
			enemy=true;
			event=true;
			Health=3;
			Attack=2;
			Xcordinate=Xcord;
			Ycordinate=Ycord;
			break;
		case'$':
			Name="Chest";
			Icon=icon;
			passable=false;
			interactable=true;
			Xcordinate=Xcord;
			Ycordinate=Ycord;
			break;
		case'.':
			Name="Empty";
			Icon='.';
			interactable=false;
			event = true;
			Xcordinate=Xcord;
			Ycordinate=Ycord;
			break;
		default:
			Icon='!';
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
	
	public char getIcon(){
		return Icon;
	}
	
	public void passableTrue(){
		passable=true;
	}
	
	public void passableFalse(){
		passable=false;
	}
	
	public boolean isPassable(){
		return passable;
	}
	
	public void enemyTrue(){
		enemy=true;
	}
	
	public void enemyFalse(){
		enemy=false;
	}
	
	public boolean isEnemy(){
		return enemy;
	}
	
	public void interactableTrue(){
		interactable=true;
	}
	
	public void interactableFalse(){
		interactable=false;
	}
	
	public boolean isInteractable(){
		return interactable;
	}
	
	public void setHealth(int x){
		Health=x;
	}
	
	public int getHealth(){
		return Health;
	}
	
	public void setAttack(int x){
		Attack=x;
	}
	
	public int getAttack(){
		return Attack;
	}
	
	public boolean isVisible(){
		return visible;
	}
	
	public void visibleFalse(){
		visible=false;
	}
	
	public void visibleTrue(){
		visible=true;
	}
	
	public boolean getEvent(){
		return event;
	}
	
	public void printEntityDetails(){
	   System.out.println(
		"Name: "+Name+"\n"
	   +"Icon: "+Icon+"\n"
	   +"Xcord: "+Xcordinate+"\n"
	   +"Ycord: "+Ycordinate+"\n"
	   +"Health: "+Health+"\n"
	   +"Attack: "+Attack+"\n"
	   +"Passable: "+passable+"\n"
	   +"Enemy: "+enemy+"\n"
	   +"Interactable: "+interactable+"\n"
	   //+": "++"\n"
	   );
		
	}
}