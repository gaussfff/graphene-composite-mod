package com.gaussfff.graphenecomposite.core.component.item;

import com.gaussfff.graphenecomposite.core.component.item.block_item.functional.ChemicalReactorBlockItem;
import com.gaussfff.graphenecomposite.core.component.item.block_item.functional.CompressorBlockItem;
import com.gaussfff.graphenecomposite.core.component.item.block_item.functional.CrusherBlockItem;
import com.gaussfff.graphenecomposite.core.component.item.block_item.functional.FiltrationMachineBlockItem;
import com.gaussfff.graphenecomposite.core.component.item.block_item.natural.CarbonShaleOreBlockItem;
import com.gaussfff.graphenecomposite.core.component.item.combat.*;
import com.gaussfff.graphenecomposite.core.component.item.ingredients.*;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public enum Items {
    // combat items
    GRAPHENE_BOOTS("graphene_boots", GrapheneBootsItem::new),
    GRAPHENE_HELMET("graphene_helmet", GrapheneHelmet::new),
    GRAPHENE_CHESTPLATE("graphene_chestplate", GrapheneChestplateItem::new),
    GRAPHENE_LEGGINGS("graphene_leggings", GrapheneLeggingsItem::new),
    GRAPHENE_SWORD("graphene_sword", GrapheneSwordItem::new),

    // ingredients items
    GRAPHITE("graphite", GraphiteItem::new),
    GRAPHENE("graphene", GrapheneItem::new),
    GRAPHENE_PLATE("graphene_plate", GraphenePlateItem::new),
    GRAPHENE_COMPOSITE("graphene_composite", GrapheneCompositeItem::new),
    GRAPHENE_SUSPENSION("graphene_suspension", GrapheneSuspensionItem::new),
    GRAPHENE_COMPOSITE_BLANK("graphene_composite_blank", GrapheneCompositeBlankItem::new),
    COAL_DUST("coal_dust", CoalDustItem::new),
    LIQUID_CARBON_BUCKET("liquid_carbon_bucket", LiquidCarbonBucketItem::new),
    POLYMER_THREAD("polymer_thread", PolymerThreadItem::new),
    TREE_BARK("tree_bark", TreeBarkItem::new),
    TREE_RESIN("tree_resin", TreeResinItem::new),
    MECHANISM("mechanism", MechanismItem::new),

    // functional block items
    CRUSHER("crusher", CrusherBlockItem::new),
    CHEMICAL_REACTOR("chemical_reactor", ChemicalReactorBlockItem::new),
    FILTRATION_MACHINE("filtration_machine", FiltrationMachineBlockItem::new),
    COMPRESSOR("compressor", CompressorBlockItem::new),

    // natural block items
    CARBON_SHALE_ORE("carbon_shale", CarbonShaleOreBlockItem::new);

    private final String id;
    private final Function<Item.Properties, Item> constructor;

    Items(String id, Function<Item.Properties, Item> constructor) {
        this.id = id;
        this.constructor = constructor;
    }

    public String getId() {
        return id;
    }

    public Function<Item.Properties, Item> getConstructor() {
        return constructor;
    }

    @Override
    public String toString() {
        return id;
    }
}
