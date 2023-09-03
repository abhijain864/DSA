import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.Data;

public class DeepCopyShallowCopy {

    public static void main(String[] args) {
        Student s = new Student("s");
        Student copy = s;
        copy.setName("cpy");
        System.out.println(s.name);
        System.out.println(s);
    }

    public static class Student{
        String name;

        Student() {}

        Student(String  name){
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
