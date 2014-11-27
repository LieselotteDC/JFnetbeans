/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package justfeed.GUI;

import javax.swing.JFrame;





/**
 *
 * @author UGent
 */
public class GuiMain extends JFrame{

    private static final GuiMain start = new GuiMain();
    public static JFrame myCaller;
     
    public static void main(String[] args) {
        //Start f = new Start (new Main());
        Start f = Start.getInstance(start);
        f.setSize(580,520);
        f.show();
        f.setLocationRelativeTo(null);
    }
    
     public static GuiMain getInstance()
    {
        return start;
    }

   
    
}
