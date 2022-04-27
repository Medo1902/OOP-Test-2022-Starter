package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;

public class NematodeVisualiser extends PApplet
{

	ArrayList<Nematode> nematodes = new ArrayList<Nematode>();

	public int j;

	public void keyPressed()
	{		
		if (keyCode == RIGHT)
		{
			j++;
			nematodes.get(j);
		}		
	}


	public void settings()
	{
		size(800, 800);
	}

	public void setup() 
	{
		colorMode(HSB);
		background(0);
		smooth();	
		loadNematodes();			
	}
	

	public void loadNematodes()
	{
		Table table = loadTable("nematodes.csv", "header");
		for(TableRow r:table.rows())
		{
			Nematode n = new Nematode(r);
			nematodes.add(n);
		}
	}

	public void drawNematodes()
    {
        for(Nematode n:nematodes)
        {
            n.render(this);
        }

    }


	public void draw()
	{	
		drawNematodes();
	}
}