import java.io.*;

public class Helper {
    Students student;
    double correctAverage;

    public Helper(Students student) {
        this.student = student;
    }

    public boolean checkIfAverageIsOk(double average) {

        double sumOfAllMarks = 0;

        for (double mark : student.marks) {
            sumOfAllMarks += mark;
        }

        correctAverage = sumOfAllMarks/student.marks.size();
        if (average != correctAverage) {
            //student.setAverage(correctAverage);
            return false;
        }

        return true;
    }

//    public void editXMLFile() throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader(baseXMLFile));
//        BufferedWriter writer = new BufferedWriter(new FileWriter(editedFilePath));
//
//        String str;
//        while ((str = reader.readLine()) != null) {
//            if (str.contains("average")) {
//                try {
//                    double temp = Double.parseDouble(str);
//                    if (!checkIfAverageIsOk(temp)) {
//                        str = str.replace(String.valueOf(temp), String.valueOf(correctAverage));
//                    }
//                } catch (Exception exc) {
//
//                }
//            }
//            writer.write(str + "\n");
//        }
//
//        reader.close();
//        writer.flush();
//        writer.close();
//        // scan .xml for tag and then replace value in it.
//    }
}
