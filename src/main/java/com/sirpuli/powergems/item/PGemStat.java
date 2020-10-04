package com.sirpuli.powergems.item;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

public enum PGemStat implements IItemTier {

    /*
    ID  NAME                MATERIAL    AMPLIFIERS
    0:  Fire Resistance     RUBY        0, 0, 0, 0, 0
    1:  Speed               HUSHANITE   0, 1, 1, 2, 3
     */

    TIER_0(
            //     ID: 0,    1
            new int[]{300, 600},
            new int[]{0, 0},
            21
    ),
    TIER_1(
            //     ID: 0,    1
            new int[]{300, 600},
            new int[]{0, 1},
            53
    );

    private final int[] duration;
    private final int[] amplifier;
    private final int maxUses;


    PGemStat(int[] duration, int[] amplifier, int maxUses) {
        this.duration = duration;
        this.amplifier = amplifier;
        this.maxUses = maxUses;
    }

    public int getDuration(int material) {
        return duration[material];
    }

    public int getAmplifier(int material) {
        return amplifier[material];
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return 0;
    }

    @Override
    public float getAttackDamage() {
        return 0;
    }

    @Override
    public int getHarvestLevel() {
        return 0;
    }

    @Override
    public int getEnchantability() {
        return 0;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return null;
    }
}
