package Principles;

public class LiskovSubstitutionPrinciple {
    /*
     * Liskov Substitution Principle
     *
     * 里氏替换原则（LSP）：
     * 继承必须确保超类所拥有的性质在子类中仍然成立
     * （Inheritance should ensure that any property proved about supertype objects also holds for subtype objects）。
     * 里氏替换原则是继承复用的基础，它反映了基类与子类之间的关系，是对开闭原则的补充，是对实现抽象化的具体步骤的规范。
     * 里氏替换原则通俗来讲就是：子类可以扩展父类的功能，但不能改变父类原有的功能。也就是说：子类继承父类时，除添加新的方法完成新增功能外，尽量不要重写父类的方法。
     *
     * 对里氏替换原则的定义可以总结如下：
     * 子类可以实现父类的抽象方法，但不能覆盖父类的非抽象方法
     * 子类中可以增加自己特有的方法
     * 当子类的方法重载父类的方法时，方法的前置条件（即方法的输入参数）要比父类的方法更宽松
     * 当子类的方法实现父类的方法时（重写/重载或实现抽象方法），方法的后置条件（即方法的的输出/返回值）要比父类的方法更严格或相等
     */

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 1);
        Square square = new Square(1, 1);

        Test test = new Test();


        // 我们发现父类resize可以得到正确的结果，但是子类resize就会陷入死循环导致程序崩溃，这就是违背了里氏替换原则
        // 这里如果要修正这个问题，需要将正方形和长方形设计成两个不同的类，而不是采用继承

        test.resize(rectangle);
        test.printRectangle(rectangle);

        test.resize(square);
        test.printRectangle(square);
    }

}

class Rectangle {
    private int length;
    private int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}

class Square extends Rectangle {
    public Square(int length, int width) {
        super(length, width);
    }
    public void setLength(int length) {
        super.setLength(length);
        super.setWidth(length);
    }
    public void setWidth(int width) {
        super.setLength(width);
        super.setWidth(width);
    }
}

class Test{
    // 我希望，如果长方形的长比宽长，就给长方形的宽++，直到长小于宽
    void resize(Rectangle rectangle) {
        while (rectangle.getLength() >= rectangle.getWidth()) {
            System.out.println("resize rectangle: " + "length " + rectangle.getLength() + " width " + rectangle.getWidth() + " width++");
            rectangle.setWidth(rectangle.getWidth() + 1);

            // 这里为了方便观察输出，强行中断循环
            if (rectangle.getWidth() > 10) {
                break;
            }
        }
    }
    void printRectangle(Rectangle rectangle) {
        System.out.println("rectangle: " + "length " + rectangle.getLength() + " width " + rectangle.getWidth() + "\n");
    }
}