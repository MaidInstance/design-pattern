package Principles;

public class LawOfDemeter {
    /*
     * Law of Demeter
     * 迪米特法则（Law of Demeter，LoD）又叫作最少知识原则（Least Knowledge Principle，LKP)
     *
     * 只与你的直接朋友交谈，不跟“陌生人”说话
     * Talk only to your immediate friends and not to strangers
     *
     * 其含义是：如果两个软件实体无须直接通信，那么就不应当发生直接的相互调用，可以通过第三方转发该调用。
     * 其目的是降低类之间的耦合度，提高模块的相对独立性。
     *
     * 迪米特法则中的“朋友”是指：
     * 当前对象本身、当前对象的成员对象、当前对象所创建的对象、当前对象的方法参数等，
     * 这些对象同当前对象存在关联、聚合或组合关系，可以直接访问这些对象的方法。
     */

    /* 情景
     * 我是新艾利都住在六分街的传奇绳匠 法厄同，目前号被盗了，开创新账号 秦始皇
     * 我现在要去进行空洞探索，因此我联系了狡兔屋，我不需要直接接触代理人，我只需要与狡兔屋的妮可老大联系就好
     */
    public static void main(String[] args) {
        Group group = new Group("狡兔屋的妮可老大");
        // 假设妮可老大为我安排了比利来执行任务
        group.cooperate(new Proxy("秦始皇"), new Agent("比利"));
        group.view();
    }

}

// 代理人
class Agent{
    private final String name;
    public Agent(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}


// 绳匠
class Proxy{
    private final String name;
    public Proxy(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }
}

// 代理人所在的群体
class Group{
    private final String name;
    private Agent agent;
    private Proxy proxy;

    public Group(String name){
        this.name = name;
    }

    public void cooperate(Proxy proxy, Agent agent){
        this.agent = agent;
        this.proxy = proxy;
    }

    public void view(){
        System.out.println("我是" + name + "，我的代理人" + agent.getName() + "和与绳匠" + proxy.getName() + "达成合作");
    }
}