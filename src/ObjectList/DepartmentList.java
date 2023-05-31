package ObjectList;

import ClassData.Department;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DepartmentList extends ArrayList<Department> implements I_List {

    @Override
    public void showList() {
        if (this.isEmpty()) {
            System.out.println("Deparment list is empty!");
            return;
        }
        System.out.println("\t\t\t\t*** Department List ***");
        System.out.println("| ++ ID　++ | ++++++ Name ++++++ | ++++++ Create Date ++++++ | ++++++ Last Update Date ++++++ |");
        for (Department dep : this) {
            System.out.printf("    %-13s %-19s %-29s %-20s \n", dep.getDepID(), dep.getDepName(), dep.getCreateDate(), dep.getLastUpdateDate());
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
                String depId = stk.nextToken();
                String depName = stk.nextToken();
                String createDate = stk.nextToken();
                String lastUpdateDate = stk.nextToken();
                Department dep = new Department(depId, depName, createDate, lastUpdateDate);
                this.add(dep);
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
            for (Department dep : this) {
                pw.println(dep.toString());
            }
            System.out.println("*** Store list department to file successfully ***");
            fw.close();
            pw.close();
        } catch (Exception e) {
        }
    }

}
