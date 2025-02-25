package ie.tudublin;

import processing.core.PApplet;
import processing.data.TableRow;

public class Nematode {
    private String name;
    private int length;
    private boolean limbs;
    private String gender;
    private boolean eyes;

    public Nematode(TableRow tr)
    {
        this(tr.getString("name"), 
            tr.getInt("length"), 
            tr.getInt("limbs") == 1, 
            tr.getString("gender"), 
            tr.getInt("eyes") == 1);
    }
    @Override
    public String toString() {
        return "Nematode [eyes=" + eyes + ", gender=" + gender + ", length=" + length + ", limbs=" + limbs + ", name="
                + name + "]";
    }
    public Nematode(String name, int length, boolean limbs, String gender, boolean eyes) {
        this.name = name;
        this.length = length;
        this.limbs = limbs;
        this.gender = gender;
        this.eyes = eyes;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public boolean isLimbs() {
        return limbs;
    }
    public void setLimbs(boolean limbs) {
        this.limbs = limbs;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public boolean isEyes() {
        return eyes;
    }
    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }

    public void render(NematodeVisualiser pa){

        float x = pa.height / 2;
        float y = pa.width - 200;

        //Print the name of the nematode
        pa.text(name, x - 50 , y - 500);

        for(int i = 0; i < length ; i++)
        {
            pa.stroke(255);
            pa.noFill();
            pa.circle(x,y,50);

            
                if(gender == "f")
                {
                    pa.stroke(255);
                    pa.noFill();
                    pa.circle(x,y, 30);
                }
            
            if (isLimbs())
            {
                pa.line(x - 25, y, x - 50, y);
                pa.line(x + 25, y, x + 50, y);
            }

            if(isEyes())
            {
    
            }
            y = y - 50;
        }
    }
    
}