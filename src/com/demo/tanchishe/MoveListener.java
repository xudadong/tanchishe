package com.demo.tanchishe;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class MoveListener extends KeyAdapter {
    private TanChiShe tanChiShe;
    public MoveListener(TanChiShe tanChiShe) {
        this.tanChiShe = tanChiShe;
    }
    public void keyReleased(KeyEvent e) {
        int keyNum = e.getKeyCode();
        if (!tanChiShe.isMoveFlg()) {
            tanChiShe.setMoveFlg(true);
        }
        if (keyNum == 38 || keyNum == 87) {
            // ↑ 又 W
            tanChiShe.setMoveDirection(1);
        } else if (keyNum == 37 || keyNum == 65) {
            // ← 又 A
            tanChiShe.setMoveDirection(2);
        } else if (keyNum == 40 || keyNum == 83) {
            // ↓ 又 S
            tanChiShe.setMoveDirection(3);
        } else if (keyNum == 39 || keyNum == 68) {
            // → 又 D
            tanChiShe.setMoveDirection(4);
        }
    }
}
