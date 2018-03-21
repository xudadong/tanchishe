package com.demo.tanchishe;

import java.util.ArrayList;
import java.util.List;

public class TanChiShe {
    private int moveDirection;
    private List<TanChiSheWei> sheWeiLst = new ArrayList<>();
    private boolean moveFlg;
    private TanChiSheTou sheTou;
    /** * @return length */
    public int getLength() {
        return sheWeiLst.size();
    }
    /** * @return moveDirection */
    public int getMoveDirection() {
        return moveDirection;
    }
    /** * @param moveDirection 設定する moveDirection */
    public void setMoveDirection(int moveDirection) {
        this.moveDirection = moveDirection;
    }
    /** * @return moveFlg */
    public boolean isMoveFlg() {
        return moveFlg;
    }
    /** * @param moveFlg 設定する moveFlg */
    public void setMoveFlg(boolean moveFlg) {
        this.moveFlg = moveFlg;
    }
    /** * @return sheWeiLst */
    public List<TanChiSheWei> getSheWeiLst() {
        return sheWeiLst;
    }
    /** * @param sheWeiLst 設定する sheWei */
    public void addSheWeiLst(TanChiSheWei shemWei) {
        this.sheWeiLst.add(shemWei);
    }
    /** * @return sheTou */
    public TanChiSheTou getSheTou() {
        return sheTou;
    }
    /** * @param sheTou 設定する sheTou */
    public void setSheTou(TanChiSheTou sheTou) {
        this.sheTou = sheTou;
    }
}
