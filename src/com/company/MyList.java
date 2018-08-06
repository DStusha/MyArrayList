package com.company;

public class MyList<T> {

    private T[] elems;
    private int size;
    private int realSize;

    public MyList(){
        elems = (T[])new Object[]{};
        size = 10;
        realSize = 0;
    }

    public int getSize(){
        return size;
    }

    public MyList(int size){
        this.size = size;
        elems = (T[])new Object[size];
        realSize = 0;
    }

    //список в строку
    public String myToString(){
        String res = "";
        for (int i = 0; i< realSize; i++){
            res = res + elems[i].toString()+"  ";
        }
        return res;
    }

    //печать списка
    public void printList(String s){
        System.out.println(s);
        System.out.println(myToString());
        System.out.println();
    }

    //количество элементов в списке
    public int countElements(){
        return realSize;
    }

    //проверка на пустоту
    public boolean myIsEmpty(){
        return (realSize ==0);
    }

    //получение элемента списка по индексу
    public T elementByIndex(int index){
        if (index < realSize && index>=0){
            return  elems[index];
        }
        return null;
    }

    //добавление элемента в конец списка
    public void addElement(T el){
        if (realSize <size){
            elems[realSize]=el;
        }
        else{
            size++;
            T[] mas = (T[])new Object[size];
            for (int i=0;i<size-1; i++){
                mas[i]= elems[i];
            }
            mas[realSize]=el;
            elems = (T[])new Object[size];
            for (int i=0;i<size; i++){
                elems[i]=mas[i];
            }
        }
        realSize++;
    }

    //добавление элемента в указанное место
    public void addElementByPos(T el, int pos) {
        if (pos >= realSize) {
            addElement(el);
        }
        else if(pos>=0){
            size++;
            T[] mas = (T[])new Object[size];
            for (int i=0;i<size-1; i++){
                mas[i]= elems[i];
            }
            elems = (T[])new Object[size];
            for (int i=0;i<size; i++){
                elems[i]=mas[i];
            }
            for (int i = realSize; i > pos+1; i--){
                elems[i]= elems[i-1];
            }
            elems[pos]= el;
            realSize++;
        }
    }

    //добавление всех эелементов одного списка в другой список
    public void addAll(MyList<T> listTwo){
        for (int i=0; i<listTwo.size;i++){
            addElement(listTwo.elementByIndex(i));
        }
    }

    //проверка присутствия элемента в списке
    public boolean elementByValue(T el){
        int i = 0;
        while (i< realSize){
            if (elems[i].equals(el)){
                return true;
            }
            else{
                i++;
            }
        }
        return false;
    }

    //получение индекса элемента
    public int indexOfElem(T element){
        int i = 0;
        while (i< realSize){
            if (elems[i].equals(element)){
                return i;
            }
            i++;
        }
        return -1;
    }

    //проверка присутствия всех элементов одного списка в другом списке
    public boolean checkEqualty (MyList<T> l2){
        int i=0;
        while (i< l2.countElements()){
            if (elementByValue(l2.elementByIndex(i))){
                i++;
            }
            else return false;
        }
        return true;
    }

    //удаление элемента по индексу
    public void deleteElementByIndex(int index){
        if(index == realSize -1){
            realSize--;
        }
        else{
            if(index< realSize && index>=0){
                for (int i = index; i< realSize -1; i++){
                    elems[i]= elems[i+1];
                    elems[i+1] = null;
                }
            realSize--;}
            }
    }

    //удаление элемента
    public void deleteElementByValue(T element){
        int i = indexOfElem(element);
        while (i != -1){
            deleteElementByIndex(i);
            i = indexOfElem(element);
        }
    }

    //удаление всех элементов списка, присутствующих в списке l2
    public void removeAll(MyList<T> l2){
        for (int i=0; i<l2.countElements();i++){
            T el = l2.elementByIndex(i);
            if(elementByValue(el)){
                deleteElementByValue(el);
            }
        }
    }

    //удаление всех элементов списка, отсутствующих в списке l2
    public void retainsAll(MyList<T> l2){
        for (int i = 0; i< realSize; i++){
            T el = elementByIndex(i);
            if(!l2.elementByValue(el)) {
                deleteElementByValue(el);
            }
        }
    }

    //удаление всех элементов списка
    public void fullDelete(){
        for (int i = 0; i< realSize; i++){
            deleteElementByIndex(i);
        }
    }

}
