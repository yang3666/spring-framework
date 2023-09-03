package learning.spring.helloworld;

public class Hello {
    private String name;

    public Hello(){

    }

    public Hello(String name){
        this.name = name;
    }

    public String hello() {
        return "Hello world! by" + name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
