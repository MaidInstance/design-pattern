package Principles;

public class OpenClosePrinciple {
    /*
     * Open Close Principle
     * 开闭原则（Open Closed Principle，OCP）：软件实体应当对扩展开放，对修改关闭
     * （Software entities should be open for extension，but closed for modification）
     * 实现方法： 通过“抽象约束、封装变化”来实现开闭原则，
     * 即通过接口或者抽象类为软件实体定义一个相对稳定的抽象层，而将相同的可变因素封装在相同的具体实现类中。
     */

    // 这里是实际调用的代码
    // 对于皮肤的修改，我们只需要创建一个新的皮肤类来继承原来的抽象类，然后在调用的时候传入新的皮肤类即可，而不需要修改原来的皮肤类
    // 所以，当对扩展开放，对修改关闭
    public static void main(String[] args) {
        Editor editor = new Editor();
        editor.setSkin(new SummerSkin());
        editor.display();
        editor.setSkin(new WinterSkin());
        editor.display();
    }

}

class Editor{
    private AbstractSkin skin;

    public void setSkin(AbstractSkin skin){
        this.skin = skin;
    }

    public void display(){
        skin.display();
    }
}


abstract class AbstractSkin{
    public abstract void display();
}

class SummerSkin extends AbstractSkin{
    public void display(){
        System.out.println("Summer Skin");
    }
}

class WinterSkin extends AbstractSkin{
    public void display(){
        System.out.println("Winter Skin");
    }
}