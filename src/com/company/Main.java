package com.company;
import java.util.Scanner;


public class Main {
    private static MyList myList;

    static void printMenu()
    {
        System.out.println();
        System.out.println("Меню: ");
        System.out.println("1 - количество элементов в списке");
        System.out.println("2 - проверка списка на пустоту ");
        System.out.println("3 - печать списка ");
        System.out.println("4 - получение элемента списка по индексу ");
        System.out.println("5 - добавление элемента в конец списка ");
        System.out.println("6 - добавление элемента в указанное место ");
        System.out.println("7 - добавление всех эелементов одного списка в другой список ");
        System.out.println("8 - проверка присутствия элемента в списке ");
        System.out.println("9 - получение индекса элемента ");
        System.out.println("10 - проверка присутствия всех элементов одного списка в другом списке ");
        System.out.println("11 - удаление элемента по индексу");
        System.out.println("12 - удаление элемента ");
        System.out.println("13 - удаление всех элементов списка, присутствующих в другом списке ");
        System.out.println("14 - удаление всех элементов списка, отсутствующих в другом списке");
        System.out.println("15 - очистка списка");
        System.out.println("0 - выход");
        System.out.println();
    }

    public static MyList<Integer> inputIntList(MyList<Integer> l, int cnt, Scanner s){
        for (int i=0; i<cnt;i++){
            int k=s.nextInt();
            l.addElement(k);
        }
        return l;
    }

    public static MyList<String> inputStrList(MyList<String> l, int cnt, Scanner s){
        for (int i=0; i<cnt;i++){
            String str =s.nextLine();
            l.addElement(str);
        }
        return l;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num=0;
        while (num != 1 && num != 2 && num !=3){
            System.out.println("Выберите тип элемента листа ");
            System.out.println("1 - число ");
            System.out.println("2 - строка ");
            System.out.println("3 - пользовательский тип ");
            num = scan.nextInt();

            System.out.println("Введите кол-во элементов в листе : ");
            int c = scan.nextInt();

            switch (num) {
                case 1 : {
                    myList = new MyList<Integer>(c);
                    System.out.println("Введите список элементов: ");
                    inputIntList(myList,c,scan);
                    break;
                }
                case 2:{
                    myList = new MyList<String>(c);
                    scan.nextLine();
                    System.out.println("Введите список элементов: ");
                    inputStrList(myList,c,scan);
                    break;
                }
                case 3:{
                    myList = new MyList<MyElem>(c);
                    for (int i=0; i<c; i++){
                        myList.addElement(MyElem.inputElem(scan));
                    }
                    break;
                }
            }
            myList.printList("Ваш список: ");
        }

        int k;
        int p;
        do{
            printMenu();

            p = scan.nextInt();

            switch (p) {
                case 1 : {
                    System.out.println("Количество элементов в списке: ");
                    System.out.println(myList.countElements());
                    break;
                }
                case 2:{
                    boolean res = myList.myIsEmpty();
                    if (res==true){
                        System.out.println("Список пуст");
                    }
                    else{
                        System.out.println("Количество элементов в списке: ");
                        System.out.println(myList.countElements());
                    }
                    break;
                }
                case 3:{
                    myList.printList("Список: ");
                    break;
                }
                case 4:{
                    System.out.println("Введите индекс ");
                    int i=scan.nextInt();
                    System.out.println(myList.elementByIndex(i));
                    break;
                }
                case 5:{
                    if(num == 3){
                        MyElem el = MyElem.inputElem(scan);
                        myList.addElement(el);
                    }
                    else{
                        System.out.println("Введите добавляемый элемент ");
                        if(num == 1){
                            int i=scan.nextInt();
                            myList.addElement(i);
                        }
                        else {
                            String s = scan.nextLine();
                            myList.addElement(s);
                        }
                    }
                    System.out.println("Элемент добавлен ");
                    break;
                }
                case 6:{
                    System.out.println("Введите позицию добавления ");
                    int j=scan.nextInt();

                    if(num == 3){
                        MyElem el = MyElem.inputElem(scan);
                        myList.addElementByPos(el,j);
                    }
                    else{
                        System.out.println("Введите добавляемый элемент ");
                        if(num == 1){
                            int i=scan.nextInt();
                            myList.addElementByPos(i,j);
                        }
                        else {
                            String s = scan.nextLine();
                            myList.addElementByPos(s,j);
                        }
                    }
                    System.out.println("Элемент добавлен ");
                    break;
                }
                case 7:{
                    System.out.println("Введите количество элементов второго списка");
                    k = scan.nextInt();
                    MyList list2;
                    if(num == 3){
                        list2 = new MyList<MyElem>(k);
                        for (int i=0; i<k; i++){
                            list2.addElement(MyElem.inputElem(scan));
                        }
                    }
                    else{
                        if(num ==1){
                            list2 = new MyList<Integer>(k);
                            System.out.println("Введите список элементов: ");
                            inputIntList(list2,k,scan);
                        }
                        else{
                            list2 = new MyList<String>(k);
                            System.out.println("Введите список элементов: ");
                            inputStrList(list2,k,scan);
                        }
                    }

                    myList.addAll(list2);
                    myList.printList("Получившийся список: ");
                    break;
                }
                case 8:{
                    System.out.println("Введите интересующий элемент");
                    boolean isFound = false;
                    switch (num){
                        case 1: isFound = myList.elementByValue(scan.nextInt());
                            break;
                        case 2: isFound =myList.elementByValue(scan.nextLine());
                            break;
                        case 3: isFound = myList.elementByValue(MyElem.inputElem(scan));
                            break;
                    }
                    if (isFound){
                        System.out.println("В списке елемент найден");
                    }
                    else {
                        System.out.println("В списке елемент не найден");
                    }
                    break;
                }
                case 9:{
                    System.out.println("Введите интересующий элемент");
                    k = -1;
                    switch (num){
                        case 1: k = myList.indexOfElem(scan.nextInt());
                            break;
                        case 2: k = myList.indexOfElem(scan.nextLine());
                            break;
                        case 3: k = myList.indexOfElem(MyElem.inputElem(scan));
                            break;
                    }
                    if (k==-1){
                        System.out.println("В списке елемент не найден");
                    }
                    else {
                        System.out.println("Индекс элемента: "+k);
                    }
                    break;
                }
                case 10:{
                    System.out.println("Введите количество элементов второго списка");
                    k = scan.nextInt();
                    MyList list2;
                    if(num == 3){
                        list2 = new MyList<MyElem>(k);
                        for (int i=0; i<k; i++){
                            list2.addElement(MyElem.inputElem(scan));
                        }
                    }
                    else{
                        if(num ==1){
                            list2 = new MyList<Integer>(k);
                            System.out.println("Введите список элементов: ");
                            inputIntList(list2,k,scan);
                        }
                        else{
                            list2 = new MyList<String>(k);
                            System.out.println("Введите список элементов: ");
                            inputStrList(list2,k,scan);
                        }
                    }

                    if (myList.checkEqualty(list2)){
                        System.out.println("Все элементы списка присутствуют в другом ");
                    }
                    else{
                        System.out.println("Не все элементы списка присутствуют в другом");
                    }
                    break;
                }
                case 11:{
                    System.out.println("Введите индекс для удаления ");
                    int j=scan.nextInt();
                    myList.deleteElementByIndex(j);
                    System.out.println("Элемент удален ");
                    break;
                }
                case 12:{
                    System.out.println("Введите элемент для удаления ");
                    if(num == 3){
                        MyElem el = MyElem.inputElem(scan);
                        myList.deleteElementByValue(el);
                    }
                    else{
                        if(num == 1){
                            int i=scan.nextInt();
                            myList.deleteElementByValue(i);
                        }
                        else {
                            String s = scan.nextLine();
                            myList.deleteElementByValue(s);
                        }
                    }
                    System.out.println("Элемент удален ");
                    break;
                }
                case 13:{
                    System.out.println("Введите количество элементов второго списка");
                    k = scan.nextInt();
                    MyList list2;
                    if(num == 3){
                        list2 = new MyList<MyElem>(k);
                        for (int i=0; i<k; i++){
                            list2.addElement(MyElem.inputElem(scan));
                        }
                    }
                    else{
                        if(num ==1){
                            list2 = new MyList<Integer>(k);
                            System.out.println("Введите список элементов: ");
                            inputIntList(list2,k,scan);
                        }
                        else{
                            list2 = new MyList<String>(k);
                            System.out.println("Введите список элементов: ");
                            inputStrList(list2,k,scan);
                        }
                    }

                    myList.removeAll(list2);
                    myList.printList("Получившийся список: ");
                    break;
                }
                case 14:{
                    System.out.println("Введите количество элементов второго списка");
                    k = scan.nextInt();
                    MyList list2;
                    if(num == 3){
                        list2 = new MyList<MyElem>(k);
                        for (int i=0; i<k; i++){
                            list2.addElement(MyElem.inputElem(scan));
                        }
                    }
                    else{
                        if(num ==1){
                            list2 = new MyList<Integer>(k);
                            System.out.println("Введите список элементов: ");
                            inputIntList(list2,k,scan);
                        }
                        else{
                            list2 = new MyList<String>(k);
                            System.out.println("Введите список элементов: ");
                            inputStrList(list2,k,scan);
                        }
                    }

                    myList.retainsAll(list2);
                    myList.printList("Получившийся список: ");
                    break;
                }
                case 15:{
                    myList.fullDelete();
                    System.out.println("Все элементы удалены");
                    break;
                }
                case 0:{
                    System.out.println("Вы вышли");
                    break;
                }
            }
        }while (p!=0);
    }
}
