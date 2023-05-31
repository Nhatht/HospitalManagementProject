package ObjectList;

import ClassData.Department;
import ClassData.Doctor;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import validation.MyValidation;

public class Transcript implements I_Transcript {

    DepartmentList depList;
    DoctorList docList;

    public Transcript(DepartmentList depList, DoctorList docList) {
        this.depList = depList;
        this.docList = docList;
    }

    public Department checkDepId(String depId) {
        for (Department department : depList) {
            if (department.getDepID().equalsIgnoreCase(depId)) {
                return department;
            }
        }
        return null;
    }

    public Doctor checkDocId(String docId) {
        for (Doctor doc : docList) {
            if (doc.getDocID().equalsIgnoreCase(docId)) {
                return doc;
            }
        }
        return null;
    }

    public Doctor checkDepInDoc(String depId) {
        for (Doctor doc : docList) {
            if (doc.getDepID().equalsIgnoreCase(depId)) {
                return doc;
            }
        }
        return null;
    }

    @Override
    public void addDoc() {
        if (depList.isEmpty()) {
            System.out.println("Department list is empty. Please add department first!");
            return;
        }
        String ctn = "y";
        while (ctn.equalsIgnoreCase("y")) {
            String docId = MyValidation.readPattern("Enter doctor Id [Ex:SE123]: ", "[A-Z][A-Z]\\d{3}");
            if (checkDocId(docId) != null) {
                System.out.println("\t*** Doctor Id Duplicate! ***");
                ctn = "n";
            } else {
                String docName = MyValidation.readPattern("Enter doctor name: ", "[A-Za-z| ]+");
                String docSex = MyValidation.readPattern("Enter doctor sex [Male/Female]: ", "Male|male|Female|female");
                String docAddress = MyValidation.readPattern("Enter doctor address: ", ".+");
                String depId = MyValidation.readPattern("Enter department Id: ", "[A-Z][A-Z]\\d{3}");
                Department dep = checkDepId(depId);
                if (dep == null) {
                    System.out.println("Department " + depId + " does not exits!");
                    System.out.println("\tAdd doctor failed!");
                } else {
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    Date date = new Date();
                    String createDate = format.format(date);
                    String lastUpdateDate = " ";
                    Doctor doc = new Doctor(docId, docName, docSex, docAddress, depId, createDate, lastUpdateDate);
                    docList.add(doc);
                    System.out.println("\tAdd doctor successfully!");
                }
                ctn = MyValidation.readPattern("Do you want to add more [Y/N]: ", "[Yy|Nn]");
                System.out.println("");
            }
        }
    }

    @Override
    public void addDep() {
        String ctn = "y";
        while (ctn.equalsIgnoreCase("y")) {
            String depId = MyValidation.readPattern("Enter Department Id [Ex:AB123]: ", "[A-Z][A-Z]\\d{3}");
            if (checkDepId(depId) != null) {
                System.out.println("\t*** Department Id Duplicate! ***");
                ctn = "n";
            } else {
                String depName = MyValidation.readPattern("Enter department name: ", "[A-Za-z|0-9| ]+");
                Date date = new Date();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String createDate = format.format(date);
                String lastUpdateDate = " ";
                Department dep = new Department(depId, depName, createDate, lastUpdateDate);
                depList.add(dep);
                System.out.println("\tAdd department successfully!");
                ctn = MyValidation.readPattern("Do you want to add more [Y/N]: ", "[Yy|Nn]");
                System.out.println("");
            }
        }
    }

    @Override
    public void updateDoc() {
        if (docList.isEmpty()) {
            System.out.println("Doctor list is empty!");
            return;
        }
        String ctn = "y";
        while (ctn.equalsIgnoreCase("y")) {
            String docId = MyValidation.readPattern("Enter doctor Id [Ex:SE123]: ", "[A-Z][A-Z]\\d{3}");
            Doctor doc = checkDocId(docId);
            if (doc == null) {
                System.out.println("Doctor " + docId + " does not exits!");
                ctn = "n";
            } else {
                System.out.println("\nOld doctor name: " + doc.getDocName());
                String nDocName = MyValidation.readPatternUpdate("Enter new doctor name: ", "[A-Za-z| ]+");

                System.out.println("\nOld doctor sex: " + doc.getDocSex());
                String nDocSex = MyValidation.readPatternUpdate("Enter new doctor sex [Male/Female]: ", "Male|male|Female|female");

                System.out.println("\nOld doctor address: " + doc.getDocAddress());
                String nDocAddress = MyValidation.readPatternUpdate("Enter new doctor address: ", ".+");

                System.out.println("\nOld department id: " + doc.getDepID());
                String nDepId = MyValidation.readPatternUpdate("Enter new department Id [Ex:AB123]: ", "[A-Za-z|0-9]+");
                Department dep = checkDepId(nDepId);
                if (dep == null && !nDepId.isEmpty()) {
                    System.out.println("Department " + nDepId + " does not exits!");
                    System.out.println("Update doctor failed!");
                } else {
                    if (nDocName.isEmpty() && nDocSex.isEmpty() && nDocAddress.isEmpty() && nDepId.isEmpty()) {
                        System.out.println("The information of doctor is unchanged!");
                    } else {
                        if (!nDocName.isEmpty()) {
                            doc.setDocName(nDocName);
                        }
                        if (!nDocSex.isEmpty()) {
                            doc.setDocSex(nDocSex);
                        }
                        if (!nDocAddress.isEmpty()) {
                            doc.setDocAddress(nDocAddress);
                        }
                        if (!nDepId.isEmpty()) {
                            doc.setDepID(nDepId);
                        }

                        Date date = new Date();
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String lastUpdateDate = format.format(date);
                        doc.setLastUpdateDate(lastUpdateDate);
                        System.out.println("Update doctor successfully!");
                    }
                }
                ctn = MyValidation.readPattern("Do you want to update more [Y/N]: ", "[Yy|Nn]");
            }

        }
    }

    @Override
    public void updateDep() {
        if (depList.isEmpty()) {
            System.out.println("Department list is empty!");
            return;
        }
        String ctn = "y";
        while (ctn.equalsIgnoreCase("y")) {
            String depId = MyValidation.readPattern("Enter department Id [Ex:AB123]: ", "[A-Z][A-Z]\\d{3}");
            Department dep = checkDepId(depId);
            if (dep == null) {
                System.out.println("Department " + depId + " does not exits!");
                ctn = "n";
            } else {
                System.out.println("\nOld department name: " + dep.getDepName());
                String nDepName = MyValidation.readPatternUpdate("Enter new department name: ", "[A-Za-z|0-9| ]+");
                if (nDepName.isEmpty()) {
                    System.out.println("The information of department is unchanged!");
                } else {
                    dep.setDepName(nDepName);
                    Date date = new Date();
                    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String lastUpdateDate = format.format(date);
                    dep.setLastUpdateDate(lastUpdateDate);
                    System.out.println("Update department successfully!");
                }
                ctn = MyValidation.readPattern("Do you want to update more [Y/N]: ", "[Yy|Nn]");
            }
        }
    }

    @Override
    public void removeDoc() {
        boolean cont;
        do {
            if (docList.isEmpty()) {
                System.out.println("Doctor list is empty!");
                return;
            }
            String docId = MyValidation.readPattern("Enter doctor Id [Ex:AB123]: ", "[A-Z][A-Z]\\d{3}");
            Doctor doc = checkDocId(docId);
            if (doc == null) {
                System.out.println("Dortor " + docId + " does not exits!");
                cont = true;
            } else {
                String del = MyValidation.readPattern("Do you realy want to delete doctor " + docId + " [Y/N]: ", "[Yy|Nn]");
                if (del.equalsIgnoreCase("y")) {
                    docList.remove(doc);
                    System.out.println("Delete dortor " + docId + " successfully!");
                } else {
                    System.out.println("Delete dortor failed!");
                }
                cont = false;
            }
        } while (cont);

    }

    @Override
    public void removeDep() {

        boolean cont;
        do {
            if (depList.isEmpty()) {
                System.out.println("Department list is empty!");
                return;
            }
            String depId = MyValidation.readPattern("Enter department Id [Ex:AB123]: ", "[A-Z][A-Z]\\d{3}");
            Department dep = checkDepId(depId);
            if (dep == null) {
                System.out.println("Department " + depId + " does not exits!");
                cont = true;
            } else {
                Doctor doc = checkDepInDoc(depId);
                if (doc != null) {
                    System.out.println("Department can not be deleted because doctor " + doc.getDocID() + " is in this department!");
                    System.out.println("Delete department failed!");
                } else {
                    String del = MyValidation.readPattern("Do you realy want to delete department " + depId + " [Y/N]   ", "[Yy|Nn]");
                    if (del.equalsIgnoreCase("y")) {
                        depList.remove(dep);
                        System.out.println("Delete department " + depId + " successfully!");
                    } else {
                        System.out.println("Delete department failed!");
                    }
                }
                cont = false;
            }
        } while (cont);

    }
           
    
    public ArrayList<Doctor> checkDocName(String o) {
        ArrayList<Doctor> result = new ArrayList();
        String oName[] = o.split(" ");
        int oLastName = oName.length - 1;
        for(Doctor doctor: docList){
            String docName[] = doctor.getDocName().split(" ");
            int lastName = docName.length - 1;
            if(oName[oLastName].equalsIgnoreCase(docName[lastName])){
                result.add(doctor);
            }
        }
        return result;
    }

    @Override
    public void searchDoc() {
        if (docList.isEmpty()) {
            System.out.println("Doctor list is empty!");
        } else {
            String docName = MyValidation.readPattern("Enter doctor name: ", "[A-Za-z| ]+");
            ArrayList<Doctor> result = checkDocName(docName);
            if (result.isEmpty()) {
                System.out.println("Doctor " + docName + " does not exist!");
                System.out.println("Search doctor failed!");
            } else {
                System.out.println("\t\t\t\t\t\t*** Doctor Information ***");
                System.out.println("| ++ ID　++ | ++++++ Name ++++++ | ++++++ Gender ++++++ | ++++++ Address ++++++ | ++ Department Id ++ | ++++++ Create Date ++++++ | ++++++ Last Update Date ++++++ |");
                for (Doctor doc : result) {
                    System.out.printf("    %-12s %-24s %-20s %-25s %-19s %-29s %-30s\n", doc.getDocID(), doc.getDocName(), doc.getDocSex(), doc.getDocAddress(), doc.getDepID(), doc.getCreateDate(), doc.getLastUpdateDate());
                }
            }
        }
    }

    @Override
    public void searchDep() {
        if (depList.isEmpty()) {
            System.out.println("Department list is empty!");
        } else {
            String depId = MyValidation.readPattern("Enter department Id [Ex:AB123]: ", "[A-Z][A-Z]\\d{3}");
            Department dep = checkDepId(depId);
            if (dep != null) {
                System.out.println("\t\t\t\t*** Department Information ***");
                System.out.println("| ++ ID　++ | ++++++ Name ++++++ | ++++++ Create Date ++++++ | ++++++ Last Update Date ++++++ |");
                System.out.printf("    %-13s %-19s %-29s %-20s \n", dep.getDepID(), dep.getDepName(), dep.getCreateDate(), dep.getLastUpdateDate());

            } else {
                System.out.println("Department " + depId + " does not exist!");
                System.out.println("Search department failed!");
            }
        }
    }

}
