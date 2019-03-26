package sample;

public class RegTable {
    private String id, owname, vehname, regno, regdate, vehclass;

    public RegTable(String id, String owname, String vehname, String regno, String regdate, String vehclass) {
        this.id = id;
        this.owname = owname;
        this.vehname = vehname;
        this.regno = regno;
        this.regdate = regdate;
        this.vehclass = vehclass;
    }

    public String getVehclass() {
        return vehclass;
    }

    public void setVehclass(String vehclass) {
        this.vehclass = vehclass;
    }

    public String getRegdate() {
        return regdate;
    }

    public void setRegdate(String regdate) {
        this.regdate = regdate;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String getVehname() {
        return vehname;
    }

    public void setVehname(String vehname) {
        this.vehname = vehname;
    }

    public String getOwname() {
        return owname;
    }

    public void setOwname(String owname) {
        this.owname = owname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
