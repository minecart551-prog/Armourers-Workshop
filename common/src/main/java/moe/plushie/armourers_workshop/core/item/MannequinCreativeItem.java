package moe.plushie.armourers_workshop.core.item;

import moe.plushie.armourers_workshop.api.common.IEntityType;
import moe.plushie.armourers_workshop.api.core.IRegistryHolder;
import moe.plushie.armourers_workshop.core.entity.MannequinCreativeEntity;
import moe.plushie.armourers_workshop.core.entity.MannequinEntity;
import moe.plushie.armourers_workshop.init.ModEntityTypes;
import net.minecraft.world.entity.player.Player;

/**
 * A creative mode only variant of the {@link MannequinItem}.
 * <p>
 * Spawns a {@link MannequinCreativeEntity}, which can only be opened and modified by players in creative mode.
 * </p>
 */
public class MannequinCreativeItem extends MannequinItem {

    public MannequinCreativeItem(Properties properties) {
        super(properties);
    }

    @Override
    protected IRegistryHolder<? extends IEntityType<? extends MannequinEntity>> entityType() {
        return ModEntityTypes.MANNEQUIN_CREATIVE;
    }

    @Override
    protected boolean isUsableBy(Player player) {
        return player.isCreative();
    }

    @Override
    protected String noPermissionMessageKey() {
        return "chat.armourers_workshop.mannequin-creative.no-permission";
    }
}
