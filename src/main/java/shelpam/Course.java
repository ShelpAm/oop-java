public class Course {
  private NeoVector<Student> students = new NeoVector<Student>();

  public void append(Student s) {
    students.pushBack(s);
  }

  public String toString() {
    String s = "Students:\n";
    for (int i = 0; i != students.size(); ++i) {
      s += students.at(i).toString() + '\n';
    }
    if (students.empty()) {
      s += "none";
    }
    return s;
  }
}
