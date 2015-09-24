package adsTest;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//import com.foo.bar.baz.Suite_baz;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    DoublyLinkedListTest.class,
    QueueArrayBasedTest.class,
    QueueDoublyLinkedListBasedTest.class,
    SinglyLinkedListTest.class,
    StackArrayBasedTest.class,
    StackDoublyLinkedListBasedTest.class,
    SortsTest.class,
})

public class AllTest {}