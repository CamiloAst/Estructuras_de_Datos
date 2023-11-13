package proyecto.utils;

import java.util.Iterator;

public class TaskQueue<E> implements Iterable<E> {
    public TaskNode<E> firstNode, lastNode;
    public int size;

    public void add(E value){
        TaskNode<E> newNode = new TaskNode<>(value);
        if(isEmpty()){
            firstNode = lastNode = newNode;
        }else{
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
        size++;
    }
    public void add(E value, int index){
        TaskNode<E> newNode = new TaskNode<>(value);
        TaskNode<E> aux = firstNode;
        if(index == 0){
            newNode.setNextNode(firstNode);
            firstNode = newNode;
        }else{
            for(int i = 0; i < index - 1; i++){
                aux = aux.getNextNode();
            }
            newNode.setNextNode(aux.getNextNode());
            aux.setNextNode(newNode);
        }
        size++;
    }

    public E pop(){
        if(!isEmpty()){
            E value = firstNode.getValue();
            if(firstNode != lastNode)
                firstNode = firstNode.getNextNode();
            else
                delete();
            size--;
            return value;
        }
        throw new NullPointerException();
    }
    public void remove(int index){
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        if(index == 0){
            if(firstNode != lastNode)
                firstNode = firstNode.getNextNode();
            else
                delete();
        }else{
            TaskNode<E> aux = firstNode;
            for(int i = 0; i < index - 1; i++){
                aux = aux.getNextNode();
            }
            aux.setNextNode(aux.getNextNode().getNextNode());
        }
        size--;
    }


    private void delete() {
        firstNode = lastNode = null;
        size = 0;
    }

    public TaskNode<E> getFirstNode() {
        return firstNode;
    }

    public void setFirstNode(TaskNode<E> firstNode) {
        this.firstNode = firstNode;
    }

    public TaskNode<E> getLastNode() {
        return lastNode;
    }

    public void setLastNode(TaskNode<E> lastNode) {
        this.lastNode = lastNode;
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

    @Override
    public Iterator<E> iterator() {
        return new TaskQueueIterator();
    }
    private class TaskQueueIterator implements Iterator<E>{
        private TaskNode<E> aux = firstNode;
        @Override
        public boolean hasNext() {
            return aux != null;
        }

        @Override
        public E next() {
            if(!hasNext())
                return null;

            E value = aux.getValue();
            aux = aux.getNextNode();
            return value;
        }
    }
}
