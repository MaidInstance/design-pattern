package Principles;

interface CPU{
    void run();
}


interface GPU{
    void run();
}

public class DependenceInversionPrinciple {
    /*
     * Dependence Inversion Principle
     * 依赖倒置原则（Dependence Inversion Principle，DIP）：
     * 高层模块不应该依赖低层模块，两者都应该依赖其抽象；抽象不应该依赖细节，细节应该依赖抽象
     * High-level modules should not depend upon low-level modules. Both should depend upon abstractions.
     * Abstractions should not depend upon details. Details should depend upon abstractions.
     *
     * 核心思想是：要面向接口编程，不要面向实现编程, 降低类间的耦合性
     *
     * 依赖倒置原则的主要作用如下:
     * 依赖倒置原则可以降低类间的耦合性。
     * 依赖倒置原则可以提高系统的稳定性。
     * 依赖倒置原则可以减少并行开发引起的风险。
     * 依赖倒置原则可以提高代码的可读性和可维护性。
     *
     * 依赖倒置原则的实现方法:
     * 每个类尽量提供接口或抽象类，或者两者都具备。
     * 变量的声明类型尽量是接口或者是抽象类。
     * 任何类都不应该从具体类派生。
     * 使用继承时尽量遵循里氏替换原则。
     */

    // 对于一台电脑来说，它需要一个CPU和一个GPU来运行，但是CPU和GPU的品牌是不确定的，所以我们需要一个接口来抽象出CPU和GPU
    // 如果我们将具体的CPU和GPU品牌类的实现类直接注入到电脑中，那么电脑的代码就会变得非常复杂，
    // 而且如果CPU和GPU的品牌发生变化，那么电脑的代码也需要修改
    // 所以我们要使用依赖倒置原则来解决这个问题
    public static void main(String[] args) {
        Computer computer = new Computer(new IntelCPU(), new IntelGPU());
        computer.run();

        Computer computer2 = new Computer(new AmdCPU(), new NvidiaGPU());
        computer2.run();
    }

}

class Computer{
    private final CPU cpu;
    private final GPU gpu;
    public Computer(CPU cpu, GPU gpu){
        this.cpu = cpu;
        this.gpu = gpu;
    }
    public void run(){
        cpu.run();
        gpu.run();
    }
}

class IntelCPU implements CPU{
    public void run(){
        System.out.println("Intel CPU is running");
    }
}
class IntelGPU implements GPU{
    public void run(){
        System.out.println("Intel GPU is running");
    }
}
class AmdCPU implements CPU{
    public void run(){
        System.out.println("Amd CPU is running");
    }
}
class NvidiaGPU implements GPU{
    public void run(){
        System.out.println("Nvidia GPU is running");
    }
}