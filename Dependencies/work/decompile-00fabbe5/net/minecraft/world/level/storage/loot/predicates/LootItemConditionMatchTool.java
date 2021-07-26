package net.minecraft.world.level.storage.loot.predicates;

import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import java.util.Set;
import net.minecraft.advancements.critereon.CriterionConditionItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootSerializer;
import net.minecraft.world.level.storage.loot.LootTableInfo;
import net.minecraft.world.level.storage.loot.parameters.LootContextParameter;
import net.minecraft.world.level.storage.loot.parameters.LootContextParameters;

public class LootItemConditionMatchTool implements LootItemCondition {

    final CriterionConditionItem predicate;

    public LootItemConditionMatchTool(CriterionConditionItem criterionconditionitem) {
        this.predicate = criterionconditionitem;
    }

    @Override
    public LootItemConditionType a() {
        return LootItemConditions.MATCH_TOOL;
    }

    @Override
    public Set<LootContextParameter<?>> b() {
        return ImmutableSet.of(LootContextParameters.TOOL);
    }

    public boolean test(LootTableInfo loottableinfo) {
        ItemStack itemstack = (ItemStack) loottableinfo.getContextParameter(LootContextParameters.TOOL);

        return itemstack != null && this.predicate.a(itemstack);
    }

    public static LootItemCondition.a a(CriterionConditionItem.a criterionconditionitem_a) {
        return () -> {
            return new LootItemConditionMatchTool(criterionconditionitem_a.b());
        };
    }

    public static class a implements LootSerializer<LootItemConditionMatchTool> {

        public a() {}

        public void a(JsonObject jsonobject, LootItemConditionMatchTool lootitemconditionmatchtool, JsonSerializationContext jsonserializationcontext) {
            jsonobject.add("predicate", lootitemconditionmatchtool.predicate.a());
        }

        @Override
        public LootItemConditionMatchTool a(JsonObject jsonobject, JsonDeserializationContext jsondeserializationcontext) {
            CriterionConditionItem criterionconditionitem = CriterionConditionItem.a(jsonobject.get("predicate"));

            return new LootItemConditionMatchTool(criterionconditionitem);
        }
    }
}
