package Lesson1;

import javax.swing.*;

class SomeClass {
    interface Callback {
        void callingBack();
    }

    Callback callback;

    public SomeClass(Callback callback) {
        this.callback = callback;
    }

    void doSomething() {
        JOptionPane.showMessageDialog(null, "work");
        callback.callingBack();
    }
}
class MyClass implements SomeClass.Callback{
        @Override
        public void callingBack(){
            System.out.println("collingBack");
        }
}

class MainSC {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        SomeClass someClass = new SomeClass(myClass);

        someClass.doSomething();
    }
}