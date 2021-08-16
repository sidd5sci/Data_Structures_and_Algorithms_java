package examples;

public class MySingleton {

    // static variable s of type Singleton
    private static MySingleton s = null;

    // variable of type String
    public String str;

    //private constructor of the Singleton class that restricted to this class itself
    private MySingleton()
    {
        str = "it is an example of singleton class.";
    }

    //static method to create an instance of the Singleton class
    // we can also create a method with the same name as the class name
    public static MySingleton getInstance()
    {
        //lazy initialization
        if (s== null)
            s = new MySingleton();
        return s;
    }

}


class MyMain{

    public static void main(String args[]){

        // instantiating Singleton class with variable a
        MySingleton a = MySingleton.getInstance();

        // instantiating Singleton class with variable b
        MySingleton b = MySingleton.getInstance();

        // instantiating Singleton class with variable c
        MySingleton c = MySingleton.getInstance();

        // changing variable of instance a
        a.str = (a.str).toUpperCase();

        System.out.println("String from a is " + a.str);
        System.out.println("String from b is " + b.str);
        System.out.println("String from c is " + c.str);
    }

}