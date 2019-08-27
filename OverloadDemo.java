class OverloadDemo
{
    void add()
    {
        System.out.println("Overloading Methods");
    }

    void add(int a , int b)
    {
        System.out.println("The addition is:" + (a+b));
    }

    void add(double a)
    {
        System.out.println("The addition is :"+(a+a));
    }

    void add(String a, String b)
    {
        System.out.println("The Addition is :"+ (a+b));
    }

    public static void main(String [] args) {

        OverloadDemo d1 = new OverloadDemo();
        d1.add();
        d1.add(10,20);
        d1.add(10);
        d1.add("Hello","java");
        
    }
}