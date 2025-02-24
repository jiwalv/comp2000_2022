// Main.java

import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;




public class Main extends JFrame {

public static void main(String[] args) throws Exception {
    Main window= new Main();
    window.run();


}
class Canvas extends JPanel{
    Stage stage;
   // Stage stage= new Stage();
    public Canvas(){
        setPreferredSize(new Dimension(1024 , 720));
        try{
        stage = StageReader.readStage("data/stage1.rvb");
        } catch(Exception e){
            System.out.println("Couldn't read stage file");
            System.exit(1);
        }
    }
    @Override  
    public void paint(Graphics g){ 
     stage.paint(g,getMousePosition());
    }

}
private Main(){
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Canvas canvas = new Canvas();
            this.setContentPane(canvas);
            this.pack();
            this.setVisible(true);


    }
    public void run(){
        while(true)
        repaint();
        }
    }
    




