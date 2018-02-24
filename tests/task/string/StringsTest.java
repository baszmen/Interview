package task.string;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {

    @Test
    public void uniqeCharacters() {
        Strings util = new Strings();
        assertEquals(true, util.uniqeCharacters("aqwertyuiopsdfghjkl;'[]zxcvbnm,./1234567890"));
        assertEquals(false, util.uniqeCharacters("asdafhgfjhgjghghghjj"));
    }

    @Test
    public void isPermutation() {
        Strings util = new Strings();
        assertEquals(true, util.isPerumtation("abcd", "bcda"));
        assertEquals(false, util.isPerumtation("sadada", "vcvxc"));
    }
}