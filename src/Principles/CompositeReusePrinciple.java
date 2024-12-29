package Principles;

public class CompositeReusePrinciple {
    /*
     * Composite Reuse Principle
     * 合成复用原则（Composite Reuse Principle，CRP）又叫组合/聚合复用原则（Composition/Aggregate Reuse Principle，CARP）。
     * 它要求在软件复用时，要尽量先使用组合或者聚合等关联关系来实现，其次才考虑使用继承关系来实现。
     * 如果要使用继承关系，则必须严格遵循里氏替换原则。合成复用原则同里氏替换原则相辅相成的，两者都是开闭原则的具体实现规范。
     *
     * 如果有一辆车，它有颜色和运作方式，比如车可以是白色或者黑色的，运作方式可以是燃油车、电车
     * 如果我们建立一个基类，只有车本身，在子类加上颜色和运作方式，我们就会有两个子类，如果子类再次继承子类，就会一直扩展下去
     * 比如 白色的燃油车、黑色的燃油车、白色的电车、黑色的电车，更可怕的是，如果我们加入新的属性，比如运行方式是油电混合类型
     * 那么就会多出白色的油电混合车、黑色的油电混合车，这样就会出现很多子类，而且如果我们要修改车的颜色，那么就会出现很多子类的修改‘
     *
     * 聪明的你一定想到了，为什么不把车的颜色和运作方式作为属性呢？
     * 这样就可以避免子类的扩展，而且如果我们要修改车的颜色，只需要修改车的颜色就可以了
     *
     * 没错，这就是合成复用原则
     *
     * 我们可以新建一个类是颜色类，另外一个是运作方式类，然后把车的颜色和运作方式作为属性，这样就可以避免子类的扩展
     *
     * 所以合成复用原则要求：在软件复用时，要尽量先使用组合或者聚合等关联关系来实现，其次才考虑使用继承关系来实现。
     */

    // 太懒了不写代码了，理解思想就好

}
