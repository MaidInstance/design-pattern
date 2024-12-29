package Principles;

public class InterfaceSegregationPrinciple {
    /*
     * 1.2.5. 接口隔离原则
     * 接口隔离原则（Interface Segregation Principle，ISP）
     * 要求程序员尽量将臃肿庞大的接口拆分成更小的和更具体的接口，让接口中只包含客户感兴趣的方法。
     *
     * 客户端不应该被迫依赖于它不使用的方法
     * Clients should not be forced to depend on methods they do not use
     * 一个类对另一个类的依赖应该建立在最小的接口上
     * The dependency of one class to another one should depend on the smallest possible interface
     */

    public static void main(String[] args) {
        // JavaTeacher 和 WorkerCanCode 都实现了部分接口，而不是一个接口什么功能都存在，让实现者被迫继承不需要的接口
        JavaTeacher javaTeacher = new JavaTeacher();
        WorkerCanCode workerCanCode = new WorkerCanCode();

        javaTeacher.code();
        javaTeacher.teach();
        workerCanCode.code();
        workerCanCode.work();


    }
}


interface Coder {
    void code();
}

interface Teacher {
    void teach();
}

interface Worker {
    void work();
}

class JavaTeacher implements Coder, Teacher{
    @Override
    public void code() {
        System.out.println("JavaTeacher is coding");
    }
    @Override
    public void teach() {
        System.out.println("JavaTeacher is teaching");
    }
}

class WorkerCanCode implements Coder, Worker{
    @Override
    public void code() {
        System.out.println("WorkerCanCode is coding");
    }

    @Override
    public void work() {
        System.out.println("WorkerCanCode is working");
    }

}