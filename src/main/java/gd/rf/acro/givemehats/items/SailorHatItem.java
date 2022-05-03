package gd.rf.acro.givemehats.items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;

public class SailorHatItem extends TrinketItem {




   @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        p_41423_.add(new TranslatableComponent("text.sailorhat"));
    }


    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        super.curioTick(slotContext, stack);
        if(slotContext.entity().isPassenger() && slotContext.entity().getVehicle().getType()== EntityType.HORSE
                && slotContext.entity().getLevel().getBlockState(slotContext.entity().getOnPos()).getBlock()== Blocks.WATER
                && slotContext.entity().getVehicle().getDeltaMovement().x<3
                && slotContext.entity().getVehicle().getDeltaMovement().z<3)
        {
            slotContext.entity().getVehicle().setDeltaMovement(slotContext.entity().getVehicle().getDeltaMovement().multiply(1.1,0,1.1));
        }
    }
}
