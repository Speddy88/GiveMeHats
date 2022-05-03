package gd.rf.acro.givemehats.items;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import top.theillusivec4.curios.api.SlotContext;

import javax.annotation.Nullable;
import java.util.List;


public class DwarvenHatItem extends TrinketItem {




   @Override
    public void appendHoverText(ItemStack p_41421_, @Nullable Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        p_41423_.add(new TranslatableComponent("text.dwarven_hat"));
    }


    



    @Override
    public void curioTick(SlotContext slotContext, ItemStack stack) {
        super.curioTick(slotContext, stack);
        if(slotContext.entity().getY()<20 && !slotContext.entity().hasEffect(MobEffects.DIG_SPEED))
        {
            slotContext.entity().addEffect(new MobEffectInstance(MobEffects.DIG_SPEED,200,2));
        }
    }
}
