import java.util.ArrayList;

public class Students {
String firstName;
String lastName;
String groupNumber;
ArrayList<String> subjects;
ArrayList<Integer> marks;
double average;

    public Students(String firstName, String lastName, String groupNumber, ArrayList<String> subjects, ArrayList<Integer> marks, double average) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.groupNumber = groupNumber;
        this.subjects = new ArrayList<>(subjects);
        this.marks = new ArrayList<>(marks);
        this.average = average;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public String getSubjectsWithMarks() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < this.subjects.size(); i++) {
            stringBuilder.append(subjects.get(i))
                    .append(" (")
                    .append(marks.get(i).toString())
                    .append("), ");
        }

        return stringBuilder.toString();
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {

        return getFirstName() +
                " " +
                getLastName() +
                ", group: " +
                getGroupNumber() +
                "\n\t" +
                getSubjectsWithMarks() +
                "average: " +
                getAverage();
    }
}
