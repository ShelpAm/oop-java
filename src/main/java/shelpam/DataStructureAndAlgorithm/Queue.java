public class Queue<T> {
  private NeoVector<T> vector = new NeoVector<T>();
  private int front;
  private int rear;
  private boolean empty = true;

  public Queue(int capacity) {
    vector.reserve(capacity);
  }

  public boolean empty() {
    return this.empty;
  }

  public void push(T t) {
    vector.setAt(rear++, t);
    rear %= vector.capacity();
    empty = false;
  }

  public T pop() {
    T ele = vector.at(front++);
    front %= vector.capacity();
    if (front == rear) {
      empty = true;
    }
    return ele;
  }
}
