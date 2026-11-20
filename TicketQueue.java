public class TicketQueue {
    private Customer[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public TicketQueue(int capacity) {
        this.capacity = capacity;
        queue = new Customer[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // ENQUEUE: Add customer at rear
    public boolean enqueue(Customer customer) {
        if (isFull()) {
            return false;
        }

        rear = (rear + 1) % capacity;
        queue[rear] = customer;
        size++;
        return true;
    }

    // DEQUEUE: Remove customer from front
    public Customer dequeue() {
        if (isEmpty()) {
            return null;
        }

        Customer customer = queue[front];
        queue[front] = null;
        front = (front + 1) % capacity;
        size--;

        return customer;
    }

    // PEEK: View front customer without removing
    public Customer peek() {
        if (isEmpty()) {
            return null;
        }

        return queue[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public Customer getCustomerAt(int position) {
        if (position < 0 || position >= size) {
            return null;
        }

        int index = (front + position) % capacity;
        return queue[index];
    }
}
