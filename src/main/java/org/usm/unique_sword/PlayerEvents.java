package org.usm.unique_sword;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "unique_sword", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {
    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();
        if (!player.getPersistentData().contains("unique_sword_given") && !hasStarterSword(player.getInventory())) {
            ItemStack sword = new ItemStack(ModItems.UNBREAKABLE_SWORD.get());
            CompoundTag tag = sword.getOrCreateTag();
            tag.putString("owner", player.getName().getString());
            sword.setHoverName(Component.translatable("unique_sword.sword").append(" " + player.getName().getString()));
            player.getInventory().add(sword);
            player.getPersistentData().putBoolean("unique_sword_given", true);
        }
    }
    @SubscribeEvent
    public static void onClone(PlayerEvent.Clone event) {
        if (event.isWasDeath()) {
            CompoundTag old = event.getOriginal().getPersistentData();
            if (old.contains("unique_sword_given")) {
                event.getEntity().getPersistentData()
                        .putBoolean("unique_sword_given", old.getBoolean("unique_sword_given"));
            }
        }
    }


    private static boolean hasStarterSword(Inventory inv) {
        for (ItemStack stack : inv.items) {
            if (!stack.isEmpty() && stack.getItem() == ModItems.UNBREAKABLE_SWORD.get()) {
                return true;
            }
        }
        return false;
    }
}
