public class HeroCodeDemo {
    //查询单链表中有效节点的个数(不带头结点)
    public static int getLength(HeroCode head) {
        if(head.next == null) {
            return 0;
        }
        int count =0;
        HeroCode cur = head;
        while(cur!=null) {
            count++;
            cur = cur.next;
        }
        return count-1;
    }
    //查找单链表中的倒数第k个节点
    public static HeroCode findLastIndexNode (HeroCode head ,int index) {
        //判断头结点是否为空
        if(head.next == null) {
            System.out.println("该链表暂时没有存放数据");
            return head;
        }
        int data = getLength(head);
        HeroCode cur = head;
        if(index > data&& index<=0) {
            System.out.println("超出链表长度");
            return head;
        }
        for (int i = 0; i < data-index+1; i++) {
            cur = cur.next;
        }
        return  cur;
    }
    public static void main(String[] args) {
        SingleLickedList singleLickedList = new SingleLickedList();
        singleLickedList.addByOrder(new HeroCode(1,"宋江","及时雨"));
        singleLickedList.addByOrder(new HeroCode(3,"吴用","智多星"));
        singleLickedList.addByOrder(new HeroCode(2,"卢俊义","玉麒麟"));
        singleLickedList.addByOrder(new HeroCode(4,"林冲","豹子头"));
        singleLickedList.showList();
        //获得链表有效长度
        int data = getLength(singleLickedList.getHead());
        HeroCode heroCode = findLastIndexNode(singleLickedList.getHead(),4);
        System.out.println(heroCode+"我在这里");
        System.out.println("该链表有"+data+"个数据");
        //singleLickedList.updateList(new HeroCode(3,"没用","智多星"));
        //删除数据
        singleLickedList.delList(1);
        singleLickedList.delList(4);
        singleLickedList.showList();

    }
}
//定义一个SingleLickedList用来管理英雄
//这种思路还是不太熟悉,要多练练
class SingleLickedList{
    //初始化一个头结点,不添加具体的数据
    private HeroCode head = new HeroCode(0,"","");

    public HeroCode getHead() {
        return head;
    }

    public void setHead(HeroCode head) {
        this.head = head;
    }

    //添加新节点到链表的尾部
    public void add(HeroCode heroCode) {
        HeroCode cur = head;
        //遍历链表,找到最后
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = heroCode;
    }
    public void addByOrder(HeroCode heroCode) {
        //链表没有数据
        if(head.next==null) {
            head.next = heroCode;
            return;
        }
        //链表有数据
        HeroCode prev = head;
        HeroCode cur = head.next;
        while(prev.next!=null) {
            if(cur.getId()>heroCode.getId()) {
                heroCode.next = cur;
                prev.next = heroCode;
                return;
            }
            if (cur.getId()==heroCode.getId()) {
                throw new RuntimeException("添加信息错误,请确认消息");
            }
            cur = cur.next;
            prev = prev.next;
        }
        //尾插
        prev.next = heroCode;
    }
    //按照修改节点的信息
    public void updateList(HeroCode heroCode ) {
        if(head.next==null) {
            System.out.println("链表为空");
            return;
        }
        HeroCode cur = head.next;
        //定义一个变量值
        boolean flag = false;
        while(true) {
            if(cur == null) {
                break;
            }
            if(cur.getId() == heroCode.getId()) {
                //找到了
                flag = true;
                break;
            }
            cur = cur.next;
        }
        if(flag){
            cur.setId(heroCode.getId());
            cur.setName(heroCode.getName());
            cur.setNickName(heroCode.getNickName());
        }else {
            //没有找到,正常结束
            //System.out.println("该链表没有该条数据");这种写法不用好
            System.out.printf("该链表中没有id为%d的这条消息\n",heroCode.getId());
            return;
        }
    }
    //删除节点
    public void delList (int id) {
        if(head.next==null) {
            System.out.println("当前链表为空");
            return;
        }
        HeroCode cur = head;
        while(cur.next!=null) {
             if (cur.next.getId()==id) {

                     cur.next = cur.next.next;
                 return;
             }
             cur = cur.next;
        }
        System.out.printf("当前链表中没有id为%d的数据\n",id);
    }
    public void showList() {
        //判断链表是否为空,及head==null
        if(head==null) {
            System.out.println("链表为空");
            return;
        }
        HeroCode cur = head.next;
        while(cur!=null) {
            System.out.println(cur.toString());
            cur = cur.next;
        }
    }
}
//定义HerCode,创建一个节点
class HeroCode{
    private int id;
    private String name;
    private String nickName;
    HeroCode next;//指向下个节点
    //创建一个新节点

    public HeroCode(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public HeroCode getNext() {
        return next;
    }

    public void setNext(HeroCode next) {
        this.next = next;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HeroCode{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
