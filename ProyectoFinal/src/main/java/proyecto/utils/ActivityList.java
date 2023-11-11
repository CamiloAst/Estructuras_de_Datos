package proyecto.utils;

public class ActivityList <E>{
    private ActivityNode<E> firstNode;
    private ActivityNode<E> lastNode;
    private ActivityNode<E> lastNodeAdded;
    private int size;

    public ActivityList(){
        firstNode = null;
        lastNode = null;
        size = 0;
    }

    /**
     * Agrega un nuevo nodo al final de la lista
     * @param element
     */
    public void add(E element){
        ActivityNode<E> newNode = new ActivityNode<>(element);
        if(isEmpty()){
            firstNode = lastNode = newNode;
        }else{
            lastNode.setNextNode(newNode);
            newNode.setPreviousNode(lastNode);
            lastNode = newNode;

        }
        size++;
        lastNodeAdded = newNode;
    }

    /**
     * Agrega un nuevo nodo después de un nodo indicado
     * @param element
     * @param previous
     */
    public void add(E element, E previous){
        ActivityNode<E> newNode = new ActivityNode<>(element);
        ActivityNode<E> aux = searchNode(previous);
        if(aux != null){
            addLastNode(newNode, aux);
            size++;
            lastNodeAdded = newNode;
        }
    }

    /**
     * Agrega un nuevo nodo después del último nodo agregado
     * @param element
     */
    public void sequentialAdd(E element){
        ActivityNode<E> newNode = new ActivityNode<>(element);
        if(isEmpty()) {
            firstNode = lastNode = newNode;
        }else{
            addLastNode(newNode, lastNodeAdded);
        }
        size++;
        lastNodeAdded = newNode;
    }

    private void addLastNode(ActivityNode<E> newNode, ActivityNode<E> aux) {
        if(!hasNext(aux)){
            aux.setNextNode(newNode);
            newNode.setPreviousNode(aux);
        }else{
            ActivityNode<E> aux2 = aux.getNextNode();
            aux.setNextNode(newNode);
            newNode.setPreviousNode(aux);
            newNode.setNextNode(aux2);
            aux2.setPreviousNode(newNode);
        }
    }

    /**
     * Elimina un nodo de la lista
     * @param element
     */
    public void remove(E element) {
        ActivityNode<E> aux = searchNode(element);
        if (aux != null) {
            removeNode(aux);
        }
    }

    private void removeNode(ActivityNode<E> aux) {
        if (aux == firstNode) {
            firstNode = aux.getNextNode();
            firstNode.setPreviousNode(null);
        } else if (aux == lastNode) {
            lastNode = aux.getPreviousNode();
            lastNode.setNextNode(null);
        } else {
            ActivityNode<E> aux2 = aux.getNextNode();
            ActivityNode<E> aux3 = aux.getPreviousNode();
            aux2.setPreviousNode(aux3);
            aux3.setNextNode(aux2);
        }
        size--;
    }

    public ActivityNode<E> searchNode(E element){
        ActivityNode<E> aux = firstNode;
        while(aux != null){
            if(aux.getValue().equals(element)){
                return aux;
            }
            aux = aux.getNextNode();
        }
        return null;
    }


    public ActivityNode<E> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(ActivityNode<E> firstNode) {
        this.firstNode = firstNode;
    }

    public ActivityNode<E> getLastNode() {
        return lastNode;
    }

    public void setLastNode(ActivityNode<E> lastNode) {
        this.lastNode = lastNode;
    }

    public ActivityNode<E> getLastNodeAdded() {
        return lastNodeAdded;
    }

    public void setLastNodeAdded(ActivityNode<E> lastNodeAdded) {
        this.lastNodeAdded = lastNodeAdded;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    private boolean isEmpty() {
        return firstNode == null;
    }

    private boolean hasNext(ActivityNode<E> node) {
        return node.getNextNode() != null;
    }
}
