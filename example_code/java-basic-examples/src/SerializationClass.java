import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class SerializationClass implements Serializable {
    private String name;

    class InnerClass implements Serializable {
        protected String innerName;

    }



    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
       doSomething();
    }

    public void doSomething() {

    }
}
