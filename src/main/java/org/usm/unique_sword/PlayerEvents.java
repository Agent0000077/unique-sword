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
        if (!player.getPersistentData().contains("unique_sword_given")) {
            ItemStack sword = new ItemStack(ModItems.UNBREAKABLE_SWORD.get());
            CompoundTag tag = sword.getOrCreateTag();
            tag.putString("owner", player.getName().getString());
            sword.setHoverName(Component.translatable("unique_sword.sword").append(" " + player.getName().getString()));
            player.getInventory().add(sword); // <-- вот это важно!
            player.getPersistentData().putBoolean("unique_sword_given", true);
        }
    }

    private static boolean hasStarterSword(Inventory inv) {
        for (ItemStack stack : inv.items) {
            if (stack.getItem() == ModItems.UNBREAKABLE_SWORD.get()) {
                return true;
            }
        }
        return false;
    }
}
