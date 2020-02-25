import java.util.ArrayList;

public class SortIt {

    public static void main(String[] args)
    {
        Nodes root = new Nodes();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(3);
        arr.add(5);
        arr.add(1);
        arr.add(8);
        arr.add(9);
        arr.add(6);
        arr.add(2);
        arr.add(7);
        arr.add(10);
        arr.add(4);

        System.out.println("Before:");
        for (int element : arr)
            System.out.print(element + " ");
        System.out.println();

        arr = sort(root, arr);

        System.out.println("After:");
        for (int element : arr)
            System.out.print(element + " ");
        System.out.println();
    }

    public static ArrayList<Integer> sort(Nodes root, ArrayList<Integer> list)
    {
        ArrayList<Integer> newList = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++)
        {
            insert(root, list.get(i));
        }
        newList = inOrder(root);
        return newList;
    }

    public static void insert(Nodes root, int element) {
        // Start at root of tree
        if (root.value == -12345) {
            root.value = element;
            return;
        }

        // if element < root.value, go left
        if (element < root.value) {
            if (root.leftChild == null) // if left child is null, make a new node with element
            {
                root.leftChild = new Nodes(element);
                root.leftChild.parent = root;
            }
            else // otherwise keep going to the left
            {
                insert(root.leftChild, element);
            }
        }
        else {
            if (root.rightChild == null) // if right child is null, make a new node with element
            {
                root.rightChild = new Nodes(element);
                root.rightChild.parent = root;
            }
            else // otherwise keep going to the right
            {
                insert(root.rightChild, element);
            }
        }
    }
    static ArrayList<Integer> sortedList = new ArrayList<Integer>();
    public static ArrayList<Integer> inOrder(Nodes root)
    {
        if (root == null)
            return sortedList;
        inOrder(root.leftChild);
        sortedList.add(root.value);
        //System.out.print(root.value + " ");
        inOrder(root.rightChild);
        return sortedList;
    }
}

class Nodes {
    int value;
    Nodes leftChild;
    Nodes rightChild;
    Nodes parent;

    public Nodes() {
        value = -12345;
        rightChild = null;
        leftChild = null;
        parent = null;
    }

    public Nodes(int value) {
        this.value = value;
        rightChild = null;
        leftChild = null;
    }
}
