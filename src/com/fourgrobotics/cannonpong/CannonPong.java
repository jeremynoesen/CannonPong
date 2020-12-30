package com.fourgrobotics.cannonpong;

import com.fourgrobotics.cannonpong.panels.GamePanel;
import com.fourgrobotics.cannonpong.panels.MenuPanel;
import com.fourgrobotics.cannonpong.util.Score;
import com.fourgrobotics.cannonpong.util.SpriteLoader;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * CannonPong is a game like cup pong, but the person throwing it is replaced with a cannon. This is a game created as
 * part of a CPR E 186 project at Iowa State University.
 *
 * @author Jeremy Noesen, Gavin Canfield, Andrew Bowen, Zachary Hirst
 */
public class CannonPong extends JFrame {
    /**
     * scoreboard to keep scores
     */
    private Score s;
    
    /**
     * initializes the ui when making a new instance
     *
     * @throws IOException
     */
    public CannonPong() throws IOException {
        initializeUI();
    }
    
    /**
     * runs the game
     *
     * @param args
     */
    public static void main(String[] args) {
        new SpriteLoader();
        
        EventQueue.invokeLater(() -> {
            CannonPong game = null;
            try {
                game = new CannonPong();
            } catch (IOException e) {
                e.printStackTrace();
            }
            game.setVisible(true);
        });
    }
    
    
    /**
     * create the window and add components to it to create the UI
     *
     * @throws IOException
     */
    private void initializeUI() throws IOException {
        s = new Score();
        
        GamePanel gamePanel = new GamePanel(s);
        add(gamePanel);
        setGlassPane(new MenuPanel(gamePanel, s));
        getGlassPane().setVisible(true);
        
        
        setSize(1000, 750);
        setResizable(false);
        setTitle("Cannon Pong");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
