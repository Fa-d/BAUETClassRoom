package go.faddy.com.agin2.models;

public class calenderPopGet {
    String type;
    String subjcct;

    public calenderPopGet() {
    }

    public calenderPopGet(String type, String subjcct) {
        this.type = type;
        this.subjcct = subjcct;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubjcct() {
        return subjcct;
    }

    public void setSubjcct(String subjcct) {
        this.subjcct = subjcct;
    }
}

