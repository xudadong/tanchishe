package com.demo.tanchishe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class YouXiPan extends JPanel {
    /** * */
    private static final long serialVersionUID = 1L;
    private TanChiShe tanChiShe;
    private boolean initFlg = true;
    private boolean randomFlg = true;
    private int randomXPoint;
    private int randomYPoint;
    private Timer timer;
    private int delay = 100;
    // every 1 second
    private int moveX = 0;
    private int moveY = 0;
    private int score;
    public YouXiPan(TanChiShe tanChiShe) {
        randomXPoint = (int) (Math.random() * 300 / 8) * 8;
        randomYPoint = (int) (Math.random() * 300 / 8) * 8;
        setBackground(Color.gray);
        setPreferredSize(new Dimension(300, 300));
        start();
        this.tanChiShe = tanChiShe;
        this.moveX = tanChiShe.getSheTou().getPoint().x;
        this.moveY = tanChiShe.getSheTou().getPoint().y;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (randomFlg) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
        g.drawRect(randomXPoint, randomYPoint, 8, 8);
        g.fillRect(randomXPoint, randomYPoint, 8, 8);
        if (initFlg) {
            initPaint(g);
        }
        if (tanChiShe.isMoveFlg()) {
            initFlg = false;
            movePaint(g);
        }
    }
    private void initPaint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(tanChiShe.getSheTou().getPoint().x, tanChiShe.getSheTou()
                .getPoint().y, 8, 8);
        g.setColor(Color.WHITE);
        g.fillRect(tanChiShe.getSheTou().getPoint().x, tanChiShe.getSheTou()
                .getPoint().y, 8, 8);
        List<TanChiSheWei> sheWeiLst = tanChiShe.getSheWeiLst();
        for (TanChiSheWei sheWei : sheWeiLst) {
            g.setColor(Color.BLACK);
            g.drawRect(sheWei.getPoint().x, sheWei.getPoint().y, 8, 8);
            g.setColor(Color.WHITE);
            g.fillRect(sheWei.getPoint().x, sheWei.getPoint().y, 8, 8);
        }
    }
    private void movePaint(Graphics g) {
        if (tanChiShe.getMoveDirection() == 1) {
            moveY = moveY - 8;
        } else if (tanChiShe.getMoveDirection() == 2) {
            moveX = moveX - 8;
        } else if (tanChiShe.getMoveDirection() == 3) {
            moveY = moveY + 8;
        } else if (tanChiShe.getMoveDirection() == 4) {
            moveX = moveX + 8;
        }
        if (moveY <= 0 || moveX <= 0 || moveX >= 300 || moveY >= 300) {
            end();
            paintTanChiShe(g);
            return;
        }
        List<TanChiSheWei> sheWeiLst = tanChiShe.getSheWeiLst();
        for (TanChiSheWei sheWei : sheWeiLst) {
            int x = sheWei.getPoint().x;
            int y = sheWei.getPoint().y;
            if ((moveX == x - 8 && moveY == y)
                    || (moveX == x && moveY == y - 8)
                    || (moveX == x + 8 && moveY == y)
                    || (moveX == x && moveY == y + 8)) {
                end();
                paintTanChiShe(g);
                return;
            }
        }
        TanChiSheTou sheTou = tanChiShe.getSheTou();
        Point sheTouPoint = sheTou.getPoint();
        int touX = sheTouPoint.x;
        int touY = sheTouPoint.y;
        Point nextShTiPoint = sheTou.getPoint();

        for (TanChiSheWei tanChiSheWei : sheWeiLst) {
            nextShTiPoint = tanChiSheWei.getPoint();
            tanChiSheWei.setPoint(sheTouPoint);
            sheTouPoint = nextShTiPoint;
        }
        sheTou.setPoint(new Point(moveX, moveY));
        if (moveX == randomXPoint || moveY == randomYPoint) {
            if ((touX == randomXPoint - 8 && touY == randomYPoint)
                    || (touX == randomXPoint && touY == randomYPoint - 8)
                    || (touX == randomXPoint + 8 && touY == randomYPoint)
                    || (touX == randomXPoint && touY == randomYPoint + 8)) {
                randomXPoint = (int) (Math.random() * 300 / 8) * 8;
                randomYPoint = (int) (Math.random() * 300 / 8) * 8;
                TanChiSheWei newSheWei = new TanChiSheWei();
                newSheWei.setPoint(sheTouPoint);
                tanChiShe.addSheWeiLst(newSheWei);
            }
        }
        paintTanChiShe(g);
    }
    private void paintTanChiShe(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawRect(tanChiShe.getSheTou().getPoint().x, tanChiShe.getSheTou()
                .getPoint().y, 8, 8);
        g.setColor(Color.WHITE);
        g.fillRect(tanChiShe.getSheTou().getPoint().x, tanChiShe.getSheTou()
                .getPoint().y, 8, 8);
        for (TanChiSheWei sheWei : tanChiShe.getSheWeiLst()) {
            g.setColor(Color.BLACK);
            g.drawRect(sheWei.getPoint().x, sheWei.getPoint().y, 8, 8);
            g.setColor(Color.WHITE);
            g.fillRect(sheWei.getPoint().x, sheWei.getPoint().y, 8, 8);
        }
    }
    private void start() {
        ActionListener action = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (score > 1000) {
                    end();
                }
                repaint();
                if (randomFlg) {
                    randomFlg = false;
                } else {
                    randomFlg = true;
                }
                score++;
            }
        };
        timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();
    }
    private void end() {
        timer.stop();
    }
}