//import java.util.Random;
public class JavaM {
	public static void main(String[] args)
	{
		Sheep sheep1 = new JavaM().new Sheep();
		Bird bird1 = new JavaM().new Bird();
		Glass glass1 = new JavaM().new Glass();
		System.out.println(sheep1.getName());
		System.out.println(bird1.getName());
		bird1.eatGlass(glass1);
		sheep1.eatGlass(glass1);
	}
	
	public class Creature
	{
		private String name;
		public Position position;
		
		public String getName()
		{
			return this.name;
		}
		
		public void setName(String name)
		{
			this.name = name;
		}
	}
	
	public class Position
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
	
	public class Glass extends Creature
	{
		Glass()
		{
			this.setName("glass");
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
	
	public class Wool
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
	
	public class Sheep extends Creature implements Movement
	{
		Sheep()
		{
			this.setName("sheep");
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

	public class Bird extends Creature implements Movement
	{
		Bird()
		{
			this.setName("bird");
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
			System.out.println(this.getName() + ": I eat a glass!");
			glass.eatByBird();
		}
		
	}
}
