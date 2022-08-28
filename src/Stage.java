import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;







public class Stage {
    Grid grid;
    List<Actor> actors;
    Actor cat;
    Actor dog;
    Actor bird;
    public Stage(){
        grid= new Grid();
   actors = new ArrayList<Actor>();
    }
public void paint(Graphics g, Point mouseLoc){
    grid.paint(g,mouseLoc);
    for(Actor a: actors){
        a.paint(g);
    }
    Optional<Cell> underMouse=grid.cellAtPoint(mouseLoc); 
    if(underMouse.isPresent()){
        Cell hoverCell = underMouse.get();
        g.setColor(Color.DARK_GRAY);
       String hoverString = String.valueOf(hoverCell.col) + " " +String.valueOf(hoverCell.y);
       g.drawString(hoverString,740,30);
    }
   
}
    
}
