package Personal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Scanner;

public class SnakeTempKlar {
    private int x = 0;
    private int y = 0;
    private int xChange = 0;
    private int yChange = 1;
    private int snakeDir = -17;
    private Timer timer;
    public Boolean otherKeys = false;
    public Boolean myKeysWinkWink = false;
    public Boolean hisSmallWand = false;
    //    private JPanel[] panels = new JPanel[323];
    private JPanel[] panels = new JPanel[255];
    private Color color = new Color(74, 74, 74);
    private Color color1 = new Color(11, 218, 234);
    private Color color2 = new Color(12, 151, 0);
    private Color colorB = new Color(0,0,0);
    private int appleEaten = 0;
    public SnakeTempKlar() {
        JFrame frame = new JFrame();
        Scanner scanner = new Scanner(System.in);
//        frame.setLayout(new GridLayout(17,19));
        frame.setLayout(new GridLayout(15,17));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        /*
        int num = -1;
        JPanel panel = new JPanel();
        for (int i = 0; i < 19; i++) {
            num += 1;
            panels[num] = panel;
            frame.add(panel);
            panel.setPreferredSize(new Dimension(40, 40));
            panel.setBackground(colorB);
        }
        for (int i = 0; i < 15; i++) {
            num += 1;
            panels[num] = panel;
            frame.add(panel);
            panel.setPreferredSize(new Dimension(40, 40));
            panel.setBackground(colorB);
            for (int j = 0; j < 17; j++) {
                num += 1;
                panels[num] = panel;
                frame.add(panel);
                panel.setPreferredSize(new Dimension(40, 40));
                panel.setBackground(color1);
            }
            num += 1;
            panels[num] = panel;
            frame.add(panel);
            panel.setPreferredSize(new Dimension(40, 40));
            panel.setBackground(colorB);
        }
        for (int i = 0; i < 19; i++) {
            num += 1;
            panels[num] = panel;
            frame.add(panel);
            panel.setPreferredSize(new Dimension(40, 40));
            panel.setBackground(colorB);
        }
         */

        for (int i = 0; i < 255; i++) {
            JPanel panel = new JPanel();
            panels[i] = panel;
            frame.add(panel);
            panel.setPreferredSize(new Dimension(40, 40));
            // if ((i&2) == 0) panel.setBackground(Color.BLACK); else panel.setBackground(Color.WHITE);
            // if (i%2 == 0) panel.setBackground(color); else panel.setBackground(color1);
            panel.setBackground(color1);
        }

        LinkedList<Integer> posList = new LinkedList<>();

        posList.add(161);
        posList.add(144);
        posList.add(127);

        for (int i = 0; i < posList.size(); i++) {
            panels[posList.get(i)].setBackground(color2);
        }
        frame.setVisible(true);
        frame.pack();
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("PRESSED!! " + e.getKeyCode());
                int[] snakedirishishi = {-1,-17,1,17};
                int wompWomp = 3;
                if (e.getKeyCode()==' ') otherKeys=true;
                if (e.getKeyCode() == 76) {
                    myKeysWinkWink = true;
                    otherKeys = true;
                    System.out.println(myKeysWinkWink + " " + otherKeys);
                } if (e.getKeyCode() == 80){
                    hisSmallWand = true;
                    otherKeys = true;
                }
                if (otherKeys && !myKeysWinkWink) {
                    if (e.getKeyCode() == 38 && snakeDir != 17) snakeDir = -17;
                    if (e.getKeyCode() == 39 && snakeDir != -1) snakeDir = 1;
                    if (e.getKeyCode() == 40 && snakeDir != -17) snakeDir = 17;
                    if (e.getKeyCode() == 37 && snakeDir != 1) snakeDir = -1;
                }if (!otherKeys){
                    if (e.getKeyCode() == 87 && snakeDir != 17) snakeDir = -17;      //Up
                    if (e.getKeyCode() == 68 && snakeDir != -1) snakeDir = 1;        //Right
                    if (e.getKeyCode() == 83 && snakeDir != -17) snakeDir = 17;      //Down
                    if (e.getKeyCode() == 65 && snakeDir != 1) snakeDir = -1;        //Left
                }if (myKeysWinkWink){
                    for (int i = 0; i <snakedirishishi.length; i++) {
                        if (snakedirishishi[i]==snakeDir) wompWomp = i;
                    }if (e.getKeyCode() == 65){
                        System.out.println("Active");
                        if (wompWomp==0) wompWomp = 4;
                        wompWomp--;
                        System.out.println(wompWomp);
                        snakeDir = snakedirishishi[wompWomp];
                    }if (e.getKeyCode() == 68){
                        System.out.println("Once Active");
                        if (wompWomp==3) wompWomp = -1;
                        wompWomp++;
                        System.out.println(wompWomp);
                        snakeDir = snakedirishishi[wompWomp];
                    }
                }if (hisSmallWand){
                    for (int i = 0; i <snakedirishishi.length; i++) {
                        if (snakedirishishi[i]==snakeDir) wompWomp = i;
                    }if (e.getKeyCode() == 37){
                        System.out.println("Active");
                        if (wompWomp==0) wompWomp = 4;
                        wompWomp--;
                        System.out.println(wompWomp);
                        snakeDir = snakedirishishi[wompWomp];
                    }if (e.getKeyCode() == 39){
                        System.out.println("Once Active");
                        if (wompWomp==3) wompWomp = -1;
                        wompWomp++;
                        System.out.println(wompWomp);
                        snakeDir = snakedirishishi[wompWomp];
                    }
                }
            }
        });
        timer = new Timer (100,e -> {
            if (snakeDir == -1) {
                xChange = -1;
                yChange = 0;
            }
            if (snakeDir == -17) {
                xChange = 0;
                yChange = 1;
            }
            if (snakeDir == 1) {
                xChange = 1;
                yChange = 0;
            }
            if (snakeDir == 17) {
                xChange = 0;
                yChange = -1;
            }
            int snakeHead = posList.getLast() + snakeDir;
            x += xChange;
            y += yChange;
            if (y>7||y<-7||x>8||x<-8) System.out.println(2/0);
            if (panels[snakeHead].getBackground() == color2) System.out.println(2/0);
            if (panels[snakeHead].getBackground() == Color.yellow) {
                appleEaten = 1;
            }
            if (appleEaten == 0) {
                panels[posList.pollFirst()].setBackground(color1);
            } else apple();
            posList.add(snakeHead);
            panels[snakeHead].setBackground(color2);
            appleEaten = 0;
        });

        timer.start();
        apple();
    }

    private void apple() {
        int position = (int) (Math.random() * 255);
        while (true) {
            position = (int) (Math.random() * 255);
            if (panels[position].getBackground() != color2) break;
        }
        System.out.println(panels[position].getBackground());
        panels[position].setBackground(Color.yellow);
        System.out.println(position);
    }

    public static void main(String[] args) {new SnakeTempKlar();}
}
