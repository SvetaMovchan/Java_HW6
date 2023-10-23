public class NoteBooks {
    int ram;
    int hd;
    String os;
    String casecolour;
    int screensize;
    private int vRam;
    private int vHd;
    private String vOs;
    private String vCol;
    private int vScr;

    public int getvRam() {
        return vRam;
    }

    public int getvHd() {
        return vHd;
    }

    public String getvOs() {
        return vOs;
    }

    public String getvCol() {
        return vCol;
    }
    public int getvScr() {
        return vScr;
    }
    public void setVRam(int vRam) {
        this.vRam = vRam;
    }

    public void setVHd(int vHd) {
        this.vHd = vHd;
    }

    public void setVOs(String vOs) {
        this.vOs = vOs;
    }

    public void setVCol(String vCol) {
        this.vCol = vCol;
    }
    public void setVScr(int vScr) {
        this.vScr = vScr;
    }

    public String toString() {
        return "RAM: " + vRam + ", SSD: " + vHd + ", OS " + vOs + ", цвет: " + vCol + ", экран: " + vScr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NoteBooks)) {
            return false;
        }
        NoteBooks nb = (NoteBooks) obj;
        return ram == nb.ram && hd == nb.hd && os.equals(nb.os) && casecolour.equals(nb.casecolour) && screensize == nb.screensize;
        //return name.equals(cat.name) && age == cat.age && poroda.equals(cat.poroda);
    }
}
