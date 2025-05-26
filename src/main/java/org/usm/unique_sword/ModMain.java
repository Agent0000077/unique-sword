package org.usm.unique_sword;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.usm.unique_sword.config.ModConfig;

@Mod("unique_sword")
public class ModMain {
    public ModMain() {
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        net.minecraftforge.fml.ModLoadingContext.get().registerConfig(
                net.minecraftforge.fml.config.ModConfig.Type.COMMON,
                ModConfig.SPEC,
                "unique_sword-common.toml"
        );
    }
}
