package org.usm.unique_sword;

import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.Item;
import org.usm.unique_sword.item.UnbreakableSword;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "unique_sword");

    public static final RegistryObject<Item> UNBREAKABLE_SWORD = ITEMS.register(
            "unbreakable_sword",
            UnbreakableSword::new
    );
}