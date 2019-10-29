class d_set_node{
    int data;
    d_set_node parent;
    d_set_node(int data){
        this.data=data;
        parent=null;
    }

    public d_set_node getroot() {
        if(parent==null)
            return this;
        else
           return  parent.getroot();
    }
}
class disjoint_set{
    d_set_node[] d;
    int size;
    disjoint_set(int size){
        this.size=size;
        d=new d_set_node[size];
    }
    public void union(int l1,int l2){
        d_set_node root1=find(l1);
        d_set_node root2=find(l2);
        if(root1!=root2){
            root2.parent=root1;
        }
    }
    public d_set_node find(int data){
        return d[data].getroot();
    }
    public void make_set(int index){
      d[index]=new d_set_node(index);
    }
    public void print(){
        for(int i=0;i<size;i++){
            System.out.print("  ( "+i+" , "+d[i].data+" )");
        }
        System.out.println("");
    }
}
public class d_set {
    public static void main(String[] args){
        disjoint_set d = new disjoint_set(10);
        for (int i=0; i<10; i++)
            d.make_set(i);
        d.print();  // prints (0,0) (1,1) (2,2) (3,3) (4,4) (5,5) (6,6) (7,7) (8,8) (9,9)
        d.union(0,1);
        d.union(1,3);
        d.print();  // prints (0,0) (1,0) (2,0) (3,3) (4,4) (5,5) (6,6) (7,7) (8,8) (9,9)
    }
}
