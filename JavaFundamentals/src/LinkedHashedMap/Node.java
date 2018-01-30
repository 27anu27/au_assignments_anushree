package LinkedHashedMap;

public class Node<K,V> {
	K key;
	V value;
	Node<K,V> next;
	Node<K,V> before, after;
	public Node(K k,V v, Node<K,V> next){
		this.key = k;
		this.value = v;
		this.next = next;
	}
}
