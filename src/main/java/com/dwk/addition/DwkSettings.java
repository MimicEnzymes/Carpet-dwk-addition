package com.dwk.addition;
import carpet.api.settings.Rule;
import static carpet.api.settings.RuleCategory.CREATIVE;
import static carpet.api.settings.RuleCategory.FEATURE;
public class DwkSettings {
    @Rule(categories = { "dwk", CREATIVE, FEATURE })
    public static boolean stopFluidFlow = false;
    @Rule(categories = { "dwk", CREATIVE, FEATURE })
    public static boolean preventFluidInteraction = false;
}