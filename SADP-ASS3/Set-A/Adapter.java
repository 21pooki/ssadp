import java.util.*;

// Adapter: Enumeration -> Iterator
class EnumerationIteratorAdapter<T> implements Iterator<T> {
    private Enumeration<T> enumeration;

    public EnumerationIteratorAdapter(Enumeration<T> enumeration) {
        this.enumeration = enumeration;
    }

    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    public T next() {
        return enumeration.nextElement();
    }
}

class Adapter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter elements separated by space: ");
        String line = sc.nextLine();

        // Split input into words and store in Vector
        String[] elements = line.split(" ");
        Arrays.sort(elements); // Sort elements alphabetically
        Vector<String> v = new Vector<>(Arrays.asList(elements));

        // Adapt Enumeration to Iterator
        Iterator<String> it = new EnumerationIteratorAdapter<>(v.elements());

        System.out.println("\nIterating elements in sorted order:");
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        sc.close();
    }
}
