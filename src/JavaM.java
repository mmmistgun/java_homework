import java.util.Random;
public class JavaM {
	public static void main(String[] args)
	{
		Random randomNumber = new Random(1);
		int SquareLength = 10;
		
		Sheep sheep1 = new Sheep(randomNumber, SquareLength);
		Bird bird1 = new Bird(randomNumber, SquareLength);
		Glass glass1 = new Glass(randomNumber, SquareLength);
		
		System.out.println(bird1.position.getPosition_x());
		
		System.out.println(sheep1.position.getPosition_x());
		System.out.println(sheep1.position.getPosition_y());
		
		System.out.println(sheep1.getName());
		System.out.println(bird1.getName());
		
		bird1.eatGlass(glass1);
		sheep1.eatGlass(glass1);
	}
}

class Creature
{
	private String name;
	public Position position = new Position();
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
}

class Position
{
	private int x = 0;
	private int y = 0;
	
	public int getPosition_x()
	{
		return this.x;
	}
	
	public int getPosition_y()
	{
		return this.y;
	}
	
	public void setPosition_x(int x)
	{
		this.x = x;
	}
	
	public void setPosition_y(int y)
	{
		this.y = y;
	}
}

interface Movement
{
	void move_x();
	void move_y();
}

class Glass extends Creature
{
	Glass(Random r, int length)
	{
		this.setName("glass");
		this.position.setPosition_x(r.nextInt(length));
		this.position.setPosition_y(r.nextInt(length));
	}
	
	private int number = 0;
	
	int getNumber()
	{
		return this.number;
	}
	
	void setNumber(int number)
	{
		this.number = number;
	}
	
	void eatBySheep()
	{
		System.out.println(this.getName() + ": I eated by a sheep!");
	}
	
	void eatByBird()
	{
		System.out.println(this.getName() + ": I eated by a bird!");
	}
}

class Wool
{
	public String color = "white";
	private int weight = 1;
	
	public String getColor()
	{
		return this.color;
	}
	
	public void setColor(String color)
	{
		this.color = color;
	}
	
	public int getWeight()
	{
		return this.weight;
	}
	
	public void setWeight(int weight)
	{
		this.weight = weight;
	}
}

class Sheep extends Creature implements Movement
{
	Sheep(Random r, int length)
	{
		this.setName("sheep");
		this.position.setPosition_x(r.nextInt(length));
		this.position.setPosition_y(r.nextInt(length));
	}
	
	Wool wool = new Wool();
	
	public void move_x()
	{
		int MyPositionX = this.position.getPosition_x();
		this.position.setPosition_x(MyPositionX + 1);
	}
	
	public void move_y()
	{
		int MyPositionY = this.position.getPosition_y();
		this.position.setPosition_x(MyPositionY + 1);
	}
	
	public void eatGlass(Glass glass)
	{
		System.out.println(this.getName() + ": I eat a glass!");
		glass.eatBySheep();
	}
}

class Bird extends Creature implements Movement
{
	Bird(Random r, int length)
	{
		this.setName("bird");
		this.position.setPosition_x(r.nextInt(length));
		this.position.setPosition_y(r.nextInt(length));
	}
	
	public void move_x()
	{
		int MyPositionX = this.position.getPosition_x();
		this.position.setPosition_x(MyPositionX + 2);
	}
	
	public void move_y()
	{
		int MyPositionY = this.position.getPosition_y();
		this.position.setPosition_x(MyPositionY + 2);
	}
	
	public void eatGlass(Glass glass)
	{
		if(this.position.getPosition_x() == glass.position.getPosition_x() 
				&& this.position.getPosition_y() == glass.position.getPosition_y())
		{
			System.out.println(this.getName() + ": I eat a glass!");
			glass.eatByBird();
		}
		else
		{
			System.out.println("There is no grass here!");
		}
	}
	
}
