
abstract class Bank{  
abstract void getBalance();
}   
class A extends Bank{  
    @Override
    void getBalance(){
        System.out.println("$100");
    }
}
class B extends Bank{  
    @Override
    void getBalance(){
        System.out.println("$150");
    }
}  
class C extends Bank{  
   @Override
    void getBalance(){
        System.out.println("$200");
    }
} 
class bank2{  
public static void main(String args[]){  
A a = new A();  
B b = new B();  
C c = new C(); 
a.getBalance();
b.getBalance();
c.getBalance();  
}  
}  