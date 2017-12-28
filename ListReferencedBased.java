import java.util.Stack;


public class ListReferencedBased implements ListInterface
{

    // reference to linked list of items

    private Node head;


    // definitions of constructors and methods

    public ListReferencedBased()
    {
        head = null;
    }  // end default constructor

    public boolean isEmpty()
    {
        return (head == null);
    }

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
    } // end size


    private Node find(int index)
    {
        //———————————————————
        // Locates a specified node in a linked list.
        // Precondition:  index is the number of the desired
        //  node.  Assumes that 1 <= index <= numItems+1
        // Post-condition:  Returns a reference to the desired
        //  node.
        //———————————————————

        Node curr = head;
        for (int skip = 0;  skip < index;  skip++)
        {
            curr = curr.next;
        } // end for
        return curr;
    } // end find

    @Override
    public Comparable get(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index <= size())
        {
            // get reference to node, then data in node
            Node curr = find(index);
            Comparable dataItem = curr.item;
            return dataItem;
        }
        else

        {
            throw new ListIndexOutOfBoundsException("List index out of bounds on get()");
        } // end if
    } // end get


    @Override
    public void add(int index, Comparable item) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index <= size())
        {
            if (index == 0)
            {
                // insert the new node containing item at
                // beginning of list
                Node newNode = new Node(item, head);
                head = newNode;
//                System.out.println("in add(), first node");
            }
            else
            {
                Node prev = find(index-1);

                // insert the new node containing item after
                // the node that prev references
                Node newNode = new Node(item, prev.next);
                prev.next = newNode;
//                System.out.println("in add(), other node added");
            }  // end if
        }
        else
        {
//            System.out.println("About to throw error.");
//            System.out.println("index: "+index);
//            System.out.println("size(): "+size());
            throw new ListIndexOutOfBoundsException("List index out of bounds on add()");
        } // end if
    } // end add

    @Override
    public void remove(int index) throws ListIndexOutOfBoundsException
    {
        if (index >= 0 && index < size())
        {
            if (index == 0)
            {
                // delete the first node from the list
                head = head.next;
            }
            else
            {
                Node prev = find(index-1);
                // delete the node after the node that prev
                // references, save reference to node
                Node curr = prev.next;
                prev.next = curr.next;
            } // end if
        }
        else
        {
            throw new ListIndexOutOfBoundsException("List index out of bounds on remove()");
        } // end if
    } // end remove

    @Override
    public void removeAll()
    {
        // setting head to null causes list to be
        // unreachable and thus marked for garbage
        // collection
        head = null;
    } // end removeAll

    @Override
    public boolean isSorted()
    {
        //TODO: Find out WHERE && HOW to implement compareTo using cs211s and cs111c material.
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
    }

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
    }

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
    }


}
