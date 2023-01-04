import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.List;

public class LavaAbility {
    private static final int COOLDOWN_TIME = 45 * 20;  // 45 seconds in ticks
    private static final int RADIUS = 10;

    private int cooldown = 0;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        PlayerEntity player = event.player;
        World world = player.getEntityWorld();
        if (!world.isRemote) {
            if (cooldown > 0) {
                cooldown--;
            }
            if (player.isSneaking() && cooldown == 0) {
                // Get all entities within radius
                List<Entity> entities = world.getEntitiesWithinAABB(Entity.class, player.getBoundingBox().grow(RADIUS));
                for (Entity entity : entities) {
                    BlockPos pos = new BlockPos(entity.getPosX(), entity.getPosY() - 1, entity.getPosZ());
                    // Set block below entity to lava
                    world.setBlockState(pos, Blocks.LAVA.getDefaultState());
                }
                cooldown = COOLDOWN_TIME;
            }
        }
    }
}