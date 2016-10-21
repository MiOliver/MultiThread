package com.oliver.algorithm;

/**
 * Created by ning on 10/20/16.
 */
public class LinklistTest {

    private Linknode linknode=null;

    public Linknode initList(Linknode head){

        if(head==null){
            head=new Linknode(0);
        }
        Linknode pre=head;
        for(int i=1;i<10;i++){
            Linknode node=new Linknode(i);
            node.next=null;
            pre.next=node;
            pre=pre.next;
        }
        return head;
    }


    public void printLinkList(Linknode head){
        Linknode node=head;
        while (node!=null){
            System.out.println("node value is:"+node.getValue());
            node=node.next;
        }
    }

    public Linknode revverse(Linknode head){

        Linknode pre=null;
        Linknode cur=head;
        Linknode next=head.next;

        while (next!=null){
            cur.next=pre;
            pre=cur;
            cur=next;
            next=next.next;
        }

        cur.next = pre;
        return cur;
    }

    Linknode reverseList(Linknode head)
    {
        //如果链表为空或者链表中只有一个元素
        if(head == null || head.next == null)
        {
            return head;
        }
        else
        {
            //先反转后面的链表，走到链表的末端结点
            Linknode newhead = reverseList(head.next);
            //再将当前节点设置为后面节点的后续节点
            head.next.next = head;
            head.next = null;
            return newhead;
        }
    }

    public static void main(String[] args){
        LinklistTest test=new LinklistTest();
        Linknode head=test.initList(test.linknode);
        test.printLinkList(head);
        System.out.println("reverse");
//        head=test.revverse(head);
        head=test.reverseList(head);
        test.printLinkList(head);
    }


}
