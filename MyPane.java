/*  Author: Cristhian Sotelo
 UCID: 30004060
 CPSC 219, T05, WINTER 2017
 Version: March 26, 2017

 Racing Simulator, this class contains all the graphics. */


import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import java.awt.Dimension;

public class MyPane extends JLayeredPane
{
    private JLabel bgLabel;
    private JLabel blizzLabel;
    private JLabel heatLabel;
    private JLabel suvLabel;
    private JLabel sportsLabel;
    private JLabel suvWinLabel;
    private JLabel sportsWinLabel;
    private JLabel raceTieLabel;

    private ImageIcon bgPic = new ImageIcon("images/racetracks2.png");
    private ImageIcon blizz = new ImageIcon("images/blizzard.png");
    private ImageIcon heat = new ImageIcon("images/heat.png");
    private ImageIcon suv = new ImageIcon("images/SUV.png");
    private ImageIcon sports = new ImageIcon("images/Sports.png");
    private ImageIcon suvWin = new ImageIcon("images/SUVWin.png");
    private ImageIcon sportsWin = new ImageIcon("images/SportsWin.png");
    private ImageIcon raceTie = new ImageIcon("images/RaceTie.png");


    private final int SPACE = 33;

    public MyPane()
    {
        setPreferredSize(new Dimension(848, 475));

        bgLabel = new JLabel(bgPic);
        bgLabel.setBounds(0, 0, bgPic.getIconWidth(), bgPic.getIconHeight());

        blizzLabel = new JLabel(blizz);
        blizzLabel.setBounds(5, 0, blizz.getIconWidth(), blizz.getIconHeight());
        blizzLabel.setVisible(false);

        heatLabel = new JLabel(heat);
        heatLabel.setBounds(5, blizz.getIconHeight(), heat.getIconWidth(), heat.getIconHeight());
        heatLabel.setVisible(false);

        suvLabel = new JLabel(suv);
        suvLabel.setBounds(2, 195, suv.getIconWidth(), suv.getIconHeight());

        sportsLabel = new JLabel(sports);
        sportsLabel.setBounds(2, 435, sports.getIconWidth(), sports.getIconHeight());

        suvWinLabel = new JLabel(suvWin);
        suvWinLabel.setBounds(210, 100, suvWin.getIconWidth(), suvWin.getIconHeight());
        suvWinLabel.setVisible(false);

        sportsWinLabel = new JLabel(sportsWin);
        sportsWinLabel.setBounds(150, 320, sportsWin.getIconWidth(), sportsWin.getIconHeight());
        sportsWinLabel.setVisible(false);

        raceTieLabel = new JLabel(raceTie);
        raceTieLabel.setBounds(240, 140, raceTie.getIconWidth(), raceTie.getIconHeight());
        raceTieLabel.setVisible(false);

        add(bgLabel, new Integer(1));
        add(blizzLabel, new Integer(2));
        add(heatLabel, new Integer(3));
        add(suvLabel, new Integer(4));
        add(sportsLabel, new Integer(5));
        add(suvWinLabel, new Integer(6));
        add(sportsWinLabel, new Integer(7));
        add(raceTieLabel, new Integer(8));
    }

    public void setBlizzard(boolean state)
    {
        blizzLabel.setVisible(state);
    }

    public void setHeat(boolean state)
    {
        heatLabel.setVisible(state);
    }

    public void moveSUV(int x)
    {
        suvLabel.setBounds((x*SPACE), 195, suv.getIconWidth(), suv.getIconHeight());
    }

    public void moveSports(int x)
    {
        sportsLabel.setBounds((x*SPACE), 435, sports.getIconWidth(), sports.getIconHeight());
    }

    public void setSUVWin(boolean state)
    {
        suvWinLabel.setVisible(state);
    }

    public void setSportsWin(boolean state)
    {
        sportsWinLabel.setVisible(state);
    }

    public void setRaceTie(boolean state)
    {
        raceTieLabel.setVisible(state);
    }

}
