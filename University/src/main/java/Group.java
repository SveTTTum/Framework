
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Group {
    private String nameGroup;
    private List<Student> students;

    public Group(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public String getNameGroup() {
        return nameGroup;

    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;

    }

    public ArrayList getMarksForGroup(String nameSubject) {
        if (nameGroup.isEmpty()) {
            throw new NullPointerException("No Students added\n");
        } else {
            ArrayList<Integer> marks = new ArrayList<>();
            for (Student student : students) {
                marks.addAll(student.getMarks(nameSubject));
            }
            return marks;
        }
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    @Override
    public String toString() {
        return "Group{" +
                "nameGroup='" + nameGroup + '\'' +
                ", students=" + students +
                '}';
    }

}
