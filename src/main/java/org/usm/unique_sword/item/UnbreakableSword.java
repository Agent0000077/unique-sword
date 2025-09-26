package org.usm.unique_sword.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.network.chat.Component;
import javax.annotation.Nullable;
import java.util.List;
import net.minecraft.ChatFormatting;
import org.usm.unique_sword.config.ModConfig;

public class UnbreakableSword extends SwordItem {
    public UnbreakableSword() {
        super(
                Tiers.IRON,
                3,
                -2.4F,
                new Item.Properties()
                        .rarity(Rarity.EPIC)
                        .stacksTo(1)
                        .fireResistant()
                        .durability(1562)
        );
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        // Неразрушаемый, если isBreakable = false
        return ModConfig.IS_BREAKABLE.get();
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return ModConfig.IS_ENCHANTABLE.get();
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if (stack.hasTag() && stack.getTag().contains("owner")) {
            String owner = stack.getTag().getString("owner");
            tooltip.add(Component.translatable("unique_sword.owner", owner).withStyle(ChatFormatting.GRAY));
        }
        tooltip.add(Component.translatable("item.unique_sword.unbreakable_sword.desc"));
        super.appendHoverText(stack, world, tooltip, flag);
    }
}
