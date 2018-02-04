package com.baliyaan.android.library.afsm;

import android.os.Bundle;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        FSM.addStates(new String[]{
                "Root", "SecondState"
        });

        new Transition("Root", "", "SecondState")
                .setAction(new Action() {
                    @Override
                    public void run(Object data) {
                        // Do something while going from Root to SecondState
                        // Control comes here only if isGo returns true.
                        assertNotNull(data);
                        Bundle bundle = (Bundle) data;
                        assertNotNull(bundle);
                        String value = bundle.getString("key1");
                        assertEquals(value,"data1");
                    }
                }) // Condition is optional (unless there are more than one transitions from a single state)
                .setCondition(new Condition() {
                    @Override
                    public boolean isGo(Object data) {
                        boolean condition = true;// Put a condition to make this transition 'unique'
                        return condition;
                    }
                });

        /*Call transit to invoke a transition.
        Which transition happens, depends upon the "current state" of FSM and "condition check" for the transition.*/
        Bundle data = new Bundle();
        data.putString("key1", "data1");
        FSM.transit(data);
    }
}
