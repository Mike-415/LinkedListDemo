import java.util.Stack;


public class ListReferencedBased implements ListInterface
{
    private Node head;

    public ListReferencedBased()
    {
        head = null;
    }  

    public boolean isEmpty()
    {
        return (head == null);
    }//isEmpty()

    @Override
    public int size()
    {
        Node current = head;
        int counter = 0;
        if(isEmpty())
        {
            return counter;
        }
        else
        {
            if(current.next == null)
            {
                return 1;
            }
            else
            {

                while (current.next != null)
                {
                    counter++;
                    current = current.next;
                }
                counter++;
            }
        }
        return counter;
    } //size()


    
    // Locates a specified node in a linked list.
    // Precondition:  index is the number of the desired
    //  node.  Assumes that 1 <= index <= numItems+1
    // Post-condition:  Returns a reference to the desired
    //  node.
    private Node find(int index)
    {
        Node curr = head;
        for (int skip = 0;  skip < index;  skip++)
        {
            curr = curr.next;
        } // end for
        return curr;
    } //find()

    @Override
    public Comparable get(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index <= size())
        {
            Node curr = find(index);
            Comparable dataItem = curr.item;
            return dataItem;
        }
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds on get()");
        } 
    }//get()


    @Override
    public void add(int index, Comparable item) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index <= size())
        {
            if (index == 0)
            {
                Node newNode = new Node(item, head);
                head = newNode;
            }
            else
            {
                Node prev = find(index-1);
                Node newNode = new Node(item, prev.next);
                prev.next = newNode;
            }  // end if
        }
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds on add()");
        } 
    }//add()

    @Override
    public void remove(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < size())
        {
            if (index == 0)
            {
                head = head.next;
            }
            else
            {
                Node prev = find(index-1);
                Node curr = prev.next;
                prev.next = curr.next;
            }
        }
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds on remove()");
        } 
    }//remove()

    @Override
    public void removeAll()
    {
        head = null;
    }//removeAll()

    @Override
    public boolean isSorted()
    {
        boolean sortFlag = true;
        Node current = head;
        while(current.next != null)
        {
            if(current.compareTo(current.next) > 0)
            {
                sortFlag = false;
            }
            current = current.next;
        }
        return sortFlag;
    }//isSorted()

    @Override
    public void reverseList()
    {
        Stack<Node> nodeStack = new Stack<>();
        Node current = head;
        int position = 0;
        while(current.next != null)
        {
            nodeStack.push(current);
            current = current.next;
        }
        nodeStack.push(current);
        removeAll();
        while(!nodeStack.empty())
        {
            add(position, nodeStack.pop().item);
            position++;
        }
    }//reverseList()

    @Override
    public String toString()
    {
        Node current = head;
        String str = "";
        while(current.next != null)
        {
            str += current.item+" ";
            current = current.next;
        }
        str += current.item+" ";
        System.out.println("size: "+size());
        return str;
    }//toString()


}
