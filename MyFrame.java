/*  Author: Cristhian Sotelo
 UCID: 30004060
 CPSC 219, T05, WINTER 2017
 Version: March 26, 2017
 
 Racing Simulator, this class contains the window frame for the graphics. */

import javax.swing.JFrame;

public class MyFrame extends JFrame
{
    public static final int WIDTH = 845;
    public static final int HEIGHT = 498;
    
    public MyFrame()
    {
        setSize(WIDTH, HEIGHT);
    }
}
