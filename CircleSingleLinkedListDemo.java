package CircleSingleLinkedListDemo;

public class CircleSingleLinkedListDemo {
    public static void main(String[] args) {
        CircleSingleLinked circleSingleLinked = new CircleSingleLinked();
        // 修改为添加 10 个小孩
        circleSingleLinked.addBoy(10);
        circleSingleLinked.showBoy();
        // 修改为从第 3 个小孩开始，每数到第 3 个小孩出圈
        circleSingleLinked.countBoy(3, 3, 10);
    }
}

class CircleSingleLinked {
    // 创建一个环形的单向链表
    // 创建第一个节点
    private Boy first = null;

    // 添加 boy
    public void addBoy(int nums) {
        if (nums <= 0) {
            System.out.println("输入数据错误");
            return;
        }
        // 使用循环
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            // 根据编号创建小孩节点
            Boy newBoy = new Boy(i);
            if (i == 1) {
                first = newBoy;
                first.setNext(first); // 注意写法
                curBoy = first;
            } else {
                curBoy.setNext(newBoy);
                newBoy.setNext(first);
                // cur 是用来标记的注意
                curBoy = newBoy;
            }
        }
    }

    // 遍历当前链表的全部节点
    public void showBoy() {
        // 判断是不是空链表
        if (first == null) {
            System.out.println("该链表为空");
            return;
        }
        Boy cur = first;
        do {
            System.out.println(cur);
            cur = cur.getNext();
        } while (cur != first);
    }

    // 根据用户的输入,计算小孩的出圈顺序
    public void countBoy(int startId, int countNum, int nums) {
        // 先对数据校验
        if (first == null || startId < 1 || startId > nums) {
            System.out.println("参数输入有误,请重新输入");
            return;
        }
        // 让 cur 指向 startId 对应的节点
        Boy cur = first;
        for (int i = 1; i < startId; i++) {
            cur = cur.getNext();
        }
        // 找到 cur 的前一个节点
        Boy prev = first;
        while (prev.getNext() != cur) {
            prev = prev.getNext();
        }
        while (cur != prev) {
            // 让两个指针同时移动 countNum - 1 步
            for (int i = 0; i < countNum - 1; i++) {
                cur = cur.getNext();
                prev = prev.getNext();
            }
            // 删除数据
            int data = cur.getId();
            cur = cur.getNext();
            prev.setNext(cur);
            System.out.println("成功删除 ID 为" + data + "的 boy");
        }
        System.out.println("最后剩下的 boy 的 ID 为" + cur.getId());
    }
}

class Boy {
    private int id;
    private Boy next;

    public Boy(int id) {
        this.id = id;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy getNext() {
        return next;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Boy{" +
                "id=" + id +
                '}';
    }
}