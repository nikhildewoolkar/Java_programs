class Rectangle
{
int l,b;
Rectangle(int l,int b)
{
    this.l=l;
    this.b=b;
}
void area()
{
    System.out.println("area rect:-"+l*b);
}

void peri()
{
    System.out.println("peri rect:-"+2*(l+b));
}

}
class Square extends Rectangle
{
    int s;
    Square(int s)
    {
        super(s,s);
        this.s=s;
    }
    void area()
    {
        super.area();
        System.out.println("area square:-"+s*s);
    }
    void peri()
    {   super.peri();
        System.out.println("peri square:-"+4*s);
    }
}
class areaperi
{
    public static void main(String args[]){
        Square[] oclass Rectangle
{
int l,b;
Rectangle(int l,int b)
{
    this.l=l;
    this.b=b;
}
void area()
{
    System.out.println("area rect:-"+l*b);
}

void peri()
{
    System.out.println("peri rect:-"+2*(l+b));
}

}
class Square extends Rectangle
{
    int s;
    Square(int s)
    {
        super(s,s);
        this.s=s;
    }
    void area()
    {
        super.area();
        System.out.println("area square:-"+s*s);
    }
    void peri()
    {   super.peri();
        System.out.println("peri square:-"+4*s);
    }
}
class areaperi
{
    public static void main(String args[]){
        Square[] o=new Square[10];
        for(int i=0;i<10;i++)
        {
            o[i]=new Square(i+1);
            o[i].area();
            o[i].peri();
        }
        Rectangle f= new Rectangle(10,20);
        f.area();
        f.peri();
    }
}

        for(int i=0;i<10;i++)
        {
            o[i]=new Square1(i+);
            o[i].area();
            o[i].peri();
        }
        Rectangle f= new Rectangle(10,20);
        f.area();
        f.peri();
    }
}
