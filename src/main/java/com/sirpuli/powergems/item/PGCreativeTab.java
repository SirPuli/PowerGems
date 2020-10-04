package com.sirpuli.powergems.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class PGCreativeTab {

    public static final ItemGroup POWERGEMS = new ItemGroup(ItemGroup.GROUPS.length, "powergems"){
        @OnlyIn(Dist.CLIENT)
        public ItemStack createIcon(){
            return new ItemStack(PGItem.RUBY_TIER_0.get());
        }
    };
}
