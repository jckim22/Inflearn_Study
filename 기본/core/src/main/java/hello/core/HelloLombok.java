package hello.core;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args){
        HelloLombok hl = new HelloLombok();
        hl.setAge(123);
        hl.setName("sdafasdf");
        System.out.println(hl.getAge());
        System.out.println(hl.toString());
    }
}
