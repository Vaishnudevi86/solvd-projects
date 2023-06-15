package buildingcompany;

class GenericNode<T> {
    // Stores data of the node
    T data;
    // Store address of the node
    GenericNode<T> next;

    // Constructor
    GenericNode(T data) {
        this.data = data;
        this.next = null;
    }
}

class GenericList<T> {
    // Head of the node
    GenericNode<T> head;

    private int len = 0;

    //constructor
    GenericList() {
        this.head = null;
    }

    // Method addNode(T data): This method adds a new element at the end
    void addNode(T data) {
        // Creating a new generic node
        GenericNode<T> temp = new GenericNode<>(data);
        if (this.head == null) {
            head = temp;
        } else {
            GenericNode<T> genericNode = head;
            // Iterate the List
            while (genericNode.next != null) {
                genericNode = genericNode.next;
            }
            genericNode.next = temp;
        }
        // Increase the len after adding new node
        len++;
    }

    void addNode(int pos, T data) {
        // Check position if its valid or not
        if (pos > len + 1) {
            System.out.println("Position not found");
            return;
        }
        // if new node is to be added in the beginning
        if (pos == 1) {
            GenericNode<T> temp = head;
            head = new GenericNode<T>(data);
            head.next = temp;
            len++;
            return;
        }
        // Temporary node to store previous head
        GenericNode<T> temp = head;
        GenericNode<T> prev = new GenericNode<T>(null);
        // Interating
        while (pos - 1 > 0) {
            prev = temp;
            temp = temp.next;
            pos--;
        }
        prev.next = new GenericNode<T>(data);
        prev.next.next = temp;
        len++;
    }

    // Method removeNode(T key): It will remove a node from the LinkedList
    void removeNode(T key) {
        GenericNode<T> prev = new GenericNode<>(null);
        prev.next = head;
        GenericNode<T> next = head.next;
        GenericNode<T> temp = head;
        // This will check whether the value is present or not
        boolean exists = false;
        if (head.data == key) {
            head = head.next;
            // Node is present which we will want to remove
            exists = true;
        }
        while (temp.next != null) {
            // Convert the value to be compared to string
            if (String.valueOf(temp.data).equals(String.valueOf(key))) {
                prev.next = next;
                exists = true;
                break;
            }
            prev = temp;
            temp = temp.next;
            next = temp.next;
        }
        if (exists == false && String.valueOf(temp.data).equals(String.valueOf(key))) {
            prev.next = null;
            exists = true;
        }
        // When the node which we want to delete exists
        if (exists) {
            // reduce the len of linked list
            len--;
        }
        // If it does not exist
        else {
            System.out.println("Not found in linked list");
        }
    }

    // Method clearList(): It will clear the Linked List
    void clearList() {
        head = null;
        len = 0;
    }

    // Method isEmpty(): It will check whether a list is empty or not
    boolean isEmpty() {
        if (head == null) {
            return true;
        }
        return false;
    }

    // Method length(): It will return the length of the linked list
    int length() {
        return this.len;
    }

    public String toString() {
        String S = "{";
        GenericNode<T> X = head;
        if (X == null)
            return S + "}";
        while (X.next != null) {
            S += String.valueOf(X.data) + "->";
            X = X.next;
        }
        S += String.valueOf(X.data);
        return S + "}";
    }
}

