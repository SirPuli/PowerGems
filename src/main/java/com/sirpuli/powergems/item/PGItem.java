package com.sirpuli.powergems.item;

import com.sirpuli.powergems.PowerGems;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("all")
public class PGItem {

    public static final Item.Properties CREATIVE_TAB = new Item.Properties().group(PGCreativeTab.POWERGEMS);

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, PowerGems.MOD_ID);

    /*
    ID  NAME                MATERIAL    AMPLIFIERS
    0:  Fire Resistance     RUBY        0, 0, 0, 0, 0
    1:  Speed               HUSHANITE   0, 1, 1, 2, 3
     */

    public static final RegistryObject<Item> RUBY_TIER_0 = ITEMS.register("ruby_tier_0", () -> new PGemItem(PGemStat.TIER_0, CREATIVE_TAB, 0));
    public static final RegistryObject<Item> HUSHANITE_TIER_0 = ITEMS.register("hushanite_tier_0", () -> new PGemItem(PGemStat.TIER_0, CREATIVE_TAB,  1));
    public static final RegistryObject<Item> RUBY_TIER_1 = ITEMS.register("ruby_tier_1", () -> new PGemItem(PGemStat.TIER_1, CREATIVE_TAB, 0));
    public static final RegistryObject<Item> HUSHANITE_TIER_1 = ITEMS.register("hushanite_tier_1", () -> new PGemItem(PGemStat.TIER_1, CREATIVE_TAB,  1));
}
