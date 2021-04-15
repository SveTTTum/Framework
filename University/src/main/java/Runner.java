public class Runner {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.getDiary().addSubjectMark("Math", new Integer[]{5, 7, 9, 7});
        student1.getDiary().addSubjectMark("Physics", new Integer[]{8, 8, 9, 8});
        student1.getDiary().addSubjectMark("Informatics", new Integer[]{6, 8, 7, 8});
        Student student2 = new Student();
        student2.getDiary().addSubjectMark("Math", new Integer[]{5, 7, 9, 7});
        student2.getDiary().addSubjectMark("Physics", new Integer[]{4, 6, 9, 7});
        student2.getDiary().addSubjectMark("Informatics", new Integer[]{5, 8, 7, 6});

        System.out.println(student1.getDiary());
        System.out.println(student2.getDiary());
        System.out.println("Средний бал студента1:  " + student1.getDiary().MiddleMarks());
        System.out.println("Средний бал студента2:  " + student2.getDiary().MiddleMarks());
    }
}