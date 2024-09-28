public class NeoVector<T> {
  private T[] data;
  private int size;

  public NeoVector() {
    data = (T[]) new Object[0];
  }

  public boolean empty() {
    return size == 0;
  }

  public int size() {
    return this.size;
  }

  public int capacity() {
    return data.length;
  }

  public void reserve(int capacity) {
    if (size >= capacity) {
      return;
    }

    T[] neoData = (T[]) new Object[capacity];
    for (int i = 0; i != size; ++i) {
      neoData[i] = this.data[i];
    }
    this.data = neoData;
  }

  public void pushBack(T t) {
    if (size == data.length) {
      reserve(data.length == 0 ? 1 : 2 * data.length);
    }

    this.data[size++] = t;
  }

  public void popBack() {
    --size;
  }

  public T at(int index) {
    return this.data[index];
  }

  public void setAt(int index, T t) {
    this.data[index] = t;
  }

  public T back() {
    return this.data[size - 1];
  }
}

