package Personal.Testing.SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Scanner;

public class SnakeFinishedForNow {
        private int x = 0;
        private int y = 0;
        private int xChange = 0;
        private int yChange = 1;
        private int snakeDir = -17;
        private int applesEaten = -1;
        private int turnsMade = 0;
        private int time = 0;
        private int prevDir = 0;
        private Timer timer;
        public Boolean otherKeys = false;
        private JPanel[] panels = new JPanel[255];
        private Color color1 = new Color(11, 218, 234);
        private Color color2 = new Color(12, 151, 0);
        private int appleEaten = 0;
        public SnakeFinishedForNow() {
            JFrame frame = new JFrame();
            frame.setLayout(new GridLayout(15,17));
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            for (int i = 0; i < 255; i++) {
                JPanel panel = new JPanel();
                panels[i] = panel;
                frame.add(panel);
                panel.setPreferredSize(new Dimension(40, 40));
                panel.setBackground(color1);
            }
            LinkedList<Integer> posList = new LinkedList<>();

            posList.add(161);
            posList.add(144);
            posList.add(127);

            for (int i = 0; i < posList.size(); i++) panels[posList.get(i)].setBackground(color2);
            frame.setVisible(true);
            frame.pack();
            frame.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == 32) timer.start();
                    int[] snakedirishishi = {-1,-17,1,17};
                    int wompWomp = 3;
                    if (e.getKeyCode() == 76) {       //L
                        otherKeys = true;
                    }
                    if (!otherKeys){
                        if (e.getKeyCode() == 38 && prevDir != 17) {
                            snakeDir = -17;
                            turnsMade++;
                        }
                        if (e.getKeyCode() == 39 && prevDir != -1) {
                            snakeDir = 1;
                            turnsMade++;
                        }
                        if (e.getKeyCode() == 40 && prevDir != -17) {
                            snakeDir = 17;
                            turnsMade++;
                        }
                        if (e.getKeyCode() == 37 && prevDir != 1) {
                            snakeDir = -1;
                            turnsMade++;
                        }
                        if (e.getKeyCode() == 87 && prevDir != 17) {
                            snakeDir = -17;      //Up
                            turnsMade++;
                        }
                        if (e.getKeyCode() == 68 && prevDir != -1) {
                            snakeDir = 1;        //Right
                            turnsMade++;
                        }
                        if (e.getKeyCode() == 83 && prevDir != -17) {
                            snakeDir = 17;      //Down
                            turnsMade++;
                        }
                        if (e.getKeyCode() == 65 && prevDir != 1) {
                            snakeDir = -1;        //Left
                            turnsMade++;
                        }
                    }
                    if (otherKeys){
                        for (int i = 0; i <snakedirishishi.length; i++) {
                            if (snakedirishishi[i]==snakeDir) wompWomp = i;
                        }if (e.getKeyCode() == 65 || e.getKeyCode() == 37){
                            System.out.println("Active");
                            if (wompWomp==0) wompWomp = 4;
                            wompWomp--;
                            turnsMade++;
                            System.out.println(wompWomp);
                            snakeDir = snakedirishishi[wompWomp];
                        }if (e.getKeyCode() == 68 || e.getKeyCode() == 39){
                            System.out.println("Once Active");
                            if (wompWomp==3) wompWomp = -1;
                            wompWomp++;
                            turnsMade++;
                            System.out.println(wompWomp);
                            snakeDir = snakedirishishi[wompWomp];
                        }
                    }
                }
            });
            timer = new Timer (120,e -> {
                time++;
                System.out.println(time*120 + " milliseconds");
                System.out.println(applesEaten + " apples eaten");
                System.out.println(turnsMade + " turns made");
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
                prevDir = snakeDir;
                x += xChange;
                y += yChange;
                if (y>7||y<-7||x>8||x<-8) System.out.println(2/0);
                if (panels[snakeHead].getBackground() == color2) System.out.println(2/0);
                if (panels[snakeHead].getBackground() == Color.yellow) appleEaten = 1;
                if (appleEaten == 0) panels[posList.pollFirst()].setBackground(color1);
                else apple();
                posList.add(snakeHead);
                panels[snakeHead].setBackground(color2);
                appleEaten = 0;
            });
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
            applesEaten++;
        }
        public static void main(String[] args) {new SnakeFinishedForNow();}
}
