package ClassData;

public abstract class Data {

    private String depID;
    private String depName;
    private String createDate;
    private String lastUpdateDate;

    public Data(String depID, String depName, String createDate, String lastUpdateDate) {
        this.depID = depID;
        this.depName = depName;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Data(String depID, String createDate, String lastUpdateDate) {
        this.depID = depID;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(String lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return depID + ";" + depName + ";" + createDate + ";" + lastUpdateDate;
    }
    
}
