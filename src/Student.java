public class Student {
  private String name;
  private int age;
  private NeoVector<Integer> courseGrade = new NeoVector<Integer>();
  private NeoVector<String> courseName = new NeoVector<String>();

  public Student(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public void addCourse(String course, int grade) {
    courseGrade.pushBack(grade);
    courseName.pushBack(course);
  }

  public String toString() {
    String s = "name: " + name + ", age: " + age + ", joined courses: ";
    for (int i = 0; i != courseGrade.size(); ++i) {
      s += courseName.at(i) + ": " + courseGrade.at(i) + ", ";
    }
    if (courseGrade.empty()) {
      s += "none";
    }
    return s;
  }
}
