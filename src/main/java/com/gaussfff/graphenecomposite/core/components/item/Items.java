package com.gaussfff.graphenecomposite.core.components.item;

import com.gaussfff.graphenecomposite.core.components.item.combat.*;
import com.gaussfff.graphenecomposite.core.components.item.ingredients.*;
import net.minecraft.world.item.Item;

import java.util.function.Function;

public enum Items {
    // combbat
    GRAPHENE_BOOTS("graphene_boots", GrapheneBootsItem::new),
    GRAPHENE_HELMET("graphene_helmet", GrapheneHelmet::new),
    GRAPHENE_CHESTPLATE("graphene_chestplate", GrapheneChestplateItem::new),
    GRAPHENE_LEGGINGS("graphene_leggings", GrapheneLeggingsItem::new),
    GRAPHENE_SWORD("graphene_sword", GrapheneSwordItem::new),

    // ingredients
    GRAPHITE("graphite", GraphiteItem::new),
    GRAPHENE("graphene", GrapheneItem::new),
    GRAPHENE_PLATE("graphene_plate", GraphenePlateItem::new),
    GRAPHENE_COMPOSITE("graphene_composite", GrapheneCompositeItem::new),
    GRAPHENE_SUSPENSION("graphene_suspension", GrapheneSuspensionItem::new),
    GRAPHENE_COMPOSITE_BLANK("graphene_composite_blank", GrapheneCompositeBlankItem::new),
    COAL_DUST("coal_dust", CoalDustItem::new),
    LIQUID_CARBON_BUCKET("liquid_carbon", LiquidCarbonBucketItem::new),
    POLYMER_THREAD("polymer_thread", PolymerThreadItem::new),
    TREE_BARK("tree_bark", TreeBarkItem::new),
    TREE_RESINE("tree_resine", TreeResinItem::new),
    MECHANISM("mechanism", MechanismItem::new);

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
