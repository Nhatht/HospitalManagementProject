package ClassData;

public class Doctor extends Data {

    private String docID;
    private String docName;
    private String docSex;
    private String docAddress;

    public Doctor(String docID, String docName, String docSex, String docAddress, String depID, String createDate, String lastUpdateDate) {
        super(depID, createDate, lastUpdateDate);
        this.docID = docID;
        this.docName = docName;
        this.docSex = docSex;
        this.docAddress = docAddress;
    }

    public String getDocID() {
        return docID;
    }

    public void setDocID(String docID) {
        this.docID = docID;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocSex() {
        return docSex;
    }

    public void setDocSex(String docSex) {
        this.docSex = docSex;
    }

    public String getDocAddress() {
        return docAddress;
    }

    public void setDocAddress(String docAddress) {
        this.docAddress = docAddress;
    }

    @Override
    public String toString() {
        return docID + ";" + docName + ";" + docSex + ";" + docAddress + ";" + super.getDepID() + ";" + super.getCreateDate() + ";" + super.getLastUpdateDate();
    }

}
