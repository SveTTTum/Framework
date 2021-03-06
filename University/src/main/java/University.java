import exceptions.EmptyFacultyException;
import exceptions.LackOfMarksExceptions;
import exceptions.SomeExceptions;

import java.util.ArrayList;
import java.util.List;

public class University {
    private List<Faculty> faculties;

    public University() {
        this.faculties = new ArrayList<>();
    }

    public University(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    float getAverageMarksForAllFaculties (Subjects nameSubject) throws SomeExceptions, LackOfMarksExceptions, EmptyFacultyException {
        if (faculties.isEmpty()) {
            throw new EmptyFacultyException("No Faculties added to the University");
        }
        int sum = 0;
        float counter = 0;

        for (Faculty faculty : faculties) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {

                    for (int mark : student.getMarks(nameSubject)) {
                        sum += mark;
                        counter++;
                    }
                }
            }
        }
        if (counter == 0) {
            throw new LackOfMarksExceptions("Division by zero! " + faculties + " has no marks in the " + nameSubject);
        }
        return (float) sum / counter;
    }
}
