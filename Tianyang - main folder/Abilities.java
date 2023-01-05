if (power1Pressed) {
    import net.minecraft.entity.EntityType;
    import net.minecraft.entity.LivingEntity;
    import net.minecraft.entity.projectile.ProjectileItemEntity;
    import net.minecraft.item.Item;
    import net.minecraft.util.DamageSource;
    import net.minecraft.util.math.BlockPos;
    import net.minecraft.util.math.RayTraceResult;
    import net.minecraft.world.World;

    public class FireballEntity extends ProjectileItemEntity {
        public FireballEntity(EntityType<? extends ProjectileItemEntity> entityType, World world) {
            super(entityType, world);
        }

        public FireballEntity(World world, LivingEntity thrower, Item item) {
            super(EntityType.FIREBALL, thrower, world);
        }

        @Override
        protected void onImpact(RayTraceResult result) {
            // Create explosion
            float explosionPower = 5.0f;  // Adjust explosion power here
            World world = this.world;
            if (!world.isRemote) {
                if (result.getType() == RayTraceResult.Type.BLOCK) {
                    BlockPos pos = result.getBlockPos();
                    world.createExplosion(this, pos.getX(), pos.getY(), pos.getZ(), explosionPower, true, false);
                } else if (result.getType() == RayTraceResult.Type.ENTITY) {
                    result.getEntity().attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), explosionPower);
                    world.createExplosion(this, result.getEntity().getPosX(), result.getEntity().getPosY(), result.getEntity().getPosZ(), explosionPower, true, true);
                }
            }
            // Remove fireball entity
            this.remove();
        }
    }
}
if (power2Pressed) {
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
                if (cooldown == 0) {
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
}
if (power3Pressed) {
    import net.minecraft.entity.Entity;
    import net.minecraft.entity.LivingEntity;
    import net.minecraft.entity.player.PlayerEntity;
    import net.minecraft.util.math.AxisAlignedBB;
    import net.minecraft.util.math.Vec3d;

    public class DashAbility {

    // The distance that the player will dash
    private static final double DASH_DISTANCE = 10.0;

    // The duration of the dash in ticks
    private static final int DASH_DURATION = 10;

    // The player's speed when dashing
    private static final double DASH_SPEED = 1.5;

    // The player's acceleration when dashing
    private static final double DASH_ACCELERATION = 0.1;

    public static void dash(PlayerEntity player) {
        // Calculate the player's dash direction
        Vec3d lookVec = player.getLookVec();
        Vec3d dashVec = new Vec3d(lookVec.x * DASH_SPEED, lookVec.y * DASH_SPEED, lookVec.z * DASH_SPEED);

        // Set the player's motion to the dash vector
        player.setMotion(dashVec);

        // Set the player's acceleration to the dash acceleration
        player.addVelocity(dashVec.x * DASH_ACCELERATION, dashVec.y * DASH_ACCELERATION, dashVec.z * DASH_ACCELERATION);

        // Set the player's velocity to the dash speed
        player.setVelocity(dashVec.x, dashVec.y, dashVec.z);

        // Set the player's position to the dash distance
        player.setPosition(player.getPosX() + dashVec.x * DASH_DISTANCE, player.getPosY() + dashVec.y * DASH_DISTANCE, player.getPosZ() + dashVec.z * DASH_DISTANCE);

        // Set the player's dash duration
        player.getDataManager().set(PlayerEntity.DASH_TIMER, DASH_DURATION);

        // Find all entities within a bounding box centered on the player and set them on fire
        AxisAlignedBB boundingBox = new AxisAlignedBB(player.getPosX() - 1, player.getPosY() - 1, player.getPosZ() - 1, player.getPosX() + 1, player.getPosY() + 1, player.getPosZ() + 1);
        for (Entity entity : player.world.getEntitiesWithinAABBExcludingEntity(player, boundingBox)) {
        if (entity instanceof LivingEntity) {
            ((LivingEntity) entity).setFire(5);
        }
        }
    }
    }
}
if (power4Pressed) {
    import net.minecraft.entity.player.PlayerEntity;
    import net.minecraft.particles.ParticleTypes;
    import net.minecraft.util.math.Vec3d;

    public class SpectatorAbility {

    // The duration of the spectator mode in ticks
    private static final int SPECTATOR_DURATION = 25 * 20;

    public static void spectator(PlayerEntity player) {
        // Set the player's game mode to spectator
        player.setGameType(GameType.SPECTATOR);

        // Set the player's spectator duration
        player.getDataManager().set(PlayerEntity.SPECTATOR_TIMER, SPECTATOR_DURATION);

        // Spawn red particles around the player
        for (int i = 0; i < 360; i += 15) {
        double x = Math.cos(Math.toRadians(i)) * 0.5;
        double z = Math.sin(Math.toRadians(i)) * 0.5;
        Vec3d particleVec = new Vec3d(x, 0, z);
        player.world.addParticle(ParticleTypes.REDSTONE, player.getPosX() + particleVec.x, player.getPosY() + 0.5, player.getPosZ() + particleVec.z, 0, 0, 0);
        }
    }
    }
}
if (power5Pressed) {
    // Power 5 is being pressed
}
if (power6Pressed) {
    // Power 6 is being pressed
}
if (power7Pressed) {
    // Power 7 is being pressed
}
if (power8Pressed) {
    // Power 8 is being pressed
}
if (power9Pressed) {
    // Power 9 is being pressed
}
if (power10Pressed) {
    // Power 10 is being pressed
}