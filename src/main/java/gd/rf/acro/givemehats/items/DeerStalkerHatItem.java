package gd.rf.acro.givemehats.items;

import dev.emi.trinkets.api.SlotGroups;
import dev.emi.trinkets.api.Slots;
import dev.emi.trinkets.api.Trinket;
import gd.rf.acro.givemehats.GiveMeHats;
import net.minecraft.block.DispenserBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;

import java.util.List;

import static dev.emi.trinkets.api.TrinketItem.TRINKET_DISPENSER_BEHAVIOR;

public class DeerStalkerHatItem extends Item implements Trinket {


    public DeerStalkerHatItem(Settings settings) {
        super(settings);
        DispenserBlock.registerBehavior(this,TRINKET_DISPENSER_BEHAVIOR);
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        tooltip.add(new TranslatableText("text.deerstalkerhat"));
    }


    @Override
    public boolean canWearInSlot(String s, String s1) {
        return s.equals(SlotGroups.HEAD) && s1.equals(Slots.MASK);
    }

    @Override
    public void tick(PlayerEntity player, ItemStack stack) {
        if(player.isSneaking())
        {
            List<LivingEntity> entities = player.getEntityWorld().getEntitiesByClass(LivingEntity.class,new Box(player.getX()-15,player.getY()-15,player.getZ(),player.getX()+15,player.getY()+15,player.getZ()+15), LivingEntity::isAlive);
            entities.forEach(entity ->
            {
                entity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING,100,3,true,false));
            });
        }
    }

    @Override
    public void render(String slot, MatrixStack matrixStack, VertexConsumerProvider vertexConsumer, int light, PlayerEntityModel<AbstractClientPlayerEntity> model, AbstractClientPlayerEntity player, float headYaw, float headPitch) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        ItemStack stack = new ItemStack(GiveMeHats.DEER_STALKER_HAT_ITEM);
        Trinket.translateToFace(matrixStack,model,player,headYaw,headPitch);
        matrixStack.scale(-1f,-1f,1f);
        matrixStack.translate(0,0.7,0.3f);
        itemRenderer.renderItem(stack, ModelTransformation.Mode.FIXED,light, OverlayTexture.DEFAULT_UV,matrixStack,vertexConsumer);

    }
}
