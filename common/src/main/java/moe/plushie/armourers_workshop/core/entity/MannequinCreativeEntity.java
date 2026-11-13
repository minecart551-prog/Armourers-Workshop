package moe.plushie.armourers_workshop.core.entity;

import moe.plushie.armourers_workshop.api.common.IEntityType;
import moe.plushie.armourers_workshop.api.core.IRegistryHolder;
import moe.plushie.armourers_workshop.init.ModEntityTypes;
import moe.plushie.armourers_workshop.init.ModItems;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

/**
 * A creative mode only variant of the {@link MannequinEntity}.
 * <p>
 * The wardrobe can only be opened and the mannequin can only be modified by players that are in creative mode.
 * Non-creative players can't open the wardrobe, can't modify the contents of the mannequin and can't damage or break it.
 * </p>
 */
public class MannequinCreativeEntity extends MannequinEntity {

    public MannequinCreativeEntity(EntityType<? extends MannequinCreativeEntity> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public IRegistryHolder<Item> mannequinItem() {
        return ModItems.MANNEQUIN_CREATIVE;
    }

    @Override
    public IRegistryHolder<? extends IEntityType<? extends MannequinEntity>> mannequinEntityType() {
        return ModEntityTypes.MANNEQUIN_CREATIVE;
    }

    @Override
    protected boolean shouldDropEquipment() {
        return false;
    }

    @Override
    public boolean isUsableBy(Player player) {
        return player.isCreative();
    }

    @Override
    public String noPermissionMessageKey() {
        return "chat.armourers_workshop.mannequin-creative.no-permission";
    }
}
