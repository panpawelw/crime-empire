package pl.lococompadres.entities;

import javax.persistence.*;

@Entity
@Table(name = "gamestate")
public class Gamestate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int actionPoints;
    private long cash;
    private long thugs;
    private long ladies;
    private long dealers;

    private String point01;
    private String point02;
    private String point03;
    private String point04;
    private String point05;
    private String point06;
    private String point07;
    private String point08;
    private String point09;
    private String point10;
    private String point11;
    private String point12;
    private String point13;
    private String point14;
    private String point15;
    private String point16;
    private String point17;
    private String point18;
    private String point19;
    private String point20;

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public long getCash() {
        return cash;
    }

    public void setCash(long cash) {
        this.cash = cash;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getThugs() {
        return thugs;
    }

    public void setThugs(long thugs) {
        this.thugs = thugs;
    }

    public long getLadies() {
        return ladies;
    }

    public void setLadies(long ladies) {
        this.ladies = ladies;
    }

    public long getDealers() {
        return dealers;
    }

    public void setDealers(long dealers) {
        this.dealers = dealers;
    }

    public String getPoint01() {
        return point01;
    }

    public void setPoint01(String point01) {
        this.point01 = point01;
    }

    public String getPoint02() {
        return point02;
    }

    public void setPoint02(String point02) {
        this.point02 = point02;
    }

    public String getPoint03() {
        return point03;
    }

    public void setPoint03(String point03) {
        this.point03 = point03;
    }

    public String getPoint04() {
        return point04;
    }

    public void setPoint04(String point04) {
        this.point04 = point04;
    }

    public String getPoint05() {
        return point05;
    }

    public void setPoint05(String point05) {
        this.point05 = point05;
    }

    public String getPoint06() {
        return point06;
    }

    public void setPoint06(String point06) {
        this.point06 = point06;
    }

    public String getPoint07() {
        return point07;
    }

    public void setPoint07(String point07) {
        this.point07 = point07;
    }

    public String getPoint08() {
        return point08;
    }

    public void setPoint08(String point08) {
        this.point08 = point08;
    }

    public String getPoint09() {
        return point09;
    }

    public void setPoint09(String point09) {
        this.point09 = point09;
    }

    public String getPoint10() {
        return point10;
    }

    public void setPoint10(String point10) {
        this.point10 = point10;
    }

    public String getPoint11() {
        return point11;
    }

    public void setPoint11(String point11) {
        this.point11 = point11;
    }

    public String getPoint12() {
        return point12;
    }

    public void setPoint12(String point12) {
        this.point12 = point12;
    }

    public String getPoint13() {
        return point13;
    }

    public void setPoint13(String point13) {
        this.point13 = point13;
    }

    public String getPoint14() {
        return point14;
    }

    public void setPoint14(String point14) {
        this.point14 = point14;
    }

    public String getPoint15() {
        return point15;
    }

    public void setPoint15(String point15) {
        this.point15 = point15;
    }

    public String getPoint16() {
        return point16;
    }

    public void setPoint16(String point16) {
        this.point16 = point16;
    }

    public String getPoint17() {
        return point17;
    }

    public void setPoint17(String point17) {
        this.point17 = point17;
    }

    public String getPoint18() {
        return point18;
    }

    public void setPoint18(String point18) {
        this.point18 = point18;
    }

    public String getPoint19() {
        return point19;
    }

    public void setPoint19(String point19) {
        this.point19 = point19;
    }

    public String getPoint20() {
        return point20;
    }

    public void setPoint20(String point20) {
        this.point20 = point20;
    }
}
