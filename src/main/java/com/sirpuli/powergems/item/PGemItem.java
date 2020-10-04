package com.sirpuli.powergems.item;

import com.sirpuli.powergems.PowerGems;
import com.sirpuli.powergems.util.helper.FormatHelper;
import com.sirpuli.powergems.util.helper.KeyboardHelper;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.TieredItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class PGemItem extends TieredItem {

    /*
    ID  NAME                MATERIAL    AMPLIFIERS
    0:  Fire Resistance     RUBY        0, 0, 0, 0, 0
    1:  Speed               HUSHANITE   0, 1, 1, 2, 3
     */

    private final Effect[] effect = new Effect[]{
            Effects.FIRE_RESISTANCE,
            Effects.SPEED};
    private final String[] effectName = new String[]{
            "fire resistance",
            "speed"};
    private final String[] color = new String[]{
            FormatHelper.MCFormat.RED + FormatHelper.MCFormat.BOLD,
            FormatHelper.MCFormat.YELLOW + FormatHelper.MCFormat.BOLD};
    private final int material;
    private final int duration;
    private final int amplifier;

    private final PGemStat pGemStat;


    public PGemItem(PGemStat statsIn, Properties builder, int materialID) {
        super(statsIn, builder);
        this.material = materialID;
        this.duration = statsIn.getDuration(materialID);
        this.amplifier = statsIn.getAmplifier(materialID);

        this.pGemStat = statsIn;
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardHelper.isHoldingShift()) {
            tooltip.add(new StringTextComponent("Gives " + color[material] + effectName[material] + FormatHelper.MCFormat.WHITE + " for " + duration / 20 + " seconds."));
        } else {
            tooltip.add(new StringTextComponent(FormatHelper.MCFormat.GRAY + "Hold" + FormatHelper.MCFormat.YELLOW + " Shift " + FormatHelper.MCFormat.GRAY + "for more information!"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if (!playerIn.getActivePotionEffects().contains(new EffectInstance(effect[material]))) {
            playerIn.addPotionEffect(new EffectInstance(effect[material], duration, amplifier));
            PowerGems.LOGGER.info("Max Durability: " + pGemStat.getMaxUses());
            playerIn.getHeldItemMainhand().damageItem(1, playerIn, (onBreak) -> {
                onBreak.sendBreakAnimation(playerIn.getActiveHand());
            });
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }
        return ActionResult.resultFail(itemstack);
    }

    @Override
    public boolean isFood() {
        return false;
    }
}