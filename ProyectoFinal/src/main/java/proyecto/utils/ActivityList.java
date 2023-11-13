package proyecto.utils;

import proyecto.exceptions.ActivityAlreadyExistException;
import proyecto.exceptions.ActivityDontExist;

import java.util.Iterator;

public class ActivityList <E>implements Iterable<E>{
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
    public void add(E element) throws ActivityAlreadyExistException {
        ActivityNode<E> newNode = new ActivityNode<>(element);
        checkDuplicates(element);
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
    public void add(E element, E previous) throws ActivityDontExist, ActivityAlreadyExistException {
        ActivityNode<E> newNode = new ActivityNode<>(element);
        ActivityNode<E> aux = searchNode(previous);
        checkDuplicates(element);
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
    public void sequentialAdd(E element) throws ActivityAlreadyExistException {
        ActivityNode<E> newNode = new ActivityNode<>(element);
        checkDuplicates(element);
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
    public void remove(E element) throws ActivityDontExist {
        ActivityNode<E> aux = searchNode(element);
        if (aux != null) {
            removeNode(aux);
        }
    }

    private void removeNode(ActivityNode<E> aux) {
        ActivityNode<E> previousNode = aux.getPreviousNode();
        ActivityNode<E> nextNode = aux.getNextNode();

        if (previousNode != null) {
            previousNode.setNextNode(nextNode);
        } else {
            firstNode = nextNode;
        }

        if (nextNode != null) {
            nextNode.setPreviousNode(previousNode);
        } else {
            lastNode = previousNode;
        }
        size--;
    }

    public ActivityNode<E> searchNode(E element) throws ActivityDontExist {
        ActivityNode<E> foward = firstNode;
        ActivityNode<E> backward = lastNode;
        do{
            if(foward.getValue().equals(element)){
                return foward;
            }else if(backward.getValue().equals(element)){
                return backward;
            }
            foward = foward.getNextNode();
            backward = backward.getPreviousNode();
        }while(foward != null && backward != null && foward != backward);

        throw new ActivityDontExist();
    }


    public ActivityNode<E> getFirstNode() {
        return firstNode;
    }
    public ActivityNode<E> getLastNode() {
        return lastNode;
    }
    public ActivityNode<E> getLastNodeAdded() {
        return lastNodeAdded;
    }

    public int getSize() {
        return size;
    }

    private boolean isEmpty() {
        return firstNode == null;
    }

    private boolean hasNext(ActivityNode<E> node) {
        return node.getNextNode() != null;
    }

    private void checkDuplicates(E element) throws ActivityAlreadyExistException {
        if(contains(element))
            throw new ActivityAlreadyExistException();
    }
    public boolean contains(E actividad) {
        ActivityNode<E> aux = firstNode;
        while(aux != null){
            if(aux.getValue().equals(actividad)){
                return true;
            }
            aux = aux.getNextNode();
        }
        return false;
    }
    private class LinkedListIterator implements Iterator<E> {
        private ActivityNode<E> aux = firstNode;
        @Override
        public boolean hasNext() {
            return aux != null;
        }

        @Override
        public E next() {
            if(!hasNext()){
                return null;
            }
            E value = aux.getValue();
            aux = aux.getNextNode();
            return value;
        }
    }
    @Override
    public LinkedListIterator iterator() {
        return new LinkedListIterator();
    }
}
