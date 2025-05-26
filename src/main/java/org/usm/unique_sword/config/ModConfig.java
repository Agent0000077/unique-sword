package org.usm.unique_sword.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class ModConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.BooleanValue IS_BREAKABLE;
    public static final ForgeConfigSpec.BooleanValue IS_ENCHANTABLE;

    static {
        IS_BREAKABLE = BUILDER
                .comment("Should the sword be breakable?")
                .define("isBreakable", false);
        IS_ENCHANTABLE = BUILDER
                .comment("Can the sword be enchanted?")
                .define("isEnchantable", false);
        SPEC = BUILDER.build();
    }
}
