package com.example.signalstrength;

import com.example.signalstrength.slice.MainAbilitySlice;
import ohos.aafwk.ability.delegation.AbilityDelegatorRegistry;
import ohos.aafwk.content.Intent;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExampleOhosTest {
    @Test
    public void testBundleName() {
        final String actualBundleName = AbilityDelegatorRegistry.getArguments().getTestBundleName();
        assertEquals("com.example.signalstrength", actualBundleName);
    }
}