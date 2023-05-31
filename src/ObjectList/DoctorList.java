package ObjectList;

import ClassData.Doctor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DoctorList extends ArrayList<Doctor> implements I_List {

    @Override
    public void showList() {
        if (this.isEmpty()) {
            System.out.println("Doctor list is empty!");
            return;
        }
        System.out.println("\t\t\t\t\t\t\t*** Doctor List ***");
        System.out.println("| ++ ID　++ | ++++++ Name ++++++ | ++++++ Gender ++++++ | ++++++ Address ++++++ | ++ Department Id ++ | ++++++ Create Date ++++++ | ++++++ Last Update Date ++++++ |");
        for (Doctor doc : this) {
            System.out.printf("    %-12s %-24s %-20s %-25s %-19s %-29s %-30s\n", doc.getDocID(), doc.getDocName(), doc.getDocSex(), doc.getDocAddress(), doc.getDepID(), doc.getCreateDate(), doc.getLastUpdateDate());
        }
    }
    
    @Override
    public void loadFile(String fName) {
        try {
            FileReader fr = new FileReader(fName);
            BufferedReader bf = new BufferedReader(fr);
            String details;
            while ((details = bf.readLine()) != null) {
                StringTokenizer stk = new StringTokenizer(details, ";");
                String docId = stk.nextToken();
                String docName = stk.nextToken();
                String docSex = stk.nextToken();
                String docAddrs = stk.nextToken();
                String dpId = stk.nextToken();
                String createDate = stk.nextToken();
                String lastUpdateDate = stk.nextToken();
                Doctor doc = new Doctor(docId, docName, docSex, docAddrs, dpId, createDate, lastUpdateDate);
                this.add(doc);
            }
            bf.close();
            fr.close();
        } catch (Exception e) {
        }
    }

    @Override
    public void writeToFile(String fName) {
        try {
            FileWriter fw = new FileWriter(fName);
            PrintWriter pw = new PrintWriter(fw);
            for (Doctor doc : this) {
                pw.println(doc.toString());
            }
            System.out.println("*** Store list doctor to file successfully ***");
            fw.close();
            pw.close();
        } catch (Exception e) {
        }
    }

}
