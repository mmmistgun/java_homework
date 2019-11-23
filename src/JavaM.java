import java.util.Random;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;



public class JavaM extends Frame {
	Random randomNumber = new Random(1);
	int SquareLength = 10;
	
	Glass glass1 = new Glass(randomNumber, SquareLength);
	Sheep sheep1 = new Sheep(randomNumber, SquareLength);
	Bird bird1 = new Bird(randomNumber, SquareLength);
	
	
	Label firstCreature = new Label("unkown");
	Label secondCreature = new Label("unkown");
	Label thirdCreature = new Label("unkown");
	
	Label firstCreatureNumber = new Label("number: 1");
	
	Label firstCreaturePositionX = new Label("X: unkown");
	Label secondCreaturePositionX = new Label("X: unkown");
	Label thirdCreaturePositionX = new Label("X: unkown");
	
	Label firstCreaturePositionY = new Label("Y: unkown");
	Label secondCreaturePositionY = new Label("Y: unkown");
	Label thirdCreaturePositionY = new Label("Y: unkown");
	
	Button btnGlassGrow = new Button("Grow");
	Button btndirection = new Button("direction 1");

	Button btnSheepMoveX = new Button("MoveX");
	Button btnBirdMoveX = new Button("MoveX");
	
	Button btnSheepMoveY = new Button("MoveY");
	Button btnBirdMoveY = new Button("MoveY");
	
	Button btnSheepEatGlass = new Button("EatGlass");
	Button btnBirdEatGlass = new Button("EatGlass");
	
	GridBagConstraints gridBag = new GridBagConstraints();
	
	public static void main(String[] args)
	{
		new JavaM();
	}
	
	public JavaM() 
	{
		
		setLayout(new GridBagLayout());

		gridBag.fill = GridBagConstraints.BOTH;
		gridBag.weightx = 0;
		gridBag.weighty = 0;
		addToBag(firstCreature,gridBag,0,0,1,1);
		addToBag(secondCreature,gridBag,1,0,1,1);
		addToBag(thirdCreature,gridBag,2,0,1,1);
		
		addToBag(firstCreatureNumber,gridBag,0,1,1,1);
		
		addToBag(firstCreaturePositionX,gridBag,0,2,1,1);
		addToBag(secondCreaturePositionX,gridBag,1,2,1,1);
		addToBag(thirdCreaturePositionX,gridBag,2,2,1,1);
		
		addToBag(firstCreaturePositionY,gridBag,0,3,1,1);
		addToBag(secondCreaturePositionY,gridBag,1,3,1,1);
		addToBag(thirdCreaturePositionY,gridBag,2,3,1,1);
		
		addToBag(btnGlassGrow,gridBag,0,4,1,1);
		addToBag(btndirection,gridBag,1,1,1,1);
		
		addToBag(btnSheepMoveX,gridBag,1,4,1,1);
		addToBag(btnBirdMoveX,gridBag,2,4,1,1);
		
		addToBag(btnSheepMoveY,gridBag,1,5,1,1);
		addToBag(btnBirdMoveY,gridBag,2,5,1,1);
		
		addToBag(btnSheepEatGlass,gridBag,1,6,1,1);
		addToBag(btnBirdEatGlass,gridBag,2,6,1,1);
		
		firstCreature.setText(glass1.getName());
		secondCreature.setText(sheep1.getName());
		thirdCreature.setText(bird1.getName());
		
		firstCreaturePositionX.setText("X: " + glass1.position.getPosition_x());
		firstCreaturePositionY.setText("Y: " + glass1.position.getPosition_y());

		secondCreaturePositionX.setText("X: " + sheep1.position.getPosition_x());
		secondCreaturePositionY.setText("Y: " + sheep1.position.getPosition_y());

		thirdCreaturePositionX.setText("X: " + bird1.position.getPosition_x());
		thirdCreaturePositionY.setText("Y: " + bird1.position.getPosition_y());
		
		btnGlassGrow.addActionListener(new GlassGrow());
		
		btnSheepMoveX.addActionListener(new SheepMoveX());
		btnSheepMoveY.addActionListener(new SheepMoveY());
		btnSheepEatGlass.addActionListener(new SheepEatGlass());
		btndirection.addActionListener(new SheepChangeDirection());
		
		btnBirdMoveX.addActionListener(new BirdMoveX());
		btnBirdMoveY.addActionListener(new BirdMoveY());
		btnBirdEatGlass.addActionListener(new BirdEatGlass());
		
		setSize(300,300);
		setVisible(true);
		
	}

	void addToBag(Component c, GridBagConstraints gbc, int x, int y, int w, int h)
	{
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = h;
		gbc.gridwidth = w;
		add(c,gbc);
	}
	
	class GlassGrow implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			glass1.Grow();
			firstCreatureNumber.setText("number: " + glass1.getNumber());
		}
	}
	
	class SheepMoveX implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			sheep1.move_x();
			secondCreaturePositionX.setText("X: " + sheep1.position.getPosition_x());
		}
	}
	
	class SheepMoveY implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			sheep1.move_y();
			secondCreaturePositionY.setText("Y: " + sheep1.position.getPosition_y());
		}
	}
	
	class SheepChangeDirection implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			sheep1.changeDirection();
			btndirection.setLabel("direction " + sheep1.direction);
		}
	}
	
	class SheepEatGlass implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			sheep1.eatGlass(glass1);
			firstCreatureNumber.setText("number: " + glass1.getNumber());
		}
	}
	
	class BirdMoveX implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			bird1.move_x();
			thirdCreaturePositionX.setText("X: " + bird1.position.getPosition_x());
		}
	}
	
	class BirdMoveY implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			bird1.move_y();
			thirdCreaturePositionY.setText("Y: " + bird1.position.getPosition_y());
		}
	}
	
	class BirdEatGlass implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			bird1.eatGlass(glass1);
			firstCreatureNumber.setText("number: " + glass1.getNumber());
		}
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
		String str = (String) JOptionPane.showInputDialog(null, "please input your glass name£º\n", "name:", JOptionPane.PLAIN_MESSAGE, null, null,
                "glass");
		if(str == null)
		{
			str = "glass";
		}
		this.setName(str);
		
		this.position.setPosition_x(r.nextInt(length));
		this.position.setPosition_y(r.nextInt(length));
	}
	
	private int number = 1;
	
	int getNumber()
	{
		return this.number;
	}
	
	void Grow()
	{
		this.number += 1;
	}
	
	void eatBySheep()
	{
		this.number--;
		System.out.println(this.getName() + ": I eated by a sheep!");
	}
	
	void eatByBird()
	{
		this.number --;
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
		String str = (String) JOptionPane.showInputDialog(null, "please input your sheep name£º\n", "name:", JOptionPane.PLAIN_MESSAGE, null, null,
                "sheep");
		if(str == null)
		{
			str = "sheep";
		}
		this.setName(str);
		this.position.setPosition_x(r.nextInt(length));
		this.position.setPosition_y(r.nextInt(length));
	}
	
	Wool wool = new Wool();
	
	int direction = 1;
	
	public void changeDirection()
	{
		direction *= -1;
	}
	
	public void move_x()
	{
		int MyPositionX = this.position.getPosition_x();
		this.position.setPosition_x(MyPositionX + 1 * direction);
	}
	
	public void move_y()
	{
		int MyPositionY = this.position.getPosition_y();
		this.position.setPosition_y(MyPositionY + 1 * direction);
		
	}
	
	public void eatGlass(Glass glass)
	{
		if(this.position.getPosition_x() == glass.position.getPosition_x() 
				&& this.position.getPosition_y() == glass.position.getPosition_y()
				&& glass.getNumber() > 0)
		{
			System.out.println(this.getName() + ": I eat a glass!");
			glass.eatBySheep();
		}
		else
		{
			System.out.println(this.getName() + " : There is no grass here!");
		}
	}
}

class Bird extends Creature implements Movement
{
	Bird(Random r, int length)
	{
		String str = (String) JOptionPane.showInputDialog(null, "please input your bird name£º\n", "name:", JOptionPane.PLAIN_MESSAGE, null, null,
                "bird");
		if(str == null)
		{
			str = "bird";
		}
		this.setName(str);
		this.position.setPosition_x(r.nextInt(length));
		this.position.setPosition_y(r.nextInt(length));
	}
	
	public void move_x()
	{
        String str = (String) JOptionPane.showInputDialog(null, "please input new x£º\n", "x", JOptionPane.PLAIN_MESSAGE, null, null,
                this.position.getPosition_x());
        if(str== null)
        {
        	str = ""+ this.position.getPosition_x();
        }
		this.position.setPosition_x(Integer.parseInt(str));
	}
	
	public void move_y()
	{
        String str = (String) JOptionPane.showInputDialog(null, "please input new y£º\n", "y", JOptionPane.PLAIN_MESSAGE, null, null,
                this.position.getPosition_y());
        if(str== null)
        {
        	str = ""+ this.position.getPosition_y();
        }
		this.position.setPosition_y(Integer.parseInt(str));

	}
	
	public void eatGlass(Glass glass)
	{
		if(this.position.getPosition_x() == glass.position.getPosition_x() 
				&& this.position.getPosition_y() == glass.position.getPosition_y()
				&& glass.getNumber() > 0)
		{
			System.out.println(this.getName() + ": I eat a glass!");
			glass.eatByBird();
		}
		else
		{
			System.out.println(this.getName() + " : There is no grass here!");
		}
	}
}

