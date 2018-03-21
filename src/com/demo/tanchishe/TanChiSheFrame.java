package com.demo.tanchishe;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class TanChiSheFrame extends JFrame {
    /** * */
    private static final long serialVersionUID = 1L;
    public TanChiSheFrame() {
        setVisible(true);
        setTitle("Ã∞≥‘…ﬂ");
        setLocationRelativeTo(null);
        setSize(500, 500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new GridBagLayout());
        TanChiShe tanChiShe = new TanChiShe();
        init(tanChiShe);
        YouXiPan qiPan = new YouXiPan(tanChiShe);
        addKeyListener(new MoveListener(tanChiShe));
        add(new JPanel(), new GridBagConstraints(0, 0, 1, 1, 0.1, 0.1,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(
                        0, 0, 0, 0), 0, 0));
        add(qiPan, new GridBagConstraints(0, 1, 1, 1, 0.8, 0.8,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                        0, 0, 0, 0), 0, 0));
        add(new JPanel(), new GridBagConstraints(0, 2, 1, 1, 0.1, 0.1,
                GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(
                        0, 0, 30, 0), 0, 0));
    }
    public void init(TanChiShe tanChiShe) {
        TanChiSheTou shetou = new TanChiSheTou();
        shetou.setPoint(new Point(8, 8));
        tanChiShe.setSheTou(shetou);
        TanChiSheWei sheWei1 = new TanChiSheWei();
        sheWei1.setPoint(new Point(16, 8));
        TanChiSheWei sheWei2 = new TanChiSheWei();
        sheWei2.setPoint(new Point(24, 8));
        tanChiShe.addSheWeiLst(sheWei1);
        tanChiShe.addSheWeiLst(sheWei2);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TanChiSheFrame();
            }
        });
    }
}
